package br.com.senai.task.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.senai.task.model.Contact;

@Component
public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>(); 
   // contacts =  Arrays.asList(new Contact(1L, "João"));

    public List<Contact> find() {
        return contacts;
    }

    public Contact save(Contact contact) {
        contacts.add(contact);
        return contact;
    }

    public Contact findById(Long id) {
        return contacts.stream().filter(contact -> contact.getId().equals(id)).findFirst().orElse(null);
    }

    public void delete(Contact contactDeleted) {
        contacts.removeIf(contact -> contact.getId().equals(contactDeleted.getId()));
    }
    
}