package turismo.controllers;

import java.util.List;

import turismo.models.Pessoas.Funcionario;

public interface FuncionarioController {
    List<Funcionario> listarFuncionarios();
    Funcionario buscarFuncionarioPorIdentificacao(String identificacao);
    void adicionarFuncionario(Funcionario cliente);
    Funcionario obterFuncionarioPorId(long id);
    void atualizarFuncionario(Funcionario funcionario);
    void removerFuncionario(Funcionario funcionario);
    public Boolean idDisponivel(long id);
}