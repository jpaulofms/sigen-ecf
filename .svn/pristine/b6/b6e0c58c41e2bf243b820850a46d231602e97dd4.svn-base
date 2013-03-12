/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.negocio.ctrl;

import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.persistencia.dao.IDAOMovimento;
import com.sigen.ecf.persistencia.dao.impl.DAOMovimento;
import com.sigen.ecf.view.VIEWLoginEncerrarMovimento;
import com.sigen.ecf.view.VIEWLoginGerente;
import com.sigen.ecf.view.VIEWLoginIniciarMovimento;
import com.sigen.ecf.view.VIEWLoginIniciarMovimentoAberto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CTRLMovimento {

    private IDAOMovimento iMovimento;
    private VIEWLoginIniciarMovimento iniciarMovimentoVIEW;
    private VIEWLoginIniciarMovimentoAberto iniciarMovimentoAbertoVIEW;
    private VIEWLoginEncerrarMovimento encerrarMovimentoVIEW;
    private VIEWLoginGerente gerenteVIEW;

    public CTRLMovimento() {
        this.iMovimento = new DAOMovimento();
    }

    public void inserir(BeanMovimento MovimentoBean) {
        try {
            this.iMovimento.inserir(MovimentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Movimento) Insert: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizar(BeanMovimento MovimentoNovo, BeanMovimento MovimentoAntigo) {
        try {
            this.iMovimento.atualizar(MovimentoNovo, MovimentoAntigo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Movimento) Update: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BeanMovimento> pesquisa(BeanMovimento MovimentoBean) {
        try {
            return this.iMovimento.pesquisa(MovimentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Movimento) Select: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<BeanMovimento>();
        }
    }

    public void remover(BeanMovimento MovimentoBean) {
        try {
            this.iMovimento.remover(MovimentoBean);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Movimento) Delete: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<BeanOperador> getListaOperadorSupervisor(boolean flagOperador) {
        if (flagOperador) {
            return CTRLCaixa.pesquisaOperador(new BeanOperador());
        }
        return CTRLCaixa.pesquisaSupervisor(new BeanOperador());
    }

    public void encerrarMovimento() {
        try {
            // Tela de encerrar de movimento
/*            VIEWLoginEncerrarMovimento loginEncerrarMovimento = new VIEWLoginEncerrarMovimento(null, true);
             loginEncerrarMovimento.setVisible(true);

             // não efetuar nenhuma ação caso cancelado
             if (!loginEncerrarMovimento.cancelado) {
             if (autenticarLogin(loginEncerrarMovimento.getLoginOperador(), loginEncerrarMovimento.getSenhaOperador())
             && autenticarLogin(loginEncerrarMovimento.getLoginGerente().getNome(), loginEncerrarMovimento.getSenhaGerente())) {
             // Ações
             } else {
             encerrarMovimento();
             }
             }*/
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Movimento) Encerrar: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean iniciarMovimento() {
        try {
            // Tela de inicio de movimento
            //          iniciarMovimentoVIEW = new VIEWLoginIniciarMovimento(null, true);
            //        iniciarMovimentoVIEW.setVisible(true);

            // não efetuar nenhuma ação caso cancelado
            //      if (!iniciarMovimentoVIEW.cancelado) {
                /*                if (autenticarLogin(iniciarMovimentoVIEW.getLoginOperador(), iniciarMovimentoVIEW.getSenhaOperador())
             && autenticarLogin(iniciarMovimentoVIEW.getLoginGerente(), iniciarMovimentoVIEW.getSenhaGerente())) {
             // Ações
             return true;
             } else {
             return iniciarMovimento();
             }*/
            //    }
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "(Movimento)", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void iniciarMovimentoAberto() {
        try {
            // Tela de inicio de movimento
//            VIEWLoginIniciarMovimentoAberto loginIniciarMovimentoAberto = new VIEWLoginIniciarMovimentoAberto(null, true, this, getListaOperadorSupervisor(false));
            //          loginIniciarMovimentoAberto.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "(Movimento) Iniciar: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean analisarMovimento() {
        try {
            // Analisar a aplicação e determinar qual tela deve ser aberta. VIEWLoginMovimentoAberto ou VIEWLoginIniciarMovimento
            // Lógica de verificação de situação da aplicação
            return iniciarMovimento();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Analisar movimento: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean autenticarLoginGerente() {

        // coletar dados para autenticar usuário
        VIEWLoginGerente loginGerente = new VIEWLoginGerente(null, true, getListaOperadorSupervisor(false));
        loginGerente.setVisible(true);
        if (!loginGerente.cancelado) {
            if (!autenticarLogin(loginGerente.getLoginGerente().getNome(), loginGerente.getSenhaGerente())) {
                autenticarLoginGerente();
            }
            return true;
        }
        return false;
    }

    private boolean autenticarLogin(String loginOperador, String senhaOperador) {
        try {
            // Validar usuários e senhas e determinar ações de tela
            senhaOperador = "123";
            if (senhaOperador.equals("123")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Autenticar login: ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
