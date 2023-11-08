package biblioteca.models;

import java.time.LocalDate;

public class Funcionario extends Usuario {
    public Funcionario(String nome, int documento, int id, int telefone, String email, LocalDate aniversario) {
        super(nome, documento, id, telefone, email, aniversario);
    }
}
