/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPSairAplicacao extends Operacao implements IOperacao {

    @Override
    protected boolean validaTransacao(Map parametros) throws OperacaoException {
        if ((Boolean) parametros.get("CupomAberto")) {
            UTILBiblioteca.informarOperacaoNaoPermitida("Cupom Aberto");
            return false;
        }
        return true;
    }

    @Override
    protected void iniciar(Map parametros) throws OperacaoException {
    }

    @Override
    protected HashMap efetuar(Map parametros) throws OperacaoException {
        try {
            /* Sair da Aplicação */
            System.exit(0);

        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }
        return null;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}
