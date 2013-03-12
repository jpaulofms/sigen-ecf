/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanSpedFiscal;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOSpedFiscal extends DAOAbstract {

    public static String clausula = "";

    public void inserir(BeanSpedFiscal spedFiscal) {

        sql = "INSERT INTO MOV_SPED_FISCAL("
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " LOJA,"
                + " MODELO_ECF,"
                + " SERIE_ECF,"
                + " DATA_REFERENCIA,"
                + " CRO,"
                + " CRZ,"
                + " COO,"
                + " TOTALIZADOR_GERAL,"
                + " VENDA_BRUTA_DIARIA)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 11)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, spedFiscal.getCodEcf());
            pstm.setString(2, spedFiscal.getCodMov());
            pstm.setString(3, spedFiscal.getLoja());
            pstm.setString(4, spedFiscal.getModeloEcf());
            pstm.setString(5, spedFiscal.getSerieEcf());
            pstm.setString(6, spedFiscal.getDataReferencia());
            pstm.setString(7, spedFiscal.getContadorCro());
            pstm.setString(8, spedFiscal.getContadorCrz());
            pstm.setString(9, spedFiscal.getContadorCoo());
            pstm.setString(10, spedFiscal.getTotalizadorGeral());
            pstm.setString(11, spedFiscal.getVendaBrutaDiaria());

            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public void atualizar(BeanSpedFiscal spedFiscalNovo, BeanSpedFiscal spedFiscalAntigo) {

        sql = "UPDATE MOV_SPED_FISCAL SET"
                + " COD_ECF = ?,"
                + " COD_MOVIMENTO = ?,"
                + " LOJA = ?,"
                + " MODELO_ECF = ?,"
                + " SERIE_ECF = ?,"
                + " DATA_REFERENCIA = ?,"
                + " CRO = ?,"
                + " CRZ = ?,"
                + " COO = ?,"
                + " TOTALIZADOR_GERAL = ?,"
                + " VENDA_BRUTA_DIARIA = ?";

        sql = sql.concat(aplicarFiltro(spedFiscalAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, spedFiscalNovo.getCodEcf());
            pstm.setString(2, spedFiscalNovo.getCodMov());
            pstm.setString(3, spedFiscalNovo.getLoja());
            pstm.setString(4, spedFiscalNovo.getModeloEcf());
            pstm.setString(5, spedFiscalNovo.getSerieEcf());
            pstm.setString(6, spedFiscalNovo.getDataReferencia());
            pstm.setString(7, spedFiscalNovo.getContadorCro());
            pstm.setString(8, spedFiscalNovo.getContadorCrz());
            pstm.setString(9, spedFiscalNovo.getContadorCoo());
            pstm.setString(10, spedFiscalNovo.getTotalizadorGeral());
            pstm.setString(11, spedFiscalNovo.getVendaBrutaDiaria());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public List<BeanSpedFiscal> pesquisa(BeanSpedFiscal spedFiscal) {

        sql = "SELECT"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " LOJA,"
                + " MODELO_ECF,"
                + " SERIE_ECF,"
                + " DATA_REFERENCIA,"
                + " CRO,"
                + " CRZ,"
                + " COO,"
                + " TOTALIZADOR_GERAL,"
                + " VENDA_BRUTA_DIARIA"
                + " FROM MOV_SPED_FISCAL";

        sql = sql.concat(aplicarFiltro(spedFiscal));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanSpedFiscal> listaSpedFiscal = new ArrayList<BeanSpedFiscal>();

            while (rs.next()) {
                BeanSpedFiscal sangria = new BeanSpedFiscal();

                spedFiscal.setCodEcf(rs.getString("COD_ECF"));
                spedFiscal.setCodMov(rs.getString("COD_MOVIMENTO"));
                spedFiscal.setLoja(rs.getString("LOJA"));
                spedFiscal.setModeloEcf(rs.getString("MODELO_ECF"));
                spedFiscal.setSerieEcf(rs.getString("SERIE_ECF"));
                spedFiscal.setDataReferencia(rs.getString("DATA_REFERENCIA"));
                spedFiscal.setContadorCro(rs.getString("CRO"));
                spedFiscal.setContadorCrz(rs.getString("CRZ"));
                spedFiscal.setContadorCoo(rs.getString("COO"));
                spedFiscal.setTotalizadorGeral(rs.getString("TOTALIZADOR_GERAL"));
                spedFiscal.setVendaBrutaDiaria(rs.getString("VENDA_BRUTA_DIARIA"));

                listaSpedFiscal.add(sangria);
            }
            return listaSpedFiscal;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanSpedFiscal>();
        }
    }

    public void remover(BeanSpedFiscal sangriaBean) {

        sql = "DELETE FROM MOV_SPED_FISCAL";
        sql = sql.concat(aplicarFiltro(sangriaBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanSpedFiscal spedFiscal) {

        String filtro = " WHERE 1 = 1";

        // COD_ECF
        if (spedFiscal.getCodEcf() != null && !spedFiscal.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '".concat(spedFiscal.getCodEcf())).concat("'");
        }

        // COO
        if (spedFiscal.getContadorCoo() != null && !spedFiscal.getContadorCoo().equals("")) {
            filtro = filtro.concat(" AND COO = '".concat(spedFiscal.getContadorCoo())).concat("'");
        }

        // CRZ
        if (spedFiscal.getContadorCrz() != null && !spedFiscal.getContadorCrz().equals("")) {
            filtro = filtro.concat(" AND CRZ = '".concat(spedFiscal.getContadorCrz())).concat("'");
        }

        // CRO
        if (spedFiscal.getContadorCro() != null && !spedFiscal.getContadorCro().equals("")) {
            filtro = filtro.concat(" AND CRO = '".concat(spedFiscal.getContadorCro())).concat("'");
        }

        // DATA_REFERENCIA
        if (spedFiscal.getDataReferencia() != null && !spedFiscal.getDataReferencia().equals("")) {
            filtro = filtro.concat(" AND DATA_REFERENCIA = '".concat(spedFiscal.getDataReferencia())).concat("'");
        }

        return filtro;
    }
}
