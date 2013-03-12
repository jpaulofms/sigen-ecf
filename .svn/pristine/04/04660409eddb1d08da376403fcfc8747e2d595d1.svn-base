/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

/**
 *
 * @author SIGEN 3
 */
public class BeanCondicaoPagamento implements Comparable<BeanCondicaoPagamento> {

    private String codCondPagto;
    private String descricao;
    private int parcelaMax;
    private int diasEntreParcelas;
    private boolean exigeEntrada;

    public String getCodCondPagto() {
        return codCondPagto;
    }

    public void setCodCondPagto(String codCondPagto) {
        this.codCondPagto = codCondPagto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getParcelaMax() {
        return parcelaMax;
    }

    public void setParcelaMax(int parcelaMax) {
        this.parcelaMax = parcelaMax;
    }

    public int getDiasEntreParcelas() {
        return diasEntreParcelas;
    }

    public void setDiasEntreParcelas(int diasEntreParcelas) {
        this.diasEntreParcelas = diasEntreParcelas;
    }

    public boolean isExigeEntrada() {
        return exigeEntrada;
    }

    public void setExigeEntrada(boolean exigeEntrada) {
        this.exigeEntrada = exigeEntrada;
    }

    public String getStringCombo() {
        return this.getCodCondPagto().concat(" - ").concat(this.getDescricao());
    }

    @Override
    public String toString() {
        return getCodCondPagto().toString() + " - " + getDescricao().toString();
    }

    @Override
    public int compareTo(BeanCondicaoPagamento o) {
        return getCodCondPagto().compareTo(o.getCodCondPagto());
    }
}
