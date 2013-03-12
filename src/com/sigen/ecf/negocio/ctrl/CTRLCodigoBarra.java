/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanCodigoBarra;
import com.sigen.ecf.persistencia.dao.IDAOCodigoBarra;
import com.sigen.ecf.persistencia.dao.impl.DAOCodigoBarra;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLCodigoBarra {

    private IDAOCodigoBarra iCodigoBarra;

    public CTRLCodigoBarra() {
        this.iCodigoBarra = new DAOCodigoBarra();
    }

    public void inserir(BeanCodigoBarra CodigoBarraBean) {
        try {
            this.iCodigoBarra.inserir(CodigoBarraBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(CodigoBarra) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanCodigoBarra CodigoBarraNovo, BeanCodigoBarra CodigoBarraAntigo) {
        try {
            this.iCodigoBarra.atualizar(CodigoBarraNovo, CodigoBarraAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(CodigoBarra) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanCodigoBarra> pesquisa(BeanCodigoBarra CodigoBarraBean) {
        try {
            return this.iCodigoBarra.pesquisa(CodigoBarraBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(CodigoBarra) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanCodigoBarra>();
        }
    }

    public void remover(BeanCodigoBarra CodigoBarraBean) {
        try {
            this.iCodigoBarra.remover(CodigoBarraBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(CodigoBarra) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
