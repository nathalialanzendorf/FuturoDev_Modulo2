package personagem;

public class Personagem {

    private String nome;
    protected String codeNone;
    private String superPoder;
    protected double energia = 100;
    private UniversoEnum universo;

    public Personagem(String nome, String codeNone, String superPoder, UniversoEnum universo) {
        this.nome = nome;
        this.codeNone = codeNone;
        this.superPoder = superPoder;
        this.universo = universo;
    }

    public Personagem() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodeNone() {
        return codeNone;
    }

    public void setCodeNone(String codeNone) {
        this.codeNone = codeNone;
    }
    
    public String getSuperPoder() {
        return superPoder;
    }

    public void setSuperPoder(String superPoder) {
        this.superPoder = superPoder;
    }

    public UniversoEnum getUniverso() {
        return universo;
    }

    public void setUniverso(UniversoEnum universo) {
        this.universo = universo;
    }

    public double getEnergia() {
        return energia;
    }
    
    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public void atacar(){
        System.out.println(this.codeNone +" está atacando com o poder " + this.superPoder);
    }

    public void atacar(String codeNone, String superPoder){
        System.out.println(codeNone +" está atacando com o poder " + superPoder);
    }

    public void atacar(Personagem atacado){
        System.out.println(this.nome +" está atacando " + atacado.getCodeNone() + " com o poder " + this.superPoder);
    }
}
