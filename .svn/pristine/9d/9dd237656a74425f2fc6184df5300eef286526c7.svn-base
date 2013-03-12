/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanCondicaoPagamento;
import com.sigen.ecf.model.bean.BeanConveniada;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import com.sigen.ecf.vo.VOCheque;
import com.sigen.ecf.vo.VOItemParcelaPagamento;
import com.sigen.ecf.vo.VOParcelaPagamento;
import com.sigen.ecf.vo.VOTransacaoTef;
import com.sigen.ecf.persistencia.dao.IDAOFormaPagamento;
import com.sigen.ecf.persistencia.dao.impl.DAOFormaPagamento;
import com.sigen.ecf.negocio.util.AbstractController;
import com.sigen.ecf.view.VIEWInserirDadosCheque;
import com.sigen.ecf.view.VIEWInserirReal;
import com.sigen.ecf.view.VIEWSelecionarFormaPagamento;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Administrador
 */
public class CTRLFormaPagamento extends AbstractController {

    private IDAOFormaPagamento iFormaPagamento;
    private VIEWSelecionarFormaPagamento formaPagamentoVIEW;
    private BigDecimal valorReceberCompra;
    private BigDecimal valorDescontoCompra;
    private BigDecimal valorTotalRecebido;
    private BigDecimal valorSaldo;
    private BeanCondicaoPagamento condicaoPagamento;
    private int numeroTotalParcelasCondicao;
    public boolean cancelado = true;
    private int ipAtual;
    // Listas
    private List<BeanFormaPagamento> lsFormaPagamento;// Lista de Forma de Pagamento */
    private List<VOTransacaoTef> lsTransacaoTef;
    private List<VOParcelaPagamento> lsParcelaPagamento;// Lista das Parcelas */
    // Globais Temporarias
    private String cgcCpf;
    private BeanConveniada conveniada;
    private String numeroAutorizacao;
    private String numeroDevolucao;
    private BigDecimal arredondamento;
    private int quantidadeParcelasPagamentoItem;
    private BeanFormaPagamento formaPagamento;
    private BeanCliente beanCliente;
    private VOCheque beanCheque;
    private int numeroTransacao;

    public CTRLFormaPagamento() {
        this.iFormaPagamento = new DAOFormaPagamento();
        //formaPagamentoVIEW = new VIEWSelecionarFormaPagamento();
    }

