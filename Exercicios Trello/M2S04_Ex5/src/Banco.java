import java.util.List;
import java.util.ArrayList;

public class Banco {
    private List<ContaBancaria> contas = new ArrayList<>();

    public Banco() {
    }

    public Banco(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public void adicionarConta(ContaBancaria conta){
        contas.add(conta);
    }

    public void removerConta(ContaBancaria conta){
        contas.remove(conta);
    }

    public void mostrarContas(){
        for (ContaBancaria conta : contas) {
            Imprimivel.mostrarDados(conta);
        }
    }

    public List<ContaBancaria> getContas() {
        if(contas == null){
            contas = new ArrayList<>();
        }
        return contas;
    }

    public void setContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }
}
