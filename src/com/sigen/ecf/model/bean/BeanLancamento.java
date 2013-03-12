/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Paulisson
 */
public class BeanLancamento {

    private SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    private String loja;
    private String codEcf;
    private String codMov;
    private String codOper;
    private String coo;
    private String codFormaPagamento;
    private String tipoFormaPagamento;
    private String codConveniada;
    private String codCliente;
    private BigDecimal taxaAdm;
    private BigDecimal valorBruto;
    private BigDecimal valorLiquido;
    private Date dataLancamento;
    private String horaLancamento;
    private String codCondicaoPagamento;
    private String numLancamento;
    private String numParcela;
    private Date dataVencimento;
    private String chqBanco;
    private String chqAgencia;
    private String chqConta;
    private String chqNumero;
    private String reciboDevolucao;
    private String numeroAutorizacao;

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getCodEcf() {
        return codEcf;
    }

    public void setCodEcf(String codEcf) {
        this.codEcf = codEcf;
    }

    public String getCodMov() {
        return codMov;
    }

    public void setCodMov(String codMov) {
        this.codMov = codMov;
    }

    public String getCodOper() {
        return codOper;
    }

    public void setCodOper(String codOper) {
        this.codOper = codOper;
    }

    public String getCoo() {
        return coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

    public String getCodFormaPagamento() {
        return codFormaPagamento;
    }

    public void setCodFormaPagamento(String codFormaPagamento) {
        this.codFormaPagamento = codFormaPagamento;
    }

    public String getTipoFormaPagamento() {
        return tipoFormaPagamento;
    }

    public void setTipoFormaPagamento(String tipoFormaPagamento) {
        this.tipoFormaPagamento = tipoFormaPagamento;
    }

    public String getCodConveniada() {
        return codConveniada;
    }

    public void setCodConveniada(String codConveniada) {
        this.codConveniada = codConveniada;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public BigDecimal getTaxaAdm() {
        return taxaAdm;
    }

    public void setTaxaAdm(BigDecimal taxaAdm) {
        this.taxaAdm = taxaAdm;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(BigDecimal valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
        if (dataLancamento != null) {
            this.horaLancamento = formatoHora.format(dataLancamento);
        }
    }

    public String getHoraLancamento() {
        return horaLancamento;
    }

    public void setHoraLancamento(String horaLancamento) {
        this.horaLancamento = horaLancamento;
    }

    public String getCodCondicaoPagamento() {
        return codCondicaoPagamento;
    }

    public void setCodCondicaoPagamento(String codCondicaoPagamento) {
        this.codCondicaoPagamento = codCondicaoPagamento;
    }

    public String getNumLancamento() {
        return numLancamento;
    }

    public void setNumLancamento(String numLancamento) {
        this.numLancamento = numLancamento;
    }

    public String getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(String numParcela) {
        this.numParcela = numParcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getChqBanco() {
        return chqBanco;
    }

    public void setChqBanco(String chqBanco) {
        this.chqBanco = chqBanco;
    }

    public String getChqAgencia() {
        return chqAgencia;
    }

    public void setChqAgencia(String chqAgencia) {
        this.chqAgencia = chqAgencia;
    }

    public String getChqConta() {
        return chqConta;
    }

    public void setChqConta(String chqConta) {
        this.chqConta = chqConta;
    }

    public String getChqNumero() {
        return chqNumero;
    }

    public void setChqNumero(String chqNumero) {
        this.chqNumero = chqNumero;
    }

    public String getReciboDevolucao() {
        return reciboDevolucao;
    }

    public void setReciboDevolucao(String reciboDevolucao) {
        this.reciboDevolucao = reciboDevolucao;
    }

    public String getNumeroAutorizacao() {
        return numeroAutorizacao;
    }

    public void setNumeroAutorizacao(String numeroAutorizacao) {
        this.numeroAutorizacao = numeroAutorizacao;
    }
}
