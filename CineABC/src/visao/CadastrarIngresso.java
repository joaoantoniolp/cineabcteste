package visao;

import controle.IngressoCadastro;
import controle.SessaoCadastro;
import modelos.*;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;

public class CadastrarIngresso extends javax.swing.JFrame {
    private CineAbc cinema;
    private IngressoCadastro ingressoCadastro;
    private SessaoCadastro sessaoCadastro; // Não é estritamente necessário aqui, cinema já dá acesso
    private TelaPrincipal telaPrincipal;

    public CadastrarIngresso(CineAbc cinema, TelaPrincipal telaPrincipal) {
        this.cinema = cinema;
        this.ingressoCadastro = new IngressoCadastro(cinema);
        this.sessaoCadastro = new SessaoCadastro(cinema); // Apenas para consistência se fosse usado
        this.telaPrincipal = telaPrincipal;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Alterado para DISPOSE_ON_CLOSE
    }

    private boolean isNumeric(String str) {
        return str != null && !str.trim().isEmpty() && str.matches("\\d+");
    }

    private boolean isValidPoltrona(String poltrona) {
        // Aceita formatos como A1, B10, Z99, etc.
        return poltrona != null && !poltrona.trim().isEmpty() && poltrona.matches("[A-Za-z]\\d+");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNomeCliente = new javax.swing.JLabel();
        jTextFieldSessao = new javax.swing.JTextField();
        jLabelPoltrona = new javax.swing.JLabel();
        jButtoncadastrarIngresso = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jTextFieldPoltrona = new javax.swing.JTextField();
        jLabelSessão = new javax.swing.JLabel();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jLabelTipoIngresso = new javax.swing.JLabel();
        jTextFieldTipoIngresso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("Cadastro De Ingresso");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/claquete.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabelNomeCliente.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelNomeCliente.setText("Nome do Cliente");

        jLabelPoltrona.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelPoltrona.setText("Poltrona");

        jButtoncadastrarIngresso.setBackground(new java.awt.Color(0, 204, 204));
        jButtoncadastrarIngresso.setFont(new java.awt.Font("Helvetica Neue", 3, 26)); // NOI18N
        jButtoncadastrarIngresso.setForeground(new java.awt.Color(0, 102, 102));
        jButtoncadastrarIngresso.setText("Cadastrar Ingresso");
        jButtoncadastrarIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncadastrarIngressoActionPerformed(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(0, 204, 204));
        jButtonVoltar.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(0, 102, 102));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabelSessão.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelSessão.setText("Sessão");

        jLabelTipoIngresso.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelTipoIngresso.setText("Tipo de Ingresso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPoltrona)
                            .addComponent(jLabelSessão)
                            .addComponent(jLabelTipoIngresso))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPoltrona, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(jButtoncadastrarIngresso))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(151, 151, 151)
                                        .addComponent(jButtonVoltar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTipoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNomeCliente)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNomeCliente)
                            .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessão)
                            .addComponent(jTextFieldSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPoltrona)
                            .addComponent(jTextFieldPoltrona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipoIngresso)
                            .addComponent(jTextFieldTipoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtoncadastrarIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVoltar)
                        .addGap(43, 43, 43)))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtoncadastrarIngressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncadastrarIngressoActionPerformed
  try {
            String sessaoIdStr = jTextFieldSessao.getText();
            String poltrona = jTextFieldPoltrona.getText();
            String nomeCliente = jTextFieldNomeCliente.getText();
            String tipoIngresso = jTextFieldTipoIngresso.getText().trim();

            if (!isNumeric(sessaoIdStr) || !isValidPoltrona(poltrona) || nomeCliente.trim().isEmpty() || tipoIngresso.isEmpty()) {
                throw new Exception("Preencha todos os campos com valores válidos! Poltrona deve ser no formato letra+número (ex.: A1).");
            }

            if (!tipoIngresso.equalsIgnoreCase("Inteira") && !tipoIngresso.equalsIgnoreCase("Meia")) {
                throw new Exception("Tipo de ingresso deve ser 'Inteira' ou 'Meia'.");
            }

            int sessaoId = Integer.parseInt(sessaoIdStr);

            Sessao sessao = cinema.getSessoes().stream()
                .filter(s -> s.getId() == sessaoId)
                .findFirst()
                .orElseThrow(() -> new Exception("Sessão não encontrada"));

            if (sessao.getIngressosDisponiveis() <= 0) {
                throw new Exception("Não há ingressos disponíveis para esta sessão!");
            }

            if (sessao.getIngressos().stream().anyMatch(i -> i.getAssento().equalsIgnoreCase(poltrona))) {
                throw new Exception("Poltrona " + poltrona + " já está ocupada!");
            }

            double precoSessao = sessao.getPreco();
            if (precoSessao <= 0) {
                throw new Exception("Preço da sessão inválido!");
            }
            double preco = tipoIngresso.equalsIgnoreCase("Meia") ? precoSessao / 2 : precoSessao;

            // Assumindo que Ingresso tem um construtor com ID gerado automaticamente
            Ingresso ingresso = new Ingresso();
            ingresso.setSessao(sessao);
            ingresso.setAssento(poltrona);
            ingresso.setPreco(preco);
            ingresso.setNomeCliente(nomeCliente);
            ingresso.setTipoIngresso(tipoIngresso);

            ingressoCadastro.cadastrarIngresso(ingresso);

            telaPrincipal.atualizarTabela();
            telaPrincipal.invokeSalvarDados();

            JOptionPane.showMessageDialog(this, "Ingresso cadastrado com sucesso!");
            dispose(); // Fecha a janela após sucesso
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar ingresso: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtoncadastrarIngressoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
       dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarIngresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarIngresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarIngresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarIngresso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarIngresso(new CineAbc(), new TelaPrincipal()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JButton jButtoncadastrarIngresso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNomeCliente;
    private javax.swing.JLabel jLabelPoltrona;
    private javax.swing.JLabel jLabelSessão;
    private javax.swing.JLabel jLabelTipoIngresso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldNomeCliente;
    private javax.swing.JTextField jTextFieldPoltrona;
    private javax.swing.JTextField jTextFieldSessao;
    private javax.swing.JTextField jTextFieldTipoIngresso;
    // End of variables declaration//GEN-END:variables
}
