package br.senai.devtubarao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.senai.devtubarao.enums.Operacao;
import br.senai.devtubarao.model.Heroi;

public class DevHeroiAplicacao {

  public static Integer menuSelecionado;
  public static Scanner scanner = new Scanner(System.in);
  public static List<Heroi> herois = new ArrayList<Heroi>();
  
  public static void executar() {
    exibirMenu();
  }

  private static void exibirMenu(){
    String menuMensagem = STR.
    """
    -------- MENU --------
    1 - Adicionar
    2 - Listar
    3 - Sair
    Escolha uma opcao:
    """ ;
    
    System.out.println(menuMensagem);
    menuSelecionado = scanner.nextInt();

    callMenuSelected();
  }

  private static void callMenuSelected() {
    switch (Operacao.values()[menuSelecionado]) {
      case ADICIONAR  -> addHeroi();
      case LISTAR     -> listarHerois();
      case SAIR       -> sair();
      default         -> error();
    }
  }

  private static void addHeroi() {
    System.out.println("-------- Adicionar Heroi --------\n");
    
    System.out.println("Digite o nome do heroi: ");
    String nome = scanner.nextLine();
    String nomeHeroi = scanner.nextLine();


    System.out.println("Digite o poder do heroi: ");
    String superpoder = scanner.nextLine();

    System.out.println("Digite a idade do heroi: ");
    Integer idade = scanner.nextInt();
    
    Heroi heroi = new Heroi();
    heroi.setNome(nomeHeroi);
    heroi.setSuperpoder(superpoder);
    heroi.setIdade(idade);

    herois.add(heroi);

    exibirMenu();
  }

  private static void listarHerois() {
    System.out.println("-------- Listar Herois --------");
    
    if (herois.size() > 0) {
      for (Heroi heroi : herois) {

        String heroiMensagem = STR.
        """
          ----------------
          Nome: \{ heroi.getNome() }
          Superpoder: \{ heroi.getSuperpoder() }
          Idade: \{ heroi.getIdade() }
          ----------------
        """ ;

        System.out.println(heroiMensagem);

      }
    } else {
      System.out.println("Nenhum heroi cadastrado.");
    }
    
    exibirMenu();
  }

  private static void sair() {
    System.out.println("Programa encerrado.");
    System.exit(0);
    scanner.close();
  }

  private static void error() {
    System.out.println("Opcao invalida.");
    exibirMenu();
  }
}