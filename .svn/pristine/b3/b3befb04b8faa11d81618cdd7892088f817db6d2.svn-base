/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class BeanMovimento implements Cloneable {

    private SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
    private String loja;
    private String codEcf;
    private String codMov;
    private String codOper;
    private String coo;
    private String gnf;
    private Date dataAbertura;
    private String horaAbertura;
    private Date dataFechamento;
    private String horaFechamento;
    private String codSupervisor;
    private BigDecimal saldoDinheiroAbertura;
    private BigDecimal saldoDinheiroFechamento;

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

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
        if (dataAbertura != null) {
            this.horaAbertura = sdfTime.format(dataAbertura);
        }
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
        if (dataFechamento != null) {
            this.horaFechamento = sdfTime.format(dataFechamento);
        }
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public String getCodSupervisor() {
        return codSupervisor;
    }

    public void setCodSup(String codSupervisor) {
        this.codSupervisor = codSupervisor;
    }

    public BigDecimal getSaldoDinheiroAbertura() {
        return saldoDinheiroAbertura;
    }

    public void setSaldoDinheiroAbertura(BigDecimal saldoDinheiroAbertura) {
        this.saldoDinheiroAbertura = saldoDinheiroAbertura;
    }

    public BigDecimal getSaldoDinheiroFechamento() {
        return saldoDinheiroFechamento;
    }

    public void setSaldoDinheiroFechamento(BigDecimal saldoDinheiroFechamento) {
        this.saldoDinheiroFechamento = saldoDinheiroFechamento;
    }

    @Override
    public BeanMovimento clone() {
        BeanMovimento m = null;
        try {
            m = (BeanMovimento) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(BeanMovimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
}
