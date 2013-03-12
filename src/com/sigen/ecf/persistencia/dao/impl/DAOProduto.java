/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.persistencia.dao.IDAOProduto;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulisson@sigensistemas.com.br
 */
public class DAOProduto extends DAOAbstract implements IDAOProduto {

    @Override
    public void inserir(BeanProduto produto) {

        sql = " INSERT INTO CAD_PRODUTO P("
                + " P.COD_PROD,"
                + " P.PRECO_VENDA,"
                + " P.DESCRICAO,"
                + " P.SALDO_ESTOQUE,"
                + " P.ICMS_ST,"
                + " P.ICMS_RED_BC,"
                + " P.ICMS_ALIQ,"
                + " P.IPI_ST,"
                + " P.IPI_ALIQ,"
                + " P.PIS_ST,"
                + " P.PIS_ALIQ,"
                + " P.COFINS_ST,"
                + " P.COFINS_ALIQ,"
                + " P.CFOP)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 14)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, produto.getCodProd());
            pstm.setBigDecimal(2, produto.getPrecoVenda());
            pstm.setString(3, produto.getDescricao());
            pstm.setBigDecimal(4, produto.getSaldoEstoque());
            pstm.setString(5, produto.getIcmsSt());
            pstm.setBigDecimal(6, produto.getIcmsRedBc());
            pstm.setBigDecimal(7, produto.getIcmsAliq());
            pstm.setString(8, produto.getIpiSt());
            pstm.setBigDecimal(9, produto.getIpiAliq());
            pstm.setString(10, produto.getPisSt());
            pstm.setBigDecimal(11, produto.getPisAliq());
            pstm.setString(12, produto.getCofinsSt());
            pstm.setBigDecimal(13, produto.getCofinsAliq());
            pstm.setString(14, produto.getCfop());

            pstm.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanProduto produtoBeanNovo, BeanProduto produtoBeanAntigo) {

        sql = "UPDATE CAD_PRODUTO P SET"
                + " P.COD_PROD = ?,  "
                + " P.PRECO_VENDA = ?,  "
                + " P.DESCRICAO = ?,  "
                + " P.SALDO_ESTOQUE = ?,  "
                + " P.ICMS_ST = ?,  "
                + " P.ICMS_RED_BC = ?,  "
                + " P.ICMS_ALIQ = ?,  "
                + " P.IPI_ST = ?,  "
                + " P.IPI_ALIQ = ?,  "
                + " P.PIS_ST = ?,  "
                + " P.PIS_ALIQ = ?,  "
                + " P.COFINS_ST = ?,  "
                + " P.COFINS_ALIQ = ?,"
                + " P.CFOP = ?";

        sql = sql.concat(aplicarFiltro(produtoBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, produtoBeanNovo.getCodProd());
            pstm.setBigDecimal(2, produtoBeanNovo.getPrecoVenda());
            pstm.setString(3, produtoBeanNovo.getDescricao());
            pstm.setBigDecimal(4, produtoBeanNovo.getSaldoEstoque());
            pstm.setString(5, produtoBeanNovo.getIcmsSt());
            pstm.setBigDecimal(6, produtoBeanNovo.getIcmsRedBc());
            pstm.setBigDecimal(7, produtoBeanNovo.getIcmsAliq());
            pstm.setString(8, produtoBeanNovo.getIpiSt());
            pstm.setBigDecimal(9, produtoBeanNovo.getIpiAliq());
            pstm.setString(10, produtoBeanNovo.getPisSt());
            pstm.setBigDecimal(11, produtoBeanNovo.getPisAliq());
            pstm.setString(12, produtoBeanNovo.getCofinsSt());
            pstm.setBigDecimal(13, produtoBeanNovo.getCofinsAliq());
            pstm.setString(14, produtoBeanNovo.getCfop());

            pstm.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanProduto> pesquisa(BeanProduto produto) {

        sql = "SELECT"
                + " P.COD_PROD,"
                + " P.PRECO_VENDA,"
                + " P.DESCRICAO AS PDESCRICAO,"
                + " P.SALDO_ESTOQUE,"
                + " P.ICMS_ST,"
                + " P.ICMS_RED_BC,"
                + " P.ICMS_ALIQ,"
                + " P.IPI_ST,"
                + " P.IPI_ALIQ,"
                + " P.PIS_ST,"
                + " P.PIS_ALIQ,"
                + " P.COFINS_ST,"
                + " P.COFINS_ALIQ,"
                + " P.CFOP,"
                + " PUN.COD_UND,"
                + " PUN.QTD_EMB,"
                + " B.EAN,"
                + " UN.DESCRICAO AS UNDESCRICAO"
                + " FROM CAD_PRODUTO P JOIN CAD_PRODUTO_UNIDADE_MEDIDA PUN ON ( P.COD_PROD = PUN.COD_PROD )"
                + " JOIN CAD_CODIGO_BARRAS B ON (( PUN.COD_UND = B.COD_UND  ) AND ( P.COD_PROD = B.COD_PROD ))"
                + " JOIN CAD_UNIDADE_MEDIDA UN ON (PUN.COD_UND = UN.COD_UND )";

        sql = sql.concat(aplicarFiltro(produto));
        sql = sql.concat(" ORDER BY P.DESCRICAO, PUN.COD_UND");

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanProduto> listaProdutos = new ArrayList<BeanProduto>();

            while (rs.next()) {
                BeanProduto produtoBean = new BeanProduto();

                produtoBean.setCodProd(rs.getString("COD_PROD"));
                produtoBean.setCodUnd(rs.getString("COD_UND"));
                produtoBean.setEan(rs.getString("EAN"));
                produtoBean.setDescricao(rs.getString("PDESCRICAO"));
                produtoBean.setSaldoEstoque(rs.getBigDecimal("SALDO_ESTOQUE"));
                produtoBean.setIcmsSt(rs.getString("ICMS_ST"));
                produtoBean.setIcmsRedBc(rs.getBigDecimal("ICMS_RED_BC"));
                produtoBean.setIcmsAliq(rs.getBigDecimal("ICMS_ALIQ"));
                produtoBean.setIpiSt(rs.getString("IPI_ST"));
                produtoBean.setIpiAliq(rs.getBigDecimal("IPI_ALIQ"));
                produtoBean.setPisSt(rs.getString("PIS_ST"));
                produtoBean.setPisAliq(rs.getBigDecimal("PIS_ALIQ"));
                produtoBean.setCofinsSt(rs.getString("COFINS_ST"));
                produtoBean.setCofinsAliq(rs.getBigDecimal("COFINS_ALIQ"));
                produtoBean.setCfop(rs.getString("CFOP"));
                produtoBean.setUndDescricao(rs.getString("UNDESCRICAO"));
                produtoBean.setQuantidadeEmbalagem(rs.getBigDecimal("QTD_EMB"));
                /* VALOR PRECO  = VALOR UNITARIO x QUANTIDADE EM EMBALAGEM */
                produtoBean.setPrecoVenda((rs.getBigDecimal("PRECO_VENDA")).multiply(produtoBean.getQuantidadeEmbalagem()));


                listaProdutos.add(produtoBean);
            }

            return listaProdutos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<BeanProduto>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public BeanProduto pesquisarProduto(String codProduto) {

        sql = "SELECT"
                + " P.COD_PROD,"
                + " P.PRECO_VENDA,"
                + " P.DESCRICAO AS PDESCRICAO,"
                + " P.SALDO_ESTOQUE,"
                + " P.ICMS_ST,"
                + " P.ICMS_RED_BC,"
                + " P.ICMS_ALIQ,"
                + " P.IPI_ST,"
                + " P.IPI_ALIQ,"
                + " P.PIS_ST,"
                + " P.PIS_ALIQ,"
                + " P.COFINS_ST,"
                + " P.COFINS_ALIQ,"
                + " P.CFOP,"
                + " PUN.COD_UND,"
                + " PUN.QTD_EMB,"
                + " UN.DESCRICAO AS UNDESCRICAO,"
                + " B.EAN"
                + " FROM CAD_PRODUTO P JOIN CAD_PRODUTO_UNIDADE_MEDIDA PUN ON ( P.COD_PROD = PUN.COD_PROD )"
                + " JOIN CAD_CODIGO_BARRAS B ON ( P.COD_PROD = B.COD_PROD )"
                + " JOIN CAD_UNIDADE_MEDIDA UN ON ( UN.COD_UND = PUN.COD_UND )"
                + " WHERE PUN.COD_PROD = '" + codProduto + "'"
                + " AND PUN.UND_PADRAO = TRUE";

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            BeanProduto produtoBean = null;

            if (rs.next()) {
                produtoBean = new BeanProduto();

                produtoBean.setCodProd(rs.getString("COD_PROD"));
                produtoBean.setCodUnd(rs.getString("COD_UND"));
                produtoBean.setEan(rs.getString("EAN"));
                produtoBean.setPrecoVenda(rs.getBigDecimal("PRECO_VENDA"));
                produtoBean.setDescricao(rs.getString("PDESCRICAO"));
                produtoBean.setSaldoEstoque(rs.getBigDecimal("SALDO_ESTOQUE"));
                produtoBean.setIcmsSt(rs.getString("ICMS_ST"));
                produtoBean.setIcmsRedBc(rs.getBigDecimal("ICMS_RED_BC"));
                produtoBean.setIcmsAliq(rs.getBigDecimal("ICMS_ALIQ"));
                produtoBean.setIpiSt(rs.getString("IPI_ST"));
                produtoBean.setIpiAliq(rs.getBigDecimal("IPI_ALIQ"));
                produtoBean.setPisSt(rs.getString("PIS_ST"));
                produtoBean.setPisAliq(rs.getBigDecimal("PIS_ALIQ"));
                produtoBean.setCofinsSt(rs.getString("COFINS_ST"));
                produtoBean.setCofinsAliq(rs.getBigDecimal("COFINS_ALIQ"));
                produtoBean.setCfop(rs.getString("CFOP"));
                produtoBean.setUndDescricao(rs.getString("UNDESCRICAO"));
                produtoBean.setQuantidadeEmbalagem(rs.getBigDecimal("QTD_EMB"));

            }

            return produtoBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public BeanProduto pesquisarProdutoCodBarra(String codBarra) {

        sql = "SELECT"
                + " P.COD_PROD,"
                + " P.PRECO_VENDA,"
                + " P.DESCRICAO AS PDESCRICAO,"
                + " P.SALDO_ESTOQUE,"
                + " P.ICMS_ST,"
                + " P.ICMS_RED_BC,"
                + " P.ICMS_ALIQ,"
                + " P.IPI_ST,"
                + " P.IPI_ALIQ,"
                + " P.PIS_ST,"
                + " P.PIS_ALIQ,"
                + " P.COFINS_ST,"
                + " P.COFINS_ALIQ,"
                + " P.CFOP,"
                + " PUN.COD_UND,"
                + " PUN.QTD_EMB,"
                + " UN.DESCRICAO AS UNDESCRICAO,"
                + " B.EAN"
                + " FROM CAD_PRODUTO P JOIN CAD_PRODUTO_UNIDADE_MEDIDA PUN ON ( P.COD_PROD = PUN.COD_PROD )"
                + " JOIN CAD_CODIGO_BARRAS B ON ( P.COD_PROD = B.COD_PROD )"
                + " JOIN CAD_UNIDADE_MEDIDA UN ON ( UN.COD_UND = PUN.COD_UND )"
                + " WHERE B.EAN = '" + codBarra + "'";

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            BeanProduto produtoBean = null;

            if (rs.next()) {
                produtoBean = new BeanProduto();

                produtoBean.setCodProd(rs.getString("COD_PROD"));
                produtoBean.setCodUnd(rs.getString("COD_UND"));
                produtoBean.setEan(rs.getString("EAN"));
                produtoBean.setPrecoVenda(rs.getBigDecimal("PRECO_VENDA"));
                produtoBean.setDescricao(rs.getString("PDESCRICAO"));
                produtoBean.setSaldoEstoque(rs.getBigDecimal("SALDO_ESTOQUE"));
                produtoBean.setIcmsSt(rs.getString("ICMS_ST"));
                produtoBean.setIcmsRedBc(rs.getBigDecimal("ICMS_RED_BC"));
                produtoBean.setIcmsAliq(rs.getBigDecimal("ICMS_ALIQ"));
                produtoBean.setIpiSt(rs.getString("IPI_ST"));
                produtoBean.setIpiAliq(rs.getBigDecimal("IPI_ALIQ"));
                produtoBean.setPisSt(rs.getString("PIS_ST"));
                produtoBean.setPisAliq(rs.getBigDecimal("PIS_ALIQ"));
                produtoBean.setCofinsSt(rs.getString("COFINS_ST"));
                produtoBean.setCofinsAliq(rs.getBigDecimal("COFINS_ALIQ"));
                produtoBean.setCfop(rs.getString("CFOP"));
                produtoBean.setUndDescricao(rs.getString("UNDESCRICAO"));
                produtoBean.setQuantidadeEmbalagem(rs.getBigDecimal("QTD_EMB"));

            }

            return produtoBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanProduto produtoBean) {
        try {

            sql = "DELETE FROM CAD_PRODUTO";

            sql = sql.concat(aplicarFiltro(produtoBean));

            stm = bd.conectar().createStatement();

            stm.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanProduto produtoBean) {
        String filtro = " WHERE 1 = 1";

        // CODPROD
        if (produtoBean.getCodProd() != null && !produtoBean.getCodProd().equals("")) {
            filtro = filtro.concat(" AND P.COD_PROD = '".concat(produtoBean.getCodProd()).concat("'"));
        }

        // DESCRICAO
        if (produtoBean.getDescricao() != null && !produtoBean.getDescricao().equals("")) {
            filtro = filtro.concat(" AND P.DESCRICAO LIKE '".concat(produtoBean.getDescricao()).concat("%'"));
        }

        // EAN
        if (produtoBean.getEan() != null && !produtoBean.getEan().equals("")) {
            filtro = filtro.concat(" AND B.EAN  = '".concat(produtoBean.getEan()).concat("'"));
        }

        return filtro;
    }
}
