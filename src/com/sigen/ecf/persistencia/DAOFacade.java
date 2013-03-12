/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanCondicaoPagamento;
import com.sigen.ecf.model.bean.BeanDevolucao;
import com.sigen.ecf.model.bean.BeanFormaCondicaoPagamento;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import com.sigen.ecf.model.bean.BeanItemDevolucao;
import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.model.bean.BeanLancamento;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.model.bean.BeanParametros;
import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.model.bean.BeanSangria;
import com.sigen.ecf.model.bean.BeanSpedFiscal;
import com.sigen.ecf.model.bean.BeanSpedFiscalAliquota;
import com.sigen.ecf.model.bean.BeanSuprimento;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.model.bean.BeanVendedor;
import com.sigen.ecf.persistencia.dao.impl.DAOCliente;
import com.sigen.ecf.persistencia.dao.impl.DAOCondicaoPagamento;
import com.sigen.ecf.persistencia.dao.impl.DAODevolucao;
import com.sigen.ecf.persistencia.dao.impl.DAOFormaCondicaoPagamento;
import com.sigen.ecf.persistencia.dao.impl.DAOFormaPagamento;
import com.sigen.ecf.persistencia.dao.impl.DAOItemDevolucao;
import com.sigen.ecf.persistencia.dao.impl.DAOItemVenda;
import com.sigen.ecf.persistencia.dao.impl.DAOLancamento;
import com.sigen.ecf.persistencia.dao.impl.DAOMovimento;
import com.sigen.ecf.persistencia.dao.impl.DAOOperador;
import com.sigen.ecf.persistencia.dao.impl.DAOParametros;
import com.sigen.ecf.persistencia.dao.impl.DAOProduto;
import com.sigen.ecf.persistencia.dao.impl.DAOSangria;
import com.sigen.ecf.persistencia.dao.impl.DAOSpedFiscal;
import com.sigen.ecf.persistencia.dao.impl.DAOSpedFiscalAliquota;
import com.sigen.ecf.persistencia.dao.impl.DAOSuprimento;
import com.sigen.ecf.persistencia.dao.impl.DAOVenda;
import com.sigen.ecf.persistencia.dao.impl.DAOVendedor;
import java.util.List;

/**
 *
 * @author Paulisson
 */
public class DAOFacade {

    public static List<BeanOperador> getLsGerente() {
        BeanOperador supervisor = new BeanOperador();
        supervisor.setSupervisor(true);
        return new DAOOperador().pesquisa(supervisor);
    }

    public static BeanFormaPagamento getFormaPagamento(BeanFormaPagamento beanFormaPagamento) {
        return new DAOFormaPagamento().pesquisa(beanFormaPagamento).get(0);
    }

    public static BeanCondicaoPagamento getCondicaoPagamento(BeanCondicaoPagamento beanCondicaoPagamento) {
        return new DAOCondicaoPagamento().pesquisa(beanCondicaoPagamento).get(0);
    }

    public static BeanParametros getParametros(BeanParametros beanParametros) {
        return new DAOParametros().pesquisa(beanParametros).get(0);
    }

    public static List<BeanCliente> getLsCliente(String cpfCnpj) {
        BeanCliente bc = new BeanCliente();
        bc.setCpfCnpj(cpfCnpj);
        return new DAOCliente().pesquisa(bc);
    }

    public static List<BeanOperador> getLsOperador() {
        BeanOperador operador = new BeanOperador();
        operador.setSupervisor(false);
        return new DAOOperador().pesquisa(operador);
    }

    public static List<BeanProduto> getLsProduto(BeanProduto beanProduto) {
        return new DAOProduto().pesquisa(beanProduto);
    }

    public static BeanProduto getProduto(BeanProduto beanProduto) {
        List<BeanProduto> lsProduto = getLsProduto(beanProduto);
        if (!lsProduto.isEmpty()) {
            return lsProduto.get(0);
        }
        return null;
    }

    public static List<BeanDevolucao> getLsDevolucao(BeanDevolucao beanDevolucao) {
        DAODevolucao.clausula = " AND VALOR_CREDITO > 0";
        return new DAODevolucao().pesquisa(beanDevolucao);
    }

    public static List<BeanSangria> getLsSangria(BeanSangria beanSangria) {
        return new DAOSangria().pesquisa(beanSangria);
    }

    public static List<BeanItemVenda> getLsItemVenda(BeanItemVenda beanItemVenda) {
        return new DAOItemVenda().pesquisa(beanItemVenda);
    }

    public static List<BeanSangria> getLsSangriaPorTipo(BeanSangria beanSangria) {
        String clausula = " GROUP BY COD_FORMA_PAGAMENTO, TIPO_FORMA_PAGAMENTO ORDER BY COD_FORMA_PAGAMENTO";
        DAOSangria.clausula = clausula;
        return new DAOSangria().pesquisaPorTipo(beanSangria);
    }

