package turismo.views;
import java.util.List;
import turismo.controllers.TurismoController;
import turismo.models.PacoteViagem;

public class TurismoViewImpl implements TurismoView {
    private TurismoController bibliotecaController;

    public TurismoViewImpl(TurismoController controller) {
        bibliotecaController = controller;
    }

    @Override
    public void mostrarViagensDisponiveis(List<PacoteViagem> viagens) {
        // Implementação da exibição de itens disponíveis
    }

    @Override
    public void mostrarEmprestimoStatus(boolean sucesso) {
        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso.");
        } else {
            System.out.println("Falha ao realizar o empréstimo.");
        }
    }

    @Override
    public void mostrarDevolucaoStatus(boolean sucesso) {
        if (sucesso) {
            System.out.println("Devolução realizada com sucesso.");
        } else {
            System.out.println("Falha ao realizar a devolução.");
        }
    }
}