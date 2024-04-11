package br.com.senai.heroi.service;

import java.util.List;

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

    public List<Heroi> find() {
        List<Heroi> herois = repository.find();

        if (herois.isEmpty()) {
            throw new NotFoundException("Nenhum herói encontrado.");
        }
        return herois;
    }

    public void save(Heroi heroi) {
        validate(heroi);        
        repository.save(heroi);
    }

    public List<Heroi> find(String name) {
        List<Heroi> heroisFiltred = repository.find(name);

        if (heroisFiltred.isEmpty()) {
            throw new NotFoundException("Nenhum herói encontrado.");
        }

        return heroisFiltred;
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
