package br.senai.devtubarao.view;

import static java.lang.StringTemplate.STR;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.senai.devtubarao.enums.Operacao;
import br.senai.devtubarao.model.Tarefa;

public class TarefaCli {

    private static int menuSelecionado;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Tarefa> tarefas = new ArrayList();
    
    public static void executar() {
            do {
                menuInicial();
                menuSelecionado();
            } while (menuSelecionado != Operacao.SAIR.getValor());
        }
    
        System.out.println(menuMsg);
        menuSelecionado = scanner.nextInt();
    }

    private static void menuInicial(){
        String menuMsg = STR.
        """
        -------- MENU --------
        1 - Adicionar
        2 - Listar
        3 - Sair
        Escolha uma opcao:
        """ ;
    
        System.out.println(menuMsg);
        menuSelecionado = scanner.nextInt();
    }

    private static void menuSelecionado(){
        switch (menuSelecionado) {
            case Operacao.ADICIONAR.getValor()  -> add();
            case Operacao.LIST.getValor()       -> listar();
            case Operacao.SAIR.getValor()       -> sair();
            default         -> error();
        }
    }

    public static void add(){
        String descricao;
        System.out.println("-------- Adicionar --------\n");
      
        System.out.println("Digite a descricao da tarefa: ");
        scanner.nextLine();
        descricao= scanner.nextLine();

        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
        
        System.out.println("Tarefa adicionada com sucesso.");
    }

    public static void listar(){
        System.out.println("-------- Listar --------\n");

        for (Tarefa tarefa : tarefas) {
            String tarefaMsg = STR.
                """
                    ----------------
                    Id: \{ tarefa.getId() }
                    Descricao: \{ tarefa.getDescricao() }
                    Status: \{ tarefa.isConcluida() }
                    Data de Criacao: \{ tarefa.getDataCriacao() }
                    ----------------
                """ ;
            System.out.println(tarefaMsg);

        }
    }

    public static void sair(){
        System.out.println("Programa encerrado.");
        System.exit(0);
        scanner.close();
    }

    public static void error(){
        System.out.println("Digite uma opcao valida.");
    }
}