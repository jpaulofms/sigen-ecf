/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.view.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class GerenciarArquivoPendente {

    public static void gravar(String numPed) {
        try {
            File arquivoPendenteTxt = new File(System.getProperty("user.dir") + "\\pedidoPendente.txt");
            FileOutputStream saida = new FileOutputStream(arquivoPendenteTxt, true);
            PrintStream p = new PrintStream(saida);
            p.println(numPed);
            p.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removerPedido() {
        try {
            boolean arquivoDeletado = true;
            File arquivoPendenteTxt = new File(System.getProperty("user.dir") + "\\pedidoPendente.txt");
            if (arquivoPendenteTxt.exists()) {
                arquivoDeletado = arquivoPendenteTxt.delete();
            }
//            if (!arquivoDeletado) {
//                remover();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removerTitulo() {
        try {
            boolean arquivoDeletado = true;
            File arquivoPendenteTxt = new File(System.getProperty("user.dir") + "\\tituloPendente.txt");
            if (arquivoPendenteTxt.exists()) {
                arquivoDeletado = arquivoPendenteTxt.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String consultarPedidoPendente() {
        File arquivoPendenteTxt = new File(System.getProperty("user.dir") + "\\pedidoPendente.txt");
        String linhaArquivo;
        try {
            if (arquivoPendenteTxt.exists()) {
                FileReader leitura = new FileReader(arquivoPendenteTxt);
                BufferedReader entrada = new BufferedReader(leitura);
                linhaArquivo = entrada.readLine();

                entrada.close();
                leitura.close();

                return linhaArquivo;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar pedido pendente.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static List<String> consultarTituloPendente() {
        File arquivoPendenteTxt = new File(System.getProperty("user.dir") + "\\tituloPendente.txt");
        String linhaArquivo;
        List<String> lRetornoTituloPendente = new ArrayList<String>();

        try {
            if (arquivoPendenteTxt.exists()) {
                FileReader leitura = new FileReader(arquivoPendenteTxt);
                BufferedReader entrada = new BufferedReader(leitura);

                while ((linhaArquivo = entrada.readLine()) != null) {
                    lRetornoTituloPendente.add(linhaArquivo);
                }

                entrada.close();
                leitura.close();

                return lRetornoTituloPendente;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar titulo pendente.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
