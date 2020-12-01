/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.Validacoes;
import apoio.Criptografia;
import javax.swing.JOptionPane;

/**
 *
 * @author roger
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public FrmLogin() {
        initComponents();
        //this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.jpg")).getImage());
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Login:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 190, 60, 24);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLogin(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(340, 240, 50, 40);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSair(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(400, 240, 50, 40);
        jPanel1.add(tfLogin);
        tfLogin.setBounds(110, 190, 120, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Senha:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 190, 70, 24);
        jPanel1.add(pfSenha);
        pfSenha.setBounds(320, 190, 130, 30);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 480, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoSair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSair
        this.dispose();
    }//GEN-LAST:event_BotaoSair

    private void BotaoLogin(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLogin
        if (!tfLogin.getText().equals("") && !String.valueOf(pfSenha.getPassword()).equals("")) {
            try {
                String tu = Validacoes.logar(tfLogin.getText(), Criptografia.criptoMD5(String.valueOf(pfSenha.getPassword())));
                if (!tu.equals("")) {
                    FrmMain tp = new FrmMain();
                    tp.setVisible(true);
                    tp.user(tu);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique se a Senha ou o Login estão corretos!", "Login ou Senha incorretos!", JOptionPane.WARNING_MESSAGE);
                    tfLogin.requestFocus();
                }
            } catch (Exception e) {
                System.out.println("erro" + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "O preenchimento é obrigatório para Logar!");
            tfLogin.requestFocus();
        }
    }//GEN-LAST:event_BotaoLogin

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfLogin;
    // End of variables declaration//GEN-END:variables
}