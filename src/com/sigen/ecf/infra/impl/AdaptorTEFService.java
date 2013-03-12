package com.sigen.ecf.infra.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sigen.ecf.infra.TEFService;
import com.sigen.ecf.vo.VOTef;
import com.sigen.ecf.vo.VOTransacaoTef;

public class AdaptorTEFService implements TEFService {

	@Override
	public void analisaiRetorno(int iRetorno) {

	}

	@Override
	public int lerRetornoTransacao(String pIdentificacao) {
		return 0;
	}

	@Override
	public void gravarArquivoRetorno(StringBuilder r) {

	}

	@Override
	public void iniciarServico() {

	}

	@Override
	public void fecharServico() {

	}

	@Override
	public List<String> consultaTransacao() {
		return new ArrayList<String>();
	}

	@Override
	public Integer realizaTransacao(VOTef vOTef) {
		return 0;
	}

	@Override
	public Integer executarRecarga() {
		return 0;
	}

	@Override
	public String ajustaValorCartao(String pValor) {
		return "100,00";
	}

	@Override
	public void copyFile(File pOrigem, File pDestino) throws IOException {

	}

	@Override
	public String novaIdentificacao() {
		return "000";
	}

	@Override
	public Integer abrirADM() {
		return 0;
	}

	@Override
	public boolean verificaGerenciadorPadrao(boolean emiteMensagem) {
		return true;
	}

	@Override
	public boolean imprimeTransacao(VOTransacaoTef transacaoTef,
			String cooCupom, boolean cupomVinculado) {
		return false;
	}

	@Override
	public boolean impressoraLigada() {
		return true;
	}

	@Override
	public String confirmaTransacao(String pNumeroTransacao) {
		return "0";
	}

	@Override
	public String naoConfirmaTransacao(String pNumeroTransacao) {
		return null;
	}

	@Override
	public void limpaBuffer(String pNumeroTransacao) {
	}

	@Override
	public void limpaArquivosTemps() {
	}

	@Override
	public boolean cancelaTefPendentes() throws Exception {
		return true;
	}

	@Override
	public boolean verificaTefPendentes() {
		return false;
	}

	@Override
	public void executaADM() {

	}

	@Override
	public int lerRespIntPos001(String pIdentificacao) {
		return -1;
	}

}
