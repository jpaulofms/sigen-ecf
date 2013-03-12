/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanProdutoUnidadeMedida;
import com.sigen.ecf.persistencia.dao.IDAOProdutoUnidadeMedida;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOProdutoUnidadeMedida extends DAOAbstract implements IDAOProdutoUnidadeMedida {

    @Override
    public void inserir(BeanProdutoUnidadeMedida produtoUnidadeMedidaBean) {

        sql = "INSERT INTO CAD_PRODUTO_UNIDADE_MEDIDA("
                + " COD_PROD,"
                + " COD_UND,"
                + " QTD_EMB,"
                + " UND_PADRAO)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 4)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, produtoUnidadeMedidaBean.getCodProduto());
            pstm.setString(2, produtoUnidadeMedidaBean.getCodUnidade());
            pstm.setBigDecimal(3, produtoUnidadeMedidaBean.getQtdEmbalagem());
            pstm.setBoolean(4, produtoUnidadeMedidaBean.isUnidadePadrao());

            pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanProdutoUnidadeMedida produtoUnidadeMedidaBeanNovo, BeanProdutoUnidadeMedida produtoUnidadeMedidaBeanAntigo) {

        sql = "UPDATE CAD_PRODUTO_UNIDADE_MEDIDA SET"
                + " COD_PROD = ?,"
                + " COD_UND = ?,"
                + " QTD_EMB = ?,"
                + " UND_PADRAO = ?";

        sql = sql.concat(aplicarFiltro(produtoUnidadeMedidaBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, produtoUnidadeMedidaBeanNovo.getCodProduto());
            pstm.setString(2, produtoUnidadeMedidaBeanNovo.getCodUnidade());
            pstm.setBigDecimal(3, produtoUnidadeMedidaBeanNovo.getQtdEmbalagem());
            pstm.setBoolean(4, produtoUnidadeMedidaBeanNovo.isUnidadePadrao());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanProdutoUnidadeMedida> pesquisa(BeanProdutoUnidadeMedida produtoUnidadeMedidaBean) {

        sql = "SELECT"
                + " COD_PROD,"
                + " COD_UND,"
                + " QTD_EMB"
                + " UND_PADRAO"
                + " FROM CAD_PRODUTO_UNIDADE_MEDIDA";

        sql = sql.concat(aplicarFiltro(produtoUnidadeMedidaBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanProdutoUnidadeMedida> listaProdutoUnidadeMedida = new ArrayList<BeanProdutoUnidadeMedida>();

            while (rs.next()) {
                BeanProdutoUnidadeMedida produtoUnidadeMedida = new BeanProdutoUnidadeMedida();

                produtoUnidadeMedida.setCodProduto(rs.getString("COD_PROD"));
                produtoUnidadeMedida.setCodUnidade(rs.getString("COD_UND"));
                produtoUnidadeMedida.setQtdEmbalagem(rs.getBigDecimal("QTD_EMB"));
                produtoUnidadeMedida.setUnidadePadrao(rs.getBoolean("UND_PADRAO"));

                listaProdutoUnidadeMedida.add(produtoUnidadeMedidaBean);
            }

            return listaProdutoUnidadeMedida;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanProdutoUnidadeMedida>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanProdutoUnidadeMedida produtoUnidadeMedidaBean) {

        sql = "DELETE FROM CAD_CODBARRA";

        sql = sql.concat(aplicarFiltro(produtoUnidadeMedidaBean));

        try {

            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanProdutoUnidadeMedida produtoUnidadeMedidaBean) {
        String filtro = " WHERE 1 = 1";

        // CODPROD
        if (produtoUnidadeMedidaBean.getCodProduto() != null && !produtoUnidadeMedidaBean.getCodProduto().equals("")) {
            filtro = filtro.concat(" AND COD_PROD = '".concat(produtoUnidadeMedidaBean.getCodProduto()).concat("'"));
        }
        // CODUND
        if (produtoUnidadeMedidaBean.getCodUnidade() != null && !produtoUnidadeMedidaBean.getCodUnidade().equals("")) {
            filtro = filtro.concat(" AND COD_UND = '".concat(produtoUnidadeMedidaBean.getCodUnidade()).concat("'"));
        }

        return filtro;
    }
}