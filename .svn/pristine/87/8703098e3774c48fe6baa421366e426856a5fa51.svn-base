/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

import com.sigen.ecf.view.util.UTILBiblioteca;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class BeanVenda implements Cloneable {

    private String coo;
    private String loja;
    private String codEcf;
    private Date dataEmissao;
    private String horaEmissao;
    private Date dataCancelamento;
    private String horaCancelamento;
    private BigDecimal valorSubTotal;
    private BigDecimal valorDesconto;
    private BigDecimal valorAcrescimo;
    private BigDecimal valorTotal;
    private String indicadorCancelamento;
    private String nomeAdquirente;
    private String cpfCnpjAdquirente;
    private String codMov;
    private String codOper;

    public String getCoo() {
        return coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

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

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
        if (dataEmissao != null) {
            this.horaEmissao = UTILBiblioteca.formatoHora.format(dataEmissao);
        }
    }

    public String getHoraEmissao() {
        return horaEmissao;
    }

    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
        if (dataCancelamento != null) {
            this.horaCancelamento = UTILBiblioteca.formatoHora.format(dataCancelamento);
        }
    }

    public String getHoraCancelamento() {
        return horaCancelamento;
    }

    public void setHoraCancelamento(String horaCancelamento) {
        this.horaCancelamento = horaCancelamento;
    }

    public BigDecimal getValorSubTotal() {
        return valorSubTotal;
    }

    public void setValorSubTotal(BigDecimal valorSubTotal) {
        this.valorSubTotal = valorSubTotal;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(BigDecimal valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getIndicadorCancelamento() {
        return indicadorCancelamento;
    }

    public void setIndicadorCancelamento(String indicadorCancelamento) {
        this.indicadorCancelamento = indicadorCancelamento;
    }

    public String getNomeAdquirente() {
        return nomeAdquirente;
    }

    public void setNomeAdquirente(String nomeAdquirente) {
        this.nomeAdquirente = nomeAdquirente;
    }

    public String getCpfCnpjAdquirente() {
        return cpfCnpjAdquirente;
    }

    public void setCpfCnpjAdquirente(String cpfCnpjAdquirente) {
        this.cpfCnpjAdquirente = cpfCnpjAdquirente;
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

    @Override
    public BeanVenda clone() {
        BeanVenda bv = null;
        try {
            bv = (BeanVenda) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(BeanVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bv;
    }
}
