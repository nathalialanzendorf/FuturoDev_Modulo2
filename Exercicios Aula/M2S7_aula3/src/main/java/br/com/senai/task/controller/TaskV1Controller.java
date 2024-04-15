package br.com.senai.task.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.task.dto.TaskDTO;
import br.com.senai.task.dto.converter.TaskConverter;
import br.com.senai.task.model.Task;
import br.com.senai.task.service.TaskService;

@RestController
@RequestMapping("v1/task")
public class TaskV1Controller {

    private TaskService service;
    private TaskConverter converter = new TaskConverter();

    @Autowired
    public TaskV1Controller(TaskService service, TaskConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> get() {
        List<Task> tasks = service.find();
        List<TaskDTO> dtos = converter.toDTO(tasks);

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDTO> getById(@PathVariable Long id) {
        Task task = service.findById(id);
        TaskDTO dto = converter.toDTO(task);

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody Task task) {
        service.save(task);
        TaskDTO dto = converter.toDTO(task);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody Task task) {
        service.update(id,task);
        TaskDTO dto = converter.toDTO(task);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }
}