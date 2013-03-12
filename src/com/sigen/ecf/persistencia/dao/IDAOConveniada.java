/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanConveniada;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOConveniada {

    public void inserir(BeanConveniada beanConveniada) throws Exception;

    public void atualizar(BeanConveniada cfopNovo, BeanConveniada cfopAntigo) throws Exception;

    public List<BeanConveniada> pesquisa(BeanConveniada beanConveniada) throws Exception;

    public List<BeanConveniada> pesquisaConveniadaFormaPagamento(String codFormaPagamento) throws Exception;

    public void remover(BeanConveniada beanConveniada) throws Exception;
}
