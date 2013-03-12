/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanUnidadeMedida;
import com.sigen.ecf.persistencia.dao.IDAOUnidadeMedida;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOUnidadeMedida extends DAOAbstract implements IDAOUnidadeMedida {

    @Override
    public void inserir(BeanUnidadeMedida unidadeMedidaBean) {

        sql = "INSERT INTO CAD_UNIDADE_MEDIDA("
                + " COD_UND,"
                + " DESCRICAO)"
                + " VALEUS (".concat(UTILBiblioteca.repeteStringDAO("?", 2)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, unidadeMedidaBean.getCodUnidade());
            pstm.setString(2, unidadeMedidaBean.getDescricao());

            pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanUnidadeMedida unidadeMedidaBeanNovo, BeanUnidadeMedida unidadeMedidaBeanAntigo) {

        sql = "UPDATE CAD_UNIDADE_MEDIDA SET"
                + " COD_UND = ?,"
                + " DESCRICAO = ?";

        sql = sql.concat(aplicarFiltro(unidadeMedidaBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, unidadeMedidaBeanNovo.getCodUnidade());
            pstm.setString(2, unidadeMedidaBeanNovo.getDescricao());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanUnidadeMedida> pesquisa(BeanUnidadeMedida unidadeMedidaBean) {

        sql = "SELECT"
                + " COD_UND,"
                + " DESCRICAO"
                + " FROM CAD_UNIDADE_MEDIDA";

        sql = sql.concat(aplicarFiltro(unidadeMedidaBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanUnidadeMedida> listaUnidadeMedida = new ArrayList<BeanUnidadeMedida>();

            while (rs.next()) {
                BeanUnidadeMedida unidadeMedida = new BeanUnidadeMedida();

                unidadeMedida.setCodUnidade(rs.getString("COD_UND"));
                unidadeMedida.setDescricao(rs.getString("DESCRICAO"));

                listaUnidadeMedida.add(unidadeMedida);
            }

            return listaUnidadeMedida;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanUnidadeMedida>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanUnidadeMedida unidadeMedidaBean) {

        sql = "DELETE FROM CAD_UNIDADE_MEDIDA";
        sql = sql.concat(aplicarFiltro(unidadeMedidaBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanUnidadeMedida unidadeMedidaBean) {
        String filtro = " WHERE 1 = 1";

        // CODOPER
        if (unidadeMedidaBean.getCodUnidade() != null && !unidadeMedidaBean.getCodUnidade().equals("")) {
            filtro = filtro.concat(" AND COD_UND = '".concat(unidadeMedidaBean.getCodUnidade()).concat("'"));
        }

        // DESCRICAO
        if (unidadeMedidaBean.getDescricao() != null && !unidadeMedidaBean.getDescricao().equals("")) {
            filtro = filtro.concat(" AND DESCRICAO = '".concat(unidadeMedidaBean.getDescricao()).concat("'"));
        }

        return filtro;
    }
}
