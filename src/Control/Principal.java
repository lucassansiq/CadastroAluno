/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.tela;
import util.Configura;

/**
 *
 * @author gabri
 */
public class Principal {
    public static void main(String[] args) {
        Configura.LookAndFeel("Windows Classic");
        new tela().setVisible(true);
        dao.ConnectionFactory.getConnection();
    }
    
}
