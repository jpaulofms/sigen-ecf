/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.view.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class EchoClienteVeSPague {

    public static StringBuilder enviaComando(StringBuilder comando) {

        System.out.println(comando);
        
        Socket socket = null;
        BufferedReader entrada = null;
        DataOutputStream saida = null;

        // Retorno
        StringBuilder s = null;

        try {
            socket = new Socket("localhost", 60906);// VeSPague

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new DataOutputStream(socket.getOutputStream());

            // Envia comando
            saida.writeBytes(comando.toString());

            s = new StringBuilder();
            String linha = "";

            int i = 0;
            String[] sSaida = new String[]{"", "		", "			", "		"};
            while ((linha = entrada.readLine()) != null) {

                if (i == 3) {
                    break;
                }

                if (linha.equals(sSaida[i])) {
                    i++;
                }
                s.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    saida.close();
                    entrada.close();
                    socket.close();

                } catch (IOException ex) {
                    Logger.getLogger(EchoClienteVeSPague.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // Retorno

        return s;
    }
}
