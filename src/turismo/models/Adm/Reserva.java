package turismo.models.Adm;

import java.time.LocalDate;

import turismo.models.Pacotes.Reservavel;
import turismo.models.Pessoas.Cliente;
import turismo.models.Pessoas.Funcionario;

public class Reserva {
    private Reservavel reserva;
    private Cliente cliente;
    private LocalDate dataReserva;
    private Funcionario funcionario;
    private long idReserva;
    
    //Construtor
    public Reserva(Reservavel reserva, Cliente cliente, LocalDate dataReserva, Funcionario funcionario, long id) {
        this.reserva = reserva;
        this.cliente = cliente;
        this.dataReserva = dataReserva;
        this.funcionario = funcionario;
        this.idReserva = id;
    }
    //Getters e Setters
    public Reservavel getReserva() {
        return reserva;
    }
    
    public void setReserva(Reservavel reserva) {
        this.reserva = reserva;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public LocalDate getDataReserva() {
        return dataReserva;
    }
    
    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public long getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }
}
