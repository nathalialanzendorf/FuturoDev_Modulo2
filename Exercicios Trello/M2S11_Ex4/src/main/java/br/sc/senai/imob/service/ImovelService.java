package br.sc.senai.imob.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.sc.senai.imob.model.Imovel;
import br.sc.senai.imob.repository.ImovelRepository;
import br.sc.senai.imob.utils.exceptions.NotFoundException;

@Component
public class ImovelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImovelService.class);

    private ImovelRepository repository;

    @Autowired
    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }
    
    public List<Imovel> findAll() {
        LOGGER.info("Buscando todos os imóveis.");
        List<Imovel> imoveis = repository.findAll();

        return Optional.ofNullable(imoveis)
            .orElseThrow(NotFoundException::new);
    }

    public Imovel findById(UUID id) {
        LOGGER.info("Buscando o imóvel. Id: {}.", id);
        return repository.findById(id)
            .orElseThrow(NotFoundException::new);
    }

    public void save(Imovel imovel) {
        LOGGER.info("Salvando o imóvel. Id: {}.", imovel.getId());
        repository.save(imovel);
    }

    public void delete(UUID id) {
        LOGGER.info("Excluindo o imóvel. Id: {}.", id);
        
        if (!repository.existsById(id)) {
            throw new NotFoundException();
        }

        repository.deleteById(id);
    }
}