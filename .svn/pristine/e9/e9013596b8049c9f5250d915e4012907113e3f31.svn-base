/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

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
import com.sigen.ecf.negocio.util.AbstractController;
import com.sigen.ecf.negocio.util.ICTRLCaixa;
import com.sigen.ecf.view.VIEWCaixa;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Administrador
 */
public class CTRLCaixa extends AbstractController implements ICTRLCaixa {

    public static CTRLCaixa controlCaixa;
    public static CTRLCliente controlCliente;
    public static CTRLCodigoBarra controlCodigoBarra;
    public static CTRLFormaPagamento controlFormaPagamento;
    public static CTRLFormaCondicaoPagamento controlFormaCondicaoPagamento;
    public static CTRLCondicaoPagamento controlCondicaoPagamento;
    public static CTRLMovimento controlMovimento;
    public static CTRLOperador controlOperador;
    public static CTRLVendedor controlVendedor;
    public static CTRLParametro controlParametro;
    public static CTRLProduto controlProduto;
    public static CTRLSangria controlSangria;
    public static CTRLSuprimento controlSuprimento;
    public static CTRLVenda controlVenda;
    public static CTRLVendaDetalhe controlVendaDetalhe;
    public static CTRLFiscal controlFiscal;
    public static CTRLBobina controlBobina;
    /* Tela Caixa*/
    public static VIEWCaixa caixaVIEW;

    public CTRLCaixa() {
        controlCliente = new CTRLCliente();
        controlCodigoBarra = new CTRLCodigoBarra();
        controlFormaPagamento = new CTRLFormaPagamento();
        controlFormaCondicaoPagamento = new CTRLFormaCondicaoPagamento();
        controlCondicaoPagamento = new CTRLCondicaoPagamento();
        controlMovimento = new CTRLMovimento();
        controlOperador = new CTRLOperador();
        controlVendedor = new CTRLVendedor();
        controlParametro = new CTRLParametro();
        controlProduto = CTRLProduto.getInstance();
        controlSangria = new CTRLSangria();
        controlSuprimento = new CTRLSuprimento();
        controlVenda = new CTRLVenda();
        controlVendaDetalhe = new CTRLVendaDetalhe();
        controlFiscal = new CTRLFiscal();
        controlBobina = new CTRLBobina();
        managerUI();
    }

    public static void main(String[] args) {
        controlCaixa = new CTRLCaixa();
        analisarInicioMovimento();
    }

