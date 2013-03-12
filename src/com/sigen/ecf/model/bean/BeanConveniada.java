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
public class BeanConveniada implements Comparable<BeanConveniada> {

    private String codConveniada;
    private String descricao;
    private BigDecimal taxaAdm;

    public String getCodConveniada() {
        return codConveniada;
    }

    public void setCodConveniada(String codConveniada) {
        this.codConveniada = codConveniada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getTaxaAdm() {
        return taxaAdm;
    }

    public void setTaxaAdm(BigDecimal taxaAdm) {
        this.taxaAdm = taxaAdm;
    }

    @Override
    public String toString() {
        return getCodConveniada() + " - " + getDescricao();
    }

    @Override
    public int compareTo(BeanConveniada o) {
        return getCodConveniada().compareTo(o.getCodConveniada());
    }

    public boolean isEmpty() {
        boolean result = (this.getCodConveniada() != null && !this.getCodConveniada().equals("")) ? false : true;
        result = (this.getDescricao() != null && !this.getDescricao().equals("")) ? false : true;

        return result;
    }
}
