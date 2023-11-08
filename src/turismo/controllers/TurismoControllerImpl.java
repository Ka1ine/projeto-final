package turismo.controllers;
import java.util.ArrayList;
import java.util.List;
import turismo.models.PacoteViagem;
import turismo.models.Cliente;

public class TurismoControllerImpl implements TurismoController {
    private List<PacoteViagem> viagens;

    public TurismoControllerImpl() {
        viagens = new ArrayList<>();
    }

    @Override
    public List<PacoteViagem> consultarViagensDisponiveis() {
        return viagens;
    }

    @Override
    public boolean emprestarViagem(Cliente cliente, PacoteViagem viagem) {
        // Lógica de empréstimo
        return true;
    }

    @Override
    public boolean devolverViagem(Cliente cliente, PacoteViagem viagem) {
        // Lógica de devolução
        return true;
    }
}