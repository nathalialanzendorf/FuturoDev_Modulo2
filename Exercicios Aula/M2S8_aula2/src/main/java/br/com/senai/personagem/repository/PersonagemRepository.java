package br.com.senai.personagem.repository;

import org.springframework.stereotype.Repository;

import br.com.senai.personagem.model.Personagem;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    
    public List<Personagem> findAllByOrderByIdAsc();
}