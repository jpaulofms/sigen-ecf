/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import java.util.Map;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.infra.TEFService;
import com.sigen.ecf.infra.impl.TEFServiceFactory;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.view.util.UTILBiblioteca;

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

		TEFService tefService = TEFServiceFactory.getInstance()
				.criarTEFService();
		Map mpRetorno = parametros;

		tefService.executaADM();

		return mpRetorno;
	}

	@Override
	protected void finalizar(Map parametros) throws OperacaoException {
	}
}
