package br.senai.devtubarao;

import br.senai.devtubarao.model.ContaCorrente;
import br.senai.devtubarao.model.ContaPoupanca;

public class App {

    public static void main(String[] args) throws Exception {
      
      ContaPoupanca poupanca = new ContaPoupanca();
      poupanca.setNumeroDaConta(123);
      poupanca.setAgecia(456);
      poupanca.setNomeDoTitular("Fulano");
      poupanca.setSaldo(1000.0);
      poupanca.setTaxaDeJuros(0.1);

      poupanca.mostrarDados();
      
      System.out.println("###### Ações ######");
      poupanca.depositar(500);
      poupanca.sacar(250);
      poupanca.sacar(500);
      poupanca.sacar(1500);

      ContaCorrente corrente = new ContaCorrente();
      corrente.setNumeroDaConta(789);
      corrente.setAgecia(000);
      corrente.setNomeDoTitular("Sicrano");
      corrente.setSaldo(100.0);
      corrente.setTaxaDeOperacao(0.75);

      corrente.mostrarDados();
      
      System.out.println("###### Ações ######");
      corrente.depositar(50);
      corrente.sacar(25);
      corrente.sacar(50);
      corrente.sacar(150);
    }
}