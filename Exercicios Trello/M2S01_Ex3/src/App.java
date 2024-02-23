public class App {
    
    public static void main(String[] args) throws Exception {
       int number1 = 10;
       double number2 = 20.5;

       double number1Converted = (double) number1;
       double result = number1Converted + number2;

       System.out.printf("Resultado: %.2f", result);
    }
}
