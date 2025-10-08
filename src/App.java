import entities.*;
import services.*;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ClienteService clienteService = new ClienteService();
    private static FuncionarioService funcionarioService = new FuncionarioService();
    private static ProdutoService produtoService = new ProdutoService();
    private static PedidoService pedidoService = new PedidoService();
    
    // Método auxiliar para repetir strings (compatibilidade Java 8)
    private static String repetir(String str, int vezes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vezes; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("\n🍔 Bem-vindo ao Sistema Bucho Cheio! 🍔");
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcaoMenu();
            
            try {
                executarOpcao(opcao);
            } catch (Exception e) {
                System.err.println("❌ Erro: " + e.getMessage());
            }
            
        } while (opcao != 0);
        
        System.out.println("\n👋 Obrigado por usar o Sistema Bucho Cheio!");
        sc.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== 📋 MENU BUCHO CHEIO ===");
        System.out.println("1 - 👤 Cadastrar Cliente");
        System.out.println("2 - 📋 Listar Clientes (" + clienteService.listarTodos().size() + " cadastrados)");
        System.out.println("3 - 👨‍💼 Cadastrar Funcionário");
        System.out.println("4 - 📋 Listar Funcionários (" + funcionarioService.listarTodos().size() + " cadastrados)");
        System.out.println("5 - 🍕 Cadastrar Produto");
        System.out.println("6 - 📋 Listar Produtos (" + produtoService.listarTodos().size() + " cadastrados)");
        System.out.println("7 - 🛒 Criar Pedido");
        System.out.println("8 - 📋 Listar Pedidos (" + pedidoService.listarTodos().size() + " registrados)");
        System.out.println("0 - 🚪 Sair");
        System.out.print("\n➡️  Escolha uma opção: ");
    }
    
    private static int lerOpcaoMenu() {
        try {
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
            return opcao;
        } catch (InputMismatchException e) {
            sc.nextLine(); // Limpa o buffer inválido
            System.err.println("❌ Por favor, digite apenas números!");
            return -1; // Valor inválido para continuar o loop
        }
    }
    
    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1: cadastrarCliente(); break;
            case 2: listarClientes(); break;
            case 3: cadastrarFuncionario(); break;
            case 4: listarFuncionarios(); break;
            case 5: cadastrarProduto(); break;
            case 6: listarProdutos(); break;
            case 7: criarPedido(); break;
            case 8: listarPedidos(); break;
            case 0: break; // Sair
            default: System.err.println("❌ Opção inválida! Tente novamente.");
        }
    }
    
    private static void cadastrarCliente() {
        System.out.println("\n=== 👤 CADASTRO DE CLIENTE ===");
        
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio!");
        }
        
        System.out.print("Idade: ");
        int idade = lerInteiro();
        if (idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Idade deve ser entre 0 e 150 anos!");
        }
        
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email deve conter @!");
        }
        
        clienteService.cadastrar(new Cliente(nome, idade, email));
        System.out.println("✅ Cliente cadastrado com sucesso!");
    }
    
    private static void listarClientes() {
        System.out.println("\n=== 👥 LISTA DE CLIENTES ===");
        List<Cliente> clientes = clienteService.listarTodos();
        
        if (clientes.isEmpty()) {
            System.out.println("📭 Nenhum cliente cadastrado ainda.");
            return;
        }
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.print((i + 1) + ". ");
            clientes.get(i).exibirInfo();
        }
    }
    
    private static void cadastrarFuncionario() {
        System.out.println("\n=== 👨‍💼 CADASTRO DE FUNCIONÁRIO ===");
        
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio!");
        }
        
        System.out.print("Idade: ");
        int idade = lerInteiro();
        if (idade < 16 || idade > 80) {
            throw new IllegalArgumentException("Idade deve ser entre 16 e 80 anos para funcionários!");
        }
        
        System.out.print("Cargo: ");
        String cargo = sc.nextLine().trim();
        if (cargo.isEmpty()) {
            throw new IllegalArgumentException("Cargo não pode estar vazio!");
        }
        
        funcionarioService.cadastrar(new Funcionario(nome, idade, cargo));
        System.out.println("✅ Funcionário cadastrado com sucesso!");
    }
    
    private static void listarFuncionarios() {
        System.out.println("\n=== 👨‍💼 LISTA DE FUNCIONÁRIOS ===");
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        
        if (funcionarios.isEmpty()) {
            System.out.println("📭 Nenhum funcionário cadastrado ainda.");
            return;
        }
        
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.print((i + 1) + ". ");
            funcionarios.get(i).exibirInfo();
        }
    }
    
    private static void cadastrarProduto() {
        System.out.println("\n=== 🍕 CADASTRO DE PRODUTO ===");
        
        System.out.print("Nome do produto: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode estar vazio!");
        }
        
        System.out.print("Preço (R$): ");
        double preco = lerDouble();
        if (preco < 0) {
            throw new IllegalArgumentException("Preço deve ser positivo!");
        }
        
        produtoService.cadastrar(new Produto(nome, preco));
        System.out.println("✅ Produto cadastrado com sucesso!");
    }
    
    private static void listarProdutos() {
        System.out.println("\n=== 🍕 LISTA DE PRODUTOS ===");
        List<Produto> produtos = produtoService.listarTodos();
        
        if (produtos.isEmpty()) {
            System.out.println("📭 Nenhum produto cadastrado ainda.");
            return;
        }
        
        for (int i = 0; i < produtos.size(); i++) {
            System.out.print((i + 1) + ". ");
            produtos.get(i).exibirInfo();
        }
    }
    
    private static void criarPedido() {
        System.out.println("\n=== 🛒 CRIAR PEDIDO ===");
        
        List<Cliente> clientes = clienteService.listarTodos();
        List<Produto> produtos = produtoService.listarTodos();
        
        if (clientes.isEmpty()) {
            throw new IllegalStateException("Cadastre pelo menos um cliente antes de criar um pedido!");
        }
        
        if (produtos.isEmpty()) {
            throw new IllegalStateException("Cadastre pelo menos um produto antes de criar um pedido!");
        }
        
        // Selecionar cliente
        System.out.println("\n📋 Selecione um cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.print((i + 1) + ". ");
            clientes.get(i).exibirInfo();
        }
        
        System.out.print("\nEscolha o cliente (número): ");
        int clienteIndex = lerInteiro() - 1;
        
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            throw new IllegalArgumentException("Cliente inválido selecionado!");
        }
        
        Cliente clienteSelecionado = clientes.get(clienteIndex);
        Pedido pedido = new Pedido(clienteSelecionado);
        
        // Adicionar produtos ao pedido
        System.out.println("\n📋 Produtos disponíveis:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.print((i + 1) + ". ");
            produtos.get(i).exibirInfo();
        }
        
        System.out.println("\n➡️  Digite os números dos produtos (separados por espaço, ou 0 para todos):");
        String entrada = sc.nextLine().trim();
        
        if (entrada.equals("0")) {
            // Adiciona todos os produtos
            for (Produto produto : produtos) {
                pedido.adicionarProduto(produto);
            }
        } else {
            // Adiciona produtos específicos
            String[] indices = entrada.split(" ");
            for (String indiceStr : indices) {
                try {
                    int indice = Integer.parseInt(indiceStr.trim()) - 1;
                    if (indice >= 0 && indice < produtos.size()) {
                        pedido.adicionarProduto(produtos.get(indice));
                    }
                } catch (NumberFormatException e) {
                    System.err.println("⚠️  Ignorando entrada inválida: " + indiceStr);
                }
            }
        }
        
        if (pedido.getProdutos().isEmpty()) {
            throw new IllegalStateException("Nenhum produto foi adicionado ao pedido!");
        }
        
        pedidoService.cadastrar(pedido);
        System.out.println("✅ Pedido criado com sucesso!");
        pedido.exibirInfo();
    }
    
    private static void listarPedidos() {
        System.out.println("\n=== 🛒 LISTA DE PEDIDOS ===");
        List<Pedido> pedidos = pedidoService.listarTodos();
        
        if (pedidos.isEmpty()) {
            System.out.println("📭 Nenhum pedido registrado ainda.");
            return;
        }
        
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println("\n" + (i + 1) + "º PEDIDO:");
            pedidos.get(i).exibirInfo();
            System.out.println(repetir("─", 40));
        }
    }
    
    private static int lerInteiro() {
        try {
            int valor = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
            return valor;
        } catch (InputMismatchException e) {
            sc.nextLine(); // Limpa o buffer inválido
            throw new IllegalArgumentException("Por favor, digite um número inteiro válido!");
        }
    }
    
    private static double lerDouble() {
        try {
            double valor = sc.nextDouble();
            sc.nextLine(); // Limpa o buffer
            return valor;
        } catch (InputMismatchException e) {
            sc.nextLine(); // Limpa o buffer inválido
            throw new IllegalArgumentException("Por favor, digite um número decimal válido!");
        }
    }
}
