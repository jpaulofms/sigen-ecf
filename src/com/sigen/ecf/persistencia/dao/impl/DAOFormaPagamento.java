/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanFormaPagamento;
import com.sigen.ecf.persistencia.dao.IDAOFormaPagamento;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOFormaPagamento extends DAOAbstract implements IDAOFormaPagamento {

    @Override
    public void inserir(BeanFormaPagamento formaPagamentoBean) {

        sql = "INSERT INTO CAD_FORMA_PAGAMENTO ("
                + " COD_FORMA_PAGTO,"
                + " DESCRICAO,"
                + " TIPO,"
                + " PAGAMENTO_A_VISTA,"
                + " PAGAMENTO_A_PRAZO)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 5)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, formaPagamentoBean.getCodFormaPagto());
            pstm.setString(2, formaPagamentoBean.getDescricao());
            pstm.setString(3, formaPagamentoBean.getTipo());
            pstm.setBoolean(4, formaPagamentoBean.isPagamentoAVista());
            pstm.setBoolean(5, formaPagamentoBean.isPagamentoAPrazo());

            pstm.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanFormaPagamento formaPagamentoBeanNovo, BeanFormaPagamento formaPagamentoBeanAntigo) {

        sql = "UPDATE CAD_FORMA_PAGAMENTO SET"
                + " COD_FORMA_PAGTO = ?,"
                + " DESCRICAO = ?,"
                + " TIPO = ?,"
                + " PAGAMENTO_A_VISTA = ?,"
                + " PAGAMENTO_A_PRAZO = ?";

        sql = sql.concat(aplicarFiltro(formaPagamentoBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, formaPagamentoBeanNovo.getCodFormaPagto());
            pstm.setString(2, formaPagamentoBeanNovo.getDescricao());
            pstm.setString(3, formaPagamentoBeanNovo.getTipo());
            pstm.setBoolean(4, formaPagamentoBeanNovo.isPagamentoAVista());
            pstm.setBoolean(5, formaPagamentoBeanNovo.isPagamentoAPrazo());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanFormaPagamento> pesquisa(BeanFormaPagamento formaPagamentoBean) {

        sql = "SELECT"
                + " COD_FORMA_PAGAMENTO,"
                + " DESCRICAO,"
                + " TIPO,"
                + " PAGAMENTO_A_VISTA,"
                + " PAGAMENTO_A_PRAZO"
                + " FROM CAD_FORMA_PAGAMENTO";

        sql = sql.concat(aplicarFiltro(formaPagamentoBean));

        try {

            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanFormaPagamento> listaFormaPagamentoBean = new ArrayList<BeanFormaPagamento>();

            while (rs.next()) {
                BeanFormaPagamento formaPagamento = new BeanFormaPagamento();

                formaPagamento.setCodFormaPagto(rs.getString("COD_FORMA_PAGAMENTO"));
                formaPagamento.setDescricao(rs.getString("DESCRICAO"));
                formaPagamento.setTipo(rs.getString("TIPO"));
                formaPagamento.setPagamentoAVista(rs.getBoolean("PAGAMENTO_A_VISTA"));
                formaPagamento.setPagamentoAPrazo(rs.getBoolean("PAGAMENTO_A_PRAZO"));

                listaFormaPagamentoBean.add(formaPagamento);
            }

            return listaFormaPagamentoBean;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanFormaPagamento> pesquisaFormaCondicaoPagamento(String codCondPagto) {

        sql = "SELECT"
                + " FP.COD_FORMA_PAGAMENTO,"
                + " FP.DESCRICAO,"
                + " FP.TIPO,"
                + " FP.PAGAMENTO_A_VISTA,"
                + " FP.PAGAMENTO_A_PRAZO"
                + " FROM CAD_FORMA_PAGAMENTO FP JOIN CAD_FORMA_CONDICAO_PAGAMENTO FCP ON ( FP.COD_FORMA_PAGAMENTO = FCP.COD_FORMA_PAGAMENTO )"
                + " WHERE FCP.COD_CONDICAO_PAGAMENTO = '".concat(codCondPagto).concat("'");

        try {

            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanFormaPagamento> listaFormaPagamentoBean = new ArrayList<BeanFormaPagamento>();

            while (rs.next()) {
                BeanFormaPagamento formaPagamento = new BeanFormaPagamento();

                formaPagamento.setCodFormaPagto(rs.getString("COD_FORMA_PAGAMENTO"));
                formaPagamento.setDescricao(rs.getString("DESCRICAO"));
                formaPagamento.setTipo(rs.getString("TIPO"));
                formaPagamento.setPagamentoAVista(rs.getBoolean("PAGAMENTO_A_VISTA"));
                formaPagamento.setPagamentoAPrazo(rs.getBoolean("PAGAMENTO_A_PRAZO"));

                listaFormaPagamentoBean.add(formaPagamento);
            }

            return listaFormaPagamentoBean;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanFormaPagamento>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanFormaPagamento formaPagamentoBean) {

        sql = "DELETE FROM CAD_FORMA_PAGAMENTO";

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

    private String aplicarFiltro(BeanFormaPagamento formaPagamentoBean) {
        String filtro = " WHERE 1 = 1";

        // FORMA DE PAGAMENTO
        if (formaPagamentoBean.getCodFormaPagto() != null && !formaPagamentoBean.getCodFormaPagto().equals("")) {
            filtro = filtro.concat(" AND COD_FORMA_PAGTO = ".concat(formaPagamentoBean.getCodFormaPagto()));
        }

        // DESCRICAO
        if (formaPagamentoBean.getDescricao() != null && !formaPagamentoBean.getDescricao().equals("")) {
            filtro = filtro.concat(" AND DESCRICAO LIKE '".concat(formaPagamentoBean.getDescricao()).concat("%'"));
        }
        
        // TIPO
        if(formaPagamentoBean.getTipo() != null && !formaPagamentoBean.getTipo().trim().equals("")){
            filtro = filtro.concat(" AND TIPO = '").concat(formaPagamentoBean.getTipo()).concat("'");
        }

        return filtro;
    }
}
