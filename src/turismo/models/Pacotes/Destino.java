package turismo.models.Pacotes;


//O local
public class Destino {
    private String nome;
    private CategoriaDestino categoria;
    private String atracoes;

    public static enum CategoriaDestino{
        PRAIA, MONTANHA, CAMPO, CIDADE
    }
    
    //Construtor
    public Destino(String nome, CategoriaDestino categoria, String atracoes) {
        this.nome = nome;
        this.categoria = categoria;
        this.atracoes = atracoes;
    }
    
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaDestino getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDestino categoria) {
        this.categoria = categoria;
    }

    public String getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(String atracoes) {
        this.atracoes = atracoes;
    }

    
}
