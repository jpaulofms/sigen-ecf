/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.persistencia.DAOFacade;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPDescontoItem extends Operacao implements IOperacao {

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
            BeanItemVenda itemDesconto = (BeanItemVenda) parametros.get("BeanItemDesconto");
            String tipoDesconto = (String) parametros.get("tipoDesconto");
            BigDecimal valorDesconto = (BigDecimal) parametros.get("valorDesconto");
            BigDecimal valorDescontoPercOuReal = (BigDecimal) parametros.get("valorDescontoPercOuReal");

            /* Desconto Item ECF */
            ecfService.inserirDescontoItem(itemDesconto.getItem(), "D", tipoDesconto, valorDescontoPercOuReal);

            BeanItemVenda itemVendaAntigo = itemDesconto.clone();

            /* Dados de cancelamento */
            itemDesconto.setValorDesconto(valorDesconto);
            itemDesconto.setValorTotal(itemDesconto.getValorTotal().subtract(valorDesconto));

            /* Update */
            DAOFacade.atualizarItemVenda(itemDesconto, itemVendaAntigo);

            /* Remover dados do mapa */
            mpRetorno.remove("BeanItemDesconto");
            mpRetorno.remove("tipoDesconto");
            mpRetorno.remove("valorDesconto");

        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }

        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}
