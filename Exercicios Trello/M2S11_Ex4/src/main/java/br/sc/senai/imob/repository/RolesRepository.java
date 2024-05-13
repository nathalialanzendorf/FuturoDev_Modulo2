package br.sc.senai.imob.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senai.imob.model.Roles;

@Repository
public interface RolesRepository  extends JpaRepository<Roles, UUID>{

    List<Roles> findAllByOrderByNameAsc();

    boolean existsByName(String name);

}