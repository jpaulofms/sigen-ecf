/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanParametro;
import com.sigen.ecf.persistencia.dao.IDAOParametro;
import com.sigen.ecf.persistencia.dao.impl.DAOParametro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLParametro {

    private IDAOParametro iParametro;

    public CTRLParametro() {
        this.iParametro = new DAOParametro();
    }

    public void inserir(BeanParametro ParametroBean) {
        try {
            this.iParametro.inserir(ParametroBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Parametro) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanParametro ParametroNovo, BeanParametro ParametroAntigo) {
        try {
            this.iParametro.atualizar(ParametroNovo, ParametroAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Parametro) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanParametro> pesquisa(BeanParametro ParametroBean) {
        try {
            return this.iParametro.pesquisa(ParametroBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Parametro) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanParametro>();
        }
    }

    public void remover(BeanParametro ParametroBean) {
        try {
            this.iParametro.remover(ParametroBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Parametro) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
