package turismo.controllers;
import java.util.List;
import java.util.Scanner;

import turismo.models.Pacotes.Pacote;
import turismo.models.Pacotes.Reservavel;
import turismo.models.Pessoas.Cliente;

public interface TurismoController {
    List<Pacote> consultarViagensDisponiveis();
    <T extends Pacote> boolean emprestarViagem(Cliente cliente, T viagem);
    <T extends Pacote> boolean devolverViagem(Cliente cliente,T viagem);
    Reservavel obterReservavelporId(long id);
    public void addPacote(Scanner scanner);
    public void removerPacote(Scanner scanner);
    public void editarPacote(Scanner scanner);
    public Boolean idDisponivel(long id);
}