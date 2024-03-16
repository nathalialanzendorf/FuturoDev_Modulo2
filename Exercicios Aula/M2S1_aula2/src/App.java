import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Conta myAccount = new Conta();

        Conta myConta2 = Conta.builder()
            .agencia(123)
            .numero(01)
            .saldo(1000)
            .build();

        myAccount.setAgencia(123);
        myAccount.setNumero(01);
        myAccount.setSaldo(1000);

        Conta destinyAccount = new Conta();
        destinyAccount.setAgencia(123);
        destinyAccount.setNumero(02);
        destinyAccount.setSaldo(1500);

        System.out.println(myAccount);

        double valor;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor para transferência: ");
        valor = scanner.nextDouble();

        myAccount.transferir(valor, destinyAccount);

        System.out.printf(
            "Seu saldo atual: %.2f\n"+
            "Saldo atual destino: %.2f\n",
            myAccount.saldo,  
            destinyAccount.saldo);
    }
}