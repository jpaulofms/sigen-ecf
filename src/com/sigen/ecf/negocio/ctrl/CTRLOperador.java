/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.persistencia.dao.IDAOOperador;
import com.sigen.ecf.persistencia.dao.impl.DAOOperador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLOperador {

    private IDAOOperador iOperador;

    public CTRLOperador() {
        this.iOperador = new DAOOperador();
    }

    public void inserir(BeanOperador operadorBean) {
        try {
            this.iOperador.inserir(operadorBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Operador) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanOperador OperadorNovo, BeanOperador OperadorAntigo) {
        try {
            this.iOperador.atualizar(OperadorNovo, OperadorAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Operador) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanOperador> pesquisar(BeanOperador operadorBean, boolean flagSupervisor) {
        try {
            // Flag de supervisor
            operadorBean.setSupervisor(flagSupervisor);

            return this.iOperador.pesquisa(operadorBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Operador) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanOperador>();
        }
    }

    public void remover(BeanOperador operadorBean) {
        try {
            this.iOperador.remover(operadorBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Operador) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
