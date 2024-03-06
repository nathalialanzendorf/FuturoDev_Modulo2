public class App {

    public static void main(String[] args) throws Exception {
        String nome = "José";
        float salario = 1000;
        float aumentar = 2000;

        Funcionario funcionario = new Funcionario(nome, salario);
        funcionario.aumentar(aumentar);

        System.out.printf("O empregado: %s de salário atual R$ %s receberá um aumento de R$ %s totalizando R$ %s: ", 
            funcionario.getNome(),
            salario,
            aumentar,
            funcionario.getSalario());
    }
}