package com.sigen.ecf.infra.sync.exporta;

public class MovimentoSincExporta extends SincronizadorExportacao {

        public MovimentoSincExporta(String codUltimoMovimento){
            super(codUltimoMovimento);
        }
    
	protected String[] getColumnNames() {
		return new String[] { "coo", "gnf", "loja", "cod_ecf", "cod_movimento",
				"cod_operador", "data_abertura", "data_fechamento",
				"cod_supervisor", "hora_abertura", "hora_fechamento",
				"saldo_dinheiro_abertura", "saldo_dinheiro_fechamento" };
	}

	protected StringBuffer getSelectSql() {
		StringBuffer sql = new StringBuffer();

		sql.append("select ");
		sql.append("coo, gnf, loja, cod_ecf, cod_movimento, cod_operador, data_abertura, ");
		sql.append("data_fechamento, cod_supervisor, hora_abertura, hora_fechamento, ");
		sql.append("saldo_dinheiro_abertura, saldo_dinheiro_fechamento ");

		sql.append("from mov_movimento ");
                
                sql.append(" where cast(cod_movimento as integer) > ").append(getCodUltimoMovimento());

		return sql;
	}

	protected String getTableToInsert() {
		return "ecf_mov_movimento";
	}
}
