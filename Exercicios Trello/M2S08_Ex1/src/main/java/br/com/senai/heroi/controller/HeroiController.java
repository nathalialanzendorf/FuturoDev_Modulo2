package br.com.senai.heroi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.heroi.dto.HeroiDTO;
import br.com.senai.heroi.dto.converter.HeroiConverterDTO;
import br.com.senai.heroi.model.Heroi;
import br.com.senai.heroi.service.HeroiServices;

@RestController
@RequestMapping("heroi")
public class HeroiController {

    private HeroiServices service;
    private HeroiConverterDTO converter;
    
    @Autowired
    public HeroiController(HeroiServices service, HeroiConverterDTO converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<Heroi>> findAll() {
        List<Heroi> herois = service.findAll();
        return ResponseEntity.ok().body(herois);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Heroi> findById(@PathVariable Long id) {
        Heroi heroi = service.findById(id);
        return ResponseEntity.ok().body(heroi);
    }

    @PostMapping
    public ResponseEntity<Heroi> save(@RequestBody HeroiDTO dto) {
        Heroi entity = converter.toEntity(dto);
        service.save(entity);

        return ResponseEntity.ok().body(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Heroi> update(@PathVariable Long id, @RequestBody HeroiDTO dto) {
        Heroi entity = service.findById(id);
        converter.toEntity(entity, dto);
        service.save(entity);

        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Heroi> delete(@PathVariable Long id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}