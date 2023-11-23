package turismo.controllers;
import java.util.List;
import java.util.Scanner;
import turismo.models.Pacotes.Pacote;
import turismo.models.Pessoas.Cliente;

public interface TurismoController {
    List<Pacote> consultarViagensDisponiveis();
    <T extends Pacote> boolean emprestarViagem(Cliente cliente, T viagem);
    <T extends Pacote> boolean devolverViagem(Cliente cliente,T viagem);
    public void addPacote(Pacote p, Scanner scanner);
    public void removerPacote(int codigo);
    public void editarPacote(int codigo, Scanner scanner);
}