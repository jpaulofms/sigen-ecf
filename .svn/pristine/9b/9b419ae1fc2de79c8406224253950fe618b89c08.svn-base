/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao;

import com.sigen.ecf.model.operacao.impl.OPAbrirAplicacao;
import com.sigen.ecf.model.operacao.impl.OPAbrirGaveta;
import com.sigen.ecf.model.operacao.impl.OPAdministradorTef;
import com.sigen.ecf.model.operacao.impl.OPBaixaCredito;
import com.sigen.ecf.model.operacao.impl.OPBaixaTitulo;
import com.sigen.ecf.model.operacao.impl.OPCancelaItemVenda;
import com.sigen.ecf.model.operacao.impl.OPCancelaVenda;
import com.sigen.ecf.model.operacao.impl.OPConcederDescontoVenda;
import com.sigen.ecf.model.operacao.impl.OPDescontoItem;
import com.sigen.ecf.model.operacao.impl.OPDevolucao;
import com.sigen.ecf.model.operacao.impl.OPDevolucaoItem;
import com.sigen.ecf.model.operacao.impl.OPExecutarTef;
import com.sigen.ecf.model.operacao.impl.OPFinalizacaoVenda;
import com.sigen.ecf.model.operacao.impl.OPLancamento;
import com.sigen.ecf.model.operacao.impl.OPMovimentoAbertura;
import com.sigen.ecf.model.operacao.impl.OPMovimentoFechamento;
import com.sigen.ecf.model.operacao.impl.OPReducaoZ;
import com.sigen.ecf.model.operacao.impl.OPRelatorioComprovanteTEF1;
import com.sigen.ecf.model.operacao.impl.OPRelatorioComprovanteTEF2;
import com.sigen.ecf.model.operacao.impl.OPRelatorioDevolucao;
import com.sigen.ecf.model.operacao.impl.OPRelatorioPosicaoCaixa;
import com.sigen.ecf.model.operacao.impl.OPRelatorioReciboCrediario;
import com.sigen.ecf.model.operacao.impl.OPRelatorioSaldoDevolucao;
import com.sigen.ecf.model.operacao.impl.OPSairAplicacao;
import com.sigen.ecf.model.operacao.impl.OPSangria;
import com.sigen.ecf.model.operacao.impl.OPSuprimento;
import com.sigen.ecf.model.operacao.impl.OPVenda;
import com.sigen.ecf.model.operacao.impl.OPVendaItem;

/**
 *
 * @author SIGEN 3
 */
public class OperacaoFactory {

    private static OperacaoFactory instance;

    private OperacaoFactory() {
    }

    public static OperacaoFactory getInstance() {
        if (instance == null) {
            instance = new OperacaoFactory();
        }
        return instance;
    }

    public Operacao criarOPAbrirAplicacao() {
        return new OPAbrirAplicacao();
    }

    public Operacao criarOPAbrirGaveta() {
        return new OPAbrirGaveta();
    }

    public Operacao criarOPAdministradorTEF() {
        return new OPAdministradorTef();
    }

    public Operacao criarOPBaixaCredito() {
        return new OPBaixaCredito();
    }

    public Operacao criarBaixaTitulo() {
        return new OPBaixaTitulo();
    }

    public Operacao criarOPCancelaItemVenda() {
        return new OPCancelaItemVenda();
    }

    public Operacao criarOPCancelaVenda() {
        return new OPCancelaVenda();
    }

    public Operacao criarOPReducaoZ() {
        return new OPReducaoZ();
    }

    public Operacao criarOPConcederDescontoVenda() {
        return new OPConcederDescontoVenda();
    }

    public Operacao criarOPExecutarTef() {
        return new OPExecutarTef();
    }

    public Operacao criarOPFinalizacao() {
        return new OPFinalizacaoVenda();
    }

    public Operacao criarOPLancamento() {
        return new OPLancamento();
    }

    public Operacao criarOPMovimentoAbertura() {
        return new OPMovimentoAbertura();
    }

    public Operacao criarOPMovimentoFechamento() {
        return new OPMovimentoFechamento();
    }

    public Operacao criarOPRelatorioComprovanteTEF1() {
        return new OPRelatorioComprovanteTEF1();
    }

    public Operacao criarOPRelatorioComprovanteTEF2() {
        return new OPRelatorioComprovanteTEF2();
    }

    public Operacao criarOPRelatorioPosicaoCaixa() {
        return new OPRelatorioPosicaoCaixa();
    }

    public Operacao criarOPRelatorioReciboCrediario() {
        return new OPRelatorioReciboCrediario();
    }

    public Operacao criarOPRelatorioDevolucao() {
        return new OPRelatorioDevolucao();
    }

    public Operacao criarOPRelatorioSaldoDevolucao() {
        return new OPRelatorioSaldoDevolucao();
    }

    public Operacao criarOPSairAplicacao() {
        return new OPSairAplicacao();
    }

    public Operacao criarOPSangria() {
        return new OPSangria();
    }

    public Operacao criarOPSuprimento() {
        return new OPSuprimento();
    }

    public Operacao criarOPVenda() {
        return new OPVenda();
    }

    public Operacao criarOPVendaItem() {
        return new OPVendaItem();
    }

    public Operacao criarOPDescontoItem() {
        return new OPDescontoItem();
    }

    public Operacao criarOPDevolucao() {
        return new OPDevolucao();
    }

    public Operacao criarOPDevolucaoItem() {
        return new OPDevolucaoItem();
    }
}
