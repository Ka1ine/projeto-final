package turismo.models.Pessoas;

import java.time.*;

//Classe base de todos os os usuarios do sistema, incluindo clientes e funcionários
public class Usuario{
    //Atributos
    private String nome;
    private long documento;
    private long id;
    private long telefone;
    private String email;
    private LocalDate aniversario;

    //Construtor
    public Usuario(String nome, long documento, long id, long telefone, String email, LocalDate aniversario) {
        this.nome = nome;
        this.documento = documento;
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.aniversario = aniversario;
    }
    //Getters e setters
    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
