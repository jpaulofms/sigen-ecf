/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra;

import com.sigen.ecf.infra.impl.BematechECFService;
import com.sigen.ecf.vo.VODevolucao;
import com.sigen.ecf.vo.VOLancamentoCaixa;
import com.sigen.ecf.vo.VOPreVendaDetalhe;
import com.sigen.ecf.vo.VOSangria;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author user
 */
public class ComprovanteRelatorioGerencialService {

    private static BematechECFService eCFBematechService = new BematechECFService();
    private static NumberFormat numberFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt", "BR"))); // formato de moeda, sem o sinal R$
    private static SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yy");
    private static DecimalFormat df = new java.text.DecimalFormat("#,##0.00");

    public static void imprimeComprovanteEntradaOperador(String codOper, String nomeOper, Double valFdo, Double valPre) throws Exception {

        String comprovanteEntrada = "************** Entrada de Operador *************\r\n";
        comprovanteEntrada += "Codigo do Operador:........ " + codOper + "\r\n";
        comprovanteEntrada += "Nome:...................... " + nomeOper + "\r\n";
        comprovanteEntrada += "Fundo de Troco:............ " + NumberFormat.getCurrencyInstance().format(valFdo) + "\r\n";
        comprovanteEntrada += "Vale-Presente:............. " + NumberFormat.getCurrencyInstance().format(valPre) + "\r\n";
        comprovanteEntrada += "************************************************\r\n";

        try {
            eCFBematechService.imprimirRelatorioGerencial(comprovanteEntrada + (char) 13 + (char) 10);
            eCFBematechService.fecharRelatorioGerencial();
        } catch (Exception ex) {
            throw ex;
        } finally {
        }
    }

    public static void imprimeComprovanteSaidaOperador(String codOper, String nomeOper) throws Exception {

        String comprovanteSaida = "************** Saida de Operador ***************\r\n";
        comprovanteSaida += "Codigo do Operador:........ " + codOper + "\r\n";
        comprovanteSaida += "Nome:...................... " + nomeOper + "\r\n";
        comprovanteSaida += "************************************************\r\n";

        try {
            eCFBematechService.imprimirRelatorioGerencial(comprovanteSaida + (char) 13 + (char) 10);
            eCFBematechService.fecharRelatorioGerencial();
        } catch (Exception ex) {
            throw ex;
        } finally {
        }

    }

    public static void imprimeComprovanteSangria(String codOper, String nomeOper, String forma, BigDecimal valor) throws Exception {

        String comrovanteSangria = "******************** Sangria *******************\r\n";
        comrovanteSangria += "Codigo do Operador:............. " + codOper + "\r\n";
        comrovanteSangria += "Nome:........................... " + nomeOper + "\r\n";
        comrovanteSangria += "Forma                              Valor\r\n";
        comrovanteSangria += forma + "                       " + NumberFormat.getCurrencyInstance().format(valor) + "\r\n";
        comrovanteSangria += "************************************************\r\n";

        try {
            eCFBematechService.imprimirRelatorioGerencial(comrovanteSangria + (char) 13 + (char) 10);
            eCFBematechService.fecharRelatorioGerencial();
        } catch (Exception ex) {
            throw ex;
        } finally {
        }
    }

    public static void imprimeComprovanteSuprimento(String codOper, String nomeOper, BigDecimal vlSup, BigDecimal valPre) throws Exception {


        String comprovanteSuprimento = "******************* Suprimento *****************\r\n";
        comprovanteSuprimento += "Codigo do Operador:............. " + codOper + "\r\n";
        comprovanteSuprimento += "Nome:........................... " + nomeOper + "\r\n";
        comprovanteSuprimento += "Valor:.......................... " + NumberFormat.getCurrencyInstance().format(vlSup) + "\r\n";
        comprovanteSuprimento += "Vale-Presente:.................. " + NumberFormat.getCurrencyInstance().format(valPre) + "\r\n";
        comprovanteSuprimento += "************************************************\r\n";

        try {
            eCFBematechService.imprimirRelatorioGerencial(comprovanteSuprimento + (char) 13 + (char) 10);
            eCFBematechService.fecharRelatorioGerencial();
        } catch (Exception ex) {
            throw ex;
        } finally {
        }

    }

