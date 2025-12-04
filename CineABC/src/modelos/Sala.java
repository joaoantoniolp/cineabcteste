package modelos;

import java.io.Serializable;
import java.util.Objects;

public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private int capacidade;
    private String tipo; // Ex: "Padrão", "3D", "IMAX"
    private boolean ativa; // Se a sala está em operação

    public Sala() {}

    public Sala(int numero, int capacidade, String tipo, boolean ativa) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.ativa = ativa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {
        return "Sala " + numero + " (Capacidade: " + capacidade + ", Tipo: " + tipo + ")";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return numero == sala.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}