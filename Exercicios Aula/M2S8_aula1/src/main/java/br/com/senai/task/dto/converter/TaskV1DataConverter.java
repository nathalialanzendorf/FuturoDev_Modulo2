package br.com.senai.task.dto.converter;

import org.springframework.stereotype.Component;

import br.com.senai.task.dto.ContactV1Dto;
import br.com.senai.task.dto.TaskV1Dto;
import br.com.senai.task.model.Contact;
import br.com.senai.task.model.Task;

@Component
public class TaskV1DataConverter {

    public TaskV1Dto toDTO(Task entity) {
        TaskV1Dto dto = new TaskV1Dto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setStatus(entity.getStatus());
        dto.setPriority(entity.getPriority());
        
        if(entity.getAssignee() != null && entity.getAssignee().getId() != null){
            ContactV1Dto contactDTO = new ContactV1Dto();
            contactDTO.setId(entity.getAssignee().getId());
            dto.setAssignee(contactDTO);
        }
        return dto;
    }

    public Task toEntity(TaskV1Dto dto, Task entity) {
        entity.setDescription(dto.getDescription());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setStatus(dto.getStatus());
        entity.setPriority(dto.getPriority());

        if(dto.getAssignee() != null && dto.getAssignee().getId() != null){
            Contact contact = new Contact();
            contact.setId(dto.getAssignee().getId());
            entity.setAssignee(contact);
        }
        return entity;       
    }

    public Task toEntity(TaskV1Dto dto) {
        return toEntity(dto,  new Task());
    }
}