package repositories;

import entities.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements IRepository<Produto> {
    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void adicionar(Produto obj) {
        produtos.add(obj);
    }

    @Override
    public void remover(int index) {
        produtos.remove(index);
    }

    @Override
    public void atualizar(int index, Produto obj) {
        produtos.set(index, obj);
    }

    @Override
    public List<Produto> listar() {
        return produtos;
    }
}
