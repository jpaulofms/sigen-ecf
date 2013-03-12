/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.vo;

import com.sigen.ecf.model.bean.BeanConveniada;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.math.BigDecimal;

/**
 *
 * @author SIGEN 3
 */
public class VOItemParcelaPagamento {

    private String indiceItemParcela;
    private BeanFormaPagamento formaPagamento;
    private BeanConveniada conveniada;
    private VOCheque cheque;
    private BigDecimal valorItemParcela;
    private String numeroAutorizacao;
    private String reciboDevolucao;
    private boolean entrada;
    private int numeroTransacao;

    public String getIndiceItemParcela() {
        return indiceItemParcela;
    }

    public void setIndiceItemParcela(String indiceItemParcela) {
        this.indiceItemParcela = UTILBiblioteca.leftpad(String.valueOf(indiceItemParcela), 3, '0');
    }

    public BeanFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(BeanFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BeanConveniada getConveniada() {
        return conveniada;
    }

    public void setConveniada(BeanConveniada conveniada) {
        this.conveniada = conveniada;
    }

    public VOCheque getCheque() {
        return cheque;
    }

    public void setCheque(VOCheque cheque) {
        this.cheque = cheque;
    }

    public BigDecimal getValorItemParcela() {
        return valorItemParcela;
    }

    public void setValorItemParcela(BigDecimal valorItemParcela) {
        this.valorItemParcela = valorItemParcela;
    }

    public String getNumeroAutorizacao() {
        return numeroAutorizacao;
    }

    public void setNumeroAutorizacao(String numeroAutorizacao) {
        this.numeroAutorizacao = numeroAutorizacao;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    public String getReciboDevolucao() {
        return reciboDevolucao;
    }

    public void setReciboDevolucao(String reciboDevolucao) {
        this.reciboDevolucao = reciboDevolucao;
    }

    public int getNumeroTransacao() {
        return numeroTransacao;
    }

    public void setNumeroTransacao(int numeroTransacao) {
        this.numeroTransacao = numeroTransacao;
    }

    public String getFormaPagamentoDescricao() {
        if (isEntrada()) {
            return getFormaPagamento().getDescricao().concat(" (E) ");
        }
        return getFormaPagamento().getDescricao();
    }

    public String getKeyString() {

        String stringKey = "";

        if (getFormaPagamento() != null && !getFormaPagamento().equals("")) {
            stringKey = getFormaPagamento().getDescricao()/*.toUpperCase()*/.concat("=");
        }
        if (!getConveniada().isEmpty()) {
            stringKey = stringKey.concat(getConveniada().toString()) + getNumeroTransacao();
        }
        if (!getCheque().isEmpty()) {
            stringKey = stringKey.concat(getCheque().toString());
        }
        return stringKey;
    }
}
