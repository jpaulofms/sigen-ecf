/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

/**
 *
 * @author Administrador
 */
public class BeanOperador implements Comparable<BeanOperador> {

    private String codOper;
    private String nome;
    private boolean supervisor;
    private String senha;

    public String getCodOper() {
        return codOper;
    }

    public void setCodOper(String codOper) {
        this.codOper = codOper;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isSupervisor() {
        return supervisor;
    }

    public void setSupervisor(boolean supervisor) {
        this.supervisor = supervisor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return getCodOper() + " - " + getNome();
    }

    @Override
    public int compareTo(BeanOperador o) {
        return getCodOper().compareTo(o.getCodOper());
    }
}
