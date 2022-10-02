package Funcionario;

public class Principal {

    public static void main(String[] args) {

        Funcionário vinicius = new Funcionário("vinicius Berkembrok",
                5_000f);
        vinicius.setCpf(11255893966L);

        System.out.println(vinicius.getNome());
        System.out.println(vinicius.getCpf());
        System.out.println(vinicius.getSalario());

        vinicius.promover(12);

        System.out.println(vinicius.getSalario());

        vinicius.aumentarSalario(2_000, 100);

        System.out.println(vinicius.getSalario());

    }
}
