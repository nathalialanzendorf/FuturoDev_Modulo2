import java.util.Scanner;

public class App {
    static final double PI = 3.14159;
    //Math.PI
    
    public static void main(String[] args) throws Exception {
       double radius;

       Scanner scanner = new Scanner(System.in);
       
       System.out.print("Digite o raio de um círculo: ");
       radius = scanner.nextDouble();

       double area = PI * radius *  radius;
       
       double perimeter = 2 * PI * radius;

        System.out.printf(
            "Resultado Area: %.2f\n"+
            "Resultado Perimetro: %.2f\n",
            area,  
            perimeter);
    }
}
