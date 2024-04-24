package br.sc.senai.imob.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import br.sc.senai.imob.model.Imovel;
import br.sc.senai.imob.repository.ImovelRepository;
import br.sc.senai.imob.utils.exceptions.InternalServerError;
import br.sc.senai.imob.utils.exceptions.NotFoundException;
import br.sc.senai.imob.utils.exceptions.NullPointerException;

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
            .orElseThrow(() -> new NotFoundException());
    }

    public Imovel findById(Long codigo) {
        return repository.findById(codigo)
            .orElseThrow(() -> new NotFoundException());
    }

    public void save(Imovel imovel) {
       // validate(imovel);
       try {
            repository.save(imovel);
        } catch (Exception e) {
            throw new NullPointerException(e);
        }
    }

    public void delete(Long codigo) {
        if (!repository.existsById(codigo)) {
            throw new NotFoundException();
        }

        repository.deleteById(codigo);
    }

    private void validate(Imovel imovel){
        if(imovel.getDescricao() == null || imovel.getDescricao().isEmpty()){
            throw new NullPointerException("descricao");
        }

        if (imovel.getTipo() == null) {
            throw new NullPointerException("tipo");
        }

        if(imovel.getEndereco() == null || imovel.getEndereco().isEmpty()){
            throw new NullPointerException("endereco");
        }

        if(imovel.getBairro() == null || imovel.getBairro().isEmpty()){
            throw new NullPointerException("bairro");
        }

        if(imovel.getCidade() == null || imovel.getCidade().isEmpty()){
            throw new NullPointerException("cidade");
        }
        
        if(imovel.getValor() == null){
            throw new NullPointerException("valor");
        }

        if (imovel.getDataCadastro() == null) {
            throw new NullPointerException("dataCadastro");
        }
    }
}