package com.sigen.ecf.infra.sync.exporta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

	public void executeUpdate(String sql) throws Exception {

		Statement stmt;

		Connection con;
		try {
			con = DBConnectionManager.getConnection(getHost(),
					getDatabaseName(), getUser(), getPass());
			con.setAutoCommit(false);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao tentar conectar ao banco de dados");
		}

		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
			throw new Exception("Erro ao tentar executar consulta");
		} finally {

			con.commit();

			try {
				DBConnectionManager.fecharSessao(con);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception("Erro ao tentar fechar conexão");
			}
		}

	}

	public ResultSet executeQuery(String sql) throws Exception {

		Statement stmt;

		Connection con;
		try {
			con = DBConnectionManager.getConnection(getHost(),
					getDatabaseName(), getUser(), getPass());
			con.setAutoCommit(false);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao tentar conectar ao banco de dados");
		}

		ResultSet result;
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Erro ao tentar executar consulta");
		} finally {
			try {
				DBConnectionManager.fecharSessao(con);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception("Erro ao tentar fechar conexão");
			}
		}

		return result;
	}

	protected abstract String getDatabaseName();

	protected abstract String getHost();

	protected abstract String getUser();

	protected abstract String getPass();

}
