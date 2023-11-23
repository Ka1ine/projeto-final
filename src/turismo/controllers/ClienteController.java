package turismo.controllers;
import java.util.List;

import turismo.controllers.ClienteControllerImpl.ViagemCheiaException;
import turismo.models.Adm.Reserva;
import turismo.models.Pacotes.Reservavel;
import turismo.models.Pessoas.Cliente;
import turismo.models.Pessoas.Funcionario;

public interface ClienteController {
    List<Cliente> listarClientes();
    Cliente buscarClientePorIdentificacao(String identificacao);
    void adicionarCliente(Cliente cliente);
    Cliente obterClientePorId(long id);
    void atualizarCliente(Cliente cliente);
    void removerCliente(Cliente cliente);
    void reservar(Cliente cliente, Reservavel viagem, Funcionario funcionario,long id) throws ViagemCheiaException;
    public Reserva obterReservaPorId(long id);

    
}