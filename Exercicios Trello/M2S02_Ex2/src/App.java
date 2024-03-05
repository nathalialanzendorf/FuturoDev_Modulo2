import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        boolean isPrime = isPrimoValidate();
        System.out.printf("O número %s um número primo\n", isPrime ? "é" : "nao é");
    }

    public static boolean isPrimoValidate(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int number = scanner.nextInt();

        if(number <= 1){
            return false;
        }

        for(int i = 2; i < number; i++) {
            if(number % i  == 0) {
                return false;
            }
        }
        return true;
    }
}