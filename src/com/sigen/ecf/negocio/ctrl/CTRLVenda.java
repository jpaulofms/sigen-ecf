/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.persistencia.dao.IDAOVenda;
import com.sigen.ecf.persistencia.dao.impl.DAOVenda;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLVenda {

    private IDAOVenda iVenda;
    private List<BeanProduto> lsProduto;
    /* Globais Temporarias */
    private BigDecimal totalVenda;
    private Integer itemCancelar;

    public CTRLVenda() {
        this.iVenda = new DAOVenda();
    }

    public void pesquisarPedido() {
    }

    public void totalizarVenda(BeanCliente cliente, BigDecimal valorCompra, BigDecimal valorDesconto, BigDecimal valorReceber) {
        try {
            /* Processos para totalizar e concluir uma venda
             * Abrir seleção da condição de pagamento, caso não seja retornado um cancelamento da seleção,
             * tela de seleção de forma de pagamento passando como parametro o objeto retornado da condição de pagamento,
             * ocorrendo sucesso, gravar dados da venda
             */
            if (!new CTRLCondicaoPagamento().selecionarCondicaoPagamento(cliente, valorCompra, valorDesconto, valorReceber)) {
                // Gravar
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void abrirCupom() {
        try {
            /* Abrir Cupom Fiscal */
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Abrir Cupom:".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelarCupom() {
        try {
            /* Cancelar cupom de venda aberto
             * Solicitar autenticação de usuário para cancelar venda
             */
            if (new CTRLMovimento().autenticarLoginGerente()) {
                // Ações
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Cancelar Cupom:".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inserir(BeanVenda VendaBean) {
        try {
            this.iVenda.inserir(VendaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Venda) Insert:".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanVenda VendaNovo, BeanVenda VendaAntigo) {
        try {
            this.iVenda.atualizar(VendaNovo, VendaAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Venda) Update:".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanVenda> pesquisa(BeanVenda VendaBean) {
        try {
            return this.iVenda.pesquisa(VendaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Venda) Select:".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanVenda>();
        }
    }

    public void remover(BeanVenda VendaBean) {
        try {
            this.iVenda.remover(VendaBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Venda) Delete:".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean venderItem(BeanProduto produto, String quantidade) {
        try {
            if (lsProduto == null) {
                lsProduto = new ArrayList<BeanProduto>();
            }
            lsProduto.add(produto);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String getLsProdutoSize() {
        return String.valueOf(lsProduto.size());
    }

    public BeanProduto cancelarItemVenda() {
        itemCancelar = 0;
        itemCancelar = Integer.parseInt(JOptionPane.showInputDialog(null, "Cancelar item", "Item", JOptionPane.QUESTION_MESSAGE));
        if (itemCancelar != 0) {
            BeanProduto produtoCancelar = removerItem(itemCancelar);
            if (produtoCancelar != null) {
                return produtoCancelar;
            }
        }
        return null;
    }

    private BeanProduto removerItem(Integer indexProduto) {
        if (indexProduto < lsProduto.size()) {
            BeanProduto produtoCancelar = lsProduto.get(indexProduto - 1);
            lsProduto.remove(indexProduto - 1);
            return produtoCancelar;
        }
        JOptionPane.showMessageDialog(null, "O item solicitado não existe na venda atual.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }

    public Integer getItemCancelar() {
        return itemCancelar;
    }
}
