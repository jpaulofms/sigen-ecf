/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view;

import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.persistencia.DAOFacade;
import com.sigen.ecf.persistencia.dao.impl.DAOOperador;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class VIEWLoginIniciarMovimentoAberto extends javax.swing.JDialog {

    private List<BeanOperador> lsGerente;
    private BeanOperador beanOperador;
    private Map mpParametros;
    public boolean cancelado = true;

    public VIEWLoginIniciarMovimentoAberto(java.awt.Frame parent, boolean modal, Map parametros, boolean saidaTemporaria) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        configurarComportamentoENTER();
        mpParametros = parametros;
        buscarOperador();
        preencherCombos();
        setTitle("Iniciar Movimento Aberto");
        if (saidaTemporaria) {
            botaoCancela.setEnabled(false);
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } else {
            CancelaAction cancelaAction = new CancelaAction();
            botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
            botaoCancela.getActionMap().put("cancelaAction", cancelaAction);
        }


        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelOperador = new javax.swing.JPanel();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        panelGerente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editSenhaGerente = new javax.swing.JPasswordField();
        cbbLoginGerente = new javax.swing.JComboBox();
        panelDadosMovimento = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        labelOperador = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editSenhaOperador = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Encerra Movimento de Caixa");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaMonitor04.png"))); // NOI18N

        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelOperador.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelOperador, gridBagConstraints);

        panelBotoes.setBackground(new Color(255,255,255,0));

        botaoConfirma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoConfirmar.png"))); // NOI18N
        botaoConfirma.setText("Confirma (ENTER)");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });

        botaoCancela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoCancelar.png"))); // NOI18N
        botaoCancela.setText("Cancela (ESC)");
        botaoCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoConfirma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoCancela)
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirma)
                    .addComponent(botaoCancela))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGerente.setBackground(new Color(255,255,255,0));
        panelGerente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Gerente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Login:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Senha:");

        editSenhaGerente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cbbLoginGerente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelGerenteLayout = new javax.swing.GroupLayout(panelGerente);
        panelGerente.setLayout(panelGerenteLayout);
        panelGerenteLayout.setHorizontalGroup(
            panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbbLoginGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editSenhaGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20))
        );
        panelGerenteLayout.setVerticalGroup(
            panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGerenteLayout.createSequentialGroup()
                .addGroup(panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLoginGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editSenhaGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelDadosMovimento.setBackground(new Color(255,255,255,0));
        panelDadosMovimento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do movimento aberto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Operador:");

        labelOperador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelOperador.setText("jLabel10");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Senha:");

        editSenhaOperador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editSenhaOperador.setPreferredSize(new java.awt.Dimension(111, 20));

        javax.swing.GroupLayout panelDadosMovimentoLayout = new javax.swing.GroupLayout(panelDadosMovimento);
        panelDadosMovimento.setLayout(panelDadosMovimentoLayout);
        panelDadosMovimentoLayout.setHorizontalGroup(
            panelDadosMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosMovimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(labelOperador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDadosMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(editSenhaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        panelDadosMovimentoLayout.setVerticalGroup(
            panelDadosMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosMovimentoLayout.createSequentialGroup()
                .addGroup(panelDadosMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosMovimentoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(9, 9, 9)
                        .addComponent(labelOperador)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosMovimentoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editSenhaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelDadosMovimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 19, Short.MAX_VALUE))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(panelDadosMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDadosMovimento.getAccessibleContext().setAccessibleName("");

        getContentPane().add(panelPrincipal, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botaoCancelaActionPerformed

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        validarLogin();
    }//GEN-LAST:event_botaoConfirmaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbbLoginGerente;
    private javax.swing.JPasswordField editSenhaGerente;
    private javax.swing.JPasswordField editSenhaOperador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelOperador;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelDadosMovimento;
    private javax.swing.JPanel panelGerente;
    private javax.swing.JPanel panelOperador;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private class ConfirmaAction extends AbstractAction {

        public ConfirmaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private void configurarComportamentoENTER() {
        editSenhaOperador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cbbLoginGerente.requestFocus();
                }
            }
        });
        cbbLoginGerente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    editSenhaGerente.requestFocus();
                }
            }
        });
        editSenhaGerente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botaoConfirma.requestFocus();
                }
            }
        });
        botaoConfirma.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    validarLogin();
                }
            }
        });
        botaoCancela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.exit(0);
                }
            }
        });
    }

    public Map getParametros() {
        mpParametros.remove("BeanSupervisor");
        mpParametros.put("BeanSupervisor", getLoginGerente());
        mpParametros.put("BeanOperador", getLoginOperador());

        return mpParametros;
    }

    private BeanOperador getLoginOperador() {
        return beanOperador;
    }

    private BeanOperador getLoginGerente() {
        return (BeanOperador) cbbLoginGerente.getSelectedItem();
    }

    private String getSenhaOperador() {
        return String.valueOf(editSenhaOperador.getPassword());
    }

    private String getSenhaGerente() {
        return String.valueOf(editSenhaGerente.getPassword());
    }

    private void preencherCombos() {
        DefaultComboBoxModel boxGerente = new DefaultComboBoxModel();

        lsGerente = DAOFacade.getLsGerente();

        // Ordenar crescente        
        Collections.sort(lsGerente);

        // Adicionando ao modelo
        for (BeanOperador gerente : lsGerente) {
            boxGerente.addElement(gerente);
        }

        // Adicionando o modelo à combo
        cbbLoginGerente.setModel(boxGerente);
    }

    private void buscarOperador() {

        BeanOperador operador = new BeanOperador();
        operador.setCodOper(((BeanMovimento) mpParametros.get("BeanMovimento")).getCodOper());
        operador = (new DAOOperador().pesquisa(operador)).get(0);

        labelOperador.setText(operador.toString());
        beanOperador = operador;
    }

    private void validarLogin() {
        /* Validar login */
        if (!UTILBiblioteca.autenticarLogin(getLoginOperador(), getSenhaOperador())) {
            JOptionPane.showMessageDialog(this, "Senha do operador incorreta!", "Iniciar Movimento", JOptionPane.INFORMATION_MESSAGE);
            editSenhaOperador.setText("");
            editSenhaOperador.requestFocus();
            return;
        }
        if (!UTILBiblioteca.autenticarLogin(getLoginGerente(), getSenhaGerente())) {
            JOptionPane.showMessageDialog(this, "Senha do supervisor incorreta!", "Iniciar Movimento", JOptionPane.INFORMATION_MESSAGE);
            editSenhaGerente.setText("");
            editSenhaGerente.requestFocus();
            return;
        }
        cancelado = false;
        dispose();
    }
}
