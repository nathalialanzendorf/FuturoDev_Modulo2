public class Conta {

   int agencia;
   int numero;
   double saldo;

   public void depositar(double valor) {
       saldo = saldo + valor;
   }

   public void sacar(double valor) {
       saldo = saldo - valor;
   }

   public void transferir(double valor, Conta destino) {
       saldo = saldo - valor;
       destino.saldo = destino.saldo + valor;
   }

   public int getAgencia() {
       return agencia;
   }

   public void setAgencia(int agencia) {
       this.agencia = agencia;
   }

   public int getNumero() {
       return numero;
   }

   public void setNumero(int numero) {
       this.numero = numero;
   }

   public double getSaldo() {
       return saldo;
   }

   public void setSaldo(double saldo) {
       this.saldo = saldo;
   }
   
}