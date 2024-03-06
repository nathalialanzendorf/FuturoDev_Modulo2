public class App {

    public static void main(String[] args) throws Exception {
      Contador contador = new Contador();

      String frase = "A casa é bonita.";
      contador.setFrase(frase);
      contador.contarPalavras();

      System.out.printf("A frase '%s' possui %s palavras.",
        frase,
        contador.contarPalavras());
    }
}