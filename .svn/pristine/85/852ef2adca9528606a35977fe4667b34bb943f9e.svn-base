/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.vo;

import com.sigen.ecf.model.bean.BeanConveniada;
import com.sigen.ecf.model.bean.BeanDevolucao;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SIGEN 3
 */
public class VOParcelaPagamento {

    private Date data;
    private BigDecimal valorParcela;
    private List<VOItemParcelaPagamento> lsItemParcelaPagamento;
    private int numeroParcela;
    private boolean entrada;

    public VOParcelaPagamento() {
        // Inicializando Item da parcela
        this.lsItemParcelaPagamento = new ArrayList<VOItemParcelaPagamento>();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public List<VOItemParcelaPagamento> getLsItemParcelaPagamento() {
        return lsItemParcelaPagamento;
    }

    public void setLsItemParcelaPagamento(List<VOItemParcelaPagamento> lsItemParcelaPagamento) {
        this.lsItemParcelaPagamento = lsItemParcelaPagamento;
    }

    public int getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    public boolean isAberta() {
        if (getValorRecebido().compareTo(this.getValorParcela()) < 0) {
            return true;
        }
        return false;
    }

    public void atualizarValor() {
        /* Atualiza o valor das parcelas com base na soma dos itens desta parcela */
        BigDecimal valorRecebido = this.getValorRecebido();
        this.setValorParcela(valorRecebido);
    }

    public BigDecimal getValorRecebido() {
        BigDecimal totalRecebido = BigDecimal.ZERO;
        for (VOItemParcelaPagamento ipp : this.lsItemParcelaPagamento) {
            totalRecebido = totalRecebido.add(ipp.getValorItemParcela());
        }
        return totalRecebido;
    }

    public void marcarEntrada() {
        for (VOItemParcelaPagamento ipp : this.lsItemParcelaPagamento) {
            if (ipp.isEntrada()) {
                this.valorParcela = this.valorParcela.add(ipp.getValorItemParcela());
            }
        }
    }

    public void adicionarItemParcela(VOCheque ipCheque, BeanConveniada ipConveniada, BeanFormaPagamento ipFormaPagamento, BigDecimal ipValor, String numeroAutorizacao, boolean isEntrada, BeanDevolucao beanDevolucao, int numeroTransacao) {

        VOItemParcelaPagamento ipp = new VOItemParcelaPagamento();
        ipp.setCheque(ipCheque != null ? ipCheque : new VOCheque());
        ipp.setConveniada(ipConveniada != null ? ipConveniada : new BeanConveniada());
        ipp.setFormaPagamento(ipFormaPagamento != null ? ipFormaPagamento : new BeanFormaPagamento());
        ipp.setIndiceItemParcela(String.valueOf(this.lsItemParcelaPagamento.size() + 1));
        ipp.setNumeroAutorizacao(numeroAutorizacao);
        ipp.setValorItemParcela(ipValor);
        ipp.setEntrada(isEntrada);
        ipp.setReciboDevolucao(beanDevolucao != null ? beanDevolucao.getCoo() : null);
        ipp.setNumeroTransacao(numeroTransacao);

        this.lsItemParcelaPagamento.add(ipp);
    }
}
