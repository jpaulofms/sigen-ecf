package com.sigen.ecf.infra.sync.exporta;

public class SuprimentoSincExporta extends SincronizadorExportacao {

    public SuprimentoSincExporta(String codUltimoMovimento){
           super(codUltimoMovimento);
        }
    
	protected String[] getColumnNames() {
		return new String[] { "coo", "gnf", "loja", "cod_ecf", "cod_movimento",
				"cod_operador", "data", "cod_forma_pagamento", "hora", "valor" };
	}

	protected StringBuffer getSelectSql() {
		StringBuffer sql = new StringBuffer();

		sql.append("select ");
		sql.append("coo, gnf, loja, cod_ecf, cod_movimento, cod_operador, data, cod_forma_pagamento,");
		sql.append("hora, valor ");

		sql.append("from mov_suprimento ");
                
                sql.append(" where cast(cod_movimento as integer) > ").append(getCodUltimoMovimento());

		return sql;
	}

	protected String getTableToInsert() {
		return "ecf_mov_suprimento";
	}
}
