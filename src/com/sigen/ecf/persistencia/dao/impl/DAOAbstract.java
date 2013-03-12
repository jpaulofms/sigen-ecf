/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.persistencia.dao.impl;

import com.sigen.ecf.persistencia.BDConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author Administrador
 */
public abstract class DAOAbstract {

    protected String sql;
    protected Statement stm;
    protected PreparedStatement pstm;
    protected ResultSet rs;
    protected BDConnection bd = new BDConnection();
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
}
