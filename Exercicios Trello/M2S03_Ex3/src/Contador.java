import java.util.StringTokenizer;

public class Contador {
    
    private String frase;

    public int contarPalavras(){
        int total = 0;
        
        for (int i = 0; i < frase.length(); i++) {
            StringTokenizer tokenizer = new StringTokenizer(frase);
            total = tokenizer.countTokens();
        }
        return total;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
}
