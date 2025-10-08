package repositories;

import java.util.List;

public interface IRepository<T> {
    void adicionar(T obj);
    void remover(int index);
    void atualizar(int index, T obj);
    List<T> listar();
}
