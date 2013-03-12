/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.model.bean.BeanItemDevolucao;
import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.persistencia.DAOFacade;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPDevolucaoItem extends Operacao implements IOperacao {

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

        List<BeanItemVenda> lsItemDevolucao = (List<BeanItemVenda>) parametros.get("lsItemDevolucao");
        BeanMovimento movimento = (BeanMovimento) parametros.get("BeanMovimento");
        String coo = (String) parametros.get("COO");

        for (BeanItemVenda item : lsItemDevolucao) {

            BeanItemDevolucao itDevolucao = new BeanItemDevolucao();
            itDevolucao.setCodEcf(movimento.getCodEcf());
            itDevolucao.setLoja(movimento.getLoja());
            itDevolucao.setCodMov(movimento.getCodMov());
            itDevolucao.setCoo(coo);
            itDevolucao.setCodProduto(item.getCodProd());
            itDevolucao.setQuantidade(item.getQuantidadeVendida());
            itDevolucao.setValorUnitario(item.getValorUnitario());
            itDevolucao.setValorTotal(item.getValorTotal());
            itDevolucao.setDescricao(item.getDescricao());

            /* persistir dados */
            DAOFacade.inserirDevolucaoItem(itDevolucao);
        }


        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}
