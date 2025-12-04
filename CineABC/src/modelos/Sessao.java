package modelos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sessao implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Filme filme;
    private Sala sala;
    private LocalDateTime dataHora;
    private int ingressosVendidos;
    private double preco;
    private List<Ingresso> ingressos = new ArrayList<>(); // Lista de ingressos específicos desta sessão

    public Sessao() {
    }

    public Sessao(Filme filme, Sala sala, LocalDateTime dataHora, double preco) {
        this.filme = filme;
        this.sala = sala;
        this.dataHora = dataHora;
        this.preco = preco;
        this.ingressosVendidos = 0; // Inicializa com 0
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(int ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
        // Removi a linha de System.out.println para evitar poluição de console
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Retorna uma cópia defensiva da lista de ingressos
    public List<Ingresso> getIngressos() {
        return new ArrayList<>(ingressos);
    }

    // Usado principalmente para carregar dados de persistência
    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = new ArrayList<>(ingressos);
        this.ingressosVendidos = this.ingressos.size(); // Garante consistência
    }

    public void adicionarIngresso(Ingresso ingresso) {
        if (getIngressosDisponiveis() <= 0) {
            throw new IllegalStateException("Não há ingressos disponíveis para esta sessão");
        }
        this.ingressos.add(ingresso);
        this.ingressosVendidos++; // Incrementa aqui, a lógica da Sessao é a primária
    }

    public int getIngressosDisponiveis() {
        return sala != null ? sala.getCapacidade() - ingressosVendidos : 0;
    }
    
    @Override
    public String toString() {
        return "Sessão ID: " + id + ", Filme: " + (filme != null ? filme.getTitulo() : "N/A") + 
               ", Sala: " + (sala != null ? sala.getNumero() : "N/A") + ", Data/Hora: " + dataHora +
               ", Preço: " + String.format("%.2f", preco) + ", Vendidos: " + ingressosVendidos;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sessao sessao = (Sessao) o;
        return id == sessao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}