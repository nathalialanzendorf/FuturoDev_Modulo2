import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        double number = scanner.nextDouble();
        double result = 0;

        for (int i = 1; i <= 10; i++) {
            result = number * i;
            System.out.println(number + " x " + i + " = " + result);
        }
    }
}