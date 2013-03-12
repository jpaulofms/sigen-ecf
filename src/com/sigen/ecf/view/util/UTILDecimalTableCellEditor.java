/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.view.util;

import java.awt.Font;
import javax.swing.DefaultCellEditor;

/**
 *
 * @author Administrador
 */
public class UTILDecimalTableCellEditor extends DefaultCellEditor {

    public UTILDecimalTableCellEditor() {

        super(new UTILDecimalTextField() {
            @Override
            public Font getFont() {
                return new Font("Arial", Font.PLAIN, 12);
            }
        });
    }
}
