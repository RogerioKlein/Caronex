/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author roger
 */
public class Log {

    /**
     * Função para registrar os logs de erro do sistema
     *
     * @param usuario Usuário logado no sistema
     * @param tela A tela onde aconteceu o erro
     * @param botao O botão clicado pelo usuário
     * @param erro Erro que aconteceu na ação do clique
     */
    public static void geraLog(String usuario, JFrame tela, JButton botao, String erro) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String space = System.lineSeparator();

        try {
            String filename = "logs.txt";

            FileWriter fw = new FileWriter(filename, true);

            fw.write("Usuário: " + usuario + space + "Tela: " + tela.getTitle() + space + "Ação executada: " + botao.getText() + space + "\nErro: " + erro + space + "\nHorário: " + dateFormat.format(new Date()) + space + space);

            fw.close();

        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void geraLog(String usuario, String tela, String botao, String erro) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String space = System.lineSeparator();

        try {
            String filename = "logs.txt";

            FileWriter fw = new FileWriter(filename, true);

            fw.write("Usuário: " + usuario + space + "Tela: " + tela + space + "Ação executada: " + botao + space + "\nErro: " + erro + space + "\nHorário: " + dateFormat.format(new Date()) + space + space);

            fw.close();

        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    
    public static void geraCSV(JTable table) {
    try{
        TableModel model = table.getModel();
        String filename = "teste.csv";
        FileWriter excel = new FileWriter(filename);

        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + ";");
            //excel.append(',');
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i,j).toString() + ";");
                //excel.append(',');
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
}

    public static void geraLogBD(String usuario, String metodo, String classe, String erro) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String space = System.lineSeparator();

        try {
            String filename = "logs.txt";

            FileWriter fw = new FileWriter(filename, true);

            fw.write("Usuário: " + usuario + space + "Método: " + metodo + space + "Classe: " + classe + space + "\nErro: " + erro + space + "\nHorário: " + dateFormat.format(new Date()) + space + space);

            fw.close();

        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    
    public static void geraLogBD(String usuario, String metodo, Class classe, String erro) {
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String space = System.lineSeparator();

        try {
            String filename = "logs.txt";

            FileWriter fw = new FileWriter(filename, true);

            fw.write("Usuário: " + usuario + space + "Método: " + metodo + space + "Classe: " + classe + space + "\nErro: " + erro + space + "\nHorário: " + dateFormat.format(new Date()) + space + space);

            fw.close();

        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}
