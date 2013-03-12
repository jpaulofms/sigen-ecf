/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.vo;

/**
 * @author Paulisson
 */
public class VOTef {

    private String NSU;
    private String data;
    private String nomeRede;
    private String hora;
    private String tipoParcelamento;
    private String tipoTransacao;
    private String valor;
    private int numeroParcelas;

    public String getNSU() {
        return NSU;
    }

    public void setNSU(String NSU) {
        this.NSU = NSU;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public String getTipoParcelamento() {
        return tipoParcelamento;
    }

    public void setTipoParcelamento(String tipoParcelamento) {
        this.tipoParcelamento = tipoParcelamento;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getNomeRede() {
        return nomeRede;
    }

    public void setNomeRede(String nomeRede) {
        this.nomeRede = nomeRede;
    }
}
