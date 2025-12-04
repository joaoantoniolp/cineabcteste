package modelos;
import java.io.Serializable;
import java.util.Objects;

public class Ingresso implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Sessao sessao;
    private String tipoIngresso; // Ex: "Inteira", "Meia"
    private double preco;
    private String assento;
    private String nomeCliente;

    public Ingresso() {}

    // Construtor que não recebe ID, pois o ID será gerado por CineAbc
    public Ingresso(Sessao sessao, String tipoIngresso, double preco, String assento, String nomeCliente) {
        this.sessao = sessao;
        this.tipoIngresso = tipoIngresso;
        this.preco = preco;
        this.assento = assento;
        this.nomeCliente = nomeCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    @Override
    public String toString() {
        return "Ingresso ID: " + id + ", Cliente: " + nomeCliente + 
               ", Sessão ID: " + (sessao != null ? sessao.getId() : "N/A") + 
               ", Assento: " + assento + ", Tipo: " + tipoIngresso + ", Preço: " + String.format("%.2f", preco);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingresso ingresso = (Ingresso) o;
        return id == ingresso.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}