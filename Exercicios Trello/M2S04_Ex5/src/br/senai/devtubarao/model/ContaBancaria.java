package br.senai.devtubarao.model;

import br.senai.devtubarao.interfaces.Imprimivel;

public class ContaBancaria implements Imprimivel {
    
    private int numeroDaConta;
    private int agencia;
    private String nomeDoTitular;
    private double saldo;

    public ContaBancaria() {
    }

    public ContaBancaria(int numeroDaConta, int agencia, String nomeDoTitular, double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.nomeDoTitular = nomeDoTitular;
        this.saldo = saldo;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgecia(int agencia) {
        this.agencia = agencia;
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo){ 
        this.saldo = saldo;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar(double valor){
        if(this.saldo >= valor){
            System.out.println("Saque realizado com sucesso. Saldo Retante: " + this.saldo);
            this.saldo -= valor;
        } else {
            System.out.println("Não foi possivel realizar o saque. Saldo insuficiente: " + this.saldo);
        }
    }

    @Override
    public void mostrarDados() {
        System.out.println("################################################");
        System.out.println("Numero da Conta: " + this.numeroDaConta);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Nome do Titular: " + this.nomeDoTitular);
        System.out.println("Saldo: " + this.saldo);
    }
}