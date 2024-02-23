import java.util.Scanner;
        
public class App {
    
    public static void main(String[] args) throws Exception {
       double number1;
       double number2;
       
       Scanner scanner = new Scanner(System.in);
       
       System.out.print("Digite o 1º numero: ");
       number1 = scanner.nextDouble();
       
       System.out.print("Digite o 2ª numero: ");
       number2 = scanner.nextDouble();
       
       System.out.printf("Resultado Soma: %.2f\n", number1 + number2);
       System.out.printf("Resultado Subtracao: %.2f\n", number1 - number2);
       System.out.printf("Resultado Divisao: %.2f\n", number1 / number2);
       System.out.printf("Resultado Multiplicacao: %.2f\n", number1 * number2);
       System.out.printf("Resultado Resto: %.2f\n", number1 % number2);
    }
}
