public class Heroi {

    private String nome;
    private String superpoder;
    private Integer idade;
    private String cidade;

    public Heroi() {
    }

    public String getNome() {
        return nome;
    }

    public String getSuperpoder() {
        return superpoder;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
