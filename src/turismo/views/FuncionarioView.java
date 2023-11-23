package turismo.views;
import java.util.List;
import turismo.models.Pessoas.Funcionario;

public interface FuncionarioView {
    void mostrarListaFuncionarios(List<Funcionario> funcionarios);
    void mostrarDetalhesFuncionario(Funcionario funcionario);
}