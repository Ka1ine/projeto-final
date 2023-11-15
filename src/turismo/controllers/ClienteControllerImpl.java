package turismo.controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import turismo.models.Adm.Reserva;
import turismo.models.Pacotes.Reservavel;
import turismo.models.Pessoas.Cliente;
import turismo.models.Pessoas.Funcionario;

public class ClienteControllerImpl implements ClienteController {
    private List<Cliente> clientes;
    private LocalDate date;

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

    public void reservar(Cliente cliente, Reservavel pacote, Funcionario funcionario) throws ViagemCheiaException{
        try {
            if (pacote.getReservas().size() >= pacote.getMaxReservas()){
                throw new ViagemCheiaException("Viagem ja lotada");
            }
            Reserva reserva = new Reserva<>(pacote, cliente, LocalDate.now() ,funcionario);
            cliente.getReservas().add(reserva);
            pacote.getReservas().add(reserva);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao fazer a reserva, por favor tente novamente");
        }
    }

    class ViagemCheiaException extends Exception{
        public ViagemCheiaException(String mensagem){
            super(mensagem);
        }
    }
}