package MegaSena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Principal {
    public static void main(String[] args) throws IOException {
        List<String> lista = lerDoArquivo();
        List<Concurso> concursos = carregarConcurso(lista);

        MegaSena megasena = new MegaSena(concursos);

        //megasena.imprimir();
        //megasena.imprimirOrdenado();
        //megasena.imprimirConcursosEmOrdemDeNumero();
        //megasena.verificarSeTeveSorteio();
        megasena.verificarSeOsNumerosForamSorteados();
        //megasena.imprimirNrosFrequentes();
        megasena.imprimirNroMaisAtrasado();




    }

    private static List<String> lerDoArquivo() throws IOException {
        Path arquivo = Paths.get("Exercicios", "src", "MegaSena", "megasena.txt");
        List<String> lista = Files.readAllLines(arquivo);
        return lista;
    }

    private static List<Concurso> carregarConcurso(List<String> lista) {
        List<Concurso> concursos = new CopyOnWriteArrayList<>();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (String linha:
             lista) {
            String[] partes = linha.split(",");
            Integer numero = Integer.valueOf(partes[0]);
            String dataString = partes[1];
            LocalDate data = LocalDate.parse(dataString, formatador);
            int[] sorteados = new int[6];
            for (int i = 2; i <= 7; i++) {
                sorteados[i-2] = Integer.parseInt(partes[i]);
            }

            Concurso concurso = new Concurso(numero, data, sorteados);
            concursos.add(concurso);
        }
        return  concursos;
    }
}

