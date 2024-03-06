public class App {

    public static void main(String[] args) throws Exception {
      Heroi heroi = new Heroi();
      heroi.setNome("Superman");
      heroi.setSuperpoder("Voar");
      heroi.setNomeDaVidaReal("José Felipe Barreto Rodrigues");
      heroi.setUniverso("DC");

      heroi.atacar();
    }
}