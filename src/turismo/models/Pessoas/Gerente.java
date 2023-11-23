package turismo.models.Pessoas;


import java.time.LocalDate;

//Além das funções de um funcionário normal também consegue cadastrar, remover e alterar pacotes
public class Gerente extends Funcionario {
    public Gerente(String nome, long documento, long id, long telefone, String email, LocalDate aniversario) {
        super(nome, documento, id, telefone, email, aniversario);
    }
}
