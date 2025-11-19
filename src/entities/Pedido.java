package entities;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

 public class Pedido {
    private Cliente cliente;
    
    // ArrayList que armazena todos os produtos do pedido
    // Permite adicionar vários produtos dinamicamente
    private List<Produto> produtos = new ArrayList<>();
    
    private LocalDateTime dataHora;
    
    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser null!");
        }
        this.cliente = cliente;
        this.dataHora = LocalDateTime.now();
    }

    // Construtor com cliente e data/hora específica
    public Pedido(Cliente cliente, LocalDateTime dataHora) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser null!");
        }
        this.cliente = cliente;
        this.dataHora = dataHora != null ? dataHora : LocalDateTime.now();
    }

    // Construtor padrão (cria cliente padrão)
    public Pedido() {
        this.cliente = new Cliente(); // Usa o construtor padrão do Cliente
        this.dataHora = LocalDateTime.now();
    }

    // Sobrecarga de método - adiciona produto existente ao ArrayList
    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser null!");
        }
        
        // O método add() do ArrayList adiciona o produto no final da lista
        produtos.add(produto);
    }

    // Sobrecarga de método - cria novo produto e adiciona ao ArrayList
    public void adicionarProduto(String nome, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode estar vazio!");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço deve ser positivo!");
        }
        
        // Cria um novo produto e adiciona ao ArrayList
        produtos.add(new Produto(nome, preco));
    }
    
    /**
     * Remove produto do pedido usando índice do ArrayList
     */
    public void removerProduto(int index) {
        if (index < 0 || index >= produtos.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para remoção!");
        }
        produtos.remove(index);
    }
    
    /**
     * Remove produto específico do ArrayList
     * Usa o método remove(Object) do ArrayList
     */
    public boolean removerProduto(Produto produto) {
        return produtos.remove(produto);
    }
    
    /**
     * Calcula total do pedido iterando sobre o ArrayList de produtos
     * Demonstra como percorrer um ArrayList usando enhanced for loop
     */
    public double calcularTotal() {
        double total = 0.0;
        
        // Enhanced for loop - forma moderna de iterar sobre ArrayList
        // Equivale a: for(int i = 0; i < produtos.size(); i++)
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        
        return total;
    }
    
    /**
     * Conta quantidade de produtos usando size() do ArrayList
     */
    public int getQuantidadeProdutos() {
        return produtos.size();
    }
    
    /**
     * Verifica se pedido tem produtos usando isEmpty() do ArrayList
     */
    public boolean isVazio() {
        return produtos.isEmpty();
    }

    public void exibirInfo() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        System.out.println("🛒 Pedido do cliente: " + cliente.getNome());
        System.out.println("🗺 Data/Hora: " + dataHora.format(formatter));
        System.out.println("🍕 Produtos (" + produtos.size() + " itens):");
        
        // Usando for tradicional para mostrar números dos itens
        // Demonstra acesso por índice no ArrayList usando get(index)
        for (int i = 0; i < produtos.size(); i++) {
            System.out.print("   " + (i + 1) + ". ");
            produtos.get(i).exibirInfo(); // get(i) acessa elemento na posição i
        }
        
        System.out.println("💵 Total do pedido: R$ " + df.format(calcularTotal()));
    }
    
    /**
     * Busca produto por nome no ArrayList
     * Demonstra iteração com condição
     */
    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
    
    /**
     * Lista produtos por faixa de preço
     * Retorna novo ArrayList com produtos filtrados
     */
    public List<Produto> listarProdutosPorPreco(double precoMin, double precoMax) {
        List<Produto> produtosFiltrados = new ArrayList<>();
        
        for (Produto produto : produtos) {
            if (produto.getPreco() >= precoMin && produto.getPreco() <= precoMax) {
                produtosFiltrados.add(produto);
            }
        }
        
        return produtosFiltrados;
    }

    // Getters
    public Cliente getCliente() { return cliente; }
    
    /**
     * Retorna cópia defensiva do ArrayList de produtos
     * Evita modificações externas na lista interna
     */
    public List<Produto> getProdutos() { 
        return new ArrayList<>(produtos); 
    }
    
    public LocalDateTime getDataHora() { return dataHora; }
}
