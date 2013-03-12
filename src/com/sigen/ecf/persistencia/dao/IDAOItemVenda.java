/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanItemVenda;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOItemVenda {

    public void inserir(BeanItemVenda beanVendaDetalhe) throws Exception;

    public void atualizar(BeanItemVenda cfopNovo, BeanItemVenda cfopAntigo) throws Exception;

    public List<BeanItemVenda> pesquisa(BeanItemVenda beanVendaDetalhe) throws Exception;

    public void remover(BeanItemVenda beanVendaDetalhe) throws Exception;
}
