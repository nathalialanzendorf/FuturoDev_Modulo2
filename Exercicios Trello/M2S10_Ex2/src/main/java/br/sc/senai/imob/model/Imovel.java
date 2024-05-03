package br.sc.senai.imob.model;

import java.time.LocalDate;
import java.util.UUID;

import br.sc.senai.imob.enums.TipoImovel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "imovel")
public class Imovel {   

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty()
    @NotNull
    @Size(min = 5, max = 255)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoImovel tipo;

    @NotEmpty()
    @NotNull
    @Size(min = 5, max = 255)
    private String endereco;

    @NotEmpty()
    @NotNull
    @Size(min = 5, max = 255)
    private String bairro;

    @NotEmpty()
    @NotNull
    @Size(min = 5, max = 255)
    private String cidade;

    @NotNull()
    @Positive()
    private Double valor;

    @NotNull
    @Past
    private LocalDate dataCadastro;

}