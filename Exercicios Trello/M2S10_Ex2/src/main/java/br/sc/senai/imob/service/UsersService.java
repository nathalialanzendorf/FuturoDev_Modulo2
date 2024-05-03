package br.sc.senai.imob.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    private UsersRepository repository;

    @Autowired
    public UsersService(UsersRepository repository){
        this.repository = repository;
    }

    public List<Users> findAll() {
        List<Users> users = repository.findAllByOrderByUsernameAsc();

        return Optional.ofNullable(users)
            .orElseThrow(NotFoundException::new);
    }

    public Users findById(UUID id) {
        return repository.findById(id)
            .orElseThrow(NotFoundException::new);
    }

    public void save(Users user){
        boolean exists = repository.existsByUsername(user.getUsername());

        if(exists){
            throw new ConflictException("user");
        }
        
        user.setPassword(encodePassword(user.getPassword()));
        repository.save(user);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException();
        }

        repository.deleteById(id);
    }

    public Users findByUsernameFetchRole(String username){
        return repository.findByUsernameFetchRoles(username);
    }
    
    public boolean checkPassword(String password, String encodedPassword){
        return passwordEncoder().matches(password, encodedPassword);
    }

    private String encodePassword(String password){
        return passwordEncoder().encode(password);
    }

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}