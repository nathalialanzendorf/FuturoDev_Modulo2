package br.senai.devtubarao;

import br.senai.devtubarao.model.ContaCorrente;
import br.senai.devtubarao.model.ContaPoupanca;
import br.senai.devtubarao.model.Banco;

public class App {

    public static void main(String[] args) throws Exception {
      Banco banco = new Banco();
      
      ContaPoupanca poupanca = new ContaPoupanca();
      poupanca.setNumeroDaConta(123);
      poupanca.setAgecia(456);
      poupanca.setNomeDoTitular("Fulano");
      poupanca.setSaldo(1000.0);
      poupanca.setTaxaDeJuros(0.1);

      banco.adicionarConta(poupanca);

      ContaCorrente corrente = new ContaCorrente();
      corrente.setNumeroDaConta(789);
      corrente.setAgecia(000);
      corrente.setNomeDoTitular("Sicrano");
      corrente.setSaldo(100.0);
      corrente.setTaxaDeOperacao(0.75);

      banco.adicionarConta(corrente);

      banco.mostrarContas();
    }
}