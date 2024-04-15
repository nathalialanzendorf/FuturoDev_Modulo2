package br.com.senai.task.model;

import br.com.senai.task.enums.Priority;
import br.com.senai.task.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne(targetEntity=Contact.class, fetch=FetchType.EAGER)
    @JoinColumn(name="id")
    private Contact assignee;
    
}