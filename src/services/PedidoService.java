package services;

import entities.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();

    public void cadastrar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser null!");
        }
        pedidos.add(pedido);
    }

    public void remover(int index) {
        if (index < 0 || index >= pedidos.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para remoção!");
        }
        pedidos.remove(index);
    }

    public void atualizar(int index, Pedido pedido) {
        if (index < 0 || index >= pedidos.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para atualização!");
        }
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser null!");
        }
        pedidos.set(index, pedido);
    }

    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos);
    }
    
    public int contarPedidos() {
        return pedidos.size();
    }
    
    public boolean isVazio() {
        return pedidos.isEmpty();
    }
}
