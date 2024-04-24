package br.sc.senai.imob.dto.converter;

import org.springframework.stereotype.Component;

import br.sc.senai.imob.dto.ImovelV1Dto;
import br.sc.senai.imob.model.Imovel;

@Component
public class ImovelV1DataConverter {
    public ImovelV1Dto convertToDto(Imovel entity) {
        ImovelV1Dto dto = new ImovelV1Dto();

        dto.setCodigo(entity.getCodigo());
        dto.setDescricao(entity.getDescricao());
        dto.setTipo(entity.getTipo());
        dto.setEndereco(entity.getEndereco());
        dto.setBairro(entity.getBairro());
        dto.setCidade(entity.getCidade());
        dto.setValor(entity.getValor());
        dto.setDataCadastro(entity.getDataCadastro());

        return dto;
    }

    public Imovel convertToEntity(ImovelV1Dto dto, Imovel entity) {

        entity.setDescricao(dto.getDescricao());
        entity.setTipo(dto.getTipo());
        entity.setEndereco(dto.getEndereco());
        entity.setBairro(dto.getBairro());
        entity.setCidade(dto.getCidade());
        entity.setValor(dto.getValor());
        entity.setDataCadastro(dto.getDataCadastro());

        return entity;
    }

    public Imovel convertToEntity(ImovelV1Dto dto){
        return convertToEntity(dto, new Imovel());
    }
}
