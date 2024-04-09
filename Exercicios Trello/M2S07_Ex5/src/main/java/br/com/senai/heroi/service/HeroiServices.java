package br.com.senai.heroi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.heroi.model.Heroi;
import br.com.senai.heroi.repository.HeroiRepository;

@Component
public class HeroiServices {

    @Autowired
    private HeroiRepository repository;

    public List<Heroi> find() {
        return repository.find();
    }

    public void save(Heroi heroi) {
        validate(heroi);        
        repository.save(heroi);
    }

    public List<Heroi> find(String name) {
        return repository.find(name);
    }

    private void validate(Heroi heroi){
        if (heroi.getNome() == null || heroi.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (heroi.getSuperpoder() == null || heroi.getSuperpoder().isEmpty()) {
            throw new IllegalArgumentException("Superpoder inválido.");
        }
        if (heroi.getIdade() == null || heroi.getIdade() < 0) {
            throw new IllegalArgumentException("Idade inválida.");
        }
        if (heroi.getCidade() == null || heroi.getCidade().isEmpty()) {
            throw new IllegalArgumentException("Cidade inválida.");
        }
    }
}
