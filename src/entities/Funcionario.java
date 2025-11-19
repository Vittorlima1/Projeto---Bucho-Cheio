package entities;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, int idade, String cargo) {
        super(nome, idade);
        this.cargo = cargo;
    }

    // Construtor só com nome
    public Funcionario(String nome) {
        super(nome);
        this.cargo = "Cargo não definido";
    }

    // Construtor padrão
    public Funcionario() {
        super();
        this.cargo = "Cargo não definido";
    }

    @Override
    public void exibirInfo() {
        System.out.println("Funcionário: " + nome + " (" + idade + " anos) - Cargo: " + cargo);
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
