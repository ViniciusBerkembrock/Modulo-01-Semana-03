package Contador;

public class Contador {

    //a) Crie uma classe 'Contador'.
    //b) Crie um método estático (static) 'contarPalavras' que recebe uma frase (String) como argumento.
    //c) Implemente o método imprimindo no console o número de palavras da frase recebida como parâmetro.
    //d) Crie um método main em outra classe para testar a implementação.
    //Dicas:
    //- Usar método split() da String ou classe StringTokenizer.

    private String frase;

    public static void contarPalavrasSplit(String frase) {
        String[] palavras = frase.split(" ");
        int quantidade = palavras.length;
        System.out.println("Quantidade de palavras: " + quantidade);
    }
}
