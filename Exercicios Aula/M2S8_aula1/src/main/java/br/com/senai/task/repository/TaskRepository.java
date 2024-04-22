package br.com.senai.task.repository;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.task.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    public List<Task> findAllByOrderByIdAsc();
}