package com.sigen.ecf.infra.sync.exporta;

public class ItemVendaSincExporta extends SincronizadorExportacao {

        public ItemVendaSincExporta(String codUltimoMovimento){
           super(codUltimoMovimento);
        }
    
	protected String[] getColumnNames() {
		return new String[] { "cod_movimento", "cod_operador", "coo", "loja",
				"cod_ecf", "item", "cod_prod", "descricao", "quantidade",
				"cod_und", "valor_unitario", "valor_desconto",
				"valor_acrescimo", "st", "valor_total",
				"indicador_cancelamento", "qtd_emb", "icms_st", "icms_red_bc",
				"icms_aliq", "icms_bc", "icms_valor", "ipi_st", "ipi_aliq",
				"ipi_bc", "ipi_valor", "pis_st", "pis_aliq", "pis_bc",
				"pis_valor", "cofins_st", "cofins_aliq", "cofins_bc",
				"cofins_valor", "iat", "casas_decimais_quantidade",
				"casas_decimais_valor", "data_emissao", "data_cancelamento",
				"hora_emissao", "hora_cancelamento", "cfop", "cod_vendedor" };
	}

	protected StringBuffer getSelectSql() {
		StringBuffer sql = new StringBuffer();

		sql.append("select ");
		sql.append("cod_movimento, cod_operador, coo, loja, cod_ecf, item, cod_prod,");
		sql.append("descricao, quantidade, cod_und, valor_unitario, valor_desconto,");
		sql.append("valor_acrescimo, st, valor_total, indicador_cancelamento, qtd_emb,");
		sql.append("icms_st, icms_red_bc, icms_aliq, icms_bc, icms_valor, ipi_st, ");
		sql.append("ipi_aliq, ipi_bc, ipi_valor, pis_st, pis_aliq, pis_bc, pis_valor,");
		sql.append("cofins_st, cofins_aliq, cofins_bc, cofins_valor, iat, casas_decimais_quantidade,");
		sql.append("casas_decimais_valor, data_emissao, data_cancelamento, hora_emissao,");
		sql.append("hora_cancelamento, cfop, cod_vendedor ");

		sql.append("from mov_item_venda ");
                
                sql.append(" where cast(cod_movimento as integer) > ").append(getCodUltimoMovimento());

		return sql;
	}

	protected String getTableToInsert() {
		return "ecf_mov_item_venda";
	}
}
