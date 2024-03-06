import java.util.Arrays;
import java.util.Scanner;

public class App {
    static int size;
    static int numbers[];

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de núemros que deseja informar: ");
        size = scanner.nextInt();
        numbers = new int[size];
    
        for (int i = 0; i < size; i++) {
           
            System.out.print("Digite o " + (i+1) + "º número: ");
            int number = scanner.nextInt();
            numbers[i] = number;
        }
        System.out.println("O Array ficou: " +  Arrays.toString(numbers));
        System.out.println("O Array invertido ficou: " + reverseArray());

    }

    public static String reverseArray() {
        int reversedNumbers[] = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            reversedNumbers[i] = numbers[numbers.length - 1 - i];
        }
        return  Arrays.toString(reversedNumbers);
    }
}