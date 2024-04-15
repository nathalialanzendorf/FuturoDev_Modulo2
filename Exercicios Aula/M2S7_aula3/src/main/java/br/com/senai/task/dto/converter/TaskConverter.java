package br.com.senai.task.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.senai.task.dto.ContactDTO;
import br.com.senai.task.dto.TaskDTO;
import br.com.senai.task.model.Contact;
import br.com.senai.task.model.Task;

@Component
public class TaskConverter {

    public TaskDTO toDTO(Task entity) {
        TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setStatus(entity.getStatus());
        dto.setPriority(entity.getPriority());

        if(entity.getAssignee() != null){
            ContactDTO contactDTO = new ContactConverter().toDTO(entity.getAssignee());
            dto.setAssignee(contactDTO);
        }

        return dto;
    }

    public Task toEntity(TaskDTO dto) {
        Task entity = new Task();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setStatus(dto.getStatus());
        entity.setPriority(dto.getPriority());

        if(dto.getAssignee() != null){
            Contact contact = new ContactConverter().toEntity(dto.getAssignee());
            entity.setAssignee(contact);
        }

        return entity;
    }

    public List<TaskDTO> toDTO(List<Task> entities) {
        List<TaskDTO> dtos = new ArrayList<>();
        for (Task entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    public List<Task> toEntity(List<TaskDTO> dtos) {
        List<Task> entities = new ArrayList<>();
        for (TaskDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}