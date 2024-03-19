package br.senai.devtubarao.utils;

public class ConsoleLog {

    public static void error(String mesage) {
        System.out.println(ConsoleColors.RED + mesage + ConsoleColors.RESET);
    }

    public static void success(String mesage) {
        System.out.println(ConsoleColors.GREEN + mesage + ConsoleColors.RESET);
    }

    public static void warning(String mesage) {
        System.out.println(ConsoleColors.YELLOW + mesage + ConsoleColors.RESET);
    }

    public static void info(String mesage) {
        System.out.println(ConsoleColors.BLUE + mesage + ConsoleColors.RESET);
    }

    public static void log(String mesage) {
        System.out.println(mesage);
    }

    public static void log(String mesage, String color) {
        System.out.println(color + mesage + ConsoleColors.RESET);
    }
}