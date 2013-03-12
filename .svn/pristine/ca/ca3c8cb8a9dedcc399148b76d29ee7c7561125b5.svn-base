/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanFormaCondicaoPagamento;
import com.sigen.ecf.persistencia.dao.IDAOFormaCondicaoPagamento;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOFormaCondicaoPagamento extends DAOAbstract implements IDAOFormaCondicaoPagamento {

    @Override
    public void inserir(BeanFormaCondicaoPagamento formaCondicaoPagamentoBean) {

        sql = "INSERT INTO CAD_FORMA_CONDICAO_PAGAMENTO("
                + " COD_COND_PAGAMENTO,"
                + " COD_FORMA_PAGAMENTO"
                + " VALEUS (".concat(UTILBiblioteca.repeteStringDAO("?", 2)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, formaCondicaoPagamentoBean.getCodCondPagto());
            pstm.setString(2, formaCondicaoPagamentoBean.getCodFormaPagto());

            pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanFormaCondicaoPagamento formaCondicaoPagamentoBeanNovo, BeanFormaCondicaoPagamento formaCondicaoPagamentoBeanAntigo) {

        sql = "UPDATE CAD_FORMA_CONDICAO_PAGAMENTO SET"
                + " COD_COND_PAGAMENTO = ?,"
                + " COD_FORMA_PAGAMENTO = ?";

        sql = sql.concat(aplicarFiltro(formaCondicaoPagamentoBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, formaCondicaoPagamentoBeanNovo.getCodCondPagto());
            pstm.setString(2, formaCondicaoPagamentoBeanNovo.getCodFormaPagto());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanFormaCondicaoPagamento> pesquisa(BeanFormaCondicaoPagamento formaCondicaoPagamentoBean) {

        sql = "SELECT"
                + " COD_CONDICAO_PAGAMENTO,"
                + " COD_FORMA_PAGAMENTO"
                + " FROM CAD_FORMA_CONDICAO_PAGAMENTO";

        sql = sql.concat(aplicarFiltro(formaCondicaoPagamentoBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanFormaCondicaoPagamento> listaFormaCondicaoPagamento = new ArrayList<BeanFormaCondicaoPagamento>();

            while (rs.next()) {
                BeanFormaCondicaoPagamento formaCondicaoPagamento = new BeanFormaCondicaoPagamento();

                formaCondicaoPagamento.setCodCondPagto(rs.getString("COD_CONDICAO_PAGAMENTO"));
                formaCondicaoPagamento.setCodFormaPagto(rs.getString("COD_FORMA_PAGAMENTO"));

                listaFormaCondicaoPagamento.add(formaCondicaoPagamento);
            }

            return listaFormaCondicaoPagamento;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanFormaCondicaoPagamento>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanFormaCondicaoPagamento formaCondicaoPagamentoBean) {

        sql = "DELETE FROM CAD_FORMA_CONDICAO_PAGAMENTO";
        sql = sql.concat(aplicarFiltro(formaCondicaoPagamentoBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanFormaCondicaoPagamento formaCondicaoPagamentoBean) {
        String filtro = " WHERE 1 = 1";

        // CODOPER
        if (formaCondicaoPagamentoBean.getCodCondPagto() != null && !formaCondicaoPagamentoBean.getCodCondPagto().equals("")) {
            filtro = filtro.concat(" AND COD_CONDICAO_PAGAMENTO = '".concat(formaCondicaoPagamentoBean.getCodCondPagto()).concat("'"));
        }

        // COD_FORMA_PAGTO
        if (formaCondicaoPagamentoBean.getCodFormaPagto() != null && !formaCondicaoPagamentoBean.getCodFormaPagto().equals("")) {
            filtro = filtro.concat(" AND COD_FORMA_PAGAMENTO = '".concat(formaCondicaoPagamentoBean.getCodFormaPagto()).concat("'"));
        }

        return filtro;
    }
}
