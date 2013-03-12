/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.impl;

import com.sigen.ecf.exception.EcfException;
import com.sigen.ecf.exception.FaltaPapelException;
import com.sigen.ecf.exception.PoucoPapelException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author victor
 */
public class AdaptorECFService extends ECFService implements ECFEstado {

    public boolean getPoucoPapel() {
        return false;
    }

    public void fecharRelatorioGerencial() {
    }

    public void imprimirRelatorioGerencial(String string) {
    }

    public void emitirDAVEmitidos(String nInicial, String nFinal) {
    }

    public void gerarDAVEmitidos(String nInicial, String nFinal) {
    }

    public void gerarArquivo(String nInicial, String nFinal, String tipo,
            String codOper) {
    }

    public void gerarEspelho(String nInicial, String nFinal, String tipo,
            String codOper) {
    }

    public void LMFReducaoEmitir(String nInicial, String nFinal, String tipo) {
    }

    public void LMFDataEmitir(String nInicial, String nFinal, String tipo) {
    }

    public void LMFReducaoGerar(String nInicial, String nFinal, String tipo) {
    }

    public void LMFDataGerar(String nInicial, String nFinal, String tipo) {
    }

    public int getCRZ() {
        return 0;
    }

    public void emitirReducaoZ() {
    }

    public void emitirLeituraX() {
    }

    public void efetuarPagamento(String descricaoTipo, BigDecimal valorTipo,
            String quantiParcelas, String conveniada) throws EcfException,
            FaltaPapelException, PoucoPapelException {
    }

    public void subTotalizaCupom(String acrescimoDesconto, String tipo)
            throws EcfException, FaltaPapelException, PoucoPapelException {
    }

    public List<String> getFormasPagamentoECF() {
        List<String> list = new ArrayList<String>();

        list.add("Dinheiro");
        list.add("Cartao Deb");
        list.add("Cartao Cred");
        list.add("Devolucao");

        return list;
    }

    public void fecharCupom(String mensagem) throws EcfException,
            FaltaPapelException, PoucoPapelException {
    }

    public void cancelaCupom() throws EcfException, FaltaPapelException,
            PoucoPapelException {
    }

    public boolean getECFAtiva() {
        return true;
    }

    public boolean getECFLivre() {
        return true;
    }

    public boolean getECFSemPapel() {
        return false;
    }

    public void abrirCupom(String cpfCpnj) {
    }

    public void abrirGaveta() {
    }

    public void espelhoMFD() {
    }

    public void arquivoMFD() {
    }

    public void cancelarItemVenda(String indexItem) throws FaltaPapelException,
            PoucoPapelException, EcfException {
    }

    public void efetuarSangria(String codOper, String nomeOper, String forma,
            BigDecimal valor) {
    }

    public void efetuarSuprimento(String suprimento, String descricaoForma)
            throws FaltaPapelException, PoucoPapelException, EcfException {
    }

    public void finalizarCupom() {
    }

    public void relatorioComprovante1() {
    }

    public void relatorioComprovante2() {
    }

    public void relatorioSaldoDevolucao() {
    }

    public void relatorioReciboCrediario() {
    }

    public void relatorioPosicaoCaixa() {
    }

    public void inserirDesconto() {
    }

    public String getCOO() {
        Date date = new Date();
        return "0" + date.getDay() + date.getHours() + date.getMinutes() + date.getSeconds();
    }

    public String getGNF() {
        Date date = new Date();
        return "0" + date.getDay() + date.getHours() + date.getMinutes() + date.getSeconds();
    }

    public Date getData() {
        return new Date();
    }

    public String getLoja() {
        return "001";
    }

    public String getECF() {
        return "001";
    }

    public void vendeItem(String codigo, String descricao, String aliquota,
            String qtde, String vlrUnitario, String vlrDesconto, String tipoIcms)
            throws EcfException, FaltaPapelException, PoucoPapelException {
    }

    public void imprimeComprovanteEntradaOperador(String codOper,
            String nomeOper, BigDecimal valFdo, BigDecimal valPre) {
    }

    public void imprimeComprovanteSaidaOperador(String codOper, String nomeOper) {
    }

    @Override
    public void inserirDescontoItem(String item, String acrescimoDesconto, String tipo, BigDecimal valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void abrirVinculadoTEF(String conveniadaString, BigDecimal valorTransacao, String cupom) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimirVinculadoTEF(String texto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fecharVinculadoTEF() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cortarPapel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean getECFCupomAberto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String dadosUltimaReducaoGerar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getModelo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getSerie() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}