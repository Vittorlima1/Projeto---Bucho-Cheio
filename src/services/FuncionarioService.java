package services;

import entities.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrar(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser null!");
        }
        funcionarios.add(funcionario);
    }

    public void remover(int index) {
        if (index < 0 || index >= funcionarios.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para remoção!");
        }
        funcionarios.remove(index);
    }

    public void atualizar(int index, Funcionario funcionario) {
        if (index < 0 || index >= funcionarios.size()) {
            throw new IndexOutOfBoundsException("Índice inválido para atualização!");
        }
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser null!");
        }
        funcionarios.set(index, funcionario);
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios);
    }
    
    public int contarFuncionarios() {
        return funcionarios.size();
    }
    
    public boolean isVazio() {
        return funcionarios.isEmpty();
    }
}
