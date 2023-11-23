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
        System.out.println("╔══════════════ Lista de Clientes ══════════════╗");
        System.out.println("║                                               ║");
        int cont = 1;
        for (Cliente cliente : clientes) {
            System.out.println("║ Cliente " + cont + ": "+ cliente.getNome());
            cont++;
        }
        System.out.println("║                                               ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    @Override
    public void mostrarDetalhesMembro(Cliente clientes) {
        // Implementação da exibição dos detalhes de um membro
    }
}