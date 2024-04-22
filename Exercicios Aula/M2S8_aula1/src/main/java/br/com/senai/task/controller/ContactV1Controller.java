package br.com.senai.task.controller;

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

import br.com.senai.task.dto.ContactV1Dto;
import br.com.senai.task.dto.converter.ContactV1DataConverter;
import br.com.senai.task.model.Contact;
import br.com.senai.task.service.ContactService;

@RestController
@RequestMapping("v1/contact")
public class ContactV1Controller {
    
    private ContactService service;
    private ContactV1DataConverter converter = new ContactV1DataConverter();

    @Autowired
    public ContactV1Controller(ContactService service, ContactV1DataConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        List<Contact> contacts = service.findAll();

        return ResponseEntity.ok().body(contacts);
    }

    @GetMapping("{id}")
    public ResponseEntity<Contact> findById(@PathVariable Long id) {
        Contact contact = service.findById(id);

        return ResponseEntity.ok().body(contact);
    }

    @PostMapping
    public ResponseEntity<Contact> save(@RequestBody ContactV1Dto dto) {
        Contact contact = converter.toEntity(dto);
        service.save(contact);

        return ResponseEntity.ok().body(contact);
    }

    @PutMapping("{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody ContactV1Dto dto) {
        Contact contact = service.findById(id);
        converter.toEntity(dto, contact);
        service.save(contact);

        return ResponseEntity.ok().body(contact);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}