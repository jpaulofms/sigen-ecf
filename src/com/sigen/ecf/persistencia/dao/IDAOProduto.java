/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanProduto;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOProduto {

    public void inserir(BeanProduto beanProduto) throws Exception;

    public void atualizar(BeanProduto cfopNovo, BeanProduto cfopAntigo) throws Exception;

    public List<BeanProduto> pesquisa(BeanProduto beanProduto) throws Exception;

    public BeanProduto pesquisarProduto(String codProduto) throws Exception;

    public BeanProduto pesquisarProdutoCodBarra(String codBarra) throws Exception;

    public void remover(BeanProduto beanProduto) throws Exception;
}