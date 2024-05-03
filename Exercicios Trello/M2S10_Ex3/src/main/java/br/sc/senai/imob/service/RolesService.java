package br.sc.senai.imob.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senai.imob.model.Roles;
import br.sc.senai.imob.repository.RolesRepository;
import br.sc.senai.imob.utils.exceptions.NotFoundException;

@Service
public class RolesService {

    private RolesRepository repository;

    @Autowired
    public RolesService(RolesRepository repository){
        this.repository = repository;
    }
    
    public List<Roles> findAll() {
        List<Roles> imoveis = repository.findAllByOrderByNameAsc();

        return Optional.ofNullable(imoveis)
            .orElseThrow(NotFoundException::new);
    }

    public Roles findById(UUID id) {
        return repository.findById(id)
            .orElseThrow(NotFoundException::new);
    }

    public void save(Roles imovel) {
        repository.save(imovel);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException();
        }

        repository.deleteById(id);
    }
}