package persistencia;

import modelos.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.*;
import java.util.stream.Collectors;

public class CinePersistence {
    private static final String ARQUIVO_DADOS = System.getProperty("user.dir") + "./src/dados/dados.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final Logger LOGGER = Logger.getLogger(CinePersistence.class.getName());

    public void salvarDados(CineAbc cinema) {
        File file = new File(ARQUIVO_DADOS);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            // Comentário inicial
            writer.println("# Arquivo de dados do Cine ABC");
            writer.println("# Formato: [Seção] seguido por registros com campos separados por |");
            writer.println();

            // Filmes
            writer.println("[Filmes]");
            writer.println("# ID  | Título                     | Duração | Gênero                    ");
            writer.println("#-----|----------------------------|---------|---------------------------");
            for (Filme filme : cinema.getFilmes()) {
                if (filme != null) {
                    writer.printf("%-5d| %-26s | %-7d | %-25s%n",
                            filme.getId(),
                            truncate(filme.getTitulo(), 26),
                            filme.getDuracao(),
                            truncate(filme.getGenero(), 25));
                }
            }

            // Salas
            writer.println();
            writer.println("[Salas]");
            writer.println("# Número | Capacidade | Tipo        | Ativa ");
            writer.println("#--------|------------|-------------|-------");
            for (Sala sala : cinema.getSalas()) {
                if (sala != null) {
                    writer.printf("%-7d| %-11d | %-12s| %-6b%n",
                            sala.getNumero(),
                            sala.getCapacidade(),
                            truncate(sala.getTipo(), 12),
                            sala.isAtiva());
                }
            }

            // Sessões
            writer.println();
            writer.println("[Sessoes]");
            writer.println("# ID  | Filme ID | Sala Nº | Data/Hora          | Ingressos Vendidos | Preço   ");
            writer.println("#-----|----------|---------|--------------------|--------------------|---------");
            for (Sessao sessao : cinema.getSessoes()) {
                if (sessao != null && sessao.getFilme() != null && sessao.getSala() != null) {
                    writer.printf("%-5d| %-9d| %-8d| %-19s| %-19d| %-8.2f%n",
                            sessao.getId(),
                            sessao.getFilme().getId(),
                            sessao.getSala().getNumero(),
                            sessao.getDataHora().format(FORMATTER),
                            sessao.getIngressosVendidos(),
                            sessao.getPreco());
                }
            }

            // Ingressos
            writer.println();
            writer.println("[Ingressos]");
            writer.println("# ID  | Sessão ID | Tipo       | Preço   | Assento | Nome Cliente               ");
            writer.println("#-----|-----------|------------|---------|---------|----------------------------");
            for (Ingresso ingresso : cinema.getIngressos()) {
                if (ingresso != null && ingresso.getSessao() != null) {
                    writer.printf("%-5d| %-10d| %-11s| %-8.2f| %-8s| %-26s%n",
                            ingresso.getId(),
                            ingresso.getSessao().getId(),
                            truncate(ingresso.getTipoIngresso(), 11),
                            ingresso.getPreco(),
                            truncate(ingresso.getAssento(), 8),
                            truncate(ingresso.getNomeCliente(), 26));
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar dados: {0}", e.getMessage());
            throw new RuntimeException("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public CineAbc carregarDados() {
        CineAbc cinema = new CineAbc();
        File file = new File(ARQUIVO_DADOS);

        if (!file.exists()) {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) parentDir.mkdirs();
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                writer.println("# Arquivo de dados do Cine ABC");
                writer.println("# Formato: [Seção] seguido por registros com campos separados por |");
                writer.println();
                writer.println("[Filmes]");
                writer.println("# ID  | Título                     | Duração | Gênero                    ");
                writer.println("#-----|----------------------------|---------|---------------------------");
                writer.println();
                writer.println("[Salas]");
                writer.println("# Número | Capacidade | Tipo        | Ativa ");
                writer.println("#--------|------------|-------------|-------");
                writer.println();
                writer.println("[Sessoes]");
                writer.println("# ID  | Filme ID | Sala Nº | Data/Hora          | Ingressos Vendidos | Preço   ");
                writer.println("#-----|----------|---------|--------------------|--------------------|---------");
                writer.println();
                writer.println("[Ingressos]");
                writer.println("# ID  | Sessão ID | Tipo       | Preço   | Assento | Nome Cliente               ");
                writer.println("#-----|-----------|------------|---------|---------|----------------------------");
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Erro ao criar arquivo: {0}", e.getMessage());
            }
            return cinema;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            String secao = "";
            List<Filme> filmes = new ArrayList<>();
            List<Sala> salas = new ArrayList<>();
            List<Sessao> sessoes = new ArrayList<>();
            List<Ingresso> ingressos = new ArrayList<>();
            Set<Integer> idsFilmes = new HashSet<>();
            Set<Integer> idsSalas = new HashSet<>();
            Set<Integer> idsSessoes = new HashSet<>();
            Set<Integer> idsIngressos = new HashSet<>();

            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty() || linha.startsWith("#")) continue; // Ignora linhas vazias, comentários e cabeçalhos
                if (linha.startsWith("[")) {
                    secao = linha;
                    continue;
                }
                if (linha.matches("-+.*")) continue; // Ignora separadores

                String[] p = linha.split("\\|");
                for (int i = 0; i < p.length; i++) {
                    p[i] = p[i].trim();
                }

                try {
                    switch (secao) {
                        case "[Filmes]":
                            if (p.length == 4) {
                                int id = Integer.parseInt(p[0]);
                                if (!idsFilmes.add(id)) continue; // Ignora duplicatas
                                Filme f = new Filme();
                                f.setId(id);
                                f.setTitulo(p[1]);
                                f.setDuracao(Integer.parseInt(p[2]));
                                f.setGenero(p[3]);
                                filmes.add(f);
                            }
                            break;
                        case "[Salas]":
                            if (p.length == 4) {
                                int numero = Integer.parseInt(p[0]);
                                if (!idsSalas.add(numero)) continue; // Ignora duplicatas
                                Sala s = new Sala();
                                s.setNumero(numero);
                                s.setCapacidade(Integer.parseInt(p[1]));
                                s.setTipo(p[2]);
                                s.setAtiva(Boolean.parseBoolean(p[3]));
                                salas.add(s);
                            }
                            break;
                        case "[Sessoes]":
                            if (p.length == 6) {
                                int id = Integer.parseInt(p[0]);
                                if (!idsSessoes.add(id)) continue; // Ignora duplicatas
                                Sessao s = new Sessao();
                                s.setId(id);
                                s.setDataHora(LocalDateTime.parse(p[3], FORMATTER));
                                s.setIngressosVendidos(Integer.parseInt(p[4]));
                                s.setPreco(Double.parseDouble(p[5]));
                                Filme f = filmes.stream().filter(fil -> fil.getId() == Integer.parseInt(p[1])).findFirst().orElse(null);
                                Sala sa = salas.stream().filter(sal -> sal.getNumero() == Integer.parseInt(p[2])).findFirst().orElse(null);
                                if (f != null && sa != null) {
                                    s.setFilme(f);
                                    s.setSala(sa);
                                    sessoes.add(s);
                                } else {
                                    LOGGER.log(Level.WARNING, "Sessão ignorada: {0}", linha);
                                }
                            }
                            break;
                        case "[Ingressos]":
                            if (p.length == 6) {
                                int id = Integer.parseInt(p[0]);
                                if (!idsIngressos.add(id)) continue; // Ignora duplicatas
                                Ingresso i = new Ingresso();
                                i.setId(id);
                                i.setTipoIngresso(p[2]);
                                i.setPreco(Double.parseDouble(p[3]));
                                i.setAssento(p[4]);
                                i.setNomeCliente(p[5]);
                                Sessao ss = sessoes.stream().filter(ses -> ses.getId() == Integer.parseInt(p[1])).findFirst().orElse(null);
                                if (ss != null) {
                                    i.setSessao(ss);
                                    ingressos.add(i);
                                } else {
                                    LOGGER.log(Level.WARNING, "Ingresso ignorado: {0}", linha);
                                }
                            }
                            break;
                    }
                } catch (Exception e) {
                    LOGGER.log(Level.WARNING, "Linha ignorada: {0} - {1}", new Object[]{linha, e.getMessage()});
                }
            }

            cinema.setFilmes(filmes);
            cinema.setSalas(salas);
            cinema.setSessoes(sessoes);
            cinema.setIngressos(ingressos);

            for (Sessao s : sessoes) {
                List<Ingresso> ins = ingressos.stream()
                        .filter(i -> i.getSessao() != null && i.getSessao().getId() == s.getId())
                        .collect(Collectors.toList());
                s.setIngressos(ins);
                s.setIngressosVendidos(ins.size());
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar dados: {0}", e.getMessage());
            throw new RuntimeException("Erro ao carregar dados: " + e.getMessage());
        }

        return cinema;
    }

    // Método auxiliar para truncar strings e evitar quebra de formatação
    private String truncate(String str, int maxLength) {
        if (str == null) return "";
        str = str.replace("\n", " ").replace("|", "-"); // Evita quebras de linha e separadores
        return str.length() > maxLength ? str.substring(0, maxLength) : str;
    }
}