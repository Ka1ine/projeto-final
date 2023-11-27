package turismo.models.Pacotes;

import java.time.LocalDate;
import java.util.ArrayList;

//Inclui tudo que o pacote simples porém também inclui o transporte até o local
public class PacoteTransporte extends Pacote{
    private String origem;
    private MetodoTransporte metodo;
    //Construtor
    public PacoteTransporte(Destino destino, LocalDate dataDisp, int duracao, int preco,
            ArrayList<turismo.models.Pacotes.Pacote.atrativos> atrativos, String hotel, CategoriaViagem categoria,
            int maxReservas, int codigo, String origem, MetodoTransporte metodo) {
        super(destino, dataDisp, duracao, preco, atrativos, hotel, categoria, maxReservas, codigo);
        this.origem = origem;
        this.metodo = metodo;
    }

    //Enum
    public enum MetodoTransporte{
        AVIAO, BARCO, ONIBUS
    }
    //Getters e Setters
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public MetodoTransporte getMetodo() {
        return metodo;
    }
    public void setMetodo(MetodoTransporte metodo) {
        this.metodo = metodo;
    }
}