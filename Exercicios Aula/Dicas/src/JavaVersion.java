import java.util.Scanner;

public class JavaVersion {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int idade;
        float peso;
        char sexo;

        System.out.println("Digite a sua idade: ");
        idade = scanner.nextInt();
        
        System.out.println("Digite o seu peso: ");
        peso = scanner.nextFloat();

        System.out.println("Digite o seu sexo: ");
        sexo = scanner.next().charAt(0);

        System.out.println(
            " Sua idade é: " + idade +
            " | Seu peso é: " + peso +
            " | Seu sexo é: " + sexo
        );

        if (idade >= 18){
            System.out.println("Você é maior de idade");
        } else {
            System.out.println("Você é menor de idade");
        }

        switch(sexo){
            case 'M':
                System.out.println("Você é do sexo masculino");
                break;
            case 'F':
                System.out.println("Você é do sexo feminino");
                break;
            default:
                System.out.println("Você é do sexo indefinido");
                break;
        }

        peso = 0;
        while (peso < 5) {
            System.out.println("Peso muito baixo");
            peso++;
        }

        peso = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Peso muito alto");
        }


        peso = 0;
        do {
            System.out.println("Peso médio");
            peso++;
        } while (peso < 5);

        scanner.close();
    }
}