/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view.util;

import com.sigen.ecf.model.bean.BeanSangria;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class SangriaTableModel extends AbstractTableModel {

    private List<BeanSangria> lista;
    private String[] colunas = new String[]{"FORMA", "VALOR EM CAIXA", "SANGRIA"};

    public SangriaTableModel(List<BeanSangria> lista) {
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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        lista.get(rowIndex).setValorSangria(new BigDecimal(aValue.toString()));
        fireTableRowsUpdated(lista.size() - 1, lista.size());
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BeanSangria beanSangria = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return beanSangria.getTipoFormaPagamento();
            case 1:
                return beanSangria.getTotalSangrar();
            case 2:
                return beanSangria.getValorSangria();
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
                return BigDecimal.class;
            case 2:
                return BigDecimal.class;
            default:
                throw new IndexOutOfBoundsException(
                        "Index out of Bounds");
        }
    }

    public BeanSangria getSelection(int row) {
        return lista.get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 2 && (lista.get(rowIndex).getTotalSangrar().compareTo(BigDecimal.ZERO) > 0)) {
            return true;
        }
        return false;
    }
}
