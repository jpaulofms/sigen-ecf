/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanParametros;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOParametros extends DAOAbstract {

    public void inserir(BeanParametros beanParametros) {

        sql = "INSERT INTO ECF_PARAMETROS("
                + " UTILIZACAO_PARCIAL_CREDITO, FOLDER_IN, FOLDER_OUT)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 3)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setBoolean(1, beanParametros.isPermiteUtilizacaoCreditoParcial());
            pstm.setString(2, beanParametros.getFolderIn());
            pstm.setString(3, beanParametros.getFolderOut());

            pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public void atualizar(BeanParametros beanParametrosNovo, BeanParametros beanParametrosAntigo) {

        sql = "UPDATE ECF_PARAMETROS SET"
                + " UTILIZACAO_PARCIAL_CREDITO = ?, FOLDER_IN = ?, FOLDER_OUT = ?";

        sql = sql.concat(aplicarFiltro(beanParametrosAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setBoolean(1, beanParametrosNovo.isPermiteUtilizacaoCreditoParcial());
            pstm.setString(2, beanParametrosNovo.getFolderIn());
            pstm.setString(3, beanParametrosNovo.getFolderOut());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public List<BeanParametros> pesquisa(BeanParametros beanParametros) {

        sql = "SELECT"
                + " UTILIZACAO_PARCIAL_CREDITO,"
                + " FOLDER_IN,"
                + " FOLDER_OUT"
                + " FROM ECF_PARAMETROS";

        sql = sql.concat(aplicarFiltro(beanParametros));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanParametros> listaParametros = new ArrayList<BeanParametros>();

            while (rs.next()) {
                BeanParametros beanParametro = new BeanParametros();

                beanParametro.setPermiteUtilizacaoCreditoParcial(rs.getBoolean("UTILIZACAO_PARCIAL_CREDITO"));
                beanParametro.setFolderIn(rs.getString("FOLDER_IN"));
                beanParametro.setFolderOut(rs.getString("FOLDER_OUT"));

                listaParametros.add(beanParametro);
            }

            return listaParametros;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanParametros>();
        } finally {
            bd.desconectar();
        }
    }

    public void remover(BeanParametros beanParametros) {

        sql = "DELETE FROM ECF_PARAMETROS";

        sql = sql.concat(aplicarFiltro(beanParametros));

        try {

            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanParametros beanParametros) {
        String filtro = " WHERE 1 = 1";

        return filtro;
    }
}