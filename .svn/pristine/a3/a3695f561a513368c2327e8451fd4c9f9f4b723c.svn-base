/**
 * <p>Title: SIGEN</p>
 *
 * suporte@sigensistemas.com.br</p>
 *
 * @author P. Boaventura (SIGEN)
 * @version 1.0
 */
package com.sigen.ecf.view;

import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.persistencia.DAOFacade;
import com.sigen.ecf.view.util.ProdutoTableModel;
import com.sigen.ecf.view.util.UTILUppercaseDocumentFilter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.text.AbstractDocument;

public class VIEWPesquisaProduto extends javax.swing.JDialog {

    public boolean cancelado = true;
    private String tipoPesquisa;
    private String quantidade;

    public VIEWPesquisaProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        configurarComportamentoENTER();
        editLocaliza.requestFocus();
        labelDescricaoCompleta.setText("");
        tipoPesquisa = "D";
        alterarTipoPesquisa();

        CancelaAction cancelaAction = new CancelaAction();
        botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        botaoCancela.getActionMap().put("cancelaAction", cancelaAction);

        PesquisaPorAction pesquisaPorAction = new PesquisaPorAction();
        botaoPesquisarPor.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "pesquisaPorAction");
        botaoPesquisarPor.getActionMap().put("pesquisaPorAction", pesquisaPorAction);

        SetaAcimaAction setaAcimaAction = new SetaAcimaAction();
        gridProduto.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "SetaAcimaAction");
        gridProduto.getActionMap().put("SetaAcimaAction", setaAcimaAction);

        SetaAbaixoAction setaAbaixoAction = new SetaAbaixoAction();
        gridProduto.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "SetaAbaixoAction");
        gridProduto.getActionMap().put("SetaAbaixoAction", setaAbaixoAction);

        Action doNothing = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //do nothing
            }
        };

        gridProduto.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "doNothing");
        gridProduto.getActionMap().put("doNothing", doNothing);

        // Definir model table
        setTableModel(new ArrayList<BeanProduto>());

        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridProduto = new javax.swing.JTable();
        panelLocaliza = new javax.swing.JPanel();
        editLocaliza = new javax.swing.JTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        botaoPesquisarPor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelDescricaoCompleta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Localiza e Importa Produto");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaLupa06.png"))); // NOI18N

        panelGrid.setBackground(new Color(255,255,255,0));
        panelGrid.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relação de Produtos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(452, 200));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        gridProduto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        gridProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(gridProduto);

        javax.swing.GroupLayout panelGridLayout = new javax.swing.GroupLayout(panelGrid);
        panelGrid.setLayout(panelGridLayout);
        panelGridLayout.setHorizontalGroup(
            panelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGridLayout.setVerticalGroup(
            panelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGridLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelLocaliza.setBackground(new Color(255,255,255,0));
        panelLocaliza.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informe dados para localização:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        panelLocaliza.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        panelLocaliza.setLayout(new java.awt.GridBagLayout());

        editLocaliza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        panelLocaliza.add(editLocaliza, gridBagConstraints);
        ((AbstractDocument) editLocaliza.getDocument()).setDocumentFilter(new UTILUppercaseDocumentFilter());

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

        botaoPesquisarPor.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        botaoPesquisarPor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoLocalizar.png"))); // NOI18N
        botaoPesquisarPor.setText("Pesquisar por");
        botaoPesquisarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarPorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoConfirma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoCancela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoPesquisarPor, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoPesquisarPor)
                    .addComponent(botaoCancela)
                    .addComponent(botaoConfirma))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setPreferredSize(new java.awt.Dimension(124, 67));

        labelDescricaoCompleta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelDescricaoCompleta.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescricaoCompleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescricaoCompleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelComponentesLayout = new javax.swing.GroupLayout(panelComponentes);
        panelComponentes.setLayout(panelComponentesLayout);
        panelComponentesLayout.setHorizontalGroup(
            panelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLocaliza, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                    .addComponent(panelGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelComponentesLayout.setVerticalGroup(
            panelComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(panelLocaliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(panelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(panelPrincipal, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        confirmar();
}//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        dispose();
}//GEN-LAST:event_botaoCancelaActionPerformed

    private void botaoPesquisarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarPorActionPerformed
    }//GEN-LAST:event_botaoPesquisarPorActionPerformed

    /*public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
     @Override
     public void run() {
     VIEWPesquisaProduto dialog = new VIEWPesquisaProduto(new javax.swing.JFrame(), true);
     dialog.setLocationRelativeTo(null);
     dialog.setVisible(true);
     }
     });
     }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.JButton botaoPesquisarPor;
    private javax.swing.JTextField editLocaliza;
    private javax.swing.JTable gridProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescricaoCompleta;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelGrid;
    private javax.swing.JPanel panelLocaliza;
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

    private class PesquisaPorAction extends AbstractAction {

        public PesquisaPorAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            alterarTipoPesquisa();
        }
    }

    private class SetaAcimaAction extends AbstractAction {

        public SetaAcimaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            upDownAction();
        }
    }

    private class SetaAbaixoAction extends AbstractAction {

        public SetaAbaixoAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            upDownAction();
        }
    }

    private void configurarComportamentoENTER() {
        editLocaliza.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pesquisarProduto();
                }
            }
        });

        gridProduto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && gridProduto.getRowCount() > 0) {
                    confirmar();
                } else if (Character.isLetter(e.getKeyChar()) || Character.isDigit(e.getKeyChar())) {
                    habilitarPesquisa(String.valueOf(e.getKeyChar()));
                }
            }
        });
    }

    private void setTableModel(List<BeanProduto> lsProduto) {

        gridProduto.setModel(new ProdutoTableModel(lsProduto));
        gridProduto.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public String toString() {
                return "gridProduto";
            }
        });

        gridProduto.setAutoCreateColumnsFromModel(false);
        gridProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        FontMetrics fm = gridProduto.getFontMetrics(new java.awt.Font("Arial", 1, 18));
//        gridProduto.setColumnModel(new ProdutoColumnModel(fm));
        gridProduto.setRowHeight(25);
        setColumnSize();
    }

    private void setColumnSize() {
        gridProduto.getColumnModel().getColumn(0).setPreferredWidth(70); // EAN
        gridProduto.getColumnModel().getColumn(1).setPreferredWidth(250); // DESCRIÇÃO
        gridProduto.getColumnModel().getColumn(2).setPreferredWidth(8); // UN
        gridProduto.getColumnModel().getColumn(3).setPreferredWidth(15); // ESTOQUE
        gridProduto.getColumnModel().getColumn(4).setPreferredWidth(15); // PREÇO
    }

    private void pesquisarProduto() {
        BeanProduto produtoPesquisa = new BeanProduto();
        if (tipoPesquisa.equals("C")) {
            produtoPesquisa.setCodProd(getStringProduto());
        } else {
            produtoPesquisa.setDescricao(getStringProduto());
        }
        List<BeanProduto> lsProduto = DAOFacade.getLsProduto(produtoPesquisa);

        if (lsProduto.isEmpty()) {
            produtoPesquisa = new BeanProduto();
            produtoPesquisa.setEan(getStringProduto());
            lsProduto = DAOFacade.getLsProduto(produtoPesquisa);
        }

        setTableModel(lsProduto);
        editLocaliza.setText("");
        definirFocus();
        upDownAction();
    }

    public BeanProduto getProduto() {
        if (gridProduto.getSelectedRow() != -1) {
            ProdutoTableModel tableModel = (ProdutoTableModel) gridProduto.getModel();
            return tableModel.getSelection(gridProduto.getSelectedRow());
        } else {
            return null;
        }
    }

    public String getQuantidade() {
        return quantidade;
    }

    private void alterarTipoPesquisa() {
        /* Alternar o tipo da Pesquisa */
        if (tipoPesquisa.equals("C")) {
            tipoPesquisa = "D";
            botaoPesquisarPor.setText("Pesquisar por Código(F5)");
        } else {
            tipoPesquisa = "C";
            botaoPesquisarPor.setText("Pesquisar por Descrição(F5)");

        }
        limparGrid();
        editLocaliza.setText("");
        labelDescricaoCompleta.setText("");
        editLocaliza.requestFocus();
    }

    private String getStringProduto() {
        /* Obter string com codigo/descrição e a quantidade */
        quantidade = "1";
        String a = editLocaliza.getText();
        if (a.contains("*") && a.replace("*", "X").split("X").length > 1) {
            String[] b = a.replace("*", "X").split("X");
            quantidade = b[0];
            a = b[1];
        }
        return a;
    }

    private void definirFocus() {
        /* Após a pesquisa definir para onde direcionar o focus */
        editLocaliza.requestFocus();
        if (gridProduto.getRowCount() > 0) {
            gridProduto.setRowSelectionInterval(0, 0);
            gridProduto.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado", "Pesquisa Produto", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void confirmar() {
        /* Determinar saída */
        cancelado = false;
        dispose();
    }

    private void upDownAction() {
        /* Teclou acima ou abaixo, edittLocaliza recebe quantidade + código do produto selecionado */
        if (gridProduto.getRowCount() > 0) {
            int i = gridProduto.getSelectedRow();

            ProdutoTableModel tableModel = (ProdutoTableModel) gridProduto.getModel();
            BeanProduto produtoSelecionado = tableModel.getSelection(i);

            String codEanProduto = produtoSelecionado.getEan() != null && !produtoSelecionado.getEan().equals("") ? produtoSelecionado.getEan() : produtoSelecionado.getCodProd();

            editLocaliza.setText(quantidade.concat("*").concat(codEanProduto));
            String descricao = produtoSelecionado.getDescricao();

            if (descricao.length() > 48) {
                descricao = descricao.substring(0, 47);
            }
            labelDescricaoCompleta.setText(descricao);
        }
    }

    private void habilitarPesquisa(String caracter) {
        /* Limpa a lista e redireciona focus para editLocaliza */
        limparGrid();
        editLocaliza.setText(caracter);
        editLocaliza.requestFocus();
    }

    private void limparGrid() {
        setTableModel(new ArrayList<BeanProduto>());
    }
}
