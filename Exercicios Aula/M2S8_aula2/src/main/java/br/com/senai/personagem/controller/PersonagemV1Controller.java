package br.com.senai.personagem.controller;

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

import br.com.senai.personagem.dto.PersonagemV1Dto;
import br.com.senai.personagem.dto.converter.PersonagemV1DataConverter;
import br.com.senai.personagem.model.Personagem;
import br.com.senai.personagem.service.PersonagemService;

@RestController
@RequestMapping("v1/personagem")
public class PersonagemV1Controller {

    private PersonagemService service;
    private PersonagemV1DataConverter converter;

    @Autowired
    public PersonagemV1Controller(PersonagemService service, PersonagemV1DataConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<Personagem>> findAll() {
        List<Personagem> personagens = service.findAll();
        return ResponseEntity.ok().body(personagens);
    }

    @GetMapping("{id}")
    public ResponseEntity<Personagem> findById(@PathVariable Long id) {
        Personagem personagem = service.findById(id);

        return ResponseEntity.ok().body(personagem);
    }

    @PostMapping
    public ResponseEntity<Personagem> save(@RequestBody PersonagemV1Dto dto) {
        Personagem personagem = converter.toEntity(dto);
        service.save(personagem);

        return ResponseEntity.ok().body(personagem);
    }

    @PutMapping("{id}")
    public ResponseEntity<Personagem> update(@PathVariable Long id, @RequestBody PersonagemV1Dto dto) {
        Personagem personagem = service.findById(id);
        converter.toEntity(dto, personagem);
        service.save(personagem);

        return ResponseEntity.ok().body(personagem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }
}