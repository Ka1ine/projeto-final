package turismo.models.Pessoas;


import java.time.LocalDate;

//Além das funções de um funcionário normal também consegue cadastrar, remover e alterar pacotes
public class Gerente extends Funcionario {
    private int senha;
    public Gerente(String nome, long documento, long id, long telefone, String email, LocalDate aniversario, int senha) {
        super(nome, documento, id, telefone, email, aniversario);
        this.senha = senha;
    }
}
