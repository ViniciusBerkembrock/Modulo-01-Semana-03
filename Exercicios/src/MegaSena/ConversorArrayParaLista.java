package MegaSena;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConversorArrayParaLista {

    public static List<Integer> converter(int[] arr) {
        List<Integer> lista = new ArrayList<>();
        for (int numero:
             arr) {
            lista.add(numero);
        }
        return lista;
    }

    public static List<Integer> converterOrdenado(int[] arr) {
        List<Integer> lista = converter(arr);
        Collections.sort(lista);
        return lista;
    }


}
