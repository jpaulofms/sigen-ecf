package com.sigen.ecf.view.util;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.DefaultFocusManager;
import javax.swing.JFormattedTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.Document;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author victor
 */
@SuppressWarnings("serial")
public class UTILTextField extends JFormattedTextField {

    private KeyListener keyListener = null;
    private MaskFormatter mascara;

    public UTILTextField(NumberFormat format) {
        super(format);
    }

    public UTILTextField() {

        keyListener = new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_TAB
                        || e.getKeyChar() == KeyEvent.VK_ENTER) {
                    DefaultFocusManager focusManager = new DefaultFocusManager();
                    focusManager.focusNextComponent();
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        };

        this.addKeyListener(keyListener);
    }

    public UTILTextField(String text) {
        this();
        setText(text);
    }

    public void removeFocusNextComponentListener() {
        removeKeyListener(keyListener);
    }

    public boolean isEmpty() {
        return getText().trim().isEmpty();
    }

    public void adicionarMascara(String mask) {
        try {
            mascara = new MaskFormatter(mask);
            setFocusLostBehavior(JFormattedTextField.COMMIT);
        } catch (ParseException ex) {
        }

        setFormatterFactory(new DefaultFormatterFactory(mascara));
    }

    public String getTextSemMascara() {
        return replaceMaskChars(getText()).trim();
    }

    @Override
    public String getText() {
        return super.getText().trim();
    }

    private String replaceMaskChars(String text) {
        return text.replaceAll("\\.", "").replace(",", "");
    }

    protected boolean isUpperCase() {
        return true;
    }

    @Override
    protected Document createDefaultModel() {
        if (isUpperCase()) {
            return new UpperCaseDocument();
        }

        return super.createDefaultModel();
    }

    @Override
    public Color getDisabledTextColor() {
        return Color.BLACK;
    }

    @Override
    public Color getBackground() {
        if (!isEnabled()) {
            return Color.LIGHT_GRAY;
        }
        return Color.white;
    }

    static class UpperCaseDocument extends PlainDocument {

        private static final long serialVersionUID = -1872696724795783010L;

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {

            if (str == null) {
                return;
            }
            char[] upper = str.toCharArray();
            for (int i = 0; i < upper.length; i++) {
                upper[i] = Character.toUpperCase(upper[i]);
            }
            super.insertString(offs, new String(upper), a);
        }
    }
}