    private static void managerUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }

        // Definição de fontes
        javax.swing.UIManager.put("OptionPane.font", new Font("Dialog", Font.BOLD, 14));
        javax.swing.UIManager.put("OptionPane.messageFont", new Font("Dialog", Font.BOLD, 14));
        javax.swing.UIManager.put("OptionPane.buttonFont", new Font("Dialog", Font.BOLD, 14));
    }

    public static void analisarInicioMovimento() {
        if (controlMovimento.analisarMovimento()) {
            caixaVIEW = new VIEWCaixa();
        } else {
            System.exit(0);
        }
    }

    @Override
    public void analisarMovimento() {
        controlMovimento.analisarMovimento();
    }

    @Override
    public void identificarCliente() {
        controlCliente.identificarCliente();
    }

    @Override
    public List<String> getCabecalhoBobina() {
        return controlBobina.cabecalhoBobina(controlCliente.getCliente());
    }

    @Override
    public void consultarProduto(String codProduto) {
        BeanProduto produto = controlProduto.consultarProduto(codProduto);
        if (produto != null) {
            String q = caixaVIEW.getQuantidade();
            if (controlVenda.venderItem(produto, q)) {
                venderItemTela(produto, q);
            }
        }
    }

    private void venderItemTela(BeanProduto produto, String quantidade) {
        List<String> lsItemVendido = new ArrayList<String>();
        if (caixaVIEW.bobinaVazia()) {
//            caixaVIEW.imprimirCabecalhoBobina();
            caixaVIEW.setLabelMensagem("Venda em andamento...");
        }

        lsItemVendido.add(getItemBobina(produto, controlVenda.getLsProdutoSize()));
        lsItemVendido.add(getItemValorBobina(produto, quantidade));

        caixaVIEW.setLabelDescricaoProduto(produto.getDescricao());
//        caixaVIEW.addElementBobina(lsItemVendido);
        //    caixaVIEW.limparCodigoProduto();
    }

    private String getItemBobina(BeanProduto produto, String item) {
        return controlBobina.getItemBobina(produto, item);
    }

    private void cancelarItemBobina(BeanProduto produto, String itemCancelado) {
        //      caixaVIEW.addElementBobina(controlBobina.cancelarItemBobina(produto, itemCancelado));
    }

    private String getItemValorBobina(BeanProduto produto, String quantidade) {
        BigDecimal totalItem = produto.getPrecoVenda().multiply(new BigDecimal(quantidade));
//        caixaVIEW.setlabelTotalItem(nf.format(totalItem).toString());

        return controlBobina.getItemValorBobina(produto, quantidade, totalItem);
    }

    public void abrirCupom() {
        controlVenda.abrirCupom();
    }

    @Override
    public void cancelarCupom() {
        controlVenda.cancelarCupom();
    }

    @Override
    public void cancelarItem() {
        if (controlMovimento.autenticarLoginGerente()) {
            BeanProduto produtoCancelar = controlVenda.cancelarItemVenda();
            if (produtoCancelar != null) {
                cancelarItemBobina(produtoCancelar, controlVenda.getItemCancelar().toString());
            }
        }
    }

    public void abrirAdministradorTef() {
        // abrir central de administração do módulo de tef
    }

    public void abrirPesquisaProduto() {
        controlProduto.abrirPesquisaProduto();
    }

    @Override
    public List<BeanProduto> pesquisarProduto(BeanProduto beanProduto) {
        return controlProduto.pesquisar(beanProduto);
    }

    @Override
    public void pesquisarPedido() {
        controlVenda.pesquisarPedido();
    }

    @Override
    public void informarVendedor() {
        controlVendedor.consultarVendedor();
    }

    @Override
    public void totalizarVenda(BigDecimal valorCompra, BigDecimal valorDesconto, BigDecimal valorReceber) {
        controlVenda.totalizarVenda(controlCliente.getCliente(), valorCompra, valorDesconto, valorReceber);
    }

    @Override
    public void fecharAplicacao() {
        try {
            // Realizar a saída da aplicação
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fechar aplicação: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void abrirGaveta() {
        //controlImpressora.abrirGaveta();
    }

    @Override
    public void inserirCliente(BeanCliente beanCliente) {
        controlCliente.inserir(beanCliente);
    }

    @Override
    public void atualizarCliente(BeanCliente beanClienteNovo, BeanCliente beanClienteAntigo) {
        controlCliente.atualizar(beanClienteNovo, beanClienteAntigo);
    }

    @Override
    public List<BeanCliente> pesquisaCliente(BeanCliente beanCliente) {
        return controlCliente.pesquisa(beanCliente);
    }

    @Override
    public void removerCliente(BeanCliente beanCliente) {
        controlCliente.remover(beanCliente);
    }

    @Override
    public void inserirCodigoBarra(BeanCodigoBarra beanCodigoBarra) {
        controlCodigoBarra.inserir(beanCodigoBarra);
    }

    @Override
    public void atualizarCodigoBarra(BeanCodigoBarra beanCodigoBarraNovo, BeanCodigoBarra beanCodigoBarraAntigo) {
        controlCodigoBarra.atualizar(beanCodigoBarraNovo, beanCodigoBarraAntigo);
    }

    @Override
    public List<BeanCodigoBarra> pesquisaCodigoBarra(BeanCodigoBarra beanCodigoBarra) {
        return controlCodigoBarra.pesquisa(beanCodigoBarra);
    }

    @Override
    public void removerCodigoBarra(BeanCodigoBarra beanCodigoBarra) {
        controlCodigoBarra.remover(beanCodigoBarra);
    }

    @Override
    public void confirmarSelecaoFormaPagamento(BeanFormaPagamento beanFormaPagamento) {
        controlFormaPagamento.confirmarSelecaoFormaPagamento(beanFormaPagamento);
    }

    @Override
    public void inserirMovimento(BeanMovimento beanMovimento) {
        controlMovimento.inserir(beanMovimento);
    }

    @Override
    public void atualizarMovimento(BeanMovimento beanMovimentoNovo, BeanMovimento beanMovimentoAntigo) {
        controlMovimento.atualizar(beanMovimentoNovo, beanMovimentoAntigo);
    }

    @Override
    public List<BeanMovimento> pesquisaMovimento(BeanMovimento beanMovimento) {
        return controlMovimento.pesquisa(beanMovimento);
    }

    @Override
    public void removerMovimento(BeanMovimento beanMovimento) {
        controlMovimento.remover(beanMovimento);
    }

    @Override
    public void inserirVendedor(BeanVendedor beanVendedor) {
        controlVendedor.inserir(beanVendedor);
    }

    @Override
    public void atualizarVendedor(BeanVendedor beanVendedorNovo, BeanVendedor beanVendedorAntigo) {
        controlVendedor.atualizar(beanVendedorNovo, beanVendedorAntigo);
    }

    @Override
    public List<BeanVendedor> pesquisaVendedor(BeanVendedor beanVendedor) {
        return controlVendedor.pesquisar(beanVendedor);
    }

    @Override
    public void removerVendedor(BeanVendedor beanVendedor) {
        controlVendedor.remover(beanVendedor);
    }

    @Override
    public void inserirOperador(BeanOperador beanOperador) {
        controlOperador.inserir(beanOperador);
    }

    @Override
    public void atualizarOperador(BeanOperador beanOperadorNovo, BeanOperador beanOperadorAntigo) {
        controlOperador.atualizar(beanOperadorNovo, beanOperadorAntigo);
    }

    public static List<BeanOperador> pesquisaOperador(BeanOperador beanOperador) {
        return controlOperador.pesquisar(beanOperador, false);
    }

    public static List<BeanOperador> pesquisaSupervisor(BeanOperador beanOperador) {
        return controlOperador.pesquisar(beanOperador, true);
    }

    @Override
    public void removerOperador(BeanOperador beanOperador) {
        controlOperador.remover(beanOperador);
    }

    @Override
    public void inserirParametro(BeanParametro beanParametro) {
        controlParametro.inserir(beanParametro);
    }

    @Override
    public void atualizarParametro(BeanParametro beanParametroNovo, BeanParametro beanParametroAntigo) {
        controlParametro.atualizar(beanParametroNovo, beanParametroAntigo);
    }

    @Override
    public List<BeanParametro> pesquisaParametro(BeanParametro beanParametro) {
        return controlParametro.pesquisa(beanParametro);
    }

    @Override
    public void removerParametro(BeanParametro beanParametro) {
        controlParametro.remover(beanParametro);
    }

    @Override
    public void inserirProduto(BeanProduto beanProduto) {
        controlProduto.inserir(beanProduto);
    }

    @Override
    public void atualizarProduto(BeanProduto beanProdutoNovo, BeanProduto beanProdutoAntigo) {
        controlProduto.atualizar(beanProdutoNovo, beanProdutoAntigo);
    }

    @Override
    public void removerProduto(BeanProduto beanProduto) {
        controlProduto.remover(beanProduto);
    }

    @Override
    public void inserirSangria(BeanSangria beanSangria) {
        controlSangria.inserir(beanSangria);
    }

    @Override
    public void atualizarSangria(BeanSangria beanSangriaNovo, BeanSangria beanSangriaAntigo) {
        controlSangria.atualizar(beanSangriaNovo, beanSangriaAntigo);
    }

    @Override
    public List<BeanSangria> pesquisaSangria(BeanSangria beanSangria) {
        return controlSangria.pesquisa(beanSangria);
    }

    @Override
    public void removerSangria(BeanSangria beanSangria) {
        controlSangria.remover(beanSangria);
    }

    @Override
    public void inserirSuprimento(BeanSuprimento beanSuprimento) {
        controlSuprimento.inserir(beanSuprimento);
    }

    @Override
    public void atualizarSuprimento(BeanSuprimento beanSuprimentoNovo, BeanSuprimento beanSuprimentoAntigo) {
        controlSuprimento.atualizar(beanSuprimentoNovo, beanSuprimentoAntigo);
    }

    @Override
    public List<BeanSuprimento> pesquisaSuprimento(BeanSuprimento beanSuprimento) {
        return controlSuprimento.pesquisa(beanSuprimento);
    }

    @Override
    public void removerSuprimento(BeanSuprimento beanSuprimento) {
        controlSuprimento.remover(beanSuprimento);
    }

    @Override
    public void inserirVenda(BeanVenda beanVenda) {
        controlVenda.inserir(beanVenda);
    }

    @Override
    public void atualizarVenda(BeanVenda beanVendaNovo, BeanVenda beanVendaAntigo) {
        controlVenda.atualizar(beanVendaNovo, beanVendaAntigo);
    }

    @Override
    public List<BeanVenda> pesquisaVenda(BeanVenda beanVenda) {
        return controlVenda.pesquisa(beanVenda);
    }

    @Override
    public void removerVenda(BeanVenda beanVenda) {
        controlVenda.remover(beanVenda);
    }

    @Override
    public void inserirVendaDetalhe(BeanItemVenda beanVendaDetalhe) {
        controlVendaDetalhe.inserir(beanVendaDetalhe);
    }

    @Override
    public void atualizarVendaDetalhe(BeanItemVenda beanVendaDetalheNovo, BeanItemVenda beanVendaDetalheAntigo) {
        controlVendaDetalhe.atualizar(beanVendaDetalheNovo, beanVendaDetalheAntigo);
    }

    @Override
    public List<BeanItemVenda> pesquisaVendaDetalhe(BeanItemVenda beanVendaDetalhe) {
        return controlVendaDetalhe.pesquisar(beanVendaDetalhe);
    }

    @Override
    public void removerVendaDetalhe(BeanItemVenda beanVendaDetalhe) {
        controlVendaDetalhe.remover(beanVendaDetalhe);
    }

    public void abrirSubMenu() {
    }

    @Override
    public void encerrarMovimento() {
        controlMovimento.encerrarMovimento();
    }

    @Override
    public void emitirPosicaoCaixa() {
        controlFiscal.emitirPosicaoCaixa();
    }

    @Override
    public void efetuarSuprimento() {
        controlSuprimento.efetuarSuprimento();
    }

    @Override
    public void efetuarSangria() {
        controlSangria.efetuarSangria();
    }

    @Override
    public void efetuarRecarga() {
        controlFiscal.efetuarRecarga();
    }

    @Override
    public void emitirReducaoZ() {
        controlFiscal.emitirReducaoZ();
    }

    @Override
    public void consultarCliente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void abrirConfiguracoes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void emitirLeituraX() {
        controlFiscal.emitirLeituraX();
    }

    @Override
    public void emitirLMFC() {
        controlFiscal.emitirLMFC();
    }

    @Override
    public void emitirLMFS() {
        controlFiscal.emitirLMFS();
    }

    @Override
    public void gerarEspelhoMFD() {
        controlFiscal.gerarEspelhoMFD();
    }

    @Override
    public void gerarArquivoMFD() {
        controlFiscal.gerarTabelaProdutos();
    }

    @Override
    public void gerarTabelaProdutos() {
        controlFiscal.gerarArquivoMFD();
    }

    @Override
    public void gerarArquivoEstoque() {
        controlFiscal.gerarArquivoEstoque();
    }

    @Override
    public void gerarMovimentoECF() {
        controlFiscal.gerarMeiosPagamento();
    }

    @Override
    public void gerarMeiosPagamento() {
        controlFiscal.gerarArquivoMFD();
    }

    @Override
    public void gerarDavEmitidos() {
        controlFiscal.gerarDavEmitidos();
    }

    @Override
    public void gerarIdentificacaoPafECF() {
        controlFiscal.gerarIdentificacaoPafECF();
    }

    @Override
    public void gerarVendasPeriodo() {
        controlFiscal.gerarVendasPeriodo();
    }

    @Override
    public void gerarIndiceTecnicoProducao() {
        controlFiscal.gerarIndiceTecnicoProducao();
    }

    @Override
    public void gerarParametrosConfiguracao() {
        controlFiscal.gerarParametrosConfiguracao();
    }
}
