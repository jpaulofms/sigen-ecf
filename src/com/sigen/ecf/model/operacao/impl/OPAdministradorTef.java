/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.view.util.UTILBiblioteca;
import com.sigen.ecf.view.util.UTILForegroundTef;
import java.util.Map;

/**
 * 
 * @author SIGEN 3
 */
public class OPAdministradorTef extends Operacao implements IOperacao {

	@Override
	protected boolean validaTransacao(Map parametros) throws OperacaoException {
		if (parametros != null && parametros.get("CupomAberto") != null
				&& (Boolean) parametros.get("CupomAberto")) {
			UTILBiblioteca.informarOperacaoNaoPermitida("Cupom Aberto");
			return false;
		}
		return true;
	}

	@Override
	protected void iniciar(Map parametros) throws OperacaoException {
	}

	@Override
	protected Map efetuar(Map parametros) throws OperacaoException {
		Map mpRetorno = parametros;

		UTILForegroundTef.executaADM();

		return mpRetorno;
	}

	@Override
	protected void finalizar(Map parametros) throws OperacaoException {
	}
}
