public class TipoDeDados {

    public static void main(String[] args) throws Exception {
        String texto = "App";
        
        char caracter_texto = 'A';  // 0 até 65535
        char caracter_numerico = 2; // 0 até 65535 16 bits

        Float real_float = 0.0f; // 16 bits antes da virgula e 16 após
        Float real_float_ = 25F;
        Double real_double = 0.0; // 4.9E-324 até 1.7976931348623157E308

        Short inteiro_short = 0; //- 32768 até 32767 (16bits)
        Byte inteiro_byte = 0; // -128 até 127
        Integer inteiro_int = 0; //- 2.147.483.648 até 2.147.483.647
        Long inteiro_long = 0L; // -9.223.372.036.854.775.808 até 9.223.372.036.854.775.807

        System.out.println("Inteiro int " + inteiro_int);
        System.out.println("Inteiro short " + inteiro_short);
        System.out.println("Inteiro long " + inteiro_long);
        System.out.println("Inteiro byte " + inteiro_byte);

        System.out.println("Real float " + real_float);
        System.out.println("Real double " + real_double);

        System.out.println("Caracter Numérico " + caracter_numerico);
        System.out.println("Caracter Texto " + caracter_texto);
        
        System.out.println("Texto " + texto);

        char caracter_a = 97;
        char caracter_b = 98;
        char letra = 99;

        System.out.println(caracter_a + " " + caracter_b);
        letra = (char) (letra + 1); 
    }
}