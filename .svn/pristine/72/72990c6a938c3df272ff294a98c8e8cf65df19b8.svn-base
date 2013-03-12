/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.persistencia.dao.IDAOItemVenda;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOItemVenda extends DAOAbstract implements IDAOItemVenda {

    @Override
    public void inserir(BeanItemVenda beanItemVenda) {

        sql = "INSERT INTO MOV_ITEM_VENDA("
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " COO,"
                + " LOJA,"
                + " COD_ECF,"
                + " ITEM,"
                + " COD_PROD,"
                + " DESCRICAO,"
                + " QUANTIDADE,"
                + " COD_UND,"
                + " VALOR_UNITARIO,"
                + " VALOR_DESCONTO,"
                + " VALOR_ACRESCIMO,"
                + " VALOR_TOTAL,"
                + " ST,"
                + " INDICADOR_CANCELAMENTO,"
                + " QTD_EMB,"
                + " ICMS_ST,"
                + " ICMS_RED_BC,"
                + " ICMS_ALIQ,"
                + " ICMS_BC,"
                + " ICMS_VALOR,"
                + " IPI_ST,"
                + " IPI_ALIQ,"
                + " IPI_BC,"
                + " IPI_VALOR,"
                + " PIS_ST,"
                + " PIS_ALIQ,"
                + " PIS_BC,"
                + " PIS_VALOR,"
                + " COFINS_ST,"
                + " COFINS_ALIQ,"
                + " COFINS_BC,"
                + " COFINS_VALOR,"
                + " IAT,"
                + " CASAS_DECIMAIS_QUANTIDADE,"
                + " CASAS_DECIMAIS_VALOR,"
                + " DATA_EMISSAO,"
                + " HORA_EMISSAO,"
                + " DATA_CANCELAMENTO,"
                + " HORA_CANCELAMENTO,"
                + " CFOP,"
                + " COD_VENDEDOR)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 43)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, beanItemVenda.getCodMov());
            pstm.setString(2, beanItemVenda.getCodOper());
            pstm.setString(3, beanItemVenda.getCoo());
            pstm.setString(4, beanItemVenda.getLoja());
            pstm.setString(5, beanItemVenda.getCodEcf());
            pstm.setString(6, beanItemVenda.getItem());
            pstm.setString(7, beanItemVenda.getCodProd());
            pstm.setString(8, beanItemVenda.getDescricao());
            pstm.setBigDecimal(9, beanItemVenda.getQuantidadeVendida());
            pstm.setString(10, beanItemVenda.getCodUnd());
            pstm.setBigDecimal(11, beanItemVenda.getValorUnitario());
            pstm.setBigDecimal(12, beanItemVenda.getValorDesconto());
            pstm.setBigDecimal(13, beanItemVenda.getValorAcrescimo());
            pstm.setBigDecimal(14, beanItemVenda.getValorTotal());
            pstm.setString(15, beanItemVenda.getSt());
            pstm.setString(16, beanItemVenda.getIndicadorCancelamento());
            pstm.setBigDecimal(17, beanItemVenda.getQuantidadeEmbalagem());
            pstm.setString(18, beanItemVenda.getIcmsSt());
            pstm.setBigDecimal(19, beanItemVenda.getIcmsRedBc());
            pstm.setBigDecimal(20, beanItemVenda.getIcmsAliq());
            pstm.setBigDecimal(21, beanItemVenda.getIcmsBc());
            pstm.setBigDecimal(22, beanItemVenda.getIcmsValor());
            pstm.setString(23, beanItemVenda.getIpiSt());
            pstm.setBigDecimal(24, beanItemVenda.getIpiAliq());
            pstm.setBigDecimal(25, beanItemVenda.getIpiBc());
            pstm.setBigDecimal(26, beanItemVenda.getIpiValor());
            pstm.setString(27, beanItemVenda.getPisSt());
            pstm.setBigDecimal(28, beanItemVenda.getPisAliq());
            pstm.setBigDecimal(29, beanItemVenda.getPisBc());
            pstm.setBigDecimal(30, beanItemVenda.getPisValor());
            pstm.setString(31, beanItemVenda.getCofinsSt());
            pstm.setBigDecimal(32, beanItemVenda.getCofinsAliq());
            pstm.setBigDecimal(33, beanItemVenda.getCofinsBc());
            pstm.setBigDecimal(34, beanItemVenda.getCofinsValor());
            pstm.setString(35, beanItemVenda.getIat());
            pstm.setBigDecimal(36, beanItemVenda.getDecimaisQuantidade());
            pstm.setBigDecimal(37, beanItemVenda.getDecimaisValor());
            pstm.setDate(38, new java.sql.Date(beanItemVenda.getDataEmissao().getTime()));
            pstm.setString(39, beanItemVenda.getHoraEmissao());
            pstm.setDate(40, beanItemVenda.getDataCancelamento() != null ? new java.sql.Date(beanItemVenda.getDataCancelamento().getTime()) : null);
            pstm.setString(41, beanItemVenda.getHoraCancelamento());
            pstm.setString(42, beanItemVenda.getCfop());
            pstm.setString(43, beanItemVenda.getCodVendedor());

            pstm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanItemVenda beanItemVendaNovo, BeanItemVenda beanItemVendaAntigo) {

        sql = "UPDATE MOV_ITEM_VENDA SET"
                + " COD_MOVIMENTO = ?,"
                + " COD_OPERADOR = ?,"
                + " COO = ?,"
                + " LOJA = ?,"
                + " COD_ECF = ?,"
                + " ITEM = ?,"
                + " COD_PROD = ?,"
                + " DESCRICAO = ?,"
                + " QUANTIDADE = ?,"
                + " COD_UND = ?,"
                + " VALOR_UNITARIO = ?,"
                + " VALOR_DESCONTO = ?,"
                + " VALOR_ACRESCIMO = ?,"
                + " VALOR_TOTAL = ?,"
                + " ST = ?,"
                + " INDICADOR_CANCELAMENTO = ?,"
                + " QTD_EMB = ?,"
                + " ICMS_ST = ?,"
                + " ICMS_RED_BC = ?,"
                + " ICMS_ALIQ = ?,"
                + " ICMS_BC = ?,"
                + " ICMS_VALOR = ?,"
                + " IPI_ST = ?,"
                + " IPI_ALIQ = ?,"
                + " IPI_BC = ?,"
                + " IPI_VALOR = ?,"
                + " PIS_ST = ?,"
                + " PIS_ALIQ = ?,"
                + " PIS_BC = ?,"
                + " PIS_VALOR = ?,"
                + " COFINS_ST = ?,"
                + " COFINS_ALIQ = ?,"
                + " COFINS_BC = ?,"
                + " COFINS_VALOR = ?,"
                + " IAT = ?,"
                + " CASAS_DECIMAIS_QUANTIDADE = ?,"
                + " CASAS_DECIMAIS_VALOR = ?,"
                + " DATA_EMISSAO = ?,"
                + " HORA_EMISSAO = ?,"
                + " DATA_CANCELAMENTO = ?,"
                + " HORA_CANCELAMENTO = ?,"
                + " CFOP = ?,"
                + " COD_VENDEDOR = ?";

        sql = sql.concat(aplicarFiltro(beanItemVendaAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, beanItemVendaNovo.getCodMov());
            pstm.setString(2, beanItemVendaNovo.getCodOper());
            pstm.setString(3, beanItemVendaNovo.getCoo());
            pstm.setString(4, beanItemVendaNovo.getLoja());
            pstm.setString(5, beanItemVendaNovo.getCodEcf());
            pstm.setString(6, beanItemVendaNovo.getItem());
            pstm.setString(7, beanItemVendaNovo.getCodProd());
            pstm.setString(8, beanItemVendaNovo.getDescricao());
            pstm.setBigDecimal(9, beanItemVendaNovo.getQuantidadeVendida());
            pstm.setString(10, beanItemVendaNovo.getCodUnd());
            pstm.setBigDecimal(11, beanItemVendaNovo.getValorUnitario());
            pstm.setBigDecimal(12, beanItemVendaNovo.getValorDesconto());
            pstm.setBigDecimal(13, beanItemVendaNovo.getValorAcrescimo());
            pstm.setBigDecimal(14, beanItemVendaNovo.getValorTotal());
            pstm.setString(15, beanItemVendaNovo.getSt());
            pstm.setString(16, beanItemVendaNovo.getIndicadorCancelamento());
            pstm.setBigDecimal(17, beanItemVendaNovo.getQuantidadeEmbalagem());
            pstm.setString(18, beanItemVendaNovo.getIcmsSt());
            pstm.setBigDecimal(19, beanItemVendaNovo.getIcmsRedBc());
            pstm.setBigDecimal(20, beanItemVendaNovo.getIcmsAliq());
            pstm.setBigDecimal(21, beanItemVendaNovo.getIcmsBc());
            pstm.setBigDecimal(22, beanItemVendaNovo.getIcmsValor());
            pstm.setString(23, beanItemVendaNovo.getIpiSt());
            pstm.setBigDecimal(24, beanItemVendaNovo.getIpiAliq());
            pstm.setBigDecimal(25, beanItemVendaNovo.getIpiBc());
            pstm.setBigDecimal(26, beanItemVendaNovo.getIpiValor());
            pstm.setString(27, beanItemVendaNovo.getPisSt());
            pstm.setBigDecimal(28, beanItemVendaNovo.getPisAliq());
            pstm.setBigDecimal(29, beanItemVendaNovo.getPisBc());
            pstm.setBigDecimal(30, beanItemVendaNovo.getPisValor());
            pstm.setString(31, beanItemVendaNovo.getCofinsSt());
            pstm.setBigDecimal(32, beanItemVendaNovo.getCofinsAliq());
            pstm.setBigDecimal(33, beanItemVendaNovo.getCofinsBc());
            pstm.setBigDecimal(34, beanItemVendaNovo.getCofinsValor());
            pstm.setString(35, beanItemVendaNovo.getIat());
            pstm.setBigDecimal(36, beanItemVendaNovo.getDecimaisQuantidade());
            pstm.setBigDecimal(37, beanItemVendaNovo.getDecimaisValor());
            pstm.setDate(38, new java.sql.Date(beanItemVendaNovo.getDataEmissao().getTime()));
            pstm.setString(39, beanItemVendaNovo.getHoraEmissao());
            pstm.setDate(40, beanItemVendaNovo.getDataCancelamento() != null ? new java.sql.Date(beanItemVendaNovo.getDataCancelamento().getTime()) : null);
            pstm.setString(41, beanItemVendaNovo.getHoraCancelamento());
            pstm.setString(42, beanItemVendaNovo.getCfop());
            pstm.setString(43, beanItemVendaNovo.getCodVendedor());


            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanItemVenda> pesquisa(BeanItemVenda beanItemVenda) {

        sql = "SELECT"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " COO,"
                + " LOJA,"
                + " COD_ECF,"
                + " ITEM,"
                + " COD_PROD,"
                + " DESCRICAO,"
                + " QUANTIDADE,"
                + " COD_UND,"
                + " VALOR_UNITARIO,"
                + " VALOR_DESCONTO,"
                + " VALOR_ACRESCIMO,"
                + " VALOR_TOTAL,"
                + " ST,"
                + " INDICADOR_CANCELAMENTO,"
                + " QTD_EMB,"
                + " ICMS_ST,"
                + " ICMS_RED_BC,"
                + " ICMS_ALIQ,"
                + " ICMS_BC,"
                + " ICMS_VALOR,"
                + " IPI_ST,"
                + " IPI_ALIQ,"
                + " IPI_BC,"
                + " IPI_VALOR,"
                + " PIS_ST,"
                + " PIS_ALIQ,"
                + " PIS_BC,"
                + " PIS_VALOR,"
                + " COFINS_ST,"
                + " COFINS_ALIQ,"
                + " COFINS_BC,"
                + " COFINS_VALOR,"
                + " IAT,"
                + " CASAS_DECIMAIS_QUANTIDADE,"
                + " CASAS_DECIMAIS_VALOR,"
                + " DATA_EMISSAO,"
                + " HORA_EMISSAO,"
                + " DATA_CANCELAMENTO,"
                + " HORA_CANCELAMENTO,"
                + " CFOP,"
                + " COD_VENDEDOR"
                + " FROM MOV_ITEM_VENDA";

        sql = sql.concat(aplicarFiltro(beanItemVenda));
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanItemVenda> listaVendaDetalhe = new ArrayList<BeanItemVenda>();

            while (rs.next()) {
                BeanItemVenda itemVenda = new BeanItemVenda();

                itemVenda.setCodMov(rs.getString("COD_MOVIMENTO"));
                itemVenda.setCodOper(rs.getString("COD_OPERADOR"));
                itemVenda.setCoo(rs.getString("COO"));
                itemVenda.setLoja(rs.getString("LOJA"));
                itemVenda.setCodEcf(rs.getString("COD_ECF"));
                itemVenda.setItem(rs.getString("ITEM"));
                itemVenda.setCodProd(rs.getString("COD_PROD"));
                itemVenda.setDescricao(rs.getString("DESCRICAO"));
                itemVenda.setQuantidadeVendida(rs.getBigDecimal("QUANTIDADE"));
                itemVenda.setCodUnd(rs.getString("COD_UND"));
                itemVenda.setValorUnitario(rs.getBigDecimal("VALOR_UNITARIO"));
                itemVenda.setValorDesconto(rs.getBigDecimal("VALOR_DESCONTO"));
                itemVenda.setValorAcrescimo(rs.getBigDecimal("VALOR_ACRESCIMO"));
                itemVenda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
                itemVenda.setSt(rs.getString("ST"));
                itemVenda.setIndicadorCancelamento(rs.getString("INDICADOR_CANCELAMENTO"));
                itemVenda.setQuantidadeEmbalagem(rs.getBigDecimal("QTD_EMB"));
                itemVenda.setIcmsSt(rs.getString("ICMS_ST"));
                itemVenda.setIcmsRedBc(rs.getBigDecimal("ICMS_RED_BC"));
                itemVenda.setIcmsAliq(rs.getBigDecimal("ICMS_ALIQ"));
                itemVenda.setIcmsBc(rs.getBigDecimal("ICMS_BC"));
                itemVenda.setIcmsValor(rs.getBigDecimal("ICMS_VALOR"));
                itemVenda.setIpiSt(rs.getString("IPI_ST"));
                itemVenda.setIpiAliq(rs.getBigDecimal("IPI_ALIQ"));
                itemVenda.setIpiBc(rs.getBigDecimal("IPI_BC"));
                itemVenda.setIpiValor(rs.getBigDecimal("IPI_VALOR"));
                itemVenda.setPisSt(rs.getString("PIS_ST"));
                itemVenda.setPisAliq(rs.getBigDecimal("PIS_ALIQ"));
                itemVenda.setPisBc(rs.getBigDecimal("PIS_BC"));
                itemVenda.setPisValor(rs.getBigDecimal("PIS_VALOR"));
                itemVenda.setCofinsSt(rs.getString("COFINS_ST"));
                itemVenda.setCofinsAliq(rs.getBigDecimal("COFINS_ALIQ"));
                itemVenda.setCofinsBc(rs.getBigDecimal("COFINS_BC"));
                itemVenda.setCofinsValor(rs.getBigDecimal("COFINS_VALOR"));
                itemVenda.setIat(rs.getString("IAT"));
                itemVenda.setDecimaisQuantidade(rs.getBigDecimal("CASAS_DECIMAIS_QUANTIDADE"));
                itemVenda.setDecimaisValor(rs.getBigDecimal("CASAS_DECIMAIS_VALOR"));
                itemVenda.setDataEmissao(rs.getDate("DATA_EMISSAO"));
                itemVenda.setHoraEmissao(rs.getString("HORA_EMISSAO"));
                itemVenda.setDataCancelamento(rs.getDate("DATA_CANCELAMENTO"));
                itemVenda.setHoraCancelamento(rs.getString("HORA_CANCELAMENTO"));
                itemVenda.setCfop(rs.getString("CFOP"));
                itemVenda.setCodVendedor(rs.getString("COD_VENDEDOR"));

                listaVendaDetalhe.add(itemVenda);
            }
            return listaVendaDetalhe;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanItemVenda>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanItemVenda vendaDetalheBean) {

        sql = "DEELTE FROM MOV_ITEM_VENDA";
        sql = sql.concat(aplicarFiltro(vendaDetalheBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanItemVenda beanItemVenda) {
        String filtro = " WHERE  1 = 1";

        // COD_PROD
        if (beanItemVenda.getCodProd() != null && !beanItemVenda.getCodProd().equals("")) {
            filtro = filtro.concat(" AND COD_PROD = '").concat(beanItemVenda.getCodProd()).concat("'");
        }

        // COO
        if (beanItemVenda.getCoo() != null && !beanItemVenda.getCoo().equals("")) {
            filtro = filtro.concat(" AND COO = '").concat(beanItemVenda.getCoo()).concat("'");
        }

        // COD_MOVIMENTO
        if (beanItemVenda.getCodMov() != null && !beanItemVenda.getCodMov().equals("")) {
            filtro = filtro.concat(" AND COD_MOVIMENTO = '").concat(beanItemVenda.getCodMov()).concat("'");
        }

        // ITEM
        if (beanItemVenda.getItem() != null && !beanItemVenda.getItem().equals("")) {
            filtro = filtro.concat(" AND ITEM = '").concat(beanItemVenda.getItem()).concat("'");
        }

        // LOJA
        if (beanItemVenda.getLoja() != null && !beanItemVenda.getLoja().equals("")) {
            filtro = filtro.concat(" AND LOJA = '").concat(beanItemVenda.getLoja()).concat("'");
        }

        // COD_ECF
        if (beanItemVenda.getCodEcf() != null && !beanItemVenda.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '").concat(beanItemVenda.getCodEcf()).concat("'");
        }

        // DATA_EMISSAO
        if (beanItemVenda.getDataEmissao() != null) {
            filtro = filtro.concat(" AND DATA_EMISSAO = '").concat(sdf.format(beanItemVenda.getDataEmissao())).concat("'");
        }

        return filtro;
    }
}
