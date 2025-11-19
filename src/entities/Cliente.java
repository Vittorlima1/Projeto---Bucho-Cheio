package entities;

public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, int idade, String email) {
        super(nome, idade);
        this.email = email;
    }

    // Construtor só com nome
    public Cliente(String nome) {
        super(nome);
        this.email = "email@exemplo.com";
    }

    // Construtor padrão
    public Cliente() {
        super();
        this.email = "email@exemplo.com";
    }

    @Override
    public void exibirInfo() {
        System.out.println("Cliente: " + nome + " (" + idade + " anos) - Email: " + email);
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
