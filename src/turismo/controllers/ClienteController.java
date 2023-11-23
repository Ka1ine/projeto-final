package turismo.controllers;
import java.util.List;

import turismo.models.Pessoas.Cliente;

public interface ClienteController {
    List<Cliente> listarClientes();
    Cliente buscarClientePorIdentificacao(String identificacao);
    void adicionarCliente(Cliente cliente);
    Cliente obterClientePorId(long id);
    void atualizarCliente(Cliente cliente);
    void removerCliente(Cliente cliente);
    
}