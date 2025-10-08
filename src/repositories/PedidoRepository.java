package repositories;

import entities.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository implements IRepository<Pedido> {
    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void adicionar(Pedido obj) {
        pedidos.add(obj);
    }

    @Override
    public void remover(int index) {
        pedidos.remove(index);
    }

    @Override
    public void atualizar(int index, Pedido obj) {
        pedidos.set(index, obj);
    }

    @Override
    public List<Pedido> listar() {
        return pedidos;
    }
}
