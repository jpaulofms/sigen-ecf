/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view;

import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.view.util.AbstractView;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class VIEWArquivoMFD extends javax.swing.JDialog {

    public VIEWArquivoMFD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        configurarComportamentoENTER();

        dataInicial.setFormatterFactory(AbstractView.getMaskDate());
        dataFinal.setFormatterFactory(AbstractView.getMaskDate());

        CancelaAction cancelaAction = new CancelaAction();
        botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        botaoCancela.getActionMap().put("cancelaAction", cancelaAction);

        /*ConfirmaAction confirmaAction = new ConfirmaAction();
         botaoConfirma.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "confirmaAction");
         botaoConfirma.getActionMap().put("confirmaAction", confirmaAction);*/

        //troca TAB por ENTER - VOLTA TAB - 02/03/12
        /*HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
         conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
         this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);*/

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
        panelFiltro = new javax.swing.JPanel();
        radioPeriodo = new javax.swing.JRadioButton();
        radioCOO = new javax.swing.JRadioButton();
        panelPeriodo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        panelCOO = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        primeiroCOO = new javax.swing.JFormattedTextField();
        ultimoCOO = new javax.swing.JFormattedTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Arquivo MFD - Memória Fita Detalhe");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaRegistradora01.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelFiltro.setBackground(new Color(255,255,255,0));
        panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Filtro:"));
        panelFiltro.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(radioPeriodo);
        radioPeriodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioPeriodo.setSelected(true);
        radioPeriodo.setText("Período de Data");
        radioPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPeriodoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioPeriodo, gridBagConstraints);

        buttonGroup1.add(radioCOO);
        radioCOO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioCOO.setText("Intervalo de COO");
        radioCOO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCOOActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioCOO, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelFiltro, gridBagConstraints);

        panelPeriodo.setBackground(new Color(255,255,255,0));
        panelPeriodo.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Data inicial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Data final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(jLabel3, gridBagConstraints);

        dataInicial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(dataInicial, gridBagConstraints);

        dataFinal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(dataFinal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelPeriodo, gridBagConstraints);

        panelCOO.setBackground(new Color(255,255,255,0));
        panelCOO.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Primeiro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelCOO.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Último:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelCOO.add(jLabel5, gridBagConstraints);

        primeiroCOO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        primeiroCOO.setEnabled(false);
        primeiroCOO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelCOO.add(primeiroCOO, gridBagConstraints);

        ultimoCOO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ultimoCOO.setEnabled(false);
        ultimoCOO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCOO.add(ultimoCOO, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelCOO, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        panelComponentes.add(panelBotoes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelPrincipal.add(panelComponentes, gridBagConstraints);

        getContentPane().add(panelPrincipal, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPeriodoActionPerformed
        primeiroCOO.setEnabled(false);
        ultimoCOO.setEnabled(false);
        dataInicial.setEnabled(true);
        dataFinal.setEnabled(true);
    }//GEN-LAST:event_radioPeriodoActionPerformed

    private void radioCOOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCOOActionPerformed
        primeiroCOO.setEnabled(true);
        ultimoCOO.setEnabled(true);
        dataInicial.setEnabled(false);
        dataFinal.setEnabled(false);
    }//GEN-LAST:event_radioCOOActionPerformed

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        gerarArquivoMFD();
}//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        dispose();
}//GEN-LAST:event_botaoCancelaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCOO;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelPeriodo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JFormattedTextField primeiroCOO;
    private javax.swing.JRadioButton radioCOO;
    private javax.swing.JRadioButton radioPeriodo;
    private javax.swing.JFormattedTextField ultimoCOO;
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
            dispose();
        }
    }

    private void configurarComportamentoENTER() {
        botaoConfirma.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    gerarArquivoMFD();
                }
            }
        });
        botaoCancela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dispose();
                }
            }
        });
    }

    private void gerarArquivoMFD() {
        if (validarDados()) {
            JOptionPane.showMessageDialog(this, "Arquivo MFD gerado com sucesso!", "Arquivo MFD", JOptionPane.OK_OPTION);
            dispose();
        }
        radioPeriodo.requestFocus();
    }

    private boolean validarDados() {
        try {
            if (radioPeriodo.isSelected()) {
                dataInicial.commitEdit();
                dataFinal.commitEdit();

                Calendar dtIni = Calendar.getInstance();
                dtIni.setTime(AbstractView.sdf.parse(dataInicial.getValue().toString()));
                Calendar dtFim = Calendar.getInstance();
                dtFim.setTime(AbstractView.sdf.parse(dataFinal.getValue().toString()));
                String dInicio = AbstractView.sdf.format(dtIni.getTime());
                String dFinal = AbstractView.sdf.format(dtFim.getTime());

                // Valida as datas 
                if (dtFim.after(Calendar.getInstance().getTime())) {
                    JOptionPane.showMessageDialog(this, "Data final maior que a data atual!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    dataInicial.requestFocus();
                } else if (dtIni.after(dtFim)) {
                    JOptionPane.showMessageDialog(this, "Data final menor que data inicial!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    dataInicial.requestFocus();
                } else if (!UTILBiblioteca.isDataValida(dInicio)) {
                    JOptionPane.showMessageDialog(this, "Data inicial inválida!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    dataInicial.requestFocus();
                } else if (!UTILBiblioteca.isDataValida(dFinal)) {
                    JOptionPane.showMessageDialog(this, "Data final inválida!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    dataFinal.requestFocus();
                } else {
                    return confirma(dInicio, dFinal);
                }
            } else if (radioCOO.isSelected()) {
                primeiroCOO.commitEdit();
                ultimoCOO.commitEdit();
                Integer pCOO = ((Long) primeiroCOO.getValue()).intValue();
                Integer uCOO = ((Long) ultimoCOO.getValue()).intValue();
                IECFService eCFService = ECFServiceFactory.getInstance().criarECFService();

                if (pCOO <= 0) {
                    JOptionPane.showMessageDialog(this, "Primeiro COO inválido!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    primeiroCOO.requestFocus();
                } else if (uCOO <= 0) {
                    JOptionPane.showMessageDialog(this, "Último COO inválido!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    ultimoCOO.requestFocus();
                } else if (uCOO < pCOO) {
                    JOptionPane.showMessageDialog(this, "Último COO menor que o primeiro COO!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    ultimoCOO.requestFocus();
                } else if (uCOO < Integer.parseInt(eCFService.getCOO())) {
                    JOptionPane.showMessageDialog(this, "Último COO fora da faixa!", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                    ultimoCOO.requestFocus();
                } else {
                    return confirma(pCOO.toString(), uCOO.toString());
                }
            }

            return false;
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problemas com os valores informados!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean confirma(String nInicial, String nFinal) {
        IECFService eCFService = ECFServiceFactory.getInstance().criarECFService();
        try {
            // Geração de Arquivo digital

            String tipo = "D"; // DATA

            if (radioCOO.isSelected()) {
                tipo = "C"; // REDUÇÃO
            }

            eCFService.gerarArquivo(nInicial, nFinal, tipo, "1");

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro na geração de Arquivo MFD!", "Arquivo MFD", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
