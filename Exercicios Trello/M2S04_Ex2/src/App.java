public class App {

    public static void main(String[] args) throws Exception {
      ContaBancaria conta = new ContaBancaria(123, 456, "Fulano", 1000);
      
      
      conta.depositar(500);
      conta.sacar(250);
      conta.sacar(500);
      conta.sacar(1500);

    }
    
}