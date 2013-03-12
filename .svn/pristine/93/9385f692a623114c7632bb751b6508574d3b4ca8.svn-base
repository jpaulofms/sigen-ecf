/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.persistencia.dao.IDAOVenda;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOVenda extends DAOAbstract implements IDAOVenda {

    public static String clausula;

    @Override
    public void inserir(BeanVenda vendaBean) {
        sql = "INSERT INTO MOV_VENDA ("
                + " COO,"
                + " LOJA,"
                + " COD_ECF,"
                + " DATA_EMISSAO,"
                + " HORA_EMISSAO,"
                + " DATA_CANCELAMENTO,"
                + " HORA_CANCELAMENTO,"
                + " VALOR_SUB_TOTAL,"
                + " VALOR_DESCONTO,"
                + " VALOR_ACRESCIMO,"
                + " VALOR_TOTAL,"
                + " INDICADOR_CANCELAMENTO,"
                + " NOME_ADQUIRENTE,"
                + " CPF_CNPJ_ADQUIRENTE,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 16)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, vendaBean.getCoo());
            pstm.setString(2, vendaBean.getLoja());
            pstm.setString(3, vendaBean.getCodEcf());
            pstm.setDate(4, new java.sql.Date(vendaBean.getDataEmissao().getTime()));
            pstm.setString(5, vendaBean.getHoraEmissao());
            pstm.setDate(6, vendaBean.getDataCancelamento() != null ? new java.sql.Date(vendaBean.getDataCancelamento().getTime()) : null);
            pstm.setString(7, vendaBean.getHoraCancelamento());
            pstm.setBigDecimal(8, vendaBean.getValorSubTotal());
            pstm.setBigDecimal(9, vendaBean.getValorDesconto());
            pstm.setBigDecimal(10, vendaBean.getValorAcrescimo());
            pstm.setBigDecimal(11, vendaBean.getValorTotal());
            pstm.setString(12, vendaBean.getIndicadorCancelamento());
            pstm.setString(13, vendaBean.getNomeAdquirente());
            pstm.setString(14, vendaBean.getCpfCnpjAdquirente());
            pstm.setString(15, vendaBean.getCodMov());
            pstm.setString(16, vendaBean.getCodOper());

            pstm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanVenda vendaBeanNovo, BeanVenda vendaBeanAntigo) {

        sql = "UPDATE MOV_VENDA SET "
                + " COO = ?,"
                + " LOJA = ?,"
                + " COD_ECF = ?,"
                + " DATA_EMISSAO = ?,"
                + " HORA_EMISSAO = ?,"
                + " DATA_CANCELAMENTO = ?,"
                + " HORA_CANCELAMENTO = ?,"
                + " VALOR_SUB_TOTAL = ?,"
                + " VALOR_DESCONTO = ?,"
                + " VALOR_ACRESCIMO = ?,"
                + " VALOR_TOTAL = ?,"
                + " INDICADOR_CANCELAMENTO = ?,"
                + " NOME_ADQUIRENTE = ?,"
                + " CPF_CNPJ_ADQUIRENTE = ?,"
                + " COD_MOVIMENTO = ?,"
                + " COD_OPERADOR = ?";

        sql = sql.concat(aplicarFiltro(vendaBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, vendaBeanNovo.getCoo());
            pstm.setString(2, vendaBeanNovo.getLoja());
            pstm.setString(3, vendaBeanNovo.getCodEcf());
            pstm.setDate(4, new java.sql.Date(vendaBeanNovo.getDataEmissao().getTime()));
            pstm.setString(5, vendaBeanNovo.getHoraEmissao());
            pstm.setDate(6, vendaBeanNovo.getDataCancelamento() != null ? new java.sql.Date(vendaBeanNovo.getDataCancelamento().getTime()) : null);
            pstm.setString(7, vendaBeanNovo.getHoraCancelamento());
            pstm.setBigDecimal(8, vendaBeanNovo.getValorSubTotal());
            pstm.setBigDecimal(9, vendaBeanNovo.getValorDesconto());
            pstm.setBigDecimal(10, vendaBeanNovo.getValorAcrescimo());
            pstm.setBigDecimal(11, vendaBeanNovo.getValorTotal());
            pstm.setString(12, vendaBeanNovo.getIndicadorCancelamento());
            pstm.setString(13, vendaBeanNovo.getNomeAdquirente());
            pstm.setString(14, vendaBeanNovo.getCpfCnpjAdquirente());
            pstm.setString(15, vendaBeanNovo.getCodMov());
            pstm.setString(16, vendaBeanNovo.getCodOper());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanVenda> pesquisa(BeanVenda vendaBean) {

        sql = "SELECT"
                + " COO,"
                + " LOJA,"
                + " COD_ECF,"
                + " DATA_EMISSAO,"
                + " HORA_EMISSAO,"
                + " DATA_CANCELAMENTO,"
                + " HORA_CANCELAMENTO,"
                + " VALOR_SUB_TOTAL,"
                + " VALOR_DESCONTO,"
                + " VALOR_ACRESCIMO,"
                + " VALOR_TOTAL,"
                + " INDICADOR_CANCELAMENTO,"
                + " NOME_ADQUIRENTE,"
                + " CPF_CNPJ_ADQUIRENTE,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR"
                + " FROM MOV_VENDA";

        sql = sql.concat(aplicarFiltro(vendaBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanVenda> listaVenda = new ArrayList<BeanVenda>();

            while (rs.next()) {

                BeanVenda venda = new BeanVenda();
                venda.setCoo(rs.getString("COO"));
                venda.setLoja(rs.getString("LOJA"));
                venda.setCodEcf(rs.getString("COD_ECF"));
                venda.setDataEmissao(rs.getDate("DATA_EMISSAO"));
                venda.setHoraEmissao(rs.getString("HORA_EMISSAO"));
                venda.setDataCancelamento(rs.getDate("DATA_CANCELAMENTO"));
                venda.setHoraCancelamento(rs.getString("HORA_CANCELAMENTO"));
                venda.setValorSubTotal(rs.getBigDecimal("VALOR_SUB_TOTAL"));
                venda.setValorDesconto(rs.getBigDecimal("VALOR_DESCONTO"));
                venda.setValorAcrescimo(rs.getBigDecimal("VALOR_ACRESCIMO"));
                venda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
                venda.setIndicadorCancelamento(rs.getString("INDICADOR_CANCELAMENTO"));
                venda.setNomeAdquirente(rs.getString("NOME_ADQUIRENTE"));
                venda.setCpfCnpjAdquirente(rs.getString("CPF_CNPJ_ADQUIRENTE"));
                venda.setCodMov(rs.getString("COD_MOVIMENTO"));
                venda.setCodOper(rs.getString("COD_OPERADOR"));

                listaVenda.add(venda);
            }
            return listaVenda;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanVenda>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanVenda vendaBean) {

        sql = "DELETE FROM MOV_VENDA";
        sql = sql.concat(aplicarFiltro(vendaBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanVenda vendaBean) {
        String filtro = " WHERE 1 = 1";


        // COO
        if (vendaBean.getCoo() != null && !vendaBean.getCoo().equals("")) {
            filtro = filtro.concat(" AND COO = '").concat(vendaBean.getCoo()).concat("'");
        }

        // COD_ECF
        if (vendaBean.getCodEcf() != null && !vendaBean.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '").concat(vendaBean.getCodEcf()).concat("'");
        }

        // LOJA
        if (vendaBean.getLoja() != null && !vendaBean.getLoja().equals("")) {
            filtro = filtro.concat(" AND LOJA = '").concat(vendaBean.getLoja()).concat("'");
        }

        // COD_MOV
        if (vendaBean.getCodMov() != null && !vendaBean.getCodMov().equals("")) {
            filtro = filtro.concat(" AND COD_MOVIMENTO = '").concat(vendaBean.getCodMov()).concat("'");
        }

        // INDICADOR_CANCELAMENTO
        if (vendaBean.getIndicadorCancelamento() != null && !vendaBean.getIndicadorCancelamento().equals("")) {
            filtro = filtro.concat(" AND INDICADOR_CANCELAMENTO = '").concat(vendaBean.getIndicadorCancelamento()).concat("'");
        }

        // NOME_ADQUIRENTE
        if (vendaBean.getNomeAdquirente() != null && !vendaBean.getNomeAdquirente().equals("")) {
            filtro = filtro.concat(" AND NOME_ADQUIRENTE LIKE '").concat(vendaBean.getNomeAdquirente()).concat("%'");
        }

        // CPF_CNPJ_ADQUIRENTE
        if (vendaBean.getCpfCnpjAdquirente() != null && !vendaBean.getCpfCnpjAdquirente().equals("")) {
            filtro = filtro.concat(" AND CPF_CNPJ_ADQUIRENTE = '").concat(vendaBean.getCpfCnpjAdquirente()).concat("'");
        }

        // DATA_EMISSAO
        if (vendaBean.getDataEmissao() != null) {
            filtro = filtro.concat(" AND DATA_EMISSAO = '").concat(sdf.format(vendaBean.getDataEmissao())).concat("'");
        }

        // DATA_CANCELAMENTO
        if (vendaBean.getDataCancelamento() != null) {
            filtro = filtro.concat(" AND DATA_CANCELAMENTO = '").concat(sdf.format(vendaBean.getDataCancelamento())).concat("'");
        }

        if (clausula != null && !clausula.equals("")) {
            filtro = filtro.concat(clausula);
            clausula = "";
        }

        return filtro;
    }
}
