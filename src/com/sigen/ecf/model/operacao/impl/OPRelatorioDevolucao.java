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
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author SIGEN 3
 */
public class OPRelatorioDevolucao extends Operacao implements IOperacao {

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
        List<BeanItemVenda> lsItemDevolucao = (List<BeanItemVenda>) parametros.get("lsItemDevolucao");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        try {

            if (!lsItemDevolucao.isEmpty()) {
                StringBuilder cabecalho = new StringBuilder();
                cabecalho.append(UTILBiblioteca.getLinhaCentralizada("RECIBO DEVOLUÇÃO"));
                cabecalho.append("\r\n");
                cabecalho.append("ITEM CÓDIGO      DESCRIÇÃO                   ").append("\r\n");
                cabecalho.append(UTILBiblioteca.getLinhaCentralizada("QTD    VL.UNIT.(R$)      VL.ITEM(R$)")).append("\r\n");

                /* Imprime cabecalho */
                eCFService.imprimirRelatorioGerencial(cabecalho.toString());

                BigDecimal totalItemDevolucao = BigDecimal.ZERO;
                int i = 0;
                String linhaImpressao = "";
                for (BeanItemVenda iDevolucao : lsItemDevolucao) {
                    i++;
                    linhaImpressao = linhaImpressao + UTILBiblioteca.leftpad(String.valueOf(i), 3, Character.valueOf('0')) + "  " + iDevolucao.getCodProd() + "  " + iDevolucao.getDescricao() + "\r\n";
                    linhaImpressao = linhaImpressao + UTILBiblioteca.getLinhaCentralizada(iDevolucao.getQuantidadeVendida() + "      " + nf.format(iDevolucao.getValorUnitario()).replace("R$", "") + "       " + nf.format(iDevolucao.getValorTotal()).replace("R$", "")) + "\r\n";

                    if (i % 10 == 0) {
                        /* Imprime de 10 em 10 linhas */
                        eCFService.imprimirRelatorioGerencial(linhaImpressao);
                        linhaImpressao = "";
                    }

                    /* Soma */
                    totalItemDevolucao = totalItemDevolucao.add(iDevolucao.getValorTotal());
                }
                if (!linhaImpressao.equals("")) {
                    eCFService.imprimirRelatorioGerencial(linhaImpressao);
                }

                /* Totalizando */
                linhaImpressao = "";
                linhaImpressao = "TOTAL DE ITENS: " + i + "\r\n";
                linhaImpressao = linhaImpressao + "TOTAL CRÉDITO DEVOLUÇÃO: " + nf.format(totalItemDevolucao);

                eCFService.imprimirRelatorioGerencial(linhaImpressao);
            }

        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        } finally {
            if (!lsItemDevolucao.isEmpty() && eCFService.getECFAtiva()) {
                eCFService.fecharRelatorioGerencial();
            }
            return mpRetorno;
        }

    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
        TratamentoException.avisouPapel = false;
    }
}
