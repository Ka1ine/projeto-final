package turismo.models;

public interface Cliente {
    String getNome();
    String getIdentificacao();
    int getLimiteEmprestimo();
    int getPrazoEmprestimo();
    double getMultaAtraso();
}