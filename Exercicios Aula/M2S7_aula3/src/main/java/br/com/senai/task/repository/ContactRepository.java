package br.com.senai.task.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import br.com.senai.task.model.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Component
@RepositoryRestResource(collectionResourceRel = "cliente", path = "clientes")
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

    //@Query("SELECT c.nome FROM Cliente c where c.id = :id")
    Contact findById(@Param("id") Long id);
    

    List<Contact> findByame(@Param("name") String name);
}