    public static List<BeanLancamento> getLsLancamentoPorTipo(BeanLancamento beanLancamento, String clausula) {
        DAOLancamento.clausula = clausula;
        return new DAOLancamento().pesquisaPorTipo(beanLancamento);
    }

    public static List<BeanLancamento> getLsLancamento(BeanLancamento beanLancamento) {
        return new DAOLancamento().pesquisa(beanLancamento);
    }

    public static List<BeanMovimento> getLsMovimento(BeanMovimento beanMovimento, String clausula) {
        DAOMovimento.clausula = clausula;
        return new DAOMovimento().pesquisa(beanMovimento);
    }

    public static List<BeanSuprimento> getLsSuprimento(BeanSuprimento beanSuprimento) {
        return new DAOSuprimento().pesquisa(beanSuprimento);
    }

    public static int getIdAliquota() {
        return Integer.parseInt(new DAOSpedFiscalAliquota().getUltimoId());
    }

    public static void inserirMovimento(BeanMovimento beanMovimento) {
        new DAOMovimento().inserir(beanMovimento);
    }

    public static void inserirDevolucao(BeanDevolucao beanDevolucao) {
        new DAODevolucao().inserir(beanDevolucao);
    }

    public static void inserirDevolucaoItem(BeanItemDevolucao beanItemDevolucao) {
        new DAOItemDevolucao().inserir(beanItemDevolucao);
    }

    public static void inserirLancamento(BeanLancamento lancamento) {
        new DAOLancamento().inserir(lancamento);
    }

    public static BeanMovimento getMovimentoAnterior(BeanMovimento beanMovimento) {
        DAOMovimento.clausula = " ORDER BY DATA_ABERTURA DESC, COD_MOVIMENTO DESC";
        List<BeanMovimento> lsMovimento = new DAOMovimento().pesquisa(beanMovimento);
        return !lsMovimento.isEmpty() ? lsMovimento.get(0) : null;
    }

    public static BeanVendedor getVendedor(BeanVendedor beanVendedor) {
        List<BeanVendedor> lsVendedor = new DAOVendedor().pesquisa(beanVendedor);
        return !lsVendedor.isEmpty() ? lsVendedor.get(0) : null;
    }

    public static BeanVenda getUltimaVenda(BeanVenda beanVenda, String clausula) {
        DAOVenda.clausula = clausula;
        List<BeanVenda> lsVenda = new DAOVenda().pesquisa(beanVenda);
        return !lsVenda.isEmpty() ? lsVenda.get(0) : null;
    }

    public static String getSenhaOperador(BeanOperador beanOperador) {
        return new DAOOperador().pesquisa(beanOperador).get(0).getSenha();
    }

    public static void inserirSuprimento(BeanSuprimento beanSuprimento) {
        new DAOSuprimento().inserir(beanSuprimento);
    }

    public static void inserirSangria(BeanSangria beanSangria) {
        new DAOSangria().inserir(beanSangria);
    }

    public static void inserirSpedFiscal(BeanSpedFiscal spedFiscal) {
        new DAOSpedFiscal().inserir(spedFiscal);
    }

    public static void inserirSpedFiscalAliquota(BeanSpedFiscalAliquota spedFiscalAliquota) {
        new DAOSpedFiscalAliquota().inserir(spedFiscalAliquota);
    }

    public static void inserirItemVenda(BeanItemVenda itemVenda) {
        new DAOItemVenda().inserir(itemVenda);
    }

    public static void atualizarVenda(BeanVenda vendaNovo, BeanVenda vendaAntigo) {
        new DAOVenda().atualizar(vendaNovo, vendaAntigo);
    }

    public static void atualizarItemVenda(BeanItemVenda itemVendaNovo, BeanItemVenda itemVendaAntigo) {
        new DAOItemVenda().atualizar(itemVendaNovo, itemVendaAntigo);
    }

    public static void atualizarMovimento(BeanMovimento movimento, BeanMovimento movimentoAntigo) {
        new DAOMovimento().atualizar(movimento, movimentoAntigo);
    }

    public static void atualizarDevolucaoUtilizada(BeanDevolucao beanDevolucao, boolean utilizada) {
        new DAODevolucao().atualizarDevolucaoUtilizada(beanDevolucao, utilizada);
    }

    public static BeanFormaCondicaoPagamento getFormaCondicaoPagemento(BeanFormaCondicaoPagamento formaCondicaoPagamento) {
        List<BeanFormaCondicaoPagamento> aux = new DAOFormaCondicaoPagamento().pesquisa(formaCondicaoPagamento);
        if(aux != null && !aux.isEmpty()){
            return aux.get(0);
        }else{
            return null;
        }
    }
}
