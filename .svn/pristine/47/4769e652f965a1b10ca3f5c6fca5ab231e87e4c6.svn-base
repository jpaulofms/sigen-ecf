/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

/**
 *
 * @author Administrador
 */
public class BeanCliente {

    private String codCliente;
    private String nome;
    private String cpfCnpj;
    private String rg;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
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

    public void setCpfCnpj(String cgcCpf) {
        this.cpfCnpj = cgcCpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEnderecoCompleto() {
        return this.endereco.concat(" - ")
                .concat(getBairro() != null ? getBairro() : ""
                .concat(" - ")
                .concat(getCidade() != null ? getCidade() : ""
                .concat("/")
                .concat(getUf() != null ? getUf().toUpperCase() : "")));
    }

    @Override
    public String toString() {
        StringBuilder cliente = new StringBuilder();

        cliente.append(this.getCodCliente()).append(" ");
        cliente.append(this.getNome()).append(" ");
        cliente.append(this.getCpfCnpj()).append(" ");
        cliente.append(this.getRg()).append(" ");
        cliente.append(this.getEndereco()).append(" ");
        cliente.append(this.getBairro()).append(" ");
        cliente.append(this.getCidade()).append(" ");
        cliente.append(this.getUf()).append(" ");

        return cliente.toString();
    }
}
