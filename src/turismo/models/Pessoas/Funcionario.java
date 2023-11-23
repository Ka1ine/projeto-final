package turismo.models.Pessoas;

import java.time.LocalDate;

public class Funcionario extends Usuario {
    public Funcionario(String nome, long documento, long id, long telefone, String email, LocalDate aniversario) {
        super(nome, documento, id, telefone, email, aniversario);
    }
}
