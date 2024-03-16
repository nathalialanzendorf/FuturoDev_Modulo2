package br.senai.devtubarao.model;

public class ContaPoupanca extends ContaBancaria{
    
    private double taxaDeJuros;

    public ContaPoupanca() {
    }

    public ContaPoupanca(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public void adicionarJuros(double taxaDeJuros){
        double juros = getSaldo() * taxaDeJuros;
        depositar(juros);
        System.out.println("Juros adicionados: " + juros);
    }
}