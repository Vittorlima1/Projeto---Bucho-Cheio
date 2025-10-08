package services;

import java.util.List;

public interface IService<T> {
    void cadastrar(T obj);
    void remover(int index);
    void alterar(int index, T obj);
    List<T> listarTodos();
}
