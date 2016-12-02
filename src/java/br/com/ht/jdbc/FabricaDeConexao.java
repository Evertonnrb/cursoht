
package br.com.ht.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class FabricaDeConexao {
    public static  Connection getConection(){
        Connection con = null;
        try {
            Class.forName("");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cursoht"
                    + "","postgres","postgres");
            System.out.println("Conectado");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Conectado");
            JOptionPane.showMessageDialog(null, "Erro "+e);
        }
        return con;
    }
}
