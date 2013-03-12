/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanSuprimento;
import com.sigen.ecf.persistencia.dao.IDAOSuprimento;
import com.sigen.ecf.persistencia.dao.impl.DAOSuprimento;
import com.sigen.ecf.view.VIEWInserirReal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLSuprimento {

    private IDAOSuprimento iSuprimento;

    public CTRLSuprimento() {
        this.iSuprimento = new DAOSuprimento();
    }

    public void efetuarSuprimento() {
        try {
            // Tela para coleta de parametros para efetuar suprimento
            VIEWInserirReal inserirReal = new VIEWInserirReal(null, true);
            inserirReal.setVisible(true);
            if (!inserirReal.cancelado) {
                JOptionPane.showMessageDialog(null, inserirReal.cancelado);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gerar espelhoMFD: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inserir(BeanSuprimento SuprimentoBean) {
        try {
            this.iSuprimento.inserir(SuprimentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Suprimento) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanSuprimento SuprimentoNovo, BeanSuprimento SuprimentoAntigo) {
        try {
            this.iSuprimento.atualizar(SuprimentoNovo, SuprimentoAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Suprimento) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }

    }

    public List<BeanSuprimento> pesquisa(BeanSuprimento SuprimentoBean) {
        try {
            return this.iSuprimento.pesquisa(SuprimentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Suprimento) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanSuprimento>();
        }
    }

    public void remover(BeanSuprimento SuprimentoBean) {
        try {
            this.iSuprimento.remover(SuprimentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Suprimento) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
