/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanCondicaoPagamento;
import com.sigen.ecf.model.bean.BeanConveniada;
import com.sigen.ecf.model.bean.BeanDevolucao;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import com.sigen.ecf.model.bean.BeanParametros;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.model.operacao.OperacaoFactory;
import com.sigen.ecf.negocio.ctrl.CTRLConveniada;
import com.sigen.ecf.persistencia.DAOFacade;
import com.sigen.ecf.persistencia.dao.impl.DAOFormaPagamento;
import com.sigen.ecf.view.util.AbstractView;
import com.sigen.ecf.view.util.UTILBiblioteca;
import com.sigen.ecf.vo.VOCheque;
import com.sigen.ecf.vo.VOItemParcelaPagamento;
import com.sigen.ecf.vo.VOParcelaPagamento;
import com.sigen.ecf.vo.VOTransacaoTef;

public class VIEWSelecionarFormaPagamento extends javax.swing.JDialog {

    public boolean cancelado = true;
    private int quantidadeParcelasCondicao;
    private BeanCondicaoPagamento beanCondicaoPagamento;
    private int ipAtual;
    private BeanCliente beanCliente;
    /* Listas */
    public List<BeanFormaPagamento> lsFormaPagamentos;
    private List<VOParcelaPagamento> lsParcelaPagamento;
    private List<VOTransacaoTef> lsTransacoesTef;
    /* Mapa de Parametros */
    private Map mpParametros;
    /* Temp */
    private BeanFormaPagamento fpSelecionada;
    private VOCheque beanCheque;
    private BeanConveniada beanConveniada;
    private int quantidadeParcelasItem;
    private String numeroAutorizacao;
    private String numeroCgcCpf;
    private BeanDevolucao beanCreditoDevolucao;
    private BigDecimal valorArredondamento;
    private BigDecimal totalReceber;
    private BigDecimal subTotal;
    private BigDecimal valorTroco;
    private int numeroTransacao;

    public VIEWSelecionarFormaPagamento(java.awt.Frame parent, boolean modal, BeanCondicaoPagamento condicaoPagamento, BigDecimal valorReceber, BigDecimal valorDesconto, int quantParcelas, Map parametros) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.mpParametros = parametros;
        beanCliente = parametros.get("BeanCliente") != null ? (BeanCliente) parametros.get("BeanCliente") : null;
        beanCondicaoPagamento = condicaoPagamento;
        txtCondicaoPagamento.setText(condicaoPagamento.getDescricao());
        txtCondicaoPagamento.setForeground(Color.RED);
        lsParcelaPagamento = new ArrayList<VOParcelaPagamento>();
        lsTransacoesTef = new ArrayList<VOTransacaoTef>();
        ipAtual = 0;
        numeroTransacao = 0;
        quantidadeParcelasCondicao = quantParcelas;
        valorTroco = BigDecimal.ZERO;
        subTotal = valorReceber;
        totalReceber = valorReceber.subtract(valorDesconto);
        setValorReceber(valorReceber);
        setValorDesconto(valorDesconto);
        BigDecimal valorPrevistoParcela = getValorPrevisto(new BigDecimal(txtValorReceber.getText().replace(",", ".")), quantidadeParcelasCondicao);
        gerarParcelasPrevisto(valorPrevistoParcela, false);
        consultarFormasPagamento();
        preencherCombo();
        configurarComportamentoENTER();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setCliente();
        atualizarValoresTela();
        atualizarAreaResumo();


        CancelaAction cancelaAction = new CancelaAction();
        btnCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        btnCancela.getActionMap().put("cancelaAction", cancelaAction);

