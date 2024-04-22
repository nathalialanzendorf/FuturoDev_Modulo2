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

import br.com.senai.task.dto.TaskV1Dto;
import br.com.senai.task.dto.converter.TaskV1DataConverter;
import br.com.senai.task.model.Task;
import br.com.senai.task.service.TaskService;

@RestController
@RequestMapping("v1/task")
public class TaskV1Controller {

    private TaskService service;
    private TaskV1DataConverter converter = new TaskV1DataConverter();

    @Autowired
    public TaskV1Controller(TaskService service, TaskV1DataConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = service.findAll();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = service.findById(id);

        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody TaskV1Dto dto) {
        Task task = converter.toEntity(dto);
        service.save(task);

        return ResponseEntity.ok().body(task);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody TaskV1Dto dto) {
        Task task = service.findById(id);
        converter.toEntity(dto, task);
        service.save(task);

        return ResponseEntity.ok().body(task);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        
        return ResponseEntity.noContent().build();
    }
}