/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanSangria;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOSangria {

    public void inserir(BeanSangria beanSangria) throws Exception;

    public void atualizar(BeanSangria cfopNovo, BeanSangria cfopAntigo) throws Exception;

    public List<BeanSangria> pesquisa(BeanSangria beanSangria) throws Exception;

    public void remover(BeanSangria beanSangria) throws Exception;
}
