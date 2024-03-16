package br.senai.devtubarao.model;

public class ContaCorrente extends ContaBancaria{
    
    private double taxaDeOperacao;

    public ContaCorrente() {
    }

    public ContaCorrente(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public void sacar(double valor){
        if(getSaldo() >= valor + taxaDeOperacao){
            System.out.println("Saque realizado com sucesso. Saldo Retante: " + getSaldo());
            setSaldo( getSaldo() - (valor + taxaDeOperacao));
        } else {
            System.out.println("Não foi possivel realizar o saque. Saldo insuficiente: " + getSaldo());
        }
    }
}