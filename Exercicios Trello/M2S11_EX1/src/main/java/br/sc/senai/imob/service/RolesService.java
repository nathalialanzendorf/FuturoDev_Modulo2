package br.sc.senai.imob.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senai.imob.model.Roles;
import br.sc.senai.imob.repository.RolesRepository;
import br.sc.senai.imob.utils.exceptions.ConflictException;
import br.sc.senai.imob.utils.exceptions.NotFoundException;

@Service
public class RolesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RolesService.class);

    private RolesRepository repository;

    @Autowired
    public RolesService(RolesRepository repository){
        this.repository = repository;
    }
    
    public List<Roles> findAll() {
        LOGGER.info("Buscando todos as roles.");
        List<Roles> roles = repository.findAllByOrderByNameAsc();

        return Optional.ofNullable(roles)
            .orElseThrow(NotFoundException::new);
    }

    public Roles findById(UUID id) {
        LOGGER.info("Buscando a role. Id: {}.", id);
        return repository.findById(id)
            .orElseThrow(NotFoundException::new);
    }

    public void save(Roles role) {
        LOGGER.info("Salvando a role. Id: {}.", role.getId());

        boolean exists = repository.existsByName(role.getName());

        if(exists){
            throw new ConflictException("role");
        }

        repository.save(role);
    }

    public void delete(UUID id) {
        LOGGER.info("Excluindo a role . Id: {}.", id);

        if (!repository.existsById(id)) {
            throw new NotFoundException();
        }

        repository.deleteById(id);
    }
}