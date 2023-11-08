package turismo.models.Pessoas;

import java.time.LocalDate;

import turismo.models.Usuario;

public class Funcionario extends Usuario {
    public Funcionario(String nome, int documento, int id, int telefone, String email, LocalDate aniversario) {
        super(nome, documento, id, telefone, email, aniversario);
    }
}
