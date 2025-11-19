package services;

import entities.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrar(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser null!");
        }
        produtos.add(produto);
    }

    public void remover(int index) {
        if (index < 0 || index >= produtos.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para remoção!");
        }
        produtos.remove(index);
    }

    public void atualizar(int index, Produto produto) {
        if (index < 0 || index >= produtos.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para atualização!");
        }
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser null!");
        }
        produtos.set(index, produto);
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }
    
    public int contarProdutos() {
        return produtos.size();
    }
    
    public boolean isVazio() {
        return produtos.isEmpty();
    }
}
