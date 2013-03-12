/**
 * <p>Title: SIGEN</p> <p>Description: PAF-ECF + TEF - Janela para
 * desconto/acréscimo.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM</p>
 *
 * @author Albert Eije (T2Ti.COM)
 * @version 1.0
 */
package com.sigen.ecf.view;

import com.sigen.ecf.view.util.LimitedDocumentTextField;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class VIEWInserirValorDesconto extends javax.swing.JDialog {
    
    public boolean cancelado = true;
    private String tipoDesconto;
    private BigDecimal valorDesconto;
    private int quantidadeCaracteresValorProduto;
    
    public VIEWInserirValorDesconto(java.awt.Frame parent, boolean modal, int quantCaracterPreco) {
        super(parent, modal);
        initComponents();
        configurarComportamentoENTER();
        setLocationRelativeTo(null);
        
        quantidadeCaracteresValorProduto = quantCaracterPreco;
        
        btGroup.add(radioValor);
        btGroup.add(radioPorcentagem);
        
        CancelaAction cancelaAction = new CancelaAction();
        botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        botaoCancela.getActionMap().put("cancelaAction", cancelaAction);
        
        this.pack();
        verificarSelecao();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btGroup = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelValor = new javax.swing.JPanel();
        editValor = new com.sigen.ecf.view.util.UTILDecimalTextField();
        jLabel2 = new javax.swing.JLabel();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        panelFiltro = new javax.swing.JPanel();
        radioPorcentagem = new javax.swing.JRadioButton();
        radioValor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Desconto / Acréscimo");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaDinheiro03.png"))); // NOI18N

        panelComponentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelValor.setBackground(new Color(255,255,255,0));
        panelValor.setLayout(new java.awt.GridBagLayout());
        panelComponentes.add(panelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, 323, -1));
        panelComponentes.add(editValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 240, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Valor:");
        panelComponentes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        panelBotoes.setBackground(new Color(255,255,255,0));
        panelBotoes.setLayout(new java.awt.GridBagLayout());

        botaoConfirma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoConfirmar.png"))); // NOI18N
        botaoConfirma.setText("Confirma (ENTER)");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        panelBotoes.add(botaoConfirma, gridBagConstraints);

        botaoCancela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoCancelar.png"))); // NOI18N
        botaoCancela.setText("Cancela (ESC)");
        botaoCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 5);
        panelBotoes.add(botaoCancela, gridBagConstraints);

        panelFiltro.setBackground(new Color(255,255,255,0));
        panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Desconto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        radioPorcentagem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioPorcentagem.setSelected(true);
        radioPorcentagem.setText("Porcentagem");
        radioPorcentagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPorcentagemActionPerformed(evt);
            }
        });

        radioValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioValor.setText("Valor");
        radioValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFiltroLayout = new javax.swing.GroupLayout(panelFiltro);
        panelFiltro.setLayout(panelFiltroLayout);
        panelFiltroLayout.setHorizontalGroup(
            panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltroLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(radioPorcentagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioValor)
                .addGap(36, 36, 36))
        );
        panelFiltroLayout.setVerticalGroup(
            panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(radioPorcentagem)
                .addComponent(radioValor))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(panelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        getContentPane().add(panelPrincipal, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelaActionPerformed
    
    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        if (validarValor()) {
            cancelado = false;
            dispose();
        }
    }//GEN-LAST:event_botaoConfirmaActionPerformed
    
    private void radioPorcentagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPorcentagemActionPerformed
        verificarSelecao();
    }//GEN-LAST:event_radioPorcentagemActionPerformed
    private void radioValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioValorActionPerformed
        verificarSelecao();
    }//GEN-LAST:event_radioValorActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.ButtonGroup btGroup;
    private com.sigen.ecf.view.util.UTILDecimalTextField editValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelValor;
    private javax.swing.JRadioButton radioPorcentagem;
    private javax.swing.JRadioButton radioValor;
    // End of variables declaration//GEN-END:variables

    private class CancelaAction extends AbstractAction {
        
        public CancelaAction() {
        }
        
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
    
    private void configurarComportamentoENTER() {
        radioPorcentagem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (radioPorcentagem.isSelected()) {
                        editValor.requestFocus();
                    } else {
                        radioPorcentagem.setSelected(true);
                    }
                }
            }
        });
        radioPorcentagem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    radioValor.requestFocus();
                }
            }
        });
        radioValor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (radioValor.isSelected()) {
                        editValor.requestFocus();
                    } else {
                        radioValor.setSelected(true);
                    }
                }
            }
        });
        radioValor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    radioPorcentagem.requestFocus();
                }
            }
        });
        editValor.addKeyListener(new KeyAdapter() {
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
                    if (validarValor()) {
                        cancelado = false;
                        dispose();
                    }
                }
            }
        });
    }
    
    private void configurarLimitedTextField(int n) {
        /*
         * limitar quantidade de caracteres do campo
         */
        editValor.setDocument(new LimitedDocumentTextField(n));
    }
    
    private boolean validarValor() {
        String valor = "";
        
        valorDesconto = editValor.getBigDecimal();
        if (radioPorcentagem.isSelected()) {
            valor = editValor.getText();
            //valorDesconto = new BigDecimal(new Double(valor));
        } else {
            valor = editValor.getText().replace(".", "").replace(",", ".");
            //valorDesconto = new BigDecimal(valor);
        }
        if (!UTILBiblioteca.regexInteger(valor.replace(".", ""))) {
            JOptionPane.showMessageDialog(this, "Valor não pode conter letras.", "Valor Desconto", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args){
        VIEWInserirValorDesconto aux = new VIEWInserirValorDesconto(new Frame(), true, 3);
        aux.setVisible(true);
    }
    
    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }
    
    public String getTipoDesconto() {
        return tipoDesconto;
    }
    
    private void verificarSelecao() {
        if (editValor.getText().isEmpty()) {
            return;
        }
        
        if (radioPorcentagem.isSelected()) {
            //editValor.setFormatterFactory(AbstractView.getMaskPorcentagem());
            //configurarLimitedTextField(5);
            tipoDesconto = "P";
        } else {
            //configurarLimitedTextField(quantidadeCaracteresValorProduto);
            tipoDesconto = "V";
        }
    }
}
