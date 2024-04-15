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

import br.com.senai.task.dto.ContactDTO;
import br.com.senai.task.dto.converter.ContactConverter;
import br.com.senai.task.model.Contact;
import br.com.senai.task.service.ContactService;

@RestController
@RequestMapping("v1/contact")
public class ContactV1Controller {
    
    private ContactService service;
    private ContactConverter converter = new ContactConverter();

    @Autowired
    public ContactV1Controller(ContactService service, ContactConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> get() {
        List<Contact> contacts = service.find();
        List<ContactDTO> dtos = converter.toDTO(contacts);

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactDTO> getById(@PathVariable Long id) {
        Contact contact = service.findById(id);
        ContactDTO dto = converter.toDTO(contact);

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ContactDTO> save(@RequestBody Contact contact) {
        service.save(contact);
        ContactDTO dto = converter.toDTO(contact);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContactDTO> update(@PathVariable Long id, @RequestBody Contact contact) {
        service.update(id, contact);

        ContactDTO dto = converter.toDTO(contact);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}