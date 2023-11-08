package turismo.controllers;
import java.util.List;
import turismo.models.Pacotes.Pacote;
import turismo.models.Pessoas.Cliente;

public interface TurismoController {
    List<? extends Pacote> consultarViagensDisponiveis();
    <T extends Pacote> boolean emprestarViagem(Cliente cliente, T viagem);
    <T extends Pacote> boolean devolverViagem(Cliente cliente,T viagem);
}