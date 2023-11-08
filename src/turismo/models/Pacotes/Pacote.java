package turismo.models.Pacotes;

import java.time.LocalDate;
import java.util.ArrayList;

import turismo.models.Destino;

//Classe base para todos os pacotes, inclui atrações e acomodação
public class Pacote {
    private Destino destino;
    private ArrayList<LocalDate> datasDisp;
    private int duracao;
    private int preco;
    private String atividades;
    private String hotel;
    private CategoriaViagem categoria;
    
    //Construtor
    public Pacote(Destino destino, ArrayList<LocalDate> datasDisp, int duracao, int preco, String atividades,
            String hotel, CategoriaViagem categoria) {
        this.destino = destino;
        this.datasDisp = datasDisp;
        this.duracao = duracao;
        this.preco = preco;
        this.atividades = atividades;
        this.hotel = hotel;
        this.categoria = categoria;
    }
    //Getters e Setters

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public ArrayList<LocalDate> getDatasDisp() {
        return datasDisp;
    }

    public void setDatasDisp(ArrayList<LocalDate> datasDisp) {
        this.datasDisp = datasDisp;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public CategoriaViagem getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaViagem categoria) {
        this.categoria = categoria;
    }
    
    
    public enum CategoriaViagem{
        AVENTURA, CULTURA, RELAXAMENTO, ROMANTICO, ECOTURISMO, RELIGIOSO
    }
}


