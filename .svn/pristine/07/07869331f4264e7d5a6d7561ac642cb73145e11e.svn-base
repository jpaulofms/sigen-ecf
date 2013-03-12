/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.persistencia.dao.IDAOVenda;
import com.sigen.ecf.persistencia.dao.impl.DAOVenda;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPVenda extends Operacao implements IOperacao {

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
        try {
            IECFService ecfService = ECFServiceFactory.getInstance().criarECFService();

            BeanVenda venda = new BeanVenda();
            venda.setLoja(((BeanMovimento) parametros.get("BeanMovimento")).getLoja());
            venda.setCodEcf(((BeanMovimento) parametros.get("BeanMovimento")).getCodEcf());
            venda.setDataEmissao(ecfService.getData());
            venda.setValorSubTotal(BigDecimal.ZERO);
            venda.setValorDesconto(BigDecimal.ZERO);
            venda.setValorAcrescimo(BigDecimal.ZERO);
            venda.setValorTotal(BigDecimal.ZERO);
            venda.setIndicadorCancelamento("N");
            venda.setNomeAdquirente(parametros.get("BeanCliente") != null ? ((BeanCliente) parametros.get("BeanCliente")).getNome() : "");
            venda.setCpfCnpjAdquirente(parametros.get("BeanCliente") != null ? ((BeanCliente) parametros.get("BeanCliente")).getCpfCnpj() : "");
            venda.setCodMov(((BeanMovimento) parametros.get("BeanMovimento")).getCodMov());
            venda.setCodOper(((BeanOperador) parametros.get("BeanOperador")).getCodOper());

            /* Abrir Cupom */
            ecfService.abrirCupom(venda.getCpfCnpjAdquirente() != null ? venda.getCpfCnpjAdquirente() : "");

            /* Número do cupom */
            venda.setCoo(ecfService.getCOO());

            /* Registrar venda */
            IDAOVenda iVenda = new DAOVenda();
            iVenda.inserir(venda);

            /* Retorno */
            mpRetorno.put("BeanVenda", venda);

        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }
        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}
