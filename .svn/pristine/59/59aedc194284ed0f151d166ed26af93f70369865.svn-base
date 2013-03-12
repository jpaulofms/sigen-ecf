package com.sigen.ecf.infra.sync.exporta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionManager {

	public static Connection getConnection(String host, String databaseName,
			String user, String pass) throws Exception {

		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://" + host + ":5432/" + databaseName;

			return DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			throw new Exception("Não foi possível encontrar o Driver!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new Exception("Não foi possível conectar ao banco de dados!");
		}
	}

	public static void fecharSessao(Connection con) throws SQLException {
		con.close();
	}

}
