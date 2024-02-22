import java.util.Scanner;

public class M2S01Aula1_Extra {

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
        
        /*
        * Pattern Matching for switch
        */ 
        //Java 8
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

        //Java 14
        switch(sexo){
            case 'M' -> System.out.println("Você é do sexo masculino");
            case 'F' -> System.out.println("Você é do sexo feminino");
            default -> System.out.println("Você é do sexo indefinido");
        }

        var obj = "M";
        //Java 17
        switch(obj){
            case String string -> System.out.println("Você é do sexo masculino");
            case 'F' -> System.out.println("Você é do sexo feminino");
            default -> System.out.println("Você é do sexo indefinido");
        }

        /*
        * String Templates
        */ 

        //Java 8
        System.out.println(
            " Sua idade é: " + idade +
            " | Seu peso é: " + peso +
            " | Seu sexo é: " + sexo
        );

        //Java 17
        System.out.printf(
            " Sua idade é: %s, seu peso: %s, seu sexo: %s%n", idade ,peso ,sexo
        );

        //Java 21
        System.out.println(STR." Sua idade é: \{idade} | Seu peso é: \{peso} | Seu sexo é \{sexo}");        

        scanner.close();
    }
}