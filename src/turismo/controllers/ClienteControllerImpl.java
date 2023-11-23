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

    @Override
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente obterClientePorId(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; 
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        int index = clientes.indexOf(cliente);
        if (index != -1) {
            clientes.set(index, cliente);
        }
        
    }

    @Override
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);  
    }
    
}