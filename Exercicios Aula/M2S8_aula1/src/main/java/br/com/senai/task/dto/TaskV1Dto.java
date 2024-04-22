package br.com.senai.task.dto;

import java.time.LocalDate;

import br.com.senai.task.enums.Priority;
import br.com.senai.task.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskV1Dto {
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private Priority priority;
    private ContactV1Dto assignee;
}
