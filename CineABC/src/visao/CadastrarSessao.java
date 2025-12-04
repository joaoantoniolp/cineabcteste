package visao;

import controle.*;
import modelos.*;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException; // Importar para tratamento de erro de parsing

public class CadastrarSessao extends javax.swing.JFrame {
    private CineAbc cinema;
    private SessaoCadastro sessaoCadastro;
    private FilmeCadastro filmeCadastro; // Não é estritamente necessário aqui, cinema já dá acesso
    private SalaCadastro salaCadastro;   // Não é estritamente necessário aqui, cinema já dá acesso
    private TelaPrincipal telaPrincipal;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public CadastrarSessao(CineAbc cinema, TelaPrincipal telaPrincipal) {
        this.cinema = cinema;
        this.sessaoCadastro = new SessaoCadastro(cinema);
        this.filmeCadastro = new FilmeCadastro(cinema); // Apenas para consistência se fosse usado
        this.salaCadastro = new SalaCadastro(cinema);   // Apenas para consistência se fosse usado
        this.telaPrincipal = telaPrincipal;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Alterado para DISPOSE_ON_CLOSE
    }

    private boolean isNumeric(String str) {
        return str != null && !str.trim().isEmpty() && str.matches("\\d+");
    }

    private boolean isDouble(String str) {
        return str != null && !str.trim().isEmpty() && str.matches("\\d+(\\.\\d+)?");
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSala = new javax.swing.JTextField();
        jLabelSala = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabelHora = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelFilme = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldFilme = new javax.swing.JTextField();
        jTextFieldHora = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/claquete.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("Cadastro De Sessão");

        jLabelSala.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelSala.setText("Sala");

        jLabelHora.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelHora.setText("Hora");

        jLabelFilme.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelFilme.setText("Filme");

        jLabelData.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelData.setText("Data");

        jButtonCadastrar.setBackground(new java.awt.Color(0, 204, 204));
        jButtonCadastrar.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jButtonCadastrar.setForeground(new java.awt.Color(0, 102, 102));
        jButtonCadastrar.setText("Cadastrar Sessão");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabelPreco.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabelPreco.setText("Preço");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelData)
                                .addComponent(jLabelSala)
                                .addComponent(jLabelFilme)
                                .addComponent(jLabelHora))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelPreco)
                                .addGap(8, 8, 8)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(144, 144, 144)
                                        .addComponent(jButtonVoltar))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldSala, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(jButtonCadastrar))
                                    .addComponent(jTextFieldFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabelFilme))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelSala)
                                    .addComponent(jTextFieldSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonCadastrar))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelData)
                                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonVoltar)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHora)
                            .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreco)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
    try {
            String filmeIdStr = jTextFieldFilme.getText();
            String salaNumeroStr = jTextFieldSala.getText();
            String precoStr = jTextFieldPreco.getText();
            String dataHoraStr = jTextFieldData.getText() + " " + jTextFieldHora.getText();

            if (!isNumeric(filmeIdStr) || !isNumeric(salaNumeroStr) || !isDouble(precoStr) || 
                jTextFieldData.getText().isEmpty() || jTextFieldHora.getText().isEmpty()) {
                throw new Exception("Preencha todos os campos com valores válidos!");
            }

            int filmeId = Integer.parseInt(filmeIdStr);
            int salaNumero = Integer.parseInt(salaNumeroStr);
            double preco = Double.parseDouble(precoStr);

            if (preco <= 0) { // Ajustado
                throw new Exception("O preço deve ser maior que 0!");
            }

            LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, FORMATTER);

            Filme filme = cinema.getFilmes().stream()
                .filter(f -> f.getId() == filmeId)
                .findFirst()
                .orElseThrow(() -> new Exception("Filme não encontrado"));

            Sala sala = cinema.getSalas().stream()
                .filter(s -> s.getNumero() == salaNumero)
                .findFirst()
                .orElseThrow(() -> new Exception("Sala não encontrada"));

            Sessao sessao = new Sessao(filme, sala, dataHora, preco);
            sessaoCadastro.cadastrarSessao(sessao);
            telaPrincipal.atualizarTabela();
            JOptionPane.showMessageDialog(this, "Sessão cadastrada com sucesso!");
            dispose();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar sessão: " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarSessao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarSessao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarSessao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarSessao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Ao rodar diretamente esta tela, criamos instâncias dummy de CineAbc e TelaPrincipal
                new CadastrarSessao(new CineAbc(), new TelaPrincipal()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelFilme;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelSala;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldFilme;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldSala;
    // End of variables declaration//GEN-END:variables
}
