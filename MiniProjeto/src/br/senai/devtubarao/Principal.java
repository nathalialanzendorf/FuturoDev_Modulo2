package br.senai.devtubarao;

public class Principal {

  public static HeroiCli heroiCli = new HeroiCli();
  
  public static void main(String[] args) {
    do {
      heroiCli.executar();
    } while (heroiCli.menuSelecionado != 3);
  }
}