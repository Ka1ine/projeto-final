package turismo.views;
import java.util.List;
import turismo.models.PacoteViagem;

public interface TurismoView {
    void mostrarViagensDisponiveis(List<PacoteViagem> viagens);
    void mostrarEmprestimoStatus(boolean sucesso);
    void mostrarDevolucaoStatus(boolean sucesso);
}