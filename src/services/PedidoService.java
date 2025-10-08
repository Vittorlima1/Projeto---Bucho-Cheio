package services;

import entities.Pedido;
import repositories.PedidoRepository;
import java.util.List;

public class PedidoService implements IService<Pedido> {
    private PedidoRepository repo = new PedidoRepository();

    @Override
    public void cadastrar(Pedido obj) {
        repo.adicionar(obj);
    }

    @Override
    public void remover(int index) {
        repo.remover(index);
    }

    @Override
    public void alterar(int index, Pedido obj) {
        repo.atualizar(index, obj);
    }

    @Override
    public List<Pedido> listarTodos() {
        return repo.listar();
    }
}
