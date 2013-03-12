package com.sigen.ecf.infra.sync.exporta;

public class LancamentoSincExporta extends SincronizadorExportacao {

        public LancamentoSincExporta(String codUltimoMovimento){
           super(codUltimoMovimento);
        }
    
	protected String[] getColumnNames() {
		return new String[] { "loja", "cod_ecf", "cod_movimento",
				"cod_operador", "coo", "cod_forma_pagamento",
				"tipo_forma_pagamento", "cod_conveniada", "cod_cliente",
				"valor_bruto", "valor_liquido", "data_lancamento",
				"hora_lancamento", "cod_condicao_pagamento", "num_lancamento",
				"num_parcela", "taxa_adm", "chq_banco", "chq_agencia",
				"chq_conta", "chq_numero", "data_vencimento" };
	}

	protected StringBuffer getSelectSql() {
		StringBuffer sql = new StringBuffer();

		sql.append("select ");
		sql.append("loja, cod_ecf, cod_movimento, cod_operador, coo, cod_forma_pagamento,");
		sql.append("tipo_forma_pagamento, cod_conveniada, cod_cliente, valor_bruto, ");
		sql.append("valor_liquido, data_lancamento, hora_lancamento, cod_condicao_pagamento,");
		sql.append("num_lancamento, num_parcela, taxa_adm, chq_banco, chq_agencia, ");
		sql.append("chq_conta, chq_numero, data_vencimento ");

		sql.append("from mov_lancamento ");

                sql.append(" where cast(cod_movimento as integer) > ").append(getCodUltimoMovimento());
                
		return sql;
	}

	protected String getTableToInsert() {
		return "ecf_mov_lancamento";
	}
}
