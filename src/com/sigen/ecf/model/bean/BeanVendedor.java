/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

/**
 *
 * @author Administrador
 */
public class BeanVendedor {

    private String codVendedor;
    private String nome;

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codOper) {
        this.codVendedor = codOper;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getCodVendedor() + " - " + getNome();
    }
}
