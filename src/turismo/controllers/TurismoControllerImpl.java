package turismo.controllers;
import java.util.ArrayList;
import java.util.List;
import turismo.models.Pacotes.*;
import turismo.models.Pessoas.*;

public class TurismoControllerImpl implements TurismoController {
    private List<Pacote> viagens;

    public TurismoControllerImpl() {
        viagens = new ArrayList<>();
    }

    @Override
    public List<Pacote> consultarViagensDisponiveis() {
        return viagens;
    }

    @Override
    public boolean emprestarViagem(Cliente cliente, Pacote viagem) {
        // Lógica de empréstimo
        return true;
    }

    @Override
    public boolean devolverViagem(Cliente cliente, Pacote viagem) {
        // Lógica de devolução
        return true;
    }
}