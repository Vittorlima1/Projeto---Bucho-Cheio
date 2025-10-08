package entities;

public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Sobrecarga de construtor
    public Produto(String nome) {
        this.nome = nome;
        this.preco = 0.0;
    }

    public void exibirInfo() {
        System.out.println("Produto: " + nome + " - R$ " + preco);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
