/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanSangria;
import com.sigen.ecf.persistencia.dao.IDAOSangria;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOSangria extends DAOAbstract implements IDAOSangria {

    public static String clausula = "";

    @Override
    public void inserir(BeanSangria sangriaBean) {

        sql = "INSERT INTO MOV_SANGRIA("
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " COO,"
                + " GNF,"
                + " DATA,"
                + " HORA,"
                + " COD_FORMA_PAGAMENTO,"
                + " TIPO_FORMA_PAGAMENTO,"
                + " VALOR,"
                + " OBSERVACAO)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 12)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, sangriaBean.getLoja());
            pstm.setString(2, sangriaBean.getCodEcf());
            pstm.setString(3, sangriaBean.getCodMov());
            pstm.setString(4, sangriaBean.getCodOper());
            pstm.setString(5, sangriaBean.getCoo());
            pstm.setString(6, sangriaBean.getGnf());
            pstm.setDate(7, new java.sql.Date(sangriaBean.getData().getTime()));
            pstm.setString(8, sangriaBean.getHora());
            pstm.setString(9, sangriaBean.getCodFormaPagamento());
            pstm.setString(10, sangriaBean.getTipoFormaPagamento());
            pstm.setBigDecimal(11, sangriaBean.getValorSangria());
            pstm.setString(12, sangriaBean.getObservacao());

            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanSangria sangriaBeanNovo, BeanSangria sangriaBeanAntigo) {

        sql = "UPDATE MOV_SANGRIA SET"
                + " LOJA = ?,"
                + " COD_ECF = ?,"
                + " COD_MOVIMENTO = ?,"
                + " COD_OPERADOR = ?,"
                + " COO = ?,"
                + " GNF = ?,"
                + " DATA = ?,"
                + " HORA = ?,"
                + " COD_FORMA_PAGAMENTO = ?,"
                + " TIPO_FORMA_PAGAMENTO = ?,"
                + " VALOR = ?,"
                + " OBSERVACAO = ? ";

        sql = sql.concat(aplicarFiltro(sangriaBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, sangriaBeanNovo.getLoja());
            pstm.setString(2, sangriaBeanNovo.getCodEcf());
            pstm.setString(3, sangriaBeanNovo.getCodMov());
            pstm.setString(4, sangriaBeanNovo.getCodOper());
            pstm.setString(5, sangriaBeanNovo.getCoo());
            pstm.setString(6, sangriaBeanNovo.getGnf());
            pstm.setDate(7, new java.sql.Date(sangriaBeanNovo.getData().getTime()));
            pstm.setString(8, sangriaBeanNovo.getHora());
            pstm.setString(9, sangriaBeanNovo.getCodFormaPagamento());
            pstm.setString(10, sangriaBeanNovo.getTipoFormaPagamento());
            pstm.setBigDecimal(11, sangriaBeanNovo.getValorSangria());
            pstm.setString(12, sangriaBeanNovo.getObservacao());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanSangria> pesquisa(BeanSangria sangriaBean) {

        sql = "SELECT"
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " COO,"
                + " GNF,"
                + " DATA,"
                + " HORA,"
                + " COD_FORMA_PAGAMENTO,"
                + " TIPO_FORMA_PAGAMENTO,"
                + " SUM(VALOR) AS VALOR,"
                + " OBSERVACAO"
                + " FROM MOV_SANGRIA";

        sql = sql.concat(aplicarFiltro(sangriaBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanSangria> listaSangria = new ArrayList<BeanSangria>();

            while (rs.next()) {
                BeanSangria sangria = new BeanSangria();

                sangria.setLoja(rs.getString("LOJA"));
                sangria.setCodEcf(rs.getString("COD_ECF"));
                sangria.setCodMov(rs.getString("COD_MOVIMENTO"));
                sangria.setCodOper(rs.getString("COD_OPERADOR"));
                sangria.setCoo(rs.getString("COO"));
                sangria.setGnf(rs.getString("GNF"));
                sangria.setData(rs.getDate("DATA"));
                sangria.setHora(rs.getString("HORA"));
                sangria.setCodFormaPagamento(rs.getString("COD_FORMA_PAGAMENTO"));
                sangria.setValorSangria(rs.getBigDecimal("VALOR"));
                sangria.setTipoFormaPagamento(rs.getString("TIPO_FORMA_PAGAMENTO"));
                sangria.setObservacao(rs.getString("OBSERVACAO"));

                listaSangria.add(sangria);
            }
            return listaSangria;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanSangria>();
        }
    }

    public List<BeanSangria> pesquisaPorTipo(BeanSangria sangriaBean) {

        sql = "SELECT"
                + " COD_FORMA_PAGAMENTO,"
                + " TIPO_FORMA_PAGAMENTO,"
                + " SUM(VALOR) AS VALOR"
                + " FROM MOV_SANGRIA";

        sql = sql.concat(aplicarFiltro(sangriaBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanSangria> listaSangria = new ArrayList<BeanSangria>();

            while (rs.next()) {
                BeanSangria sangria = new BeanSangria();
                sangria.setCodFormaPagamento(rs.getString("COD_FORMA_PAGAMENTO"));
                sangria.setValorSangria(rs.getBigDecimal("VALOR"));
                sangria.setTipoFormaPagamento(rs.getString("TIPO_FORMA_PAGAMENTO"));

                listaSangria.add(sangria);
            }
            return listaSangria;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void remover(BeanSangria sangriaBean) {

        sql = "DELETE FROM MOV_SANGRIA";
        sql = sql.concat(aplicarFiltro(sangriaBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanSangria sangriaBean) {

        String filtro = " WHERE 1 = 1";

        // LOJA
        if (sangriaBean.getLoja() != null && !sangriaBean.getLoja().equals("")) {
            filtro = filtro.concat(" AND LOJA = '".concat(sangriaBean.getLoja())).concat("'");
        }

        // COD_ECF
        if (sangriaBean.getCodEcf() != null && !sangriaBean.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '".concat(sangriaBean.getCodEcf()).concat("'"));
        }

        // COD_MOVIMENTO
        if (sangriaBean.getCodMov() != null && !sangriaBean.getCodMov().equals("")) {
            filtro = filtro.concat(" AND COD_MOVIMENTO = '".concat(sangriaBean.getCodMov()).concat("'"));
        }

        // DATA
        if (sangriaBean.getData() != null) {
            filtro = filtro.concat(" AND DATA_SANGRIA = '".concat(sdf.format(sangriaBean.getData())).concat("'"));
        }

        // COD_FORMA_PAGAMENTO
        if (sangriaBean.getCodFormaPagamento() != null && !sangriaBean.getCodFormaPagamento().equals("")) {
            filtro = filtro.concat(" AND COD_FORMA_PAGAMENTO = '".concat(sangriaBean.getCodFormaPagamento()).concat("'"));
        }

        // TIPO_FORMA_PAGAMENTO
        if (sangriaBean.getTipoFormaPagamento() != null && !sangriaBean.getTipoFormaPagamento().equals("")) {
            filtro = filtro.concat(" AND TIPO_FORMA_PAGAMENTO = '".concat(sangriaBean.getTipoFormaPagamento()).concat("'"));
        }

        if (clausula != null && !clausula.equals("")) {
            filtro = filtro.concat(clausula);
        }

        return filtro;
    }
}
