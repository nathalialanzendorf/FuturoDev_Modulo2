package br.com.senai.heroi.model;

public class Heroi {

    private String nome;
    private String superpoder;
    private Integer idade;
    private String cidade;

    public Heroi() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSuperpoder() {
        return superpoder;
    }
    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
