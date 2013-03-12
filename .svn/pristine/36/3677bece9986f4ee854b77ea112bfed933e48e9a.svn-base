/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.persistencia.dao.IDAOCliente;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulisson@sigensistemas.com.br
 */
public class DAOCliente extends DAOAbstract implements IDAOCliente {

    @Override
    public void inserir(BeanCliente clienteBean) {

        sql = "INSERT INTO CAD_CLIENTE("
                + " COD_CLI,"
                + " NOME,"
                + " CPF_CNPJ"
                + " VALUES(".concat(UTILBiblioteca.repeteStringDAO("?", 3)).concat(")");

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, clienteBean.getCodCliente());
            pstm.setString(2, clienteBean.getNome());
            pstm.setString(3, clienteBean.getCpfCnpj());

            pstm.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }

    }

    @Override
    public void atualizar(BeanCliente clienteBeanNovo, BeanCliente clienteBeanAntigo) {

        sql = "UPDATE CAD_CLIENTE SET"
                + " COD_CLI = ?,"
                + " NOME = ?,"
                + " CPF_CNPJ = ?";

        sql = sql.concat(aplicarFiltro(clienteBeanAntigo));

        try {
            pstm = bd.conectar().prepareStatement(sql);

            pstm.setString(1, clienteBeanNovo.getCodCliente());
            pstm.setString(2, clienteBeanNovo.getNome());
            pstm.setString(3, clienteBeanNovo.getCpfCnpj());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }

    }

    @Override
    public List<BeanCliente> pesquisa(BeanCliente clienteBean) {

        sql = "SELECT"
                + " COD_CLI,"
                + " NOME,"
                + " CPF_CNPJ "
                + " FROM CAD_CLIENTE";

        sql = sql.concat(aplicarFiltro(clienteBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanCliente> listaCliente = new ArrayList<BeanCliente>();

            while (rs.next()) {
                BeanCliente cliente = new BeanCliente();

                cliente.setCodCliente(rs.getString("COD_CLI"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpfCnpj(rs.getString("CPF_CNPJ"));

                listaCliente.add(cliente);
            }

            return listaCliente;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanCliente>();
        } finally {
            bd.desconectar();
        }

    }

    @Override
    public void remover(BeanCliente clienteBean) {

        sql = "DELETE FROM CAD_CLIENTE";
        sql = sql.concat(aplicarFiltro(clienteBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }

    }

    private String aplicarFiltro(BeanCliente clienteBean) {
        String filtro = " WHERE 1 = 1";

        // COD_CLI
        /*if (clienteBean.getCodCliente() != null && !clienteBean.getCodCliente().equals("")) {
         filtro = filtro.concat(" AND COD_CLI = ".concat(clienteBean.getCodCliente()));
         }*/

        // NOME
        /*if (clienteBean.getNome() != null && !clienteBean.getNome().equals("")) {
         filtro = filtro.concat(" AND NOME LIKE '".concat(clienteBean.getNome()).concat("%'"));
         }*/

        // CPF_CNPJ
        if (clienteBean.getCpfCnpj() != null && !clienteBean.getCpfCnpj().equals("")) {
            filtro = filtro.concat(" AND CPF_CNPJ = '".concat(clienteBean.getCpfCnpj()).concat("'"));
        }
        return filtro;
    }
}
