package Funcionario;

public class Funcionário {

    //Crie uma classe 'Funcionario' para representar um empregado de
    // uma empresa, contendo os atributos cpf, nome completo e salário.
    //Implemente também um método 'promover' que recebe como parâmetro
    // um percentual (float), devendo o salário ser aumentado pelo
    // percentual indicado no argumento do método.
    //Crie e utilize um objeto desta classe para testar a implementação.

    //a) Crie uma classe 'Funcionario' com os atributos 'nome' (String) e 'salário' (Float).
    //b) Implemente um construtor que receba um argumento de nome e inicialize o atributo de 'nome' com este valor.
    //c) Implemente outro construtor que receba como argumentos nome e salário e inicialize os respectivos atributos.
    //d) Implemente um método público 'aumentar' que recebe como parâmetro um valor (Float). Na implementação, some este valor ao 'salário'.
    //e) Implemente outro método público 'aumentar' que recebe como parâmetros um valor (Float) e uma commissão (Float). Na implementação,
    //some ambos os valores ao 'salário'.


    public Funcionário(String nome) {
        this.nome = nome;
    }

    public Funcionário(String nome, Float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    private Long cpf;
    private String nome;
    private Float salario;

    public void promover(float porcentagem) {
        this.salario = salario * (1 + (porcentagem/100));
    }
    public void aumentarSalario(float valor){
        this.salario += valor;
    }

    public void aumentarSalario(float valor, float comicao) {
        this.salario = (this.salario + valor) * ((comicao/100) + 1);
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }
}
