package br.com.senai.task.dto;

import java.time.LocalDate;

import br.com.senai.task.enums.Priority;
import br.com.senai.task.enums.Status;

public class TaskDTO {
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private Priority priority;
    private ContactDTO assignee;
    
    public TaskDTO() {
    }

    public TaskDTO(Long id, String description, LocalDate startDate, LocalDate endDate, Status status, Priority priority,
            ContactDTO assignee) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public ContactDTO getAssignee() {
        return assignee;
    }

    public void setAssignee(ContactDTO assignee) {
        this.assignee = assignee;
    }
}
