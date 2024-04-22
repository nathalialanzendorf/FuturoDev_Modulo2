package br.com.senai.personagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.personagem.model.Personagem;
import br.com.senai.personagem.repository.PersonagemRepository;
import br.com.senai.personagem.utils.exceptions.NotFoundException;
import br.com.senai.personagem.utils.exceptions.NullPointerException;

@Component
public class PersonagemService {

    private PersonagemRepository repository;

    @Autowired
    public PersonagemService(PersonagemRepository repository) {
        this.repository = repository;
    }

    public List<Personagem> findAll() {
        List<Personagem> personagens = repository.findAllByOrderByIdAsc();

        return Optional.ofNullable(personagens)
            .orElseThrow(() -> new NotFoundException());
    }

    public Personagem findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException());
            
    }

    public void save(Personagem personagem) {
        validate(personagem);
        repository.save(personagem);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException();
        }

        repository.deleteById(id);
    }

    private void validate(Personagem personagem){
        if(personagem.getNome() == null || personagem.getNome().isEmpty()){
            throw new NullPointerException("nome");
        }

        if (personagem.getReferencia() == null) {
            throw new NullPointerException("referencia");
        }

        if (personagem.getDataCadastro() == null) {
            throw new NullPointerException("dataCadastro");
        }
    }
}