    public static void imprimeComprovantePosicaoCaixa(String codOper, String nomeOper, String numEcf, Date dataAtual, BigDecimal fdo, BigDecimal sup, List<VOSangria> listaSangrias, BigDecimal saldoTransp, List<VOLancamentoCaixa> listaRecebimentos, boolean saidaOperador) throws Exception {

        String posCaixa = "               POSICAO DE CAIXA                \r\n";

        if (saidaOperador) {
            posCaixa = "     POSICAO DE CAIXA DA SAIDA DO OPERADOR      \r\n";
        }

        String pulaLinha = "\r\n";

        String cabecalho = "----------------------------------------------\r\n";
        cabecalho += posCaixa;
        cabecalho += "----------------------------------------------\r\n";
        cabecalho += "OPERADOR......: " + codOper + " - " + nomeOper + "\r\n";
        cabecalho += "ECF...........: " + numEcf + "\r\n";
        cabecalho += "DATA..........: " + formataData.format(dataAtual);
        cabecalho += pulaLinha;

        String fundoCaixa = "                Fundo de Troco                \r\n";
        fundoCaixa += pulaLinha;
        fundoCaixa += "Soma........................: R$ " + String.valueOf(numberFormat.format(fdo)) + "\r\n";

        String suprimento = "                 Suprimento                \r\n";
        suprimento += pulaLinha;
        suprimento += "Soma........................: R$ " + String.valueOf(numberFormat.format(sup)) + "\r\n";

        String sangria = "                   Sangria                \r\n";
        sangria += "Forma                         Valor \r\n";
        //SOMA SANGRIA

        String transportados = "              Saldos Transportados                \r\n";
        //SOMA TRANSPORTADOS

        String recebimentos = "                Recebimentos                \r\n";
        recebimentos += "Forma          Quant          Valor\r\n";
        //SOMA RECEBIMENTOS

        //++++++++++++++++++++++++++++++++++++++++++++++++ IMPRESSÃO ++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

        try {
            eCFBematechService.imprimirRelatorioGerencial(cabecalho + (char) 13 + (char) 10);
            eCFBematechService.imprimirRelatorioGerencial(fundoCaixa + (char) 13 + (char) 10);
            eCFBematechService.imprimirRelatorioGerencial(suprimento + (char) 13 + (char) 10);
            eCFBematechService.imprimirRelatorioGerencial(sangria + (char) 13 + (char) 10);
            //for sangria
            double somaSangria = 0;
            for (Iterator<VOSangria> it = listaSangrias.iterator(); it.hasNext();) {
                VOSangria sangriaVO = (VOSangria) it.next();
                BigDecimal vlSangria = sangriaVO.getValor();
                String lSangria = sangriaVO.getDescricao() + "                           " + String.valueOf(numberFormat.format(vlSangria));
                eCFBematechService.imprimirRelatorioGerencial(lSangria + (char) 13 + (char) 10);
                somaSangria += sangriaVO.getValor().doubleValue();
            }
            eCFBematechService.imprimirRelatorioGerencial("Soma........................: R$ " + String.valueOf(numberFormat.format(somaSangria)) + "\r\n" + (char) 13 + (char) 10);

            eCFBematechService.imprimirRelatorioGerencial(transportados + (char) 13 + (char) 10);
            //SomaTransp
            String somaTransportados = String.valueOf(numberFormat.format(saldoTransp));
            eCFBematechService.imprimirRelatorioGerencial("Soma........................: R$ " + somaTransportados + "\r\n" + (char) 13 + (char) 10);

            eCFBematechService.imprimirRelatorioGerencial(recebimentos + (char) 13 + (char) 10);
            //for receb
            BigDecimal somaRecebimentos = BigDecimal.ZERO;
            for (Iterator<VOLancamentoCaixa> it = listaRecebimentos.iterator(); it.hasNext();) {
                VOLancamentoCaixa recebimentosVO = it.next();
                BigDecimal vlRecebimento = recebimentosVO.getValLan();
                String lRecebimento = recebimentosVO.getReseve() + "                " + String.valueOf(numberFormat.format(vlRecebimento));
                eCFBematechService.imprimirRelatorioGerencial(lRecebimento + (char) 13 + (char) 10);
                somaRecebimentos = somaRecebimentos.add(recebimentosVO.getValLan());
            }
            eCFBematechService.imprimirRelatorioGerencial("Soma........................: R$ " + df.format(somaRecebimentos) + "\r\n" + (char) 13 + (char) 10);

            String valorCaixa = String.valueOf(numberFormat.format(fdo.add(sup).add(saldoTransp).add(somaRecebimentos).subtract(new BigDecimal(somaSangria))));
            String comprovantePosicaoCaixaFim = "----------------------------------------------\r\n";
            comprovantePosicaoCaixaFim += "Valor em Caixa..............: R$ " + valorCaixa + "\r\n";
            comprovantePosicaoCaixaFim += "----------------------------------------------\r\n";
            eCFBematechService.imprimirRelatorioGerencial(comprovantePosicaoCaixaFim + (char) 13 + (char) 10);

            //FECHAR RELATÓRIO GERENCIAL
            eCFBematechService.fecharRelatorioGerencial();

        } catch (Exception ex) {
            throw ex;
        } finally {
        }
    }

