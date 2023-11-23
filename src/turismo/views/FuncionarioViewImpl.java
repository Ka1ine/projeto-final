package turismo.views;
import java.util.List;

import turismo.controllers.FuncionarioController;
import turismo.models.Pessoas.Funcionario;

public class FuncionarioViewImpl implements FuncionarioView {
    private FuncionarioController funcionarioController;

    public FuncionarioViewImpl(FuncionarioController controller) {
        funcionarioController = controller;
    }

    @Override
    public void mostrarListaFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("╔════════════ Lista de Funcionarios ════════════╗");
        System.out.println("║                                               ║");
        int cont = 1;
        for (Funcionario funcionario : funcionarios) {
            System.out.println("║ Funcionário " + cont + ": "+ funcionario.getNome());
            cont++;
        }
        System.out.println("║                                               ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    @Override
    public void mostrarDetalhesFuncionario(Funcionario funcionario) {
        // Implementação da exibição dos detalhes de um membro
    }
}