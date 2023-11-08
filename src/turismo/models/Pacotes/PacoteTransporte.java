package turismo.models.Pacotes;

import java.time.LocalDate;
import java.util.ArrayList;

//Inclui tudo que o pacote simples porém também inclui o transporte até o local
public class PacoteTransporte extends Pacote{
    private String origem;
    private MetodoTransporte metodo;

    //Construtor
    public PacoteTransporte(Destino destino, ArrayList<LocalDate> datasDisp, int duracao, int preco, String atividades,
            String hotel, CategoriaViagem categoria) {
        super(destino, datasDisp, duracao, preco, atividades, hotel, categoria);
    }
    //Enum
    private enum MetodoTransporte{
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
