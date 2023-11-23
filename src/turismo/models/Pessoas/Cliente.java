
package turismo.models.Pessoas;

import java.time.LocalDate;
import java.util.ArrayList;

import turismo.models.Adm.Reserva;

public class Cliente extends Usuario {

    private ArrayList<Reserva> reservas;

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente(String nome, long documento, long id, long telefone, String email, LocalDate aniversario) {
        super(nome, documento, id, telefone, email, aniversario);
        this.reservas = new ArrayList<>();
    }
}