    public static void imprimeComprovanteRetiraPosteriorEntrega(String caixa, String numDav, String filial, String pedido,
            String codCli, String cpfCli, String nomeCli, String endCli, String bairro, String cidade, Date data,
            String condicao, String cupomFiscal, String numParcelas, String valorCompra, String entrada,
            String valorFinanciado, String valorSoma, String valorParcelas, String codVendedor, String nomeVendedor,
            String codOper, String nomeOper,
            List formasEntrada, Map retPost, Map entrega, String vlTroco) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = simpleDateFormat.format(data);

        imprimirComprovanteDAV(filial, caixa, numDav, pedido, codCli, nomeCli, dataAtual, condicao, cupomFiscal, numParcelas, valorCompra,
                entrada, valorFinanciado, valorSoma, valorParcelas, formasEntrada, vlTroco);

//        Caixa.numeroNotaSemCupom = eCFBematechService.numeroUltimoCupom();

        Iterator itRetEntrega = entrega.keySet().iterator();
        while (itRetEntrega.hasNext()) {
            String loja = (String) itRetEntrega.next();
            imprimirCabecalhoEntrega(numDav, pedido, codCli, cpfCli, nomeCli, endCli, bairro, cidade, codVendedor, nomeVendedor, codOper, nomeOper);
            Iterator itensIt = ((List) entrega.get(loja)).iterator();
            while (itensIt.hasNext()) {
                VOPreVendaDetalhe preVendaDetalheVO = (VOPreVendaDetalhe) itensIt.next();
                imprimirItem(String.valueOf(preVendaDetalheVO.getIdProduto()) + preVendaDetalheVO.getDigProd(), String.valueOf(preVendaDetalheVO.getQuantidade()), preVendaDetalheVO.getDescricaoProduto());
            }
            eCFBematechService.fecharRelatorioGerencial();
        }


