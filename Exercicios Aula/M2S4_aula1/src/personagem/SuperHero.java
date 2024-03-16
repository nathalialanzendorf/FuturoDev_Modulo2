package personagem;

public class SuperHero extends Personagem {

    public SuperHero(String nome, String codeNone, String superPoder, UniversoEnum universo) {
        super(nome, codeNone, superPoder, universo);
    }

    @Override
    public void atacar(){
        super.atacar();
        if(this.energia > 0.1){
            double energiaGasta = this.energia * 0.3;
            this.energia = Double.parseDouble(String.format("%.2f", (this.energia - energiaGasta)).replace(",", "."));
        } else {
            System.out.println("O personagem " + this.codeNone + " gastou todas as suas energias e não pode atacar agora" );
        }
    }
}
