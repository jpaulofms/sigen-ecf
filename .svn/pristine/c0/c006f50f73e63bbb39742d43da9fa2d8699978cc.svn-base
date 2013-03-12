/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.bean.BeanCondicaoPagamento;
import com.sigen.ecf.model.bean.BeanFormaCondicaoPagamento;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import com.sigen.ecf.model.bean.BeanLancamento;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.model.bean.BeanSuprimento;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.model.operacao.OperacaoFactory;
import com.sigen.ecf.persistencia.DAOFacade;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPMovimentoAbertura extends Operacao implements IOperacao {

    private Date data;
    private String codEcf;
    private String loja;

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
        Map parametrosRetorno = parametros;
        boolean result = true;
        try {
            IECFService ecfService = ECFServiceFactory.getInstance().criarECFService();
            data = ecfService.getData();
            codEcf = (String) parametros.get("codEcf");
            loja = (String) parametros.get("loja");

            BeanMovimento movimentoPesquisa = new BeanMovimento();
            movimentoPesquisa.setCodEcf(codEcf);
            movimentoPesquisa.setLoja(loja);
            String clausula = "ORDER BY CAST(COD_MOVIMENTO AS INTEGER) DESC, DATA_ABERTURA DESC, COO DESC";
            List<BeanMovimento> lsMovimentoDia = DAOFacade.getLsMovimento(movimentoPesquisa, clausula);
            // Cod Movimento do dia
            String codMov = "1";
            if (!lsMovimentoDia.isEmpty()) {
                codMov = String.valueOf(Integer.parseInt(lsMovimentoDia.get(0).getCodMov()) + 1);
            }

            /* emitir comprovante de entrada do operador */
            ecfService.imprimeComprovanteEntradaOperador(
                    ((BeanOperador) parametros.get("BeanOperador")).getCodOper(),
                    ((BeanOperador) parametros.get("BeanOperador")).getNome(),
                    ((BigDecimal) parametros.get("saldoMovimentoAnterior")),
                    BigDecimal.ZERO);


            /* Caso valor do suprimento seja maior que zero inserir lancamento do suprimento */
            BigDecimal valorSuprimento = (BigDecimal) parametros.get("saldoSuprimento");
            BigDecimal saldoMovAnterior = (BigDecimal) parametros.get("saldoMovimentoAnterior");

            BeanMovimento movimento = new BeanMovimento();

            movimento.setCodEcf(codEcf);
            movimento.setCodMov(codMov);
            movimento.setCodOper(((BeanOperador) parametros.get("BeanOperador")).getCodOper());
            movimento.setCodSup(((BeanOperador) parametros.get("BeanSupervisor")).getCodOper());
            movimento.setCoo(ecfService.getCOO());
            movimento.setGnf(ecfService.getGNF());
            movimento.setLoja(loja);
            movimento.setDataAbertura(data);
            movimento.setSaldoDinheiroAbertura(saldoMovAnterior);

            /* Gravar os dados do movimento de abertura */
            DAOFacade.inserirMovimento(movimento);

            if (valorSuprimento.compareTo(BigDecimal.ZERO) > 0) {
                /* Inserir valor de suprimento */
                efetuarSuprimento(valorSuprimento, parametros, saldoMovAnterior, movimento);
            }

            if (saldoMovAnterior.compareTo(BigDecimal.ZERO) > 0) {
                /* Inserir lancamento de fundo de troco */
                efetuarLancamentoFundoTroco(saldoMovAnterior, movimento);
            }

            /* Map de Retorno */
            parametrosRetorno.put("BeanMovimento", movimento);

        } catch (Exception ex) {
            TratamentoException.tratar(ex);
            result = false;
        }
        parametrosRetorno.put("result", result);
        return parametrosRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
        TratamentoException.avisouPapel = false;
    }

    private void efetuarLancamentoFundoTroco(BigDecimal saldoMovAnterior, BeanMovimento movimento) {
        if (saldoMovAnterior.compareTo(BigDecimal.ZERO) > 0) {
            BeanFormaPagamento formaPagamento = new BeanFormaPagamento();
            formaPagamento.setTipo("DIN");
            formaPagamento = DAOFacade.getFormaPagamento(formaPagamento);

//            BeanCondicaoPagamento condicaoPagamento = new BeanCondicaoPagamento();
//            condicaoPagamento.setDescricao("%VISTA");
//            condicaoPagamento = DAOFacade.getCondicaoPagamento(condicaoPagamento);
            
            BeanFormaCondicaoPagamento formaCondicaoPagamento = new BeanFormaCondicaoPagamento();
            formaCondicaoPagamento.setCodFormaPagto(formaPagamento.getCodFormaPagto());
            formaCondicaoPagamento = DAOFacade.getFormaCondicaoPagemento(formaCondicaoPagamento);

            BeanLancamento beanLancamento = new BeanLancamento();
            beanLancamento.setLoja(movimento.getLoja());
            beanLancamento.setCodEcf(movimento.getCodEcf());
            beanLancamento.setCodMov(movimento.getCodMov());
            beanLancamento.setCodOper(movimento.getCodOper());
            beanLancamento.setCoo(movimento.getCoo());
            beanLancamento.setCodFormaPagamento(formaPagamento.getCodFormaPagto());
            beanLancamento.setTipoFormaPagamento(formaPagamento.getTipo());
            beanLancamento.setCodConveniada(null);
            beanLancamento.setCodCliente(null);
            beanLancamento.setValorBruto(saldoMovAnterior);
            beanLancamento.setValorLiquido(saldoMovAnterior);
            beanLancamento.setTaxaAdm(BigDecimal.ZERO);
            beanLancamento.setDataLancamento(data);
            beanLancamento.setCodCondicaoPagamento(formaCondicaoPagamento.getCodCondPagto()); // A vista sempre será 1 ?
            beanLancamento.setNumLancamento("1");
            beanLancamento.setNumParcela("1");
            beanLancamento.setDataVencimento(data);

            /* Lancamento do Fundo de Troco */
            DAOFacade.inserirLancamento(beanLancamento);
        }
    }

    private void efetuarSuprimento(BigDecimal valorSuprimento, Map parametros, BigDecimal saldoMovAnterior, BeanMovimento movimento) {
        BeanSuprimento beanSuprimento = new BeanSuprimento();
        beanSuprimento.setValor(valorSuprimento);

        parametros.put("BeanSuprimento", beanSuprimento);
        parametros.put("saldoMovAnterior", saldoMovAnterior);
        parametros.put("BeanMovimento", movimento);

        Operacao efetuarSuprimento = OperacaoFactory.getInstance().criarOPSuprimento();
        efetuarSuprimento.executar(parametros);

        parametros.remove(beanSuprimento);
        parametros.remove(saldoMovAnterior);
    }
}
