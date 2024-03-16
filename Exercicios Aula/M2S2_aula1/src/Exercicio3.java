import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) throws Exception {
        int resultado = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int numero = scanner.nextInt();
        scanner.close();

        System.out.printf("Tabua do %d\n", numero);

       for(int i = 1; i <= 10; i++) {
            resultado = numero * i;
            System.out.printf("%d x %d = %d \n",numero, i, resultado);
        }
    }
}