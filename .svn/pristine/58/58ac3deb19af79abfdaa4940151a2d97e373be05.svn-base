/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.sync.exporta;

/**
 *
 * @author desenvolvimento
 */
public class SpedFiscalSincExporta extends SincronizadorExportacao {

    public SpedFiscalSincExporta(String codigoUltimoMovimento){
        super(codigoUltimoMovimento);
    }
    
    @Override
    protected String[] getColumnNames() {
        return new String[]{"cod_ecf", "modelo_ecf", "serie_ecf", "data_referencia", "cro", "crz", "coo",
            "totalizador_geral", "venda_bruta_diaria", "cod_movimento", "loja"};
    }
    
    @Override
    protected String getTableToInsert() {
       return "ecf_mov_sped_fiscal";
    }

    @Override
    protected StringBuffer getSelectSql() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("cod_ecf, modelo_ecf, serie_ecf, data_referencia, cro, crz, ");
        sql.append("coo, totalizador_geral, venda_bruta_diaria, cod_movimento, loja ");

        sql.append("from mov_sped_fiscal ");

        sql.append(" where cast(cod_movimento as integer) > ").append(getCodUltimoMovimento());

        return sql;
    }
    
}
