package br.sc.senai.imob.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.sc.senai.imob.model.Users;
import br.sc.senai.imob.repository.UsersRepository;
import br.sc.senai.imob.utils.exceptions.ConflictException;
import br.sc.senai.imob.utils.exceptions.NotFoundException;

@Service
public class UsersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersService.class);

    private UsersRepository repository;

    @Autowired
    public UsersService(UsersRepository repository){
        this.repository = repository;
    }

    public List<Users> findAll() {
        LOGGER.info("Buscando todos os users.");
        List<Users> users = repository.findAllByOrderByUsernameAsc();

        return Optional.ofNullable(users)
            .orElseThrow(NotFoundException::new);
    }

    public Users findById(UUID id) {
        LOGGER.info("Buscando o user. Id: {}.", id);
        return repository.findById(id)
            .orElseThrow(NotFoundException::new);
    }

    public void save(Users user){
        LOGGER.info("Salvando o user. Id: {}.", user.getId());

        boolean exists = repository.existsByUsername(user.getUsername());

        if(exists){
            throw new ConflictException("user");
        }
        
        user.setPassword(encodePassword(user.getPassword()));
        repository.save(user);
    }

    public void delete(UUID id) {
        LOGGER.info("Excluindo o user . Id: {}.", id);

        if (!repository.existsById(id)) {
            throw new NotFoundException();
        }

        repository.deleteById(id);
    }

    public Users findByUsernameFetchRole(String username){
        return repository.findByUsernameFetchRoles(username);
    }
    
    public boolean checkPassword(String password, String encodedPassword){
        LOGGER.debug("Validando a senha.");
        return passwordEncoder().matches(password, encodedPassword);
    }

    private String encodePassword(String password){
        LOGGER.debug("Criptografando a senha.");
        return passwordEncoder().encode(password);
    }

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}