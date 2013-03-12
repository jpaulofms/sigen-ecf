/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanFormaCondicaoPagamento;
import com.sigen.ecf.persistencia.dao.IDAOFormaCondicaoPagamento;
import com.sigen.ecf.persistencia.dao.impl.DAOFormaCondicaoPagamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLFormaCondicaoPagamento {

    private IDAOFormaCondicaoPagamento iFormaCondicaoPagamento;

    public CTRLFormaCondicaoPagamento() {
        this.iFormaCondicaoPagamento = new DAOFormaCondicaoPagamento();
    }

    public void inserir(BeanFormaCondicaoPagamento FormaCondicaoPagamentoBean) {
        try {
            this.iFormaCondicaoPagamento.inserir(FormaCondicaoPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaCondicaoPagamento) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanFormaCondicaoPagamento FormaCondicaoPagamentoNovo, BeanFormaCondicaoPagamento FormaCondicaoPagamentoAntigo) {
        try {
            this.iFormaCondicaoPagamento.atualizar(FormaCondicaoPagamentoNovo, FormaCondicaoPagamentoAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaCondicaoPagamento) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanFormaCondicaoPagamento> pesquisa(BeanFormaCondicaoPagamento FormaCondicaoPagamentoBean) {
        try {
            return this.iFormaCondicaoPagamento.pesquisa(FormaCondicaoPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaCondicaoPagamento) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanFormaCondicaoPagamento>();
        }
    }

    public void remover(BeanFormaCondicaoPagamento FormaCondicaoPagamentoBean) {
        try {
            this.iFormaCondicaoPagamento.remover(FormaCondicaoPagamentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(FormaCondicaoPagamento) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
