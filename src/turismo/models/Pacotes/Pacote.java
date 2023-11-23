package turismo.models.Pacotes;

import java.time.LocalDate;
import java.util.ArrayList;

import turismo.models.Adm.Reserva;

//Classe base para todos os pacotes, inclui atrações e acomodação
public class Pacote implements Reservavel{
    private Destino destino;
    private LocalDate dataDisp;
    private int duracao;
    private int preco;
    private ArrayList<atrativos> atrativos;
    
    private String hotel;
    private CategoriaViagem categoria;
    private ArrayList<Reserva<Reservavel>> reservas;
    private int maxReservas;
    private int codigo;
    
    //Construtor
    public Pacote(Destino destino, LocalDate dataDisp, int duracao, int preco, ArrayList<atrativos> atrativos,
    String hotel, CategoriaViagem categoria, int maxReservas, int codigo) {
        this.destino = destino;
        this.dataDisp = dataDisp;
        this.duracao = duracao;
        this.preco = preco;
        this.atrativos = atrativos;
        this.hotel = hotel;
        this.categoria = categoria;
        this.maxReservas = maxReservas;
        this.codigo = codigo;
        this.reservas = new ArrayList<>();
    }
    //Getters e Setters    
    public ArrayList<atrativos> getAtrativos() {
        return atrativos;
    }

    public void setAtrativos(ArrayList<atrativos> atrativos) {
        this.atrativos = atrativos;
    }
    public Destino getDestino() {
        return destino;
    }
    
    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public LocalDate getDataDisp() {
        return dataDisp;
    }
    
    public void setDatasDisp(LocalDate dataDisp) {
        this.dataDisp = dataDisp;
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
    public ArrayList<Reserva<Reservavel>> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva<Reservavel>> reservas) {
        this.reservas = reservas;
    }    
    public int getMaxReservas() {
        return maxReservas;
    }

    public void setMaxReservas(int maxReservas) {
        this.maxReservas = maxReservas;
    }    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    //enum
    public static enum CategoriaViagem{
        AVENTURA, CULTURA, RELAXAMENTO, ROMANTICO, ECOTURISMO, RELIGIOSO
    }

    public enum atrativos{
        piscina, passeio_guiado, pensao_completa, spa, pet_friendly 
    }
}


