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

import br.sc.senai.imob.dto.RolesV1Dto;
import br.sc.senai.imob.model.Roles;
import br.sc.senai.imob.service.RolesService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/roles")
public class RolesV1Controller {
    
    private RolesService service;
    private ModelMapper mapper;

    @Autowired
    public RolesV1Controller(RolesService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    
    @GetMapping
    public ResponseEntity<List<Roles>> findAll() {
        List<Roles> roles = service.findAll();
        return ResponseEntity.ok().body(roles);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Roles> findByCodigo(@PathVariable UUID id) {
        Roles role = service.findById(id);
        return ResponseEntity.ok().body(role);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid RolesV1Dto dto) {
        Roles role = mapper.map(dto, Roles.class);
        service.save(role);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Roles> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid RolesV1Dto dto) {
        Roles role = service.findById(id);
        mapper.map(role, RolesV1Dto.class);
        service.save(role);

        return ResponseEntity.ok().body(role);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }    
}
