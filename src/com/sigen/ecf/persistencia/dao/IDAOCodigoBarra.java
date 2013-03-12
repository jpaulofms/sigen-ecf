/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao;

import com.sigen.ecf.model.bean.BeanCodigoBarra;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOCodigoBarra {

    public void inserir(BeanCodigoBarra beanCodigoBarra) throws Exception;

    public void atualizar(BeanCodigoBarra beanCodigoBarraNovo, BeanCodigoBarra beanCodigoBarraAntigo) throws Exception;

    public List<BeanCodigoBarra> pesquisa(BeanCodigoBarra beanCodigoBarra) throws Exception;

    public void remover(BeanCodigoBarra beanCodigoBarra) throws Exception;
}
