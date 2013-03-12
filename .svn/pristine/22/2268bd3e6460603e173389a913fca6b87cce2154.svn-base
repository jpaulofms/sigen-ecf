package com.sigen.ecf.model.operacao.impl;

import com.sigen.ecf.exception.EcfException;
import com.sigen.ecf.exception.FaltaPapelException;
import com.sigen.ecf.exception.OperacaoException;
import com.sigen.ecf.exception.PoucoPapelException;
import com.sigen.ecf.exception.TratamentoException;
import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.model.operacao.IOperacao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.persistencia.DAOFacade;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

/**
 * @author SIGEN 3
 */
public class OPVendaItem extends Operacao implements IOperacao {

    @Override
    protected boolean validaTransacao(Map parametros) throws OperacaoException {
        return true;
    }

    @Override
    protected void iniciar(Map parametros) throws OperacaoException {
    }

    @Override
    protected Map efetuar(Map parametros) throws OperacaoException {
        IECFService ecfService = ECFServiceFactory.getInstance().criarECFService();
        Map mpRetorno = parametros;
        try {
            BeanItemVenda itemVenda = ((BeanItemVenda) parametros.get("BeanItemVenda"));
            BeanVenda beanVenda = ((BeanVenda) parametros.get("BeanVenda"));
            String aliqIcmsString = itemVenda.getIcmsAliq().compareTo(BigDecimal.TEN) >= 0 ? (itemVenda.getIcmsAliq().toString().replace(",", ""))
                    .replace(".", "") : ("0" + itemVenda.getIcmsAliq().toString().replace(",", "")).replace(".", "");

            NumberFormat formatECF = DecimalFormat.getInstance();
            ecfService.vendeItem(
                    String.valueOf(itemVenda.getCodProd()),
                    String.valueOf(itemVenda.getDescricao()),
                    String.valueOf(aliqIcmsString),
                    formatECF.format(itemVenda.getQuantidadeVendida()),
                    String.valueOf(itemVenda.getValorUnitario().setScale(
                    2, BigDecimal.ROUND_HALF_UP)),
                    formatECF.format(itemVenda.getValorDesconto() != null ? itemVenda.getValorDesconto() : BigDecimal.ZERO),
                    String.valueOf(itemVenda.getIcmsSt().equals("60") ? "FF" : "I"));

            itemVenda.setDataEmissao((ecfService.getData()));
            itemVenda.setCoo(beanVenda.getCoo());
            itemVenda.setSt(itemVenda.getIcmsSt().equals("60") ? "FF" : "I");

            /* Gravar item de venda */
            DAOFacade.inserirItemVenda(itemVenda);

            /* Sobrescrever objeto item de Venda */
            mpRetorno.remove("BeanItemVenda");
            mpRetorno.put("BeanItemVenda", itemVenda);

        } catch (EcfException ex) {
            TratamentoException.tratar(ex);
        } catch (FaltaPapelException ex) {
            TratamentoException.tratar(ex);
        } catch (PoucoPapelException ex) {
            TratamentoException.tratar(ex);
        } catch (Exception ex) {
            TratamentoException.tratar(ex);
        }
        return mpRetorno;
    }

    @Override
    protected void finalizar(Map parametros) throws OperacaoException {
    }
}
