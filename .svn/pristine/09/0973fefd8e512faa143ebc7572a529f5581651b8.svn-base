/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.sync.exporta;

/**
 *
 * @author desenvolvimento
 */
public class DevolucaoSincExporta extends SincronizadorExportacao {

    public DevolucaoSincExporta(String codUltimoMovimento) {
        super(codUltimoMovimento);
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"coo_devolucao", "loja", "cod_ecf", "data_devolucao",
                    "hora", "valor_credito", "endereco",
                    "cep", "numero", "complemento", "bairro", "estado", "cidade",
                    "nome_cliente", "cpf_cnpj", "cod_mov", "devolucao_utilizada"};
    }

    @Override
    protected String getTableToInsert() {
        return "ecf_mov_devolucao";
    }

    @Override
    protected StringBuffer getSelectSql() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("coo_devolucao, loja, cod_ecf, data_devolucao, hora, valor_credito, ");
        sql.append("endereco, cep, numero, complemento, bairro, estado, cidade, ");
        sql.append("nome_cliente, cpf_cnpj, cod_mov, devolucao_utilizada ");

        sql.append("from mov_devolucao ");

        sql.append(" where cast(cod_mov as integer) > ").append(getCodUltimoMovimento());

        return sql;
    }
}
