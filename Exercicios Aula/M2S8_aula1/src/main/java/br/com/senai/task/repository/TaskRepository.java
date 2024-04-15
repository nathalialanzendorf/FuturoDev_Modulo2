package br.com.senai.task.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.senai.task.model.Task;

@Component
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
   // tasks = Arrays.asList(new Task(1L, "Tarefa 1", LocalDate.now(), LocalDate.now(), Status.PENDING, Priority.LOW, new Contact(1L, "João")));

    public List<Task> find() {
        return tasks;
    }

    public void save(Task task) {
        tasks.add(task);
    }

    public Task findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
    }

    public void delete(Task taskDeleted) {
        tasks.removeIf(task -> task.getId().equals(taskDeleted.getId()));
    }
    
}