/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.vo;

import java.math.BigDecimal;

/**
 *
 * @author SIGEN 3
 */
public class VOEfetuaPagamentoECF {

    private String descricaoFormaPagamento;
    private Integer quantidadeParcelas;
    private BigDecimal totalTipo;
    private String descricaoConveniada;

    public String getDescricaoFormaPagamento() {
        return descricaoFormaPagamento;
    }

    public void setDescricaoFormaPagamento(String descricaoFormaPagamento) {
        this.descricaoFormaPagamento = descricaoFormaPagamento;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public BigDecimal getTotalTipo() {
        return totalTipo;
    }

    public void setTotalTipo(BigDecimal totalTipo) {
        this.totalTipo = totalTipo;
    }

    public String getDescricaoConveniada() {
        return descricaoConveniada;
    }

    public void setDescricaoConveniada(String descricaoConveniada) {
        this.descricaoConveniada = descricaoConveniada;
    }
}
