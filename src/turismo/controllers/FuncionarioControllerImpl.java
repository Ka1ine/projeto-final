package turismo.controllers;

import java.util.ArrayList;
import java.util.List;

import turismo.models.Pessoas.Funcionario;

public class FuncionarioControllerImpl implements FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioControllerImpl() {
        funcionarios = new ArrayList<>();
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public Funcionario obterFuncionarioPorId(long id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null; 
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        int index = funcionarios.indexOf(funcionario);
        if (index != -1) {
            funcionarios.set(index, funcionario);
        }
        
    }

    @Override
    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);  
    }

    @Override
    public Funcionario buscarFuncionarioPorIdentificacao(String identificacao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarFuncionarioPorIdentificacao'");
    }
}