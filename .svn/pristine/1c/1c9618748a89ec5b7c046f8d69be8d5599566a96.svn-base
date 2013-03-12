/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanSuprimento;
import com.sigen.ecf.persistencia.dao.IDAOSuprimento;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOSuprimento extends DAOAbstract implements IDAOSuprimento {

    public static String clausula;

    @Override
    public void inserir(BeanSuprimento suprimentoBean) {

        sql = "INSERT INTO MOV_SUPRIMENTO("
                + " COO,"
                + " GNF,"
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " VALOR,"
                + " DATA,"
                + " HORA,"
                + " COD_FORMA_PAGAMENTO)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 10)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, suprimentoBean.getCoo());
            pstm.setString(2, suprimentoBean.getGnf());
            pstm.setString(3, suprimentoBean.getLoja());
            pstm.setString(4, suprimentoBean.getCodEcf());
            pstm.setString(5, suprimentoBean.getCodMov());
            pstm.setString(6, suprimentoBean.getCodOper());
            pstm.setBigDecimal(7, suprimentoBean.getValor());
            pstm.setDate(8, new java.sql.Date(suprimentoBean.getData().getTime()));
            pstm.setString(9, suprimentoBean.getHora());
            pstm.setString(10, suprimentoBean.getCodFormaPagamento());

            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanSuprimento suprimentoBeanNovo, BeanSuprimento suprimentoBeanAntigo) {

        sql = "UPDATE MOV_SUPRIMENTO SET"
                + " COO = ?,"
                + " GNF = ?,"
                + " LOJA = ?,"
                + " COD_ECF = ?,"
                + " COD_MOVIMENTO = ?,"
                + " COD_OPERADOR = ?,"
                + " VALOR = ?,"
                + " DATA = ?,"
                + " HORA = ?,"
                + " COD_FORMA_PAGAMENTO = ?";

        sql = sql.concat(aplicarFiltro(suprimentoBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, suprimentoBeanNovo.getCoo());
            pstm.setString(2, suprimentoBeanNovo.getGnf());
            pstm.setString(3, suprimentoBeanNovo.getLoja());
            pstm.setString(4, suprimentoBeanNovo.getCodEcf());
            pstm.setString(5, suprimentoBeanNovo.getCodMov());
            pstm.setString(6, suprimentoBeanNovo.getCodOper());
            pstm.setBigDecimal(7, suprimentoBeanNovo.getValor());
            pstm.setDate(8, new java.sql.Date(suprimentoBeanNovo.getData().getTime()));
            pstm.setString(9, suprimentoBeanNovo.getHora());
            pstm.setString(10, suprimentoBeanNovo.getCodFormaPagamento());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanSuprimento> pesquisa(BeanSuprimento suprimentoBean) {

        sql = "SELECT"
                + " COO,"
                + " GNF,"
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " VALOR,"
                + " DATA,"
                + " HORA,"
                + " COD_FORMA_PAGAMENTO"
                + " FROM MOV_SUPRIMENTO";

        sql = sql.concat(aplicarFiltro(suprimentoBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanSuprimento> listaSuprimento = new ArrayList<BeanSuprimento>();

            while (rs.next()) {
                BeanSuprimento suprimento = new BeanSuprimento();

                suprimento.setCoo(rs.getString("COO"));
                suprimento.setGnf(rs.getString("GNF"));
                suprimento.setLoja(rs.getString("LOJA"));
                suprimento.setCodEcf(rs.getString("COD_ECF"));
                suprimento.setCodMov(rs.getString("COD_MOVIMENTO"));
                suprimento.setCodOper(rs.getString("COD_OPERADOR"));
                suprimento.setValor(rs.getBigDecimal("VALOR"));
                suprimento.setData(rs.getDate("DATA"));
                suprimento.setHora(rs.getString("HORA"));
                suprimento.setCodFormaPagamento(rs.getString("COD_FORMA_PAGAMENTO"));

                listaSuprimento.add(suprimento);
            }
            return listaSuprimento;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanSuprimento>();
        }
    }

    @Override
    public void remover(BeanSuprimento suprimentoBean) {

        sql = "DELETE FROM MOV_SUPRIMENTO";

        sql = sql.concat(aplicarFiltro(suprimentoBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanSuprimento suprimentoBean) {

        String filtro = " WHERE 1 = 1";

        // COO
        if (suprimentoBean.getCoo() != null && !suprimentoBean.getCoo().equals("")) {
            filtro = filtro.concat(" AND COO = '".concat(suprimentoBean.getCoo()).concat("'"));
        }

        // GNF
        if (suprimentoBean.getGnf() != null && !suprimentoBean.getGnf().equals("")) {
            filtro = filtro.concat(" AND GNF = '".concat(suprimentoBean.getGnf()).concat("'"));
        }

        // LOJA
        if (suprimentoBean.getLoja() != null && !suprimentoBean.getLoja().equals("")) {
            filtro = filtro.concat(" AND LOJA = '".concat(suprimentoBean.getLoja()).concat("'"));
        }

        // COD_ECF
        if (suprimentoBean.getCodEcf() != null && !suprimentoBean.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '".concat(suprimentoBean.getCodEcf()).concat("'"));
        }

        // COD_OPER
        if (suprimentoBean.getCodOper() != null && !suprimentoBean.getCodOper().equals("")) {
            filtro = filtro.concat(" AND COD_OPERADOR = '".concat(suprimentoBean.getCodOper()).concat("'"));
        }

        // COD_MOVIMENTO
        if (suprimentoBean.getCodMov() != null && !suprimentoBean.getCodMov().equals("")) {
            filtro = filtro.concat(" AND COD_MOVIMENTO = '".concat(suprimentoBean.getCodMov()).concat("'"));
        }

        // DATA
        if (suprimentoBean.getData() != null) {
            filtro = filtro.concat(" AND DATA = '".concat(sdf.format(suprimentoBean.getData())).concat("'"));
        }

        if (clausula != null && !clausula.equals("")) {
            filtro = filtro.concat(clausula);
        }

        return filtro;

    }
}
