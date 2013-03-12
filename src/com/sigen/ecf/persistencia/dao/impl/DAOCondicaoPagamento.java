/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanCondicaoPagamento;
import com.sigen.ecf.persistencia.dao.IDAOCondicaoPagamento;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOCondicaoPagamento extends DAOAbstract implements IDAOCondicaoPagamento {

    @Override
    public void inserir(BeanCondicaoPagamento formaPagamentoBean) {

        sql = "INSERT INTO CAD_CONDICAO_PAGAMENTO ("
                + " COD_COND_PAGTO,"
                + " DESCRICAO,"
                + " PARCELA_MAX,"
                + " DIAS_ENTRE_PARCELAS,"
                + " EXIGE_ENTRADA)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 5)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, formaPagamentoBean.getCodCondPagto());
            pstm.setString(2, formaPagamentoBean.getDescricao());
            pstm.setInt(3, formaPagamentoBean.getParcelaMax());
            pstm.setInt(4, formaPagamentoBean.getDiasEntreParcelas());
            pstm.setBoolean(5, formaPagamentoBean.isExigeEntrada());

            pstm.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanCondicaoPagamento formaPagamentoBeanNovo, BeanCondicaoPagamento formaPagamentoBeanAntigo) {

        sql = "UPDATE CAD_CONDICAO_PAGAMENTO SET"
                + " COD_COND_PAGTO = ?,"
                + " DESCRICAO = ?,"
                + " PARCELA_MAX = ?,"
                + " DIAS_ENTRE_PARCELAS = ?,"
                + " EXIGE_ENTRADA = ?";

        sql = sql.concat(aplicarFiltro(formaPagamentoBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, formaPagamentoBeanNovo.getCodCondPagto());
            pstm.setString(2, formaPagamentoBeanNovo.getDescricao());
            pstm.setInt(3, formaPagamentoBeanNovo.getParcelaMax());
            pstm.setInt(4, formaPagamentoBeanNovo.getDiasEntreParcelas());
            pstm.setBoolean(5, formaPagamentoBeanNovo.isExigeEntrada());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanCondicaoPagamento> pesquisa(BeanCondicaoPagamento formaPagamentoBean) {

        sql = "SELECT"
                + " COD_CONDICAO_PAGAMENTO,"
                + " DESCRICAO,"
                + " PARCELA_MAX,"
                + " DIAS_ENTRE_PARCELAS,"
                + " EXIGE_ENTRADA"
                + " FROM CAD_CONDICAO_PAGAMENTO";

        sql = sql.concat(aplicarFiltro(formaPagamentoBean));

        try {

            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanCondicaoPagamento> listaCondicaoPagamentoBean = new ArrayList<BeanCondicaoPagamento>();

            while (rs.next()) {
                BeanCondicaoPagamento formaPagamento = new BeanCondicaoPagamento();

                formaPagamento.setCodCondPagto(rs.getString("COD_CONDICAO_PAGAMENTO"));
                formaPagamento.setDescricao(rs.getString("DESCRICAO"));
                formaPagamento.setParcelaMax(rs.getInt("PARCELA_MAX"));
                formaPagamento.setDiasEntreParcelas(rs.getInt("DIAS_ENTRE_PARCELAS"));
                formaPagamento.setExigeEntrada(rs.getBoolean("EXIGE_ENTRADA"));

                listaCondicaoPagamentoBean.add(formaPagamento);
            }

            return listaCondicaoPagamentoBean;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanCondicaoPagamento>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanCondicaoPagamento formaPagamentoBean) {

        sql = "DELETE FROM CAD_CONDICAO_PAGAMENTO";

        sql = sql.concat(aplicarFiltro(formaPagamentoBean));

        try {

            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanCondicaoPagamento formaPagamentoBean) {
        String filtro = " WHERE 1 = 1";

        // CONDPGTO
        if (formaPagamentoBean.getCodCondPagto() != null && !formaPagamentoBean.getCodCondPagto().equals("")) {
            filtro = filtro.concat(" AND COD_COND_PAGTO = ".concat(formaPagamentoBean.getCodCondPagto()));
        }

        // DESCRICAO
        if (formaPagamentoBean.getDescricao() != null && !formaPagamentoBean.getDescricao().equals("")) {
            filtro = filtro.concat(" AND DESCRICAO LIKE '".concat(formaPagamentoBean.getDescricao()).concat("%'"));
        }

        return filtro;
    }
}
