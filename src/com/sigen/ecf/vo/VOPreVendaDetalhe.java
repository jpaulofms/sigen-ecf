package com.sigen.ecf.vo;

import java.math.BigDecimal;

/**
 * <p>Title: SIGEN</p> <p>Description: PAF-ECF + TEF - Objeto de valor referente
 * a tabela Pre-Venda - Detalhe.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM</p>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * The author may be contacted at: t2ti.com@gmail.com</p>
 *
 * @author Albert Eije (T2Ti.COM)
 * @version 1.0
 */
public class VOPreVendaDetalhe {

    private Integer id;
    private Integer idProduto;
    private String digProd;
    private Integer idPreVendaCabecalho;
    private Double quantidade;
    private Double valorUnitario;
    private Double valorTotal;
    private String descricaoProduto;
    private String tpPed;
    private String filOrig;
    private String ean;
    private String itemPed;
    private Double desconto;
    private BigDecimal preco;
    private String estoque;
    private String flMarcaPropria;
    private String undMenor;
    private BigDecimal aliqIcms;
    private BigDecimal aliqIpi;
    private BigDecimal conversao;
    private String ctf;
    private Double quantidadeEmbal;
    private String codEmbal;

    public VOPreVendaDetalhe() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the idProduto
     */
    public Integer getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the idPreVendaCabecalho
     */
    public Integer getIdPreVendaCabecalho() {
        return idPreVendaCabecalho;
    }

    /**
     * @param idPreVendaCabecalho the idPreVendaCabecalho to set
     */
    public void setIdPreVendaCabecalho(Integer idPreVendaCabecalho) {
        this.idPreVendaCabecalho = idPreVendaCabecalho;
    }

    /**
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getTpPed() {
        return tpPed;
    }

    public void setTpPed(String tpPed) {
        this.tpPed = tpPed;
    }

    public String getFilOrig() {
        return filOrig;
    }

    public void setFilOrig(String filOrig) {
        this.filOrig = filOrig;
    }

    public String getDigProd() {
        return digProd;
    }

    public void setDigProd(String digProd) {
        this.digProd = digProd;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getItemPed() {
        return itemPed;
    }

    public void setItemPed(String itemPed) {
        this.itemPed = itemPed;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getAliqIcms() {
        return aliqIcms;
    }

    public void setAliqIcms(BigDecimal aliqIcms) {
        this.aliqIcms = aliqIcms;
    }

    public BigDecimal getAliqIpi() {
        return aliqIpi;
    }

    public void setAliqIpi(BigDecimal aliqIpi) {
        this.aliqIpi = aliqIpi;
    }

    public BigDecimal getConversao() {
        return conversao;
    }

    public void setConversao(BigDecimal conversao) {
        this.conversao = conversao;
    }

    public String getCtf() {
        return ctf;
    }

    public void setCtf(String ctf) {
        this.ctf = ctf;
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getFlMarcaPropria() {
        return flMarcaPropria;
    }

    public void setFlMarcaPropria(String flMarcaPropria) {
        this.flMarcaPropria = flMarcaPropria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getUndMenor() {
        return undMenor;
    }

    public void setUndMenor(String undMenor) {
        this.undMenor = undMenor;
    }

    public Double getQuantidadeEmbal() {
        return quantidadeEmbal;
    }

    public void setQuantidadeEmbal(Double quantidadeEmbal) {
        this.quantidadeEmbal = quantidadeEmbal;
    }

    public String getCodEmbal() {
        return codEmbal;
    }

    public void setCodEmbal(String codEmbal) {
        this.codEmbal = codEmbal;
    }
}