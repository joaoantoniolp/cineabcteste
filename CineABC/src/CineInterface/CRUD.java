package CineInterface;

import controle.CineCRUD;
import modelos.Filme;
import modelos.Sala;
import modelos.Sessao;
import modelos.Ingresso;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CRUD implements CineCRUD {
    private List<Filme> filmes = new ArrayList<>();
    private List<Sala> salas = new ArrayList<>();
    private List<Sessao> sessoes = new ArrayList<>();
    private List<Ingresso> ingressos = new ArrayList<>();
    private final String ARQUIVO_DADOS = System.getProperty("user.dir") + "/dados/dados.txt"; // Caminho dinâmico
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); // Alinhado com CinePersistence
    private static final Logger LOGGER = Logger.getLogger(CRUD.class.getName());

    public CRUD() {
        carregarDados();
    }

    @Override
    public void criarFilme(Filme filme) {
        if (filme != null) {
            filmes.add(filme);
            salvarDados();
        }
    }

    @Override
    public Filme lerFilme(int id) {
        return filmes.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void atualizarFilme(Filme filme) {
        Filme existente = lerFilme(filme.getId());
        if (existente != null) {
            existente.setTitulo(filme.getTitulo());
            existente.setGenero(filme.getGenero());
            existente.setDuracao(filme.getDuracao());
            existente.setClassificacao(filme.getClassificacao());
            salvarDados();
        }
    }

    @Override
    public void excluirFilme(int id) {
        filmes.removeIf(f -> f.getId() == id);
        salvarDados();
    }

    @Override
    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes);
    }

    @Override
    public void criarSala(Sala sala) {
        if (sala != null) {
            salas.add(sala);
            salvarDados();
        }
    }

    @Override
    public Sala lerSala(int numero) {
        return salas.stream().filter(s -> s.getNumero() == numero).findFirst().orElse(null);
    }

    @Override
    public void atualizarSala(Sala sala) {
        Sala existente = lerSala(sala.getNumero());
        if (existente != null) {
            existente.setCapacidade(sala.getCapacidade());
            existente.setTipo(sala.getTipo());
            salvarDados();
        }
    }

    @Override
    public void excluirSala(int numero) {
        salas.removeIf(s -> s.getNumero() == numero);
        salvarDados();
    }

    @Override
    public List<Sala> listarSalas() {
        return new ArrayList<>(salas);
    }

    @Override
    public void criarSessao(Sessao sessao) {
        if (sessao != null) {
            sessoes.add(sessao);
            salvarDados();
        }
    }

    @Override
    public Sessao lerSessao(int id) {
        return sessoes.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void atualizarSessao(Sessao sessao) {
        Sessao existente = lerSessao(sessao.getId());
        if (existente != null) {
            existente.setFilme(sessao.getFilme());
            existente.setSala(sessao.getSala());
            existente.setDataHora(sessao.getDataHora());
            existente.setPreco(sessao.getPreco());
            salvarDados();
        }
    }

    @Override
    public void excluirSessao(int id) {
        sessoes.removeIf(s -> s.getId() == id);
        salvarDados();
    }

    @Override
    public List<Sessao> listarSessoes() {
        return new ArrayList<>(sessoes);
    }

    @Override
    public void criarIngresso(Ingresso ingresso) {
        if (ingresso != null) {
            ingressos.add(ingresso);
            salvarDados();
        }
    }

    @Override
    public Ingresso lerIngresso(int id) {
        return ingressos.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void atualizarIngresso(Ingresso ingresso) {
        Ingresso existente = lerIngresso(ingresso.getId());
        if (existente != null) {
            existente.setSessao(ingresso.getSessao());
            existente.setAssento(ingresso.getAssento());
            existente.setPreco(ingresso.getPreco());
            existente.setNomeCliente(ingresso.getNomeCliente());
            salvarDados();
        }
    }

    @Override
    public void excluirIngresso(int id) {
        ingressos.removeIf(i -> i.getId() == id);
        salvarDados();
    }

    @Override
    public List<Ingresso> listarIngressos() {
        return new ArrayList<>(ingressos);
    }

    private void carregarDados() {
        File file = new File(ARQUIVO_DADOS);
        if (!file.exists()) {
            try {
                File parentDir = file.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Erro ao criar arquivo de dados: {0}", e.getMessage());
            }
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            String secao = null;
            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;
                if (linha.startsWith("[")) {
                    secao = linha;
                    continue;
                }
                String[] partes = linha.split("\\|"); // Alinhado com CinePersistence
                try {
                    switch (secao) {
                        case "[Filmes]":
                            if (partes.length >= 4) {
                                Filme filme = new Filme();
                                filme.setId(Integer.parseInt(partes[0]));
                                filme.setTitulo(partes[1]);
                                filme.setDuracao(Integer.parseInt(partes[2]));
                                filme.setGenero(partes[3]);
                                filmes.add(filme);
                            }
                            break;
                        case "[Salas]":
                            if (partes.length >= 2) {
                                Sala sala = new Sala();
                                sala.setNumero(Integer.parseInt(partes[0]));
                                sala.setCapacidade(Integer.parseInt(partes[1]));
                                salas.add(sala);
                            }
                            break;
                        case "[Sessoes]":
                            if (partes.length >= 5) {
                                Sessao sessao = new Sessao();
                                sessao.setId(Integer.parseInt(partes[0]));
                                int filmeId = Integer.parseInt(partes[1]);
                                int salaNumero = Integer.parseInt(partes[2]);
                                LocalDateTime dataHora = LocalDateTime.parse(partes[3], FORMATTER);
                                sessao.setDataHora(dataHora);
                                sessao.setIngressosVendidos(Integer.parseInt(partes[4]));
                                sessao.setPreco(partes.length > 5 ? Double.parseDouble(partes[5]) : 0.0);
                                Filme filmeSessao = lerFilme(filmeId);
                                Sala salaSessao = lerSala(salaNumero);
                                if (filmeSessao != null && salaSessao != null) {
                                    sessao.setFilme(filmeSessao);
                                    sessao.setSala(salaSessao);
                                    sessoes.add(sessao);
                                } else {
                                    LOGGER.warning("Sessão ignorada: Filme ou Sala não encontrados - " + linha);
                                }
                            }
                            break;
                        case "[Ingressos]":
                            if (partes.length >= 6) {
                                Ingresso ingresso = new Ingresso();
                                ingresso.setId(Integer.parseInt(partes[0]));
                                int sessaoId = Integer.parseInt(partes[1]);
                                ingresso.setTipoIngresso(partes[2]);
                                ingresso.setPreco(Double.parseDouble(partes[3]));
                                ingresso.setAssento(partes[4]);
                                ingresso.setNomeCliente(partes[5]);
                                Sessao sessaoIngresso = lerSessao(sessaoId);
                                if (sessaoIngresso != null) {
                                    ingresso.setSessao(sessaoIngresso);
                                    ingressos.add(ingresso);
                                } else {
                                    LOGGER.warning("Ingresso ignorado: Sessão não encontrada - " + linha);
                                }
                            }
                            break;
                        default:
                            LOGGER.warning("Seção desconhecida: " + secao);
                    }
                } catch (Exception e) {
                    LOGGER.warning("Erro ao parsear linha: " + linha + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar dados: {0}", e.getMessage());
        }
    }

    private void salvarDados() {
        File file = new File(ARQUIVO_DADOS);
        try {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("[Filmes]\n");
                for (Filme filme : filmes) {
                    writer.write(String.format("%d|%s|%d|%s\n", filme.getId(), filme.getTitulo(), filme.getDuracao(), filme.getGenero()));
                }
                writer.write("\n[Salas]\n");
                for (Sala sala : salas) {
                    writer.write(String.format("%d|%d\n", sala.getNumero(), sala.getCapacidade()));
                }
                writer.write("\n[Sessoes]\n");
                for (Sessao sessao : sessoes) {
                    writer.write(String.format("%d|%d|%d|%s|%d|%.2f\n", sessao.getId(), sessao.getFilme().getId(),
                            sessao.getSala().getNumero(), sessao.getDataHora().format(FORMATTER),
                            sessao.getIngressosVendidos(), sessao.getPreco()));
                }
                writer.write("\n[Ingressos]\n");
                for (Ingresso ingresso : ingressos) {
                    writer.write(String.format("%d|%d|%s|%.2f|%s|%s\n", ingresso.getId(), ingresso.getSessao().getId(),
                            ingresso.getTipoIngresso(), ingresso.getPreco(), ingresso.getAssento(), ingresso.getNomeCliente()));
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar dados: {0}", e.getMessage());
        }
    }
}