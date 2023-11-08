package turismo.models.Pessoas;


import java.time.*;

//Classe base de todos os os usuarios do sistema, incluindo clientes e funcionários
public class Usuario{
    //Atributos
    private String nome;
    private int documento;
    private int id;
    private int telefone;
    private String email;
    private LocalDate aniversario;

    //Construtor
    public Usuario(String nome, int documento, int id, int telefone, String email, LocalDate aniversario) {
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
