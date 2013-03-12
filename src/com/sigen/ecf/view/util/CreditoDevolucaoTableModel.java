/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view.util;

import com.sigen.ecf.model.bean.BeanDevolucao;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class CreditoDevolucaoTableModel extends AbstractTableModel {

    private List<BeanDevolucao> lista;
    private String[] colunas = new String[]{"COMPROVANTE DA DEVOLUÇÃO", "VALOR DO CRÉDITO"};

    public CreditoDevolucaoTableModel(List<BeanDevolucao> lista) {
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
        BeanDevolucao beanCredito = lista.get(rowIndex);
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        switch (columnIndex) {
            case 0:
                return beanCredito.getCoo();
            case 1:
                return nf.format(beanCredito.getValorCredito()).replace("R$", "");
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
            default:
                throw new IndexOutOfBoundsException("Index out of Bounds");
        }
    }

    public BeanDevolucao getSelection(int row) {
        return lista.get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
