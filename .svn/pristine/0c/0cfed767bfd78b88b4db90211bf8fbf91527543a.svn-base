/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.sync.exporta;

/**
 *
 * @author desenvolvimento
 */
public class SpedFiscalAliquotaSincExporta extends SincronizadorExportacao {

    public SpedFiscalAliquotaSincExporta(String codigoUltimoMovimento){
        super(codigoUltimoMovimento);
    }
    
    
   @Override
    protected String[] getColumnNames() {
        return new String[]{"aliquota", "valor_aliquota", "data_referencia", "cod_ecf",
            "cod_movimento", "loja", "id"};
    }
    
    @Override
    protected String getTableToInsert() {
       return "ecf_mov_sped_fiscal_aliquota";
    }

    @Override
    protected StringBuffer getSelectSql() {
        StringBuffer sql = new StringBuffer();

        sql.append("select ");
        sql.append("aliquota, valor_aliquota, data_referencia, cod_ecf, cod_movimento, loja, id ");

        sql.append("from mov_sped_fiscal_aliquota ");

        sql.append(" where cast(cod_movimento as integer) > ").append(getCodUltimoMovimento());

        return sql;
    }   
    
}
