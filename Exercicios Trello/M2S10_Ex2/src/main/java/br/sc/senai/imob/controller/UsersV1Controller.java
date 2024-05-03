package br.sc.senai.imob.controller;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senai.imob.dto.UsersV1Dto;
import br.sc.senai.imob.model.Users;
import br.sc.senai.imob.service.UsersService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/users")
public class UsersV1Controller {

    private UsersService service;
    private ModelMapper mapper;

    @Autowired
    public UsersV1Controller(UsersService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    
    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        List<Users> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Users> findByCodigo(@PathVariable UUID id) {
        Users user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid UsersV1Dto dto) {
        Users user = mapper.map(dto, Users.class);
        service.save(user);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Users> update(@PathVariable UUID id, @RequestBody @Valid UsersV1Dto dto) {
        Users user = service.findById(id);
        mapper.map(user, UsersV1Dto.class);
        service.save(user);

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }    
}