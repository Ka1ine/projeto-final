package turismo.views;
import java.util.List;
import turismo.models.Pessoas.Cliente;

public interface ClienteView {
    void mostrarListaClientes(List<Cliente> membros);
    void mostrarDetalhesMembro(Cliente membro);
}