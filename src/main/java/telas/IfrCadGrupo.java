/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.DaoGenerico;
import apoio.*;
import entidades.Grupo;
import entidades.Pessoa;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author roger
 */
public class IfrCadGrupo extends javax.swing.JInternalFrame {

    private static IfrCadGrupo tela;
    String errors;
    public static int id_organizador;

    public int id = -1;

    /**
     * Creates new form IfrCadGrupo
     */
    public IfrCadGrupo() {
        initComponents();
        this.setTitle("Cadastrar Grupo");
        Pesquisas.PesquisaGrupo(tblBuscaGrupo, "");
        // aplica mascaras
        // btnBuscaResp.setVisible(false);
    }

    public static IfrCadGrupo getInstancia() {
        if (tela == null) {
            tela = new IfrCadGrupo();
        }
        return tela;
    }

    private void fechaTela() {
        GerenciarJanelas.fecharJanela(tela);
        tela = null;
    }

    public void trazerPessoa(Pessoa pessoa) {
        id_organizador = pessoa.getId_pessoa();
        txtOrganizador.setText(pessoa.getNome());
    }

    public void salvar(Grupo u) {

        Session sessao = null;
        sessao = conexao.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = conexao.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            int id = (int) sessao.save(u);
            transacao.commit();
            u.setId_grupo(id);
            Audita.salvarAuditoria("SalvarGrupo", "Grupo", 1);

            JOptionPane.showMessageDialog(null, "Grupo criado com sucesso!");
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD("admin", "salvar", "dao", hibEx.toString());
        } finally {
            sessao.close();
        }
        if (JOptionPane.showConfirmDialog(null, "Voce deseja criar a lista de pessoas do Grupo agora?") == 0) {
            GerenciarJanelas.abreJanela(IfrGrupoPessoa.getInstancia(u));
            this.dispose();
        }
    }

    public void atualizar(Grupo u) {
        Session sessao = null;
        sessao = conexao.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.update(u);
            transacao.commit();
            Audita.salvarAuditoria("AtualizarGrupo", "Grupo", 1);

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD("admin", "atualizar", "dao", hibEx.toString());
        } finally {
            sessao.close();
        }
    }

    public void inativar(Grupo u) {
        if (JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Inativar este Grupo?") == 0) {
            Session sessao = null;
            List resultado = null;
            sessao = conexao.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery("FROM Grupo WHERE id = " + u.getId_grupo());

            try {

                resultado = query.list();
                for (Object obj : resultado) {
                    Grupo grupo = (Grupo) obj;
                    grupo.setStatus(u.getStatus());
                    sessao.update(grupo);
                    transacao.commit();
                    Audita.salvarAuditoria("InativarGrupo", "Grupo", 1);
                }

            } catch (HibernateException hibEx) {
                hibEx.printStackTrace();
                Log.geraLogBD("admin", "inativar", "dao", hibEx.toString());
            } finally {
                JOptionPane.showMessageDialog(null, "Grupo Desativado");
                sessao.close();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeGrupo = new javax.swing.JTextField();
        txtOrganizador = new javax.swing.JTextField();
        btnBuscaResp = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        BtnFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscaGrupo = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtGrupoBusca = new javax.swing.JTextField();
        btnPesquisaGrupo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();

        setTitle("Cadastrar Grupo");

        jLabel1.setText("Nome Grupo:");

        jLabel2.setText("Organizador:");

        btnBuscaResp.setText("Busca");
        btnBuscaResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaRespActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtOrganizador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscaResp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscaResp)
                    .addComponent(txtOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastra", jPanel1);

        tblBuscaGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBuscaGrupo);

        jLabel4.setText("Grupo:");

        btnPesquisaGrupo.setText("Busca");
        btnPesquisaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaGrupoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Editar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnInativar.setText("Inativar");
        btnInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInativarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtGrupoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesquisaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInativar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisaGrupo)
                    .addComponent(txtGrupoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnInativar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisa", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        fechaTela();
    }//GEN-LAST:event_BtnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validaInsert()) {

            Grupo grupo = new Grupo();

            grupo.setNome_grupo(txtNomeGrupo.getText());
            grupo.setId_admin(id_organizador);
            grupo.setStatus("A");

            if (id > -1) {
                grupo.setId_grupo(id);
                DaoGenerico.getInstance().atualizar(grupo);
                //atualizar(grupo);

            } else {
                //salvar(grupo);
                DaoGenerico.getInstance().inserir(grupo);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor, verifique os dados");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscaRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaRespActionPerformed
        DlgPessoas dlgPessoas = new DlgPessoas(null, true, txtOrganizador.getText(), this);
        dlgPessoas.setVisible(true);
    }//GEN-LAST:event_btnBuscaRespActionPerformed

    private void btnPesquisaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaGrupoActionPerformed
        Pesquisas.PesquisaGrupo(tblBuscaGrupo, txtGrupoBusca.getText());
    }//GEN-LAST:event_btnPesquisaGrupoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        id = Integer.parseInt(String.valueOf(tblBuscaGrupo.getValueAt(tblBuscaGrupo.getSelectedRow(), 0)));
        jTabbedPane1.setSelectedIndex(0);
        Session sessao = null;
        List resultado = null;
        try {
            sessao = conexao.HibernateUtil.getSessionFactory().openSession();

            Grupo grupo = (Grupo) sessao.get(Grupo.class,
                    id);

            txtNomeGrupo.setText(grupo.getNome_grupo());

            Pessoa organizador = (Pessoa) sessao.get(Pessoa.class,
                    grupo.getId_admin());
            txtOrganizador.setText(organizador.getNome());
            id_organizador = organizador.getId_pessoa();

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLog("admin", "IfrCadGrupo", "Alterar", hibEx.toString());
        } finally {
            sessao.close();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        int id = Integer.parseInt(String.valueOf(tblBuscaGrupo.getValueAt(tblBuscaGrupo.getSelectedRow(), 0)));
        Grupo grupo = new Grupo();
        grupo.setId_grupo(id);
        grupo.setStatus("X");
        inativar(grupo);
    }//GEN-LAST:event_btnInativarActionPerformed

    public boolean validaInsert() {

        String replaced = "";
        errors = "";

        //NomeGrupo
        if (txtNomeGrupo.getText().length() == 0) {
            errors += "Preencha o Nome do Grupo - ";
        }

        //Selecione um Organizador
        if (txtNomeGrupo.getText().length() == 0) {
            errors += "Preencha o Organizador - ";
        }

        return errors.equals("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnFechar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscaResp;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnPesquisaGrupo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBuscaGrupo;
    private javax.swing.JTextField txtGrupoBusca;
    private javax.swing.JTextField txtNomeGrupo;
    private javax.swing.JTextField txtOrganizador;
    // End of variables declaration//GEN-END:variables
}
