/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.impl;

/**
 *
 * @author Administrador
 */
public enum TEFRedeEnum {

    REDECARD("REDECARD"), CIELO("CIELO"), AMEX("AMEX"), BANESE("BANESE"), HIPERCARD("HIPERCARD");
    private String identificador;

    private TEFRedeEnum(String identificador) {
        setIdentificador(identificador);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
