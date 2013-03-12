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
import com.sigen.ecf.infra.impl.ECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.bean.BeanCondicaoPagamento;
import com.sigen.ecf.model.bean.BeanFormaCondicaoPagamento;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import com.sigen.ecf.model.bean.BeanLancamento;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanSuprimento;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.persistencia.DAOFacade;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPSuprimento extends Operacao implements IOperacao {

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
        ECFService eCFService = ECFServiceFactory.getInstance().criarECFService();

        BeanSuprimento beanSuprimento = (BeanSuprimento) parametros.get("BeanSuprimento");
        try {
            BeanFormaPagamento formaPagamento = new BeanFormaPagamento();
            formaPagamento.setTipo("DIN");
            formaPagamento = DAOFacade.getFormaPagamento(formaPagamento);
            eCFService.efetuarSuprimento(beanSuprimento.getValor().toPlainString(), formaPagamento.getDescricao());

            //BeanCondicaoPagamento condicaoPagamento = new BeanCondicaoPagamento();
            //condicaoPagamento.setDescricao("%VISTA");
            //condicaoPagamento = DAOFacade.getCondicaoPagamento(condicaoPagamento);

            BeanFormaCondicaoPagamento formaCondicaoPagamento = new BeanFormaCondicaoPagamento();
            formaCondicaoPagamento.setCodFormaPagto(formaPagamento.getCodFormaPagto());
            formaCondicaoPagamento = DAOFacade.getFormaCondicaoPagemento(formaCondicaoPagamento);

            /* Persistir */
            beanSuprimento.setLoja(((BeanMovimento) parametros.get("BeanMovimento")).getLoja());
            beanSuprimento.setCodEcf(((BeanMovimento) parametros.get("BeanMovimento")).getCodEcf());
            beanSuprimento.setCodMov(((BeanMovimento) parametros.get("BeanMovimento")).getCodMov());
            beanSuprimento.setCodOper(((BeanMovimento) parametros.get("BeanMovimento")).getCodOper());
            beanSuprimento.setCoo(eCFService.getCOO());
            beanSuprimento.setGnf(eCFService.getGNF());
            beanSuprimento.setData(eCFService.getData());
            beanSuprimento.setCodFormaPagamento(formaPagamento.getCodFormaPagto()); // Suprimentos só é feito em dinheiro ?

            /* Suprimento */
            DAOFacade.inserirSuprimento(beanSuprimento);


            BeanLancamento beanLancamento = new BeanLancamento();
            beanLancamento.setLoja(beanSuprimento.getLoja());
            beanLancamento.setCodEcf(beanSuprimento.getCodEcf());
            beanLancamento.setCodMov(beanSuprimento.getCodMov());
            beanLancamento.setCodOper(beanSuprimento.getCodOper());
            beanLancamento.setCoo(beanSuprimento.getCoo());
            beanLancamento.setCodFormaPagamento(beanSuprimento.getCodFormaPagamento());
            beanLancamento.setTipoFormaPagamento(formaPagamento.getTipo());
            beanLancamento.setCodConveniada(null);
            beanLancamento.setCodCliente(null);
            beanLancamento.setValorBruto(beanSuprimento.getValor());
            beanLancamento.setValorLiquido(beanSuprimento.getValor());
            beanLancamento.setTaxaAdm(BigDecimal.ZERO);
            beanLancamento.setDataLancamento(beanSuprimento.getData());
            beanLancamento.setCodCondicaoPagamento(formaCondicaoPagamento.getCodCondPagto()); // A vista sempre será 1 ?
            beanLancamento.setNumLancamento("1");
            beanLancamento.setNumParcela("1");
            beanLancamento.setDataVencimento(beanSuprimento.getData());


            /* Lancamento do Suprimento */
            DAOFacade.inserirLancamento(beanLancamento);


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
        TratamentoException.avisouPapel = false;
    }
}
