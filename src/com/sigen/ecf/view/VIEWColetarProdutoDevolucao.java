/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view;

import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.persistencia.DAOFacade;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class VIEWColetarProdutoDevolucao extends javax.swing.JDialog {

    public boolean cancelado = true;
    private BeanItemVenda itemDevolucao;
    private BeanProduto produto;

    public VIEWColetarProdutoDevolucao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        ConcluirAction concluirAction = new ConcluirAction();
        botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "concluirAction");
        botaoCancela.getActionMap().put("concluirAction", concluirAction);
        editQuantidade.setEditable(true);
        editQuantidade.setEnabled(true);
        setTitle("Produto Devolução");

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
        editCodigo = new javax.swing.JFormattedTextField();
        editDescricaoProduto = new javax.swing.JTextField();
        editQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfValorUnitarioPago = new com.sigen.ecf.view.util.UTILDecimalTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Identificação do Cliente");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaDinheiro05.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelDados.setBackground(new Color(255,255,255,0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descrição");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Quantidade");

        editCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        editDescricaoProduto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editDescricaoProduto.setEnabled(false);

        editQuantidade.setEditable(false);
        editQuantidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editQuantidade.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Valor Unitário Pago");

        tfValorUnitarioPago.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDadosLayout.createSequentialGroup()
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(editCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tfValorUnitarioPago, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(editQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(editDescricaoProduto, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18))))
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfValorUnitarioPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28))
                    .addComponent(editQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(editCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(editDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelDados, gridBagConstraints);

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
        botaoCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoEncerraVenda.png"))); // NOI18N
        botaoCancela.setText("Concluir (F10)");
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
    private javax.swing.JFormattedTextField editCodigo;
    private javax.swing.JTextField editDescricaoProduto;
    private javax.swing.JTextField editQuantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel panelPrincipal;
    private com.sigen.ecf.view.util.UTILDecimalTextField tfValorUnitarioPago;
    // End of variables declaration//GEN-END:variables

    private class ConfirmaAction extends AbstractAction {

        public ConfirmaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    private class ConcluirAction extends AbstractAction {

        public ConcluirAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private void configurarComportamentoENTER() {
        editCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    consultarProduto();
                }
            }
        });

        tfValorUnitarioPago.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    editQuantidade.requestFocus();
                }
            }
        });
        editQuantidade.addKeyListener(new KeyAdapter() {
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
    }

    private void consultarProduto() {
        String codProduto = editCodigo.getText();
        if (!UTILBiblioteca.regexInteger(codProduto)) {
            JOptionPane.showMessageDialog(this, "Caracteres inválidos", "Consultar Produto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        produto = new BeanProduto();
        produto.setCodProd(codProduto);

        produto = DAOFacade.getProduto(produto);
        if (produto == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado", "Consultar Produto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* Produto encontrado - Exibir informações */
        editDescricaoProduto.setText(produto.getDescricao());
        tfValorUnitarioPago.requestFocus();
    }

    private void confirmar() {
        if (produto != null && validarCampos()) {

            itemDevolucao = new BeanItemVenda();
            itemDevolucao.setCodProd(produto.getCodProd());
            itemDevolucao.setDescricao(produto.getDescricao());
            itemDevolucao.setQuantidadeVendida(new BigDecimal(editQuantidade.getText().replace(".", "").replace(",", ".")));
            itemDevolucao.setValorUnitario(new BigDecimal(tfValorUnitarioPago.getText()));
            itemDevolucao.setValorTotal(itemDevolucao.getValorUnitario().multiply(itemDevolucao.getQuantidadeVendida()));

            cancelado = false;
            dispose();
        }
    }

    public BeanItemVenda getItemVenda() {
        return itemDevolucao;
    }

    private boolean validarCampos() {
        boolean result = false;
        BigDecimal valorPago = BigDecimal.ZERO;
        if (tfValorUnitarioPago.getText() != null) {
            valorPago = new BigDecimal(tfValorUnitarioPago.getText().replace(".", "").replace(",", "."));
        }

        result = editCodigo.getText() != null && !editCodigo.getText().equals("") ? true : false;
        if (!result) {
            JOptionPane.showMessageDialog(this, "Todos os dados devem ser preenchidos para prosseguir", "Produto Devolução", JOptionPane.WARNING_MESSAGE);
            editCodigo.requestFocus();
            return result;
        }

        result = editDescricaoProduto.getText() != null && !editDescricaoProduto.getText().equals("") ? true : false;
        if (!result) {
            JOptionPane.showMessageDialog(this, "Todos os dados devem ser preenchidos para prosseguir", "Produto Devolução", JOptionPane.WARNING_MESSAGE);
            editDescricaoProduto.requestFocus();
            return result;
        }
        result = valorPago.compareTo(BigDecimal.ZERO) > 0 ? true : false;
        if (!result) {
            JOptionPane.showMessageDialog(this, "Valor Unitário Pago deve ser maior que 0,00(zero)", "Produto Devolução", JOptionPane.WARNING_MESSAGE);
            tfValorUnitarioPago.requestFocus();
            return result;
        }
        result = editQuantidade.getText() != null && !editQuantidade.getText().equals("") ? true : false;
        if (result) {
            result = new BigDecimal(editQuantidade.getText().replace(".", "").replace(",", ".")).compareTo(BigDecimal.ZERO) > 0 ? true : false;
        }
        if (!result) {
            JOptionPane.showMessageDialog(this, "Digite uma quantidade maior que 0,00(zero) para prosseguir", "Produto Devolução", JOptionPane.WARNING_MESSAGE);
            editQuantidade.requestFocus();
            return result;
        }
        return result;
    }
}
