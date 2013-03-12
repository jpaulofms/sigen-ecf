/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanLancamento;
import com.sigen.ecf.persistencia.dao.IDAOLancamento;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Administrador
 */
public class DAOLancamento extends DAOAbstract implements IDAOLancamento {

    public static String clausula = "";

    @Override
    public void inserir(BeanLancamento lancamentoBean) {

        sql = "INSERT INTO MOV_LANCAMENTO("
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " COO,"
                + " COD_FORMA_PAGAMENTO,"
                + " TIPO_FORMA_PAGAMENTO,"
                + " COD_CONVENIADA,"
                + " COD_CLIENTE,"
                + " VALOR_BRUTO,"
                + " VALOR_LIQUIDO,"
                + " DATA_LANCAMENTO,"
                + " HORA_LANCAMENTO,"
                + " COD_CONDICAO_PAGAMENTO,"
                + " NUM_LANCAMENTO,"
                + " NUM_PARCELA,"
                + " DATA_VENCIMENTO,"
                + " CHQ_BANCO,"
                + " CHQ_AGENCIA,"
                + " CHQ_CONTA,"
                + " CHQ_NUMERO,"
                + " RECIBO_DEVOLUCAO,"
                + " NUMERO_AUTORIZACAO,"
                + " TAXA_ADM)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 24)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, lancamentoBean.getLoja());
            pstm.setString(2, lancamentoBean.getCodEcf());
            pstm.setString(3, lancamentoBean.getCodMov());
            pstm.setString(4, lancamentoBean.getCodOper());
            pstm.setString(5, lancamentoBean.getCoo());
            pstm.setString(6, lancamentoBean.getCodFormaPagamento());
            pstm.setString(7, lancamentoBean.getTipoFormaPagamento());
            pstm.setString(8, lancamentoBean.getCodConveniada());
            pstm.setString(9, lancamentoBean.getCodCliente());
            pstm.setBigDecimal(10, lancamentoBean.getValorBruto());
            pstm.setBigDecimal(11, lancamentoBean.getValorLiquido());
            pstm.setDate(12, new java.sql.Date(lancamentoBean.getDataLancamento().getTime()));
            pstm.setString(13, lancamentoBean.getHoraLancamento());
            pstm.setString(14, lancamentoBean.getCodCondicaoPagamento());
            pstm.setString(15, lancamentoBean.getNumLancamento());
            pstm.setString(16, lancamentoBean.getNumParcela());
            pstm.setDate(17, new java.sql.Date(lancamentoBean.getDataVencimento().getTime()));
            pstm.setString(18, lancamentoBean.getChqBanco());
            pstm.setString(19, lancamentoBean.getChqAgencia());
            pstm.setString(20, lancamentoBean.getChqConta());
            pstm.setString(21, lancamentoBean.getChqNumero());
            pstm.setString(22, lancamentoBean.getReciboDevolucao());
            pstm.setString(23, lancamentoBean.getNumeroAutorizacao());
            pstm.setBigDecimal(24, lancamentoBean.getTaxaAdm());

            pstm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanLancamento lancamentoBeanNovo, BeanLancamento lancamentoBeanAntigo) {

        sql = "UPDATE MOV_LANCAMENTO SET"
                + " LOJA = ?,"
                + " COD_ECF = ?,"
                + " COD_MOVIMENTO = ?,"
                + " COD_OPERADOR = ?,"
                + " COO = ?,"
                + " COD_FORMA_PAGAMENTO = ?,"
                + " TIPO_FORMA_PAGAMENTO = ?,"
                + " COD_CONVENIADA = ?,"
                + " COD_CLIENTE = ?,"
                + " VALOR_BRUTO = ?,"
                + " VALOR_LIQUIDO = ?,"
                + " DATA_LANCAMENTO = ?,"
                + " HORA_LANCAMENTO = ?,"
                + " COD_CONDICAO_PAGAMENTO = ?,"
                + " NUM_LANCAMENTO = ?,"
                + " NUM_PARCELA = ?,"
                + " DATA_VENCIMENTO = ?,"
                + " CHQ_BANCO = ?,"
                + " CHQ_AGENCIA = ?,"
                + " CHQ_CONTA = ?,"
                + " CHQ_NUMERO = ?,"
                + " RECIBO_DEVOLUCAO = ?,"
                + " NUMERO_AUTORIZACAO = ?,"
                + " TAXA_ADM = ?";

        sql = sql.concat(aplicarFiltro(lancamentoBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, lancamentoBeanNovo.getLoja());
            pstm.setString(2, lancamentoBeanNovo.getCodEcf());
            pstm.setString(3, lancamentoBeanNovo.getCodMov());
            pstm.setString(4, lancamentoBeanNovo.getCodOper());
            pstm.setString(5, lancamentoBeanNovo.getCoo());
            pstm.setString(6, lancamentoBeanNovo.getCodFormaPagamento());
            pstm.setString(7, lancamentoBeanNovo.getTipoFormaPagamento());
            pstm.setString(8, lancamentoBeanNovo.getCodConveniada());
            pstm.setString(9, lancamentoBeanNovo.getCodCliente());
            pstm.setBigDecimal(10, lancamentoBeanNovo.getValorBruto());
            pstm.setBigDecimal(11, lancamentoBeanNovo.getValorLiquido());
            pstm.setDate(12, new java.sql.Date(lancamentoBeanNovo.getDataLancamento().getTime()));
            pstm.setString(13, lancamentoBeanNovo.getHoraLancamento());
            pstm.setString(14, lancamentoBeanNovo.getCodCondicaoPagamento());
            pstm.setString(15, lancamentoBeanNovo.getNumLancamento());
            pstm.setString(16, lancamentoBeanNovo.getNumParcela());
            pstm.setDate(17, new java.sql.Date(lancamentoBeanNovo.getDataVencimento().getTime()));
            pstm.setString(18, lancamentoBeanNovo.getChqBanco());
            pstm.setString(19, lancamentoBeanNovo.getChqAgencia());
            pstm.setString(20, lancamentoBeanNovo.getChqConta());
            pstm.setString(21, lancamentoBeanNovo.getChqNumero());
            pstm.setString(22, lancamentoBeanNovo.getReciboDevolucao());
            pstm.setString(23, lancamentoBeanNovo.getNumeroAutorizacao());
            pstm.setBigDecimal(24, lancamentoBeanNovo.getTaxaAdm());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanLancamento> pesquisa(BeanLancamento lancamentoBean) {

        sql = "SELECT"
                + " LOJA,"
                + " COD_ECF,"
                + " COD_MOVIMENTO,"
                + " COD_OPERADOR,"
                + " COO,"
                + " COD_FORMA_PAGAMENTO,"
                + " TIPO_FORMA_PAGAMENTO,"
                + " COD_CONVENIADA,"
                + " COD_CLIENTE,"
                + " VALOR_BRUTO,"
                + " VALOR_LIQUIDO,"
                + " DATA_LANCAMENTO,"
                + " HORA_LANCAMENTO,"
                + " COD_CONDICAO_PAGAMENTO,"
                + " NUM_LANCAMENTO,"
                + " NUM_PARCELA,"
                + " DATA_VENCIMENTO,"
                + " CHQ_BANCO,"
                + " CHQ_AGENCIA,"
                + " CHQ_CONTA,"
                + " CHQ_NUMERO,"
                + " RECIBO_DEVOLUCAO,"
                + " NUMERO_AUTORIZACAO,"
                + " TAXA_ADM"
                + " FROM MOV_LANCAMENTO";

        sql = sql.concat(aplicarFiltro(lancamentoBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanLancamento> listaLancamento = new ArrayList<BeanLancamento>();

            while (rs.next()) {
                BeanLancamento lancamento = new BeanLancamento();

                lancamento.setLoja(rs.getString("LOJA"));
                lancamento.setCodEcf(rs.getString("COD_ECF"));
                lancamento.setCodMov(rs.getString("COD_MOVIMENTO"));
                lancamento.setCodOper(rs.getString("COD_OPERADOR"));
                lancamento.setCoo(rs.getString("COO"));
                lancamento.setCodFormaPagamento(rs.getString("COD_FORMA_PAGAMENTO"));
                lancamento.setTipoFormaPagamento(rs.getString("TIPO_FORMA_PAGAMENTO"));
                lancamento.setCodConveniada(rs.getString("COD_CONVENIADA"));
                lancamento.setCodCliente(rs.getString("COD_CLIENTE"));
                lancamento.setValorBruto(rs.getBigDecimal("VALOR_BRUTO"));
                lancamento.setValorLiquido(rs.getBigDecimal("VALOR_LIQUIDO"));
                lancamento.setDataLancamento(rs.getDate("DATA_LANCAMENTO"));
                lancamento.setHoraLancamento(rs.getString("HORA_LANCAMENTO"));
                lancamento.setCodCondicaoPagamento(rs.getString("COD_CONDICAO_PAGAMENTO"));
                lancamento.setNumLancamento(rs.getString("NUM_LANCAMENTO"));
                lancamento.setNumParcela(rs.getString("NUM_PARCELA"));
                lancamento.setDataVencimento(rs.getDate("DATA_VENCIMENTO"));
                lancamento.setChqBanco(rs.getString("CHQ_BANCO"));
                lancamento.setChqAgencia(rs.getString("CHQ_AGENCIA"));
                lancamento.setChqConta(rs.getString("CHQ_CONTA"));
                lancamento.setChqNumero(rs.getString("CHQ_NUMERO"));
                lancamento.setReciboDevolucao(rs.getString("RECIBO_DEVOLUCAO"));
                lancamento.setNumeroAutorizacao(rs.getString("NUMERO_AUTORIZACAO"));
                lancamento.setTaxaAdm(rs.getBigDecimal("TAXA_ADM"));

                listaLancamento.add(lancamento);
            }

            return listaLancamento;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanLancamento>();
        } finally {
            bd.desconectar();
        }
    }

    public List<BeanLancamento> pesquisaPorTipo(BeanLancamento lancamentoBean) {

        sql = "SELECT"
                + " SUM(VALOR_BRUTO) AS VALOR,"
                + " TIPO_FORMA_PAGAMENTO"
                + " FROM MOV_LANCAMENTO";

        sql = sql.concat(aplicarFiltro(lancamentoBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanLancamento> listaLancamento = new ArrayList<BeanLancamento>();

            while (rs.next()) {
                BeanLancamento lancamento = new BeanLancamento();

                lancamento.setTipoFormaPagamento(rs.getString("TIPO_FORMA_PAGAMENTO"));
                lancamento.setValorBruto(rs.getBigDecimal("VALOR"));

                listaLancamento.add(lancamento);
            }

            return listaLancamento;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanLancamento>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanLancamento lancamentoBean) {

        sql = "DELETE FROM MOV_LANCAMENTO";
        sql = sql.concat(aplicarFiltro(lancamentoBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanLancamento lancamentoBean) {
        String filtro = " WHERE 1 = 1";

        // LOJA
        if (lancamentoBean.getLoja() != null && !lancamentoBean.getLoja().equals("")) {
            filtro = filtro.concat(" AND LOJA = '".concat(lancamentoBean.getLoja()).concat("'"));
        }

        // COD_ECF
        if (lancamentoBean.getCodEcf() != null && !lancamentoBean.getCodEcf().equals("")) {
            filtro = filtro.concat(" AND COD_ECF = '".concat(lancamentoBean.getCodEcf()).concat("'"));
        }

        // COD_MOVIMENTO
        if (lancamentoBean.getCodMov() != null && !lancamentoBean.getCodMov().equals("")) {
            filtro = filtro.concat(" AND COD_MOVIMENTO = '".concat(lancamentoBean.getCodMov()).concat("'"));
        }

        // COD_OPERADOR
        if (lancamentoBean.getCodOper() != null && !lancamentoBean.getCodOper().equals("")) {
            filtro = filtro.concat(" AND COD_OPERADOR = '".concat(lancamentoBean.getCodOper()).concat("'"));
        }

        // COD_FORMA_PAGAMENTO
        if (lancamentoBean.getCodFormaPagamento() != null && !lancamentoBean.getCodFormaPagamento().equals("")) {
            filtro = filtro.concat(" AND COD_FORMA_PAGAMNTO = '".concat(lancamentoBean.getCodFormaPagamento()).concat("'"));
        }

        // COD_CONVENIADA
        if (lancamentoBean.getCodConveniada() != null && !lancamentoBean.getCodConveniada().equals("")) {
            filtro = filtro.concat(" AND COD_CONVENIADA = '".concat(lancamentoBean.getCodConveniada()).concat("'"));
        }

        // COD_CLIENTE
        if (lancamentoBean.getCodCliente() != null && !lancamentoBean.getCodCliente().equals("")) {
            filtro = filtro.concat(" AND COD_CLIENTE = '".concat(lancamentoBean.getCodCliente()).concat("'"));
        }

        // DATA_LANCAMENTO
        if (lancamentoBean.getDataLancamento() != null) {
            filtro = filtro.concat(" AND DATA_LANCAMENTO = '".concat(sdf.format(lancamentoBean.getDataLancamento())).concat("'"));
        }

        // COD_CONDICAO_PAGAMENTO
        if (lancamentoBean.getCodCondicaoPagamento() != null && !lancamentoBean.getCodCondicaoPagamento().equals("")) {
            filtro = filtro.concat(" AND COD_CONDICAO_PAGAMENTO = '".concat(lancamentoBean.getCodCondicaoPagamento()).concat("'"));
        }

        // TIPO_FORMA_PAGAMENTO
        if (lancamentoBean.getTipoFormaPagamento() != null && !lancamentoBean.getTipoFormaPagamento().equals("")) {
            filtro = filtro.concat(" AND TIPO_FORMA_PAGAMENTO = '".concat(lancamentoBean.getTipoFormaPagamento()).concat("'"));
        }

        // DATA_VENCIMENTO
        if (lancamentoBean.getDataVencimento() != null) {
            filtro = filtro.concat(" AND DATA_VENCIMENTO = '".concat(sdf.format(lancamentoBean.getDataVencimento())).concat("'"));
        }

        if (clausula != null && !clausula.equals("")) {
            filtro = filtro.concat(" " + clausula);
        }

        return filtro;
    }
}
