/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanConveniada;
import com.sigen.ecf.persistencia.dao.IDAOConveniada;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOConveniada extends DAOAbstract implements IDAOConveniada {

    @Override
    public void inserir(BeanConveniada conveniadaBean) {

        sql = "INSERT INTO CAD_CONVENIADA("
                + " COD_CONVENIADA,"
                + " TAXA_ADM,"
                + " DESCRICAO)"
                + " VALEUS (".concat(UTILBiblioteca.repeteStringDAO("?", 3)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, conveniadaBean.getCodConveniada());
            pstm.setBigDecimal(2, conveniadaBean.getTaxaAdm());
            pstm.setString(3, conveniadaBean.getDescricao());

            pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanConveniada conveniadaBeanNovo, BeanConveniada conveniadaBeanAntigo) {

        sql = "UPDATE CAD_CONVENIADA SET"
                + " COD_CONVENIADA = ?,"
                + " TAXA_ADM = ?,"
                + " DESCRICAO = ?";

        sql = sql.concat(aplicarFiltro(conveniadaBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, conveniadaBeanNovo.getCodConveniada());
            pstm.setBigDecimal(2, conveniadaBeanNovo.getTaxaAdm());
            pstm.setString(3, conveniadaBeanNovo.getDescricao());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanConveniada> pesquisa(BeanConveniada conveniadaBean) {

        sql = "SELECT"
                + " COD_CONVENIADA,"
                + " TAXA_ADM,"
                + " DESCRICAO"
                + " FROM CAD_CONVENIADA";

        sql = sql.concat(aplicarFiltro(conveniadaBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanConveniada> listaConveniada = new ArrayList<BeanConveniada>();

            while (rs.next()) {
                BeanConveniada conveniada = new BeanConveniada();

                conveniada.setCodConveniada(rs.getString("COD_CONVENIADA"));
                conveniada.setTaxaAdm(rs.getBigDecimal("TAXA_ADM"));
                conveniada.setDescricao(rs.getString("DESCRICAO"));

                listaConveniada.add(conveniada);
            }

            return listaConveniada;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanConveniada>();
        } finally {
            bd.desconectar();
        }

    }

    @Override
    public List<BeanConveniada> pesquisaConveniadaFormaPagamento(String codFormaPagamento) {

        sql = "SELECT"
                + " C.COD_CONVENIADA,"
                + " C.DESCRICAO,"
                + " FPC.TAXA_ADM"
                + " FROM CAD_CONVENIADA C JOIN CAD_FORMA_PAGAMENTO_CONVENIADA FPC ON (C.COD_CONVENIADA = FPC.COD_CONVENIADA)"
                + " WHERE FPC.COD_FORMA_PAGAMENTO = '".concat(codFormaPagamento).concat("'");

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanConveniada> listaConveniada = new ArrayList<BeanConveniada>();

            while (rs.next()) {
                BeanConveniada conveniada = new BeanConveniada();

                conveniada.setCodConveniada(rs.getString("COD_CONVENIADA"));
                conveniada.setTaxaAdm(rs.getBigDecimal("TAXA_ADM"));
                conveniada.setDescricao(rs.getString("DESCRICAO"));

                listaConveniada.add(conveniada);
            }

            return listaConveniada;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanConveniada>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanConveniada conveniadaBean) {

        sql = "DELETE FROM CAD_CONVENIADA";
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

    private String aplicarFiltro(BeanConveniada conveniadaBean) {
        String filtro = " WHERE 1 = 1";

        // CODOPER
        if (conveniadaBean.getCodConveniada() != null && !conveniadaBean.getCodConveniada().equals("")) {
            filtro = filtro.concat(" AND COD_CONVENIADA = '".concat(conveniadaBean.getCodConveniada()).concat("'"));
        }

        // DESCRICAO
        if (conveniadaBean.getDescricao() != null && !conveniadaBean.getDescricao().equals("")) {
            filtro = filtro.concat(" AND DESCRICAO = '".concat(conveniadaBean.getDescricao()).concat("'"));
        }

        return filtro;
    }
}
