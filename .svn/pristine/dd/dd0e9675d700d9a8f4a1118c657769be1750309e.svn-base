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
public class BeanSuprimento {

    SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
    private String loja;
    private String codEcf;
    private String codMov;
    private String codOper;
    private String coo;
    private String gnf;
    private Date data;
    private String hora;
    private String codFormaPagamento;
    private BigDecimal valor;

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
            this.hora = formatHora.format(data);
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
