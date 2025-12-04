package modelos;

import java.io.Serializable;
import java.util.Objects;

public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String titulo;
    private String genero;
    private int duracao; // em minutos
    private String diretor;
    private String sinopse;
    private int classificacao; // em anos

    public Filme() {}

    // Construtor usado no cadastro de filme (sem id, que será gerado)
    public Filme(String titulo, String genero, int duracao, int classificacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.diretor = ""; // Inicializa para evitar null
        this.sinopse = ""; // Inicializa para evitar null
    }
    
    // Construtor completo para uso ao carregar dados (incluindo diretor e sinopse)
    public Filme(int id, String titulo, String genero, int duracao, String diretor, String sinopse, int classificacao) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.diretor = diretor;
        this.sinopse = sinopse;
        this.classificacao = classificacao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }

    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }

    public String getSinopse() { return sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }

    public int getClassificacao() { return classificacao; }
    public void setClassificacao(int classificacao) { this.classificacao = classificacao; }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Gênero: " + genero + 
               ", Duração: " + duracao + " min, Classificação: " + classificacao + " anos";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return id == filme.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}