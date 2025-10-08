package services;

import entities.Produto;
import repositories.ProdutoRepository;
import java.util.List;

public class ProdutoService implements IService<Produto> {
    private ProdutoRepository repo = new ProdutoRepository();

    @Override
    public void cadastrar(Produto obj) {
        repo.adicionar(obj);
    }

    @Override
    public void remover(int index) {
        repo.remover(index);
    }

    @Override
    public void alterar(int index, Produto obj) {
        repo.atualizar(index, obj);
    }

    @Override
    public List<Produto> listarTodos() {
        return repo.listar();
    }
}
