/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.Formatacao;
import apoio.GerenciarJanelas;
import apoio.Pesquisas;
import apoio.SoNumeros;
import apoio.TableSorter;
import entidades.Viagem;
import java.sql.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rogério H. Klein <rhklein@universo.univates.br>
 */
public class IfrConsultaViagem extends javax.swing.JInternalFrame {

    private static IfrConsultaViagem tela;
    static Viagem viagem = new Viagem();
    GerenciarJanelas gerenciarJanelas;

    private Date dateMax;
    private String dateMaxS;
    private Date dateMin;
    private String dateMinS;
    private Date hoje;

    TableSorter sorter;
    private int id;

    static JInternalFrame getInstancia() {
        if (tela == null) {
            tela = new IfrConsultaViagem();
        }
        return tela;
    }

    public IfrConsultaViagem() {
        initComponents();
        Pesquisas.PesquisaViagens(tblViagens, -1);
        //datas
        this.dateMin = Date.valueOf(Formatacao.ajustaDataAMD("01/01/0001"));
        this.dateMax = Date.valueOf(Formatacao.ajustaDataAMD("31/12/9999"));

        this.dateMinS = Formatacao.ajustaDataAMD("01/01/0001");
        this.dateMaxS = Formatacao.ajustaDataAMD("31/12/9999");

        this.hoje = Date.valueOf(Formatacao.ajustaDataAMD(Formatacao.getDataAtual()));
        ftfDataSaidaMin.setText(Formatacao.ajustaDataDMA(hoje));
        ftfDataSaidaMax.setText(Formatacao.ajustaDataDMA(hoje));

        //popula cabeçalho
        ///////////new ViagemDAO().popularTabela(tblViagens, 0, "", 0, null, null, null, null, Formatacao.ajustaDataAMD(Formatacao.getDataAtual()), Formatacao.ajustaDataAMD(Formatacao.getDataAtual()));
        //Formata
        Formatacao.formatarData(ftfDataEmissaoMax);
        Formatacao.formatarData(ftfDataEmissaoMin);
        Formatacao.formatarData(ftfDataRetornoMax);
        Formatacao.formatarData(ftfDataRetornoMin);
        Formatacao.formatarData(ftfDataSaidaMax);
        Formatacao.formatarData(ftfDataSaidaMin);
        //PREENCHER
        ftfDataSaidaMax.setText(Formatacao.getDataAtual());
        ftfDataSaidaMin.setText(Formatacao.removerFormatacao(Formatacao.getDataAtual()));

        txfNumViagem.setDocument(new SoNumeros());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblViagens = new javax.swing.JTable();
        btmEditaViagem = new javax.swing.JButton();
        btnCriarViagem = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txfNumViagem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txfGrupo = new javax.swing.JTextField();
        cbxStatusViagem = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        ftfDataSaidaMin = new javax.swing.JFormattedTextField();
        ftfDataSaidaMax = new javax.swing.JFormattedTextField();
        ftfDataRetornoMin = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        ftfDataRetornoMax = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        ftfDataEmissaoMax = new javax.swing.JFormattedTextField();
        ftfDataEmissaoMin = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        btnCancela = new javax.swing.JButton();
        btnFinaliza = new javax.swing.JButton();
        btnInicia = new javax.swing.JButton();
        btnRetorno = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();

        setTitle("Consulta Viagens");

        tblViagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tblViagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViagensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViagens);

        btmEditaViagem.setText("Editar Viagem");

        btnCriarViagem.setText("Programar Nova Viagem");
        btnCriarViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarViagemActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Data Viagem: ");

        jLabel2.setText("a");

        jLabel3.setText("Data Retorno:");

        jLabel5.setText("Data Emissão:");

        jLabel11.setText("Número Viagem:");

        jLabel12.setText("Grupo:");

        cbxStatusViagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Todos", "Programada", "Em Andamento", "Retornando", "Finalizada", "Cancelada" }));
        cbxStatusViagem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxStatusViagemItemStateChanged(evt);
            }
        });

        jLabel17.setText("Status Viagem:");

        ftfDataSaidaMin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfDataSaidaMinFocusLost(evt);
            }
        });

        ftfDataSaidaMax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfDataSaidaMaxFocusLost(evt);
            }
        });

        ftfDataRetornoMin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfDataRetornoMinFocusLost(evt);
            }
        });

        jLabel13.setText("a");

        ftfDataRetornoMax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfDataRetornoMaxFocusLost(evt);
            }
        });

        jLabel14.setText("a");

        ftfDataEmissaoMax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfDataEmissaoMaxFocusLost(evt);
            }
        });

        ftfDataEmissaoMin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfDataEmissaoMinFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Viagens Cadastradas:");

        btnCancela.setText("Cancelar Viagem");
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        btnFinaliza.setText("Finalizar Viagem");
        btnFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaActionPerformed(evt);
            }
        });

        btnInicia.setText("Iniciar Viagem");
        btnInicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciaActionPerformed(evt);
            }
        });

        btnRetorno.setText("Iniciar Retorno");
        btnRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetornoActionPerformed(evt);
            }
        });

        btnAtualiza.setText("Atualizar");
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCriarViagem)
                                .addGap(18, 18, 18)
                                .addComponent(btmEditaViagem)
                                .addGap(18, 18, 18)
                                .addComponent(btnInicia)
                                .addGap(18, 18, 18)
                                .addComponent(btnRetorno)
                                .addGap(18, 18, 18)
                                .addComponent(btnFinaliza)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancela)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txfGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel3)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(ftfDataEmissaoMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel14)
                                                .addGap(10, 10, 10)
                                                .addComponent(ftfDataEmissaoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(ftfDataSaidaMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2)
                                                .addGap(10, 10, 10)
                                                .addComponent(ftfDataSaidaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(ftfDataRetornoMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13)
                                                .addGap(10, 10, 10)
                                                .addComponent(ftfDataRetornoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxStatusViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txfNumViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAtualiza))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 338, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(ftfDataSaidaMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDataSaidaMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txfNumViagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualiza))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13)
                    .addComponent(ftfDataRetornoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDataRetornoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStatusViagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14)
                    .addComponent(ftfDataEmissaoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDataEmissaoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txfGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmEditaViagem)
                    .addComponent(btnCriarViagem)
                    .addComponent(btnSair)
                    .addComponent(btnCancela)
                    .addComponent(btnFinaliza)
                    .addComponent(btnInicia)
                    .addComponent(btnRetorno))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void fechaTela() {
        GerenciarJanelas.fecharJanela(tela);
        tela = null;
    }
    private void btnCriarViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarViagemActionPerformed
        GerenciarJanelas.abreJanela(IfrViagem.getInstancia());
    }//GEN-LAST:event_btnCriarViagemActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        fechaTela();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblViagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViagensMouseClicked
        chamaFiltros();
    }//GEN-LAST:event_tblViagensMouseClicked

    private void btnIniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciaActionPerformed
        if (tblViagens.getSelectedRow() >= 0) {
            int n = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Iniciar essa Viagem?", "Status da Viagem", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                ///////new ViagemDAO().atualizarStatus((int) tblViagens.getModel().getValueAt(tblViagens.getSelectedRow(), 0), 2);
                chamaFiltros();
                JOptionPane.showMessageDialog(null, "Viagem Iniciada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Viagem!");
        }
    }//GEN-LAST:event_btnIniciaActionPerformed

    private void btnRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetornoActionPerformed
        if (tblViagens.getSelectedRow() >= 0) {
            int n = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Iniciar o Retorno dessa Viagem?", "Status da Viagem", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                ///////new ViagemDAO().atualizarStatus((int) tblViagens.getModel().getValueAt(tblViagens.getSelectedRow(), 0), 3);
                chamaFiltros();
                JOptionPane.showMessageDialog(null, "Retorno Iniciado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Viagem!");
        }
    }//GEN-LAST:event_btnRetornoActionPerformed

    private void btnFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaActionPerformed
        if (tblViagens.getSelectedRow() >= 0) {
            int n = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Finalizar essa Viagem?", "Status da Viagem", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                ///////new ViagemDAO().atualizarStatus((int) tblViagens.getModel().getValueAt(tblViagens.getSelectedRow(), 0), 4);
                chamaFiltros();
                JOptionPane.showMessageDialog(null, "Viagem Finalizada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Viagem!");
        }
    }//GEN-LAST:event_btnFinalizaActionPerformed

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        if (tblViagens.getSelectedRow() >= 0) {
            int n = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Cancelar essa Viagem?", "Status da Viagem", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                ///////new ViagemDAO().atualizarStatus((int) tblViagens.getModel().getValueAt(tblViagens.getSelectedRow(), 0), 5);
                chamaFiltros();
                JOptionPane.showMessageDialog(null, "Viagem Cancelada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Viagem!");
        }
    }//GEN-LAST:event_btnCancelaActionPerformed

    private void cbxStatusViagemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxStatusViagemItemStateChanged
        chamaFiltros();
    }//GEN-LAST:event_cbxStatusViagemItemStateChanged

    private void ftfDataSaidaMaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfDataSaidaMaxFocusLost
        if (Formatacao.removerFormatacao(ftfDataSaidaMax.getText()).equals("")) {
            Formatacao.formatarData(ftfDataSaidaMax);
        }
    }//GEN-LAST:event_ftfDataSaidaMaxFocusLost

    private void ftfDataRetornoMaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfDataRetornoMaxFocusLost
        if (Formatacao.removerFormatacao(ftfDataRetornoMax.getText()).equals("")) {
            Formatacao.formatarData(ftfDataRetornoMax);
        }
    }//GEN-LAST:event_ftfDataRetornoMaxFocusLost

    private void ftfDataEmissaoMaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfDataEmissaoMaxFocusLost
        if (Formatacao.removerFormatacao(ftfDataEmissaoMax.getText()).equals("")) {
            Formatacao.formatarData(ftfDataEmissaoMax);
        }
    }//GEN-LAST:event_ftfDataEmissaoMaxFocusLost

    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
        chamaFiltros();
    }//GEN-LAST:event_btnAtualizaActionPerformed

    private void ftfDataSaidaMinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfDataSaidaMinFocusLost
        if (Formatacao.removerFormatacao(ftfDataSaidaMin.getText()).equals("")) {
            Formatacao.formatarData(ftfDataSaidaMin);
        }
    }//GEN-LAST:event_ftfDataSaidaMinFocusLost

    private void ftfDataRetornoMinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfDataRetornoMinFocusLost
        if (Formatacao.removerFormatacao(ftfDataRetornoMin.getText()).equals("")) {
            Formatacao.formatarData(ftfDataRetornoMin);
        }
    }//GEN-LAST:event_ftfDataRetornoMinFocusLost

    private void ftfDataEmissaoMinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfDataEmissaoMinFocusLost
        if (Formatacao.removerFormatacao(ftfDataEmissaoMin.getText()).equals("")) {
            Formatacao.formatarData(ftfDataEmissaoMin);
        }
    }//GEN-LAST:event_ftfDataEmissaoMinFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmEditaViagem;
    private javax.swing.JButton btnAtualiza;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnCriarViagem;
    private javax.swing.JButton btnFinaliza;
    private javax.swing.JButton btnInicia;
    private javax.swing.JButton btnRetorno;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cbxStatusViagem;
    private javax.swing.JFormattedTextField ftfDataEmissaoMax;
    private javax.swing.JFormattedTextField ftfDataEmissaoMin;
    private javax.swing.JFormattedTextField ftfDataRetornoMax;
    private javax.swing.JFormattedTextField ftfDataRetornoMin;
    private javax.swing.JFormattedTextField ftfDataSaidaMax;
    private javax.swing.JFormattedTextField ftfDataSaidaMin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblViagens;
    private javax.swing.JTextField txfGrupo;
    private javax.swing.JTextField txfNumViagem;
    // End of variables declaration//GEN-END:variables

    //confere se data maior não é menor que a menor
    private boolean menorMaior(String dataMax, String dataMin) {
        Date dmax = Date.valueOf(dataMax);
        Date dmin = Date.valueOf(dataMin);
        //confere se data maior não é menor que a menor
        if (dmax.before(dmin)) {
            JOptionPane.showMessageDialog(null, "Data");
            return false;
        } else {
            return true;
        }
    }

    private void chamaFiltros() {
        try {
            String demax;
            String drmax;
            String dsmax;
            String demin;
            String drmin;
            String dsmin;

            //Min
            //Saida
            if (Formatacao.removerFormatacao(ftfDataSaidaMin.getText()).trim().isEmpty()) {
                dsmin = dateMinS;
            } else {
                dsmin = Formatacao.ajustaDataAMD(ftfDataSaidaMin.getText());
            }
            //Retorno
            if (Formatacao.removerFormatacao(ftfDataRetornoMin.getText()).trim().isEmpty()) {
                drmin = dateMinS;
            } else {
                drmin = Formatacao.ajustaDataAMD(ftfDataRetornoMin.getText());
            }
            //Emissao
            if (Formatacao.removerFormatacao(ftfDataEmissaoMin.getText()).trim().isEmpty()) {
                demin = dateMinS;
            } else {
                demin = Formatacao.ajustaDataAMD(ftfDataEmissaoMin.getText());
            }

            //Max
            //Saida se campo data maior vazio...
            if (Formatacao.removerFormatacao(ftfDataSaidaMax.getText()).trim().isEmpty()) {
                //se a data menor não tiver sido preenchido pelo usuario...
                if (dsmin.equals(dateMinS)) {
                    //defini data maxima padrao
                    dsmax = dateMaxS;
                } else {
                    //se usuário preencheu a menor, preenche a maior com a menor
                    dsmax = dsmin;
                    ftfDataSaidaMax.setText(Formatacao.ajustaDataDMA(dsmin));
                }
                //se usuario preencheu data maior
            } else {
                dsmax = Formatacao.ajustaDataAMD(ftfDataSaidaMax.getText());
            }

            //Retorno se campo data maior vazio...
            if (Formatacao.removerFormatacao(ftfDataRetornoMax.getText()).trim().isEmpty()) {
                //se a data menor não tiver sido preenchido pelo usuario...
                if (drmin.equals(dateMinS)) {
                    //defini data maxima padrao
                    drmax = dateMaxS;
                } else {
                    //se usuário preencheu a menor, preenche a maior com a menor
                    drmax = dsmin;
                    ftfDataRetornoMax.setText(Formatacao.ajustaDataDMA(drmin));
                }
                //se usuario preencheu data maior
            } else {
                drmax = Formatacao.ajustaDataAMD(ftfDataRetornoMax.getText());
            }

            //Emissao se campo data maior vazio...
            if (Formatacao.removerFormatacao(ftfDataEmissaoMax.getText()).trim().isEmpty()) {
                //se a data menor não tiver sido preenchido pelo usuario...
                if (demin.equals(dateMinS)) {
                    //defini data maxima padrao
                    demax = dateMaxS;
                } else {
                    //se usuário preencheu a menor, preenche a maior com a menor
                    demax = dsmin;
                    ftfDataEmissaoMax.setText(Formatacao.ajustaDataDMA(demin));
                }
                //se usuario preencheu data maior
            } else {
                demax = Formatacao.ajustaDataAMD(ftfDataEmissaoMax.getText());
            }

            //numero Viagem
            int numViagem = 0;
            try {
                numViagem = Integer.parseInt(txfNumViagem.getText());
            } catch (Exception e) {
            }

            //busca grupo
            String grupo = txfGrupo.getText().trim();

            //status Viagem
            int statusViagem = 0;
            try {
                statusViagem = cbxStatusViagem.getSelectedIndex();
            } catch (Exception e) {
            }

            //chama o Viagemdao
            ///////new ViagemDAO().popularTabela(tblViagens, numViagem, grupo, statusViagem, demax, demin, drmax, drmin, dsmax, dsmin);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no Filtro:" + e);
        }
    }
}
