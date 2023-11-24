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
    private ArrayList<Reserva> reservas;

    public ClienteControllerImpl() {
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    @Override
    public List<Cliente> listarClientes() {
        return clientes;
    }

    @Override
    public Cliente buscarClientePorIdentificacao(String identificacao) {
        return null;
    }

    public void reservar(Cliente cliente, Reservavel pacote, Funcionario funcionario,long id) throws ViagemCheiaException{
        try {
            if (pacote.getReservas().size() >= pacote.getMaxReservas()){
                throw new ViagemCheiaException("Viagem ja lotada");
            }
            Reserva reserva = new Reserva(pacote, cliente, LocalDate.now() ,funcionario,id);
            cliente.getReservas().add(reserva);
            pacote.getReservas().add(reserva);
            reservas.add(reserva);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao fazer a reserva, por favor tente novamente");
        }
    }

    public Reserva obterReservaPorId(long id){
        for(Reserva reserva:reservas){
            if (reserva.getIdReserva() == id){
                return reserva;
            }
        }
        return null;
    }

    public class ViagemCheiaException extends Exception{
        public ViagemCheiaException(String mensagem){
            super(mensagem);
        }
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