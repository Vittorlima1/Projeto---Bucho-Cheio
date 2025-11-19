package entities;

public abstract class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Sobrecarga de construtor
    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 0;
    }

    // Construtor padrão
    public Pessoa() {
        this.nome = "Nome não definido";
        this.idade = 0;
    }

    // Método abstrato
    public abstract void exibirInfo();

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
}
