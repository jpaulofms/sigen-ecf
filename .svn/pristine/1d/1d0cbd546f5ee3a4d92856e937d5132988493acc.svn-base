/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra;

import com.sigen.ecf.exception.EcfException;
import com.sigen.ecf.exception.FaltaPapelException;
import com.sigen.ecf.exception.PoucoPapelException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SIGEN 3
 */
public interface IECFService {

    public boolean getECFCupomAberto();

    public boolean getPoucoPapel();

    public void fecharRelatorioGerencial();

    public void imprimirRelatorioGerencial(String string) throws Exception;

    public void emitirDAVEmitidos(String nInicial, String nFinal);

    public void gerarDAVEmitidos(String nInicial, String nFinal);

    public void gerarArquivo(String nInicial, String nFinal, String tipo, String codOper);

    public void gerarEspelho(String nInicial, String nFinal, String tipo, String codOper);

    public void LMFReducaoEmitir(String nInicial, String nFinal, String tipo);

    public void LMFDataEmitir(String nInicial, String nFinal, String tipo);

    public void LMFReducaoGerar(String nInicial, String nFinal, String tipo);

    public void LMFDataGerar(String nInicial, String nFinal, String tipo);

    public int getCRZ();

    public void emitirReducaoZ();

    public void emitirLeituraX();

    public void efetuarPagamento(String descricaoTipo, BigDecimal valorTipo, String quantiParcelas, String conveniada) throws Exception;

    public void subTotalizaCupom(String acrescimoDesconto, String tipo) throws EcfException, FaltaPapelException, PoucoPapelException;

    public List<String> getFormasPagamentoECF();

    public void fecharCupom(String mensagem) throws EcfException, FaltaPapelException, PoucoPapelException;

    public void cancelaCupom() throws EcfException, FaltaPapelException, PoucoPapelException;

    public boolean getECFAtiva();

    public boolean getECFLivre();

    public boolean getECFSemPapel();

    public void abrirCupom(String cpfCpnj);

    public void abrirGaveta();

    public void espelhoMFD();

    public void arquivoMFD();

    public void cancelarItemVenda(String indexItem) throws FaltaPapelException, PoucoPapelException, EcfException;

    public void efetuarSangria(String codOper, String nomeOper, String forma, BigDecimal valor);

    public void efetuarSuprimento(String suprimento, String descricaoForma) throws FaltaPapelException, PoucoPapelException, EcfException;

    public void finalizarCupom();

    public void relatorioComprovante1();

    public void relatorioComprovante2();

    public void relatorioSaldoDevolucao();

    public void relatorioReciboCrediario();

    public void relatorioPosicaoCaixa();

    public void inserirDescontoItem(String item, String acrescimoDesconto, String tipo, BigDecimal valor);

    public String getCOO();

    public String getGNF();

    public Date getData();

    public String getLoja();

    public String getECF();

    public void vendeItem(String codigo, String descricao, String aliquota,
            String qtde, String vlrUnitario, String vlrDesconto, String tipoIcms)
            throws EcfException, FaltaPapelException, PoucoPapelException;

    public void imprimeComprovanteEntradaOperador(String codOper, String nomeOper, BigDecimal valFdo, BigDecimal valPre);

    public void imprimeComprovanteSaidaOperador(String codOper, String nomeOper);

    public void abrirVinculadoTEF(String conveniadaString, BigDecimal valorTransacao, String cupom) throws Exception;

    public void imprimirVinculadoTEF(String texto) throws Exception;

    public void fecharVinculadoTEF() throws Exception;

    public void cortarPapel();

    public String dadosUltimaReducaoGerar();
 
    public String getModelo();
    public String getSerie();
}
