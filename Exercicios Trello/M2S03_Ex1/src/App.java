public class App {

    public static void main(String[] args) throws Exception {
        double salario = 1000;
        float percentual = 50;

        Empregado empregado = new Empregado();
        empregado.setNomeCompleto("José");
        empregado.setCPF("123.456.789-00");
        empregado.setSalario(salario);

        empregado.promover(percentual);

        System.out.printf("O empregado: %s de salário atual R$ %s receberá um aumento de %s%% totalizando R$ %s: ", 
            empregado.getNomeCompleto(),
            salario,
            percentual,
            empregado.getSalario());
    }
}