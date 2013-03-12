/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanDevolucao;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAODevolucao extends DAOAbstract {

    public static String clausula = "";

    public void inserir(BeanDevolucao beanDevolucao) {

        sql = "INSERT INTO MOV_DEVOLUCAO("
                + " NOME_CLIENTE,"
                + " CPF_CNPJ,"
                + " COO_DEVOLUCAO,"
                + " DATA_DEVOLUCAO,"
                + " HORA,"
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOV,"
                + " VALOR_CREDITO,"
                + " ENDERECO,"
                + " CEP,"
                + " NUMERO,"
                + " COMPLEMENTO,"
                + " BAIRRO,"
                + " ESTADO,"
                + " CIDADE,"
                + " DEVOLUCAO_UTILIZADA)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 17)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, beanDevolucao.getNome());
            pstm.setString(2, beanDevolucao.getCpfCnpj());
            pstm.setString(3, beanDevolucao.getCoo());
            pstm.setDate(4, new java.sql.Date(beanDevolucao.getDataDevolucao().getTime()));
            pstm.setString(5, beanDevolucao.getHoraDevolucao());
            pstm.setString(6, beanDevolucao.getLoja());
            pstm.setString(7, beanDevolucao.getCodEcf());
            pstm.setString(8, beanDevolucao.getCodMov());
            pstm.setBigDecimal(9, beanDevolucao.getValorCredito());
            pstm.setString(10, beanDevolucao.getEndereco());
            pstm.setString(11, beanDevolucao.getCep());
            pstm.setString(12, beanDevolucao.getNumero());
            pstm.setString(13, beanDevolucao.getComplemento());
            pstm.setString(14, beanDevolucao.getBairro());
            pstm.setString(15, beanDevolucao.getEstado());
            pstm.setString(16, beanDevolucao.getCidade());
            pstm.setBoolean(17, beanDevolucao.isDevolucaoUtilizada());

            pstm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public void atualizar(BeanDevolucao devolucaoNovo, BeanDevolucao devolucaoAntigo) {

        sql = "UPDATE MOV_DEVOLUCAO SET"
                + " NOME_CLIENTE = ?,"
                + " CPF_CNPJ = ?,"
                + " COO_DEVOLUCAO = ?,"
                + " DATA_DEVOLUCAO = ?,"
                + " HORA = ?,"
                + " LOJA = ?,"
                + " COD_ECF = ?,"
                + " COD_MOV = ?,"
                + " VALOR_CREDITO = ?,"
                + " ENDERECO = ?,"
                + " CEP = ?,"
                + " NUMERO = ?,"
                + " COMPLEMENTO = ?,"
                + " BAIRRO = ?,"
                + " ESTADO = ?,"
                + " CIDADE = ?";

        sql = sql.concat(aplicarFiltro(devolucaoAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);
            pstm.setString(1, devolucaoNovo.getNome());
            pstm.setString(2, devolucaoNovo.getCpfCnpj());
            pstm.setString(3, devolucaoNovo.getCoo());
            pstm.setDate(4, new java.sql.Date(devolucaoNovo.getDataDevolucao().getTime()));
            pstm.setString(5, devolucaoNovo.getHoraDevolucao());
            pstm.setString(6, devolucaoNovo.getLoja());
            pstm.setString(7, devolucaoNovo.getCodEcf());
            pstm.setString(8, devolucaoNovo.getCodMov());
            pstm.setBigDecimal(9, devolucaoNovo.getValorCredito());
            pstm.setString(10, devolucaoNovo.getEndereco());
            pstm.setString(11, devolucaoNovo.getCep());
            pstm.setString(12, devolucaoNovo.getNumero());
            pstm.setString(13, devolucaoNovo.getComplemento());
            pstm.setString(14, devolucaoNovo.getBairro());
            pstm.setString(15, devolucaoNovo.getEstado());
            pstm.setString(16, devolucaoNovo.getCidade());
            pstm.setBoolean(17, devolucaoNovo.isDevolucaoUtilizada());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public void atualizarDevolucaoUtilizada(BeanDevolucao devolucao, boolean utilizada) {

        sql = "UPDATE MOV_DEVOLUCAO SET"
                + " DEVOLUCAO_UTILIZADA = ?";

        sql = sql.concat(aplicarFiltro(devolucao));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setBoolean(1, utilizada);

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public List<BeanDevolucao> pesquisa(BeanDevolucao conveniadaBean) {

        sql = "SELECT"
                + " NOME_CLIENTE,"
                + " CPF_CNPJ,"
                + " COO_DEVOLUCAO,"
                + " DATA_DEVOLUCAO,"
                + " HORA,"
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOV,"
                + " VALOR_CREDITO,"
                + " ENDERECO,"
                + " CEP,"
                + " NUMERO,"
                + " COMPLEMENTO,"
                + " BAIRRO,"
                + " ESTADO,"
                + " CIDADE,"
                + " DEVOLUCAO_UTILIZADA"
                + " FROM MOV_DEVOLUCAO";

        sql = sql.concat(aplicarFiltro(conveniadaBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanDevolucao> listaDevolucao = new ArrayList<BeanDevolucao>();

            while (rs.next()) {
                BeanDevolucao devolucao = new BeanDevolucao();

                devolucao.setNome(rs.getString("NOME_CLIENTE"));
                devolucao.setCpfCnpj(rs.getString("CPF_CNPJ"));
                devolucao.setCoo(rs.getString("COO_DEVOLUCAO"));
                devolucao.setDataDevolucao(rs.getDate("DATA_DEVOLUCAO"));
                devolucao.setHoraDevolucao(rs.getString("HORA"));
                devolucao.setLoja(rs.getString("LOJA"));
                devolucao.setCodEcf(rs.getString("COD_ECF"));
                devolucao.setCodMov(rs.getString("COD_MOV"));
                devolucao.setValorCredito(rs.getBigDecimal("VALOR_CREDITO"));
                devolucao.setEndereco(rs.getString("ENDERECO"));
                devolucao.setCep(rs.getString("CEP"));
                devolucao.setNumero(rs.getString("NUMERO"));
                devolucao.setComplemento(rs.getString("COMPLEMENTO"));
                devolucao.setBairro(rs.getString("BAIRRO"));
                devolucao.setEstado(rs.getString("ESTADO"));
                devolucao.setCidade(rs.getString("CIDADE"));
                devolucao.setDevolucaoUtilizada(rs.getBoolean("DEVOLUCAO_UTILIZADA"));

                listaDevolucao.add(devolucao);
            }

            return listaDevolucao;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanDevolucao>();
        } finally {
            bd.desconectar();
        }

    }

    public void remover(BeanDevolucao conveniadaBean) {

        sql = "DELETE FROM MOV_DEVOLUCAO";
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

    private String aplicarFiltro(BeanDevolucao devolucao) {
        String filtro = " WHERE 1 = 1";

        // LOJA
        if (devolucao.getLoja() != null && !devolucao.getLoja().equals("")) {
            filtro = filtro.concat(" AND LOJA = '".concat(devolucao.getLoja()).concat("'"));
        }

        // COD_ECF
        if (devolucao.getCodEcf() != null && !devolucao.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '".concat(devolucao.getCodEcf()).concat("'"));
        }

        // COD_MOV
        if (devolucao.getCodMov() != null && !devolucao.getCodMov().equals("")) {
            filtro = filtro.concat(" AND COD_MOV = '".concat(devolucao.getCodMov()).concat("'"));
        }

        // COO
        if (devolucao.getCoo() != null && !devolucao.getCoo().equals("")) {
            filtro = filtro.concat(" AND COO_DEVOLUCAO = '".concat(devolucao.getCoo()).concat("'"));
        }

        // CPF_CNPJ
        if (devolucao.getCpfCnpj() != null && !devolucao.getCpfCnpj().equals("")) {
            filtro = filtro.concat(" AND CPF_CNPJ = '".concat(devolucao.getCpfCnpj()).concat("'"));
        }

        // DEVOLUCAO_UTILIZADA        
        filtro = filtro.concat(" AND DEVOLUCAO_UTILIZADA = '" + devolucao.isDevolucaoUtilizada() + "'");

        if (clausula != null && !clausula.equals("")) {
            filtro = filtro.concat(clausula);
        }

        return filtro;
    }
}
