/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import conexao.DaoGenerico;
import entidades.Auditoria;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author roger
 */
public class Audita {

    private static Auditoria audita;

    public Audita(Auditoria audita) {
        this.audita = audita;
    }

    public static boolean salvarAuditoria(String acao, String tabela, int user) {
        audita.setAction(acao);
        audita.setDate(new Date());
        int id = DaoGenerico.getInstance().inserirSerial(audita);
        audita.setId(id);
        return true;
    }

    public static void gerarAuditoria() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String space = System.lineSeparator();

        try {
            String filename = "Auditoria.txt";

            FileWriter fw = new FileWriter(filename, true);

            fw.write("" + "");

            fw.close();

        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

}
