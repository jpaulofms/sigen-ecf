/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

/**
 *
 * @author Administrador
 */
public class BeanUnidadeMedida implements Comparable<BeanUnidadeMedida> {

    private String codUnidade;
    private String descricao;

    public String getCodUnidade() {
        return codUnidade;
    }

    public void setCodUnidade(String codUnidade) {
        this.codUnidade = codUnidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getCodUnidade() + " - " + getDescricao();
    }

    @Override
    public int compareTo(BeanUnidadeMedida o) {
        return getCodUnidade().compareTo(o.getCodUnidade());
    }
}
