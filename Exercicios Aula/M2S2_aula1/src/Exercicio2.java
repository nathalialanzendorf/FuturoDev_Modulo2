import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) throws Exception {
        int resultado = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int numero = scanner.nextInt();
        scanner.close();

        System.out.printf("Tabua do %d\n", numero);

        int i = 0;

        while (i++ < 10) {
            resultado = numero * i;
            System.out.printf("%d x %d = %d \n",numero, i, resultado);
        }
    }
}