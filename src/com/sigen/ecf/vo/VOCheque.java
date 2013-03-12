/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.vo;

import java.util.Date;

/**
 *
 * @author SIGEN 3
 */
public class VOCheque {

    private String codBanco;
    private String codAgencia;
    private String contaCorrente;
    private String numeroCheque;
    private Date data;

    public VOCheque() {
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(String codAgencia) {
        this.codAgencia = codAgencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isEmpty() {
        boolean result = (this.getCodBanco() != null && !this.getCodBanco().equals("")) ? false : true;
        result = (this.getCodAgencia() != null && !this.getCodAgencia().equals("")) ? false : true;
        result = (this.getContaCorrente() != null && !this.getContaCorrente().equals("")) ? false : true;
        result = (this.getNumeroCheque() != null && !this.getNumeroCheque().equals("")) ? false : true;
        result = this.getData() != null ? false : true;

        return result;
    }

    @Override
    public String toString() {
        return getCodBanco() + "/" + getCodAgencia() + "/" + getContaCorrente() + "/" + getNumeroCheque() + " ";
    }
}
