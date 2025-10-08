package services;

import entities.Funcionario;
import repositories.FuncionarioRepository;
import java.util.List;

public class FuncionarioService implements IService<Funcionario> {
    private FuncionarioRepository repo = new FuncionarioRepository();

    @Override
    public void cadastrar(Funcionario obj) {
        repo.adicionar(obj);
    }

    @Override
    public void remover(int index) {
        repo.remover(index);
    }

    @Override
    public void alterar(int index, Funcionario obj) {
        repo.atualizar(index, obj);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return repo.listar();
    }
}
