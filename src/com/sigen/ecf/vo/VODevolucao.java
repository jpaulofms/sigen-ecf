/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class VODevolucao implements Cloneable {

    private String codCli;
    private String nomeCli;
    private String nrRecibo;
    private BigDecimal vlRecibo;
    private BigDecimal vlUtilizado;
    private BigDecimal vlSaldoImpressao;
    private String tpNota;
    private String numNota;
    private String numSerie;
    private String numReciboAnt;
    private String status;
    private String codFil;
    private Date dtNota;
    private Date dtRecibo;
    private String cpfCnj;

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getNrRecibo() {
        return nrRecibo;
    }

    public void setNrRecibo(String nrRecibo) {
        this.nrRecibo = nrRecibo;
    }

    public BigDecimal getVlUtilizado() {
        return vlUtilizado;
    }

    public void setVlUtilizado(BigDecimal vlUtilizado) {
        this.vlUtilizado = vlUtilizado;
    }

    public BigDecimal getVlRecibo() {
        return vlRecibo;
    }

    public void setVlRecibo(BigDecimal vlRecibo) {
        this.vlRecibo = vlRecibo;
    }

    public String getCodCli() {
        return codCli;
    }

    public void setCodCli(String codCli) {
        this.codCli = codCli;
    }

    public String getCodFil() {
        return codFil;
    }

    public void setCodFil(String codFil) {
        this.codFil = codFil;
    }

    public String getNumNota() {
        return numNota;
    }

    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }

    public String getNumReciboAnt() {
        return numReciboAnt;
    }

    public void setNumReciboAnt(String numReciboAnt) {
        this.numReciboAnt = numReciboAnt;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTpNota() {
        return tpNota;
    }

    public void setTpNota(String tpNota) {
        this.tpNota = tpNota;
    }

    public Date getDtNota() {
        return dtNota;
    }

    public void setDtNota(Date dtNota) {
        this.dtNota = dtNota;
    }

    public Date getDtRecibo() {
        return dtRecibo;
    }

    public void setDtRecibo(Date dtRecibo) {
        this.dtRecibo = dtRecibo;
    }

    public String getCpfCnj() {
        return cpfCnj;
    }

    public void setCpfCnj(String cpfCnj) {
        this.cpfCnj = cpfCnj;
    }

    public BigDecimal getVlSaldoImpressao() {
        return vlSaldoImpressao;
    }

    public void setVlSaldoImpressao(BigDecimal vlSaldoImpressao) {
        this.vlSaldoImpressao = vlSaldoImpressao;
    }

    @Override
    public VODevolucao clone() {
        VODevolucao devolucaoVORetorno = new VODevolucao();

        try {
            devolucaoVORetorno = (VODevolucao) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return devolucaoVORetorno;
    }
}
