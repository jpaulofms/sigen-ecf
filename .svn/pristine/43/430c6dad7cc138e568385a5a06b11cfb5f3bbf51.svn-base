/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.persistencia.dao.IDAOItemVenda;
import com.sigen.ecf.persistencia.dao.impl.DAOItemVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLVendaDetalhe {

    private IDAOItemVenda iVendaDetalhe;

    public CTRLVendaDetalhe() {
        this.iVendaDetalhe = new DAOItemVenda();
    }

    public void inserir(BeanItemVenda VendaDetalheBean) {
        try {
            this.iVendaDetalhe.inserir(VendaDetalheBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(VendaDetalhe) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanItemVenda VendaDetalheNovo, BeanItemVenda VendaDetalheAntigo) {
        try {
            this.iVendaDetalhe.atualizar(VendaDetalheNovo, VendaDetalheAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(VendaDetalhe) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanItemVenda> pesquisar(BeanItemVenda VendaDetalheBean) {
        try {
            return this.iVendaDetalhe.pesquisa(VendaDetalheBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(VendaDetalhe) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanItemVenda>();
        }
    }

    public void remover(BeanItemVenda VendaDetalheBean) {
        try {
            this.iVendaDetalhe.remover(VendaDetalheBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(VendaDetalhe) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}