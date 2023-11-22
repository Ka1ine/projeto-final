package turismo.views;
import java.util.List;
import turismo.controllers.ClienteController;
import turismo.models.Pessoas.Cliente;

public class ClienteViewImpl implements ClienteView {
    private ClienteController clienteController;

    public ClienteViewImpl(ClienteController controller) {
        clienteController = controller;
    }

    @Override
    public void mostrarListaClientes(List<Cliente> clientes) {
        // Implementação da exibição da lista de membros
    }

    @Override
    public void mostrarDetalhesMembro(Cliente clientes) {
        // Implementação da exibição dos detalhes de um membro
    }
}