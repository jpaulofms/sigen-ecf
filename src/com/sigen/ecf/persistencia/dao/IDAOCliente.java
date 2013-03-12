/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanCliente;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOCliente {

    public void inserir(BeanCliente beanCliente) throws Exception;

    public void atualizar(BeanCliente cfopNovo, BeanCliente cfopAntigo) throws Exception;

    public List<BeanCliente> pesquisa(BeanCliente beanCliente) throws Exception;

    public void remover(BeanCliente beanCliente) throws Exception;
}