/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.persistencia.DAOFacade;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class VIEWIdentificarCliente extends javax.swing.JDialog {

    public boolean cancelado = true;
    private BeanCliente cliente;
    private boolean flagDevolucao;

    public VIEWIdentificarCliente(java.awt.Frame parent, boolean modal, boolean flagDevolucao) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        CancelaAction cancelaAction = new CancelaAction();
        botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        botaoCancela.getActionMap().put("cancelaAction", cancelaAction);
        this.flagDevolucao = flagDevolucao;

        if (flagDevolucao) {
            editNome.setEditable(true);
            editNome.setEnabled(true);
            editEndereco.setEditable(true);
            editEndereco.setEnabled(true);
        }

        configurarComportamentoENTER();
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelDados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        editCpfCnpj = new javax.swing.JFormattedTextField();
        editNome = new javax.swing.JTextField();
        editEndereco = new javax.swing.JTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Identificação do Cliente");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaHomem09.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelDados.setBackground(new Color(255,255,255,0));
        panelDados.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CPF/CNPJ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDados.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDados.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Endereço:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDados.add(jLabel4, gridBagConstraints);

        editCpfCnpj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDados.add(editCpfCnpj, gridBagConstraints);

        editNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editNome.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDados.add(editNome, gridBagConstraints);

        editEndereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editEndereco.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDados.add(editEndereco, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelDados, gridBagConstraints);

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
                .addGap(61, 61, 61)
                .addComponent(botaoConfirma)
                .addGap(18, 18, 18)
                .addComponent(botaoCancela)
                .addGap(61, 61, 61))
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirma)
                    .addComponent(botaoCancela)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
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
        confirmar();
}//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        dispose();
}//GEN-LAST:event_botaoCancelaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.JFormattedTextField editCpfCnpj;
    private javax.swing.JTextField editEndereco;
    private javax.swing.JTextField editNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelDados;
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
            dispose();
        }
    }

    private void configurarComportamentoENTER() {
        editCpfCnpj.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!flagDevolucao) {
                        consultarCliente();
                    } else {
                        validarCpfCnpj();
                    }
                }
            }
        });

        if (flagDevolucao) {
            editNome.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        editEndereco.requestFocus();
                    }
                }
            });
            editEndereco.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER && flagDevolucao) {
                        botaoConfirma.requestFocus();
                    }
                }
            });
        }

        botaoConfirma.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    confirmar();
                }
            }
        });
    }

    private void setCliente(BeanCliente beanCliente) {
        editCpfCnpj.setText(beanCliente.getCpfCnpj());
        editNome.setText(beanCliente.getNome());
        editEndereco.setText(beanCliente.getEndereco() != null ? beanCliente.getEndereco() : "");
        botaoConfirma.requestFocus();
    }

    private void consultarCliente() {
        String cpfCnpj = editCpfCnpj.getText().trim();

        if (!UTILBiblioteca.validaCpfCnpj(cpfCnpj)) {
            JOptionPane.showMessageDialog(this, "CPF/ CNPJ invalido!", "Identificar Cliente", JOptionPane.ERROR_MESSAGE);
            cancelado = true;
            return;
        }

        List<BeanCliente> lsCliente = DAOFacade.getLsCliente(cpfCnpj);
        if (lsCliente != null && !lsCliente.isEmpty()) {

            cliente = lsCliente.get(0);
            setCliente(cliente);
        } else {
            //JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Identificar Cliente", JOptionPane.INFORMATION_MESSAGE);
            //editCpfCnpj.setText("");
            //editCpfCnpj.requestFocus();
            cliente = new BeanCliente();
            cliente.setCpfCnpj(cpfCnpj);
        }
        cancelado = false;
        botaoConfirma.requestFocus();
    }

    private void confirmar() {
        if (flagDevolucao) {
            if ((editCpfCnpj.getText() == null || editCpfCnpj.getText().equals(""))
                    || (editNome.getText() == null || editNome.getText().equals(""))
                    || (editEndereco.getText() == null || editEndereco.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Todos os dados devem ser preenchidos para prosseguir", "Identifica Cliente", JOptionPane.WARNING_MESSAGE);
                editCpfCnpj.requestFocus();
                return;
            }
            cliente = new BeanCliente();
            cliente.setCpfCnpj(editCpfCnpj.getText());
            cliente.setNome(editNome.getText());
            cliente.setEndereco(editEndereco.getText());
            cancelado = false;
        }

        dispose();
    }

    public BeanCliente getCliente() {
        return cliente;
    }

    private void validarCpfCnpj() {
        if (UTILBiblioteca.regexInteger(editCpfCnpj.getText()) && UTILBiblioteca.validaCpfCnpj(editCpfCnpj.getText())) {
            editNome.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "CPF/ CNPJ invalido!", "Identificar Cliente", JOptionPane.ERROR_MESSAGE);
            editCpfCnpj.requestFocus();
        }
    }
}
