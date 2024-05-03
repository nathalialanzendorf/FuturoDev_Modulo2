package br.sc.senai.imob.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senai.imob.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, UUID> {
}