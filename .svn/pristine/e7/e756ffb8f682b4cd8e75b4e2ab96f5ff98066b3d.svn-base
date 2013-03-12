/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.persistencia.dao.IDAOMovimento;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOMovimento extends DAOAbstract implements IDAOMovimento {

    public static String clausula = "";

    @Override
    public void inserir(BeanMovimento movimentoBean) {

        sql = "INSERT INTO MOV_MOVIMENTO ("
                + " COO,"
                + " GNF,"
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " DATA_ABERTURA,"
                + " HORA_ABERTURA,"
                + " DATA_FECHAMENTO,"
                + " HORA_FECHAMENTO,"
                + " COD_SUPERVISOR,"
                + " SALDO_DINHEIRO_ABERTURA,"
                + " SALDO_DINHEIRO_FECHAMENTO)"
                + " VALUES(".concat(UTILBiblioteca.repeteStringDAO("?", 13)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, movimentoBean.getCoo());
            pstm.setString(2, movimentoBean.getGnf());
            pstm.setString(3, movimentoBean.getLoja());
            pstm.setString(4, movimentoBean.getCodEcf());
            pstm.setString(5, movimentoBean.getCodMov());
            pstm.setString(6, movimentoBean.getCodOper());
            pstm.setDate(7, new java.sql.Date(movimentoBean.getDataAbertura().getTime()));
            pstm.setString(8, movimentoBean.getHoraAbertura());
            pstm.setDate(9, movimentoBean.getDataFechamento() != null ? new java.sql.Date(movimentoBean.getDataFechamento().getTime()) : null);
            pstm.setString(10, movimentoBean.getHoraFechamento());
            pstm.setString(11, movimentoBean.getCodSupervisor());
            pstm.setBigDecimal(12, movimentoBean.getSaldoDinheiroAbertura());
            pstm.setBigDecimal(13, movimentoBean.getSaldoDinheiroFechamento());

            pstm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanMovimento movimentoBeanNovo, BeanMovimento movimentoBeanAntigo) {

        sql = "UPDATE MOV_MOVIMENTO SET "
                + " COO = ?,"
                + " GNF = ?,"
                + " LOJA = ?,"
                + " COD_ECF = ?,"
                + " COD_MOVIMENTO = ?,"
                + " COD_OPERADOR = ?,"
                + " DATA_ABERTURA = ?,"
                + " HORA_ABERTURA = ?,"
                + " DATA_FECHAMENTO = ?,"
                + " HORA_FECHAMENTO = ?,"
                + " COD_SUPERVISOR = ?,"
                + " SALDO_DINHEIRO_ABERTURA = ?,"
                + " SALDO_DINHEIRO_FECHAMENTO = ?";


        sql = sql.concat(aplicarFiltro(movimentoBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, movimentoBeanNovo.getCoo());
            pstm.setString(2, movimentoBeanNovo.getGnf());
            pstm.setString(3, movimentoBeanNovo.getLoja());
            pstm.setString(4, movimentoBeanNovo.getCodEcf());
            pstm.setString(5, movimentoBeanNovo.getCodMov());
            pstm.setString(6, movimentoBeanNovo.getCodOper());
            pstm.setDate(7, new java.sql.Date(movimentoBeanNovo.getDataAbertura().getTime()));
            pstm.setString(8, movimentoBeanNovo.getHoraAbertura());
            pstm.setDate(9, new java.sql.Date(movimentoBeanNovo.getDataFechamento().getTime()));
            pstm.setString(10, movimentoBeanNovo.getHoraFechamento());
            pstm.setString(11, movimentoBeanNovo.getCodSupervisor());
            pstm.setBigDecimal(12, movimentoBeanNovo.getSaldoDinheiroAbertura());
            pstm.setBigDecimal(13, movimentoBeanNovo.getSaldoDinheiroFechamento());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanMovimento> pesquisa(BeanMovimento movimentoBean) {

        sql = "SELECT"
                + " COO,"
                + " GNF,"
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " DATA_ABERTURA,"
                + " HORA_ABERTURA,"
                + " DATA_FECHAMENTO,"
                + " HORA_FECHAMENTO,"
                + " COD_SUPERVISOR,"
                + " SALDO_DINHEIRO_ABERTURA,"
                + " SALDO_DINHEIRO_FECHAMENTO"
                + " FROM MOV_MOVIMENTO";

        sql = sql.concat(aplicarFiltro(movimentoBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanMovimento> listaMovimento = new ArrayList<BeanMovimento>();

            while (rs.next()) {
                BeanMovimento movimento = new BeanMovimento();

                movimento.setCoo(rs.getString("COO"));
                movimento.setGnf(rs.getString("GNF"));
                movimento.setLoja(rs.getString("LOJA"));
                movimento.setCodEcf(rs.getString("COD_ECF"));
                movimento.setCodMov(rs.getString("COD_MOVIMENTO"));
                movimento.setCodOper(rs.getString("COD_OPERADOR"));
                movimento.setDataAbertura(rs.getDate("DATA_ABERTURA"));
                movimento.setHoraAbertura(rs.getString("HORA_ABERTURA"));
                if (rs.getDate("DATA_FECHAMENTO") != null) {
                    movimento.setDataFechamento(rs.getDate("DATA_FECHAMENTO"));
                    movimento.setHoraFechamento(rs.getString("HORA_FECHAMENTO"));
                }
                movimento.setCodSup(rs.getString("COD_SUPERVISOR"));
                movimento.setSaldoDinheiroAbertura(rs.getBigDecimal("SALDO_DINHEIRO_ABERTURA"));
                movimento.setSaldoDinheiroFechamento(rs.getBigDecimal("SALDO_DINHEIRO_FECHAMENTO"));

                listaMovimento.add(movimento);
            }

            return listaMovimento;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanMovimento movimentoBean) {

        sql = "DELETE FROM MOV_MOVIMENTO";
        sql = sql.concat(aplicarFiltro(movimentoBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanMovimento movimentoBean) {

        String filtro = " WHERE 1 = 1";

        // LOJA
        if (movimentoBean.getLoja() != null && !movimentoBean.getLoja().equals("")) {
            filtro = filtro.concat(" AND LOJA = '".concat(movimentoBean.getLoja()).concat("'"));
        }

        // COO
        if (movimentoBean.getCoo() != null && !movimentoBean.getCoo().equals("")) {
            filtro = filtro.concat(" AND COO = '".concat(movimentoBean.getCoo()).concat("'"));
        }

        // GNF
        if (movimentoBean.getGnf() != null && !movimentoBean.getGnf().equals("")) {
            filtro = filtro.concat(" AND GNF = '".concat(movimentoBean.getGnf()).concat("'"));
        }

        // COD_ECF
        if (movimentoBean.getCodEcf() != null && !movimentoBean.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '".concat(movimentoBean.getCodEcf()).concat("'"));
        }

        // COD_MOVIMENTO
        if (movimentoBean.getCodMov() != null && !movimentoBean.getCodMov().equals("")) {
            filtro = filtro.concat(" AND COD_MOVIMENTO = '".concat(movimentoBean.getCodMov()).concat("'"));
        }

        // CODOPER
        if (movimentoBean.getCodOper() != null && !movimentoBean.getCodOper().equals("")) {
            filtro = filtro.concat(" AND COD_OPERADOR = '".concat(movimentoBean.getCodOper()).concat("'"));
        }

        // DATA ABERTURA
        if (movimentoBean.getDataAbertura() != null) {
            filtro = filtro.concat(" AND DATA_ABERTURA = '".concat(sdf.format(movimentoBean.getDataAbertura())).concat("'"));
        }

        if (clausula != null && !clausula.equals("")) {
            filtro = filtro.concat(" " + clausula);
            clausula = "";
        }

        return filtro;
    }
}
