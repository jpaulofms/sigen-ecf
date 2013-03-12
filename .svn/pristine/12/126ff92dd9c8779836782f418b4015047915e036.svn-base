/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.sync.exporta;

/**
 *
 * @author desenvolvimento
 */
public class ItemDevolucaoSincExporta extends SincronizadorExportacao {

    public ItemDevolucaoSincExporta(String codigoUltimoMovimento) {
        super(codigoUltimoMovimento);
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"cod_ecf", "loja", "coo_devolucao", "cod_produto",
                    "quantidade", "valor_unitario", "valor_total", "cod_mov"};
    }

    @Override
    protected String getTableToInsert() {
        return "ecf_mov_item_devolucao";
    }

    @Override
    protected StringBuffer getSelectSql() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("cod_ecf, loja, coo_devolucao, cod_produto, quantidade, valor_unitario, ");
        sql.append("valor_total, cod_mov ");

        sql.append("from mov_item_devolucao ");

        sql.append(" where cast(cod_mov as integer) > ").append(getCodUltimoMovimento());

        return sql;
    }
}
