package turismo.views;
import java.util.List;
import turismo.controllers.TurismoController;
import turismo.models.Pacotes.*;

public class TurismoViewImpl implements TurismoView {
    private TurismoController bibliotecaController;

    public TurismoViewImpl(TurismoController controller) {
        bibliotecaController = controller;
    }

    @Override
    public void mostrarViagensDisponiveis(List<? extends Pacote> viagens) {
        int index = 1;
        for (Pacote pacote : viagens) {
            System.out.printf("%d. %s - R$%d,00 - %s\n", index, pacote.getDestino().getNome(), pacote.getPreco(), pacote.getCategoria().name());
            index += 1;
        }
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