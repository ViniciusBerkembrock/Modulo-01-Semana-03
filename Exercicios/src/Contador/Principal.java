package Contador;
import  java.util.StringTokenizer;

public class Principal {
    public static void main(String[] args) {

        Contador.contarPalavrasSplit("Vinícius Berkembrock Marcon");

        String fraseFiltro = "-";
        String fraseContar = "Hello World - Viva o Presente - - - -";

        StringTokenizer stringTokenizer01 = new StringTokenizer(fraseContar);
        StringTokenizer stringTokenizer02 = new StringTokenizer(fraseContar, fraseFiltro );

        int quantidadeSemFiltro = stringTokenizer01.countTokens();
        int quantidadeComFiltro = stringTokenizer02.countTokens();

        System.out.println("Quantidade de palavras não filtradas: " + quantidadeSemFiltro);
        System.out.println("Quantidade de palavras filtradas: " + quantidadeComFiltro);

        ContadorConstructor contadorConstructor = new ContadorConstructor(fraseContar);
        int numeroPalavrasNaoFiltradas = contadorConstructor.contarPalavras();
        System.out.println("Quantidade de palavras não filtradas:" + numeroPalavrasNaoFiltradas);
        int numerosPalavrasFiltradas = contadorConstructor.contarPalavras(" - ");
        System.out.println("Quantidade de palavras filtrasdas: " + numerosPalavrasFiltradas);

    }
}
