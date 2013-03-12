package com.sigen.ecf.infra.sync.exporta;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public abstract class Sincronizador {

	protected static final String ASPA = "\'";
	//private static String FINAL_ARQUIVO = "#$@SIGEN@$#";

	private List<Map<String, String>> gerarListaRegistros() throws Exception {

		StringBuffer ecfSelect = getSelectSql();

		List<Map<String, String>> valores = new ArrayList<Map<String, String>>();

		try {
			ResultSet rs = getSelectDAO().executeQuery(ecfSelect.toString());

			int columnsCount = rs.getMetaData().getColumnCount();

			while (rs.next()) {

				Map<String, String> map = new LinkedHashMap<String, String>();
				for (int i = 1; i <= columnsCount; i++) {
					String columnName = rs.getMetaData().getColumnName(i);
					map.put(columnName, rs.getString(columnName));
				}
				valores.add(map);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return valores;
	}

	public String getInsertString() throws Exception {

		List<Map<String, String>> linhas = gerarListaRegistros();

		StringBuffer sqlInsert = new StringBuffer();

		for (Iterator<Map<String, String>> iterator = linhas.iterator(); iterator
				.hasNext();) {

			Map<String, String> row = (Map<String, String>) iterator.next();

			StringBuffer sqlStringBuffer = new StringBuffer();

			String tableToInsert = getTableToInsert();

			sqlStringBuffer.append("insert into " + tableToInsert);

			sqlStringBuffer.append(" (");

			for (int i = 0; i < getColumnNames().length - 1; i++) {
				sqlStringBuffer.append(getColumnNames()[i] + ",");
			}

			sqlStringBuffer
					.append(getColumnNames()[getColumnNames().length - 1] + ")");

			sqlStringBuffer.append(" values");

			sqlStringBuffer.append(" (");

			for (int i = 0; i < getColumnNames().length - 1; i++) {
				sqlStringBuffer.append(":" + getColumnNames()[i] + ",");
			}

			sqlStringBuffer.append(":"
					+ getColumnNames()[getColumnNames().length - 1] + ");");

			String sqlString = sqlStringBuffer.toString();

			for (int i = 0; i < getColumnNames().length; i++) {

				String valor = row.get(getColumnNames()[i]);

				if (valor == null) {
					sqlString = sqlString.replaceAll(":" + getColumnNames()[i],
							"null");
				} else {
					sqlString = sqlString.replaceAll(":" + getColumnNames()[i],
							ASPA + valor.replaceAll(ASPA, "") + ASPA);
				}
			}

			sqlInsert.append(sqlString + "\n");

		}

		// getInsertDAO().executeUpdate(sqlInsert.toString());

		//sqlInsert.append(FINAL_ARQUIVO);

		return sqlInsert.toString();

	}

	protected abstract DAO getSelectDAO();

	//protected abstract DAO getInsertDAO();

	protected abstract String[] getColumnNames();

	protected abstract String getTableToInsert();

	protected abstract StringBuffer getSelectSql();

}
