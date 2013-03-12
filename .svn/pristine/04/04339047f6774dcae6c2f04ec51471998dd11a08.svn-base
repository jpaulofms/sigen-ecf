/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanSangria;
import com.sigen.ecf.persistencia.dao.IDAOSangria;
import com.sigen.ecf.persistencia.dao.impl.DAOSangria;
import com.sigen.ecf.view.VIEWEfetuarSangria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLSangria {

    private IDAOSangria iSangria;

    public CTRLSangria() {
        this.iSangria = new DAOSangria();
    }

    public void efetuarSangria() {
        try {
            // Tela para coleta de parametros para efetuar sangria
//            VIEWEfetuarSangria efetuarSangria = new VIEWEfetuarSangria(null, true);
            //          efetuarSangria.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gerar espelhoMFD: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inserir(BeanSangria SangriaBean) {
        try {
            this.iSangria.inserir(SangriaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Sangria) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanSangria SangriaNovo, BeanSangria SangriaAntigo) {
        try {
            this.iSangria.atualizar(SangriaNovo, SangriaAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Sangria) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanSangria> pesquisa(BeanSangria SangriaBean) {
        try {
            return this.iSangria.pesquisa(SangriaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Sangria) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanSangria>();
        }
    }

    public void remover(BeanSangria SangriaBean) {
        try {
            this.iSangria.remover(SangriaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Sangria) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
