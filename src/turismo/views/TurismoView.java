package turismo.views;
import java.util.List;

import turismo.models.Pacotes.Pacote;

public interface TurismoView {
    void mostrarViagensDisponiveis(List<Pacote> viagens);
    void mostrarEmprestimoStatus(boolean sucesso);
    void mostrarDevolucaoStatus(boolean sucesso);
}