        FinalizarPedidoAction finalizarPedidoAction = new FinalizarPedidoAction();
        btnFinalizarPedido.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "finalizarPedidoAction");
        btnFinalizarPedido.getActionMap().put("finalizarPedidoAction", finalizarPedidoAction);

        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlValores = new javax.swing.JPanel();
        lblValorRecebido = new javax.swing.JLabel();
        txtValorRecebido = new javax.swing.JFormattedTextField();
        lblValorReceber = new javax.swing.JLabel();
        txtValorReceber = new javax.swing.JFormattedTextField();
        txtDesconto = new javax.swing.JFormattedTextField();
        lblDesconto = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JFormattedTextField();
        txtTroco = new javax.swing.JFormattedTextField();
        lblTroco = new javax.swing.JLabel();
        pnlFormaPagamento = new javax.swing.JPanel();
        lblCondPagto = new javax.swing.JLabel();
        cbbFormaPagamento = new javax.swing.JComboBox();
        pnlParcelas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResumo = new javax.swing.JTextArea();
        panelBotoes = new javax.swing.JPanel();
        btnFinalizarPedido = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnConferencia = new javax.swing.JButton();
        btnRenegociar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        editNomeCli = new javax.swing.JLabel();
        editCpfCnpj = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtCondicaoPagamento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Forma Pagamento");
        setModal(true);
        setResizable(false);

        pnlValores.setFocusable(false);

        lblValorRecebido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValorRecebido.setText("Valor Recebido");
        lblValorRecebido.setFocusable(false);

        txtValorRecebido.setEditable(false);
        txtValorRecebido.setFocusable(false);
        txtValorRecebido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblValorReceber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValorReceber.setText("Valor Receber");
        lblValorReceber.setFocusable(false);

        txtValorReceber.setEditable(false);
        txtValorReceber.setFocusable(false);
        txtValorReceber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtDesconto.setEditable(false);
        txtDesconto.setFocusable(false);
        txtDesconto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblDesconto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDesconto.setText("Desconto");
        lblDesconto.setFocusable(false);

        lblSaldo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaldo.setText("Saldo");
        lblSaldo.setFocusable(false);

        txtSaldo.setEditable(false);
        txtSaldo.setFocusable(false);
        txtSaldo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtTroco.setEditable(false);
        txtTroco.setFocusable(false);
        txtTroco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblTroco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTroco.setText("Troco");
        lblTroco.setFocusable(false);

        javax.swing.GroupLayout pnlValoresLayout = new javax.swing.GroupLayout(pnlValores);
        pnlValores.setLayout(pnlValoresLayout);
        pnlValoresLayout.setHorizontalGroup(
            pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValoresLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorReceber)
                    .addComponent(txtValorReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorRecebido)
                    .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesconto)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldo)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTroco)
                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlValoresLayout.setVerticalGroup(
            pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValoresLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblValorReceber)
                .addGap(6, 6, 6)
                .addComponent(txtValorReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblValorRecebido)
                .addGap(6, 6, 6)
                .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDesconto)
                .addGap(6, 6, 6)
                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblSaldo)
                .addGap(6, 6, 6)
                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblTroco)
                .addGap(6, 6, 6)
                .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlFormaPagamento.setFocusable(false);

        lblCondPagto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCondPagto.setText("Forma de Pagamento");

        cbbFormaPagamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlFormaPagamentoLayout = new javax.swing.GroupLayout(pnlFormaPagamento);
        pnlFormaPagamento.setLayout(pnlFormaPagamentoLayout);
        pnlFormaPagamentoLayout.setHorizontalGroup(
            pnlFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormaPagamentoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormaPagamentoLayout.createSequentialGroup()
                        .addComponent(lblCondPagto, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(pnlFormaPagamentoLayout.createSequentialGroup()
                        .addComponent(cbbFormaPagamento, 0, 169, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlFormaPagamentoLayout.setVerticalGroup(
            pnlFormaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormaPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCondPagto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(cbbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlParcelas.setFocusable(false);

        txtResumo.setColumns(20);
        txtResumo.setEditable(false);
        txtResumo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtResumo.setRows(5);
        txtResumo.setFocusable(false);
        jScrollPane1.setViewportView(txtResumo);

        javax.swing.GroupLayout pnlParcelasLayout = new javax.swing.GroupLayout(pnlParcelas);
        pnlParcelas.setLayout(pnlParcelasLayout);
        pnlParcelasLayout.setHorizontalGroup(
            pnlParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParcelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlParcelasLayout.setVerticalGroup(
            pnlParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParcelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBotoes.setBackground(new Color(255,255,255,0));
        panelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        btnCancela.setText("Cancela (ESC)");
        btnCancela.setFocusable(false);
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        btnConferencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConferencia.setText("Conf. de Pedido (F10)");
        btnConferencia.setFocusable(false);
        btnConferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConferenciaActionPerformed(evt);
            }
        });

        btnRenegociar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRenegociar.setText("Renegociar (F4)");
        btnRenegociar.setFocusable(false);
        btnRenegociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenegociarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRenegociar)
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarPedido)
                    .addComponent(btnCancela)
                    .addComponent(btnConferencia)
                    .addComponent(btnRenegociar))
                .addContainerGap())
        );

        editNomeCli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editNomeCli.setText("jLabel1");

        editCpfCnpj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editCpfCnpj.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(editCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editNomeCli)
                    .addComponent(editCpfCnpj))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCondicaoPagamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCondicaoPagamento.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtCondicaoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(txtCondicaoPagamento))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlFormaPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addComponent(pnlParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidoActionPerformed
    if (verificarPagamento()) {
        cancelado = false;
        dispose();
    }
}//GEN-LAST:event_btnFinalizarPedidoActionPerformed
private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
    dispose();
}//GEN-LAST:event_btnCancelaActionPerformed
private void btnConferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConferenciaActionPerformed
}//GEN-LAST:event_btnConferenciaActionPerformed

