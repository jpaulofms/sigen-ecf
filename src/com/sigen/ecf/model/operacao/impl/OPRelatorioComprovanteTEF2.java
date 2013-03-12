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
public class OPRelatorioComprovanteTEF2 extends Operacao implements IOperacao {

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
        boolean report = (Boolean) parametros.get("BooleanResult");
        BeanVenda venda = (BeanVenda) parametros.get("BeanVenda");
        try {

            List<VOTransacaoTef> lsTransacoesTef = (List<VOTransacaoTef>) parametros.get("lsTransacoesTef");
            if (!lsTransacoesTef.isEmpty()) {
                VOTransacaoTef transacaoTef = lsTransacoesTef.get(0);

                if (!UTILForegroundTef.imprimeTransacao(transacaoTef, venda.getCoo(), true)) {
                    if (UTILForegroundTef.impressoraLigada()) {
                        if (!UTILForegroundTef.cancelaTefPendentes()) {
                            JOptionPane.showMessageDialog(null, "Erro no Cancelamento dos TEF pendentes.\nO Sistema será encerrado!.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        } else {
                            //if (eCFService.getEstadoImpressora() == Caixa.RELATORIO) {
                            //Caixa.aCBrECF.fechaRelatorio();
                            //}
                            //Caixa.cancelaCupomAut();
                            report = true;
                        }
                    } else {
                        if (!UTILForegroundTef.cancelaTefPendentes()) {
                            JOptionPane.showMessageDialog(null, "Erro no Cancelamento dos TEF pendentes.\nO Sistema será encerrado!.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        }
                        report = true;
                    }
                }
            }
        } catch (OperacaoException ex) {
            TratamentoException.tratar(ex);
        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }
        mpRetorno.put("BooleanResult", report);
        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}