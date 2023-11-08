package turismo.controllers;
import java.util.List;
import turismo.models.Cliente;
import turismo.views.ClienteView;

public interface ClienteController {
    List<Cliente> listarClientes();
    Cliente buscarClientePorIdentificacao(String identificacao);
}