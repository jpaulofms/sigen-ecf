/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.view.util;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitedDocumentTextField extends PlainDocument {

    int limit;

    public LimitedDocumentTextField(int limit) {
        this.limit = limit;
    }

    public void insertString(int offset, String s, AttributeSet a) throws BadLocationException {
        if (offset + s.length() <= limit) {
            super.insertString(offset, s, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
}