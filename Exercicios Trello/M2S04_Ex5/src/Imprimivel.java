public interface Imprimivel {

    public static void mostrarDados(ContaBancaria conta){
        System.out.println("##########################################");
        System.out.println("Número da conta: " + conta.getNumeroDaConta());
        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("Nome do titular: " + conta.getNomeDoTitular());
        System.out.println("Saldo: " + conta.getSaldo());
        System.err.println("Tipo de conta: " + conta.getClass().getSimpleName());
    }
}