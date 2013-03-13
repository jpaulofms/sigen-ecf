/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.main;

import java.awt.Font;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.TEFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.infra.impl.TEFServiceFactory;
import com.sigen.ecf.infra.sync.SigenECFSincImporta;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.model.operacao.OperacaoFactory;
import com.sigen.ecf.persistencia.DAOFacade;
import com.sigen.ecf.view.VIEWCaixa;
import com.sigen.ecf.view.VIEWLoginIniciarMovimento;
import com.sigen.ecf.view.VIEWLoginIniciarMovimentoAberto;

/**
 * @author SIGEN 3
 */
public class SigenApplication {

	private static Map parametros = new HashMap();

	private static TEFService tefService;

	public static void main(String[] args) throws FileNotFoundException {

		System.setOut(new PrintStream(new BufferedOutputStream(
				new FileOutputStream(new File("console"))), true));
		System.setErr(new PrintStream(new BufferedOutputStream(
				new FileOutputStream(new File("erros"))), true));

		configuracaoFontes();
		movimentoAbertura();
	}

	private static void configuracaoFontes() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
		}

		// Definição de fontes
		javax.swing.UIManager.put("OptionPane.font", new Font("Dialog",
				Font.BOLD, 14));
		javax.swing.UIManager.put("OptionPane.messageFont", new Font("Dialog",
				Font.BOLD, 14));
		javax.swing.UIManager.put("OptionPane.buttonFont", new Font("Dialog",
				Font.BOLD, 14));
	}

	private static void movimentoAbertura() {
		try {

			tefService = TEFServiceFactory.getInstance().criarTEFService();

			/* Estado impressora */
			IECFService eCFService = ECFServiceFactory.getInstance()
					.criarECFService();
			if (!eCFService.getECFAtiva()) {
				JOptionPane.showMessageDialog(null,
						"ECF desligada/não encontrada. Sistema será fechado",
						"Estado ECF", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}

			// Verifica se existe alguma atualização dos dados do ERP para o ECF
			SigenECFSincImporta importarDados = new SigenECFSincImporta();
			importarDados.verificarAtualizacaoDados();

			String codEcf = eCFService.getECF();
			String loja = eCFService.getLoja();

			/* Verificar e cancelar operações TEF Pendentes */
			verificaPendente();

			BeanMovimento beanMovimento = new BeanMovimento();
			beanMovimento.setDataAbertura(eCFService.getData());
			beanMovimento.setCodEcf(codEcf);
			beanMovimento.setLoja(loja);
			String clausula = "ORDER BY CAST(COD_MOVIMENTO AS INTEGER) DESC , DATA_ABERTURA DESC, COO DESC";

			parametros.put("codEcf", codEcf);
			parametros.put("loja", loja);

			/* Pesquisa movimentos do dia ordenado pelo código do movimento */
			List<BeanMovimento> lsMovimentoDia = DAOFacade.getLsMovimento(
					beanMovimento, clausula);

			if (lsMovimentoDia.isEmpty()
					|| (!lsMovimentoDia.isEmpty() && lsMovimentoDia.get(0)
							.getDataFechamento() != null)) {
				BeanMovimento movimentoAnterior = DAOFacade
						.getMovimentoAnterior(new BeanMovimento());
				parametros.put("BeanMovimento", movimentoAnterior);
				parametros = iniciarMovimento(parametros);
			} else {
				parametros.put("BeanMovimento", lsMovimentoDia.get(0));
				parametros = movimentoAberto(parametros);
			}

			/* Recuperar venda aberta não finalizada */
			if (!recuperarVenda()) {
				/* Cancelar Venda Aberta */
				if (eCFService.getECFCupomAberto()) {
					JOptionPane.showMessageDialog(null,
							"Existe um cupom aberto que será cancelado",
							"Estado ECF", JOptionPane.WARNING_MESSAGE);
					eCFService.cancelaCupom();
				}
			}

			/* Ações */
			Operacao abrirAplicacao = OperacaoFactory.getInstance()
					.criarOPAbrirAplicacao();
			parametros = abrirAplicacao.executar(parametros);

			/* inicia caixa */
			VIEWCaixa caixaVIEW = new VIEWCaixa();
			caixaVIEW.setLabelOperador((BeanOperador) parametros
					.get("BeanOperador"));
			caixaVIEW.setMapParametros(parametros);
			caixaVIEW.setVisible(true);
		} catch (Exception ex) {
			TratamentoException.tratar(ex);
		}
	}

	private static Map iniciarMovimento(Map parametros) {
		/* Abrir Movimento */
		VIEWLoginIniciarMovimento loginIniciarMovimento = new VIEWLoginIniciarMovimento(
				null, true, parametros);
		loginIniciarMovimento.setVisible(true);
		parametros = loginIniciarMovimento.getParametros();

		return parametros;
	}

	private static Map movimentoAberto(Map parametros) {
		/* Movimento Aberto */
		VIEWLoginIniciarMovimentoAberto iniciarMovimentoAberto = new VIEWLoginIniciarMovimentoAberto(
				null, true, parametros, false);
		iniciarMovimentoAberto.setVisible(true);
		if (iniciarMovimentoAberto.cancelado) {
			System.exit(0);
		}
		Map mpRetorno = iniciarMovimentoAberto.getParametros();

		/* Necessidade de Operação ?? */

		return mpRetorno;
	}

	private static void verificaPendente() {
		try {
			if (tefService.verificaGerenciadorPadrao(true)) {
				if (tefService.verificaTefPendentes()) {
					JOptionPane.showMessageDialog(null,
							"Existem movimento TEF não Impressos ou Confirmados.\n"
									+ "Será necessario cancelá-los.",
							"Aviso do Sistema", JOptionPane.ERROR_MESSAGE);

					if (!tefService.cancelaTefPendentes()) {
						JOptionPane.showMessageDialog(null,
								"Erro no Cancelamento dos TEF pendentes\n"
										+ "O Sistema será encerrado!.",
								"Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
			} else {
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static boolean recuperarVenda() {
		/* Futuramente pode ser parametrizado isso ? */
		try {
			String codEcf = (String) parametros.get("codEcf");
			String loja = (String) parametros.get("loja");
			BeanMovimento movimento = (BeanMovimento) parametros
					.get("BeanMovimento");

			BeanVenda vendaNaoFinalizada = new BeanVenda();
			vendaNaoFinalizada.setCodEcf(codEcf);
			vendaNaoFinalizada.setLoja(loja);
			vendaNaoFinalizada.setCodMov(movimento.getCodMov());
			vendaNaoFinalizada.setIndicadorCancelamento("N");

			vendaNaoFinalizada.setCoo(ECFServiceFactory.getInstance()
					.criarECFService().getCOO());

			String clausula = " ORDER BY CAST(COD_MOVIMENTO AS INTEGER) DESC";
			vendaNaoFinalizada = DAOFacade.getUltimaVenda(vendaNaoFinalizada,
					clausula);

			if (vendaNaoFinalizada == null
					|| vendaNaoFinalizada.getValorTotal().compareTo(
							BigDecimal.ZERO) > 0) {
				return false;
			}

			String[] opcoes = { "Sim", "Não" };
			int escolha = JOptionPane
					.showOptionDialog(
							null,
							"Existe uma venda que não foi finalizada, deseja tentar recuperá-la ?",
							"Recuperação de Venda", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
			if (escolha == JOptionPane.NO_OPTION) {
				BeanVenda vendaNovo = vendaNaoFinalizada.clone();
				vendaNovo.setIndicadorCancelamento("S");
				DAOFacade.atualizarVenda(vendaNovo, vendaNaoFinalizada);
				return false;
			}

			/* Ações */
			IECFService eCFService = ECFServiceFactory.getInstance()
					.criarECFService();

			// Adicionar ao map para ser recuperada no caixa
			parametros.put("CupomRecuperarAberto",
					eCFService.getECFCupomAberto());
			parametros.put("BeanVendaRecuperar", vendaNaoFinalizada);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Erro na recuperação da venda. Cupom será cancelado",
					"Recuperação de Venda", JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}
}
