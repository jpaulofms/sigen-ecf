/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanVendedor;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOVendedor {

    public void inserir(BeanVendedor beanVendedor) throws Exception;

    public void atualizar(BeanVendedor cfopNovo, BeanVendedor cfopAntigo) throws Exception;

    public List<BeanVendedor> pesquisa(BeanVendedor beanVendedor) throws Exception;

    public void remover(BeanVendedor beanVendedor) throws Exception;
}
