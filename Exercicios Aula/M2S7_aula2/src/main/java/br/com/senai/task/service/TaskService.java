package br.com.senai.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.task.repository.TaskRepository;
import br.com.senai.task.utils.exceptions.BusinessException;
import br.com.senai.task.utils.exceptions.NotFoundException;
import br.com.senai.task.model.Task;

@Component
public class TaskService {

    private TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> find() {
        List<Task> tasks = repository.find();

        if (tasks.isEmpty()) {
            throw new NotFoundException("Nenhuma task encontrada.");
        }
        return tasks;
    }

    public void save(Task task) {
        validate(task);        
        repository.save(task);
    }

    public void update(Long id, Task task) {
        validate(task);
        Task taskUpdated = findById(id);

        if(taskUpdated != null){
            repository.delete(task);
            repository.save(task);
        }else{
            throw new NotFoundException("Nenhuma task encontrada.");
        }
    }

    public Task findById(Long id) {
        Task task = repository.findById(id);

        if (task == null) {
            throw new NotFoundException("Nenhuma task encontrada.");
        }

        return task;
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
        if (task.getAssignee() == null) {
            throw new BusinessException("Assignee deve ser preenchido.");
        }
    }
}