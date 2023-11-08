
package turismo.models.Pessoas;

import java.time.LocalDate;

public class Cliente extends Usuario {
    public Cliente(String nome, int documento, int id, int telefone, String email, LocalDate aniversario) {
        super(nome, documento, id, telefone, email, aniversario);
    }
}
