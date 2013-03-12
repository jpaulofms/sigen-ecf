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
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.model.operacao.OperacaoFactory;
import com.sigen.ecf.persistencia.DAOFacade;
import com.sigen.ecf.view.util.AbstractView;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class VIEWLoginIniciarMovimento extends javax.swing.JDialog {

    public boolean cancelado = true;
    private List<BeanOperador> lsOperador;
    private List<BeanOperador> lsGerente;
    private Map mpParametro;

    public VIEWLoginIniciarMovimento(java.awt.Frame parent, boolean modal, Map parametro) {
        super(parent, modal);
        initComponents();
        this.mpParametro = parametro;
        this.setLocationRelativeTo(null);
        configurarComportamentoENTER();
        preencherCombos();
        saldoAnterior();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.pack();

        CancelaAction cancelaAction = new CancelaAction();
        botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        botaoCancela.getActionMap().put("cancelaAction", cancelaAction);

    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelComponentes = new javax.swing.JPanel();
        panelAbertura = new javax.swing.JPanel();
        panelOperador = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editSenhaOperador = new javax.swing.JPasswordField();
        cbbLoginOperador = new javax.swing.JComboBox();
        panelGerente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editSenhaGerente = new javax.swing.JPasswordField();
        cbbLoginGerente = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        editSaldoMovimentoAnterior = new javax.swing.JFormattedTextField();
        editSuprimento = new com.sigen.ecf.view.util.UTILDecimalTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelVersao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Inicia Movimento do Caixa");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelAbertura.setBackground(new Color(255,255,255,0));
        panelAbertura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados para abertura do movimento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N

        panelOperador.setBackground(new Color(255,255,255,0));
        panelOperador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Operador:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel6.setText("Login:");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel7.setText("Senha:");

        editSenhaOperador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cbbLoginOperador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelOperadorLayout = new javax.swing.GroupLayout(panelOperador);
        panelOperador.setLayout(panelOperadorLayout);
        panelOperadorLayout.setHorizontalGroup(
            panelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cbbLoginOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editSenhaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelOperadorLayout.setVerticalGroup(
            panelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperadorLayout.createSequentialGroup()
                .addGroup(panelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(panelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSenhaOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoginOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        panelGerente.setBackground(new Color(255,255,255,0));
        panelGerente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Supervisor:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Login:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
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
                    .addComponent(cbbLoginGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editSenhaGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGerenteLayout.setVerticalGroup(
            panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGerenteLayout.createSequentialGroup()
                .addGroup(panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSenhaGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoginGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel5.setText("Suprimento");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel8.setText("Movimento Anterior:");

        editSaldoMovimentoAnterior.setEditable(false);
        editSaldoMovimentoAnterior.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        editSaldoMovimentoAnterior.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editSaldoMovimentoAnterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        editSuprimento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelAberturaLayout = new javax.swing.GroupLayout(panelAbertura);
        panelAbertura.setLayout(panelAberturaLayout);
        panelAberturaLayout.setHorizontalGroup(
            panelAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAberturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAberturaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(editSaldoMovimentoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(editSuprimento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addComponent(panelOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAberturaLayout.setVerticalGroup(
            panelAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAberturaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addGroup(panelAberturaLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGroup(panelAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSaldoMovimentoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editSuprimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotoes.setBackground(new Color(255,255,255,0));

        botaoConfirma.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        botaoConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoConfirmar.png"))); // NOI18N
        botaoConfirma.setText("Confirma (ENTER)");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });

        botaoCancela.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
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
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoConfirma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoCancela)
                .addGap(17, 17, 17))
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoConfirma)
                        .addComponent(botaoCancela))
                    .addComponent(jLabel4))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout panelComponentesLayout = new javax.swing.GroupLayout(panelComponentes);
        panelComponentes.setLayout(panelComponentesLayout);
        panelComponentesLayout.setHorizontalGroup(
            panelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComponentesLayout.createSequentialGroup()
                        .addComponent(panelAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelComponentesLayout.setVerticalGroup(
            panelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logotipo_extraido_pdf_100x50.png"))); // NOI18N

        labelVersao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelVersao.setText("jLabel9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelVersao)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(panelPrincipal, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        confirmar();
    }//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botaoCancelaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.JComboBox cbbLoginGerente;
    private javax.swing.JComboBox cbbLoginOperador;
    private javax.swing.JFormattedTextField editSaldoMovimentoAnterior;
    private javax.swing.JPasswordField editSenhaGerente;
    private javax.swing.JPasswordField editSenhaOperador;
    private com.sigen.ecf.view.util.UTILDecimalTextField editSuprimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelVersao;
    private javax.swing.JPanel panelAbertura;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelGerente;
    private javax.swing.JPanel panelOperador;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getParent() != null && getParent() instanceof VIEWCaixa) {
                VIEWLoginIniciarMovimento.this.dispose();
            } else {
                System.exit(0);
            }
        }
    }

    private void configurarComportamentoENTER() {
        cbbLoginOperador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    editSenhaOperador.requestFocus();
                }
            }
        });
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
                    editSuprimento.requestFocus();
                }
            }
        });
        editSuprimento.addKeyListener(new KeyAdapter() {
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
                    confirmar();
                }
            }
        });
        botaoCancela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (getParent() != null && getParent() instanceof VIEWCaixa) {
                    VIEWLoginIniciarMovimento.this.dispose();
                } else {
                    System.exit(0);
                }
            }
        });
    }

    public Map getParametros() {
        return mpParametro;
    }

    private BeanOperador getLoginOperador() {
        return (BeanOperador) cbbLoginOperador.getSelectedItem();
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
        DefaultComboBoxModel boxOperador = new DefaultComboBoxModel();
        DefaultComboBoxModel boxGerente = new DefaultComboBoxModel();

        lsOperador = DAOFacade.getLsOperador();
        lsGerente = DAOFacade.getLsGerente();

        // Ordenar crescente
        Collections.sort(lsOperador);
        Collections.sort(lsGerente);

        // Adicionando ao modelo
        for (BeanOperador operador : lsOperador) {
            boxOperador.addElement(operador);
        }

        // Adicionando ao modelo
        for (BeanOperador gerente : lsGerente) {
            boxGerente.addElement(gerente);
        }

        // Adicionando o modelo à combo
        cbbLoginOperador.setModel(boxOperador);
        cbbLoginGerente.setModel(boxGerente);
    }

    private boolean validarLogin() {
        /* Validar login */
        if (!UTILBiblioteca.autenticarLogin(getLoginOperador(), getSenhaOperador())) {
            JOptionPane.showMessageDialog(this, "Senha do operador incorreta!", "Iniciar Movimento", JOptionPane.INFORMATION_MESSAGE);
            editSenhaOperador.setText("");
            editSenhaOperador.requestFocus();
            return false;
        }
        if (!UTILBiblioteca.autenticarLogin(getLoginGerente(), getSenhaGerente())) {
            JOptionPane.showMessageDialog(this, "Senha do supervisor incorreta!", "Iniciar Movimento", JOptionPane.INFORMATION_MESSAGE);
            editSenhaGerente.setText("");
            editSenhaGerente.requestFocus();
            return false;
        }

        return realizaOperacao();
    }

    private boolean realizaOperacao() {

        mpParametro.put("BeanOperador", getLoginOperador());
        mpParametro.put("BeanSupervisor", getLoginGerente());
        mpParametro.put("saldoMovimentoAnterior", new BigDecimal(editSaldoMovimentoAnterior.getText().replace(".", "").replace(",", ".")));
        mpParametro.put("saldoSuprimento", editSuprimento.getBigDecimal());

        /* Operação */
        Operacao movimentoAbertura = OperacaoFactory.getInstance().criarOPMovimentoAbertura();
        mpParametro = movimentoAbertura.executar(mpParametro);

        return (Boolean) mpParametro.get("result");
    }

    private void confirmar() {
        if (validarLogin()) {
            cancelado = false;
            dispose();
        }
    }

    private void saldoAnterior() {
        BigDecimal saldo = BigDecimal.ZERO;
        if (mpParametro.get("BeanMovimento") != null) {
            BeanMovimento movimentoAnterior = (BeanMovimento) mpParametro.get("BeanMovimento");
            saldo = movimentoAnterior.getSaldoDinheiroFechamento() != null ? movimentoAnterior.getSaldoDinheiroFechamento() : BigDecimal.ZERO;
        }
        editSaldoMovimentoAnterior.setText(AbstractView.df.format(saldo));
    }
}
