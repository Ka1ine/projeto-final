package turismo.controllers;
import java.util.ArrayList;
import java.util.List;
import turismo.models.Pessoas.Cliente;

public class ClienteControllerImpl implements ClienteController {
    private List<Cliente> clientes;

    public ClienteControllerImpl() {
        clientes = new ArrayList<>();
    }

    @Override
    public List<Cliente> listarClientes() {
        return clientes;
    }

    @Override
    public Cliente buscarClientePorIdentificacao(String identificacao) {
        // Lógica de busca
        return null;
    }
}