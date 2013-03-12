/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanSpedFiscalAliquota;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOSpedFiscalAliquota extends DAOAbstract {

    public void inserir(BeanSpedFiscalAliquota spedFiscalAliquota) {

        sql = "INSERT INTO MOV_SPED_FISCAL_ALIQUOTA("
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " LOJA,"
                + " ALIQUOTA,"
                + " VALOR_ALIQUOTA,"
                + " DATA_REFERENCIA,"
                + " ID)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 7)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, spedFiscalAliquota.getCodEcf());
            pstm.setString(2, spedFiscalAliquota.getCodMov());
            pstm.setString(3, spedFiscalAliquota.getLoja());
            pstm.setString(4, spedFiscalAliquota.getAliquota());
            pstm.setString(5, spedFiscalAliquota.getTotalAliquota());
            pstm.setString(6, spedFiscalAliquota.getDataReferencia());
            pstm.setString(7, spedFiscalAliquota.getId());

            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public void atualizar(BeanSpedFiscalAliquota spedFiscalAliquotaNovo, BeanSpedFiscalAliquota spedFiscalAliquotaAntigo) {

        sql = "UPDATE MOV_SPED_FISCAL_ALIQUOTA SET"
                + " COD_ECF = ?,"
                + " COD_MOVIMENTO = ?,"
                + " LOJA = ?,"
                + " ALIQUOTA = ?,"
                + " VALOR_ALIQUOTA = ?,"
                + " DATA_REFERENCIA = ?,"
                + " ID = ?";

        sql = sql.concat(aplicarFiltro(spedFiscalAliquotaAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, spedFiscalAliquotaNovo.getCodEcf());
            pstm.setString(2, spedFiscalAliquotaNovo.getCodMov());
            pstm.setString(3, spedFiscalAliquotaNovo.getLoja());
            pstm.setString(4, spedFiscalAliquotaNovo.getAliquota());
            pstm.setString(5, spedFiscalAliquotaNovo.getTotalAliquota());
            pstm.setString(6, spedFiscalAliquotaNovo.getDataReferencia());
            pstm.setString(7, spedFiscalAliquotaNovo.getId());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public List<BeanSpedFiscalAliquota> pesquisa(BeanSpedFiscalAliquota spedFiscalAliquota) {

        sql = "SELECT"
                + " ID,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " LOJA,"
                + " ALIQUOTA,"
                + " VALOR_ALIQUOTA,"
                + " DATA_REFERENCIA"
                + " FROM MOV_SPED_FISCAL_ALIQUOTA";

        sql = sql.concat(aplicarFiltro(spedFiscalAliquota));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanSpedFiscalAliquota> listaSpedFiscal = new ArrayList<BeanSpedFiscalAliquota>();

            while (rs.next()) {
                BeanSpedFiscalAliquota sfAliquota = new BeanSpedFiscalAliquota();

                sfAliquota.setId(rs.getString("ID"));
                sfAliquota.setCodEcf(rs.getString("COD_ECF"));
                sfAliquota.setCodMov(rs.getString("COD_MOVIMENTO"));
                sfAliquota.setLoja(rs.getString("LOJA"));
                sfAliquota.setAliquota(rs.getString("ALIQUOTA"));
                sfAliquota.setTotalAliquota(rs.getString("VALOR_ALIQUOTA"));
                sfAliquota.setDataReferencia(rs.getString("DATA_REFERENCIA"));

                listaSpedFiscal.add(sfAliquota);
            }
            return listaSpedFiscal;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanSpedFiscalAliquota>();
        }
    }

    public String getUltimoId() {

        sql = "SELECT"
                + " ID"
                + " FROM MOV_SPED_FISCAL_ALIQUOTA"
                + " ORDER BY ID DESC";

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            String id = "0";
            if (rs.next()) {
                id = rs.getString("ID");
            }
            return id;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void remover(BeanSpedFiscalAliquota sangriaBean) {

        sql = "DELETE FROM MOV_SPED_FISCAL_ALIQUOTA";
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

    private String aplicarFiltro(BeanSpedFiscalAliquota spedFiscalAliquota) {

        String filtro = " WHERE 1 = 1";

        // COD_ECF
        if (spedFiscalAliquota.getCodEcf() != null && !spedFiscalAliquota.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '".concat(spedFiscalAliquota.getCodEcf())).concat("'");
        }
        // COD_MOVIMENTO
        if (spedFiscalAliquota.getCodMov() != null && !spedFiscalAliquota.getCodMov().equals("")) {
            filtro = filtro.concat(" AND COD_MOVIMENTO = '".concat(spedFiscalAliquota.getCodMov())).concat("'");
        }
        // LOJA
        if (spedFiscalAliquota.getLoja() != null && !spedFiscalAliquota.getLoja().equals("")) {
            filtro = filtro.concat(" AND LOJA = '".concat(spedFiscalAliquota.getLoja())).concat("'");
        }
        // DATA_REFERENCIA
        if (spedFiscalAliquota.getDataReferencia() != null && !spedFiscalAliquota.getDataReferencia().equals("")) {
            filtro = filtro.concat(" AND DATA_REFERENCIA = '".concat(spedFiscalAliquota.getDataReferencia())).concat("'");
        }

        return filtro;
    }
}
