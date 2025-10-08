package repositories;

import entities.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository implements IRepository<Funcionario> {
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void adicionar(Funcionario obj) {
        funcionarios.add(obj);
    }

    @Override
    public void remover(int index) {
        funcionarios.remove(index);
    }

    @Override
    public void atualizar(int index, Funcionario obj) {
        funcionarios.set(index, obj);
    }

    @Override
    public List<Funcionario> listar() {
        return funcionarios;
    }
}
