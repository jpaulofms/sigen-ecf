/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.view.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Administrador
 */
public class FTPConnection {

    private static boolean arquivoEnviado = false;

    public static void main(String[] args, String numECF) {
        String caminhoArquivoMFD = args[0];
        try {
            enviarArquivoMFD(caminhoArquivoMFD, numECF, new Date());

            if (arquivoEnviado) {
                //EXCLUIR ARQUIVOS LOCAIS
                File fileDownloadMFD = new File("C:\\DownloadMFD.MFD");
                if (fileDownloadMFD.exists()) {
                    fileDownloadMFD.delete();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static FTPClient isConnectionFTP(String numECF, String codFil, Date dataAtual) {

        FTPClient ftp = new FTPClient();
        String filial = "";

        // LOJA
        switch (Integer.parseInt(codFil)) {
            case 2:
                filial = "Casa do Fio";
                break;
            case 4:
                filial = "Mistao Norte";
                break;
            case 5:
                filial = "Mistao";
                break;
            case 10:
                filial = "Mistao Moveis";
                break;
        }
        try {
            //ECF
            int n = Integer.parseInt(numECF);
            numECF = "ECF " + n;

            // CONECTAR
            ftp.connect("192.168.1.1");
            ftp.login("mistao", "mis199");


            // SE DIRETÓRIO ECF NÃO EXISTIR, CRIA-LO
            String diretorio = "\\MFD\\" + filial + "\\" + numECF;
            verificaExistenciaDiretorio(ftp, diretorio);

            // SE DIRETÓRIO MES NÃO EXISTIR, CRIA-LO
            SimpleDateFormat dtFormat = new SimpleDateFormat("MMMMM"); // Retorno string com nome do mes
            String meuMes = dtFormat.format(dataAtual);
            diretorio += "\\" + meuMes;

            verificaExistenciaDiretorio(ftp, diretorio);

            //verifica se conectou com sucesso!  
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                //erro ao se conectar  
                ftp.disconnect();
                System.out.println("Conexão recusada");
                System.exit(1);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return ftp;
    }

    private static boolean verificaExistenciaDiretorio(FTPClient ftp, String diretorio) throws IOException {
        boolean diretorioExiste = false;
        while (!diretorioExiste) {
            if (!ftp.changeWorkingDirectory(diretorio)) {
                ftp.makeDirectory(diretorio);
            } else {
                diretorioExiste = true;
            }
        }
        return diretorioExiste;
    }

    private static void enviarArquivoMFD(String caminhoArquivoMFD, String numECF, Date dataAtual) throws IOException {

        FTPClient ftp = new FTPClient();
        try {
            ftp = isConnectionFTP(numECF, "", dataAtual);

            //Preparar o arquivo para o envio...  
            if (caminhoArquivoMFD != null && !caminhoArquivoMFD.equals("")) {
                //Arquivo a ser enviado
                InputStream isEnvio = new FileInputStream(caminhoArquivoMFD);

                SimpleDateFormat formatData = new SimpleDateFormat("yyyyMMdd");
                String nomeArquivoEnvio = formatData.format(dataAtual) + ".txt";

                // Tipo do arquivo
                ftp.setFileType(FTPClient.ASCII_FILE_TYPE);
                System.out.println("Enviando arquivo...");

                //Envia o arquivo e checa se arquivo realmente foi enviado                    
                if (ftp.storeFile(nomeArquivoEnvio, isEnvio) && (envioBemSucedido(nomeArquivoEnvio, ftp))) {
                    System.out.println("Arquivo enviado com sucesso!");
                    arquivoEnviado = true;
                } else {
                    System.out.println("Arquivo não enviado!");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e);
            System.exit(1);
        } finally {
            ftp.logout();
            ftp.disconnect();
        }
    }

    private static boolean envioBemSucedido(String nomeArquivoMFD, FTPClient ftp) throws IOException {
        boolean result = false;

        try {
            if (ftp.isConnected()) {
                //Lista de Arquivos no diretorio corrente
                String[] files = ftp.listNames();

                //Verifica se encontra arquivo enviado
                for (String f : files) {
                    if (f.equalsIgnoreCase(nomeArquivoMFD)) {
                        return true;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
}