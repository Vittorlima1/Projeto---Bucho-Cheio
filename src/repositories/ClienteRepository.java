package repositories;

import entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepository implements IRepository<Cliente> {
    // ArrayList que armazena todos os clientes cadastrados
    // Um ArrayList é uma estrutura de dados dinâmica que pode crescer conforme necessário
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void adicionar(Cliente obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cliente não pode ser null!");
        }
        
        // Verificar se já existe cliente com mesmo email
        if (buscarPorEmail(obj.getEmail()) != null) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este email!");
        }
        
        // O método add() do ArrayList adiciona o elemento no final da lista
        clientes.add(obj);
    }

    @Override
    public void remover(int index) {
        if (index < 0 || index >= clientes.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para remoção!");
        }
        // O método remove(index) remove o elemento na posição específica
        clientes.remove(index);
    }

    @Override
    public void atualizar(int index, Cliente obj) {
        if (index < 0 || index >= clientes.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para atualização!");
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cliente não pode ser null!");
        }
        // O método set() substitui o elemento na posição específica
        clientes.set(index, obj);
    }

    @Override
    public List<Cliente> listar() {
        // Retorna uma nova ArrayList com os mesmos elementos (cópia defensiva)
        return new ArrayList<>(clientes);
    }
    
    // Métodos adicionais de busca usando as funcionalidades do ArrayList
    
    /**
     * Busca cliente por email usando stream API do Java 8+
     * O ArrayList implementa Iterable, permitindo usar streams facilmente
     */
    public Cliente buscarPorEmail(String email) {
        return clientes.stream()
                      .filter(cliente -> cliente.getEmail().equalsIgnoreCase(email))
                      .findFirst()
                      .orElse(null);
    }
    
    /**
     * Busca clientes por nome (busca parcial, case-insensitive)
     * Retorna um novo ArrayList com os resultados
     */
    public List<Cliente> buscarPorNome(String nome) {
        return clientes.stream()
                      .filter(cliente -> cliente.getNome().toLowerCase().contains(nome.toLowerCase()))
                      .collect(Collectors.toList());
    }
    
    /**
     * Conta total de clientes usando o método size() do ArrayList
     */
    public int contarClientes() {
        return clientes.size();
    }
    
    /**
     * Verifica se a lista está vazia usando isEmpty() do ArrayList
     */
    public boolean isVazio() {
        return clientes.isEmpty();
    }
}
