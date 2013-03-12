/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanFormaPagamento;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOFormaPagamento {

    public void inserir(BeanFormaPagamento beanFormaPagamento) throws Exception;

    public void atualizar(BeanFormaPagamento cfopNovo, BeanFormaPagamento cfopAntigo) throws Exception;

    public List<BeanFormaPagamento> pesquisa(BeanFormaPagamento beanFormaPagamento) throws Exception;

    public List<BeanFormaPagamento> pesquisaFormaCondicaoPagamento(String codCondPagto) throws Exception;

    public void remover(BeanFormaPagamento beanFormaPagamento) throws Exception;
}
