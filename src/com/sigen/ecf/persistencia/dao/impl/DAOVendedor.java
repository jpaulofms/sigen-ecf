/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanVendedor;
import com.sigen.ecf.persistencia.dao.IDAOVendedor;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOVendedor extends DAOAbstract implements IDAOVendedor {

    @Override
    public void inserir(BeanVendedor vendedorBean) {

        sql = "INSERT INTO CAD_VENDEDOR("
                + " COD_VENDEDOR,"
                + " NOME)"
                + " VALEUS (".concat(UTILBiblioteca.repeteStringDAO("?", 2)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, vendedorBean.getCodVendedor());
            pstm.setString(2, vendedorBean.getNome());

            pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanVendedor vendedorBeanNovo, BeanVendedor vendedorBeanAntigo) {

        sql = "UPDATE CAD_VENDEDOR SET"
                + " COD_VENDEDOR = ?,"
                + " NOME = ?";

        sql = sql.concat(aplicarFiltro(vendedorBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, vendedorBeanNovo.getCodVendedor());
            pstm.setString(2, vendedorBeanNovo.getNome());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanVendedor> pesquisa(BeanVendedor vendedorBean) {

        sql = "SELECT"
                + " COD_VENDEDOR,"
                + " NOME"
                + " FROM CAD_VENDEDOR";

        sql = sql.concat(aplicarFiltro(vendedorBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanVendedor> listaVendedor = new ArrayList<BeanVendedor>();

            while (rs.next()) {
                BeanVendedor vendedor = new BeanVendedor();

                vendedor.setCodVendedor(rs.getString("COD_VENDEDOR"));
                vendedor.setNome(rs.getString("NOME"));

                listaVendedor.add(vendedor);
            }

            return listaVendedor;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanVendedor>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanVendedor vendedorBean) {

        sql = "DELETE FROM CAD_VENDEDOR";
        sql = sql.concat(aplicarFiltro(vendedorBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanVendedor vendedorBean) {
        String filtro = " WHERE 1 = 1";

        // CODOPER
        if (vendedorBean.getCodVendedor() != null && !vendedorBean.getCodVendedor().equals("")) {
            filtro = filtro.concat(" AND COD_VENDEDOR = '".concat(vendedorBean.getCodVendedor()).concat("'"));
        }

        // NOME
        if (vendedorBean.getNome() != null && !vendedorBean.getNome().equals("")) {
            filtro = filtro.concat(" AND NOME LIKE '".concat(vendedorBean.getNome()).concat("%'"));
        }

        return filtro;
    }
}
