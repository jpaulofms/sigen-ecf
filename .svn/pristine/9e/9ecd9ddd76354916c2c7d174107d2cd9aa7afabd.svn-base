/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanCondicaoPagamento;
import com.sigen.ecf.persistencia.dao.IDAOCondicaoPagamento;
import com.sigen.ecf.persistencia.dao.impl.DAOCondicaoPagamento;
import com.sigen.ecf.view.VIEWSelecionarCondicaoPagamento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLCondicaoPagamento {

    private IDAOCondicaoPagamento iCondicaoPagamento;
    private VIEWSelecionarCondicaoPagamento selecionarCondicaoVIEW;
    public boolean cancelado = true;
    private Integer numeroParcelas;

    public CTRLCondicaoPagamento() {
        this.iCondicaoPagamento = new DAOCondicaoPagamento();
    }

    public boolean selecionarCondicaoPagamento(BeanCliente cliente, BigDecimal valorCompra, BigDecimal valorDesconto, BigDecimal valorReceber) {
        try {
            // Processo para selecionar condicao de pagamento
            //selecionarCondicaoVIEW = new VIEWSelecionarCondicaoPagamento(null, true, this, pesquisa(new BeanCondicaoPagamento()), valorCompra, valorDesconto, valorReceber);
            selecionarCondicaoVIEW.setVisible(true);

            if (!selecionarCondicaoVIEW.cancelado) {
                // Abrir tela para selecionar a forma de pagamento passando como parâmetro objeto condicaoPagamento e número de parcelas
                //this.cancelado = new CTRLFormaPagamento().selecionarFormaPagamento(selecionarCondicaoVIEW.getCondicaoPagamento(), cliente, this.numeroParcelas, valorReceber, valorDesconto);
            }

            return cancelado;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Totalizar venda: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    public boolean getCancelado() {
        return cancelado;
    }

    public void inserir(BeanCondicaoPagamento CondicaoPagamentoBean) {
        try {
            this.iCondicaoPagamento.inserir(CondicaoPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(CondicaoPagamento) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanCondicaoPagamento CondicaoPagamentoNovo, BeanCondicaoPagamento CondicaoPagamentoAntigo) {
        try {
            this.iCondicaoPagamento.atualizar(CondicaoPagamentoNovo, CondicaoPagamentoAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(CondicaoPagamento) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanCondicaoPagamento> pesquisa(BeanCondicaoPagamento CondicaoPagamentoBean) {
        try {
            return this.iCondicaoPagamento.pesquisa(CondicaoPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(CondicaoPagamento) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanCondicaoPagamento>();
        }
    }

    public void remover(BeanCondicaoPagamento CondicaoPagamentoBean) {
        try {
            this.iCondicaoPagamento.remover(CondicaoPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(CondicaoPagamento) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void selecionarNumeroParcelas() {
        /*
         * Solicitar a quantidade de parcelas para a forma de pagamento atual
         */
        /*        Integer[] opcoesParcelas = new Integer[selecionarCondicaoVIEW.getCondicaoPagamento().getParcelaMax()];
         this.numeroParcelas = 1;
         if (opcoesParcelas.length > 1) {
         for (int i = 0; i < selecionarCondicaoVIEW.getCondicaoPagamento().getParcelaMax(); i++) {
         opcoesParcelas[i] = i + 1;
         }
         this.numeroParcelas = (Integer) JOptionPane.showInputDialog(selecionarCondicaoVIEW, "Parcelamento", "Parcelas", JOptionPane.PLAIN_MESSAGE, null, opcoesParcelas, 1);
         }*/
    }
}
