package services;

import entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser null!");
        }
        
        if (buscarPorEmail(cliente.getEmail()) != null) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este email!");
        }
        
        clientes.add(cliente);
    }

    public void remover(int index) {
        if (index < 0 || index >= clientes.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para remoção!");
        }
        clientes.remove(index);
    }

    public void atualizar(int index, Cliente cliente) {
        if (index < 0 || index >= clientes.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para atualização!");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser null!");
        }
        clientes.set(index, cliente);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
    
    public Cliente buscarPorEmail(String email) {
        return clientes.stream()
                      .filter(cliente -> cliente.getEmail().equalsIgnoreCase(email))
                      .findFirst()
                      .orElse(null);
    }
    
    public List<Cliente> buscarPorNome(String nome) {
        return clientes.stream()
                      .filter(cliente -> cliente.getNome().toLowerCase().contains(nome.toLowerCase()))
                      .collect(Collectors.toList());
    }
    
    public int contarClientes() {
        return clientes.size();
    }
    
    public boolean isVazio() {
        return clientes.isEmpty();
    }
}
