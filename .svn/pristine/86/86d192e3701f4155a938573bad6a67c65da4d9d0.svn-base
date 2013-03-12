/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.view.util.UTILBiblioteca;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SIGEN 3
 */
public class CTRLBobina {

    public List<String> cabecalhoBobina(BeanCliente beanCliente) {
        List<String> lsModelBobina = new ArrayList<String>();

        lsModelBobina.add(UTILBiblioteca.repete("-", 48));
        lsModelBobina.add("           ** CUPOM FISCAL **           ");
        lsModelBobina.add(("CNPJ/CPF CONSUMIDOR: " + beanCliente.getCpfCnpj()));
        lsModelBobina.add(UTILBiblioteca.repete("-", 48));
        lsModelBobina.add("ITEM CÓDIGO         DESCRIÇÃO                   ");
        lsModelBobina.add("QTD UN   VL.UNIT.(R$) ST     VL.ITEM(R$)");
        lsModelBobina.add(UTILBiblioteca.repete("-", 48));

        return lsModelBobina;
    }

    public String getItemBobina(BeanProduto produto, String item) {
        String itemBobina =
                UTILBiblioteca.repete("0", 3 - String.valueOf(item).length()) + item
                + "  "
                + produto.getEan() + UTILBiblioteca.repete(" ", 14 - produto.getEan().length())
                + " "
                + produto.getDescricao();

        return itemBobina;
    }

    public List<String> cancelarItemBobina(BeanProduto produto, String itemCancelado) {
        List<String> lsItemCancelado = new ArrayList<String>();
        lsItemCancelado.add(UTILBiblioteca.repete("*", 48));
        lsItemCancelado.add(UTILBiblioteca.repete("0", 3 - itemCancelado.length()) + itemCancelado
                + "  " + produto.getEan() + UTILBiblioteca.repete(" ", 14 - produto.getEan().length())
                + "  " + produto.getDescricao());

        lsItemCancelado.add("ITEM CANCELADO");
        lsItemCancelado.add(UTILBiblioteca.repete("*", 48));

        return lsItemCancelado;
    }

    public String getItemValorBobina(BeanProduto produto, String quantidade, BigDecimal totalItem) {
        String unidadeProduto = produto.getUndDescricao();

        if (unidadeProduto.length() >= 3) {
            unidadeProduto = unidadeProduto.substring(0, 3);
        } else {
            unidadeProduto += UTILBiblioteca.repete(" ", 3 - unidadeProduto.length());
        }

        String itemValorBobina =
                UTILBiblioteca.repete(" ", 3 - quantidade.length()) + quantidade
                + " "
                + unidadeProduto
                + " x "
                + UTILBiblioteca.repete(" ", 7 - produto.getPrecoVenda().toString().length()) + UTILBiblioteca.formatoDecimal("V", produto.getPrecoVenda())
                + "  "
                + UTILBiblioteca.repete(" ", 5 - produto.getIcmsSt().length()) + produto.getIcmsSt()
                + UTILBiblioteca.repete(" ", 10 - totalItem.toString().length()) + UTILBiblioteca.formatoDecimal("V", totalItem);

        return itemValorBobina;
    }
}
