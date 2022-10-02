package Contador;

import java.util.StringTokenizer;

public class ContadorConstructor {

    private String frase;

    public ContadorConstructor(String frase) {
        this.frase = frase;
    }

    public int contarPalavras() {
        StringTokenizer contador = new StringTokenizer(this.frase);
        return contador.countTokens();
    }

    public int contarPalavras(String filtro) {
        StringTokenizer contador = new StringTokenizer(this.frase, filtro);
        return contador.countTokens();
    }
}
