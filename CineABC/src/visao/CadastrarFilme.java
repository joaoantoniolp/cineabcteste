package visao;

import controle.FilmeCadastro;
import modelos.CineAbc;
import modelos.Filme;
import javax.swing.JOptionPane;

public class CadastrarFilme extends javax.swing.JFrame {
    private CineAbc cinema;
    private FilmeCadastro filmeCadastro;
    private TelaPrincipal telaPrincipal;

    public CadastrarFilme(CineAbc cinema, TelaPrincipal telaPrincipal) {
        this.cinema = cinema;
        this.filmeCadastro = new FilmeCadastro(cinema);
        this.telaPrincipal = telaPrincipal;
        initComponents();
        setLocationRelativeTo(null);
    }

    // Construtor privado para evitar que seja chamado sem os parâmetros necessários
    // Deixei o corpo vazio, mas é melhor removê-lo se não for intencional chamar new CadastrarFilme()
    private CadastrarFilme() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean isNumeric(String str) {
        return str != null && !str.trim().isEmpty() && str.matches("\\d+");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtoncadastrarFilme = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldGenero = new javax.swing.JTextField();
        jTextFieldDuracao = new javax.swing.JTextField();
        jTextFieldClassificacao = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelDuracao = new javax.swing.JLabel();
        jLabelClassificacao = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtoncadastrarFilme.setBackground(new java.awt.Color(0, 204, 204));
        jButtoncadastrarFilme.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jButtoncadastrarFilme.setForeground(new java.awt.Color(0, 102, 102));
        jButtoncadastrarFilme.setText("Cadastrar Filme");
        jButtoncadastrarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncadastrarFilmeActionPerformed(evt);
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

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabelTitulo.setText("Cadastrar De Filme");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/claquete.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabelNome.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelNome.setText("Nome");

        jLabelGenero.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelGenero.setText("Gênero");

        jLabelDuracao.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelDuracao.setText("Duração");

        jLabelClassificacao.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelClassificacao.setText("Classificação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addGap(352, 352, 352)
                        .addComponent(jButtoncadastrarFilme)
                        .addGap(171, 171, 171))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTitulo))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelClassificacao)
                                            .addComponent(jLabelDuracao))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(27, 27, 27)
                        .addComponent(jButtonVoltar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGenero)
                    .addComponent(jButtoncadastrarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelDuracao)
                        .addComponent(jTextFieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClassificacao)
                    .addComponent(jTextFieldClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtoncadastrarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncadastrarFilmeActionPerformed
try {
        String titulo = jTextFieldNome.getText();
        String genero = jTextFieldGenero.getText();
        String duracaoStr = jTextFieldDuracao.getText();
        String classificacaoStr = jTextFieldClassificacao.getText();

        if (titulo.isEmpty() || genero.isEmpty() || !isNumeric(duracaoStr) || !isNumeric(classificacaoStr)) {
            throw new Exception("Preencha todos os campos com valores válidos!");
        }

        int duracao = Integer.parseInt(duracaoStr);
        int classificacao = Integer.parseInt(classificacaoStr);

        Filme filme = new Filme(titulo, genero, duracao, classificacao);
        filmeCadastro.cadastrarFilme(filme);
        telaPrincipal.invokeSalvarDados(); // Salvar após cadastrar
        JOptionPane.showMessageDialog(this, "Filme cadastrado com sucesso!");
        dispose();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar filme: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButtoncadastrarFilmeActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JButton jButtoncadastrarFilme;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelClassificacao;
    private javax.swing.JLabel jLabelDuracao;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldClassificacao;
    private javax.swing.JTextField jTextFieldDuracao;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
