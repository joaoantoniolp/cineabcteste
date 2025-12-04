package modelos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CineAbc implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Filme> filmes = new ArrayList<>();
    private List<Sala> salas = new ArrayList<>();
    private List<Sessao> sessoes = new ArrayList<>();
    private List<Ingresso> ingressos = new ArrayList<>();
    private int proximoIdFilme = 1;
    private int proximoIdSessao = 1;
    private int proximoIdIngresso = 1;

    // Métodos de adição
    public void adicionarFilme(Filme filme) {
        if (filme == null) throw new IllegalArgumentException("Filme não pode ser nulo");
        filme.setId(gerarIdFilme());
        filmes.add(filme);
    }

    public void adicionarSala(Sala sala) {
        if (sala == null) throw new IllegalArgumentException("Sala não pode ser nula");
        // Verifica se já existe uma sala com o mesmo número
        if (salas.stream().anyMatch(s -> s.getNumero() == sala.getNumero())) {
            throw new IllegalArgumentException("Já existe uma sala com o número " + sala.getNumero());
        }
        salas.add(sala);
    }

    public void adicionarSessao(Sessao sessao) {
        if (sessao == null) throw new IllegalArgumentException("Sessão não pode ser nula");
        sessao.setId(gerarIdSessao());
        sessoes.add(sessao);
    }

    public void adicionarIngresso(Ingresso ingresso) {
        if (ingresso == null) {
            throw new IllegalArgumentException("Ingresso não pode ser nulo");
        }
        if (ingresso.getSessao() == null) {
            throw new IllegalArgumentException("Sessão do ingresso não pode ser nula");
        }
        
        // Garante que o ID do ingresso seja gerado pelo CineAbc
        ingresso.setId(gerarIdIngresso());
        
        // Adiciona o ingresso à lista global do cinema
        ingressos.add(ingresso);
        
        // Adiciona o ingresso à lista de ingressos da sessão correspondente
        // A lógica de `ingressosVendidos` da sessão é atualizada dentro do método da Sessao
        ingresso.getSessao().adicionarIngresso(ingresso); 
    }

    // Getters (com cópia da lista para encapsulamento)
    public List<Filme> getFilmes() { return new ArrayList<>(filmes); }
    public List<Sala> getSalas() { return new ArrayList<>(salas); }
    public List<Sessao> getSessoes() { return new ArrayList<>(sessoes); }
    public List<Ingresso> getIngressos() { return new ArrayList<>(ingressos); }

    // Setters usados ao carregar da persistência (e atualizam os próximos IDs)
    public void setFilmes(List<Filme> filmes) {
        this.filmes = new ArrayList<>(filmes);
        this.proximoIdFilme = filmes.stream()
            .mapToInt(Filme::getId)
            .max().orElse(0) + 1;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = new ArrayList<>(salas);
        // Não há IDs sequenciais para salas, o número é o identificador
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = new ArrayList<>(sessoes);
        this.proximoIdSessao = sessoes.stream()
            .mapToInt(Sessao::getId)
            .max().orElse(0) + 1;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = new ArrayList<>(ingressos);
        this.proximoIdIngresso = ingressos.stream()
            .mapToInt(Ingresso::getId)
            .max().orElse(0) + 1;
    }

    // Geração de IDs
    public int gerarIdFilme() { return proximoIdFilme++; }
    public int gerarIdSessao() { return proximoIdSessao++; }
    public int gerarIdIngresso() { return proximoIdIngresso++; }

    // Métodos de remoção
    public void removerFilme(Filme filme) {
        filmes.remove(filme);
        // Opcional: Remover sessões ligadas a este filme.
        // sessoes.removeIf(s -> s.getFilme() != null && s.getFilme().equals(filme));
        // E ingressos ligados a essas sessões...
    }

    public void removerSala(Sala sala) {
        salas.remove(sala);
        // Opcional: Remover sessões ligadas a esta sala.
        // sessoes.removeIf(s -> s.getSala() != null && s.getSala().equals(sala));
        // E ingressos ligados a essas sessões...
    }

    public void removerSessao(Sessao sessao) {
        sessoes.remove(sessao);
        // Remove ingressos ligados a essa sessão da lista global de ingressos
        ingressos.removeIf(i -> i.getSessao() != null && i.getSessao().equals(sessao));
    }

    public void removerIngresso(Ingresso ingresso) {
        ingressos.remove(ingresso);
        Sessao sessao = ingresso.getSessao();
        if (sessao != null) {
            // Remove o ingresso da lista de ingressos da própria sessão
            sessao.getIngressos().remove(ingresso);
            // Atualiza a contagem de ingressos vendidos na sessão
            sessao.setIngressosVendidos(sessao.getIngressos().size()); 
        }
    }
}