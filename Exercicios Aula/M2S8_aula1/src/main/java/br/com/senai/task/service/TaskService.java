package br.com.senai.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.task.repository.TaskRepository;
import br.com.senai.task.utils.exceptions.BusinessException;
import br.com.senai.task.utils.exceptions.NotFoundException;
import br.com.senai.task.model.Contact;
import br.com.senai.task.model.Task;

@Component
public class TaskService {

    private TaskRepository repository;
    private ContactService contactService;

    @Autowired
    public TaskService(TaskRepository repository, ContactService contactService) {
        this.repository = repository;
        this.contactService = contactService;
    }

    public List<Task> findAll() {
        List<Task> tasks = repository.findAllByOrderByIdAsc();

        return Optional.ofNullable(tasks)
            .filter(t -> !t.isEmpty())
            .orElseThrow(() -> new NotFoundException("Nenhuma task encontrada."));
    }

    public Task findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Nenhuma task encontrada."));
    }

    public void save(Task task) {
        validate(task);
        
        Contact contact = contactService.findById(task.getAssignee().getId());
        task.setAssignee(contact);

        repository.save(task);
    }

    public void delete(Long id) {
        Task task = findById(id);
        repository.delete(task);
    }

    private void validate(Task task){
        if(task.getDescription() == null || task.getDescription().isEmpty()){
            throw new BusinessException("Description deve ser preenchido.");
        }

        if (task.getStartDate() == null) {
            throw new BusinessException("StartDate deve ser preenchido.");
        }

        if (task.getEndDate() == null) {
            throw new BusinessException("EndDate deve ser preenchido.");
        }

        if (task.getStatus() == null) {
            throw new BusinessException("Status deve ser preenchido.");
        }

        if (task.getPriority() == null) {
            throw new BusinessException("Priority deve ser preenchido.");
        }

        if (task.getAssignee() == null || task.getAssignee().getId() == null){
            throw new BusinessException("Assignee deve ser preenchido.");
        }
    }
}