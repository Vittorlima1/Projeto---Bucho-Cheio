package services;

import entities.Cliente;
import repositories.ClienteRepository;
import java.util.List;

public class ClienteService implements IService<Cliente> {
    private ClienteRepository repo = new ClienteRepository();

    @Override
    public void cadastrar(Cliente obj) {
        repo.adicionar(obj);
    }

    @Override
    public void remover(int index) {
        repo.remover(index);
    }

    @Override
    public void alterar(int index, Cliente obj) {
        repo.atualizar(index, obj);
    }

    @Override
    public List<Cliente> listarTodos() {
        return repo.listar();
    }
}
