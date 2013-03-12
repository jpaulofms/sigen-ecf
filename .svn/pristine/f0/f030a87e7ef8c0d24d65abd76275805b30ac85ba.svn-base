/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class BeanSpedFiscal {

    private String modeloEcf;
    private String serieEcf;
    private String codEcf;
    private String codMov;
    private String loja;
    private String dataReferencia;
    private String contadorCro;
    private String contadorCrz;
    private String contadorCoo;
    private String totalizadorGeral;
    private String vendaBrutaDiaria;
    private List<BeanSpedFiscalAliquota> lsTotalizadoresParciais;

    public void addAliquota(String tributacao, String valor, int id) {
        if (lsTotalizadoresParciais == null) {
            lsTotalizadoresParciais = new ArrayList<BeanSpedFiscalAliquota>();
        }
        BeanSpedFiscalAliquota aliquota = new BeanSpedFiscalAliquota();
        aliquota.setAliquota(tributacao);
        aliquota.setTotalAliquota(valor);
        aliquota.setCodEcf(getCodEcf());
        aliquota.setCodMov(getCodMov());
        aliquota.setLoja(getLoja());
        aliquota.setId(String.valueOf(id));
        aliquota.setDataReferencia(getDataReferencia());
        lsTotalizadoresParciais.add(aliquota);
    }

    public String getModeloEcf() {
        return modeloEcf;
    }

    public void setModeloEcf(String modeloEcf) {
        this.modeloEcf = modeloEcf;
    }

    public String getSerieEcf() {
        return serieEcf;
    }

    public void setSerieEcf(String serieEcf) {
        this.serieEcf = serieEcf;
    }

    public String getCodEcf() {
        return codEcf;
    }

    public void setCodEcf(String codEcf) {
        this.codEcf = codEcf;
    }

    public String getDataReferencia() {
        return dataReferencia;
    }

    public void setDataReferencia(String dataReferencia) {
        this.dataReferencia = dataReferencia;
    }

    public String getContadorCro() {
        return contadorCro;
    }

    public void setContadorCro(String contadorCro) {
        this.contadorCro = contadorCro;
    }

    public String getContadorCrz() {
        return contadorCrz;
    }

    public void setContadorCrz(String contadorCrz) {
        this.contadorCrz = contadorCrz;
    }

    public String getContadorCoo() {
        return contadorCoo;
    }

    public void setContadorCoo(String contadorCoo) {
        this.contadorCoo = contadorCoo;
    }

    public String getTotalizadorGeral() {
        return totalizadorGeral;
    }

    public void setTotalizadorGeral(String totalizadorGeral) {
        this.totalizadorGeral = totalizadorGeral;
    }

    public String getVendaBrutaDiaria() {
        return vendaBrutaDiaria;
    }

    public void setVendaBrutaDiaria(String vendaBrutaDiaria) {
        this.vendaBrutaDiaria = vendaBrutaDiaria;
    }

    public List<BeanSpedFiscalAliquota> getLsTotalizadoresParciais() {
        return lsTotalizadoresParciais;
    }

    public void setLsTotalizadoresParciais(List<BeanSpedFiscalAliquota> lsTotalizadoresParciais) {
        this.lsTotalizadoresParciais = lsTotalizadoresParciais;
    }

    public String getCodMov() {
        return codMov;
    }

    public void setCodMov(String codMov) {
        this.codMov = codMov;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }
}