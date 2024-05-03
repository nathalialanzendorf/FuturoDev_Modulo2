package br.sc.senai.imob.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import  br.sc.senai.imob.model.Users;

@Repository
public interface UsersRepository  extends JpaRepository<Users, UUID>{
    Users findByUsername(String username);

    @Query("SELECT users FROM Users users JOIN FETCH users.roles WHERE users.username = :username")
    Users findByUsernameFetchRoles(@Param("username") String username);

    boolean existsByUsername(String username);

    List<Users> findAllByOrderByUsernameAsc();
}