    public boolean selecionarFormaPagamento(BeanCondicaoPagamento condicaoPagamento, BeanCliente cliente, Integer quantidadeParcelasCondicao, BigDecimal valorReceber, BigDecimal valorDesconto) {
        try {
            // Processos para selecionar e efetuar formas de pagamento
            this.beanCliente = cliente;
            this.valorReceberCompra = valorReceber;
            this.valorDescontoCompra = valorDesconto;
            this.valorTotalRecebido = BigDecimal.ZERO;

            lsParcelaPagamento = new ArrayList<VOParcelaPagamento>();
            lsTransacaoTef = new ArrayList<VOTransacaoTef>();
            this.condicaoPagamento = condicaoPagamento;
            this.numeroTotalParcelasCondicao = quantidadeParcelasCondicao;
            this.ipAtual = 0;
            

            gerarParcelasPrevisto(valorReceberCompra, numeroTotalParcelasCondicao, false);

            //formaPagamentoVIEW = new VIEWSelecionarFormaPagamento(null, true, this, condicaoPagamento);
            setValores();
            setCliente();
            atualizarAreaResumo();

            formaPagamentoVIEW.setVisible(true);

            if (!formaPagamentoVIEW.cancelado) {
                return true;
            }

            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaPagamento) ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<BeanFormaPagamento> getLsFormaPagamento() {
        /* Caso parcela seja uma entrada, retornar formas de pagamento a vista */
        if (lsFormaPagamento == null) {
            lsFormaPagamento = pesquisaFormaCondicaoPagamento(condicaoPagamento.getCodCondPagto());
        }
        if (lsParcelaPagamento.get(ipAtual).isEntrada() || condicaoPagamento.getParcelaMax() == 1) {
            return pesquisaFormaCondicaoPagamentoEntrada();
        }
        return pesquisaFormaCondicaoPagamentoPrazo();
    }

    private List<BeanFormaPagamento> pesquisaFormaCondicaoPagamentoEntrada() {
        List<BeanFormaPagamento> lsfFormaPagamentoEntrada = new ArrayList<BeanFormaPagamento>();
        for (BeanFormaPagamento fp : lsFormaPagamento) {
            if (fp.isPagamentoAVista()) {
                lsfFormaPagamentoEntrada.add(fp);
            }
        }
        return lsfFormaPagamentoEntrada;
    }

    private List<BeanFormaPagamento> pesquisaFormaCondicaoPagamentoPrazo() {
        List<BeanFormaPagamento> lsfFormaPagamentoPrazo = new ArrayList<BeanFormaPagamento>();
        for (BeanFormaPagamento fp : lsFormaPagamento) {
            if (fp.isPagamentoAPrazo()) {
                lsfFormaPagamentoPrazo.add(fp);
            }
        }
        return lsfFormaPagamentoPrazo;
    }

    private BigDecimal getValorPrevisto(BigDecimal valorDividir, int numeroDivisor) {
        //Calcula o valor por numero divisor
        BigDecimal valorParcelasPrevisto = valorDividir.divide(new BigDecimal(numeroDivisor), UTILBiblioteca.DECIMAL_VALOR, BigDecimal.ROUND_DOWN);
        definirArredondamento(valorDividir, valorParcelasPrevisto, numeroDivisor);
        return valorParcelasPrevisto;
    }

    public void inserir(BeanFormaPagamento FormaPagamentoBean) {
        try {
            this.iFormaPagamento.inserir(FormaPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaPagamento) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanFormaPagamento FormaPagamentoNovo, BeanFormaPagamento FormaPagamentoAntigo) {
        try {
            this.iFormaPagamento.atualizar(FormaPagamentoNovo, FormaPagamentoAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaPagamento) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanFormaPagamento> pesquisa(BeanFormaPagamento FormaPagamentoBean) {
        try {
            return this.iFormaPagamento.pesquisa(FormaPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaPagamento) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanFormaPagamento>();
        }
    }

    public List<BeanFormaPagamento> pesquisaFormaCondicaoPagamento(String codCondPagto) {
        try {
            return this.iFormaPagamento.pesquisaFormaCondicaoPagamento(codCondPagto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaPagamento) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanFormaPagamento>();
        }
    }

    public void remover(BeanFormaPagamento FormaPagamentoBean) {
        try {
            this.iFormaPagamento.remover(FormaPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaPagamento) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void confirmarSelecaoFormaPagamento(BeanFormaPagamento formaPagamentoBean) {
        try {
            /*
             * Analisar a forma de pagamento e solicitar os dados complementares, se necessário
             */
            this.formaPagamento = formaPagamentoBean;
            quantidadeParcelasPagamentoItem = 1;
            boolean result = false;

            // DINHEIRO
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("DIN")) {
                result = solicitarDadosDinheiro();
            }

            // CHEQUE
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CHE")) {
                result = solicitarDadosCheque();
            }

            // CARTAO DEB TEF
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CART_TEF_DEB")) {
                result = solicitarDadosDebitoTEF();
            }

            // CARTAO CRED TEF
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CART_TEF_CRED")) {
                result = solicitarDadosTEF();
            }

            // CARTAO DEB POS
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CART_POS_DEB")) {
                result = solicitarDadosDebitoPOS();
            }

            // CARTAO CRED POS
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CART_POS_CRED")) {
                result = solicitarDadosPOS();
            }

            // CREDIÁRIO
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CRE")) {
                result = solicitarDadosCrediario();
            }

            // DEVOLUCAO
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("DEV")) {
                result = solicitarDadosDevolucao();
            }


