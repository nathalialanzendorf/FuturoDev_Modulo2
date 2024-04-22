package br.sc.senai.imob.dto.converter;

import org.springframework.stereotype.Component;

import br.sc.senai.imob.dto.ImovelV1Dto;
import br.sc.senai.imob.model.Imovel;

@Component
public class ImovelV1DtoConverter {
    public ImovelV1Dto convertToDto(Imovel entity) {
        return ImovelV1Dto.builder()
            .codigo(entity.getCodigo())
            .descricao(entity.getDescricao())
            .tipo(entity.getTipo())
            .endereco(entity.getEndereco())
            .bairro(entity.getBairro())
            .cidade(entity.getCidade())
            .valor(entity.getValor())
            .dataCadastro(entity.getDataCadastro())
        .build();
    }

    public Imovel convertToEntity(ImovelV1Dto dto, Imovel entity) {
        return Imovel.builder()
            .codigo(dto.getCodigo())
            .descricao(dto.getDescricao())
            .tipo(dto.getTipo())
            .endereco(dto.getEndereco())
            .bairro(dto.getBairro())
            .cidade(dto.getCidade())
            .valor(dto.getValor())
            .dataCadastro(dto.getDataCadastro())
            .build();
    }

    public Imovel convertToEntity(ImovelV1Dto dto){
        return convertToEntity(dto, Imovel.builder().build());
    }
}
