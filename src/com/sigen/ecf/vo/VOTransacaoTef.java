/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.vo;

import com.sigen.ecf.model.bean.BeanConveniada;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import java.math.BigDecimal;

/**
 *
 * @author Administrador
 */
public class VOTransacaoTef {

    private String tipoTransacao;
    private BeanConveniada beanConveniada;
    private BigDecimal valor;
    private Integer numeroParcelas;
    private BeanFormaPagamento beanFormaPagamento;
    private String nsu;
    private String dataTransacao;
    private String horaTransacao;
    private int numeroTransacao;

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BeanConveniada getBeanConveniada() {
        return beanConveniada;
    }

    public void setBeanConveniada(BeanConveniada beanConveniada) {
        this.beanConveniada = beanConveniada;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public BeanFormaPagamento getBeanFormaPagamento() {
        return beanFormaPagamento;
    }

    public void setBeanFormaPagamento(BeanFormaPagamento beanFormaPagamento) {
        this.beanFormaPagamento = beanFormaPagamento;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getHoraTransacao() {
        return horaTransacao;
    }

    public void setHoraTransacao(String horaTransacao) {
        this.horaTransacao = horaTransacao;
    }

    public int getNumeroTransacao() {
        return numeroTransacao;
    }

    public void setNumeroTransacao(int numeroTransacao) {
        this.numeroTransacao = numeroTransacao;
    }
}
