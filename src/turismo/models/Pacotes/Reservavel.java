package turismo.models.Pacotes;

import java.util.ArrayList;

import turismo.models.Adm.Reserva;

public interface Reservavel {
    int getMaxReservas();

    ArrayList<Reserva> getReservas();
    long getId();
}
