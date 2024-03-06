public class Empregado {
    
    String nomeCompleto;
    String CPF;
    double salario; 

    public void promover(float percentual) {
        salario += salario * percentual / 100;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public double getSalario() {
        return salario;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
