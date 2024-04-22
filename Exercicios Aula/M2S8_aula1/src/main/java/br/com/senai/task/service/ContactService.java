package br.com.senai.task.service;

import java.util.List;
import java.util.Optional;

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

    public List<Contact> findAll() {
        List<Contact> contacts = repository.findAllByOrderByIdAsc();

        return Optional.ofNullable(contacts)
            .filter(t -> !t.isEmpty())
            .orElseThrow(() -> new NotFoundException("Nenhum contact encontrado."));
    }

    public Contact findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Nenhum contact encontrado."));
    }

    public void save(Contact contact) {
        validate(contact);
        repository.save(contact);
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