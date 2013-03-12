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
import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.persistencia.dao.IDAOItemVenda;
import com.sigen.ecf.persistencia.dao.impl.DAOItemVenda;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPCancelaItemVenda extends Operacao implements IOperacao {

    @Override
    protected boolean validaTransacao(Map parametros) throws OperacaoException {
        return true;
    }

    @Override
    protected void iniciar(Map parametros) throws OperacaoException {
    }

    @Override
    protected Map efetuar(Map parametros) throws OperacaoException {
        IECFService ecfService = ECFServiceFactory.getInstance().criarECFService();
        Map mpRetorno = parametros;
        try {
            BeanItemVenda itemVendaCancela = (BeanItemVenda) parametros.get("BeanItemCancelar");
            BeanItemVenda itemVendaAntigo = itemVendaCancela.clone();

            /* Cancelar Item ECF */
            ecfService.cancelarItemVenda(itemVendaCancela.getItem());

            /* Dados de cancelamento */
            itemVendaCancela.setIndicadorCancelamento("S");
            itemVendaCancela.setDataCancelamento(ecfService.getData());

            /* Update */
            IDAOItemVenda iDAOItemVenda = new DAOItemVenda();
            iDAOItemVenda.atualizar(itemVendaCancela, itemVendaAntigo);

            /* Remover Item cancelar do mapa */
            mpRetorno.remove("beanItemCancelar");

        } catch (FaltaPapelException ex) {
            TratamentoException.tratar(ex);
        } catch (PoucoPapelException ex) {
            TratamentoException.tratar(ex);
        } catch (EcfException ex) {
            TratamentoException.tratar(ex);
        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }

        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}
