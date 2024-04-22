package br.com.senai.personagem.dto.converter;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import br.com.senai.personagem.dto.PersonagemV1Dto;
import br.com.senai.personagem.model.Personagem;

import br.com.senai.personagem.utils.exceptions.BusinessException;

@Component
public class PersonagemV1DataConverter {

    public PersonagemV1Dto toDTO(Personagem entity) {
        PersonagemV1Dto dto = new PersonagemV1Dto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setReferencia(entity.getReferencia());
        dto.setDataCadastro(entity.getDataCadastro());
        
        return dto;
    }

    public Personagem toEntity(PersonagemV1Dto dto, Personagem entity) {
        try{
            entity.setNome(dto.getNome());
            entity.setReferencia(dto.getReferencia());
            entity.setDataCadastro(dto.getDataCadastro());
           
            return entity;       
        } catch (Exception e) {
            throw new BusinessException("Ocorreu erro ao converter os campos.", e);
        }
    }

    public Personagem toEntity(PersonagemV1Dto dto) {
        return toEntity(dto,  new Personagem());
    }
}