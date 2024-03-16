import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        double values = 0;
        int i = 0;
        int limit = 5;
        
        do {
            System.out.print("Digite o valor da nota aluno: ");
            double value = scanner.nextDouble();
            values += value;
            i++;
        } while (i < limit);
        
        double result = values / limit;

        System.out.printf("Média: %.2f\n", result);
       
        /*
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o valor da nota do aluno: ");
            double nota = scanner.nextDouble();
            values += value;
        }
        */
    }
}