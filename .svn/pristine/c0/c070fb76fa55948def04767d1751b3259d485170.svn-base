/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view.util;

import com.sigen.ecf.model.bean.BeanItemVenda;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class DevolucaoTableModel extends AbstractTableModel {

    private List<BeanItemVenda> lista = new ArrayList<BeanItemVenda>();
    private String[] colunas = new String[]{"COD. PRODUTO", "DESCRIÇÃO", "QUANTIDADE", "VALOR UNITÁRIO", "VALOR TOTAL"};

    public DevolucaoTableModel() {
        lista = new ArrayList<BeanItemVenda>();
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
        BeanItemVenda itemVenda = lista.get(rowIndex);
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        switch (columnIndex) {
            case 0:
                return itemVenda.getCodProd();
            case 1:
                return itemVenda.getDescricao();
            case 2:
                return itemVenda.getQuantidadeVendida();
            case 3:
                return nf.format(itemVenda.getValorUnitario()).replace("R$", "");
            case 4:
                return nf.format(itemVenda.getValorTotal()).replace("R$", "");
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
                return BigDecimal.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("Index out of Bounds");
        }
    }

    public List<BeanItemVenda> getLista() {
        return lista;
    }

    public void addItem(BeanItemVenda itemVenda) {
        lista.add(itemVenda);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void atualizarGrid() {
        fireTableRowsUpdated(lista.size() - 1, lista.size());
    }

    public BigDecimal getTotalCredito() {
        BigDecimal total = BigDecimal.ZERO;
        for (BeanItemVenda iv : lista) {
            total = total.add(iv.getValorTotal());
        }

        return total;
    }
}
