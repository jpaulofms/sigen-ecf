package com.sigen.ecf.infra.sync.exporta;

import org.apache.commons.lang.StringUtils;

public abstract class SincronizadorExportacao extends Sincronizador {
        
        private String codUltimoMovimento;
    
        public SincronizadorExportacao(String codUltimoMovimento){
            this.codUltimoMovimento = codUltimoMovimento;
        }
        
	protected DAO getSelectDAO() {
		return DAOFactory.getEcfDao();
	}
        
        protected String getCodUltimoMovimento(){
            if(StringUtils.isEmpty(codUltimoMovimento)){
                return "0";
            }
            return codUltimoMovimento;
        }

}
