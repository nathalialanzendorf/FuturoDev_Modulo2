package br.com.senai.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.task.repository.ContactRepository;
import br.com.senai.task.utils.exceptions.BusinessException;
import br.com.senai.task.utils.exceptions.NotFoundException;
import br.com.senai.task.model.Contact;

@Component
public class ContactService {

    private ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public List<Contact> find() {
        List<Contact> contacts = repository.find();

        if (contacts.isEmpty()) {
            throw new NotFoundException("Nenhum contact encontrado.");
        }
        return contacts;
    }

    public void save(Contact contact) {
        validate(contact);
        repository.save(contact);
    }

    public void update(Long id, Contact contact) {
        validate(contact);
        Contact contactUpdated = findById(id);

        if(contactUpdated != null){
            repository.delete(contact);
            repository.save(contact);
        }else{
            throw new NotFoundException("Nenhum contact encontrado.");
        }
    }

    public Contact findById(Long id) {
        Contact contact = repository.findById(id);

        if (contact == null) {
            throw new NotFoundException("Nenhum contact encontrado.");
        }

        return contact;
    }

    public void delete(Long id) {
        Contact contact = findById(id);
        repository.delete(contact);
    }

    private void validate(Contact contact){
        if(contact.getName() == null || contact.getName().isEmpty()){
            throw new BusinessException("Name deve ser preenchido.");
        }
    }
}