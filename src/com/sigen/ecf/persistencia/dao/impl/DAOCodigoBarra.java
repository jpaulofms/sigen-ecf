/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanCodigoBarra;
import com.sigen.ecf.persistencia.dao.IDAOCodigoBarra;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOCodigoBarra extends DAOAbstract implements IDAOCodigoBarra {

    @Override
    public void inserir(BeanCodigoBarra codigoBarraBean) {

        sql = "INSERT INTO CAD_CODIGO_BARRAS("
                + " COD_PROD,"
                + " COD_UND,"
                + " EAN)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 4)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, codigoBarraBean.getCodProduto());
            pstm.setString(2, codigoBarraBean.getCodUnidade());
            pstm.setString(3, codigoBarraBean.getEan());

            pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanCodigoBarra codigoBarraBeanNovo, BeanCodigoBarra codigoBarraBeanAntigo) {

        sql = "UPDATE CAD_CODIGO_BARRAS SET"
                + " COD_PROD = ?,"
                + " COD_UND = ?,"
                + " EAN = ?";

        sql = sql.concat(aplicarFiltro(codigoBarraBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, codigoBarraBeanNovo.getCodProduto());
            pstm.setString(2, codigoBarraBeanNovo.getCodUnidade());
            pstm.setString(3, codigoBarraBeanNovo.getEan());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanCodigoBarra> pesquisa(BeanCodigoBarra codigoBarraBean) {

        sql = "SELECT"
                + " COD_PROD,"
                + " COD_UND,"
                + " EAN"
                + " FROM CAD_CODIGO_BARRAS";

        sql = sql.concat(aplicarFiltro(codigoBarraBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanCodigoBarra> listaCodigoBarra = new ArrayList<BeanCodigoBarra>();

            while (rs.next()) {
                BeanCodigoBarra codigoBarra = new BeanCodigoBarra();

                codigoBarra.setCodProduto(rs.getString("COD_PROD"));
                codigoBarra.setCodUnidade(rs.getString("COD_UND"));
                codigoBarra.setEan(rs.getString("EAN"));

                listaCodigoBarra.add(codigoBarraBean);
            }

            return listaCodigoBarra;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanCodigoBarra>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanCodigoBarra codigoBarraBean) {

        sql = "DELETE FROM CAD_CODBARRA";

        sql = sql.concat(aplicarFiltro(codigoBarraBean));

        try {

            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanCodigoBarra codigoBarraBean) {
        String filtro = " WHERE 1 = 1";

        // CODPROD
        if (codigoBarraBean.getCodProduto() != null && !codigoBarraBean.getCodProduto().equals("")) {
            filtro = filtro.concat(" AND COD_PROD = '".concat(codigoBarraBean.getCodProduto()).concat("'"));
        }
        // CODUND
        if (codigoBarraBean.getCodUnidade() != null && !codigoBarraBean.getCodUnidade().equals("")) {
            filtro = filtro.concat(" AND COD_UND = '".concat(codigoBarraBean.getCodUnidade()).concat("'"));
        }

        // EAN
        if (codigoBarraBean.getEan() != null && !codigoBarraBean.getEan().equals("")) {
            filtro = filtro.concat(" AND EAN = '".concat(codigoBarraBean.getEan()).concat("'"));
        }

        return filtro;
    }
}