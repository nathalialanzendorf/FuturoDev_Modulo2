package br.senai.devtubarao;

import br.senai.devtubarao.model.ContaBancaria;

public class App {

    public static void main(String[] args) throws Exception {
      ContaBancaria conta = new ContaBancaria();
      conta.setNumeroDaConta(123);
      conta.setAgecia(456);
      conta.setNomeDoTitular("Fulano");
      conta.setSaldo(1000.0);
      
      conta.depositar(500);
      conta.sacar(250);
      conta.sacar(500);
      conta.sacar(1500);

    }

}