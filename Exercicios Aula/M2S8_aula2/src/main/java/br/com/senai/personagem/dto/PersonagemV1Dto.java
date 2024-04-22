package br.com.senai.personagem.dto;

import java.time.LocalDate;

import br.com.senai.personagem.enums.Referencia;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonagemV1Dto {
    private Long id;
    private String nome;
    private Referencia referencia;
    private LocalDate dataCadastro;
}
