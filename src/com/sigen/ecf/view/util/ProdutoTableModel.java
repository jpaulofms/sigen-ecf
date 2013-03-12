/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.view.util;

import com.sigen.ecf.model.bean.BeanProduto;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SIGEN
 */
public class ProdutoTableModel extends AbstractTableModel {

    private List<BeanProduto> lista;
    private String[] colunas = new String[]{"EAN", "DESCRIÇÃO", "UND", "ESTOQUE", "PREÇO"};

    public ProdutoTableModel(List<BeanProduto> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BeanProduto beanProduto = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return beanProduto.getEan() != null && !beanProduto.getEan().equals("") ? beanProduto.getEan() : "SEM EAN";
            case 1:
                return beanProduto.getDescricao();
            case 2:
                return beanProduto.getUndDescricao();
            case 3:
                return beanProduto.getSaldoEstoque();
            case 4:
                return AbstractView.nf.format(beanProduto.getPrecoVenda().multiply(beanProduto.getQuantidadeEmbalagem()));
            default:
                throw new IndexOutOfBoundsException("Index out of Bounds");
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return BigDecimal.class;
            case 4:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("Index out of Bounds");
        }
    }

    public void setVisibleTableData() {
        fireTableRowsInserted(0, lista.size() - 1);
    }

    public BeanProduto getSelection(int row) {
        return lista.get(row);
    }
}
