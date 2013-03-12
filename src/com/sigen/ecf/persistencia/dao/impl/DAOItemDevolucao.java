/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanItemDevolucao;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOItemDevolucao extends DAOAbstract {

    public void inserir(BeanItemDevolucao beanItemDevolucao) {

        sql = "INSERT INTO MOV_ITEM_DEVOLUCAO("
                + " COD_ECF,"
                + " LOJA,"
                + " COO_DEVOLUCAO,"
                + " COD_PRODUTO,"
                + " QUANTIDADE,"
                + " VALOR_UNITARIO,"
                + " VALOR_TOTAL,"
                + " COD_MOV)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 8)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, beanItemDevolucao.getCodEcf());
            pstm.setString(2, beanItemDevolucao.getLoja());
            pstm.setString(3, beanItemDevolucao.getCoo());
            pstm.setString(4, beanItemDevolucao.getCodProduto());
            pstm.setBigDecimal(5, beanItemDevolucao.getQuantidade());
            pstm.setBigDecimal(6, beanItemDevolucao.getValorUnitario());
            pstm.setBigDecimal(7, beanItemDevolucao.getValorTotal());
            pstm.setString(8, beanItemDevolucao.getCodMov());

            pstm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public void atualizar(BeanItemDevolucao itemDevolucaoNovo, BeanItemDevolucao itemDevolucaoAntigo) {

        sql = "UPDATE MOV_ITEM_DEVOLUCAO SET"
                + " COD_ECF = ?,"
                + " LOJA = ?,"
                + " COO_DEVOLUCAO = ?,"
                + " COD_PRODUTO = ?,"
                + " QUANTIDADE = ?,"
                + " VALOR_UNITARIO = ?,"
                + " VALOR_TOTAL = ?,"
                + " COD_MOV = ?";

        sql = sql.concat(aplicarFiltro(itemDevolucaoAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);
            pstm.setString(1, itemDevolucaoNovo.getCodEcf());
            pstm.setString(2, itemDevolucaoNovo.getLoja());
            pstm.setString(3, itemDevolucaoNovo.getCoo());
            pstm.setString(4, itemDevolucaoNovo.getCodProduto());
            pstm.setBigDecimal(5, itemDevolucaoNovo.getQuantidade());
            pstm.setBigDecimal(6, itemDevolucaoNovo.getValorUnitario());
            pstm.setBigDecimal(7, itemDevolucaoNovo.getValorTotal());
            pstm.setString(8, itemDevolucaoNovo.getCodMov());

            pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public List<BeanItemDevolucao> pesquisa(BeanItemDevolucao itemDevolucao) {

        sql = "SELECT"
                + " COD_ECF,"
                + " LOJA,"
                + " COO_DEVOLUCAO,"
                + " COD_PRODUTO,"
                + " QUANTIDADE,"
                + " VALOR_UNITARIO,"
                + " VALOR_TOTAL,"
                + " COD_MOV"
                + " FROM MOV_ITEM_DEVOLUCAO";

        sql = sql.concat(aplicarFiltro(itemDevolucao));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanItemDevolucao> listaItemDevolucao = new ArrayList<BeanItemDevolucao>();

            while (rs.next()) {
                BeanItemDevolucao devolucao = new BeanItemDevolucao();

                itemDevolucao.setCodEcf(rs.getString("COD_ECF"));
                itemDevolucao.setLoja(rs.getString("LOJA"));
                itemDevolucao.setCoo(rs.getString("COO_DEVOLUCAO"));
                itemDevolucao.setCodProduto(rs.getString("COD_PRODUTO"));
                itemDevolucao.setQuantidade(rs.getBigDecimal("QUANTIDADE"));
                itemDevolucao.setValorUnitario(rs.getBigDecimal("VALOR_UNITARIO"));
                itemDevolucao.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
                itemDevolucao.setCodMov(rs.getString("COD_MOV"));

                listaItemDevolucao.add(devolucao);
            }

            return listaItemDevolucao;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanItemDevolucao>();
        } finally {
            bd.desconectar();
        }

    }

    public void remover(BeanItemDevolucao conveniadaBean) {

        sql = "DELETE FROM MOV_ITEM_DEVOLUCAO";
        sql = sql.concat(aplicarFiltro(conveniadaBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanItemDevolucao devolucao) {
        String filtro = " WHERE 1 = 1";

        // COO
        if (devolucao.getCoo() != null && !devolucao.getCoo().equals("")) {
            filtro = filtro.concat(" AND COO = '".concat(devolucao.getCoo()).concat("'"));
        }

        return filtro;
    }
}
