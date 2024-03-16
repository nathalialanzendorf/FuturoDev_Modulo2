import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) throws Exception {
        double valor1;
        double valor2;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor da primeira nota: ");
        valor1 = scanner.nextDouble();

        System.out.print("Digite o valor da segunda nota: ");
        valor2 = scanner.nextDouble();
        double result = (valor1 + valor2) / 2;

        System.out.printf("Média: %.2f\n", result);

        if (result >= 7) {
            System.out.println("Aprovado");
        } else if (result < 7 && result >= 4) {
            System.out.println("Recuperacao");
        } else {
            System.out.println("Reprovado");
        }
    }
}