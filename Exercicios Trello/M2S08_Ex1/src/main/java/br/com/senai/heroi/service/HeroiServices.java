package br.com.senai.heroi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.heroi.model.Heroi;
import br.com.senai.heroi.repository.HeroiRepository;
import br.com.senai.heroi.utils.exceptions.BusinessException;
import br.com.senai.heroi.utils.exceptions.NotFoundException;

@Component
public class HeroiServices {

    private HeroiRepository repository;

    @Autowired
    public HeroiServices(HeroiRepository repository) {
        this.repository = repository;
    }

    public List<Heroi> findAll() {
        List<Heroi> herois = repository.findAll();

        if (herois.isEmpty()) {
            throw new NotFoundException("Nenhum herói encontrado.");
        }
        return herois;
    }

    public Heroi save(Heroi heroi) {
        validate(heroi);        
        return repository.save(heroi);
    }

    public Heroi findById(Long id) {
        Optional<Heroi> heroi = repository.findById(id);

        if (!heroi.isPresent()) {
            throw new NotFoundException("Nenhum herói encontrado.");
        }

        return heroi.get();
    }

    public void deleteById(Long id) {
        Optional<Heroi> heroi = repository.findById(id);

        if (!heroi.isPresent()) {
            throw new NotFoundException("Nenhum herói encontrado.");
        }

        repository.deleteById(id);
    }

    private void validate(Heroi heroi){
        if(heroi.getNome() == null || heroi.getNome().isEmpty()){
            throw new BusinessException("Nome deve ser preenchido.");
        }

        if (heroi.getSuperpoder() == null || heroi.getSuperpoder().isEmpty()) {
            throw new BusinessException("Superpoder deve ser preenchido.");
        }

        if (heroi.getIdade() == null || heroi.getIdade() < 0) {
            throw new BusinessException("Idade deve ser preenchida.");
        }

        if (heroi.getCidade() == null || heroi.getCidade().isEmpty()) {
            throw new BusinessException("Cidade deve ser preenchida.");
        }
    }
}