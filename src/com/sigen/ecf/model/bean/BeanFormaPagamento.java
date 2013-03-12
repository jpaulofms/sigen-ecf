/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

import java.math.BigDecimal;

/**
 *
 * @author Administrador
 */
public class BeanFormaPagamento implements Comparable<BeanFormaPagamento> {

    private String codFormaPagto;
    private String tipo;
    private String descricao;
    private boolean pagamentoAVista;
    private boolean pagamentoAPrazo;

    public String getCodFormaPagto() {
        return codFormaPagto;
    }

    public void setCodFormaPagto(String codFormaPagto) {
        this.codFormaPagto = codFormaPagto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPagamentoAVista() {
        return pagamentoAVista;
    }

    public void setPagamentoAVista(boolean pagamentoAVista) {
        this.pagamentoAVista = pagamentoAVista;
    }

    public boolean isPagamentoAPrazo() {
        return pagamentoAPrazo;
    }

    public void setPagamentoAPrazo(boolean pagamentoAPrazo) {
        this.pagamentoAPrazo = pagamentoAPrazo;
    }

    public boolean isPermiteTroco() {
        if (!getTipo().equalsIgnoreCase("DIN")) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getCodFormaPagto().concat(" - ").concat(this.getDescricao().toUpperCase());
    }

    @Override
    public int compareTo(BeanFormaPagamento o) {
        return getCodFormaPagto().compareTo(o.getCodFormaPagto());
    }
}
