import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de início do intervalo: ");
        int inicio = scanner.nextInt();

        System.out.print("Digite o número de fim do intervalo: ");
        int fim = scanner.nextInt();


        int soma = 0;
        System.out.println("Somando o número: "+ inicio + " até o número: "+ fim);
        for (int i = inicio; i <= fim; i++) {
            soma += i;
        }
        System.out.println("Total: "+ soma);
        scanner.close();
    }
}