import personagem.Personagem;
import personagem.UniversoEnum;

public class App {
    public static void main(String[] args) {

        Personagem personagem = new Personagem();
        personagem.setNome("Homem de Ferro");
        personagem.setCodeNone("001");  
        personagem.setSuperPoder("Armadura");
        personagem.setUniverso(UniversoEnum.MARVEL);

        personagem.atacar();
        personagem.atacar("002", "Raio laser");
        
        Personagem atacado = new Personagem("Super homem", "003", "Raio laser", UniversoEnum.DC);
        personagem.atacar(atacado);
    }
}