/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPAbrirGaveta extends Operacao implements IOperacao {

    @Override
    protected boolean validaTransacao(Map parametros) throws OperacaoException {
        return true;
    }

    @Override
    protected void iniciar(Map parametros) throws OperacaoException {
    }

    @Override
    protected Map efetuar(Map parametros) throws OperacaoException {
        ECFServiceFactory.getInstance().criarECFService().abrirGaveta();
        return parametros;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}
