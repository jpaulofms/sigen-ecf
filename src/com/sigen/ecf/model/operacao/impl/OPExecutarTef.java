/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.view.util.TEFRedeEnum;
import com.sigen.ecf.view.util.UTILForegroundTef;
import com.sigen.ecf.vo.VOTef;
import com.sigen.ecf.vo.VOTransacaoTef;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author SIGEN 3
 */
public class OPExecutarTef extends Operacao implements IOperacao {
    
    private List<VOTransacaoTef> lsTransacaoTef;
    
    @Override
    protected boolean validaTransacao(Map parametros) throws OperacaoException {
        return true;
    }
    
    @Override
    protected void iniciar(Map parametros) throws OperacaoException {
    }
    
    @Override
    protected Map efetuar(Map parametros) throws OperacaoException {
        Map mpRetorno = parametros;
        
        lsTransacaoTef = (List<VOTransacaoTef>) parametros.get("lsTransacoesTef");
        if (realizarTransacoesTEF()) {
            /*
             * Retornar True
             */
            mpRetorno.put("lsTransacoesTef", lsTransacaoTef);
            mpRetorno.put("BooleanResult", true);
            return mpRetorno;
        }
        mpRetorno.put("BooleanResult", false);
        return mpRetorno;
    }
    
    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
    
    private boolean realizarTransacoesTEF() {
        Integer retorno = 1;
        
        for (VOTransacaoTef transacaoTef : lsTransacaoTef) {
            if (UTILForegroundTef.verificaGerenciadorPadrao(true)) {
                if (transacaoTef.getNsu() == null || transacaoTef.getNsu().isEmpty()) {
                    
                    try {
                        String tipoParcelamento = "D";
                        if (transacaoTef.getBeanFormaPagamento().isPagamentoAPrazo()) {
                            tipoParcelamento = "C";
                        }

                        // CONVENIADA 
                        String conveniada = TEFRedeEnum.CIELO.getIdentificador();
                        if (transacaoTef.getBeanConveniada().getDescricao().contains("BANESE")) {
                            if (tipoParcelamento.equals("C")) {
                                conveniada = TEFRedeEnum.REDECARD.getIdentificador();
                            }else{
                                conveniada = TEFRedeEnum.BANESE.getIdentificador();
                            }
                        } else if ((transacaoTef.getBeanConveniada().getDescricao().contains("AMEX"))) {
                            conveniada = TEFRedeEnum.AMEX.getIdentificador();
                        } else if ((transacaoTef.getBeanConveniada().getDescricao().contains("HIPER"))) {
                            conveniada = TEFRedeEnum.REDECARD.getIdentificador();
                        }

                        /*
                         * Executa o client
                         */
                        VOTef objetoTef = new VOTef();
                        
                        objetoTef.setTipoTransacao("Cartao Vender");
                        objetoTef.setNomeRede(conveniada);
                        objetoTef.setTipoParcelamento(tipoParcelamento);
                        objetoTef.setValor(transacaoTef.getValor().toPlainString()); // Valor Formatado ?;
                        objetoTef.setNumeroParcelas(transacaoTef.getNumeroParcelas());
                        
                        retorno = 1;
                        retorno = UTILForegroundTef.realizaTransacao(objetoTef);

                        /*
                         * Retornos
                         */
                        objetoTef.setNSU(UTILForegroundTef.NSU);
                        objetoTef.setNomeRede(UTILForegroundTef.nomeRede);
                        objetoTef.setData(UTILForegroundTef.data);
                        objetoTef.setHora(UTILForegroundTef.hora);
                        
                        if (retorno == 1) {
                            transacaoTef.setNsu(objetoTef.getNSU());
                            transacaoTef.setDataTransacao(UTILForegroundTef.data);
                            transacaoTef.setHoraTransacao(UTILForegroundTef.hora);
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                retorno = -1;
            }
        }
        if (retorno != 1) {
            // Realizar cancelamento de Operações que já foram efetuadas
            cancelarTefPendentes();
            for (VOTransacaoTef vTEF : lsTransacaoTef) {
                vTEF.setNsu(null);
            }
            return false;
        }
        return true;
    }
    
    private void cancelarTefPendentes() {
        try {
            UTILForegroundTef.cancelaTefPendentes();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro no Cancelamento dos TEF pendentes.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}