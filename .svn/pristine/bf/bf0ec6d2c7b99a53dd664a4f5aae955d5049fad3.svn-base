/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.persistencia.dao.IDAOOperador;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOOperador extends DAOAbstract implements IDAOOperador {

    @Override
    public void inserir(BeanOperador operadorBean) {

        sql = "INSERT INTO CAD_OPERADOR("
                + " COD_OPERADOR,"
                + " NOME,"
                + " SENHA,"
                + " SUPERVISOR)"
                + " VALEUS (".concat(UTILBiblioteca.repeteStringDAO("?", 4)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, operadorBean.getCodOper());
            pstm.setString(2, operadorBean.getNome());
            pstm.setString(3, operadorBean.getSenha());
            pstm.setBoolean(4, operadorBean.isSupervisor());

            pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanOperador operadorBeanNovo, BeanOperador operadorBeanAntigo) {

        sql = "UPDATE CAD_OPERADOR SET"
                + " COD_OPERADOR = ?,"
                + " SENHA = ?,"
                + " NOME = ?,"
                + " SUPERVISOR = ?";

        sql = sql.concat(aplicarFiltro(operadorBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, operadorBeanNovo.getCodOper());
            pstm.setString(2, operadorBeanNovo.getNome());
            pstm.setString(3, operadorBeanNovo.getSenha());
            pstm.setBoolean(4, operadorBeanNovo.isSupervisor());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanOperador> pesquisa(BeanOperador operadorBean) {

        sql = "SELECT"
                + " COD_OPERADOR,"
                + " NOME,"
                + " SENHA,"
                + " SUPERVISOR"
                + " FROM CAD_OPERADOR";

        sql = sql.concat(aplicarFiltro(operadorBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanOperador> listaOperador = new ArrayList<BeanOperador>();

            while (rs.next()) {
                BeanOperador operador = new BeanOperador();

                operador.setCodOper(rs.getString("COD_OPERADOR"));
                operador.setNome(rs.getString("NOME"));
                operador.setSenha(rs.getString("SENHA"));
                operador.setSupervisor(rs.getBoolean("SUPERVISOR"));

                listaOperador.add(operador);
            }
            return listaOperador;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanOperador>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanOperador operadorBean) {

        sql = "DELETE FROM CAS_OPERADOR";
        sql = sql.concat(aplicarFiltro(operadorBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    private String aplicarFiltro(BeanOperador operadorBean) {
        String filtro = " WHERE 1 = 1";

        // CODOPER
        if (operadorBean.getCodOper() != null && !operadorBean.getCodOper().equals("")) {
            filtro = filtro.concat(" AND COD_OPERADOR = '".concat(operadorBean.getCodOper()).concat("'"));
        }

        // NOME
        if (operadorBean.getNome() != null && !operadorBean.getNome().equals("")) {
            filtro = filtro.concat(" AND NOME LIKE '".concat(operadorBean.getNome()).concat("%'"));
        }

        // SENHA
        if (operadorBean.getSenha() != null && !operadorBean.getSenha().equals("")) {
            filtro = filtro.concat(" AND SENHA = '".concat(operadorBean.getSenha()).concat("'"));
        }

        // SUPERVISOR
        filtro = filtro.concat(" AND SUPERVISOR = " + operadorBean.isSupervisor());


        return filtro;
    }
}
