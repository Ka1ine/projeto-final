package turismo.controllers;
import java.util.List;

import turismo.models.Pessoas.Cliente;

public interface ClienteController {
    List<Cliente> listarClientes();
    Cliente buscarClientePorIdentificacao(String identificacao);
}