private void btnRenegociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenegociarActionPerformed
}//GEN-LAST:event_btnRenegociarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnConferencia;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JButton btnRenegociar;
    private javax.swing.JComboBox cbbFormaPagamento;
    private javax.swing.JLabel editCpfCnpj;
    private javax.swing.JLabel editNomeCli;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCondPagto;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTroco;
    private javax.swing.JLabel lblValorReceber;
    private javax.swing.JLabel lblValorRecebido;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel pnlFormaPagamento;
    private javax.swing.JPanel pnlParcelas;
    private javax.swing.JPanel pnlValores;
    private javax.swing.JLabel txtCondicaoPagamento;
    private javax.swing.JFormattedTextField txtDesconto;
    private javax.swing.JTextArea txtResumo;
    private javax.swing.JFormattedTextField txtSaldo;
    private javax.swing.JFormattedTextField txtTroco;
    private javax.swing.JFormattedTextField txtValorReceber;
    private javax.swing.JFormattedTextField txtValorRecebido;
    // End of variables declaration//GEN-END:variables

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class FinalizarPedidoAction extends AbstractAction {

        public FinalizarPedidoAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (verificarPagamento()) {
                cancelado = false;
                dispose();
            }
        }
    }

    private void configurarComportamentoENTER() {
        cbbFormaPagamento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    confirmarFormaPagamento();
                }
            }
        });


        cbbFormaPagamento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F4) {
                    // renegociar
                }
            }
        });
    }

    private void atualizarFormasPagamento() {
        consultarFormasPagamento();
        preencherCombo();
    }

    private void consultarFormasPagamento() {
        this.lsFormaPagamentos = getLsFormaPagamento();
    }

    private List<BeanFormaPagamento> getLsFormaPagamento() {
        /* Caso parcela seja uma entrada, retornar formas de pagamento a vista */

        lsFormaPagamentos = new DAOFormaPagamento().pesquisaFormaCondicaoPagamento(beanCondicaoPagamento.getCodCondPagto());

        if (lsParcelaPagamento.get(ipAtual).isEntrada() || beanCondicaoPagamento.getParcelaMax() == 1) {
            return pesquisaFormaCondicaoPagamentoEntrada();
        }
        return pesquisaFormaCondicaoPagamentoPrazo();
    }

    private List<BeanFormaPagamento> pesquisaFormaCondicaoPagamentoEntrada() {
        List<BeanFormaPagamento> lsfFormaPagamentoEntrada = new ArrayList<BeanFormaPagamento>();
        for (BeanFormaPagamento fp : lsFormaPagamentos) {
            if (fp.isPagamentoAVista()) {
                lsfFormaPagamentoEntrada.add(fp);
            }
        }
        return lsfFormaPagamentoEntrada;
    }

    private List<BeanFormaPagamento> pesquisaFormaCondicaoPagamentoPrazo() {
        List<BeanFormaPagamento> lsfFormaPagamentoPrazo = new ArrayList<BeanFormaPagamento>();
        for (BeanFormaPagamento fp : lsFormaPagamentos) {
            if (fp.isPagamentoAPrazo()) {
                lsfFormaPagamentoPrazo.add(fp);
            }
        }
        //        return lsfFormaPagamentoPrazo;
        return lsFormaPagamentos;
    }

    private void preencherCombo() {
        DefaultComboBoxModel box = new DefaultComboBoxModel();

        // Ordenar crescente
        Collections.sort(lsFormaPagamentos);

        // Adicionando ao modelo
        for (BeanFormaPagamento formaPagamento : lsFormaPagamentos) {
            box.addElement(formaPagamento);
        }

        // Adicionando a combo
        cbbFormaPagamento.setModel(box);
    }

    private void confirmarFormaPagamento() {
        confirmarSelecaoFormaPagamento((BeanFormaPagamento) cbbFormaPagamento.getSelectedItem());
    }

    private void setAreaResumo(List<String> lsAreaResumo) {
        // Visualização das parcelas e formas de pagamentos
        txtResumo.setText("");
        for (String s : lsAreaResumo) {
            txtResumo.append(s);
        }
    }

    private void setValorReceber(BigDecimal valorReceber) {
        txtValorReceber.setText(UTILBiblioteca.formatoDecimal("V", valorReceber));
    }

    private void setValorRecebido(BigDecimal valorRecebido) {
        txtValorRecebido.setText(UTILBiblioteca.formatoDecimal("V", valorRecebido));
    }

    private void setValorDesconto(BigDecimal valorDesconto) {
        txtDesconto.setText(UTILBiblioteca.formatoDecimal("V", valorDesconto));
    }

    private void setNumeroParcelas(int numeroParcelas) {
        quantidadeParcelasCondicao = numeroParcelas;
    }

    private void setSaldo(BigDecimal valorSaldo) {
        txtSaldo.setText(UTILBiblioteca.formatoDecimal("V", valorSaldo));

        if (valorSaldo.compareTo(BigDecimal.ZERO) == 0) {
            cbbFormaPagamento.setVisible(false);
            cbbFormaPagamento.setFocusable(false);
        }
    }

    private void setTroco(BigDecimal valorTroco) {
        txtTroco.setText(UTILBiblioteca.formatoDecimal("V", valorTroco));
    }

    private void setCliente() {
        String nomeCliente = beanCliente != null ? beanCliente.getNome() : "VENDA AO CONSUMIDOR";
        String cpfCnpj = AbstractView.formatString((beanCliente != null ? beanCliente.getCpfCnpj() : "99999999999"), true);

        editNomeCli.setText(nomeCliente);
        editCpfCnpj.setText(cpfCnpj);
    }

    private boolean verificarPagamento() {
        if (new BigDecimal(txtSaldo.getText().replace(",", ".")).compareTo(BigDecimal.ZERO) > 0) {
            JOptionPane.showMessageDialog(this, "Para finalizar, o valor do saldo deve ser estar zerado.", "Totalizar venda", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        /* Operação de Finalizacao */
        mpParametros.put("lsParcelaPagamento", lsParcelaPagamento);
        mpParametros.put("lsTransacoesTef", lsTransacoesTef);
        mpParametros.put("BeanCondicaoPagamento", beanCondicaoPagamento);
        mpParametros.put("TotalVenda", totalReceber);
        mpParametros.put("SubTotalVenda", subTotal);
        mpParametros.put("valorTroco", valorTroco);
        Operacao finalizacao = OperacaoFactory.getInstance().criarOPFinalizacao();
        mpParametros = finalizacao.executar(mpParametros);

        boolean result = (Boolean) mpParametros.get("BooleanResult");

        return result;
    }

    /* MÉTODOS DE CONTORLE DE PAGAMENTO/PARCELAS */
    private void confirmarSelecaoFormaPagamento(BeanFormaPagamento formaPagamentoBean) {
        try {
            /*
             * Analisar a forma de pagamento e solicitar os dados complementares, se necessário
             */
            fpSelecionada = formaPagamentoBean;
            quantidadeParcelasItem = 1;
            boolean result = false;

            // DINHEIRO
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("DIN")) {
                result = solicitarDadosDinheiro();
            }

            // CHEQUE
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CHE")) {
                result = solicitarDadosCheque();
            }

            // CARTAO DEB TEF
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CART_TEF_DEB")) {
                result = solicitarDadosDebitoTEF();
            }

            // CARTAO CRED TEF
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CART_TEF_CRED")) {
                result = solicitarDadosCreditoTEF();
            }

            // CARTAO DEB POS
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CART_POS_DEB")) {
                result = solicitarDadosDebitoPOS();
            }

            // CARTAO CRED POS
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CART_POS_CRED")) {
                result = solicitarDadosCreditoPOS();
            }

            // CREDIÁRIO
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("CRE")) {
                result = solicitarDadosCrediario();
            }

            // DEVOLUCAO
            if (formaPagamentoBean.getTipo().equalsIgnoreCase("DEV")) {
                result = solicitarDadosDevolucao();
            }

            if (result) {
                /* Em caso de devolucão, verificar parametros sobre utilizar todo o credito de devolucao ou permitir uso parcial */
                BeanParametros beanParametros = DAOFacade.getParametros(new BeanParametros());
                BigDecimal ipValorRecebido = BigDecimal.ZERO;

                if (formaPagamentoBean.getTipo().equalsIgnoreCase("DEV")) {
                    /* Uso total, */
                    if (!beanParametros.isPermiteUtilizacaoCreditoParcial() && totalReceber.compareTo(beanCreditoDevolucao.getValorCredito()) < 0) {
                        JOptionPane.showMessageDialog(this, "Não permitido uso parcial de devolução, utilize todo o saldo disponível.", "Devolução", JOptionPane.WARNING_MESSAGE);
                    } else {
                        ipValorRecebido = beanCreditoDevolucao.getValorCredito();
                    }
                } else {
                    /* Receber valores e adicionar item da parcela a parcela criar e adicionar item parcela para o valor informado */
                    ipValorRecebido = receberValor();
                }


                if (ipValorRecebido.compareTo(BigDecimal.ZERO) > 0) {
                    /* Adicionar item a lista de transações */
                    adicionarTransacoesTef(ipValorRecebido);
                    /* Define se as parcelas devem ser reorganizadas */
                    analisaParcelas(ipValorRecebido);
                    /* Montar e adiciona os itens da parcela */
                    inserirItemParcela(getValorPrevisto(ipValorRecebido, quantidadeParcelasItem), (beanCondicaoPagamento.isExigeEntrada() && formaPrazoEmUnicaParcela()));
                    /* Verifica a necessidade de atualizar os valores totais da parcela */
                    atualizarValoresTotaisParcela();
                    /* incremento do indice de parcela atual */
                    if (!beanCondicaoPagamento.isExigeEntrada() || (beanCondicaoPagamento.isExigeEntrada() && !lsParcelaPagamento.get(0).isAberta())) {
                        ipAtual++;
                    }
                    atualizarAreaResumo();
                }
            }
            reinicializarGlobaisTemporarias();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "(FormaPagamento) ".concat(ex.getMessage()), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean solicitarDadosDinheiro() {
        return true;
    }

    private boolean solicitarDadosCheque() {
        try {
            quantidadeParcelasItem = 1;
            beanCheque = null;
            receberDadosCheque();
            if (beanCheque != null) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosCreditoTEF() {
        try {
            receberConveniada();
            quantidadeParcelasItem = 1;
            if (beanConveniada != null) {
                if (quantidadeParcelasCondicao > 1) {
                    receberQuantidadeParcelas();
                }
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosDebitoTEF() {
        try {
            receberConveniada();
            if (beanConveniada != null) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean solicitarDadosCreditoPOS() {
        try {
            receberNumeroAutorizacao();
            if (numeroAutorizacao != null) {
                receberConveniada();
                if (beanConveniada != null) {
                    receberQuantidadeParcelas();
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosDebitoPOS() {
        try {
            receberNumeroAutorizacao();
            if (numeroAutorizacao != null) {
                receberConveniada();
                if (beanConveniada != null) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosCrediario() {
        try {
            receberCgcCpf();
            if (numeroCgcCpf != null) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean solicitarDadosDevolucao() {
        try {
            receberDadosDevolucao();
            if (beanCreditoDevolucao != null) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private void receberDadosCheque() {
        /* Solicitar os dados do preenchimento do cheque */
        VIEWInserirDadosCheque inserirDadosCheque = new VIEWInserirDadosCheque(null, true, getDataParcelas());
        inserirDadosCheque.setVisible(true);
        if (!inserirDadosCheque.cancelado) {
            beanCheque = inserirDadosCheque.getDadosCheque();
        }
    }

    private List<Date> getDataParcelas() {
        /* Retornar as datas de cada parcela */
        List<Date> lsDataPagamento = new ArrayList<Date>();
        for (VOParcelaPagamento pp : lsParcelaPagamento) {
            lsDataPagamento.add(pp.getData());
        }
        return lsDataPagamento;
    }

    private void receberConveniada() {
        /* Solicitar conveniada do cartão */
        List<BeanConveniada> lsConveniada = new CTRLConveniada().pesquisaConveniadaFormaPagamento(fpSelecionada.getCodFormaPagto());
        beanConveniada = (BeanConveniada) JOptionPane.showInputDialog(null,
                "Selecionar conveniada", "Conveniada", JOptionPane.QUESTION_MESSAGE, null, lsConveniada.toArray(), 0);
    }

    private void receberQuantidadeParcelas() {
        /* Solicitar a quantidade de parcelas para a forma de pagamento selecionada */
        int a = beanCondicaoPagamento.isExigeEntrada() ? quantidadeParcelasCondicao - 1 : quantidadeParcelasCondicao;
        Integer[] opcoesParcelas = new Integer[a];
        for (int i = 0; i < a; i++) {
            opcoesParcelas[i] = i + 1;
        }
        quantidadeParcelasItem = (Integer) JOptionPane.showInputDialog(this,
                "Parcelamento", "Parcelas", JOptionPane.PLAIN_MESSAGE, null, opcoesParcelas, 1);
    }

    private void receberNumeroAutorizacao() {
        /* Solicitar número da autorizacao de operação POS */
        String numAutorizacao = JOptionPane.showInputDialog(this, "Número da Autorização", "Autorização", JOptionPane.QUESTION_MESSAGE);
        if (numAutorizacao != null) {
            if (UTILBiblioteca.regexInteger(numAutorizacao)) {
                numeroAutorizacao = numAutorizacao;
            } else {
                JOptionPane.showMessageDialog(null, "Somente números são permitidos", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                receberNumeroAutorizacao();
            }
        }
    }

    private void receberCgcCpf() {
        /* Coletar cpf */
        String numCgcCpf = JOptionPane.showInputDialog(this, "CGC/CPF", "Informe o CGC/CPF", JOptionPane.QUESTION_MESSAGE);
        if (numCgcCpf != null) {
            if (UTILBiblioteca.regexInteger(numCgcCpf)) {
                if (UTILBiblioteca.validaCpfCnpj(numCgcCpf)) {
                    numeroCgcCpf = numCgcCpf;
                    return;
                }
                JOptionPane.showMessageDialog(null, "CGC/CPF inválido.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Somente números são permitidos", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                receberCgcCpf();
            }
        }
    }

    private void receberDadosDevolucao() {
        beanCreditoDevolucao = null;
        if (beanCliente != null) {
            numeroCgcCpf = beanCliente.getCpfCnpj();
        } else {
            receberCgcCpf();
        }

        /* Caso haja um cpf/cnpj buscar os recibos disponíveis para efetuar pagamento */
        if (numeroCgcCpf != null) {
            VIEWPesquisaDevolucao devolucao = new VIEWPesquisaDevolucao(null, true, numeroCgcCpf);
            devolucao.setVisible(true);
            if (!devolucao.cancelado) {
                if (devolucao.getCreditoDevolucao() != null) {
                    beanCreditoDevolucao = devolucao.getCreditoDevolucao();
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum recibo foi encontrado.", "Devolução", JOptionPane.WARNING_MESSAGE);
                    numeroCgcCpf = null;
                    receberDadosDevolucao();
                }
            }
        }
    }

    private boolean verificarSaldoDevolucao() {
        /* Verifica se a devolução informada possui saldo positivo */
        /*        BeanDevolucao beanDevolucao = pesquisaDevolucao(numeroDevolucao);
         if (beanDevolucao.getSaldo.compareTo(BigDecimal.ZERO) > 0) {
         return true;
         }
         return false;*/
        return true;
    }

    private BigDecimal receberValor() {
        /* Solicitar o valor do item para a forma de pagamento selecionada */
        VIEWInserirReal inserirReal = new VIEWInserirReal(null, true);
        inserirReal.setVisible(true);
        if (!inserirReal.cancelado) {
            if (inserirReal.getValor().compareTo(BigDecimal.ZERO) > 0) {
                /* Tratamento de valor superior a valor disponível na devolução */
                if (fpSelecionada.getTipo().equalsIgnoreCase("DEV") && inserirReal.getValor().compareTo(beanCreditoDevolucao.getValorCredito()) > 0) {
                    JOptionPane.showMessageDialog(this, "Valor superior ao valor disponível!", "Inserir Valor", JOptionPane.ERROR_MESSAGE);
                    return receberValor();
                }
                /* Menor que o saldo a receber ou (Maior que saldo E a forma permita troco) */
                if (inserirReal.getValor().compareTo(new BigDecimal(txtSaldo.getText().replace(",", "."))) <= 0
                        || (inserirReal.getValor().compareTo(new BigDecimal(txtSaldo.getText().replace(",", "."))) > 0 && fpSelecionada.isPermiteTroco())) {
                    return inserirReal.getValor();
                } else {
                    JOptionPane.showMessageDialog(inserirReal, "Valor superior ao saldo à receber.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    return receberValor();
                }
            } else {
                JOptionPane.showMessageDialog(inserirReal, "Valor deve ser maior que zero", "Receber Valor", JOptionPane.OK_OPTION);
                return receberValor();
            }
        }
        return BigDecimal.ZERO;
    }

    private void adicionarTransacoesTef(BigDecimal tfValor) {
        /* Adicionar a lista em caso de operação tef */

        if (fpSelecionada.getTipo().equalsIgnoreCase("CART_TEF_DEB")
                || fpSelecionada.getTipo().equalsIgnoreCase("CART_TEF_CRED")) {
            VOTransacaoTef tf = new VOTransacaoTef();
            tf.setValor(tfValor);
            tf.setTipoTransacao(fpSelecionada.getTipo().equals("CART_TEF_DEB") ? "B" : "C");
            tf.setNumeroParcelas(quantidadeParcelasItem);
            tf.setBeanConveniada(beanConveniada);
            tf.setBeanFormaPagamento(fpSelecionada);

            if (lsTransacoesTef == null) {
                lsTransacoesTef = new ArrayList<VOTransacaoTef>();
            }

            numeroTransacao = lsTransacoesTef.size() + 1;
            tf.setNumeroTransacao(numeroTransacao);
            lsTransacoesTef.add(tf);
        }
    }

    private void analisaParcelas(BigDecimal ipValorRecebido) {
        /* Caso a quantidade de parcelas informada seja menor que a total e o valor informado seja igual ao total a receber 
         * reorganizar as parcelas para que o pagamento seja feito com a quantidade de parcelas menor, caso não
         * avaliar se a parcela atual é uma entrada e regorganizar as parcelas de acordo com o valor da entrada informado
         */
        if (quantidadeParcelasItem < quantidadeParcelasCondicao && ipValorRecebido.compareTo(new BigDecimal(txtValorReceber.getText().replace(".", "").replace(",", "."))) == 0) {
            reorganizarParcelas();
        } else if (permiteEntrada()) {
            // reorganizarParcelasEntrada(ipValorRecebido);
        }
    }

    private void reorganizarParcelas() {
        /* Limpar e reorganizar a lista de parcelas, modificando a quantidade de parcelas da condiçção pela quantidade de parcelas
         * informada para o item de parcela atual
         */
        lsParcelaPagamento = new ArrayList<VOParcelaPagamento>();
        quantidadeParcelasCondicao = quantidadeParcelasItem;
        BigDecimal valorPrevistoParcela = getValorPrevisto(new BigDecimal(txtValorReceber.getText().replace(",", ".")), quantidadeParcelasCondicao);
        gerarParcelasPrevisto(valorPrevistoParcela, false);
    }

    private boolean permiteEntrada() {
        /* Analisa se a condicao de pagamento exige uma entrada e verifica se a entrada já foi preenchida */
        if (beanCondicaoPagamento.isExigeEntrada() && (!fpSelecionada.isPagamentoAPrazo()) || (fpSelecionada.isPagamentoAPrazo() && quantidadeParcelasItem == 1)) {
            return true;
        }
        return false;
    }

    private void reorganizarParcelasEntrada(BigDecimal ipValorRecebidoEntrada) {
        /* Caso o valor recebido seja maior que o valor da primeira parcela(Entrada)
         * Adicionar uma parcela "isolada" com o valor da parcela. Carregar o demais parcelas com o valor restante 
         */
        quantidadeParcelasItem = 1;
        BigDecimal somaParcelaEntrada = lsParcelaPagamento.get(0).getValorRecebido().add(ipValorRecebidoEntrada);
        BigDecimal valorMenosEntrada = new BigDecimal(txtValorReceber.getText().replace(",", ".")).subtract(somaParcelaEntrada);

        if (ipValorRecebidoEntrada.compareTo(lsParcelaPagamento.get(0).getValorParcela()) >= 0
                || somaParcelaEntrada.compareTo(lsParcelaPagamento.get(0).getValorParcela()) >= 0) {

            /* Guardar itens que já existem na parcela para depois inserir */
            List<VOItemParcelaPagamento> lsParcelaPagamentoEntrada = lsParcelaPagamento.get(0).getLsItemParcelaPagamento();
            lsParcelaPagamento = new ArrayList<VOParcelaPagamento>();
            adicionarParcela(Calendar.getInstance().getTime(), somaParcelaEntrada, 1, true);
            lsParcelaPagamento.get(0).setLsItemParcelaPagamento(lsParcelaPagamentoEntrada);
            BigDecimal valorPrevistoParcela = getValorPrevisto(valorMenosEntrada, quantidadeParcelasCondicao - 1);
            gerarParcelasPrevisto(valorPrevistoParcela, true);
        }
    }

    private void gerarParcelasPrevisto(BigDecimal valorPrevistoParcela, boolean flagEntrada) {
        try {
            /* Adicionar parcelas do pagamento segundo a condição e a quantidade de parcelas */
            /* flag que indica se entrada já foi adicionada */

            Calendar dataParcela = Calendar.getInstance();
            int a = 0;
            if (flagEntrada) {
                a = 1;
            }

            for (int i = a; i < quantidadeParcelasCondicao; i++) {
                BigDecimal valorParcela = valorPrevistoParcela;

                /* Calcula as datas das parcelas com base na condição */
                if ((quantidadeParcelasCondicao > 1 && !beanCondicaoPagamento.isExigeEntrada()) || (i > 0)) {
                    dataParcela.add(Calendar.DAY_OF_MONTH, beanCondicaoPagamento.getDiasEntreParcelas());
                }

                /* Adicona valor do arredondamento */
                if (i == 0 || flagEntrada) {
                    valorParcela = valorPrevistoParcela.add(valorArredondamento);
                }

                /* Adicionar parcela a lista de parcelas */
                adicionarParcela(dataParcela.getTime(), valorParcela, i + 1, (beanCondicaoPagamento.isExigeEntrada() && i == 0) ? true : false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarParcela(Date dataParcela, BigDecimal valorParcela, int numeroParcela, boolean isEntrada) {
        /* Adicionar parcela a lista */
        VOParcelaPagamento pp = new VOParcelaPagamento();
        pp.setData(dataParcela);
        // pp.setLsItemParcelaPagamento();
        pp.setValorParcela(valorParcela);
        pp.setNumeroParcela(numeroParcela);
        pp.setEntrada(isEntrada);

        lsParcelaPagamento.add(pp);
    }

    private BigDecimal getValorPrevisto(BigDecimal valorDividir, int numeroDivisor) {
        /* Retorna o valor previsto para cada parcela com base nos parametros */
        BigDecimal valorParcelasPrevisto = valorDividir.divide(new BigDecimal(numeroDivisor), UTILBiblioteca.DECIMAL_VALOR, BigDecimal.ROUND_DOWN);
        definirArredondamento(valorDividir, valorParcelasPrevisto, numeroDivisor);
        return valorParcelasPrevisto;
    }

    private void definirArredondamento(BigDecimal valorRecebido, BigDecimal valorParcelasPrevisto, int n) {
        /* Calcula e define o valor de sobra da divisão */
        try {
            BigDecimal valorSomaParcelasPrevisto = valorParcelasPrevisto.multiply(new BigDecimal(n));
            BigDecimal diferenca = valorRecebido.subtract(valorSomaParcelasPrevisto);
            valorArredondamento = diferenca;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inserirItemParcela(BigDecimal ipValorRecebidoDividido, boolean flagEntrada) {
        /* Montar itens do pagamento */
        int a = 0;
        if (flagEntrada) {
            a = 1;
            quantidadeParcelasItem++;
        }

        /* Loop da quantidade de parcelas da forma de pagamento selecionada */
        for (int i = a; i < quantidadeParcelasItem; i++) {

            /* Caso seja cheque */
            if (fpSelecionada.getTipo().equalsIgnoreCase("CHE")) {
                montarParcelaCheque(ipValorRecebidoDividido);
            } else {
                //if (((lsParcelaPagamento.get(i).isAberta()) || quantidadeParcelasItem != 1) || permiteEntrada()) {
                    BigDecimal ipValorPagamento = ipValorRecebidoDividido;
                    if (lsParcelaPagamento.get(i).getNumeroParcela() - 1 == 0
                            || (flagEntrada && 
                                (quantidadeParcelasItem > 1 && 
                                    lsParcelaPagamento.get(i).getNumeroParcela() - 1 == 1))) {
                        ipValorPagamento = ipValorRecebidoDividido.add(valorArredondamento);
                    }
                    adicionarItemParcela(lsParcelaPagamento.get(i).getNumeroParcela(), ipValorPagamento);
                //} else {
                  //  quantidadeParcelasItem++;
               // }
            }
        }
        atualizarValoresTela();
    }

    private void montarParcelaCheque(BigDecimal ipValor) {
        /* Se pagou valor total com 1 cheque, e foi reorganizado as parcelas, modificar a data da parcela para a data do cheque */
        if (quantidadeParcelasItem == 1 && ipValor.compareTo(new BigDecimal(txtValorReceber.getText().replace(",", "."))) == 0) {
            lsParcelaPagamento.get(0).setData(beanCheque.getData());
        }

        /* Adiconar o cheque na parcela correspondente conforme data selecionada para o cheque */
        int indiceParcela = 0;
        for (Date data : getDataParcelas()) {
            if (beanCheque.getData().getTime() == data.getTime()) {
                adicionarItemParcela(indiceParcela + 1, ipValor);
                break;
            }
            indiceParcela++;
        }
    }

    private void adicionarItemParcela(int ppIndex, BigDecimal ipValorRecebido) {
        /* Adicionar um item de parcela para parcela determinada pelo index */
        try {
            if (ipValorRecebido.compareTo(BigDecimal.ZERO) == 0) {
                return;
            }
            BigDecimal valorItemParcela = ipValorRecebido;
            BigDecimal valorSaldoRestante = new BigDecimal(txtSaldo.getText().replace(".", "").replace(",", "."));
            if ((ipValorRecebido.compareTo(valorSaldoRestante) > 0 && fpSelecionada.isPermiteTroco())
                    || (ipValorRecebido.compareTo(valorSaldoRestante) > 0 && fpSelecionada.getTipo().equals("DEV"))) {
                BigDecimal troco = ipValorRecebido.subtract(valorSaldoRestante);
                this.valorTroco = valorTroco.add(troco);
            }

            lsParcelaPagamento.get(ppIndex - 1).adicionarItemParcela(beanCheque, beanConveniada, fpSelecionada, valorItemParcela, numeroAutorizacao, permiteEntrada(), beanCreditoDevolucao, numeroTransacao);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private BigDecimal getValorRecebido() {
        /* Retornar valor total recebido */
        BigDecimal valorAcumulado = BigDecimal.ZERO;
        for (VOParcelaPagamento pp : lsParcelaPagamento) {
            valorAcumulado = valorAcumulado.add(pp.getValorRecebido());
        }
        return valorAcumulado;
    }

    private void atualizarValoresTela() {
        /* Atualizar os valores */
        try {
            BigDecimal valorRecebido = getValorRecebido();
            BigDecimal valoreReceber = new BigDecimal(txtValorReceber.getText().replace(",", "."));

            BigDecimal valorSaldo = BigDecimal.ZERO;
            if (valoreReceber.subtract(valorRecebido).compareTo(BigDecimal.ZERO) >= 0) {
                valorSaldo = valoreReceber.subtract(valorRecebido);
            }

            /*BigDecimal troco = BigDecimal.ZERO;
             if (valorRecebido.compareTo(valoreReceber) > 0) {
             troco = valorRecebido.subtract(valoreReceber);
             }*/

            setValorRecebido(valorRecebido);
            setSaldo(valorSaldo);
            setTroco(valorTroco);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarValoresTotaisParcela() {
        if (beanCondicaoPagamento.getParcelaMax() > 1) {
            atualizarValoresParcelas();
        }
    }

    private void atualizarValoresParcelas() {
        /* Atualizar os valores nas descrições das parcelas  com base no valor recebido por cada uma */

        if (permiteEntrada()) {
            return;
        }

        /* Atualiza o valor das parcelas */
        for (VOParcelaPagamento pp : lsParcelaPagamento) {
            pp.atualizarValor();
        }

        if (saldoZerado()) {
            excluirParcelasZeradas();
            return;
        }
    }

    private void excluirParcelasZeradas() {
        /* Excluir parcelas com valor 0,00 */
        for (int i = 0; i < lsParcelaPagamento.size(); i++) {
            for (int b = 0; b < lsParcelaPagamento.size(); b++) {
                if (lsParcelaPagamento.get(b).getValorRecebido().compareTo(BigDecimal.ZERO) == 0) {
                    lsParcelaPagamento.remove(b);
                }
            }
        }
    }

    private void atualizarAreaResumo() {
        try {
            /* Atualizar visualização das formas de pagamento, inserindo nova forma confirmada */
            List<String> lsAreaResumo = new ArrayList<String>();
            lsAreaResumo.add(" " + UTILBiblioteca.repete("*", 20).concat(" VENDA NO CAIXA ").concat(UTILBiblioteca.repete("*", 20).concat("\r\n\r\n")));
            int i = 0;

            for (VOParcelaPagamento pp : lsParcelaPagamento) {
                lsAreaResumo.add(String.format("%1$-" + 25 + "s", "Parc (" + (++i) + "/" + lsParcelaPagamento.size() + ") - " + AbstractView.sdf.format(pp.getData())) + " " + UTILBiblioteca.formatoDecimal("V", pp.getValorParcela()) + "\n");

                // Analisar Item da parcela
                for (VOItemParcelaPagamento ipp : pp.getLsItemParcelaPagamento()) {
                    String campoConveniadaCheque = "";
                    // Info Adicionais
                    if (ipp.getConveniada() != null && !ipp.getConveniada().isEmpty()) {
                        campoConveniadaCheque = " " + ipp.getConveniada().toString() + " ";
                    }
                    if (ipp.getCheque() != null && !ipp.getCheque().isEmpty()) {
                        campoConveniadaCheque = " " + ipp.getCheque().toString() + "";
                    }
                    lsAreaResumo.add("    " + String.format("%1$-" + 20 + "s", ipp.getIndiceItemParcela() + " " + ipp.getFormaPagamentoDescricao().concat(campoConveniadaCheque)) + UTILBiblioteca.formatoDecimal("V", ipp.getValorItemParcela()) + "\n");
                }
                lsAreaResumo.add("\r\n");
            }

            // Atualizar visualizaçção
            setAreaResumo(lsAreaResumo);
            if (beanCondicaoPagamento.isExigeEntrada() && !lsParcelaPagamento.get(0).isAberta() && !saldoZerado()) {
                atualizarFormasPagamento();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reinicializarGlobaisTemporarias() {
        numeroCgcCpf = null;
        beanConveniada = null;
        numeroAutorizacao = null;
        beanCreditoDevolucao = null;
        valorArredondamento = null;
        quantidadeParcelasItem = 0;
        fpSelecionada = null;
        beanCheque = null;
        numeroTransacao = 0;
    }

    private boolean formaPrazoEmUnicaParcela() {
        if (fpSelecionada.isPagamentoAPrazo() && quantidadeParcelasItem == 1) {
            return true;
        }
        return false;
    }

    private boolean saldoZerado() {
        BigDecimal valorSaldo = new BigDecimal(txtSaldo.getText().replace(".", "").replace(",", "."));
        if (valorSaldo.compareTo(BigDecimal.ZERO) == 0) {
            return true;
        }
        return false;
    }
}
