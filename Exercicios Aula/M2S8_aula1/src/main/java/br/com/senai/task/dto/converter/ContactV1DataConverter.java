package br.com.senai.task.dto.converter;

import org.springframework.stereotype.Component;

import br.com.senai.task.dto.ContactV1Dto;
import br.com.senai.task.model.Contact;

@Component
public class ContactV1DataConverter {
    
    public ContactV1Dto toDTO(Contact entity) {
        ContactV1Dto dto = new ContactV1Dto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Contact toEntity(ContactV1Dto dto, Contact entity) {
        entity.setName(dto.getName());
        return entity;
    }

    public Contact toEntity(ContactV1Dto dto) {
        return toEntity(dto, new Contact());
    }
}
