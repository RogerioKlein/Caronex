/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import conexao.HibernateUtil;
import entidades.ResumoViagens;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import javax.swing.JOptionPane;
import org.hibernate.query.Query;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Everton
 */
public class GraficoDeBarra {
    
    
    public List<ResumoViagens> getResumoViagens(int id_r, int ano, int mes) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<ResumoViagens> x = new ArrayList<>();
        try {
            List<Object> resultado = new ArrayList();
            String sql = "FROM ResumoViagens "
                    + " WHERE ano = 2020";

            Query query = sessao.createQuery(sql);
            resultado = query.list();

            for (int i = 0; i < resultado.size(); i++) {
                x.add((ResumoViagens)resultado.get(i));
            }

        } catch (Exception e) {
            //LogsDAO.salvarLog(Tela_Login.fun, "Erro ao puxar algum registro do banco de dados.", e);
            JOptionPane.showMessageDialog(null, "Erro imprevisto!\n" + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return x;
    }
    
    public CategoryDataset createDataSet(List<ResumoViagens> rvs) {

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (ResumoViagens m : rvs) {
            dataSet.addValue((Number)m.getNum_viagens(), m.getAno() + "-" + m.getMes(), "");
            
        }

        return dataSet;
    }

    public JFreeChart createBarChart(CategoryDataset dataSet) {

        JFreeChart graficoBarras = ChartFactory.createBarChart3D("Viagens no ano", "Meses", "Número de viagens", dataSet, PlotOrientation.VERTICAL, true, true, false);

        return graficoBarras;
    }

    public ChartPanel criarGrafico(List<ResumoViagens> rvs) {

        CategoryDataset dataset = this.createDataSet(rvs);

        JFreeChart grafico = this.createBarChart(dataset);

        ChartPanel painelGrafico = new ChartPanel(grafico);

        return painelGrafico;

    }

    public ChartPanel atualizarGrafico(List<ResumoViagens> rvs) {

        CategoryDataset datset = this.createDataSet(rvs);

        JFreeChart graf = this.createBarChart(datset);

        ChartPanel painelG = new ChartPanel(graf);

        return painelG;
    }
    
}
