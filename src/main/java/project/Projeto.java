/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import entidades.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.UIManager;
import telas.FrmLogin;

/**
 *
 * @author roger
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception e) {

        }
        //tela login
        FrmLogin tela = new FrmLogin();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
        
    }

}
