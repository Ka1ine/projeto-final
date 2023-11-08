<<<<<<< Updated upstream
package turismo.models;

public interface Cliente {
    String getNome();
    String getIdentificacao();
    int getLimiteEmprestimo();
    int getPrazoEmprestimo();
    double getMultaAtraso();
}
=======
package biblioteca.models;

import java.time.LocalDate;

public class Cliente extends Usuario {
    public Cliente(String nome, int documento, int id, int telefone, String email, LocalDate aniversario) {
        super(nome, documento, id, telefone, email, aniversario);
    }
}
>>>>>>> Stashed changes
