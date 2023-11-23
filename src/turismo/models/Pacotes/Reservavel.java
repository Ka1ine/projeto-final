package turismo.models.Pacotes;

import java.util.ArrayList;

import turismo.models.Adm.Reserva;

public interface Reservavel {

    int getMaxReservas();

    ArrayList<Reserva<Reservavel>> getReservas();

}
