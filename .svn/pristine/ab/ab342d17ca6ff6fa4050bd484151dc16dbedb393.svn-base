/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.persistencia.dao.IDAOCliente;
import com.sigen.ecf.persistencia.dao.impl.DAOCliente;
import com.sigen.ecf.view.VIEWIdentificarCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLCliente {

    private IDAOCliente iCliente;
    public BeanCliente cliente;
    private VIEWIdentificarCliente identificarClienteVIEW;

    public CTRLCliente() {
        this.iCliente = new DAOCliente();
        this.cliente = new BeanCliente();
        //identificarClienteVIEW = new VIEWIdentificarCliente();
    }

    public void identificarCliente() {
        try {
            /* Identificar cliente de uma venda */
            //identificarClienteVIEW = new VIEWIdentificarCliente(null, true, this);
            identificarClienteVIEW.setVisible(true);
            if (identificarClienteVIEW.cancelado) {
                this.cliente = null;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Identificar Cliente: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inserir(BeanCliente ClienteBean) {
        try {
            this.iCliente.inserir(ClienteBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Cliente) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanCliente ClienteNovo, BeanCliente ClienteAntigo) {
        try {
            this.iCliente.atualizar(ClienteNovo, ClienteAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Cliente) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanCliente> pesquisa(BeanCliente ClienteBean) {
        try {
            return this.iCliente.pesquisa(ClienteBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Cliente) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanCliente>();
        }
    }

    public void remover(BeanCliente ClienteBean) {
        try {
            this.iCliente.remover(ClienteBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Cliente) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultarCliente(String cgcCpf) {
        /*
         * Pesquisar e exibir cliente
         */
        BeanCliente clientePesquisa = new BeanCliente();
        clientePesquisa.setCpfCnpj(cgcCpf);
        List<BeanCliente> lsCliente = pesquisa(clientePesquisa);
        if (!lsCliente.isEmpty()) {
            setCliente(lsCliente.get(0));
            this.cliente = lsCliente.get(0);
        }
    }

    private void setCliente(BeanCliente beanCliente) {
//        identificarClienteVIEW.setCliente(beanCliente);
    }

    public BeanCliente getCliente() {
        return this.cliente;
    }
}
