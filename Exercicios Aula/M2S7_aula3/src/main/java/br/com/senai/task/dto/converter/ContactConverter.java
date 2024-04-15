package br.com.senai.task.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.senai.task.dto.ContactDTO;
import br.com.senai.task.model.Contact;

@Component
public class ContactConverter {
    
    public ContactDTO toDTO(Contact entity) {
        ContactDTO dto = new ContactDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Contact toEntity(ContactDTO dto) {
        Contact entity = new Contact();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public List<ContactDTO> toDTO(List<Contact> entities) {
        List<ContactDTO> dtos = new ArrayList<>();
        for (Contact entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    public List<Contact> toEntity(List<ContactDTO> dtos) {
        List<Contact> entities = new ArrayList<>();
        for (ContactDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}
