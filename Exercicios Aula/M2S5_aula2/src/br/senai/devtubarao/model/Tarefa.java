package br.senai.devtubarao.model;

import java.time.LocalDateTime;

public class Tarefa {

    private Integer id;
    private String descricao;
    private boolean concluida;
    private LocalDateTime dataCriacao;

    public Tarefa() {
        this.id = (int) System.currentTimeMillis();
        this.dataCriacao = LocalDateTime.now();
    }

    public Tarefa(String descricao) {
        this.id = (int) System.currentTimeMillis();
        this.dataCriacao = LocalDateTime.now();
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
