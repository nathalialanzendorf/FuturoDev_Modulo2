package br.sc.senai.imob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.sc.senai.imob.model.Imovel;
import br.sc.senai.imob.repository.ImovelRepository;
import br.sc.senai.imob.utils.exceptions.NotFoundException;

@Component
public class ImovelService {

    private ImovelRepository repository;

    @Autowired
    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }
    
    public List<Imovel> findAll() {
        List<Imovel> imoveis = repository.findAllByOrderByCodigoAsc();

        return Optional.ofNullable(imoveis)
            .orElseThrow(NotFoundException::new);
    }

    public Imovel findById(Long codigo) {
        return repository.findById(codigo)
            .orElseThrow(NotFoundException::new);
    }

    public void save(Imovel imovel) {
        repository.save(imovel);
    }

    public void delete(Long codigo) {
        if (!repository.existsById(codigo)) {
            throw new NotFoundException();
        }

        repository.deleteById(codigo);
    }
}