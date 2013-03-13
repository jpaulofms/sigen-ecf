/**
 * <p>Title: SIGEN</p> <p>Description: PAF-ECF + TEF - Classe de controle do
 * TEF.</p>
 */
package com.sigen.ecf.infra.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import nlink.win32.DllClass;
import nlink.win32.DllMethod;

import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.TEFService;
import com.sigen.ecf.view.util.EchoClienteVeSPague;
import com.sigen.ecf.view.util.UTILBiblioteca;
import com.sigen.ecf.vo.VOTef;
import com.sigen.ecf.vo.VOTransacaoTef;

//import nlink.win32.NLink;

public class TefForegroundService implements TEFService {

	@DllClass
	public interface User32 {

		@DllMethod
		int BlockInput(boolean fBlock);
	}

	private static IECFService eCFService = ECFServiceFactory.getInstance()
			.criarECFService();
	// Variáveis de controle
	public static String NSU, nomeRede, data, hora, identificacao, valor;
	public static boolean relatorioGerencial;
	private static boolean transacaoAprovada = false;
	private static String conteudoArquivo, linhaArquivo, campoArquivo, linha;
	// Arquivos de controle
	public static File arquivoRetornoTransacao = new File(
			System.getProperty("user.dir") + "\\retornotransacao.001");
	public static File arquivoImprimeTxt = new File(
			System.getProperty("user.dir") + "\\imprime.txt");
	public static File arquivoTefTxt = new File(System.getProperty("user.dir")
			+ "\\tef.txt");
	public static File arquivoPendenteTxt = new File(
			System.getProperty("user.dir") + "\\pendente.txt");
	/* Controle de buffer */
	private static int numSequencial = 1;
	private static boolean isSucess = false;
	private static boolean imprimirComprovante = false;
	private static List<String> aImpressaoComprovante;
	private static String comprovanteImpressao = "";
	private static int totalLinhas = 0;

	/* Formatação */
	static NumberFormat formatter = new DecimalFormat("#,###,##0.00");
	static NumberFormat formataTef = new DecimalFormat("0.00");
	static SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");

