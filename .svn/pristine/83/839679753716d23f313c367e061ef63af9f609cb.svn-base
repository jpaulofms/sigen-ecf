/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.TratamentoException;
import java.util.Map;

/**
 * @author SIGEN 3
 */
public abstract class Operacao {

    public Map executar(Map parametros) {
        try {
            Map parametroRetorno = parametros;

            if (validaTransacao(parametros)) {
                iniciar(parametros);
                parametroRetorno = efetuar(parametros);
                finalizar(parametros);
            }

            return parametroRetorno;
        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }
        return null;
    }

    protected abstract boolean validaTransacao(Map parametros) throws OperacaoException;

    protected abstract void iniciar(Map parametros) throws OperacaoException;

    protected abstract Map efetuar(Map parametros) throws OperacaoException;

    protected abstract void finalizar(Map parametros) throws OperacaoException;
}
