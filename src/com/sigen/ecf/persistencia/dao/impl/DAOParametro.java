/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.model.bean.BeanParametro;
import com.sigen.ecf.persistencia.dao.IDAOParametro;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DAOParametro extends DAOAbstract implements IDAOParametro {

    @Override
    public void inserir(BeanParametro parametroBean) {

        sql = "INSERT INTO CAD_PARAM("
                + " FLUTILIZACENTRAL,"
                + " ISS,"
                + " RAZSOC,"
                + " FANTASIA,"
                + " ENDERECO,"
                + " NUMERO,"
                + " COMPLEMENTO,"
                + " CIDADE,"
                + " ESTADO,"
                + " CGCCPF,"
                + " INSCRICAO,"
                + " DTPROC,"
                + " CODEVESALDOCXA,"
                + " CONDPGTODEFAULT,"
                + " CODEVEDEFAULT,"
                + " LIMITESANGRIA,"
                + " TIPOSISTEMA,"
                + " MSGPROMPDV,"
                + " CODFIL,"
                + " FLABATECOMISSAO,"
                + " FLVALIDAESTOQPDV)"
                + " VALUES (".concat(UTILBiblioteca.repeteStringDAO("?", 21));

        try {
            pstm = bd.conectar().prepareCall(sql);

            pstm.setString(1, parametroBean.getFlUtilizaCentral());
            pstm.setString(2, parametroBean.getISS());
            pstm.setString(3, parametroBean.getRazSoc());
            pstm.setString(4, parametroBean.getFantasia());
            pstm.setString(5, parametroBean.getEndereco());
            pstm.setString(6, parametroBean.getNumero());
            pstm.setString(7, parametroBean.getComplemento());
            pstm.setString(8, parametroBean.getCidade());
            pstm.setString(9, parametroBean.getEstado());
            pstm.setString(10, parametroBean.getCgcCpf());
            pstm.setString(11, parametroBean.getInscricao());
            pstm.setDate(12, new java.sql.Date(parametroBean.getDtProc().getTime()));
            pstm.setString(13, parametroBean.getCodEveSaldoCxa());
            pstm.setString(14, parametroBean.getCondPgtoDefault());
            pstm.setString(15, parametroBean.getCodEveDefault());
            pstm.setString(16, parametroBean.getLimiteSangria());
            pstm.setString(17, parametroBean.getTipoSistema());
            pstm.setString(18, parametroBean.getMsgPromPDV());
            pstm.setString(19, parametroBean.getCodFil());
            pstm.setString(20, parametroBean.getFlAbateComissao());
            pstm.setString(21, parametroBean.getFlValidadeEstoqPDV());

            pstm.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void atualizar(BeanParametro parametroBeanNovo, BeanParametro parametroBeanAntigo) {

        sql = "UPDATE CAD_PARAM SET"
                + " FLUTILIZACENTRAL = ?,"
                + " ISS = ?,"
                + " RAZSOC = ?,"
                + " FANTASIA = ?,"
                + " ENDERECO = ?,"
                + " NUMERO = ?,"
                + " COMPLEMENTO = ?,"
                + " CIDADE = ?,"
                + " ESTADO = ?,"
                + " CGCCPF = ?,"
                + " INSCRICAO = ?,"
                + " DTPROC = ?,"
                + " CODEVESALDOCXA = ?,"
                + " CONDPGTODEFAULT = ?,"
                + " CODEVEDEFAULT = ?,"
                + " LIMITESANGRIA = ?,"
                + " TIPOSISTEMA = ?,"
                + " MSGPROMPDV = ?,"
                + " CODFIL = ?,"
                + " FLABATECOMISSAO = ?,"
                + " FLVALIDAESTOQPDV = ?";

        sql = sql.concat(aplicarFiltro(parametroBeanAntigo));

        try {
            pstm = bd.conectar().prepareCall(sql);

            pstm.setString(1, parametroBeanNovo.getFlUtilizaCentral());
            pstm.setString(2, parametroBeanNovo.getISS());
            pstm.setString(3, parametroBeanNovo.getRazSoc());
            pstm.setString(4, parametroBeanNovo.getFantasia());
            pstm.setString(5, parametroBeanNovo.getEndereco());
            pstm.setString(6, parametroBeanNovo.getNumero());
            pstm.setString(7, parametroBeanNovo.getComplemento());
            pstm.setString(8, parametroBeanNovo.getCidade());
            pstm.setString(9, parametroBeanNovo.getEstado());
            pstm.setString(10, parametroBeanNovo.getCgcCpf());
            pstm.setString(11, parametroBeanNovo.getInscricao());
            pstm.setDate(12, new java.sql.Date(parametroBeanNovo.getDtProc().getTime()));
            pstm.setString(13, parametroBeanNovo.getCodEveSaldoCxa());
            pstm.setString(14, parametroBeanNovo.getCondPgtoDefault());
            pstm.setString(15, parametroBeanNovo.getCodEveDefault());
            pstm.setString(16, parametroBeanNovo.getLimiteSangria());
            pstm.setString(17, parametroBeanNovo.getTipoSistema());
            pstm.setString(18, parametroBeanNovo.getMsgPromPDV());
            pstm.setString(19, parametroBeanNovo.getCodFil());
            pstm.setString(20, parametroBeanNovo.getFlAbateComissao());
            pstm.setString(21, parametroBeanNovo.getFlValidadeEstoqPDV());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public List<BeanParametro> pesquisa(BeanParametro parametroBean) {

        sql = "SELECT"
                + " FLUTILIZACENTRAL,"
                + " ISS,"
                + " RAZSOC,"
                + " FANTASIA,"
                + " ENDERECO,"
                + " NUMERO,"
                + " COMPLEMENTO,"
                + " CIDADE,"
                + " ESTADO,"
                + " CGCCPF,"
                + " INSCRICAO,"
                + " DTPROC,"
                + " CODEVESALDOCXA,"
                + " CONDPGTODEFAULT,"
                + " CODEVEDEFAULT,"
                + " LIMITESANGRIA,"
                + " TIPOSISTEMA,"
                + " MSGPROMPDV,"
                + " CODFIL,"
                + " FLABATECOMISSAO,"
                + " FLVALIDAESTOQPDV"
                + " FROM CAD_PARAM";

        sql = sql.concat(aplicarFiltro(parametroBean));

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(sql);
            List<BeanParametro> listaParametro = new ArrayList<BeanParametro>();

            while (rs.next()) {
                BeanParametro parametro = new BeanParametro();

                parametro.setFlUtilizaCentral(rs.getString("FLUTILIZACENTRAL"));
                parametro.setISS(rs.getString("ISS"));
                parametro.setRazSoc(rs.getString("RAZSOC"));
                parametro.setFantasia(rs.getString("FANTASIA"));
                parametro.setEndereco(rs.getString("ENDERECO"));
                parametro.setNumero(rs.getString("NUMERO"));
                parametro.setComplemento(rs.getString("COMPLEMENTO"));
                parametro.setCidade(rs.getString("CIDADE"));
                parametro.setEstado(rs.getString("ESTADO"));
                parametro.setCgcCpf(rs.getString("CGCCPF"));
                parametro.setInscricao(rs.getString("INSCRICAO"));
                parametro.setDtProc(rs.getDate("DTPROC"));
                parametro.setCodEveSaldoCxa(rs.getString("CODEVESALDOCXA"));
                parametro.setCondPgtoDefault(rs.getString("CONDPGTODEFAULT"));
                parametro.setCodEveDefault(rs.getString("CODEVEDEFAULT"));
                parametro.setLimiteSangria(rs.getString("LIMITESANGRIA"));
                parametro.setTipoSistema(rs.getString("TIPOSISTEMA"));
                parametro.setMsgPromPDV(rs.getString("MSGPROMPDV"));
                parametro.setCodFil(rs.getString("CODFIL"));
                parametro.setFlAbateComissao(rs.getString("FLABATECOMISSAO"));
                parametro.setFlValidadeEstoqPDV(rs.getString("FLVALIDAESTOQPDV"));

                listaParametro.add(parametro);
            }
            return listaParametro;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<BeanParametro>();
        } finally {
            bd.desconectar();
        }
    }

    @Override
    public void remover(BeanParametro parametroBean) {

        sql = "DELETE FROM CAD_PARAM";
        sql = sql.concat(aplicarFiltro(parametroBean));

        try {
            stm = bd.conectar().createStatement();
            stm.executeQuery(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bd.desconectar();
        }

    }

    private String aplicarFiltro(BeanParametro parametroBean) {

        String filtro = " WHERE 1 = 1";

        // FLUTILIZACENTRAL
        if (parametroBean.getFlUtilizaCentral() != null && !parametroBean.getFlUtilizaCentral().equals("")) {
            filtro = filtro.concat(" AND FLUTILIZACENTRAL = '".concat(parametroBean.getFlUtilizaCentral()).concat("'"));
        }

        // ISS
        if (parametroBean.getISS() != null && !parametroBean.getISS().equals("")) {
            filtro = filtro.concat(" AND ISS = ".concat(parametroBean.getISS()));
        }

        // RAZSOC
        if (parametroBean.getRazSoc() != null && !parametroBean.getRazSoc().equals("")) {
            filtro = filtro.concat(" AND RAZSOC LIKE '".concat(parametroBean.getRazSoc()).concat("%'"));
        }

        // FANTASIA
        if (parametroBean.getFantasia() != null && !parametroBean.getFantasia().equals("")) {
            filtro = filtro.concat(" AND FANTASIA LIKE '".concat(parametroBean.getFantasia()).concat("%'"));
        }

        // ENDERECO
        if (parametroBean.getEndereco() != null && !parametroBean.getEndereco().equals("")) {
            filtro = filtro.concat(" AND ENDERECO LIKE '".concat(parametroBean.getEndereco()).concat("%'"));
        }

        // NUMERO
        if (parametroBean.getNumero() != null && !parametroBean.getNumero().equals("")) {
            filtro = filtro.concat(" AND NUMERO = ".concat(parametroBean.getNumero()));
        }

        // COMPLEMENTO
        if (parametroBean.getComplemento() != null && !parametroBean.getComplemento().equals("")) {
            filtro = filtro.concat(" AND COMPLEMENTO = '".concat(parametroBean.getComplemento()).concat("'"));
        }

        // CIDADE
        if (parametroBean.getCidade() != null && !parametroBean.getCidade().equals("")) {
            filtro = filtro.concat(" AND CIDADE  = '".concat(parametroBean.getCidade()).concat("'"));
        }

        // ESTADO
        if (parametroBean.getEstado() != null && !parametroBean.getEstado().equals("")) {
            filtro = filtro.concat(" AND ESTADO = '".concat(parametroBean.getEstado()).concat("'"));
        }

        // CGCCPF
        if (parametroBean.getCgcCpf() != null && !parametroBean.getCgcCpf().equals("")) {
            filtro = filtro.concat(" AND CGCCPF = '".concat(parametroBean.getCgcCpf()).concat("'"));
        }

        // INSCRICAO
        if (parametroBean.getInscricao() != null && !parametroBean.getInscricao().equals("")) {
            filtro = filtro.concat(" AND INSCRICAO = '".concat(parametroBean.getInscricao()).concat("'"));
        }

        // DTPROC
        if (parametroBean.getDtProc() != null && !parametroBean.getDtProc().equals("")) {
            filtro = filtro.concat(" AND DTPROC = '".concat(sdf.format(parametroBean.getDtProc().getTime())).concat("'"));
        }

        // CODEVESALDOCXA
        if (parametroBean.getCodEveSaldoCxa() != null && !parametroBean.getCodEveSaldoCxa().equals("")) {
            filtro = filtro.concat(" AND CODEVESALDOCXA = '".concat(parametroBean.getCodEveSaldoCxa()).concat("'"));
        }

        // CONDPGTODEFAULT 
        if (parametroBean.getCondPgtoDefault() != null && !parametroBean.getCondPgtoDefault().equals("")) {
            filtro = filtro.concat(" AND CONDPGTODEFAULT = '".concat(parametroBean.getCondPgtoDefault()).concat("'"));
        }

        // CODEVEDEFAULT
        if (parametroBean.getCodEveDefault() != null && !parametroBean.getCodEveDefault().equals("")) {
            filtro = filtro.concat(" AND CODEVEDEFAULT = '".concat(parametroBean.getCodEveDefault()).concat("'"));
        }

        // LIMITESANGRIA
        if (parametroBean.getLimiteSangria() != null && !parametroBean.getLimiteSangria().equals("")) {
            filtro = filtro.concat(" AND LIMITESANGRIA = ".concat(parametroBean.getLimiteSangria()));
        }

        // TIPOSISTEMA
        if (parametroBean.getTipoSistema() != null && !parametroBean.getTipoSistema().equals("")) {
            filtro = filtro.concat(" AND TIPOSISTEMA = '".concat(parametroBean.getTipoSistema()).concat("'"));
        }

        // MSGPROMPDV
        if (parametroBean.getMsgPromPDV() != null && !parametroBean.getMsgPromPDV().equals("")) {
            filtro = filtro.concat(" AND MSGPROMPDV LIKE '".concat(parametroBean.getMsgPromPDV()).concat("%'"));
        }

        // CODFIL
        if (parametroBean.getCodFil() != null && !parametroBean.getCodFil().equals("")) {
            filtro = filtro.concat(" AND CODFIL = ".concat(parametroBean.getCodFil()));
        }

        // FLABATECOMISSAO
        if (parametroBean.getFlAbateComissao() != null && !parametroBean.getFlAbateComissao().equals("")) {
            filtro = filtro.concat(" AND FLABATECOMISSAO = '".concat(parametroBean.getFlAbateComissao()).concat("'"));
        }

        // FLVALIDAESTOQPDV
        if (parametroBean.getFlValidadeEstoqPDV() != null && !parametroBean.getFlValidadeEstoqPDV().equals("")) {
            filtro = filtro.concat(" AND FLVALIDAESTOQPDV = '".concat(parametroBean.getFlValidadeEstoqPDV()).concat("'"));
        }

        return filtro;
    }
}
