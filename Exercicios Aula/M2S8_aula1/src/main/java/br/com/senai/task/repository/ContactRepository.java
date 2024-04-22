package br.com.senai.task.repository;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.task.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    public List<Contact> findAllByOrderByIdAsc();

}