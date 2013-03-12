/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.view.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Administrador
 */
public class UTILDecimalTableCellRenderer extends DefaultTableCellRenderer {

    private NumberFormat format = NumberFormat.getNumberInstance();

    public UTILDecimalTableCellRenderer() {
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
    }

    @Override
    protected void setValue(Object value) {
        try {
            BigDecimal valor = new BigDecimal(String.valueOf(value));

            setText((value == null || String.valueOf(value).isEmpty()) ? "" : format.format(valor));
        } catch (NumberFormatException e) {
            setValue(BigDecimal.ZERO);
        }
    }
}
