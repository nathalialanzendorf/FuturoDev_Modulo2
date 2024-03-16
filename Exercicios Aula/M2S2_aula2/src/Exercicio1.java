
public class Exercicio1 {
   

        String [][] predio = new String[2][5];
        
        predio[0][0] = "101";
        predio[0][1] = "102";
        predio[0][2] = "103";
        predio[0][3] = "104";
        predio[0][4] = "105";

        predio[1][0] = "201";
        predio[1][1] = "202";
        predio[1][2] = "203";
        predio[1][3] = "204";
        predio[1][4] = "205";

        System.out.println("Total de Andares: "+ predio.length);

        for (int linha = 0; linha < predio.length; linha++) {
            System.out.println("Andar: "+ (linha + 1));
            System.out.println("Total de apartamentos: "+ predio[linha].length);

            for (int coluna = 0; coluna < predio[linha].length; coluna++) {
                System.out.println("Apartamentos: "+ predio[linha][coluna]);
            }
        }   
    }
}