/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.view.util;

import com.sigen.ecf.negocio.ctrl.CTRLCaixa;
import com.sigen.ecf.negocio.util.ICTRLCaixa;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Administrador
 */
public class AbstractView {

    public static NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    public static DecimalFormat df = new DecimalFormat("#,###,##0.00");
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static ICTRLCaixa iCaixa = new CTRLCaixa();

    public static DefaultFormatterFactory getMaskDate() {
        try {
            return new DefaultFormatterFactory(new MaskFormatter("##/##/####"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Máscara de datas ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new DefaultFormatterFactory();
        }
    }

    public static DefaultFormatterFactory getMaskCEP() {
        try {
            return new DefaultFormatterFactory(new MaskFormatter("##.###-###"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Máscara de CEP ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new DefaultFormatterFactory();
        }
    }

    public static DefaultFormatterFactory getMaskPorcentagem() {
        try {
            return new DefaultFormatterFactory(new MaskFormatter("##.##"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Máscara de Porcentagem ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new DefaultFormatterFactory();
        }
    }

    public static String formatString(String string, boolean cpf) {
        try {
            String mask = cpf ? "###.###.###-##" : "##.###.###/####-##";
            MaskFormatter mf = new MaskFormatter(mask);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(string);
        } catch (ParseException pe) {
            return "";
        }
    }
}