            if (result) {
                /* Receber valores e adicionar item da parcela a parcela criar e adicionar item parcela para o valor informado */
                BigDecimal ipValorRecebido = receberValor();
                if (ipValorRecebido.compareTo(BigDecimal.ZERO) > 0) {
                    /* Adicionar item a lista de transações */
                    adicionarTransacoesTef(ipValorRecebido);
                    /* Define se as parcelas devem ser reorganizadas */
                    analisaParcelas(ipValorRecebido);
                    /* Montar e adiciona os itens da parcela */
                    montarParcelas(ipValorRecebido, (condicaoPagamento.isExigeEntrada() && ipAtual != 0 ? true : false));
                    /* Verifica a necessidade de atualizar os valores totais da parcela */
                    atualizarValoresTotaisParcela();
                    /* incremento do indice de parcela atual */
                    if (!condicaoPagamento.isExigeEntrada() || (condicaoPagamento.isExigeEntrada() && !lsParcelaPagamento.get(0).isAberta())) {
                        ipAtual++;
                    }
                    atualizarAreaResumo();
                }
            }
            reinicializarGlobaisTemporarias();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaPagamento) ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reorganizarParcelas() {
        lsParcelaPagamento = new ArrayList<VOParcelaPagamento>();
        this.numeroTotalParcelasCondicao = quantidadeParcelasPagamentoItem;
        gerarParcelasPrevisto(valorReceberCompra, numeroTotalParcelasCondicao, false);
    }

    private void reorganizarParcelasEntrada(BigDecimal ipValorRecebidoEntrada) {
        quantidadeParcelasPagamentoItem = 1;
        BigDecimal valorMenosEntrada = valorReceberCompra.subtract(ipValorRecebidoEntrada);
        if (ipValorRecebidoEntrada.compareTo(lsParcelaPagamento.get(0).getValorParcela()) >= 0) {
            /* Adiciona uma parcela "isolada" com o valor da parcela. Carregar o demais parcelas com o valor restante*/
            lsParcelaPagamento = new ArrayList<VOParcelaPagamento>();
            adicionarParcelaEntrada(ipValorRecebidoEntrada);
            gerarParcelasPrevisto(valorMenosEntrada, numeroTotalParcelasCondicao - 1, true);
        }
    }

    private void receberQuantidadeParcelas() {
        /* Solicitar a quantidade de parcelas para a forma de pagamento atual */
        Integer[] opcoesParcelas = new Integer[condicaoPagamento.isExigeEntrada() ? this.numeroTotalParcelasCondicao - 1 : this.numeroTotalParcelasCondicao];
        int a = condicaoPagamento.isExigeEntrada() ? this.numeroTotalParcelasCondicao - 1 : this.numeroTotalParcelasCondicao;
        for (int i = 0; i < a; i++) {
            opcoesParcelas[i] = i + 1;
        }
        quantidadeParcelasPagamentoItem = (Integer) JOptionPane.showInputDialog(formaPagamentoVIEW,
                "Parcelamento", "Parcelas", JOptionPane.PLAIN_MESSAGE, null, opcoesParcelas, 1);
    }

    private BigDecimal receberValor() {
        /* Solicitar o valor da parcela para a forma de pagamento atual */
        VIEWInserirReal inserirReal = new VIEWInserirReal(null, true);
        inserirReal.setVisible(true);
        if (!inserirReal.cancelado) {
            if (inserirReal.getValor().compareTo(BigDecimal.ZERO) > 0) {
                if (inserirReal.getValor().compareTo(this.valorSaldo) <= 0
                        || (inserirReal.getValor().compareTo(this.valorSaldo) > 0 && formaPagamento.isPermiteTroco())) {
                    return inserirReal.getValor();
                } else {
                    JOptionPane.showMessageDialog(inserirReal, "Valor superior ao saldo à receber.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    return receberValor();
                }
            } else {
                JOptionPane.showMessageDialog(inserirReal, "Valor deve ser maior que zero", "Receber Valor", JOptionPane.OK_OPTION);
                return receberValor();
            }
        }
        return BigDecimal.ZERO;
    }

    private void receberDadosCheque() {
        /* Solicitar os dados do preenchimento do cheque */
        VIEWInserirDadosCheque inserirDadosCheque = new VIEWInserirDadosCheque(null, true, getDataParcelas());
        inserirDadosCheque.setVisible(true);
        if (!inserirDadosCheque.cancelado) {
            beanCheque = inserirDadosCheque.getDadosCheque();
        }
    }

    private void receberCgcCpf() {
        /* Coletar cpf */
        String numCgcCpf = JOptionPane.showInputDialog(formaPagamentoVIEW, "CGC/CPF", "Informe o CGC/CPF", JOptionPane.QUESTION_MESSAGE);
        if (numCgcCpf != null) {
            if (UTILBiblioteca.regexInteger(numCgcCpf)) {
                if (UTILBiblioteca.validaCpfCnpj(numCgcCpf)) {
                    cgcCpf = numCgcCpf;
                    return;
                }
                JOptionPane.showMessageDialog(null, "CGC/CPF inválido.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Somente números são permitidos", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                receberCgcCpf();
            }
        }
    }

    private void receberConveniada() {
        /* Solicitar conveniada do cartão */
        List<BeanConveniada> lsConveniada = new CTRLConveniada().pesquisaConveniadaFormaPagamento(formaPagamento.getCodFormaPagto());
        conveniada = (BeanConveniada) JOptionPane.showInputDialog(null,
                "Selecionar conveniada", "Conveniada", JOptionPane.QUESTION_MESSAGE, null, lsConveniada.toArray(), 0);
    }

    private void receberNumeroAutorizacao() {
        /* Solicitar número da autorizacao de operação POS */
        String numAutorizacao = JOptionPane.showInputDialog(formaPagamentoVIEW, "Número da Autorização", "Autorização", JOptionPane.QUESTION_MESSAGE);
        if (numAutorizacao != null) {
            if (UTILBiblioteca.regexInteger(numAutorizacao)) {
                numeroAutorizacao = numAutorizacao;
            } else {
                JOptionPane.showMessageDialog(null, "Somente números são permitidos", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                receberNumeroAutorizacao();
            }
        }
    }

    private void receberNumeroDevolucao() {
        /* Solicitar número da devolucao */
        String numDevolucao = JOptionPane.showInputDialog(formaPagamentoVIEW, "Número da Devolução", "Devolução", JOptionPane.QUESTION_MESSAGE);
        if (numDevolucao != null) {
            if (UTILBiblioteca.regexInteger(numDevolucao)) {
                numeroDevolucao = numDevolucao;
            } else {
                JOptionPane.showMessageDialog(null, "Somente números são permitidos", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                receberNumeroDevolucao();
            }
        }
    }

    private boolean solicitarDadosDinheiro() {
        return true;
    }

    private boolean solicitarDadosCheque() {
        try {
            quantidadeParcelasPagamentoItem = 1;
            beanCheque = null;
            receberDadosCheque();
            if (beanCheque != null) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosTEF() {
        try {
            receberConveniada();
            if (conveniada != null) {
                receberQuantidadeParcelas();
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosDebitoTEF() {
        try {
            receberConveniada();
            if (conveniada != null) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosPOS() {
        try {
            receberNumeroAutorizacao();
            if (numeroAutorizacao != null) {
                receberConveniada();
                if (conveniada != null) {
                    receberQuantidadeParcelas();
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosDebitoPOS() {
        try {
            receberNumeroAutorizacao();
            if (numeroAutorizacao != null) {
                receberConveniada();
                if (conveniada != null) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosCrediario() {
        try {
            receberCgcCpf();
            if (cgcCpf != null) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosDevolucao() {
        try {
            receberNumeroDevolucao();
            if (numeroDevolucao != null) {
                return verificarSaldoDevolucao();
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private void gerarParcelasPrevisto(BigDecimal valorParcelar, int quantidadeParcelas, boolean flagEntrada) {
        try {
            /* Adicionar parcelas do pagamento segundo a condição e a quantidade de parcelas */
            Calendar dataParcela = Calendar.getInstance();
            /* calcula valor por parcela e acrescenta a primeira parcela o valor da diferenca */
            BigDecimal valorPrevistoParcela = getValorPrevisto(valorParcelar, quantidadeParcelas);
            /* flag que indica se entrada já foi adicionada */
            int a = 0;
            if (flagEntrada) {
                a = 1;
            }
            for (int i = a; i < this.numeroTotalParcelasCondicao; i++) {
                BigDecimal valorParcela = valorPrevistoParcela;

                /* Calcula as datas das parcelas com base na condição */
                if ((numeroTotalParcelasCondicao > 1 && !condicaoPagamento.isExigeEntrada()) || (i > 0)) {
                    dataParcela.add(Calendar.DAY_OF_MONTH, condicaoPagamento.getDiasEntreParcelas());
                }

                /* Adicona valor do arredondamento */
                if (i == 0 || flagEntrada) {
                    valorParcela = valorPrevistoParcela.add(this.arredondamento);
                }

                VOParcelaPagamento pp = new VOParcelaPagamento();
                pp.setData(dataParcela.getTime());
                // pp.setLsItemParcelaPagamento();
                pp.setValorParcela(valorParcela);
                pp.setNumeroParcela(i + 1);
                pp.setEntrada((this.condicaoPagamento.isExigeEntrada() && i == 0) ? true : false);

                this.lsParcelaPagamento.add(pp);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formaPagamentoVIEW, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarItemParcela(int ppIndex, BigDecimal ipValorRecebido) {
        try {
            if (ipValorRecebido.compareTo(BigDecimal.ZERO) == 0) {
                return;
            }
//            lsParcelaPagamento.get(ppIndex - 1).adicionarItemParcela(beanCheque, conveniada, formaPagamento, ipValorRecebido, numeroAutorizacao, itemEntrada(), numeroTransacao);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formaPagamentoVIEW, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean itemEntrada() {
        try {
            if (condicaoPagamento.isExigeEntrada() && lsParcelaPagamento.get(0).isAberta()) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formaPagamentoVIEW, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void atualizarAreaResumo() {
        try {
            /*
             * Atualizar visualização das formas de pagamento, inserindo nova forma confirmada
             */
            List<String> lsAreaResumo = new ArrayList<String>();
            int i = 0;
            lsAreaResumo.add(UTILBiblioteca.repete("*", 20).concat(" VENDA NO CAIXA ").concat(UTILBiblioteca.repete("*", 20).concat("\r\n\r\n")));

            for (VOParcelaPagamento pp : lsParcelaPagamento) {
                i++;
                //lsAreaResumo.add(String.format("%1$-" + 25 + "s", "Parc (" + i + "/" + lsParcelaPagamento.size() + ") - " + sdf.format(pp.getData())) + " " + UTILBiblioteca.formatoDecimal("V", pp.getValorParcela()) + "\n");

                // Analisar Item da parcela
                for (VOItemParcelaPagamento ipp : pp.getLsItemParcelaPagamento()) {
                    String campoConveniadaCheque = "";
                    // Info Adicionais
                    if (ipp.getConveniada() != null && !ipp.getConveniada().isEmpty()) {
                        campoConveniadaCheque = " " + ipp.getConveniada().toString() + " ";
                    }
                    if (ipp.getCheque() != null && !ipp.getCheque().isEmpty()) {
                        campoConveniadaCheque = " " + ipp.getCheque().toString() + "";
                    }
                    lsAreaResumo.add("    " + String.format("%1$-" + 20 + "s", ipp.getIndiceItemParcela() + " " + ipp.getFormaPagamentoDescricao().concat(campoConveniadaCheque)) + UTILBiblioteca.formatoDecimal("V", ipp.getValorItemParcela()) + "\n");
                }

                lsAreaResumo.add("\r\n");
            }

            // Atualizar visualizaçção
            /*
             formaPagamentoVIEW.setAreaResumo(lsAreaResumo);
             if (condicaoPagamento.isExigeEntrada() && !lsParcelaPagamento.get(0).isAberta()) {
             formaPagamentoVIEW.atualizarFormasPagamento();
             }*/
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formaPagamentoVIEW, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void definirArredondamento(BigDecimal valorRecebido, BigDecimal valorParcelasPrevisto, int n) {
        try {
            BigDecimal valorSomaParcelasPrevisto = valorParcelasPrevisto.multiply(new BigDecimal(n));
            BigDecimal diferenca = valorRecebido.subtract(valorSomaParcelasPrevisto);
            this.arredondamento = diferenca;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formaPagamentoVIEW, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setValores() {
        try {
            /*            formaPagamentoVIEW.setValorReceber(this.valorReceberCompra);
             formaPagamentoVIEW.setValorDesconto(this.valorDescontoCompra);
             formaPagamentoVIEW.setValorRecebido(this.valorTotalRecebido);

             this.valorSaldo = BigDecimal.ZERO;
             if (this.valorReceberCompra.subtract(this.valorTotalRecebido).compareTo(BigDecimal.ZERO) >= 0) {
             this.valorSaldo = this.valorReceberCompra.subtract(this.valorTotalRecebido);
             }
             formaPagamentoVIEW.setSaldo(this.valorSaldo);

             BigDecimal troco = BigDecimal.ZERO;
             if (this.valorTotalRecebido.compareTo(this.valorReceberCompra) > 0) {
             troco = this.valorTotalRecebido.subtract(this.valorReceberCompra);
             }
             formaPagamentoVIEW.setTroco(troco);*/
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formaPagamentoVIEW, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setCliente() {
        //formaPagamentoVIEW.setCliente(new BeanCliente().getNome(), beanCliente.getCgcCpf());
    }

    private void atualizarValorTotalRecebido() {
        BigDecimal valorAcumulado = BigDecimal.ZERO;
        for (VOParcelaPagamento pp : lsParcelaPagamento) {
            valorAcumulado = valorAcumulado.add(pp.getValorRecebido());
        }
        this.valorTotalRecebido = valorAcumulado;
    }

    private void montarParcelas(BigDecimal ipValorRecebido, boolean flagEntrada) {
        /* Montar parcelas do pagamento */
        BigDecimal ipValorRecebidoDividido = getValorPrevisto(ipValorRecebido, this.quantidadeParcelasPagamentoItem);
        int a = 0;
        if (flagEntrada) {
            a = 1;
            quantidadeParcelasPagamentoItem++;
        }

        for (int i = a; i < quantidadeParcelasPagamentoItem; i++) {

            if (formaPagamento.getTipo().equalsIgnoreCase("CHE")) {
                montarParcelaCheque(ipValorRecebidoDividido);
            } else {
                if (lsParcelaPagamento.get(i).isAberta() || quantidadeParcelasPagamentoItem != 1) {
                    BigDecimal ipValorPagamento = ipValorRecebidoDividido;
                    if (lsParcelaPagamento.get(i).getNumeroParcela() - 1 == 0
                            || (flagEntrada && (quantidadeParcelasPagamentoItem > 1 && lsParcelaPagamento.get(i).getNumeroParcela() - 1 == 1))) {
                        ipValorPagamento = ipValorRecebidoDividido.add(this.arredondamento);
                    }
                    adicionarItemParcela(lsParcelaPagamento.get(i).getNumeroParcela(), ipValorPagamento);
                } else {
                    quantidadeParcelasPagamentoItem++;
                }
            }
        }
        atualizarValorTotalRecebido();
        setValores();
    }

    private void montarParcelaCheque(BigDecimal ipValor) {
        /* Se pagou valor total com 1 cheque, e foi reorganizado as parcelas, modificar a data da parcela para a data do cheque */
        if (quantidadeParcelasPagamentoItem == 1 && ipValor.compareTo(valorReceberCompra) == 0) {
            lsParcelaPagamento.get(0).setData(beanCheque.getData());
        }

        int indiceParcela = 0;
        for (Date data : getDataParcelas()) {
            if (beanCheque.getData().getTime() == data.getTime()) {
                adicionarItemParcela(lsParcelaPagamento.get(indiceParcela).getNumeroParcela(), ipValor);
                break;
            }
            indiceParcela++;
        }
    }

    private void atualizarValoresParcelas() {
        if (valorSaldo.compareTo(BigDecimal.ZERO) > 0 && !itemEntrada()) {
            return;
        }
        /* Atualiza o valor das parcelas */
        for (VOParcelaPagamento pp : lsParcelaPagamento) {
            pp.atualizarValor();
        }
        excluirParcelasZeradas();
    }

    /*private void marcarParcelaEntrada() {
     if (condicaoPagamento.isExigeEntrada()) {
     lsParcelaPagamento.get(0).marcarEntrada();
     }
     }*/
    public boolean finalizarPagamento() {
        if (valorSaldo.compareTo(BigDecimal.ZERO) == 0) {
            /* Realizr pagamentos */
            return true;
        }
        JOptionPane.showMessageDialog(formaPagamentoVIEW, "Saldo em aberto", "Finalizar Venda", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    private List<Date> getDataParcelas() {
        List<Date> lsDataPagamento = new ArrayList<Date>();
        for (VOParcelaPagamento pp : lsParcelaPagamento) {
            lsDataPagamento.add(pp.getData());
        }
        return lsDataPagamento;
    }

    private void reinicializarGlobaisTemporarias() {
        cgcCpf = null;
        conveniada = null;
        numeroAutorizacao = null;
        numeroDevolucao = null;
        arredondamento = null;
        quantidadeParcelasPagamentoItem = 0;
        formaPagamento = null;
        beanCliente = null;
        beanCheque = null;
    }

    private void analisaParcelas(BigDecimal ipValorRecebido) {
        /* Caso a quantidade de parcelas informada seja menor que a total e o valor informado seja igual ao total a receber 
         * reorganizar as parcelas para que o pagamento seja feito com a quantidade de parcelas menor */
        if (quantidadeParcelasPagamentoItem < numeroTotalParcelasCondicao && ipValorRecebido.compareTo(valorReceberCompra) == 0) {
            reorganizarParcelas();
        } else if (itemEntrada()) {
            reorganizarParcelasEntrada(ipValorRecebido);
        }
    }

    private void atualizarValoresTotaisParcela() {
        if (itemEntrada()) {
            //marcarParcelaEntrada();
        } else {
            atualizarValoresParcelas();
        }
    }

    private boolean verificarSaldoDevolucao() {
        /*        BeanDevolucao beanDevolucao = pesquisaDevolucao(numeroDevolucao);
         if (beanDevolucao.getSaldo.compareTo(BigDecimal.ZERO) > 0) {
         return true;
         }
         return false;*/
        return true;
    }

    private void excluirParcelasZeradas() {
        /* Excluir parcelas com valor 0,00 */
        for (int i = 0; i < lsParcelaPagamento.size(); i++) {
            for (int b = 0; b < lsParcelaPagamento.size(); b++) {
                if (lsParcelaPagamento.get(b).getValorRecebido().compareTo(BigDecimal.ZERO) == 0) {
                    lsParcelaPagamento.remove(b);
                }
            }
        }
    }

    private void adicionarTransacoesTef(BigDecimal tfValor) {
        /* Adicionar a lista em caso de operação tef */

        if (formaPagamento.getTipo().equalsIgnoreCase("CART_TEF_DEB")
                || formaPagamento.getTipo().equalsIgnoreCase("CART_TEF_CRED")) {
            VOTransacaoTef tf = new VOTransacaoTef();
            tf.setValor(tfValor);
            tf.setTipoTransacao(formaPagamento.getTipo().equals("CART_TEF_DEB") ? "B" : "C");
            tf.setNumeroParcelas(quantidadeParcelasPagamentoItem);
            tf.setBeanConveniada(conveniada);
            tf.setBeanFormaPagamento(formaPagamento);

            lsTransacaoTef.add(tf);
        }
    }

    private void adicionarParcelaEntrada(BigDecimal ipEntrada) {
        /* Inserir parcela de entrada e distribuir o restante entre as parcelas restante */
        VOParcelaPagamento pp = new VOParcelaPagamento();
        pp.setData(Calendar.getInstance().getTime());
        // pp.setLsItemParcelaPagamento();
        pp.setValorParcela(ipEntrada);
        pp.setNumeroParcela(1);
        pp.setEntrada(true);

        this.lsParcelaPagamento.add(pp);
    }
}
