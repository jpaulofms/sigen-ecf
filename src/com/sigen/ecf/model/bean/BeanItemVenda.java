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
public class BeanItemVenda implements Cloneable {

    private String coo;
    private String item;
    private String codMov;
    private String codOper;
    private String loja;
    private String codEcf;
    private String codProd;
    private String descricao;
    private BigDecimal quantidadeVendida;
    private String codUnd;
    private String undDescricao;
    private BigDecimal valorUnitario;
    private BigDecimal valorDesconto;
    private BigDecimal valorAcrescimo;
    private BigDecimal valorTotal;
    private String st;
    private String indicadorCancelamento;
    private BigDecimal quantidadeEmbalagem;
    private String icmsSt;
    private BigDecimal icmsRedBc;
    private BigDecimal icmsAliq;
    private BigDecimal icmsBc;
    private BigDecimal icmsValor;
    private String ipiSt;
    private BigDecimal ipiAliq;
    private BigDecimal ipiBc;
    private BigDecimal ipiValor;
    private String pisSt;
    private BigDecimal pisAliq;
    private BigDecimal pisBc;
    private BigDecimal pisValor;
    private String cofinsSt;
    private BigDecimal cofinsAliq;
    private BigDecimal cofinsBc;
    private BigDecimal cofinsValor;
    private String iat;
    private BigDecimal decimaisQuantidade;
    private BigDecimal decimaisValor;
    private Date dataEmissao;
    private String horaEmissao;
    private Date dataCancelamento;
    private String horaCancelamento;
    private String cfop;
    private String codVendedor;

    public String getCoo() {
        return coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(BigDecimal quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public String getCodUnd() {
        return codUnd;
    }

    public void setCodUnd(String codUnd) {
        this.codUnd = codUnd;
    }

    public String getUndDescricao() {
        return undDescricao;
    }

    public void setUndDescricao(String undDescricao) {
        this.undDescricao = undDescricao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
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

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getIndicadorCancelamento() {
        return indicadorCancelamento;
    }

    public void setIndicadorCancelamento(String indicadorCancelamento) {
        this.indicadorCancelamento = indicadorCancelamento;
    }

    public BigDecimal getQuantidadeEmbalagem() {
        return quantidadeEmbalagem;
    }

    public void setQuantidadeEmbalagem(BigDecimal quantidadeEmbalagem) {
        this.quantidadeEmbalagem = quantidadeEmbalagem;
    }

    public String getIcmsSt() {
        return icmsSt;
    }

    public void setIcmsSt(String icmsSt) {
        this.icmsSt = icmsSt;
    }

    public BigDecimal getIcmsRedBc() {
        return icmsRedBc;
    }

    public void setIcmsRedBc(BigDecimal icmsRedBc) {
        this.icmsRedBc = icmsRedBc;
    }

    public BigDecimal getIcmsAliq() {
        return icmsAliq;
    }

    public void setIcmsAliq(BigDecimal icmsAliq) {
        this.icmsAliq = icmsAliq;
    }

    public BigDecimal getIcmsBc() {
        return icmsBc;
    }

    public void setIcmsBc(BigDecimal icmsBc) {
        this.icmsBc = icmsBc;
    }

    public BigDecimal getIcmsValor() {
        return icmsValor;
    }

    public void setIcmsValor(BigDecimal icmsValor) {
        this.icmsValor = icmsValor;
    }

    public String getIpiSt() {
        return ipiSt;
    }

    public void setIpiSt(String ipiSt) {
        this.ipiSt = ipiSt;
    }

    public BigDecimal getIpiAliq() {
        return ipiAliq;
    }

    public void setIpiAliq(BigDecimal ipiAliq) {
        this.ipiAliq = ipiAliq;
    }

    public BigDecimal getIpiBc() {
        return ipiBc;
    }

    public void setIpiBc(BigDecimal ipiBc) {
        this.ipiBc = ipiBc;
    }

    public BigDecimal getIpiValor() {
        return ipiValor;
    }

    public void setIpiValor(BigDecimal ipiValor) {
        this.ipiValor = ipiValor;
    }

    public String getPisSt() {
        return pisSt;
    }

    public void setPisSt(String pisSt) {
        this.pisSt = pisSt;
    }

    public BigDecimal getPisAliq() {
        return pisAliq;
    }

    public void setPisAliq(BigDecimal pisAliq) {
        this.pisAliq = pisAliq;
    }

    public BigDecimal getPisBc() {
        return pisBc;
    }

    public void setPisBc(BigDecimal pisBc) {
        this.pisBc = pisBc;
    }

    public BigDecimal getPisValor() {
        return pisValor;
    }

    public void setPisValor(BigDecimal pisValor) {
        this.pisValor = pisValor;
    }

    public String getCofinsSt() {
        return cofinsSt;
    }

    public void setCofinsSt(String cofinsSt) {
        this.cofinsSt = cofinsSt;
    }

    public BigDecimal getCofinsAliq() {
        return cofinsAliq;
    }

    public void setCofinsAliq(BigDecimal cofinsAliq) {
        this.cofinsAliq = cofinsAliq;
    }

    public BigDecimal getCofinsBc() {
        return cofinsBc;
    }

    public void setCofinsBc(BigDecimal cofinsBc) {
        this.cofinsBc = cofinsBc;
    }

    public BigDecimal getCofinsValor() {
        return cofinsValor;
    }

    public void setCofinsValor(BigDecimal cofinsValor) {
        this.cofinsValor = cofinsValor;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public BigDecimal getDecimaisQuantidade() {
        return decimaisQuantidade;
    }

    public void setDecimaisQuantidade(BigDecimal decimaisQuantidade) {
        this.decimaisQuantidade = decimaisQuantidade;
    }

    public BigDecimal getDecimaisValor() {
        return decimaisValor;
    }

    public void setDecimaisValor(BigDecimal decimaisValor) {
        this.decimaisValor = decimaisValor;
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

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    @Override
    public BeanItemVenda clone() {
        BeanItemVenda biv = null;
        try {
            biv = (BeanItemVenda) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(BeanItemVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return biv;
    }
}
