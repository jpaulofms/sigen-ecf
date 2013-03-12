/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.persistencia.dao.IDAOProduto;
import com.sigen.ecf.persistencia.dao.impl.DAOProduto;
import com.sigen.ecf.view.VIEWPesquisaProduto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLProduto {

    private static CTRLProduto instance;
    private IDAOProduto iProduto;

    private CTRLProduto() {
        this.iProduto = new DAOProduto();
    }

    public static CTRLProduto getInstance() {
        if (instance == null) {
            instance = new CTRLProduto();
        }

        return instance;
    }

    public void abrirPesquisaProduto() {
        try {
            /* Tela para pesquisar produtos
             * Após fechamento, dar procedimento de venda apenas se selecionado um produto
             */
            VIEWPesquisaProduto pesquisaProdutoDialog = new VIEWPesquisaProduto(null, true);
            pesquisaProdutoDialog.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Pesquisar Produto: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inserir(BeanProduto ProdutoBean) {
        try {
            this.iProduto.inserir(ProdutoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Produto) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanProduto ProdutoNovo, BeanProduto ProdutoAntigo) {
        try {
            this.iProduto.atualizar(ProdutoNovo, ProdutoAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Produto) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanProduto> pesquisar(BeanProduto ProdutoBean) {
        try {
            return this.iProduto.pesquisa(ProdutoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Produto) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanProduto>();
        }
    }

    private BeanProduto pesquisarProduto(String codProduto) {
        try {
            return this.iProduto.pesquisarProduto(codProduto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Produto) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private BeanProduto pesquisarProdutoCodBarra(String codBarra) {
        try {
            return this.iProduto.pesquisarProdutoCodBarra(codBarra);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Produto) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void remover(BeanProduto ProdutoBean) {
        try {
            this.iProduto.remover(ProdutoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Produto) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BeanProduto consultarProduto(String codProduto) {
        BeanProduto produto = pesquisarProduto(codProduto);
        if (produto == null) {
            produto = pesquisarProdutoCodBarra(codProduto);
            if (produto == null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }
        return produto;
    }
}
