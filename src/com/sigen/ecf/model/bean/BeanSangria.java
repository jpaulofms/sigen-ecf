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
 * @author Administrador
 */
public class BeanSangria {

    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    private String loja;
    private String codEcf;
    private String codMov;
    private String codOper;
    private String coo;
    private String gnf;
    private Date data;
    private String hora;
    private String codFormaPagamento;
    private String tipoFormaPagamento;
    private BigDecimal totalSangrar;
    private BigDecimal valorSangria;
    private String observacao;

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

    public String getGnf() {
        return gnf;
    }

    public void setGnf(String gnf) {
        this.gnf = gnf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
        if (data != null) {
            this.hora = formatoHora.format(data);
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCodFormaPagamento() {
        return codFormaPagamento;
    }

    public void setCodFormaPagamento(String codFormaPagamento) {
        this.codFormaPagamento = codFormaPagamento;
    }

    public BigDecimal getTotalSangrar() {
        return totalSangrar;
    }

    public void setTotalSangrar(BigDecimal totalSangrar) {
        this.totalSangrar = totalSangrar;
    }

    public BigDecimal getValorSangria() {
        return valorSangria;
    }

    public void setValorSangria(BigDecimal valorSangria) {
        this.valorSangria = valorSangria;
    }

    public SimpleDateFormat getFormatoHora() {
        return formatoHora;
    }

    public void setFormatoHora(SimpleDateFormat formatoHora) {
        this.formatoHora = formatoHora;
    }

    public String getTipoFormaPagamento() {
        return tipoFormaPagamento;
    }

    public void setTipoFormaPagamento(String tipoFormaPagamento) {
        this.tipoFormaPagamento = tipoFormaPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
