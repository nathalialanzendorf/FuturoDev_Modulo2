package br.com.senai.heroi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HeroiDTO {

    private String nome;
    private String superpoder;
    private Integer idade;
    private String cidade;
}
