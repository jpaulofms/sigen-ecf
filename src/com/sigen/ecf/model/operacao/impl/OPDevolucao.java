/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.bean.BeanDevolucao;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.model.operacao.OperacaoFactory;
import com.sigen.ecf.persistencia.DAOFacade;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPDevolucao extends Operacao implements IOperacao {

    @Override
    protected boolean validaTransacao(Map parametros) throws OperacaoException {
        return true;
    }

    @Override
    protected void iniciar(Map parametros) throws OperacaoException {
        TratamentoException.avisouPapel = false;
    }

    @Override
    protected Map efetuar(Map parametros) throws OperacaoException {
        Map mpRetorno = parametros;

        IECFService eCFService = ECFServiceFactory.getInstance().criarECFService();
        BeanDevolucao devolucao = (BeanDevolucao) parametros.get("BeanDevolucao");
        BeanMovimento beanMovimento = (BeanMovimento) parametros.get("BeanMovimento");

        /* Algo será impresso ? */
        Operacao opRelDevolucao = OperacaoFactory.getInstance().criarOPRelatorioDevolucao();
        opRelDevolucao.executar(parametros);

        devolucao.setLoja(beanMovimento.getLoja());
        devolucao.setCodEcf(beanMovimento.getCodEcf());
        devolucao.setCodMov(beanMovimento.getCodMov());
        devolucao.setCoo(eCFService.getCOO());
        devolucao.setDataDevolucao(eCFService.getData());
        devolucao.setDevolucaoUtilizada(false);

        /* Persistir dados */
        DAOFacade.inserirDevolucao(devolucao);

        /* OP dos Itens */
        parametros.put("COO", devolucao.getCoo());
        Operacao opItemDevolucao = OperacaoFactory.getInstance().criarOPDevolucaoItem();
        opItemDevolucao.executar(parametros);

        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}