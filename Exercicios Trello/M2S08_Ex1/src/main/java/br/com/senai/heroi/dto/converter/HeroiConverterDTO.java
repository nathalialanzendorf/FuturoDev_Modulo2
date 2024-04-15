package br.com.senai.heroi.dto.converter;

import org.springframework.stereotype.Component;

import br.com.senai.heroi.dto.HeroiDTO;
import br.com.senai.heroi.model.Heroi;

@Component
public class HeroiConverterDTO {

    public HeroiDTO toDTO(Heroi entity){
        HeroiDTO dto = new HeroiDTO();
        
        dto.setNome(entity.getNome());
        dto.setSuperpoder(entity.getSuperpoder());
        dto.setIdade(entity.getIdade());
        dto.setCidade(entity.getCidade());
        
        return dto;
    }

    public Heroi toEntity(Heroi entity, HeroiDTO dto){
        entity.setNome(dto.getNome());
        entity.setSuperpoder(dto.getSuperpoder());
        entity.setIdade(dto.getIdade());
        entity.setCidade(dto.getCidade());

        return entity;
    }

    public Heroi toEntity(HeroiDTO dto){
        Heroi entity = new Heroi();
        toEntity(entity, dto);
        return entity;
    }
}