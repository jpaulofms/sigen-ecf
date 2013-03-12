/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.EcfException;
import com.sigen.ecf.exception.FaltaPapelException;
import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.PoucoPapelException;
import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.persistencia.dao.IDAOVenda;
import com.sigen.ecf.persistencia.dao.impl.DAOVenda;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPCancelaVenda extends Operacao implements IOperacao {

    @Override
    protected boolean validaTransacao(Map parametros) throws OperacaoException {
        return true;
    }

    @Override
    protected void iniciar(Map parametros) throws OperacaoException {
    }

    @Override
    protected Map efetuar(Map parametros) throws OperacaoException {
        Map mpRetorno = parametros;
        IECFService ecfService = ECFServiceFactory.getInstance().criarECFService();
        try {
            /* Cancela Cupom impressora */
            ecfService.cancelaCupom();

            /* Cancelar Venda */
            BeanVenda vendaUpdate = ((BeanVenda) parametros.get("BeanVenda"));
            BeanVenda vendaCancelar = vendaUpdate.clone();
            vendaUpdate.setIndicadorCancelamento("S");
            vendaUpdate.setDataCancelamento(ecfService.getData());

            /* Update */
            IDAOVenda iDAOVenda = new DAOVenda();
            iDAOVenda.atualizar(vendaUpdate, vendaCancelar);

        } catch (EcfException ex) {
            TratamentoException.tratar(ex);
        } catch (FaltaPapelException ex) {
            TratamentoException.tratar(ex);
        } catch (PoucoPapelException ex) {
            TratamentoException.tratar(ex);
        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }
        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
        TratamentoException.avisouPapel = false;
    }
}
