package com.sigen.ecf.view.util;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;

/**
 * Component JMoneyField
 */
public class UTILDecimalTextField extends UTILTextField {

    private static final SimpleAttributeSet nullAttribute = new SimpleAttributeSet();
    private int minimunFractionDigits = 2;

    public UTILDecimalTextField() {
        this.minimunFractionDigits = minimunFractionDigits;
        inicializar();
    }

    private void inicializar() {
        this.setHorizontalAlignment(RIGHT);
        this.setDocument(new MoneyFieldDocument());
        this.addFocusListener(new MoneyFieldFocusListener());
        this.setText(getZero());
        this.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (e.getDot() != getText().length()) {
                    getCaret().setDot(getText().length());
                }
            }
        });
    }

    private final class MoneyFieldFocusListener extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {
            selectAll();
        }
    }

    public void setText(BigDecimal d) {
        java.text.NumberFormat format = DecimalFormat.getInstance();
        format.setMinimumFractionDigits(getMinimunFractionDigits());
        super.setText(format.format(d));
    }

    public int getMinimunFractionDigits() {
        return minimunFractionDigits;
    }

    public void setMinimunFractionDigits(int minimunFractionDigits) {
        this.minimunFractionDigits = minimunFractionDigits;
    }

    public BigDecimal getBigDecimal() {
        return new BigDecimal(getText());
    }

    @Override
    public String getText() {
        return super.getText().replace(".", "").replace(",", ".");
    }

    private final class MoneyFieldDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            String original = getText(0, getLength());

            // Permite apenas digitar até 16 caracteres (9.999.999.999,99)
            if (original.length() < 16) {
                StringBuffer mascarado = new StringBuffer();
                if (a != nullAttribute) {
                    // limpa o campo
                    remove(-1, getLength());

                    if (!str.startsWith("-")) {
                        mascarado.append((original + str));
                    } else if ("-".equals(str)) {
                        mascarado.append((original));
                    } else if (str.startsWith("-")) {
                        mascarado.append(str.replace("-", "0"));
                    }

                    for (int i = 1; i < mascarado.length(); i++) {
                        if (((char) ('-') != mascarado.charAt(i))
                                && !Character.isDigit(mascarado.charAt(i))) {
                            mascarado.deleteCharAt(i);
                        }
                    }

                    if ((str.startsWith("-"))) {
                        mascarado = new StringBuffer("-0"
                                + mascarado.toString());
                    }

                    BigDecimal number = new BigDecimal(mascarado.toString());

                    if (!(str.startsWith("-"))) {
                        mascarado.replace(0, mascarado.length(), number.toString());
                    }

                    if (mascarado.length() < minimunFractionDigits + 1) {
                        int l = mascarado.length() - 1;
                        do {
                            if (l == minimunFractionDigits - 1) {
                                mascarado.insert(0, ",");
                            } else {
                                mascarado.insert(0, "0");
                            }
                            l++;
                        } while (l < minimunFractionDigits + 1);
                        // if (mascarado.length() == 1) {
                        // mascarado.insert(0, "0");
                        // mascarado.insert(0, ",");
                        // mascarado.insert(0, "0");
                        // } else if (mascarado.length() ==
                        // minimunFractionDigits) {
                        // mascarado.insert(0, ",");
                        // mascarado.insert(0, "0");
                        // }
                    } else {
                        mascarado.insert(mascarado.length()
                                - minimunFractionDigits, ",");
                    }

                    int length = mascarado.length()
                            - (minimunFractionDigits + 1);
                    if (length > 3) {
                        mascarado.insert(length - 3, '.');
                        if (length > 6) {
                            mascarado.insert(length - 6, '.');
                            if (length > 9) {
                                mascarado.insert(length - 9, '.');
                                if (length > 12) {
                                    mascarado.insert(length - 12, '.');
                                }
                            }
                        }
                    }
                    super.insertString(0, mascarado.toString(), a);
                } else {
                    if (original.length() == 0) {
                        super.insertString(0, getZero(), a);
                    }
                }
            }
        }

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            if (len == getLength()) {
                super.remove(0, len);
                if (offs != -1) {
                    insertString(0, "", nullAttribute);
                }
            } else {
                String original = getText(0, getLength()).substring(0, offs)
                        + getText(0, getLength()).substring(offs + len);
                super.remove(0, getLength());
                insertString(0, original, null);
            }
        }
    }

    private String getZero() {
        StringBuilder b = new StringBuilder("0,");
        for (int i = 0; i < minimunFractionDigits; i++) {
            b.append("0");
        }
        return b.toString();
    }
}