/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanProdutoUnidadeMedida;
import com.sigen.ecf.persistencia.dao.IDAOProdutoUnidadeMedida;
import com.sigen.ecf.persistencia.dao.impl.DAOProdutoUnidadeMedida;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLProdutoUnidadeMedida {

    private IDAOProdutoUnidadeMedida iProdutoUnidadeMedida;

    public CTRLProdutoUnidadeMedida() {
        this.iProdutoUnidadeMedida = new DAOProdutoUnidadeMedida();
    }

    public void inserir(BeanProdutoUnidadeMedida ProdutoUnidadeMedidaBean) {
        try {
            this.iProdutoUnidadeMedida.inserir(ProdutoUnidadeMedidaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(ProdutoUnidadeMedida) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanProdutoUnidadeMedida ProdutoUnidadeMedidaNovo, BeanProdutoUnidadeMedida ProdutoUnidadeMedidaAntigo) {
        try {
            this.iProdutoUnidadeMedida.atualizar(ProdutoUnidadeMedidaNovo, ProdutoUnidadeMedidaAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(ProdutoUnidadeMedida) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanProdutoUnidadeMedida> pesquisa(BeanProdutoUnidadeMedida ProdutoUnidadeMedidaBean) {
        try {
            return this.iProdutoUnidadeMedida.pesquisa(ProdutoUnidadeMedidaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(ProdutoUnidadeMedida) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanProdutoUnidadeMedida>();
        }
    }

    public void remover(BeanProdutoUnidadeMedida ProdutoUnidadeMedidaBean) {
        try {
            this.iProdutoUnidadeMedida.remover(ProdutoUnidadeMedidaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(ProdutoUnidadeMedida) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
