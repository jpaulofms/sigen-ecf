/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.persistencia;

import java.sql.*;
import javax.swing.JOptionPane;

public class BDConnection {

    Connection con;

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1:5432/sigen_ecf";
            String user = "postgres";
            String password = "sigenerp";

            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Driver!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
        return con;
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
