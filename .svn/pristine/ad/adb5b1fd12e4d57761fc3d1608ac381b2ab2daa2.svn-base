/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanConveniada;
import com.sigen.ecf.persistencia.dao.IDAOConveniada;
import com.sigen.ecf.persistencia.dao.impl.DAOConveniada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLUnidadeMedida {

    private IDAOConveniada iConveniada;

    public CTRLUnidadeMedida() {
        this.iConveniada = new DAOConveniada();
    }

    public void inserir(BeanConveniada ConveniadaBean) {
        try {
            this.iConveniada.inserir(ConveniadaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Conveniada) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanConveniada ConveniadaNovo, BeanConveniada ConveniadaAntigo) {
        try {
            this.iConveniada.atualizar(ConveniadaNovo, ConveniadaAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Conveniada) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanConveniada> pesquisa(BeanConveniada ConveniadaBean) {
        try {
            return this.iConveniada.pesquisa(ConveniadaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Conveniada) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanConveniada>();
        }
    }

    public void remover(BeanConveniada ConveniadaBean) {
        try {
            this.iConveniada.remover(ConveniadaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Conveniada) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
