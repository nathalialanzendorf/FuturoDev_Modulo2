public class Funcionario {
    
    String nome;
    float salario;

    public Funcionario(String nome) {
        this.nome = nome;
    }  

    public Funcionario(String nome, float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void aumentar(float aumento) {
        salario += aumento;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
