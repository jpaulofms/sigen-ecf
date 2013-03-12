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

public class VIEWDAVEmitidos extends javax.swing.JDialog {

    public VIEWDAVEmitidos(java.awt.Frame parent, boolean modal) {
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
        radioGerencial = new javax.swing.JRadioButton();
        radioArquivo = new javax.swing.JRadioButton();
        panelPeriodo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DAV Emitidos");
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
        panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Filtro:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelFiltro.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(radioGerencial);
        radioGerencial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioGerencial.setSelected(true);
        radioGerencial.setText("Relatório Gerencial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioGerencial, gridBagConstraints);

        buttonGroup1.add(radioArquivo);
        radioArquivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioArquivo.setText("Geração de Arquivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioArquivo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelPeriodo.add(dataInicial, gridBagConstraints);

        dataFinal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelPeriodo.add(dataFinal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelPeriodo, gridBagConstraints);

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

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        efetuarDAV();
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
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelPeriodo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JRadioButton radioArquivo;
    private javax.swing.JRadioButton radioGerencial;
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
                    efetuarDAV();
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

    private void efetuarDAV() {
        if (validarDados()) {
            JOptionPane.showMessageDialog(this, "Relatório de DAV Eemitidos gerado com sucesso!", "DAV Emitidos", JOptionPane.OK_OPTION);
            dispose();
        }
        radioGerencial.requestFocus();
    }

    private boolean validarDados() {
        try {

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
            if (radioGerencial.isSelected()) {
                eCFService.emitirDAVEmitidos(nInicial, nFinal);
            } else if (radioArquivo.isSelected()) {
                eCFService.gerarDAVEmitidos(nInicial, nFinal);
            }

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro na geração de DAV Emitidos!", "DAV Emitidos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
