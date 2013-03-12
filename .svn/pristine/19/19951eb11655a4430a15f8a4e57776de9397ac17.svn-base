/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.sync;

import com.sigen.ecf.infra.sync.importa.ViewAguardandoAtualizacao;
import com.sigen.ecf.model.bean.BeanParametros;
import com.sigen.ecf.persistencia.BDConnection;
import com.sigen.ecf.persistencia.DAOFacade;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author joaopaulo
 */
public class SigenECFSincImporta {

    private static String DATA_FILENAME = "\\cadastros.txt";
    public static String FINAL_ARQUIVO = "#$@SIGEN@$#";
    private Connection connection = null;
    private List<String> linhas = new ArrayList<String>();

    public static void main(String[] args) {
     SigenECFSincImporta aux = new SigenECFSincImporta();
     aux.verificarAtualizacaoDados();//outra coisa
     }
    public void verificarAtualizacaoDados() {
        try {
            if (hasDataToUpdate()) {
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    private boolean erro = false;

    private boolean hasDataToUpdate() throws Exception {

        boolean hasNewFile = false;

        BeanParametros beanParametros = DAOFacade.getParametros(new BeanParametros());
        
        System.out.println(System.getProperty("user.dir") + beanParametros.getFolderIn()+DATA_FILENAME);
        
        File data = new File(System.getProperty("user.dir") + beanParametros.getFolderIn() + DATA_FILENAME);

        if (data.exists()) {

            final Long time = data.lastModified();

            try {

                ResultSet rs = getConnection().prepareStatement("select data_time from syn_data order by update_date desc limit 1").executeQuery();

                if (rs.next()) {
                    hasNewFile = time.compareTo(rs.getLong("data_time")) > 0;
                } else {
                    hasNewFile = true;
                }

                if (hasNewFile) {
                    hasNewFile = checkIsComplete(data);
                }

                if (hasNewFile) {

                    ViewAguardandoAtualizacao at = new ViewAguardandoAtualizacao(null, true) {
                        @Override
                        public void atualizarCadastro() {
                            try {
                                removeOldData();
                                for (String linha : linhas) {
                                    getConnection().prepareStatement(linha).execute();
                                }
                                PreparedStatement ps = getConnection().prepareStatement("insert into syn_data (data_time, update_date) values (?, ?)");
                                ps.setLong(1, time);
                                ps.setTimestamp(2, new Timestamp(new Date().getTime()));
                                ps.execute();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                erro = true;
                            }
                            dispose();
                        }
                    };
                    at.setVisible(true);
                }

                if (erro) {
                    throw new SQLException();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                getConnection().rollback();
                throw new Exception("Erro ao tentar executar consulta");
            } finally {
                getConnection().commit();
                try {
                    getConnection().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new Exception("Erro ao tentar fechar conexão");
                }
            }
        }

        return hasNewFile;
    }
    private static String REMOVE_OLD_DATA_SQL = new StringBuffer("delete from cad_cliente;")
            .append("delete from cad_codigo_barras;")
            .append("delete from cad_condicao_pagamento;")
            .append("delete from cad_conveniada;")
            .append("delete from cad_forma_condicao_pagamento;")
            .append("delete from cad_forma_pagamento;")
            .append("delete from cad_forma_pagamento_conveniada;")
            .append("delete from cad_operador;")
            .append("delete from cad_produto_unidade_medida;")
            .append("delete from cad_produto;")
            .append("delete from cad_unidade_medida;")
            .append("delete from cad_vendedor;").toString();

    private void removeOldData() throws SQLException {
        String[] deleteSQL = REMOVE_OLD_DATA_SQL.split(";");
        for (String sql : deleteSQL) {
            if (!sql.trim().isEmpty()) {
                getConnection().prepareStatement(sql).execute();
            }
        }
    }

    private boolean checkIsComplete(File data) throws FileNotFoundException, IOException {
        BufferedReader bf = new BufferedReader(new FileReader(data));
        String linha;
        String ultimaLinha = null;
        while ((linha = bf.readLine()) != null) {
            ultimaLinha = linha;
            if (!ultimaLinha.equals(FINAL_ARQUIVO)) {
                linhas.add(linha);
            }
        }
        if (ultimaLinha != null) {
            return ultimaLinha.equals(FINAL_ARQUIVO);
        }
        return false;
    }

    private Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = new BDConnection().conectar();
            connection.setAutoCommit(false);
        }
        return connection;
    }
}