	/**
	 * Realiza a transação TEF.
	 * 
	 * @param pIdentificacao
	 *            identificação da transação
	 * @param pNumeroCupom
	 *            número do cupom fiscal - COO
	 * @param pValorPago
	 *            valor da transação
	 * @param pNumeroTransacao
	 *            número da transação
	 * @return 0 = GP INATIVO / 1 = OK / -1 = FAIL
	 */
	public void analisaiRetorno(int iRetorno) {
		try {
			switch (iRetorno) {
			// case 0:
			// throw new Exception("Com confirmação da Automação.");
			// case 1:
			// throw new Exception("Sem confirmação da Automação.");
			case 2:
				// TROCAR NÚMERO SEQUENCIAL
				// throw new Exception("Sequencial Inválido.");
				break;
			case 3:
				// throw new Exception("Transação cancelada pelo operador.");
				break;
			case 4:
				throw new Exception("Transação cancelada pelo cliente.");
			case 5:
				throw new Exception("Parâmetros insuficientes ou inválidos");
			case 6:
				throw new Exception(
						"Problemas de Comunicação com o VeSPagueServer");
			case 7:
				throw new Exception("Problemas de Comunicação com a rede");
			case 8:
				throw new Exception("Tempo limite de espera excedido.");
			case 9:
				throw new Exception("Problema desconhecido;");
			default:
				;
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	private void linhasComprovanteImpressao(String linhaRetorno) {
		// Linhas comprovante impressao
		if (linhaRetorno.contains("transacao_comprovante_1via")
				|| linhaRetorno.contains("transacao_comprovante_2via")
				|| linhaRetorno.contains("transacao_comprovante_resumido")) {
			imprimirComprovante = true;
		}

		if (imprimirComprovante
				&& (linhaRetorno.contains("transacao_") || (linhaRetorno
						.contains("\"")))
				&& !linhaRetorno.contains("transacao_comprovante_2via")
				&& !linhaRetorno.contains("transacao_comprovante_1via")
				&& !linhaRetorno.contains("transacao_comprovante_resumido")) {
			imprimirComprovante = false;
		}

		if (imprimirComprovante) {
			if (linhaRetorno.contains("transacao_comprovante_1via")) { // 27 com
																		// o =
				String linhaComprovante = linhaRetorno.substring(
						linhaRetorno.indexOf("\""), linhaRetorno.length() - 1)
						.replace("\"", "");
				aImpressaoComprovante.add("\r\n");
				comprovanteImpressao = UTILBiblioteca
						.getLinhaCentralizada(linhaComprovante);
				totalLinhas = 1;
			} else if (linhaRetorno.contains("transacao_comprovante_2via")) { // 27
																				// com
																				// o
																				// =
				if (!comprovanteImpressao.equals("")) {
					aImpressaoComprovante.add(comprovanteImpressao);
				}
				aImpressaoComprovante.add(getPontoDeCorte());
				String linhaComprovante = linhaRetorno.substring(
						linhaRetorno.indexOf("\""), linhaRetorno.length() - 1)
						.replace("\"", "");
				comprovanteImpressao = comprovanteImpressao = UTILBiblioteca
						.getLinhaCentralizada(linhaComprovante);
				totalLinhas = 1;
			} else if (linha.contains("transacao_comprovante_resumido")) { // 31
																			// com
																			// o
																			// =
				if (!comprovanteImpressao.equals("")) {
					aImpressaoComprovante.add(comprovanteImpressao);
				}
				aImpressaoComprovante.add("");
				String linhaComprovante = linhaRetorno.substring(
						linhaRetorno.indexOf("\""), linhaRetorno.length() - 1)
						.replace("\"", "");
				comprovanteImpressao = UTILBiblioteca
						.getLinhaCentralizada(linhaComprovante);
				totalLinhas = 1;
			} else {
				comprovanteImpressao += UTILBiblioteca
						.getLinhaCentralizada(linhaRetorno);
				totalLinhas++;
			}

			if (totalLinhas == 4) {
				aImpressaoComprovante.add(comprovanteImpressao);
				totalLinhas = 0;
				comprovanteImpressao = "";
			}
		}
	}

	private String getPontoDeCorte() {
		String pontoCorte = "CORTE AQUI";
		BigDecimal n = new BigDecimal(String.valueOf(48 - pontoCorte.length()));
		n = n.divide(new BigDecimal(2d))
				.setScale(2, BigDecimal.ROUND_HALF_DOWN);

		return UTILBiblioteca.repete("-", n.intValue()).concat(pontoCorte)
				.concat(UTILBiblioteca.repete("-", n.intValue() - 1))
				.concat("\r\n");
	}

	public int lerRetornoTransacao(String pIdentificacao) {
		String retornoTransacao = "";
		int result = -2;
		// User32 user32 = NLink.create(User32.class);
		aImpressaoComprovante = new ArrayList<String>();
		comprovanteImpressao = "";

		try {
			FileReader leitura = new FileReader(arquivoRetornoTransacao);
			BufferedReader entrada = new BufferedReader(leitura);

			while ((linhaArquivo = entrada.readLine()) != null) {

				// analisaiRetorno
				if (linhaArquivo.contains("=")
						&& linhaArquivo.substring(0, linhaArquivo.indexOf("="))
								.equals("retorno")) {
					retornoTransacao = linhaArquivo.substring(
							linhaArquivo.indexOf("\""),
							linhaArquivo.length() - 1).replace("\"", "");

					if (retornoTransacao.equals("0")
							|| retornoTransacao.equals("1")) {
						transacaoAprovada = true;
						result = 1;
					} else {
						transacaoAprovada = false;
						result = -1;
						break;
					}
				}

				if (linhaArquivo.contains("=")
						&& linhaArquivo.substring(0, linhaArquivo.indexOf("="))
								.equals("transacao_nsu")) {
					TefForegroundService.NSU = linhaArquivo.substring(
							linhaArquivo.indexOf("\""),
							linhaArquivo.length() - 1).replace("\"", "");
					copyFile(arquivoRetornoTransacao,
							new File(System.getProperty("user.dir")
									+ "\\intpos" + TefForegroundService.NSU
									+ ".001"));
				}
				if (linhaArquivo.contains("=")
						&& linhaArquivo.substring(0, linhaArquivo.indexOf("="))
								.equals("transacao_rede")) {
					TefForegroundService.nomeRede = linhaArquivo.substring(
							linhaArquivo.indexOf("\""),
							linhaArquivo.length() - 1).replace("\"", "");
				}
				if (linhaArquivo.contains("=")
						&& linhaArquivo.substring(0, linhaArquivo.indexOf("="))
								.equals("transacao_data")) {
					TefForegroundService.data = linhaArquivo.substring(16, 26);
					TefForegroundService.hora = linhaArquivo.substring(27,
							linhaArquivo.length() - 1);
				}

				// Linhas Comprovante
				try {
					linhasComprovanteImpressao(linhaArquivo);
					result = 1;
				} catch (Exception e) {
					result = -1;
				}

				linha = linha + (char) 13 + (char) 10 + (char) 13 + (char) 10
				// + " . . . . . . . . . . . . . . . . . . . . . . . . "
						+ (char) 13 + (char) 10 + (char) 13 + (char) 10;

				// linha += linhas2Via;

				if (linhaArquivo.contains("=")
						&& linhaArquivo.substring(0, linhaArquivo.indexOf("="))
								.equals("mensagem")) {
					// user32.BlockInput(true);
					/*
					 * Mensagem msg = new Mensagem(null, true, true, 1000);
					 * //verifica se tem alguma linha para ser impressa //se
					 * tiver exibe mensagem se ok, no minimo 5 segundos if
					 * ((!linha.equals("")) && (result == 1)) {
					 * Caixa.setTextoMensagem
					 * (linhaArquivo.substring(linhaArquivo.indexOf("\""),
					 * linhaArquivo.length() - 1));
					 * msg.setMensagem(linhaArquivo.
					 * substring(linhaArquivo.indexOf("\""),
					 * linhaArquivo.length() - 1));
					 * msg.setLocationRelativeTo(null); msg.setVisible(true); }
					 * else { //exibe mensagem com OK user32.BlockInput(false);
					 * ExibirMensagemDialog mensagem = new
					 * ExibirMensagemDialog(Caixa.getCaixa(), true,
					 * linhaArquivo.substring(linhaArquivo.indexOf("\""),
					 * linhaArquivo.length() - 1)); mensagem.setVisible(true);
					 * result = -1; }
					 */
					// user32.BlockInput(false);
				}
			} // Fim while not EOF

			if (comprovanteImpressao != null
					&& !comprovanteImpressao.equals("")
					&& !comprovanteImpressao.equals("\"\r\n")) {
				aImpressaoComprovante.add(comprovanteImpressao);
			}

			entrada.close();
			leitura.close();
		} catch (IOException e) {
			// user32.BlockInput(false);
			// e.printStackTrace();
		}

		/* Gravar Arquivo de Impressão */
		gravarArquivoImpressao();

		if (!transacaoAprovada
				|| (!retornoTransacao.equals("0") && !retornoTransacao
						.equals("1"))) {
			result = -1;
		}

		return result;
	}

	private void gravarArquivoImpressao() {
		/* Gravar arquivo de impressão */
		if (aImpressaoComprovante != null && !aImpressaoComprovante.isEmpty()) {
			try {
				String comprovante = "";
				for (String s : aImpressaoComprovante) {
					comprovante += s + "\r\n";
				}

				FileWriter gravar = new FileWriter(new File(
						System.getProperty("user.dir") + "\\imprime"
								+ TefForegroundService.NSU.toString() + ".txt"));
				PrintWriter saida = new PrintWriter(gravar);
				saida.println(comprovante);
				saida.close();
				gravar.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void analisaComandoRetorno(StringBuilder comandoRetorno) {

		System.out.println(comandoRetorno);

		boolean mudarSequencial = false;
		linha = "";
		String guardarSequencialRetorno = "";

		Scanner scan = new Scanner(comandoRetorno.toString());
		while (scan.hasNextLine()) {
			linha = scan.nextLine();

			// analisaiRetorno
			if (linha.contains("retorno")) {
				String retorno = linha.substring(linha.indexOf("\""),
						linha.length() - 1).replace("\"", "");
				// String[] retorno = linha.split("\"");
				analisaiRetorno(Integer.parseInt(retorno));
				if (retorno.equals("2")) {
					mudarSequencial = true;
				}

				if (retorno.equals("0") || retorno.equals("1")) {
					isSucess = true;
				}
			}

			// MudarSequencial
			if (linha.contains("sequencial")) {
				guardarSequencialRetorno = linha.substring(linha.indexOf("\""),
						linha.length() - 1).replace("\"", "");
			}
			if (mudarSequencial) {
				setNumSequencial(Integer.parseInt(guardarSequencialRetorno));
			}
		}
	}

	public void gravarArquivoRetorno(StringBuilder r) {
		try {
			// Formata arquivo INTPOS.001 para solicitar a transação TEF
			conteudoArquivo = r.toString();

			FileWriter gravar = new FileWriter(arquivoRetornoTransacao);

			PrintWriter saida = new PrintWriter(gravar);
			saida.println(conteudoArquivo);
			saida.close();
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void iniciarServico() {
		// PEGAR VERSÃO DA AUTOMAÇÃO
		// String identificaVersao = Caixa.versaoAutomacao;
		String identificaVersao = "1.0";
		// TIPO RETORNO, 0 = COM CONFIRMAÇÃO 1 = SEM CONFIRMAÇÃO
		String numRetorno = "1";
		isSucess = false;
		StringBuilder comandoRetorno = new StringBuilder();

		while (!isSucess) {

			// INICIAR COMUNICAÇÃO
			StringBuilder comandoEnvio = new StringBuilder();

			comandoEnvio.append("versao=\"" + identificaVersao + "\"").append(
					"\r\n");
			comandoEnvio.append("sequencial=\"" + getNumSequencial() + "\"")
					.append("\r\n");
			comandoEnvio.append("retorno=\"" + numRetorno + "\"")
					.append("\r\n");
			comandoEnvio.append("servico=\"iniciar\"").append("\r\n");
			comandoEnvio.append(
					"aplicacao=\"SIGEN - SISTEMAS DE GESTAO DE NEGOCIOS\"")
					.append("\r\n");

			try {
				FileOutputStream saida = new FileOutputStream(arquivoTefTxt,
						true);
				PrintStream p = new PrintStream(saida);
				p.println(comandoEnvio.toString());
				p.close();

			} catch (IOException io) {
				io.printStackTrace();
			}

			comandoRetorno = EchoClienteVeSPague.enviaComando(comandoEnvio);

			analisaComandoRetorno(comandoRetorno);
		}
		gravarArquivoRetorno(comandoRetorno);

		if (arquivoTefTxt.exists()) {
			arquivoTefTxt.delete();
		}
	}

	public void fecharServico() {
		// numSequencial++;
		// TIPO RETORNO, 0 = COM CONFIRMAÇÃO 1 = SEM CONFIRMAÇÃO
		String numRetorno = "1";

		// INICIAR COMUNICAÇÃO
		StringBuilder comandoEnvio = new StringBuilder();

		comandoEnvio.append("sequencial=\"" + getNumSequencial() + "\"");
		comandoEnvio.append("retorno=\"" + numRetorno + "\"");
		comandoEnvio.append("servico=\"finalizar\"");

		try {
			FileOutputStream saida = new FileOutputStream(arquivoTefTxt, true);
			PrintStream p = new PrintStream(saida);
			p.println(comandoEnvio.toString());
			p.close();

		} catch (IOException io) {
			io.printStackTrace();
		}

		StringBuilder comandoRetorno = EchoClienteVeSPague
				.enviaComando(comandoEnvio);

		analisaComandoRetorno(comandoRetorno);

		if (arquivoTefTxt.exists()) {
			arquivoTefTxt.delete();
		}
	}

	public List<String> consultaTransacao() {
		List<String> transacoes = new ArrayList<String>();

		// TIPO RETORNO, 0 = COM CONFIRMAÇÃO 1 = SEM CONFIRMAÇÃO
		String numRetorno = "1";

		// INICIAR COMUNICAÇÃO
		StringBuilder comandoEnvio = new StringBuilder();

		comandoEnvio.append("retorno=\"" + numRetorno + "\"");
		comandoEnvio.append("servico=\"consultar\"");

		// Abre Comunicação
		iniciarServico();

		// Incrementa Sequencial
		// numSequencial++;
		comandoEnvio.append("sequencial=\"" + getNumSequencial() + "\"");

		// Executa consulta

		StringBuilder comandoRetorno = EchoClienteVeSPague
				.enviaComando(comandoEnvio);

		analisaComandoRetorno(comandoRetorno);

		if (isSucess) {
			Scanner scan = new Scanner(comandoRetorno.toString());
			while (scan.hasNext()) {
				String linha = scan.nextLine();

				if (linha.length() > 10
						&& linha.substring(0, linha.indexOf("=")).equals(
								"transacao")) {
					String aLinha = linha.substring(linha.indexOf("\""),
							linha.length() - 1).replace("\"", "");
					transacoes = quebraMensagem(aLinha, ";");
				}
			}
		}

		// Fecha Comunicação
		fecharServico();

		return transacoes;
	}

	private List<String> quebraMensagem(String campoAnalisa, String quebra) {
		List<String> aMensagem = new ArrayList<String>();

		campoAnalisa = campoAnalisa.replace("\"", "");
		String[] transacoes = campoAnalisa.split(quebra);

		for (String a : transacoes) {
			// if (a.contains("Administracao")) {
			aMensagem.add(a);
			// }
		}

		return aMensagem;
	}

	private StringBuilder montarComandoEnvio(VOTef vOTef) {
		// TIPO RETORNO, 0 = COM CONFIRMAÇÃO 1 = SEM CONFIRMAÇÃO
		String numRetorno = "1";
		String tPagamento = "";
		String pTipoProduto = "";
		String pParceladoPor = "";
		String pTipoCartao = "";

		// pValorPago = ajustaValorCartao(pValorPago);

		// INICIAR COMUNICAÇÃO
		StringBuilder comandoEnvio = new StringBuilder();

		comandoEnvio.append("retorno=\"" + numRetorno + "\"").append("\r\n");
		comandoEnvio.append("servico=\"executar\"").append("\r\n");
		comandoEnvio.append("transacao=\"" + vOTef.getTipoTransacao() + "\"")
				.append("\r\n");

		if (vOTef.getTipoTransacao().equals("Cartao Vender")) {
			// Primeira maiuscula
			String pNomeRede = vOTef.getNomeRede().toLowerCase();
			String p1 = pNomeRede.substring(0, 1).toUpperCase();
			String pR = pNomeRede.substring(1, pNomeRede.length());
			String novoNomeRede = p1.concat(pR);

			if (vOTef.getTipoParcelamento().equals("C")) {
				pTipoCartao = "Credito";
				pParceladoPor = "A vista";
				pTipoProduto = "CREDITO-" + novoNomeRede;
				if (vOTef.getNumeroParcelas() > 1) {
					tPagamento = "Estabelecimento";
					pParceladoPor = "Parcelado";
				}
				comandoEnvio.append(
						"transacao_financiado=\"" + tPagamento + "\"").append(
						"\r\n");
				comandoEnvio.append("transacao_valor_taxa_embarque=\"0\"")
						.append("\r\n");
			} else if (vOTef.getTipoParcelamento().equals("D")) {
				pTipoCartao = "Debito";
				pParceladoPor = "A vista";
				pTipoProduto = "DEBITO-" + novoNomeRede;
				comandoEnvio.append("transacao_valor_taxa_embarque=\"0\"")
						.append("\r\n");
				comandoEnvio.append("transacao_valor_saque=\"0\"").append(
						"\r\n");
			}
			comandoEnvio.append("transacao_valor_taxa_servico=\"0\"").append(
					"\r\n");
			comandoEnvio.append("transacao_rede=\"" + novoNomeRede + "\"")
					.append("\r\n");
			comandoEnvio
					.append("transacao_tipo_cartao=\"" + pTipoCartao + "\"")
					.append("\r\n");
			comandoEnvio.append("transacao_produto=\"" + pTipoProduto + "\"")
					.append("\r\n");
			comandoEnvio
					.append("transacao_pagamento=\"" + pParceladoPor + "\"")
					.append("\r\n");
			comandoEnvio.append(
					"transacao_parcela=\"" + vOTef.getNumeroParcelas() + "\"")
					.append("\r\n");
			comandoEnvio.append("transacao_valor=\"" + vOTef.getValor() + "\"")
					.append("\r\n");

		} else if (vOTef.getTipoTransacao().equals("Administracao Cancelar")) {
			// comandoEnvio.append("transacao_data=\"" + TefTcpIp.data +
			// "\"").append("\r\n");
			// comandoEnvio.append("transacao_nsu=\"" + TefTcpIp.NSU +
			// "\"").append("\r\n");
			// comandoEnvio.append("transacao_valor=\"" + TefTcpIp.valor +
			// "\"").append("\r\n");
		} else if (vOTef.getTipoTransacao().equals("Telefone Recarregar")) {
			// comandoEnvio.append("transacao_telefone_ddd=\"" + tDDD +
			// "\"").append("\r\n");
			// comandoEnvio.append("transacao_telefone_numero=\"" + tNumero +
			// "\"").append("\r\n");
		}

		return comandoEnvio;
	}

	public Integer realizaTransacao(VOTef vOTef) {
		Integer result;

		StringBuilder comandoEnvio = montarComandoEnvio(vOTef);

		if (arquivoRetornoTransacao.exists()) {
			arquivoRetornoTransacao.delete();
		}

		result = 0;

		// Abre Comunicação
		iniciarServico();

		// Incrementa Sequencial
		// numSequencial++;
		comandoEnvio.append("sequencial=\"" + getNumSequencial() + "\"");

		// Executa transação
		StringBuilder comandoRetorno = EchoClienteVeSPague
				.enviaComando(comandoEnvio);

		// Gravar Arquivo de Retorno
		gravarArquivoRetorno(comandoRetorno);

		result = -2;

		if (arquivoRetornoTransacao.exists()) {
			// while (result == -2) {
			result = lerRetornoTransacao(novaIdentificacao());
			// }
		}

		// Se tudo ocorrer bem cria o arquivo Pendente.txt
		if (result == 1) {
			// gera um arquivo pendente, pois falta a confirmação da
			// transação(CNC);
			try {
				FileOutputStream saida = new FileOutputStream(
						arquivoPendenteTxt, true);
				PrintStream p = new PrintStream(saida);
				p.println(TefForegroundService.NSU.toString());
				p.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/* cancelar operacao */
		if (result == 9) {
		}

		// Fecha Comunicação
		fecharServico();

		return result;
	}

	public Integer executarRecarga() {
		VOTef vOTefRecarregar = new VOTef();
		vOTefRecarregar.setTipoTransacao("Telefone Recarregar");
		Integer retorno = realizaTransacao(vOTefRecarregar);
		return retorno;
	}

	/**
	 * Ajusta o valor para enviar para o GP.
	 * 
	 * @param pValor
	 *            valor do pagamento
	 * @return valor formatado (Exemplo: 10000 para 100,00
	 */
	public String ajustaValorCartao(String pValor) {
		String cValorCartao = pValor.substring(0, pValor.indexOf(","))
				+ pValor.substring(pValor.indexOf(",") + 1, pValor.length());

		return cValorCartao;
	}

	/**
	 * Cópia de arquivos por Stream.
	 * 
	 * @param pOrigem
	 *            arquivo de origem.
	 * @param pDestino
	 *            arquivo de destino.
	 * @return nenhum.
	 */
	public void copyFile(File pOrigem, File pDestino) throws IOException {
		InputStream entradaCopy = new FileInputStream(pOrigem);
		OutputStream saidaCopy = new FileOutputStream(pDestino);

		// Transfere bytes da entrada para saida
		byte[] buf = new byte[1024];
		int len;
		while ((len = entradaCopy.read(buf)) > 0) {
			saidaCopy.write(buf, 0, len);
		}
		entradaCopy.close();
		saidaCopy.close();
	}

	/**
	 * Cria uma identificação inicial para a transação.
	 * 
	 * @return String com o numero da identificação no formato (DDMMHHMMSS)
	 */
	public String novaIdentificacao() {
		try {
			Thread.sleep(1000);
			SimpleDateFormat formHora = new SimpleDateFormat("ddMMHHmmss");
			String identificacao = formHora.format(new Date());
			return identificacao;
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return "000";
	}

	/**
	 * Abre o ADM do TEF
	 * 
	 * @return true = Ativo | false = Inativo.
	 */
	public Integer abrirADM() {
		int result;
		TefForegroundService.NSU = "";
		List<String> listaOperacoes = new ArrayList<String>();

		if (arquivoRetornoTransacao.exists()) {
			arquivoRetornoTransacao.delete();
		}
		result = 0;

		try {
			listaOperacoes = consultaTransacao();

			Object opcao = JOptionPane.showInputDialog(null,
					"Selecione a opção desejada", "Administração TEF",
					JOptionPane.DEFAULT_OPTION, null, listaOperacoes.toArray(),
					listaOperacoes.toArray()[0]);

			if (opcao == null || opcao.equals("")) {
				return -1;
			}

			VOTef vOTefAdm = new VOTef();
			vOTefAdm.setTipoTransacao(opcao.toString());
			StringBuilder comandoEnvio = montarComandoEnvio(vOTefAdm);

			if (arquivoRetornoTransacao.exists()) {
				arquivoRetornoTransacao.delete();
			}

			result = 0;

			// Abre Comunicação
			iniciarServico();

			// Incrementa Sequencial
			// numSequencial++;
			comandoEnvio.append("sequencial=\"" + getNumSequencial() + "\"");

			try {
				FileOutputStream saida = new FileOutputStream(arquivoTefTxt,
						true);
				PrintStream p = new PrintStream(saida);
				p.println(comandoEnvio.toString());
				p.close();

			} catch (IOException io) {
				io.printStackTrace();
			}

			// Executa transação
			StringBuilder comandoRetorno = EchoClienteVeSPague
					.enviaComando(comandoEnvio);

			// Gravar Arquivo de Retorno
			gravarArquivoRetorno(comandoRetorno);

			result = -2;
			if (arquivoRetornoTransacao.exists()) {
				// while (result == -2) {
				result = lerRetornoTransacao(novaIdentificacao());
				// analisaComando(comandoRetorno);
				// }
			}

			// Fecha Comunicação
			fecharServico();

			// Se tudo ocorrer bem cria o arquivo PENDENTE.txt
			if (result == 1) {
				result = 1;
				FileWriter gravar = new FileWriter(arquivoPendenteTxt);
				PrintWriter saida = new PrintWriter(gravar);
				saida.println(TefForegroundService.NSU.toString());
				saida.close();
				gravar.close();
			}
			// return result;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	/**
	 * Verifica se o GP está ativo.
	 * 
	 * @return true = Ativo | false = Inativo.
	 */
	public boolean verificaGerenciadorPadrao(boolean emiteMensagem) {
		boolean result = false;

		if (arquivoRetornoTransacao.exists()) {
			arquivoRetornoTransacao.delete();
		}
		// inicia Serviço
		try {
			iniciarServico();
		} catch (Exception e) {
			if (emiteMensagem) {
				JOptionPane.showMessageDialog(null, "TEF não está ATIVO!",
						"Mensagem para o operador", 2);
			}
			return false;
		}

		// tenta sete vezes
		for (int tentativa = 1; tentativa <= 7; tentativa++) {
			try {
				if ((arquivoRetornoTransacao.exists())) {
					// GP ativo
					fecharServico();
					arquivoRetornoTransacao.delete();
					result = true;
					break;
				}
				Thread.sleep(1000);
				if (tentativa == 7) {
					if (emiteMensagem) {
						JOptionPane.showMessageDialog(null,
								"TEF não está ATIVO!",
								"Mensagem para o operador", 2);
					}
					result = false;
					break;
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Realiza a impressão da Transação TEF.
	 * 
	 * @param pFormaPagamento
	 *            forma de pagamento
	 * @param pValorPago
	 *            valor da forma de pagamento
	 * @param pNumeroCupom
	 *            número do cupom fiscal - COO
	 * @param pIdentificacao
	 *            identificação da transação
	 * @param pNumeroTransacao
	 *            número da transação
	 * @return true ou false
	 */
	public boolean imprimeTransacao(VOTransacaoTef transacaoTef,
			String cooCupom, boolean cupomVinculado) {
		boolean result = false;
		boolean relatorioAberto = false;
		// User32 user32 = NLink.create(User32.class);

		try {
			// result = true;
			// Criação do arquivo imprimieXXXXXXXX.TXT. Vamos utilizar esse
			// arquivo caso ocorra queda de energia para cancelar a transação.
			if (new File(System.getProperty("user.dir") + "\\imprime"
					+ transacaoTef.getNsu() + ".txt").exists()) {
				// TODO : qual a melhor estratégia para travar o teclado e mouse
				// neste momento?
				// user32.BlockInput(true);

				List<String> impList = new ArrayList();
				String str = "";

				FileReader ler = new FileReader(new File(
						System.getProperty("user.dir") + "\\imprime"
								+ transacaoTef.getNsu() + ".txt"));
				BufferedReader entrada = new BufferedReader(ler);
				linha = "";
				int totalLinhas = 0;
				while ((!result) && ((str = entrada.readLine()) != null)) {
					totalLinhas++;
					if (str.contains("CORTE AQUI")) {
						impList.add(linha);
						impList.add("\r\n\r\n"); // Insere 2 linhas para não
													// cortar no texto
						impList.add(str);
						linha = "";
					} else {
						linha += str.replace("\"", "") + "\r\n";
					}

					if (totalLinhas % 10 == 0) {
						impList.add(linha);
						linha = "";
					}
				}

				if (!linha.equals("")) {
					impList.add(linha);
				}
				int line = 1;
				for (String s : impList) {
					try {
						if (s.contains("CORTE AQUI")) {
							eCFService.cortarPapel();
						} else {
							if (cupomVinculado) {
								// Abre Comprovante Não Fiscal Vinculado TEF
								if (line == 1) {
									eCFService.abrirVinculadoTEF(transacaoTef
											.getBeanFormaPagamento()
											.getDescricao(), transacaoTef
											.getValor(), cooCupom);
									relatorioAberto = true;
									line = 0;
								}
								eCFService.imprimirVinculadoTEF(s);
							} else {
								eCFService.imprimirRelatorioGerencial(s);
								relatorioAberto = true;
							}
						}
						result = true;
					} catch (Exception e) {
						e.printStackTrace();
						// user32.BlockInput(false);

						String[] opcoes = { "Sim", "Não" };
						String mensagem = "Erro na impressão. Deseja tentar novamente?";
						if (eCFService.getPoucoPapel()) {
							mensagem = "Impressora com pouco ou sem papel. Tentar imprimir novamente?";
						}
						int escolha = JOptionPane.showOptionDialog(null,
								mensagem, "Aviso do Sistema",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, opcoes,
								null);
						if (escolha == JOptionPane.YES_OPTION) {
							// user32.BlockInput(true); //bloquear teclado;
							if (impressoraLigada()) {
								entrada.close();
								ler.close();
								if (relatorioAberto) {
									eCFService.fecharVinculadoTEF();
								}
								// if (Caixa.aCBrECF.getEstado() ==
								// Caixa.RELATORIO) {
								// Caixa.aCBrECF.fechaRelatorio();
								// }
								result = imprimeTransacao(transacaoTef,
										cooCupom, false);
								break;
							}
						} else {
							// user32.BlockInput(false);//desbloqueando mouse e
							// teclado para fechar o sistema
							result = false;
							break;
						}
					}
				}
				entrada.close();
				ler.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Throwable t) {
			t.printStackTrace();
			JOptionPane.showMessageDialog(null, t.getMessage(),
					"Erro do Sistema", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			if (eCFService.getECFAtiva() && relatorioAberto) {
				if (cupomVinculado) {
					try {
						eCFService.fecharVinculadoTEF();
						relatorioAberto = false;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					eCFService.fecharRelatorioGerencial();
					relatorioAberto = false;
				}
			}
			// user32.BlockInput(false);
		}
		return result;
	}

	public boolean impressoraLigada() {
		try {
			return eCFService.getECFAtiva();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Confirma a Transação TEF.
	 * 
	 * @param pNumeroTransacao
	 *            número da transação
	 * @return NSU Enviar novamente arquivo de solicitação da transação com o
	 *         retorno 0(zero) em caso de impressão OK, ou retorno 9(nove) em
	 *         caso de erro
	 */
	public String confirmaTransacao(String pNumeroTransacao) {

		while (!verificaGerenciadorPadrao(true)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		linhaArquivo = "";
		conteudoArquivo = "";
		File arquivo;

		// Encontrar arquivo de transação
		if (!pNumeroTransacao.equals("")) {
			arquivo = new File(System.getProperty("user.dir") + "\\intpos"
					+ pNumeroTransacao + ".001");
		} else {
			arquivo = arquivoRetornoTransacao;
		}

		if (arquivo.exists()) {
			try {

				FileReader ler = new FileReader(arquivo);
				BufferedReader entrada = new BufferedReader(ler);

				// confirmação
				StringBuilder confirmacao = new StringBuilder();

				while ((linhaArquivo = entrada.readLine()) != null) {

					// novo builder de confirmação
					if (!linhaArquivo.contains("retorno")) {
						confirmacao.append(linhaArquivo).append("\r\n");
					}
				} // Fim do while not EOF

				entrada.close();
				ler.close();

				// Adiciona retorno de transação com sucesso
				confirmacao.append("retorno=\"0\"");

				// Cria o novo INTPOS.001 da Confirmacão
				FileWriter gravar = new FileWriter(arquivoRetornoTransacao);
				PrintWriter saida = new PrintWriter(gravar);
				saida.println(confirmacao.toString());
				saida.close();
				gravar.close();

				// Enviar confirmação

				StringBuilder comandoRetorno = EchoClienteVeSPague
						.enviaComando(confirmacao);

				// Gera um arquivo TEF informando que foi confirmado a impressão
				// do arquivo!
				// Informações necessarias para cancelamento automatico da
				// transação
				String linhaTef = pNumeroTransacao + ";" + nomeRede + ";"
						+ data + ";" + hora + ";" + valor + ";";

				if (!arquivoTefTxt.exists()) {
					gravar = new FileWriter(arquivoTefTxt);
					saida = new PrintWriter(gravar);
					saida.println(linhaTef);
					saida.close();
					gravar.close();
				} else {
					UTILBiblioteca.addLineFromFile(
							arquivoTefTxt.getAbsolutePath(), linhaTef);
				}

				if (arquivoRetornoTransacao.exists()) {
					arquivoRetornoTransacao.delete();
				}
				if (arquivoPendenteTxt.exists()) {
					arquivoPendenteTxt.delete();
				}

				return TefForegroundService.NSU;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * Não Confirma a Transação ou a impressao TEF.
	 * 
	 * @param pNumeroTransacao número da transação
	 * 
	 * @return NSU
	 */
	public String naoConfirmaTransacao(String pNumeroTransacao) {
		while (!verificaGerenciadorPadrao(true)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		linhaArquivo = "";
		conteudoArquivo = "";
		File arquivo;
		String rede = "", cNSU = "", valor = "", data = "";

		if (!pNumeroTransacao.equals("")) {
			arquivo = new File(System.getProperty("user.dir") + "\\intpos"
					+ pNumeroTransacao + ".001");
		} else {
			arquivo = arquivoRetornoTransacao;
		}

		if (arquivo.exists()) {

			// Builder de retorno negando a conclusão da transação
			StringBuilder rNaoConfirma = new StringBuilder();

			try {
				FileReader ler = new FileReader(arquivo);
				BufferedReader entrada = new BufferedReader(ler);

				while ((linhaArquivo = entrada.readLine()) != null) {

					// Linhas de arquivoRetorno
					if (!linhaArquivo.contains("retorno")) {
						if (linhaArquivo.contains("=")
								&& linhaArquivo.substring(0,
										linhaArquivo.indexOf("=")).equals(
										"transacao_rede")) {
							rede = linhaArquivo.substring(
									linhaArquivo.indexOf("\""),
									linhaArquivo.length() - 1)
									.replace("\"", "");
						}
						if (linhaArquivo.contains("=")
								&& linhaArquivo.substring(0,
										linhaArquivo.indexOf("=")).equals(
										"transacao_nsu")) {
							cNSU = linhaArquivo.substring(
									linhaArquivo.indexOf("\""),
									linhaArquivo.length() - 1)
									.replace("\"", "");
						}
						if (linhaArquivo.contains("=")
								&& linhaArquivo.substring(0,
										linhaArquivo.indexOf("=")).equals(
										"transacao_valor")) {
							valor = linhaArquivo.substring(
									linhaArquivo.indexOf("\""),
									linhaArquivo.length() - 1)
									.replace("\"", "");
						}
						// if (linhaArquivo.contains("=") &&
						// linhaArquivo.substring(0,
						// linhaArquivo.indexOf("=")).equals("transacao_data"))
						// {
						// data =
						// linhaArquivo.substring(linhaArquivo.indexOf("\""),
						// linhaArquivo.length() - 1).replace("\"", "");
						// }

						// buffer de não confirmação
						rNaoConfirma.append(linhaArquivo).append("\r\n");
					}
				} // Fim do while not EOF

				entrada.close();
				ler.close();

				// Adicionar retorno de operação sem sucesso
				rNaoConfirma.append("retorno=\"9\"");

				// Cria o novo INTPOS.001 da Confirmacão
				FileWriter gravar = new FileWriter(arquivoRetornoTransacao);
				PrintWriter saida = new PrintWriter(gravar);
				saida.println(rNaoConfirma.toString());
				saida.close();
				gravar.close();

				// Enviar nãoConfirmação

				StringBuilder comandoRetorno = EchoClienteVeSPague
						.enviaComando(rNaoConfirma);

				// Deletar arquivos
				arquivoRetornoTransacao.delete();
				arquivo.delete();

				BigDecimal valorTef = new BigDecimal(valor);

				DecimalFormat df = new DecimalFormat("###,###,###,##0.00");

				String textomsg = "";
				if (!rede.toString().equals("")) {
					textomsg += "Rede: " + rede + (char) 13 + (char) 10;
				}
				if (!cNSU.toString().equals("")) {
					textomsg += "NSU: " + cNSU + (char) 13 + (char) 10;
				}
				if (!valor.toString().equals("0,00")) {
					textomsg += "Valor: " + df.format(valorTef);
				}

				JOptionPane.showMessageDialog(null,
						"Transação TEF não efetuada. Favor reter o cupom"
								+ (char) 13 + (char) 10 + (char) 13 + (char) 10
								+ textomsg, "Encerrar venda.",
						JOptionPane.INFORMATION_MESSAGE);

				return cNSU;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
		// int cont = 0;
		// while (!respIntPosSts.exists()) {
		// Thread.sleep(1000);
		// cont++;
		// if (cont == 7) {
		// if (!reqIntPos001.exists()) {
		// copyFile(arquivoRetornoTransacao, reqIntPos001);
		// } else {
		// JOptionPane.showMessageDialog(null,
		// "TEF não está Ativo e será ativado automaticamente!",
		// "Mensagem para o operador", JOptionPane.INFORMATION_MESSAGE);
		// Runtime.getRuntime().exec("c:\\tef_dial\\tef_dial.exe");
		// Thread.sleep(8000);
		// }
		// cont = 0;
		// }
		// }
	}

	// //////////////////////////////////////////////////////////////////////////////
	// Função: limpaBuffer
	// Objetivo: Limpar os arquivos responsaveis pela transacao TEF
	// Parâmetros: String com o número de identificação (NSU)
	// //////////////////////////////////////////////////////////////////////////////
	public void limpaBuffer(String pNumeroTransacao) {

		if (arquivoRetornoTransacao.exists()) {
			arquivoRetornoTransacao.delete();
		}
		if (new File(System.getProperty("user.dir") + "\\intpos"
				+ pNumeroTransacao + ".001").exists()) {
			new File(System.getProperty("user.dir") + "\\intpos"
					+ pNumeroTransacao + ".001").delete();
		}
		if (new File(System.getProperty("user.dir") + "\\imprime"
				+ pNumeroTransacao + ".txt").exists()) {
			new File(System.getProperty("user.dir") + "\\imprime"
					+ pNumeroTransacao + ".txt").delete();
		}
	}

	// //////////////////////////////////////////////////////////////////////////////
	// Função: limpaArquivosTempos
	// Objetivo: Limpar os arquivos temporarios depois de imprimir e confirmar a
	// transação
	// Parâmetros:
	// //////////////////////////////////////////////////////////////////////////////

	public void limpaArquivosTemps() {

		if (arquivoTefTxt.exists()) {
			arquivoTefTxt.delete();
		}

		if (arquivoPendenteTxt.exists()) {
			arquivoPendenteTxt.delete();
		}
	}

	// //////////////////////////////////////////////////////////////////////////////
	// Função: cancelaTefPendentes
	// Objetivo: cancelar todas as transacoes TEF pendentes
	// Parâmetros:
	// Retorno: True se tudo ok e false se tiver algum erro
	// //////////////////////////////////////////////////////////////////////////////

	public boolean cancelaTefPendentes() throws Exception {
		boolean result = false;
		// não confirmando a ultima transação pendente
		String lin = "";

		try {
			if (arquivoPendenteTxt.exists()) {
				FileReader leitura = new FileReader(arquivoPendenteTxt);
				BufferedReader entrada = new BufferedReader(leitura);
				while ((linhaArquivo = entrada.readLine()) != null) {
					TefForegroundService.NSU = linhaArquivo;
					naoConfirmaTransacao(TefForegroundService.NSU);

					if (new File(System.getProperty("user.dir") + "\\imprime"
							+ TefForegroundService.NSU + ".txt").exists()) {
						new File(System.getProperty("user.dir") + "\\imprime"
								+ TefForegroundService.NSU + ".txt").delete();
					}
				}
				entrada.close();
				leitura.close();
				limpaBuffer(TefForegroundService.NSU);

				// // Excluir arquivo de impressão

				result = true;
			}
			limpaArquivosTemps();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	// //////////////////////////////////////////////////////////////////////////////
	// Função: verificaTefPendentes
	// Objetivo: verifica se a transaçoes nao impressas ou nao confirmadas
	// Parâmetros:
	// Retorno: True se tiver pendente e false se não tiver pendente
	// //////////////////////////////////////////////////////////////////////////////
	public boolean verificaTefPendentes() {
		boolean result = false;
		try {
			FileWriter gravar;
			if (arquivoTefTxt.exists()) {
				result = true;
			}

			if (arquivoPendenteTxt.exists()) {
				result = true;
			}

			if (arquivoRetornoTransacao.exists()
					&& (!arquivoPendenteTxt.exists())) {
				NSU = lerIdentificacao();
				gravar = new FileWriter(arquivoPendenteTxt);
				PrintWriter saida = new PrintWriter(gravar);
				saida.println(TefForegroundService.NSU.toString());
				saida.close();
				gravar.close();
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// //////////////////////////////////////////////////////////////////////////////
	// Função: executaADM()
	// Objetivo: executar a função ADM do TEF.
	// Parâmetros:
	// Retorno 1-OK, 2-Erro, 3-GP não ativo
	// //////////////////////////////////////////////////////////////////////////////
	public void executaADM() {

		if (verificaGerenciadorPadrao(true)) {
			switch (abrirADM()) {
			case 1: // OK
				TefForegroundService.relatorioGerencial = true;
				VOTransacaoTef tf = new VOTransacaoTef();
				tf.setNsu(TefForegroundService.NSU);
				if (!imprimeTransacao(tf, null, false)) {
					try {
						cancelaTefPendentes();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					// JOptionPane.showMessageDialog(null,
					// "Devido a um erro no ECF o sistema será finalizado, ",
					// "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
					// + "a venda e as transações TEF serão canceladas " +
					// (char) 13 + (char) 10
					// + "quando o sistema reiniciar.", "Aviso do Sistema",
					// JOptionPane.ERROR_MESSAGE);
					// TefTcpIp.NaoConfirmaTransacao(this.ultimoNSU);
					// System.exit(0);
				}
				TefForegroundService.relatorioGerencial = false;
				if (!TefForegroundService.NSU.toString().equals("")) {
					confirmaTransacao(TefForegroundService.NSU);
				}

				limpaBuffer(TefForegroundService.NSU);
				limpaArquivosTemps();

				break;
			case -1: // Transação não realizada
				// TODO : Devemos fazer mais alguma coisa aqui? O que?
				// JOptionPane.showMessageDialog(rootPane,
				// "Erro na transação com cartão.", "Aviso do Sistema",
				// JOptionPane.ERROR_MESSAGE);
				break;
			case 0: // GP Inativo
				// TODO : Se o GP estiver inativo, o que devemos fazer?
				JOptionPane.showMessageDialog(null,
						"Gerenciador padrão inativo.", "Aviso do Sistema",
						JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}

	// //////////////////////////////////////////////////////////////////////////////
	// Função: lerRespIntPos001
	// Objetivo: ler o arquivo respintpos001 e gerar o arquivo para impressão se
	// tiver;
	// Parâmetros: pIdentificacao
	// Retorno: -1: Transação não Realizada; 0: GP não Ativo; 1: Transação
	// Realizada;
	// //////////////////////////////////////////////////////////////////////////////

	public int lerRespIntPos001(String pIdentificacao) {
		int result = -2, numeroLinhas;
		// User32 user32 = NLink.create(User32.class);
		try {
			FileReader leitura = new FileReader(arquivoRetornoTransacao);
			BufferedReader entrada = new BufferedReader(leitura);

			while ((linhaArquivo = entrada.readLine()) != null) {
				campoArquivo = linhaArquivo.substring(0, 3);
				switch (Integer.parseInt(campoArquivo)) {
				case 1: // verifica se o campo de identificação é o mesmo do
						// solicitado
					if (!linhaArquivo.substring(10, linhaArquivo.length())
							.equals(pIdentificacao)) {
						entrada.close();
						leitura.close();
						arquivoRetornoTransacao.delete();
						break;
					}
					break;
				case 9: // verifica se a transação foi aprovada
					if (linhaArquivo.substring(10, linhaArquivo.length())
							.equals("0")) {
						transacaoAprovada = true;
						result = 1;
					}
					if (!linhaArquivo.substring(10, linhaArquivo.length())
							.equals("0")) {
						transacaoAprovada = false;
						result = -1;
					}
					break;
				case 12: {
					TefForegroundService.NSU = linhaArquivo.substring(10,
							linhaArquivo.length());
				}
					break;
				case 10: {
					TefForegroundService.nomeRede = linhaArquivo.substring(10,
							linhaArquivo.length());
				}
					break;
				case 22: {
					TefForegroundService.data = linhaArquivo.substring(10,
							linhaArquivo.length());
				}
					break;
				case 23: {
					TefForegroundService.hora = linhaArquivo.substring(10,
							linhaArquivo.length());
				}
					break;

				case 28: // verifica se existem linhas para serem impressas
					if ((Integer.parseInt(linhaArquivo.substring(10,
							linhaArquivo.length())) != 0)
							&& (transacaoAprovada == true)) {

						/*
						 * O arquivo INTPOS.001 é copiado temporariamente. Isso
						 * ocorre para cadas transação. Caso a transação
						 * necessite ser cancelada, as informações estarão neste
						 * arquivo.
						 */
						copyFile(arquivoRetornoTransacao,
								new File(System.getProperty("user.dir")
										+ "\\intpos" + TefForegroundService.NSU
										+ ".001"));
						result = 1;

						// Armazena o número de linhas para a impressão da via
						// única
						numeroLinhas = Integer.parseInt(linhaArquivo.substring(
								10, linhaArquivo.length()));

						// Formata o arquivo para impressão da via única
						linha = linha + (char) 13 + (char) 10;

						// String linhas2Via = "" + (char) 13 + (char) 10;

						for (int i = 1; i <= numeroLinhas; i++) {
							linhaArquivo = entrada.readLine();
							try {
								if (linhaArquivo.substring(0, 3).equals("029")) {
									linha = linha
											+ linhaArquivo.substring(11,
													linhaArquivo.length() - 1)
											+ (char) 13 + (char) 10;
									// linhas2Via += linhaArquivo.substring(11,
									// linhaArquivo.length() - 1) + (char) 13 +
									// (char) 10;
								} else {
									if (linhaArquivo.substring(0, 3).equals(
											"028")) {
										i = i - 1;
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

						}
						linha = linha + (char) 13 + (char) 10 + (char) 13
								+ (char) 10
								// +
								// " . . . . . . . . . . . . . . . . . . . . . . . . "
								+ (char) 13 + (char) 10 + (char) 13 + (char) 10;

						// linha += linhas2Via;
					}
					break;
				case 30: // Se o campo for 030 exibe uma mensagem para o
							// operador
					// user32.BlockInput(true);
					// Mensagem msg = new Mensagem(null, true, true, 1000);
					// verifica se tem alguma linha para ser impressa
					// se tiver exibe mensagem se ok, no minimo 5 segundos
					/*
					 * if ((!linha.equals("")) && (result == 1)) {
					 * Caixa.setTextoMensagem(linhaArquivo.substring(10,
					 * linhaArquivo.length()));
					 * msg.setMensagem(linhaArquivo.substring(10,
					 * linhaArquivo.length())); msg.setLocationRelativeTo(null);
					 * msg.setVisible(true); } else { //exibe mensagem com OK
					 * user32.BlockInput(false); ExibirMensagemDialog mensagem =
					 * new ExibirMensagemDialog(Caixa.getCaixa(), true,
					 * linhaArquivo.substring(10, linhaArquivo.length()));
					 * mensagem.setVisible(true); result = -1; }
					 */
					// user32.BlockInput(false);
					break;
				/*
				 * case 712: //verifica se existem linhas para sereom impressas
				 * na via do cliente if
				 * ((Integer.parseInt(linhaArquivo.substring(10,
				 * linhaArquivo.length())) != 0) && (transacaoAprovada == true))
				 * {
				 * 
				 * //Armazena o número de linhas para a impressão da via do
				 * cliente numeroLinhas =
				 * Integer.parseInt(linhaArquivo.substring(10,
				 * linhaArquivo.length()));
				 * 
				 * //Formata o arquivo para impressão da via do cliente linha =
				 * linha + (char) 13 + (char) 10;
				 * 
				 * for (int i = 1; i <= numeroLinhas; i++) { linhaArquivo =
				 * entrada.readLine(); if (linhaArquivo.substring(0,
				 * 3).equals("713")) { linha = linha +
				 * linhaArquivo.substring(11, linhaArquivo.length() - 1) +
				 * (char) 13 + (char) 10; } } linha = linha + (char) 13 + (char)
				 * 10 + (char) 13 + (char) 10 +
				 * " . . . . . . . . . . . . . . . . . . . . . . . . " + (char)
				 * 13 + (char) 10 + (char) 13 + (char) 10; } break; case 714:
				 * //Verifica se existem linhas para serem impressas na via do
				 * estabelecimento if
				 * ((Integer.parseInt(linhaArquivo.substring(10,
				 * linhaArquivo.length())) != 0) && (transacaoAprovada == true))
				 * {
				 * 
				 * //Armazena o número de linhas para a impressão da via do
				 * estabelecimento numeroLinhas =
				 * Integer.parseInt(linhaArquivo.substring(10,
				 * linhaArquivo.length()));
				 * 
				 * //Formata o arquivo para impressão da via do estabelecimento
				 * linha = linha + (char) 13 + (char) 10;
				 * 
				 * for (int i = 1; i <= numeroLinhas; i++) { linhaArquivo =
				 * entrada.readLine(); if (linhaArquivo.substring(0,
				 * 3).equals("715")) { linha = linha +
				 * linhaArquivo.substring(11, linhaArquivo.length() - 1) +
				 * (char) 13 + (char) 10; } } linha = linha + (char) 13 + (char)
				 * 10 + (char) 13 + (char) 10 +
				 * " . . . . . . . . . . . . . . . . . . . . . . . . " + (char)
				 * 13 + (char) 10 + (char) 13 + (char) 10; } break;
				 */
				}
				if (linhaArquivo == null) { // Chegou no fim do arquivo
					break;
				}
			} // Fim while not EOF
			entrada.close();
			leitura.close();
		} catch (IOException e) {
			// user32.BlockInput(false);
			// e.printStackTrace();
		}
		// Cria o arquivo temporário IMPRIME[transacao].txt com a imagem do
		// comprovante.

		if (!linha.equals("")) {
			try {
				FileWriter gravar = new FileWriter(new File(
						System.getProperty("user.dir") + "\\imprime"
								+ TefForegroundService.NSU.toString() + ".txt"));
				PrintWriter saida = new PrintWriter(gravar);
				saida.println(linha);
				saida.close();
				gravar.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private String lerIdentificacao() {
		String result = "";
		try {
			FileReader leitura = new FileReader(arquivoRetornoTransacao);
			BufferedReader entrada = new BufferedReader(leitura);

			while ((linhaArquivo = entrada.readLine()) != null) {
				// PEGAR NSU
				if (linhaArquivo.contains("=")
						&& linhaArquivo.substring(0, linhaArquivo.indexOf("="))
								.equals("transacao_nsu")) {
					result = linhaArquivo.substring(linhaArquivo.indexOf("\""),
							linhaArquivo.length() - 1).replace("\"", "");
					arquivoRetornoTransacao.delete();
					break;
				}
			}
			entrada.close();
			leitura.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private int getNumSequencial() {
		int atual = numSequencial;
		setNumSequencial(++atual);
		return atual;
	}

	private void setNumSequencial(int sequencial) {
		numSequencial = sequencial;
	}

}
