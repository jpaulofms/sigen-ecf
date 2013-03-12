/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.view.util.UTILForegroundTef;
import com.sigen.ecf.vo.VOTransacaoTef;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author SIGEN 3
 */
public class OPRelatorioComprovanteTEF1 extends Operacao implements IOperacao {

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
        boolean tefComProblema = (Boolean) parametros.get("BooleanResult");
        try {
            BeanVenda venda = (BeanVenda) parametros.get("BeanVenda");

            List<VOTransacaoTef> lsTransacoesTef = (List<VOTransacaoTef>) parametros.get("lsTransacoesTef");
            for (VOTransacaoTef tf : lsTransacoesTef) {
                if (!UTILForegroundTef.imprimeTransacao(tf, venda.getCoo(), true)) {
                    if (UTILForegroundTef.impressoraLigada()) {
                        if (!UTILForegroundTef.cancelaTefPendentes()) {
                            JOptionPane.showMessageDialog(null, "Erro no Cancelamento dos TEF pendentes.\nO Sistema será encerrado!.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        } else {
                            //if (eCFService.getEstadoImpressora() == Caixa.RELATORIO) {
                            //Caixa.aCBrECF.fechaRelatorio();
                            //}
                            //Caixa.cancelaCupomAut();
                            tefComProblema = true;
                            break;
                        }
                    } else {
                        if (!UTILForegroundTef.cancelaTefPendentes()) {
                            JOptionPane.showMessageDialog(null, "Erro no Cancelamento dos TEF pendentes.\nO Sistema será encerrado!.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        }
                        tefComProblema = true;
                        break;
                    }
                }
            }
        } catch (OperacaoException ex) {
            TratamentoException.tratar(ex);
        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }
        mpRetorno.put("BooleanResult", tefComProblema);
        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}