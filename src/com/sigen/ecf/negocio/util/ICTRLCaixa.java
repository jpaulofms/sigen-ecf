/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.util;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanCodigoBarra;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.model.bean.BeanParametro;
import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.model.bean.BeanSangria;
import com.sigen.ecf.model.bean.BeanSuprimento;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.model.bean.BeanVendedor;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ICTRLCaixa {

    // Caixa telas
    public void consultarProduto(String codProduto);

    public void analisarMovimento();

    public List<String> getCabecalhoBobina();

    public void encerrarMovimento();

    public void emitirPosicaoCaixa();

    public void efetuarSuprimento();

    public void efetuarSangria();

    public void efetuarRecarga();

    public void emitirReducaoZ();

    public void consultarCliente();

    public void abrirConfiguracoes();

    public void emitirLeituraX();

    public void emitirLMFC();

    public void emitirLMFS();

    public void gerarEspelhoMFD();

    public void gerarArquivoMFD();

    public void gerarTabelaProdutos();

    public void gerarArquivoEstoque();

    public void gerarMovimentoECF();

    public void gerarMeiosPagamento();

    public void gerarDavEmitidos();

    public void gerarIdentificacaoPafECF();

    public void gerarVendasPeriodo();

    public void gerarIndiceTecnicoProducao();

    public void gerarParametrosConfiguracao();

    //public void ocultarMenusCaixa();
    public void identificarCliente();

    public void cancelarCupom();

    public void cancelarItem();

    public List<BeanProduto> pesquisarProduto(BeanProduto beanProduto);

    public void totalizarVenda(BigDecimal valorCompra, BigDecimal valorDesconto, BigDecimal valorReceber);

    public void fecharAplicacao();

    public void pesquisarPedido();

    // Cliente
    public void inserirCliente(BeanCliente beanCliente);

    public void atualizarCliente(BeanCliente beanClienteNovo, BeanCliente beanClienteAntigo);

    public List<BeanCliente> pesquisaCliente(BeanCliente beanCliente);

    public void removerCliente(BeanCliente beanCliente);

    // CodigoBarra
    public void inserirCodigoBarra(BeanCodigoBarra beanCodigoBarra);

    public void atualizarCodigoBarra(BeanCodigoBarra beanCodigoBarraNovo, BeanCodigoBarra beanCodigoBarraAntigo);

    public List<BeanCodigoBarra> pesquisaCodigoBarra(BeanCodigoBarra beanCodigoBarra);

    public void removerCodigoBarra(BeanCodigoBarra beanCodigoBarra);

    public void confirmarSelecaoFormaPagamento(BeanFormaPagamento beanFormaPagamento);

    // Movimento
    public void inserirMovimento(BeanMovimento beanMovimento);

    public void atualizarMovimento(BeanMovimento beanMovimentoNovo, BeanMovimento beanMovimentoAntigo);

    public List<BeanMovimento> pesquisaMovimento(BeanMovimento beanMovimento);

    public void removerMovimento(BeanMovimento beanMovimento);

    // Operador
    public void inserirOperador(BeanOperador beanOperador);

    public void atualizarOperador(BeanOperador beanOperadorNovo, BeanOperador beanOperadorAntigo);

    //public List<BeanOperador> pesquisaOperador(BeanOperador beanOperador);
    //public List<BeanOperador> pesquisaSupervisor(BeanOperador beanOperador);
    public void removerOperador(BeanOperador beanOperador);

    // Parametro
    public void inserirParametro(BeanParametro beanParametro);

    public void atualizarParametro(BeanParametro beanParametroNovo, BeanParametro beanParametroAntigo);

    public List<BeanParametro> pesquisaParametro(BeanParametro beanParametro);

    public void removerParametro(BeanParametro beanParametro);

    // Produto
    public void inserirProduto(BeanProduto beanProduto);

    public void atualizarProduto(BeanProduto beanProdutoNovo, BeanProduto beanProdutoAntigo);

    public void removerProduto(BeanProduto beanProduto);

    // Sangria
    public void inserirSangria(BeanSangria beanSangria);

    public void atualizarSangria(BeanSangria beanSangriaNovo, BeanSangria beanSangriaAntigo);

    public List<BeanSangria> pesquisaSangria(BeanSangria beanSangria);

    public void removerSangria(BeanSangria beanSangria);

    // Suprimento
    public void inserirSuprimento(BeanSuprimento beanSuprimento);

    public void atualizarSuprimento(BeanSuprimento beanSuprimentoNovo, BeanSuprimento beanSuprimentoAntigo);

    public List<BeanSuprimento> pesquisaSuprimento(BeanSuprimento beanSuprimento);

    public void removerSuprimento(BeanSuprimento beanSuprimento);

    // Venda
    public void inserirVenda(BeanVenda beanVenda);

    public void atualizarVenda(BeanVenda beanVendaNovo, BeanVenda beanVendaAntigo);

    public List<BeanVenda> pesquisaVenda(BeanVenda beanVenda);

    public void removerVenda(BeanVenda beanVenda);

    // VendaDetalhe
    public void inserirVendaDetalhe(BeanItemVenda beanVendaDetalhe);

    public void atualizarVendaDetalhe(BeanItemVenda beanVendaDetalheNovo, BeanItemVenda beanVendaDetalheAntigo);

    public List<BeanItemVenda> pesquisaVendaDetalhe(BeanItemVenda beanVendaDetalhe);

    public void removerVendaDetalhe(BeanItemVenda beanVendaDetalhe);

    // Vendedor
    public void inserirVendedor(BeanVendedor beanVendedor);

    public void atualizarVendedor(BeanVendedor beanVendedorNovo, BeanVendedor beanVendedorAntigo);

    public List<BeanVendedor> pesquisaVendedor(BeanVendedor beanVendedor);

    public void removerVendedor(BeanVendedor beanVendedor);

    public void informarVendedor();
}
