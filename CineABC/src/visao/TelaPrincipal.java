package visao;

import persistencia.CinePersistence;
import controle.SessaoCadastro;
import modelos.CineAbc;
import modelos.Sessao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import modelos.Filme;

public class TelaPrincipal extends javax.swing.JFrame {
    private final CineAbc cinema;
    private final SessaoCadastro sessaoCadastro;
    private final CinePersistence persistence;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public TelaPrincipal() {
        this.persistence = new CinePersistence();
        CineAbc loadedCinema;
        try {
            loadedCinema = persistence.carregarDados();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados do arquivo: " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            loadedCinema = new CineAbc();
        }
        this.cinema = loadedCinema;
        this.sessaoCadastro = new SessaoCadastro(cinema);
        initComponents();
        configurarTabela();
        atualizarTabela();
        setLocationRelativeTo(null);
        verificarDadosIniciais();
    }

    private void configurarTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Filme", "Sala", "Data/Hora", "Ingressos Vendidos"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabela não editável
            }
        };
        jTableTabela.setModel(model);
    }

    private void verificarDadosIniciais() {
        if (cinema.getSessoes().isEmpty() && cinema.getFilmes().isEmpty() && cinema.getSalas().isEmpty() && cinema.getIngressos().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum dado encontrado. Cadastre filmes, salas, sessões ou ingressos para começar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void invokeSalvarDados() {
        try {
            persistence.salvarDados(cinema);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) jTableTabela.getModel();
        model.setRowCount(0); // Limpa a tabela
        List<Sessao> sessoes = sessaoCadastro.listarSessoes();
        for (Sessao sessao : sessoes) {
            String filmeTitulo = sessao.getFilme() != null ? sessao.getFilme().getTitulo() : "N/A";
            String salaNumero = sessao.getSala() != null ? String.valueOf(sessao.getSala().getNumero()) : "N/A";
            String dataHora = sessao.getDataHora() != null ? sessao.getDataHora().format(FORMATTER) : "N/A";
            model.addRow(new Object[]{
                    filmeTitulo,
                    salaNumero,
                    dataHora,
                    sessao.getIngressosVendidos()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButtoncadastrarFilme = new javax.swing.JButton();
        jButtoncadastrarSessao = new javax.swing.JButton();
        jButtoncadastrarSala = new javax.swing.JButton();
        jButtonexcluirSessao = new javax.swing.JButton();
        jButtoncadastrarIngresso = new javax.swing.JButton();
        jButtonEstatisticas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelFilme = new javax.swing.JLabel();
        jLabelSessao = new javax.swing.JLabel();
        jLabelSala = new javax.swing.JLabel();
        jLabelIngresso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filme", "Sala", "Sessão", "Ingresso"
            }
        ));
        jTableTabela.setColumnSelectionAllowed(true);
        jTableTabela.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableTabelaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTableTabela);
        jTableTabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Butões De Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 18))); // NOI18N

        jButtoncadastrarFilme.setFont(new java.awt.Font("Yu Gothic UI", 3, 15)); // NOI18N
        jButtoncadastrarFilme.setText("Cadastrar Filme");
        jButtoncadastrarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncadastrarFilmeActionPerformed(evt);
            }
        });

        jButtoncadastrarSessao.setFont(new java.awt.Font("Yu Gothic UI", 3, 15)); // NOI18N
        jButtoncadastrarSessao.setText("Cadastrar Sessão");
        jButtoncadastrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncadastrarSessaoActionPerformed(evt);
            }
        });

        jButtoncadastrarSala.setFont(new java.awt.Font("Yu Gothic UI", 3, 15)); // NOI18N
        jButtoncadastrarSala.setText("Cadastrar  Sala");
        jButtoncadastrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncadastrarSalaActionPerformed(evt);
            }
        });

        jButtonexcluirSessao.setFont(new java.awt.Font("Yu Gothic UI", 3, 15)); // NOI18N
        jButtonexcluirSessao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excluir.png"))); // NOI18N
        jButtonexcluirSessao.setText("Excluir Sessão");
        jButtonexcluirSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonexcluirSessaoActionPerformed(evt);
            }
        });

        jButtoncadastrarIngresso.setFont(new java.awt.Font("Yu Gothic UI", 3, 15)); // NOI18N
        jButtoncadastrarIngresso.setText("Cadastrar  Ingresso");
        jButtoncadastrarIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncadastrarIngressoActionPerformed(evt);
            }
        });

        jButtonEstatisticas.setFont(new java.awt.Font("Yu Gothic UI", 3, 15)); // NOI18N
        jButtonEstatisticas.setText("Estatística de Vendas");
        jButtonEstatisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstatisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtoncadastrarFilme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtoncadastrarSessao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEstatisticas, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtoncadastrarSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtoncadastrarIngresso, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jButtonexcluirSessao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtoncadastrarFilme, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jButtoncadastrarSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtoncadastrarSessao, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(jButtoncadastrarIngresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonexcluirSessao, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jButtonEstatisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CINEMA ABC");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/claquete.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cadastros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 18))); // NOI18N

        jLabelFilme.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabelFilme.setText("Cadastrar Filme");

        jLabelSessao.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabelSessao.setText("Cadastrar Sessão");

        jLabelSala.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabelSala.setText("Cadastrar Sala");

        jLabelIngresso.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabelIngresso.setText("Cadastrar Ingresso");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIngresso)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelSala, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelSessao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelFilme)
                .addGap(28, 28, 28)
                .addComponent(jLabelSala)
                .addGap(28, 28, 28)
                .addComponent(jLabelSessao)
                .addGap(29, 29, 29)
                .addComponent(jLabelIngresso)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jButtoncadastrarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncadastrarFilmeActionPerformed
        new CadastrarFilme(cinema, this).setVisible(true);
        invokeSalvarDados();
        atualizarTabela();
    }//GEN-LAST:event_jButtoncadastrarFilmeActionPerformed

    private void jButtoncadastrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncadastrarSalaActionPerformed
        new CadastrarSala(cinema, this).setVisible(true);
        invokeSalvarDados();
        atualizarTabela();
    }//GEN-LAST:event_jButtoncadastrarSalaActionPerformed

    private void jButtoncadastrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncadastrarSessaoActionPerformed
        new CadastrarSessao(cinema, this).setVisible(true);
        invokeSalvarDados();
        atualizarTabela();
    }//GEN-LAST:event_jButtoncadastrarSessaoActionPerformed

    private void jButtoncadastrarIngressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncadastrarIngressoActionPerformed
        new CadastrarIngresso(cinema, this).setVisible(true);
        invokeSalvarDados();
        atualizarTabela();
    }//GEN-LAST:event_jButtoncadastrarIngressoActionPerformed

    private void jButtonEstatisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstatisticasActionPerformed
        StringBuilder relatorio = new StringBuilder("=== Relatório de Estatísticas de Vendas ===\n\n");

        List<Sessao> sessoes = cinema.getSessoes();
        if (sessoes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há sessões cadastradas para gerar estatísticas!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // 1. Filme com mais ingressos vendidos
        Map<Filme, Integer> ingressosPorFilme = new HashMap<>();
        int totalIngressos = 0;

        for (Sessao sessao : sessoes) {
            int ingressosVendidos = sessao.getIngressosVendidos();
            Filme filme = sessao.getFilme();
            ingressosPorFilme.merge(filme, ingressosVendidos, Integer::sum);
            totalIngressos += ingressosVendidos;
        }

        Filme filmeMaisVendido = null;
        int maxIngressosFilme = 0;
        for (Map.Entry<Filme, Integer> entry : ingressosPorFilme.entrySet()) {
            if (entry.getValue() > maxIngressosFilme) {
                filmeMaisVendido = entry.getKey();
                maxIngressosFilme = entry.getValue();
            }
        }
        double percentagemFilme = totalIngressos > 0 ? (maxIngressosFilme * 100.0 / totalIngressos) : 0.0;
        relatorio.append("1. Filme com Mais Ingressos Vendidos:\n");
        relatorio.append(filmeMaisVendido != null
                ? String.format("   - %s: %d ingressos (%.2f%% do total)\n\n", filmeMaisVendido.getTitulo(), maxIngressosFilme, percentagemFilme)
                : "   - Nenhum ingresso vendido.\n\n");

        // 2. Sessão com maior e menor ocupação
        Sessao sessaoMaiorOcupacao = null;
        Sessao sessaoMenorOcupacao = null;
        double maiorPercentagem = -1;
        double menorPercentagem = Double.MAX_VALUE;

        for (Sessao sessao : sessoes) {
            int capacidade = sessao.getSala().getCapacidade();
            int vendidos = sessao.getIngressosVendidos();
            double percentagem = capacidade > 0 ? (vendidos * 100.0 / capacidade) : 0.0;

            if (percentagem > maiorPercentagem) {
                maiorPercentagem = percentagem;
                sessaoMaiorOcupacao = sessao;
            }
            if (percentagem < menorPercentagem) {
                menorPercentagem = percentagem;
                sessaoMenorOcupacao = sessao;
            }
        }

        relatorio.append("2. Ocupação de Poltronas por Sessão:\n");
        if (sessaoMaiorOcupacao != null) {
            int capacidadeMaior = sessaoMaiorOcupacao.getSala().getCapacidade();
            relatorio.append(String.format("   - Maior Ocupação: Sessão ID %d (%s, Sala %d): %d/%d poltronas (%.2f%%)\n",
                    sessaoMaiorOcupacao.getId(), sessaoMaiorOcupacao.getFilme().getTitulo(),
                    sessaoMaiorOcupacao.getSala().getNumero(), sessaoMaiorOcupacao.getIngressosVendidos(),
                    capacidadeMaior, maiorPercentagem));
        } else {
            relatorio.append("   - Nenhuma sessão com ocupação.\n");
        }
        if (sessaoMenorOcupacao != null) {
            int capacidadeMenor = sessaoMenorOcupacao.getSala().getCapacidade();
            relatorio.append(String.format("   - Menor Ocupação: Sessão ID %d (%s, Sala %d): %d/%d poltronas (%.2f%%)\n",
                    sessaoMenorOcupacao.getId(), sessaoMenorOcupacao.getFilme().getTitulo(),
                    sessaoMenorOcupacao.getSala().getNumero(), sessaoMenorOcupacao.getIngressosVendidos(),
                    capacidadeMenor, menorPercentagem));
        } else {
            relatorio.append("   - Nenhuma sessão com ocupação.\n");
        }

        JOptionPane.showMessageDialog(this, relatorio.toString(), "Relatório de Estatísticas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonEstatisticasActionPerformed

    private void jButtonexcluirSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonexcluirSessaoActionPerformed
        int selectedRow = jTableTabela.getSelectedRow();
        if (selectedRow >= 0) {
            Sessao sessao = cinema.getSessoes().get(selectedRow);
            sessaoCadastro.removerSessao(sessao);
            atualizarTabela();
            invokeSalvarDados(); // Salvar após excluir
            JOptionPane.showMessageDialog(this, "Sessão excluída com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma sessão para excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonexcluirSessaoActionPerformed

    private void jTableTabelaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableTabelaAncestorAdded
        atualizarTabela();
    }//GEN-LAST:event_jTableTabelaAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEstatisticas;
    private javax.swing.JButton jButtoncadastrarFilme;
    private javax.swing.JButton jButtoncadastrarIngresso;
    private javax.swing.JButton jButtoncadastrarSala;
    private javax.swing.JButton jButtoncadastrarSessao;
    private javax.swing.JButton jButtonexcluirSessao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFilme;
    private javax.swing.JLabel jLabelIngresso;
    private javax.swing.JLabel jLabelSala;
    private javax.swing.JLabel jLabelSessao;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    // End of variables declaration//GEN-END:variables
}
