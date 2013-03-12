/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.exception;

import javax.swing.JOptionPane;

/**
 *
 * @author SIGEN 3
 */
public class TratamentoException {

    public static boolean avisouPapel = false;
    
    public static void tratar(Exception ex) {
        ex.printStackTrace();
        if(ex instanceof PoucoPapelException){
            if(!avisouPapel){
                JOptionPane.showMessageDialog(null, "Impressora com pouco papel, substitua a bobina.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                avisouPapel = true;
            }
        }else if(ex instanceof FaltaPapelException){
            if(!avisouPapel){
                JOptionPane.showMessageDialog(null, "Impressora sem papel!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                avisouPapel = true;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro desconhecido", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