        Iterator itRetPost = retPost.keySet().iterator();
        while (itRetPost.hasNext()) {
            String loja = (String) itRetPost.next();
            imprimirCabecalhoRetiraPosterior(numDav, pedido, codVendedor, nomeVendedor, codOper, nomeOper, loja);
            Iterator itensIt = ((List) retPost.get(loja)).iterator();
            while (itensIt.hasNext()) {
                VOPreVendaDetalhe preVendaDetalheVO = (VOPreVendaDetalhe) itensIt.next();
                imprimirItem(String.valueOf(preVendaDetalheVO.getIdProduto()) + preVendaDetalheVO.getDigProd(), String.valueOf(preVendaDetalheVO.getQuantidade()), preVendaDetalheVO.getDescricaoProduto());
            }
            eCFBematechService.fecharRelatorioGerencial();
        }

    }

    private static void imprimirComprovanteDAV(String filial, String caixa, String numDav, String pedido, String codCli, String nomeCli, String data, String condicao, String cupomFiscal, String numParcelas, String valorCompra, String Entrada, String vlrFinalizado, String vlrSoma, String vlrParcelas, List formasEntrada, String vlTroco) throws Exception {
        //IMPRIMIR RELATORIO GERAL
//        String relatGeral = "          Relatório Geral          ";
        if (cupomFiscal == null) {
            cupomFiscal = "";
        }


        String comprovanteDAV1 = "DAV: " + numDav + "\r\n";
        comprovanteDAV1 += "FILIAL .: " + filial + "   Pedido...: " + pedido + "\r\n";
        comprovanteDAV1 += "CLIENTE .: " + codCli + " - " + nomeCli + "\r\n";
        comprovanteDAV1 += "Data ..............: " + data + "\r\n";
        comprovanteDAV1 += "Condicao ..........: " + condicao + "\r\n";
        comprovanteDAV1 += "Cupom Fiscal.......: " + cupomFiscal + "\r\n";
        comprovanteDAV1 += "Num. Parcelas .....: " + numParcelas + "\r\n";
        comprovanteDAV1 += "Valor da Compra....: " + UTILBiblioteca.formatoDecimal("V", new BigDecimal(valorCompra)) + "\r\n";
        comprovanteDAV1 += "Entrada............: " + UTILBiblioteca.formatoDecimal("V", new BigDecimal(Entrada)) + "\r\n";
        comprovanteDAV1 += "Valor Financiado...: " + UTILBiblioteca.formatoDecimal("V", new BigDecimal(vlrFinalizado)) + "\r\n";
        comprovanteDAV1 += "Valor Soma.........: " + UTILBiblioteca.formatoDecimal("V", new BigDecimal(vlrSoma)) + "\r\n";
        comprovanteDAV1 += "Troco..............: " + UTILBiblioteca.formatoDecimal("V", new BigDecimal(vlTroco)) + "\r\n";
        comprovanteDAV1 += "Valor das Parcelas.: " + UTILBiblioteca.formatoDecimal("V", new BigDecimal(vlrParcelas)) + "\r\n";
        comprovanteDAV1 += "Formas da Entrada \r\n";

        String comprovanteDAV2 = "Caixa : " + caixa + "            " + "Filial : " + filial + "\r\n";

        comprovanteDAV2 += "Sr. Consumidor, essa é uma Guia de Pagamentos, para sua Segurança, exija o Cupom ou Nota Fiscal \r\n";


        eCFBematechService.imprimirRelatorioGerencial(comprovanteDAV1 + (char) 13 + (char) 10);

        for (Iterator it = formasEntrada.iterator(); it.hasNext();) {
            VOLancamentoCaixa lancamentoCaixaVO = (VOLancamentoCaixa) it.next();
            eCFBematechService.imprimirRelatorioGerencial(lancamentoCaixaVO.getForma() + "                "
                    + UTILBiblioteca.formatoDecimal("V", lancamentoCaixaVO.getValLan()) + (char) 13 + (char) 10);
        }

        eCFBematechService.imprimirRelatorioGerencial(comprovanteDAV2 + (char) 13 + (char) 10);
        eCFBematechService.fecharRelatorioGerencial();
    }

    private static void imprimirCabecalhoEntrega(String dav, String pedido, String codigo, String cpf, String nome, String endereco, String bairro, String cidade, String codVendedor, String nomeVendedor, String codOperador, String nomeOperador) throws Exception {

        String comprovanteEntregaCabecalho = "          Pedido de Venda Entrega          \r\n";
        comprovanteEntregaCabecalho += "DAV: " + dav + "\r\n";
        comprovanteEntregaCabecalho += "Pedido: " + pedido + "\r\n";
        comprovanteEntregaCabecalho += "Codigo: " + codigo + "\r\n";
        comprovanteEntregaCabecalho += "CPF: " + cpf + "\r\n";
        comprovanteEntregaCabecalho += "Nome: " + nome + "\r\n";
        comprovanteEntregaCabecalho += "Endereco: " + endereco + "\r\n";
        comprovanteEntregaCabecalho += "Bairro: " + bairro + "    Cidade: " + cidade + "\r\n";
        comprovanteEntregaCabecalho += "Vendedor: " + codVendedor + " - " + nomeVendedor + "\r\n";
        comprovanteEntregaCabecalho += "Operador: " + codOperador + " - " + nomeOperador + "\r\n";
        comprovanteEntregaCabecalho += "Codigo           " + "Qtde" + "  " + "Descricao \r\n";

        eCFBematechService.imprimirRelatorioGerencial(comprovanteEntregaCabecalho + (char) 13 + (char) 10);
    }

    private static void imprimirCabecalhoRetiraPosterior(String dav, String pedido, String codVendedor, String nomeVendedor, String codOperador, String nomeOperador, String filial) throws Exception {

        String comprovanteRetiraPosteriorCabecalho = "      Pedido Retira Posterior    - Filial Ret:" + filial + "\r\n";
        comprovanteRetiraPosteriorCabecalho += "DAV: " + dav + "\r\n";
        comprovanteRetiraPosteriorCabecalho += "Pedido: " + pedido + "\r\n";
        comprovanteRetiraPosteriorCabecalho += "Vendedor: " + codVendedor + " - " + nomeVendedor + "\r\n";
        comprovanteRetiraPosteriorCabecalho += "Operador: " + codOperador + " - " + nomeOperador + "\r\n";
        comprovanteRetiraPosteriorCabecalho += "Codigo           " + "Qtde" + "  " + "Descricao \r\n";

        eCFBematechService.imprimirRelatorioGerencial(comprovanteRetiraPosteriorCabecalho + (char) 13 + (char) 10);

    }

    private static void imprimirItem(String codigo, String qtde, String descricao) throws Exception {
        String item = codigo + "           " + qtde + "  " + descricao;
        eCFBematechService.imprimirRelatorioGerencial(item + (char) 13 + (char) 10);
    }

    public void imprimeComprovanteDevolucao(List<VODevolucao> devolucaoVOs) throws Exception {

        String comprovanteDevolucao = "          Recibo de Devolucao Parcial         \r\n";

        try {
            eCFBematechService.imprimirRelatorioGerencial(comprovanteDevolucao + (char) 13 + (char) 10);

            for (VODevolucao devolucaoVO : devolucaoVOs) {
//                BigDecimal valorSaldo = devolucaoVO.getVlRecibo();

                /*
                 * Caso não seja pedido ou se for pedido e tiver sido renegociado e uma das novas formas de pagamento for uma devolução
                 */
//                if ((!Caixa.isPreVenda) || (Caixa.isPreVenda && Caixa.renegociado)) {
//                    valorSaldo = devolucaoVO.getVlRecibo().subtract(devolucaoVO.getVlUtilizado());
//                    if (valorSaldo.compareTo(BigDecimal.ZERO) <= 0) {
//                        valorSaldo = BigDecimal.ZERO;
//                    }
//                }

                comprovanteDevolucao = "Cliente......: " + devolucaoVO.getNomeCli() + "\r\n";
                comprovanteDevolucao += "Recibo..................: " + devolucaoVO.getNrRecibo() + "\r\n";
                comprovanteDevolucao += "Valor Utilizado.........: " + UTILBiblioteca.formatoDecimal("V", devolucaoVO.getVlUtilizado()) + "\r\n";
                comprovanteDevolucao += "Saldo...................: " + UTILBiblioteca.formatoDecimal("V", devolucaoVO.getVlSaldoImpressao()) + "\r\n";

                eCFBematechService.imprimirRelatorioGerencial(comprovanteDevolucao + (char) 13 + (char) 10);
            }

            String linhaFim = "----------------------------------------------\r\n";
            eCFBematechService.imprimirRelatorioGerencial(linhaFim + (char) 13 + (char) 10);

            eCFBematechService.fecharRelatorioGerencial();

        } catch (Exception ex) {
            throw ex;
        } finally {
        }
    }
}
