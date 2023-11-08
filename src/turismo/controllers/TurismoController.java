package turismo.controllers;
import java.util.List;
import turismo.models.PacoteViagem;
import turismo.models.Cliente;

public interface TurismoController {
    List<PacoteViagem> consultarViagensDisponiveis();
    boolean emprestarViagem(Cliente cliente, PacoteViagem viagem);
    boolean devolverViagem(Cliente cliente, PacoteViagem viagem);
}