package br.sc.senai.imob.dto;

import java.time.LocalDate;

import br.sc.senai.imob.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImovelV1Dto {

    private Long codigo;
    private String descricao;
    private Tipo tipo;
    private String endereco;
    private String bairro;
    private String cidade;
    private Double valor;
    private LocalDate dataCadastro;
}