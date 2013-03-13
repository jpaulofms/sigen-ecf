/**
 * <p>Title: SIGEN</p> <p>Description: PAF-ECF + TEF - Classe de controle do
 * TEF.</p>
 */
package com.sigen.ecf.infra;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.sigen.ecf.vo.VOTef;
import com.sigen.ecf.vo.VOTransacaoTef;

//import nlink.win32.NLink;

public interface TEFService {

	public void analisaiRetorno(int iRetorno);

	public int lerRetornoTransacao(String pIdentificacao);

	public void gravarArquivoRetorno(StringBuilder r);

	public void iniciarServico();

	public void fecharServico();

	public List<String> consultaTransacao();

	public Integer realizaTransacao(VOTef vOTef);

	public Integer executarRecarga();

	public String ajustaValorCartao(String pValor);

	public void copyFile(File pOrigem, File pDestino) throws IOException;

	public String novaIdentificacao();

	public Integer abrirADM();

	public boolean verificaGerenciadorPadrao(boolean emiteMensagem);

	public boolean imprimeTransacao(VOTransacaoTef transacaoTef,
			String cooCupom, boolean cupomVinculado);

	public boolean impressoraLigada();

	public String confirmaTransacao(String pNumeroTransacao);

	public String naoConfirmaTransacao(String pNumeroTransacao);

	public void limpaBuffer(String pNumeroTransacao);

	public void limpaArquivosTemps();

	public boolean cancelaTefPendentes() throws Exception;

	public boolean verificaTefPendentes();

	public void executaADM();

	public int lerRespIntPos001(String pIdentificacao);

}
