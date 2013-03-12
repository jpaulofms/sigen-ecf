/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view;

import com.sigen.ecf.model.bean.BeanDevolucao;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.model.operacao.OperacaoFactory;
import com.sigen.ecf.view.util.DevolucaoTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

public class VIEWInserirItemDevolucao extends javax.swing.JDialog {

    public boolean cancelado = true;
    /* Mapa de Parametros */
    private Map mpParametros;
    private BeanDevolucao devolucao;
    private DevolucaoTableModel model = new DevolucaoTableModel();

    public VIEWInserirItemDevolucao(java.awt.Frame parent, boolean modal, Map parametros) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.mpParametros = parametros;
        editCpfCnpj.setForeground(Color.RED);
        editNomeCli.setForeground(Color.RED);
        editEndereco.setForeground(Color.RED);
        configurarComportamentoENTER();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        mpParametros = parametros;
        setDadosCliente();

        CancelaAction cancelaAction = new CancelaAction();
        btnCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        btnCancela.getActionMap().put("cancelaAction", cancelaAction);

        FinalizarPedidoAction finalizarPedidoAction = new FinalizarPedidoAction();
        btnFinalizarPedido.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "finalizarPedidoAction");
        btnFinalizarPedido.getActionMap().put("finalizarPedidoAction", finalizarPedidoAction);

        AdicionarProdutoAction adicionarProdutoAction = new AdicionarProdutoAction();
        btnFinalizarPedido.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "adicionarProdutoAction");
        btnFinalizarPedido.getActionMap().put("adicionarProdutoAction", adicionarProdutoAction);

        this.pack();
        setTableModel();
        gridItemDevolucao.requestFocus();
        adicionarProduto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPai = new javax.swing.JPanel();
        panelBotoes = new javax.swing.JPanel();
        btnFinalizarPedido = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnAddProduto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        editCpfCnpj = new javax.swing.JLabel();
        editNomeCli = new javax.swing.JLabel();
        editEndereco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlParcelas = new javax.swing.JPanel();
        lbTotalDevolucao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridItemDevolucao = new javax.swing.JTable();
        tfTotalCredito = new com.sigen.ecf.view.util.UTILDecimalTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Forma Pagamento");
        setModal(true);
        setResizable(false);

        panelPai.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        panelBotoes.setBackground(new Color(255,255,255,0));
        panelBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelBotoes.setMinimumSize(new java.awt.Dimension(261, 30));

        btnFinalizarPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFinalizarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoConfirmar.png"))); // NOI18N
        btnFinalizarPedido.setText("Finalizar Pedido (F11)");
        btnFinalizarPedido.setFocusable(false);
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
            }
        });

        btnCancela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoCancelar.png"))); // NOI18N
        btnCancela.setText("Cancelar (ESC)");
        btnCancela.setFocusable(false);
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        btnAddProduto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoMenuOperacoes.png"))); // NOI18N
        btnAddProduto.setText("Adicionar Produto(F5)");
        btnAddProduto.setFocusable(false);
        btnAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinalizarPedido)
                .addGap(18, 18, 18)
                .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarPedido)
                    .addComponent(btnCancela)
                    .addComponent(btnAddProduto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        editCpfCnpj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editCpfCnpj.setText("jLabel2");

        editNomeCli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editNomeCli.setText("jLabel1");

        editEndereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editEndereco.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Endereço:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CPF/CNPJ:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NOME:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editCpfCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCpfCnpj)
                    .addComponent(editNomeCli)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editEndereco)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlParcelas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlParcelas.setFocusable(false);

        lbTotalDevolucao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTotalDevolucao.setText("Total Crédito");
        lbTotalDevolucao.setFocusable(false);

        gridItemDevolucao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridItemDevolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(gridItemDevolucao);

        tfTotalCredito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlParcelasLayout = new javax.swing.GroupLayout(pnlParcelas);
        pnlParcelas.setLayout(pnlParcelasLayout);
        pnlParcelasLayout.setHorizontalGroup(
            pnlParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParcelasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlParcelasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbTotalDevolucao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTotalCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        pnlParcelasLayout.setVerticalGroup(
            pnlParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParcelasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalDevolucao)
                    .addComponent(tfTotalCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPaiLayout = new javax.swing.GroupLayout(panelPai);
        panelPai.setLayout(panelPaiLayout);
        panelPaiLayout.setHorizontalGroup(
            panelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(panelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPaiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelPaiLayout.setVerticalGroup(
            panelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPaiLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(pnlParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPaiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(481, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidoActionPerformed
    confirmar();
}//GEN-LAST:event_btnFinalizarPedidoActionPerformed

    private void btnAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdutoActionPerformed
        adicionarProduto();
    }//GEN-LAST:event_btnAddProdutoActionPerformed

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JLabel editCpfCnpj;
    private javax.swing.JLabel editEndereco;
    private javax.swing.JLabel editNomeCli;
    private javax.swing.JTable gridItemDevolucao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTotalDevolucao;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelPai;
    private javax.swing.JPanel pnlParcelas;
    private com.sigen.ecf.view.util.UTILDecimalTextField tfTotalCredito;
    // End of variables declaration//GEN-END:variables

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cancelar();
        }
    }

    private class FinalizarPedidoAction extends AbstractAction {

        public FinalizarPedidoAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            confirmar();
        }
    }

    private class AdicionarProdutoAction extends AbstractAction {

        public AdicionarProdutoAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            adicionarProduto();
        }
    }

    private void configurarComportamentoENTER() {
        /*cbbFormaPagamento.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_ENTER) {
         confirmarFormaPagamento();
         }
         }
         });*/
    }

    private void setTableModel() {

        gridItemDevolucao.setModel(model);
        gridItemDevolucao.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public String toString() {
                return "gridItemDevolucao";
            }
        });

        gridItemDevolucao.setAutoCreateColumnsFromModel(false);
        gridItemDevolucao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gridItemDevolucao.setRowHeight(25);
        setColumnSize();

        atualizaCreditoTotal();
    }

    private void setColumnSize() {
        gridItemDevolucao.getColumnModel().getColumn(0).setPreferredWidth(50); // COD PRODUTO
        gridItemDevolucao.getColumnModel().getColumn(1).setPreferredWidth(220); // DESC PRODUTO
        gridItemDevolucao.getColumnModel().getColumn(2).setPreferredWidth(20); // QUANTINDADE
        gridItemDevolucao.getColumnModel().getColumn(3).setPreferredWidth(50); // UNITARIO
        gridItemDevolucao.getColumnModel().getColumn(4).setPreferredWidth(50); // TOTAL
    }

    private void confirmar() {
        executarOperacao();
        dispose();
    }

    private void cancelar() {
        dispose();
    }

    private void setDadosCliente() {
        BeanDevolucao beanDevolucao = (BeanDevolucao) mpParametros.get("BeanDevolucao");

        devolucao = beanDevolucao;

        editNomeCli.setText(beanDevolucao.getNome().toUpperCase());
        editCpfCnpj.setText(beanDevolucao.getCpfCnpj().toUpperCase());
        editEndereco.setText(beanDevolucao.getEnderecoCompleto().toUpperCase());
    }

    private void adicionarProduto() {
        VIEWColetarProdutoDevolucao coletarProduto = new VIEWColetarProdutoDevolucao(null, true);
        coletarProduto.setVisible(true);
        if (!coletarProduto.cancelado) {
            model.addItem(coletarProduto.getItemVenda());
            model.atualizarGrid();
            setTableModel();
            adicionarProduto();
        }
    }

    private void atualizaCreditoTotal() {
        tfTotalCredito.setText(model.getTotalCredito());
    }

    private void executarOperacao() {
        devolucao.setValorCredito(tfTotalCredito.getBigDecimal());
        mpParametros.put("BeanDevolucao", devolucao);
        mpParametros.put("lsItemDevolucao", model.getLista());

        /* realizar operação */
        Operacao opDevolucao = OperacaoFactory.getInstance().criarOPDevolucao();
        opDevolucao.executar(mpParametros);

    }
}
