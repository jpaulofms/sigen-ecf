package com.sigen.ecf.infra.sync.exporta;

public class VendaSincExporta extends SincronizadorExportacao {

        public VendaSincExporta(String codUltimoMovimento){
           super(codUltimoMovimento);
        }
    
	protected String[] getColumnNames() {
		return new String[] { "coo", "loja", "cod_ecf", "data_emissao",
				"data_cancelamento", "valor_sub_total", "valor_desconto",
				"valor_acrescimo", "valor_total", "indicador_cancelamento",
				"nome_adquirente", "cpf_cnpj_adquirente", "cod_movimento",
				"cod_operador", "hora_emissao", "hora_cancelamento" };
	}

	protected StringBuffer getSelectSql() {
		StringBuffer sql = new StringBuffer();

		sql.append("select ");
		sql.append("coo, loja, cod_ecf, data_emissao, data_cancelamento, valor_sub_total, ");
		sql.append("valor_desconto, valor_acrescimo, valor_total, indicador_cancelamento, ");
		sql.append("nome_adquirente, cpf_cnpj_adquirente, cod_movimento, cod_operador, ");
		sql.append("hora_emissao, hora_cancelamento ");

		sql.append("from mov_venda ");

                sql.append(" where cast(cod_movimento as integer) > ").append(getCodUltimoMovimento());
                
		return sql;
	}

	protected String getTableToInsert() {
		return "ecf_mov_venda";
	}
}
