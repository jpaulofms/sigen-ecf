/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanVendedor;
import com.sigen.ecf.persistencia.dao.IDAOVendedor;
import com.sigen.ecf.persistencia.dao.impl.DAOVendedor;
import com.sigen.ecf.view.VIEWConsultarVendedor;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLVendedor {

    private IDAOVendedor iVendedor;

    public CTRLVendedor() {
        this.iVendedor = new DAOVendedor();
    }

    public void inserir(BeanVendedor vendedorBean) {
        try {
            this.iVendedor.inserir(vendedorBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Vendedor) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanVendedor VendedorNovo, BeanVendedor VendedorAntigo) {
        try {
            this.iVendedor.atualizar(VendedorNovo, VendedorAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Vendedor) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanVendedor> pesquisar(BeanVendedor vendedorBean) {
        try {

            return this.iVendedor.pesquisa(vendedorBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Vendedor) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanVendedor>();
        }
    }

    public void remover(BeanVendedor vendedorBean) {
        try {
            this.iVendedor.remover(vendedorBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Vendedor) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultarVendedor() {
        try {
            /* 
             * Identificar e informar o vendedor de uma venda
             */
            VIEWConsultarVendedor consultarVendedor = new VIEWConsultarVendedor(null, true);
            consultarVendedor.setVisible(true);
            if (!consultarVendedor.cancelado) {
                //informarVendedor(consultarVendedor.getCodVendedor());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Vendedor) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void informarVendedor(String codVendedor) throws HeadlessException {
        /*
         * Buscar vendedor e tratar em caso de vendedor não encontrado
         */
        BeanVendedor beanVendedor = new BeanVendedor();
        beanVendedor.setCodVendedor(codVendedor);
        List<BeanVendedor> lsVendedor = pesquisar(beanVendedor);
        if (lsVendedor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vendedor com código '".concat(beanVendedor.getCodVendedor()).concat("' não encontrado."), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            consultarVendedor();
        } else {
            // Guardar código do vendedor
        }
    }
}
