package br.com.senai.heroi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.heroi.model.Heroi;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long>{

}
