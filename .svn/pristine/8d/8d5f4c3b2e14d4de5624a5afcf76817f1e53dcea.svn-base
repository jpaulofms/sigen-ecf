/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

import com.sigen.ecf.view.util.UTILBiblioteca;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class BeanDevolucao {

    private String loja;
    private String codEcf;
    private String codMov;
    private String coo;
    private Date dataDevolucao;
    private String horaDevolucao;
    private String nome;
    private String cpfCnpj;
    private BigDecimal valorCredito;
    private String endereco;
    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String estado;
    private String cidade;
    private boolean devolucaoUtilizada;

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

    public String getCoo() {
        return coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        if (dataDevolucao != null) {
            this.horaDevolucao = UTILBiblioteca.formatoHora.format(dataDevolucao);
        }
    }

    public String getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public boolean isDevolucaoUtilizada() {
        return devolucaoUtilizada;
    }

    public void setDevolucaoUtilizada(boolean devolucaoUtilizada) {
        this.devolucaoUtilizada = devolucaoUtilizada;
    }

    public String getEnderecoCompleto() {
        String endereco = getEndereco();
        if (getComplemento() != null && !getComplemento().equals("")) {
            endereco = endereco + " - " + getComplemento();
        }
        if (getNumero() != null && !getNumero().equals("")) {
            endereco = endereco + " - " + getNumero();
        }
        if (getCep() != null && !getCep().equals("")) {
            endereco = endereco + " - " + getCep();
        }
        if (getBairro() != null && !getBairro().equals("")) {
            endereco = endereco + " - " + getBairro();
        }
        if (getCidade() != null && !getCidade().equals("")) {
            endereco = endereco + " - " + getCidade();
        }
        if (getEstado() != null && !getEstado().equals("")) {
            endereco = endereco + " - " + getEstado();
        }

        return endereco;
    }
}
