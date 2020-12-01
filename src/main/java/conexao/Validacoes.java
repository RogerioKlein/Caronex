/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

/**
 *
 * @author roger
 */
import conexao.HibernateUtil;
import entidades.Login;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Validacoes {

    public static String logar(String login, String senha) {
        String tipo_user = "";
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Login> resultado = new ArrayList();
        String sql = "FROM Login "
                + "WHERE status = 'A'";
        try {
            Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Login loginDB = resultado.get(i);
                if (loginDB.getLogin().equals(login) && loginDB.getSenha().equals(senha)) {
                    if (loginDB.getStatus().equals("A")) {
                        tipo_user = loginDB.getTipo_usuario();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro não previsto!\n" + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return tipo_user;
    }

}
