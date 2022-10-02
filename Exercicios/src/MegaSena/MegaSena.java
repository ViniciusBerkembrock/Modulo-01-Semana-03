package MegaSena;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MegaSena {

    private List<Concurso> concursos;

    public MegaSena(List<Concurso> concursos) {
        this.concursos = concursos;
    }

    public void imprimir() {
        for (Concurso conc :
                concursos) {
            System.out.println(conc + "\n");
        }
    }

    public void imprimirOrdenado() {
        for (Concurso conc :
                concursos) {
            System.out.println(conc.formatarComNumerosSorteadosOrdenados());
        }
    }


    public void verificarSeTeveSorteio() {
        System.out.println("Informe a data (formato = dd/MM/yyyy): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataPesquisa = LocalDate.parse(input, formatador);
        int[] sorteadosNaData = null;
        for(Concurso concurso: concursos) {
            if (concurso.getData().equals(dataPesquisa)) {
                sorteadosNaData = concurso.getSorteados();
                break;
            }
        }
        if (sorteadosNaData == null) {
            System.out.println("Não houve sorteio neste dia");
        } else {
            System.out.println(Arrays.toString(sorteadosNaData) );
        }
    }

    public void verificarSeOsNumerosForamSorteados() {
        System.out.println("Digite as seis dezenas para pesquisar (separada por virgulas): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] split = input.split(",");
        int[] numeros = { Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()),
                Integer.parseInt(split[3].trim()), Integer.parseInt(split[4].trim()), Integer.parseInt(split[5].trim()) };
        List<Integer> listaNumeros = ConversorArrayParaLista.converterOrdenado(numeros);
        int[] dezenasSorteados = null;
        Integer nroDoConcurso = null;
        for(Concurso concurso: concursos) {
            List<Integer> nrosOrdenados = ConversorArrayParaLista.converterOrdenado(concurso.getSorteados());
            if (nrosOrdenados.toString().equals(listaNumeros.toString())) {
                dezenasSorteados = concurso.getSorteados();
                nroDoConcurso = concurso.getNumero();
                break;
            }
        }
        if (dezenasSorteados == null) {
            System.out.println("Numeros nunca sorteados");
        } else {
            System.out.println("Dezenas sorteadas no concurso: " + nroDoConcurso);
            System.out.println(Arrays.toString(dezenasSorteados) );
        }
    }

    public void imprimirNrosFrequentes() {
        Map<Integer, Integer> map = new HashMap<>();
        for (Concurso concurso: concursos) {
            int[] sorteados = concurso.getSorteados();
            for (int i = 0; i < sorteados.length; i++) {
                int nro = sorteados[i];
                int qtdAtual = map.getOrDefault(nro, 0);
                map.put(nro, qtdAtual + 1);
            }
        }
        int nroMaisFrequente = 1;
        int nroMenosFrequente = 1;
        int qtdMaisFrequente = 0;
        int qtdMenosFrequente = Integer.MAX_VALUE;

        for(Integer nro: map.keySet()) {
            Integer qtd = map.get(nro);
            if (qtd > qtdMaisFrequente) {
                qtdMaisFrequente = qtd;
                nroMaisFrequente = nro;
            }
            if (qtd < qtdMenosFrequente) {
                qtdMenosFrequente = qtd;
                nroMenosFrequente = nro;
            }
        }

        System.out.println("Número mais frequente = " + nroMaisFrequente);
        System.out.println("Número menos frequente = " + nroMenosFrequente);
    }

    public void imprimirNroMaisAtrasado() {
       Map<Integer, LocalDate> map = new HashMap<>();
        for (Concurso concurso: concursos) {
            int[] sorteados = concurso.getSorteados();
            for (int i = 0; i < sorteados.length; i++) {
                int nro = sorteados[i];
                if (map.containsKey(nro)) {
                    LocalDate dataUltSorteio = map.get(nro);
                    if (concurso.getData().isAfter(dataUltSorteio)) {
                        map.put(nro, concurso.getData());
                    }
                } else {
                    map.put(nro, concurso.getData());
                }
            }
        }

        LocalDate dataMaisAntiga = LocalDate.now();
        int nroMaisAtrasado = 0;
        for(Integer nro: map.keySet()) {
            LocalDate data = map.get(nro);
            if (data.isBefore(dataMaisAntiga)) {
                dataMaisAntiga = data;
                nroMaisAtrasado = nro;
            }
        }

        System.out.println("Mais atrasado: " + nroMaisAtrasado);   // 24
    }


}
