/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import conexao.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidades.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.hibernate.query.Query;

/**
 *
 * @author roger
 */
public class Pesquisas {

    public static void PesquisaPessoa(JTable tabela, String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Pessoa> resultado = new ArrayList();
        String sql = "FROM Pessoa "
                + "WHERE nome LIKE '%" + nome + "%' "
                + "AND status != 'X'"
                + "ORDER BY nome";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "RG", "Nome", "CPF", "Idade", "Responsável", "Email", "Telefone"};
        int[] widths = {30, 130, 30, 100, 30, 100, 100, 100};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Pessoa pessoa = resultado.get(i);
                Pessoa pessoa_responsavel = (Pessoa) sessao.get(Pessoa.class, pessoa.getId_responsavel());
                modelo.addRow(new Object[]{
                    pessoa.getId_pessoa(),
                    pessoa.getIdentidade(),
                    pessoa.getNome(),
                    pessoa.getCpf(),
                    pessoa.getIdade(),
                    pessoa_responsavel.getNome(),
                    pessoa.getEmail(),
                    pessoa.getTelefone()});
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaPessoa", "Pessoa", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaGrupo(JTable tabela, String nomeGrupo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Grupo> resultado = new ArrayList();
        String sql = "FROM Grupo "
                + "WHERE nome_grupo LIKE '%" + nomeGrupo + "%' "
                + "AND status != 'X'"
                + "ORDER BY nome_grupo";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "Nome do Grupo", "Stat", "Adm"};
        int[] widths = {30, 130, 30, 100};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        //verificar o getColumn(não pode ter o numero maior do que o Num de Colunas
        /*tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(40);
        //
        
        tabela.getColumnModel().getColumn(0).setHeaderValue(headers[0]);
        tabela.getColumnModel().getColumn(1).setHeaderValue(headers[1]);
        tabela.getColumnModel().getColumn(2).setHeaderValue(headers[2]);
        tabela.getColumnModel().getColumn(3).setHeaderValue(headers[3]);*/
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Grupo grupo = resultado.get(i);
                modelo.addRow(new Object[]{
                    grupo.getId_grupo(),
                    grupo.getNome_grupo(),
                    grupo.getStatus(),
                    grupo.getId_admin()
                });
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaGrupo", "Grupo", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaViagens(JTable tabela, int idViagem) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Viagem> resultado = new ArrayList();
        String sql = "FROM Viagem "
                + "WHERE status != 'X'"
                + "ORDER BY data_viagem";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "data_viagem", "valor_viagem", "km_viagem", "horas_viagem", "id_veiculo", "id_grupo", "status"};
        int[] widths = {30, 100, 100, 100, 100, 100, 100, 100};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        //verificar o getColumn(não pode ter o numero maior do que o Num de Colunas
        /*tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(40);
        //
        
        tabela.getColumnModel().getColumn(0).setHeaderValue(headers[0]);
        tabela.getColumnModel().getColumn(1).setHeaderValue(headers[1]);
        tabela.getColumnModel().getColumn(2).setHeaderValue(headers[2]);
        tabela.getColumnModel().getColumn(3).setHeaderValue(headers[3]);*/
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Viagem viagem = resultado.get(i);
                modelo.addRow(new Object[]{
                    //"ID", "data_viagem", "valor_viagem", "km_viagem", "horas_viagem", "id_veiculo", "id_grupo", "status"
                    viagem.getId_viagem(),
                    viagem.getData_viagem(),
                    viagem.getValor_viagem(),
                    viagem.getKm_viagem(),
                    
                    viagem.getHoras_viagem(),
                    viagem.getId_veiculo(),
                    viagem.getId_grupo(),
                    viagem.getStatus()
                });
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaViagem", "Viagem", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaGrupoPessoa(JTable tabela, int idGrupo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Grupo> resultado = new ArrayList();
        String sql = "FROM Grupo "
                + "WHERE id_grupo = " + idGrupo + " "
                + "AND status != 'X' "
                + "ORDER BY id_grupo";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "RG", "Nome", "CPF"};
        int[] widths = {30, 100, 100, 100};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();

            Grupo grupo = resultado.get(0);

            for (Pessoa pessoa : grupo.getPessoas()) {
                modelo.addRow(new Object[]{
                    pessoa.getId_pessoa(),
                    pessoa.getIdentidade(),
                    pessoa.getNome(),
                    pessoa.getCpf()});
            }

        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaGrupo", "Grupo", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaVeiculo(JTable tabela, String placa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Veiculo> resultado = new ArrayList();
        String sql = "FROM Veiculo "
                + "WHERE placa LIKE '%" + placa + "%' "
                + "ORDER BY placa";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "Placa", "KM/L", "valor_disp_kml"};
        int[] widths = {30, 130, 30, 100};

        for (int i = 0; i < 4; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(40);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Veiculo veiculo = resultado.get(i);
                modelo.addRow(new Object[]{
                    veiculo.getId_veiculo(),
                    veiculo.getPlaca(),
                    veiculo.getKml(),
                    veiculo.getValor_disp_km(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getCor()});
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaVeiculo", "Veiculo", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaEndereco(JTable tabela, String busca) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Endereco> resultado = new ArrayList();
        String sql = "FROM Endereco "
                + "WHERE (bairro LIKE '%" + busca + "%' OR numero LIKE '%" + busca + "%' OR logradouro LIKE '%" + busca + "%') "
                + "AND status != 'X' "
                + "ORDER BY id_end";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "Número", "Logradouro", "Complemento", "Bairro", "Cidade"};
        int[] widths = {40, 60, 100, 100, 100, 100};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {

            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Endereco endereco = resultado.get(i);
                Cidade cidade = (Cidade) sessao.get(Cidade.class, endereco.getId_end());
                modelo.addRow(new Object[]{
                    endereco.getId_end(),
                    endereco.getNumero(),
                    endereco.getLogradouro(),
                    endereco.getComplemento(),
                    endereco.getBairro(),
                    cidade.getCidade()});
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaEndereco", "Endereco", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaPessoaG(JTable tabela, String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Pessoa> resultado = new ArrayList();
        String sql = "FROM Pessoa "
                + "WHERE nome LIKE '%" + nome + "%' "
                + "AND status != 'X'"
                + "ORDER BY nome";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "RG", "Nome", "CPF"};
        int[] widths = {30, 100, 100, 100};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Pessoa pessoa = resultado.get(i);
                Pessoa pessoa_responsavel = (Pessoa) sessao.get(Pessoa.class, pessoa.getId_responsavel());
                modelo.addRow(new Object[]{
                    pessoa.getId_pessoa(),
                    pessoa.getIdentidade(),
                    pessoa.getNome(),
                    pessoa.getCpf()});
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaPessoaG", "Pessoa", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaCidade(JTable tabela, String busca) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Cidade> resultado = new ArrayList();
        String sql = "FROM Cidade "
                + "WHERE cidade LIKE '%" + busca + "%' "
                + "AND status != 'X' "
                + "ORDER BY cidade";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "Nome da Cidade", "UF"};
        int[] widths = {40, 130, 130};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Cidade cidade = resultado.get(i);
                modelo.addRow(new Object[]{
                    cidade.getId_cid(),
                    cidade.getCidade(),
                    cidade.getUf()});
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaCidade", "Cidade", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaUsuario(JTable tabela, String busca) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Login> resultado = new ArrayList();
        String sql = "FROM Login "
                + "WHERE login LIKE '%" + busca + "%' "
                + "AND status != 'X' "
                + "ORDER BY login";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "Login", "Tipo Usuario"};
        int[] widths = {40, 130, 130};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Login login = resultado.get(i);
                modelo.addRow(new Object[]{
                    login.getId(),
                    login.getLogin(),
                    login.getTipo_usuario()});
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaLogin", "Login", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaAuditoria(JTextArea txtArea) throws IOException {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Auditoria> resultado = new ArrayList();
        String sql = "FROM Auditoria "
                + "ORDER BY log_id";

        //começa IO
        try {

            Query query = sessao.createQuery(sql);
            resultado = query.list();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String space = System.lineSeparator();
            String filename = "Auditoria.txt";
            FileWriter fw = new FileWriter(filename, true);

            for (int i = 0; i < resultado.size(); i++) {
                Auditoria audita = resultado.get(i);
                fw.write(audita.toString());
                txtArea.setText(txtArea.getText() + audita.toString());
            }
            fw.close();

            JOptionPane.showMessageDialog(null, "Arquivo Gerado com sucesso!!");

        } catch (HibernateException e) {
            Log.geraLogBD("admin", "GeracaoArquivo", "Auditoria", e.toString());
        } finally {
            sessao.close();
        }
    }

    public static void PesquisaAuditoriaDois(JTable tabela, String data1, String data2) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Auditoria> resultado = new ArrayList();
        String sql = "FROM Auditoria "
                + "WHERE data_criacao >= '" + data1 + "' "
                + "AND data_criacao <= '" + data2 + "'";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        String[] headers = {"ID", "Data", "Operação Realizada"};
        int[] widths = {20, 100, 200};

        for (int i = 0; i < headers.length; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Auditoria auditoria = resultado.get(i);
                modelo.addRow(new Object[]{
                    auditoria.getId(),
                    auditoria.getDate(),
                    auditoria.getAction()});
            }
        } catch (HibernateException e) {
            Log.geraLogBD("admin", "PesquisaLogin", "Login", e.toString());
        } finally {
            sessao.close();
        }
    }

}
