package com.sigen.ecf.infra.sync;

import com.sigen.ecf.infra.sync.exporta.DAOFactory;
import com.sigen.ecf.infra.sync.exporta.DevolucaoSincExporta;
import com.sigen.ecf.infra.sync.exporta.ItemDevolucaoSincExporta;
import com.sigen.ecf.infra.sync.exporta.ItemVendaSincExporta;
import com.sigen.ecf.infra.sync.exporta.LancamentoSincExporta;
import com.sigen.ecf.infra.sync.exporta.MovimentoSincExporta;
import com.sigen.ecf.infra.sync.exporta.SangriaSincExporta;
import com.sigen.ecf.infra.sync.exporta.Sincronizador;
import com.sigen.ecf.infra.sync.exporta.SpedFiscalAliquotaSincExporta;
import com.sigen.ecf.infra.sync.exporta.SpedFiscalSincExporta;
import com.sigen.ecf.infra.sync.exporta.SuprimentoSincExporta;
import com.sigen.ecf.infra.sync.exporta.VendaSincExporta;
import com.sigen.ecf.model.bean.BeanParametros;
import com.sigen.ecf.persistencia.DAOFacade;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Map;
import javax.swing.JOptionPane;

public class SigenECFSincExporta {

    private String DIR_PATH = "";
    private static final String FILE_NAME = "movimentos";
    private static final String FILE_EXTENSION = ".txt";
    private DecimalFormat df = new DecimalFormat("00");
    private Map parametros;

    /*public static void main(String[] args) {
     Map map = new HashMap();
     map.put("codEcf", "00001");//escrevi
     map.put("loja", "00001");
     SigenECFSincExporta app = new SigenECFSincExporta(map);
     app.run();
     }*/
    public SigenECFSincExporta(Map parametros) {
        this.parametros = parametros;
        if (System.getProperty("jboss.server.home.dir") != null) {
            DIR_PATH = System.getProperty("jboss.server.home.dir")
                    + File.separator + "deploy" + File.separator + "resources"
                    + File.separator;
        }

    }

    public void run() {

        try {

            String loja = (String) parametros.get("loja");
            String codEcf = (String) parametros.get("codEcf");

            ResultSet rs = DAOFactory.getEcfDao().executeQuery("select cod_mov from syn_data_exp where cod_ecf = '" + codEcf
                    + "' and loja = '" + loja + "' order by export_date desc limit 1");
            String codMov = "0";
            if (rs.next()) {
                codMov = rs.getString("cod_mov");
            }

            Calendar cal = Calendar.getInstance();
            StringBuffer data = new StringBuffer();
            data.append(FILE_NAME).append("_").append(loja)
                    .append("_").append(codEcf).append("_")
                    .append(cal.get(Calendar.YEAR)).append(df.format(cal.get(Calendar.MONTH) + 1))
                    .append(df.format(cal.get(Calendar.DATE))).append(df.format(cal.get(Calendar.HOUR_OF_DAY)))
                    .append(df.format(cal.get(Calendar.MINUTE))).append(df.format(cal.get(Calendar.SECOND)))
                    .append(FILE_EXTENSION);

            String fileName = data.toString();

            BeanParametros beanParametros = DAOFacade.getParametros(new BeanParametros());
            DIR_PATH = System.getProperty("user.dir") + beanParametros.getFolderOut() + "\\";

            gravarArquivo(new MovimentoSincExporta(codMov), DIR_PATH + fileName);

            gravarArquivo(new VendaSincExporta(codMov), DIR_PATH + fileName);

            gravarArquivo(new ItemVendaSincExporta(codMov), DIR_PATH + fileName);

            gravarArquivo(new LancamentoSincExporta(codMov), DIR_PATH + fileName);

            gravarArquivo(new SangriaSincExporta(codMov), DIR_PATH + fileName);

            gravarArquivo(new SuprimentoSincExporta(codMov), DIR_PATH + fileName);

            gravarArquivo(new DevolucaoSincExporta(codMov), DIR_PATH + fileName);

            gravarArquivo(new ItemDevolucaoSincExporta(codMov), DIR_PATH + fileName);
            
            gravarArquivo(new SpedFiscalSincExporta(codMov), DIR_PATH + fileName);

            gravarArquivo(new SpedFiscalAliquotaSincExporta(codMov), DIR_PATH + fileName);

            gravarFinalArquivo(SigenECFSincImporta.FINAL_ARQUIVO, DIR_PATH + fileName);

            rs = DAOFactory.getEcfDao().executeQuery("select cod_movimento, max(cast(cod_movimento as integer)) as inteiro from mov_movimento "
                    + "where cod_ecf = '" + codEcf + "' and loja = '" + loja + "' group by cod_movimento order by inteiro desc limit 1");
            if (rs.next()) {
                codMov = rs.getString("cod_movimento");
            }

            DAOFactory.getEcfDao().executeUpdate("insert into syn_data_exp ("
                    + "cod_mov, cod_ecf, loja, export_date) values ('"
                    + codMov + "', '" + codEcf + "', '" + loja + "',current_timestamp)");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    protected static void gravarFinalArquivo(String finalArquivo, String nomeArquivo) throws Exception{
        PrintWriter saida = new PrintWriter(new BufferedWriter(new FileWriter(
                nomeArquivo, true)));

        saida.println(finalArquivo);
        saida.close();
    }
    
    protected static void gravarArquivo(Sincronizador sinc, String nomeArquivo)
            throws Exception {
        String inserts = sinc.getInsertString();

        PrintWriter saida = new PrintWriter(new BufferedWriter(new FileWriter(
                nomeArquivo, true)));

        saida.println(inserts);
        saida.close();
    }
}
