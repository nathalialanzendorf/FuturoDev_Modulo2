package br.senai.devtubarao;

import static java.lang.StringTemplate.STR;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import br.senai.devtubarao.enums.Operacao;
import br.senai.devtubarao.model.Heroi;
import br.senai.devtubarao.utils.ConsoleLog;

public class HeroiCli {

  public static Integer menuSelecionado;
  public static Scanner scanner = new Scanner(System.in);
  public static List<Heroi> herois = new ArrayList<Heroi>();
  public static ConsoleLog console = new ConsoleLog();
  
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
    
    console.info(menuMensagem);
    menuSelecionado = scanner.nextInt();

    callMenuSelected();
  }

  private static void callMenuSelected() {
    try{
      switch (Operacao.values()[menuSelecionado]) {
        case ADICIONAR  -> addHeroi();
        case LISTAR     -> listarHerois();
        case SAIR       -> sair();
        default         -> error();
      }
    }catch (Exception e){
      error();
    }
  }

  private static void addHeroi() {
    try{
      console.info("-------- Adicionar Heroi --------\n");
      
      console.log("Digite o nome do heroi: ");
      String nome = scanner.nextLine();
      String nomeHeroi = scanner.nextLine();

      console.log("Digite o poder do heroi: ");
      String superpoder = scanner.nextLine();

      console.log("Digite a idade do heroi: ");
      Integer idade = scanner.nextInt();
      
      Heroi heroi = new Heroi();
      heroi.setNome(nomeHeroi);
      heroi.setSuperpoder(superpoder);
      heroi.setIdade(idade);

      save(heroi);



      exibirMenu();
    }catch (InputMismatchException e){
      error("Digite uma idade valida.");
    }catch (Exception e){
      error("Erro ao adicionar heroi. Tente novamente.");
    }
  }

  private static void listarHerois() {
    console.info("-------- Listar Herois --------");
    
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

        console.log(heroiMensagem);

      }
    } else {
      console.warning("Nenhum heroi cadastrado.");
    }
    
    exibirMenu();
  }

  private static void sair() {
    console.success("Programa encerrado.");
    System.exit(0);
    scanner.close();
  }

  private static void error(String mesage) {
    console.error(mesage);
    exibirMenu();
  }

  private static void error() {
    error("Digite uma opcao valida.");
  }

  private static void save(Heroi heroi) {
    if (herois.stream().anyMatch(h -> h.getNome().equals(heroi.getNome()))) {
      console.error("Heroi ja cadastrado.");
    } else {
      herois.add(heroi);
      console.success("Heroi salvo com sucesso!");
    }
  }
}