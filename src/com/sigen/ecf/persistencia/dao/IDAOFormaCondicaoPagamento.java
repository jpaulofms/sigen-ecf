/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanFormaCondicaoPagamento;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOFormaCondicaoPagamento {

    public void inserir(BeanFormaCondicaoPagamento beanFormaCondicaoPagamento) throws Exception;

    public void atualizar(BeanFormaCondicaoPagamento cfopNovo, BeanFormaCondicaoPagamento cfopAntigo) throws Exception;

    public List<BeanFormaCondicaoPagamento> pesquisa(BeanFormaCondicaoPagamento beanFormaCondicaoPagamento) throws Exception;

    public void remover(BeanFormaCondicaoPagamento beanFormaCondicaoPagamento) throws Exception;
}
