package br.sc.senai.imob.dto;

import java.time.LocalDate;
import java.util.UUID;

import br.sc.senai.imob.enums.TipoImovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImovelV1Dto {

    private UUID id;
    private String descricao;
    private TipoImovel tipo;
    private String endereco;
    private String bairro;
    private String cidade;
    private Double valor;
    private LocalDate dataCadastro;
}