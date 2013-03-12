package com.sigen.ecf.view;

import com.sigen.ecf.infra.IECFService;
import com.sigen.ecf.infra.impl.ECFServiceFactory;
import com.sigen.ecf.model.bean.BeanCliente;
import com.sigen.ecf.model.bean.BeanItemVenda;
import com.sigen.ecf.model.bean.BeanMovimento;
import com.sigen.ecf.model.bean.BeanOperador;
import com.sigen.ecf.model.bean.BeanProduto;
import com.sigen.ecf.model.bean.BeanSuprimento;
import com.sigen.ecf.model.bean.BeanVenda;
import com.sigen.ecf.model.bean.BeanVendedor;
import com.sigen.ecf.model.operacao.Operacao;
import com.sigen.ecf.model.operacao.OperacaoFactory;
import com.sigen.ecf.persistencia.DAOFacade;
import com.sigen.ecf.persistencia.dao.impl.DAOProduto;
import com.sigen.ecf.view.util.AbstractView;
import com.sigen.ecf.view.util.UTILBiblioteca;
import java.awt.AWTKeyStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class VIEWCaixa extends javax.swing.JFrame implements MouseListener {

//****************************************************************************//
// Variáveis de instância                                                     //
//****************************************************************************//
    private DefaultListModel modelMenuPrincipal;
    private DefaultListModel modelMenuOperacoes;
    private DefaultListModel modelMenuFiscal;
    private DefaultListModel modelBobina;
    private DefaultListModel modelSubMenuGerente;
    private DefaultListModel modelSubMenuSupervisor;
    /* Mapa de Parametros */
    Map mpParametro = new HashMap();
    /* Beans */
    private BeanCliente beanCliente;
    private BeanVendedor beanVendedor;
    private BeanOperador beanOperador;
    private List<BeanItemVenda> lsItemVenda;
    private List<BeanItemVenda> lsItemVendaCancelados;
    private boolean cupomAberto = false;
    private boolean recuperandoVenda = false;

//****************************************************************************//
// Construtor                                                                 //
//****************************************************************************//
    @SuppressWarnings("LeakingThisInConstructor")
    public VIEWCaixa() {

        initComponents();

        labelImagemTela.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\imagens\\Tela1024x768.jpg"));
        modelBobina = new DefaultListModel();
        bobina.setModel(modelBobina);

        setResolucao(this);

        definirMenuPrincipal();
        definirMenuOperacoes();
        definirMenuFiscal();
        definirSubMenuGerente();
        definirSubMenuSupervisor();
        fecharMenusSuspenso();
        zerarCampos();
        setLabelVendedor(beanVendedor);


        /* Modificar Recebimento Carne para Desconto */
        labelDescontoItem.setText("F3 - Desconto Item");

        configurarMouseListener();
        configurarKeyAction();

        //troca TAB por ENTER para os edits de código e quantidade
        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        editCodigo.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        editQuantidade.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setExtendedState(MAXIMIZED_BOTH);
            }
        });

        editCodigo.setText("");
        this.pack();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        recuperarVenda();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                            
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        containerPrincipal = new javax.swing.JLayeredPane();
        labelTitulo = new javax.swing.JLabel();
        labelOperador = new javax.swing.JLabel();
        labelVendedor = new javax.swing.JLabel();
        panelBotoes = new javax.swing.JPanel();
        panelIdentCliente = new javax.swing.JPanel();
        labelIdentCliente = new javax.swing.JLabel();
        panelMenuPrincipalSuspenso = new javax.swing.JPanel();
        labelMenuPrincipal = new javax.swing.JLabel();
        panelCarregaPreVenda = new javax.swing.JPanel();
        labelCarregaPreVenda = new javax.swing.JLabel();
        panelMenuFiscal = new javax.swing.JPanel();
        labelMenuFiscal = new javax.swing.JLabel();
        panelProduto = new javax.swing.JPanel();
        labelProduto = new javax.swing.JLabel();
        panelDescontoItem = new javax.swing.JPanel();
        labelDescontoItem = new javax.swing.JLabel();
        panelInformaVendedor = new javax.swing.JPanel();
        labelInformaVendedor = new javax.swing.JLabel();
        panelCancItem = new javax.swing.JPanel();
        labelCancItem = new javax.swing.JLabel();
        panelCancCupom = new javax.swing.JPanel();
        labelCancCupom = new javax.swing.JLabel();
        panelTotVenda = new javax.swing.JPanel();
        labelTotVenda = new javax.swing.JLabel();
        panelDevolucaoMercadoria = new javax.swing.JPanel();
        labelDevolucaoMercadoria = new javax.swing.JLabel();
        panelSair = new javax.swing.JPanel();
        labelSair = new javax.swing.JLabel();
        panelSubMenu = new javax.swing.JPanel();
        panelCard = new javax.swing.JPanel();
        panelSubMenuGerente = new javax.swing.JScrollPane();
        listaSubMenuGerente = new javax.swing.JList();
        panelSubMenuSupervisor = new javax.swing.JScrollPane();
        listaSubMenuSupervisor = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        panelMenuPrincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMenuPrincipal = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        panelMenuOperacoes = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaMenuOperacoes = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        panelMenuFiscalSuspenso = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaMenuFiscal = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        panelBobina = new javax.swing.JScrollPane();
        bobina = new javax.swing.JList();
        editUnitario = new javax.swing.JFormattedTextField();
        editCodigo = new javax.swing.JFormattedTextField();
        editQuantidade = new javax.swing.JFormattedTextField();
        editSubTotal = new javax.swing.JFormattedTextField();
        editTotalItem = new javax.swing.JFormattedTextField();
        labelImagemProduto = new javax.swing.JLabel();
        labelDescricaoProduto = new javax.swing.JLabel();
        labelTotalGeral = new javax.swing.JLabel();
        labelMensagens = new javax.swing.JLabel();
        labelImagemTela = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        containerPrincipal.setPreferredSize(new java.awt.Dimension(1024, 738));

        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 14));
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("SIGEN SISTEMAS - (79) 3211.7678 - comercial@sigensistemas.com.br");
        labelTitulo.setFocusable(false);
        labelTitulo.setName("labelTitulo"); // NOI18N
        labelTitulo.setRequestFocusEnabled(false);
        labelTitulo.setBounds(300, 10, 550, 20);
        containerPrincipal.add(labelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelOperador.setFont(new java.awt.Font("Tahoma", 1, 11));
        labelOperador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelOperador.setText("jLabel1");
        labelOperador.setBounds(754, 60, 230, 14);
        containerPrincipal.add(labelOperador, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelVendedor.setFont(new java.awt.Font("Tahoma", 1, 11));
        labelVendedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelVendedor.setText("jLabel8");
        labelVendedor.setBounds(754, 80, 230, 14);
        containerPrincipal.add(labelVendedor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        panelBotoes.setBackground(new Color(255, 255, 255, 0));
        panelBotoes.setMinimumSize(new java.awt.Dimension(950, 56));
        panelBotoes.setName("panelBotoes"); // NOI18N
        panelBotoes.setPreferredSize(new java.awt.Dimension(950, 56));
        panelBotoes.setLayout(new java.awt.GridBagLayout());

        panelIdentCliente.setBackground(new Color(255, 255, 255, 0));
        panelIdentCliente.setToolTipText("");
        //panelIdentCliente.setName("panelF1"); // NOI18N
        panelIdentCliente.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelIdentCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoCliente.png"))); // NOI18N
        labelIdentCliente.setText("SHIFT + F6 - Identifica Cliente");
        //labelF1.setName("labelF1"); // NOI18N
        panelIdentCliente.add(labelIdentCliente);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelIdentCliente, gridBagConstraints);

        panelMenuPrincipal.setBackground(new Color(255, 255, 255, 0));
        panelMenuPrincipal.setToolTipText("");
        //panelMenuPrincipal.setName("panelF2"); // NOI18N
        panelMenuPrincipal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoMenuPrincipal.png"))); // NOI18N
        labelMenuPrincipal.setText("F2 - Menu Principal");
        //labelF2.setName("labelF2"); // NOI18N
        panelMenuPrincipal.add(labelMenuPrincipal);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelMenuPrincipal, gridBagConstraints);

        panelCarregaPreVenda.setBackground(new Color(255, 255, 255, 0));
        //panelF3.setName("panelF3"); // NOI18N
        panelCarregaPreVenda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelCarregaPreVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoMenuOperacoes.png"))); // NOI18N
        labelCarregaPreVenda.setText("F9 - Pedido de Venda");
        //labelF3.setName("labelF3"); // NOI18N
        panelCarregaPreVenda.add(labelCarregaPreVenda);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelCarregaPreVenda, gridBagConstraints);

        panelMenuFiscal.setBackground(new Color(255, 255, 255, 0));
        panelMenuFiscal.setName("panelMnFiscal"); // NOI18N
        panelMenuFiscal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelMenuFiscal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoMenuFiscal.png"))); // NOI18N
        labelMenuFiscal.setText("F4 - Menu Fiscal");
        //labelF4.setName("labelF4"); // NOI18N
        panelMenuFiscal.add(labelMenuFiscal);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelMenuFiscal, gridBagConstraints);

        panelProduto.setBackground(new Color(255, 255, 255, 0));
        panelProduto.setName("panelF5"); // NOI18N
        panelProduto.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoPesquisa.png"))); // NOI18N
        labelProduto.setText("F5 - Pesquisa Produto");
        //labelF5.setName("labelF5"); // NOI18N
        panelProduto.add(labelProduto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelProduto, gridBagConstraints);

        panelDescontoItem.setBackground(new Color(255, 255, 255, 0));
        //panelRecebCarne.setName("panelF6"); // NOI18N
        panelDescontoItem.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelDescontoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoCalculadora.png"))); // NOI18N
        labelDescontoItem.setText("F3 - Recebimento de Carnê");
        //labelF6.setName("labelF6"); // NOI18N
        panelDescontoItem.add(labelDescontoItem);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelDescontoItem, gridBagConstraints);

        panelInformaVendedor.setBackground(new Color(255, 255, 255, 0));
        //panelInformaVendedor.setName("panelF7"); // NOI18N
        panelInformaVendedor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelInformaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoEncerraVenda.png"))); // NOI18N
        labelInformaVendedor.setText("F7 - Informar Vendedor");
        //labelF7.setName("labelF7"); // NOI18N
        panelInformaVendedor.add(labelInformaVendedor);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelInformaVendedor, gridBagConstraints);

        panelCancItem.setBackground(new Color(255, 255, 255, 0));
        //panelCancItem.setName("panelF8"); // NOI18N
        panelCancItem.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelCancItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoCancelaItem.png"))); // NOI18N
        labelCancItem.setText("SHIFT + F2 - Canc Item");
        //labelF8.setName("labelF8"); // NOI18N
        panelCancItem.add(labelCancItem);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelCancItem, gridBagConstraints);

        panelCancCupom.setBackground(new Color(255, 255, 255, 0));
        //panelCancCupom.setName("panelF9"); // NOI18N
        panelCancCupom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelCancCupom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoCancelaCupom.png"))); // NOI18N
        labelCancCupom.setText("F6 - Canc Cupom");
        //labelF9.setName("labelF9"); // NOI18N
        panelCancCupom.add(labelCancCupom);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelCancCupom, gridBagConstraints);

        panelTotVenda.setBackground(new Color(255, 255, 255, 0));
        //panelTotVenda.setName("panelF10"); // NOI18N
        panelTotVenda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelTotVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoDesconto.png"))); // NOI18N
        labelTotVenda.setText("F10 - Totalizar Venda");
        //labelF10.setName("labelF10"); // NOI18N
        panelTotVenda.add(labelTotVenda);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelTotVenda, gridBagConstraints);

        panelDevolucaoMercadoria.setBackground(new Color(255, 255, 255, 0));
        //panelTEF.setName("panelF11"); // NOI18N
        panelDevolucaoMercadoria.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelDevolucaoMercadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoGaveta.png"))); // NOI18N
        labelDevolucaoMercadoria.setText("F8 - Devolução de Mercadoria");
        //labelF11.setName("labelF11"); // NOI18N
        panelDevolucaoMercadoria.add(labelDevolucaoMercadoria);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelDevolucaoMercadoria, gridBagConstraints);

        panelSair.setBackground(new Color(255, 255, 255, 0));
        //panelSair.setName("panelF12"); // NOI18N
        panelSair.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        labelSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoSair.png"))); // NOI18N
        labelSair.setText("F12 - Sair do Caixa");
        //labelF12.setName("labelF12"); // NOI18N
        panelSair.add(labelSair);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelBotoes.add(panelSair, gridBagConstraints);

        panelBotoes.setBounds(38, 705, 950, 56);
        containerPrincipal.add(panelBotoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        panelSubMenu.setBackground(new Color(255, 255, 255, 0));
        panelSubMenu.setName("panelSubMenu"); // NOI18N
        panelSubMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCard.setLayout(new java.awt.CardLayout());

        panelSubMenuGerente.setBorder(null);
        panelSubMenuGerente.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaSubMenuGerente.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        panelSubMenuGerente.setViewportView(listaSubMenuGerente);

        panelCard.add(panelSubMenuGerente, "cardGerente");

        panelSubMenuSupervisor.setBorder(null);
        panelSubMenuSupervisor.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaSubMenuSupervisor.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        panelSubMenuSupervisor.setViewportView(listaSubMenuSupervisor);

        panelCard.add(panelSubMenuSupervisor, "cardSupervisor");

        panelSubMenu.add(panelCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 22, 450, 180));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/layout/SubMenu.png"))); // NOI18N
        panelSubMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelSubMenu.setBounds(10, 280, 467, 212);
        containerPrincipal.add(panelSubMenu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        panelMenuPrincipalSuspenso.setBackground(new Color(255, 255, 255, 0));
        panelMenuPrincipalSuspenso.setName("panelMenuPrincipal"); // NOI18N
        panelMenuPrincipalSuspenso.setPreferredSize(new java.awt.Dimension(213, 200));
        panelMenuPrincipalSuspenso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Menu Principal");
        panelMenuPrincipalSuspenso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 190, -1));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaMenuPrincipal.setFont(new java.awt.Font("Tahoma", 1, 12));
        listaMenuPrincipal.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        listaMenuPrincipal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMenuPrincipal.setAutoscrolls(false);
        jScrollPane2.setViewportView(listaMenuPrincipal);

        panelMenuPrincipalSuspenso.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 35, 200, 160));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/layout/Menu.png"))); // NOI18N
        panelMenuPrincipalSuspenso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelMenuPrincipalSuspenso.setBounds(685, 40, 213, 200);
        containerPrincipal.add(panelMenuPrincipalSuspenso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        panelMenuOperacoes.setBackground(new Color(255, 255, 255, 0));
        panelMenuOperacoes.setName("panelMenuOperacoes"); // NOI18N
        panelMenuOperacoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Menu Operações");
        panelMenuOperacoes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 190, -1));

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaMenuOperacoes.setFont(new java.awt.Font("Tahoma", 1, 12));
        listaMenuOperacoes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        listaMenuOperacoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMenuOperacoes.setAutoscrolls(false);
        jScrollPane4.setViewportView(listaMenuOperacoes);

        panelMenuOperacoes.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 35, 200, 160));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/layout/Menu.png"))); // NOI18N
        panelMenuOperacoes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelMenuOperacoes.setBounds(715, 40, 213, 200);
        containerPrincipal.add(panelMenuOperacoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        panelMenuFiscalSuspenso.setBackground(new Color(255, 255, 255, 0));
        panelMenuFiscalSuspenso.setName("panelMenuFiscal"); // NOI18N
        panelMenuFiscalSuspenso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Menu Fiscal");
        panelMenuFiscalSuspenso.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 190, -1));

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaMenuFiscal.setFont(new java.awt.Font("Tahoma", 1, 12));
        listaMenuFiscal.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        listaMenuFiscal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMenuFiscal.setAutoscrolls(false);
        listaMenuFiscal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane5.setViewportView(listaMenuFiscal);

        panelMenuFiscalSuspenso.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 35, 200, 160));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/layout/Menu.png"))); // NOI18N
        panelMenuFiscalSuspenso.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelMenuFiscalSuspenso.setBounds(745, 40, 213, 200);
        containerPrincipal.add(panelMenuFiscalSuspenso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        panelBobina.setBorder(null);
        panelBobina.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelBobina.setName("panelBobina"); // NOI18N
        panelBobina.setAutoscrolls(true);

        bobina.setBackground(new java.awt.Color(255, 253, 228));
        bobina.setFont(new java.awt.Font("Courier New", 1, 16));
        bobina.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        bobina.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bobina.setFocusable(false);
        bobina.setName("Bobina"); // NOI18N
        panelBobina.setViewportView(bobina);

        panelBobina.setBounds(40, 240, 405, 360);
        containerPrincipal.add(panelBobina, javax.swing.JLayeredPane.DEFAULT_LAYER);

        editUnitario.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        editUnitario.setBorder(null);
        editUnitario.setEditable(false);
        editUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editUnitario.setText("0,00");
        editUnitario.setFocusable(false);
        editUnitario.setFont(new java.awt.Font("Verdana", 1, 18));
        editUnitario.setName("editUnitario"); // NOI18N
        editUnitario.setBounds(490, 462, 200, 30);
        containerPrincipal.add(editUnitario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        editCodigo.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        editCodigo.setBorder(null);
        editCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editCodigo.setText("0");
        editCodigo.setFont(new java.awt.Font("Verdana", 1, 18));
        editCodigo.setName("editCodigo"); // NOI18N
        editCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                editCodigoFocusLost(evt);
            }
        });
        editCodigo.setBounds(490, 262, 200, 30);
        containerPrincipal.add(editCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        editQuantidade.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        editQuantidade.setBorder(null);
        editQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editQuantidade.setFont(new java.awt.Font("Verdana", 1, 18));
        editQuantidade.setName("editQuantidade"); // NOI18N
        editQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                editQuantidadeFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                editQuantidadeFocusLost(evt);
            }
        });
        editQuantidade.setBounds(490, 362, 200, 30);
        //editQuantidade.setEnabled(false);
        containerPrincipal.add(editQuantidade, javax.swing.JLayeredPane.DEFAULT_LAYER);

        editSubTotal.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        editSubTotal.setBorder(null);
        editSubTotal.setEditable(false);
        editSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editSubTotal.setText("0,00");
        editSubTotal.setFocusable(false);
        editSubTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        editSubTotal.setName("editSubTotal"); // NOI18N
        editSubTotal.setBounds(730, 562, 250, 30);
        containerPrincipal.add(editSubTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        editTotalItem.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        editTotalItem.setBorder(null);
        editTotalItem.setEditable(false);
        editTotalItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editTotalItem.setText("0,00");
        editTotalItem.setFocusable(false);
        editTotalItem.setFont(new java.awt.Font("Verdana", 1, 18));
        editTotalItem.setName("editTotalItem"); // NOI18N
        editTotalItem.setBounds(490, 562, 200, 30);
        containerPrincipal.add(editTotalItem, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelImagemProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImagemProduto.setFocusable(false);
        labelImagemProduto.setName("imageProduto"); // NOI18N
        labelImagemProduto.setBounds(730, 250, 250, 250);
        containerPrincipal.add(labelImagemProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelDescricaoProduto.setFont(new java.awt.Font("Verdana", 1, 48));
        labelDescricaoProduto.setForeground(new java.awt.Color(255, 255, 255));
        labelDescricaoProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDescricaoProduto.setText("Produto para venda");
        labelDescricaoProduto.setName("labelDescricaoProduto"); // NOI18N
        labelDescricaoProduto.setBounds(40, 110, 945, 83);
        containerPrincipal.add(labelDescricaoProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelTotalGeral.setFont(new java.awt.Font("Verdana", 1, 27));
        labelTotalGeral.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalGeral.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalGeral.setText("2.785.565,44");
        labelTotalGeral.setFocusable(false);
        labelTotalGeral.setName("labelTotalGeral"); // NOI18N
        labelTotalGeral.setBounds(40, 652, 400, 40);
        containerPrincipal.add(labelTotalGeral, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelMensagens.setFont(new java.awt.Font("Verdana", 1, 18));
        labelMensagens.setForeground(new java.awt.Color(255, 255, 0));
        labelMensagens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMensagens.setText("<html>Mensagem grande mensagem grande mensagem grande mensagem grande</html>");
        labelMensagens.setFocusable(false);
        labelMensagens.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelMensagens.setName("labelMensagens"); // NOI18N
        labelMensagens.setPreferredSize(new java.awt.Dimension(772, 20));
        labelMensagens.setBounds(485, 650, 500, 45);
        containerPrincipal.add(labelMensagens, javax.swing.JLayeredPane.DEFAULT_LAYER);

        labelImagemTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/layout/Tela1024x768.jpg"))); // NOI18N
        labelImagemTela.setFocusable(false);
        labelImagemTela.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        labelImagemTela.setName("labelImagemTela"); // NOI18N
        labelImagemTela.setRequestFocusEnabled(false);
        labelImagemTela.setBounds(0, 0, 1024, 768);
        containerPrincipal.add(labelImagemTela, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(containerPrincipal);

        pack();
    }// </editor-fold>                                

    private void editCodigoFocusLost(java.awt.event.FocusEvent evt) {
        verificaEditCodigo();
    }

    private void editQuantidadeFocusLost(java.awt.event.FocusEvent evt) {
    }

    private void editQuantidadeFocusGained(java.awt.event.FocusEvent evt) {
    }

// ***************************************************************************//
// Metodos principais e de infra                                              //
// ***************************************************************************//
    private void setResolucao(Container container) {
        String nomeFonte = "";
        int estiloFonte = 0;

        ((JComponent) panelMenuPrincipalSuspenso).setBounds(30, 50, 400, 200);
        ((JComponent) panelMenuFiscalSuspenso).setBounds(30, 50, 400, 200);


        /*        ConfiguracaoController configuracaoControl = new ConfiguracaoController();
         List<PosicaoComponentesVO> listaPosicoes = new ArrayList<PosicaoComponentesVO>();
         PosicaoComponentesVO posicaoComponente = new PosicaoComponentesVO();
         listaPosicoes = configuracaoControl.verificaPosicaoTamanho();
         String nomeComponente = "";

         for (Component componente : container.getComponents()) {
         nomeComponente = componente.getName();
         if (nomeComponente != null) {
         for (int i = 0; i < listaPosicoes.size(); i++) {
         posicaoComponente = listaPosicoes.get(i);
         if (posicaoComponente.getNomeComponente().equals(nomeComponente)) {
         ((JComponent) componente).setBounds(posicaoComponente.getEsquerda(), posicaoComponente.getTopo(), posicaoComponente.getLargura(), posicaoComponente.getAltura());
         if (posicaoComponente.getTamanhoFonte() > 0) {
         nomeFonte = ((JComponent) componente).getFont().getName();
         estiloFonte = ((JComponent) componente).getFont().getStyle();
         ((JComponent) componente).setFont(new Font(nomeFonte, estiloFonte, posicaoComponente.getTamanhoFonte()));
         }
         if (componente instanceof JLabel) {
         ((JLabel) componente).setText(posicaoComponente.getTextoComponente());
         }
         break;
         }
         }
         }
         setResolucao((Container) componente);
         }*/
    }

    private void setarImagem(String nome) {
        try {
//            labelImagemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource(configuracao.getCaminhoImagensProdutos() + nome)));
        } catch (Exception e) {
            //          labelImagemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource(configuracao.getCaminhoImagensProdutos() + "padrao.png")));
        }
    }

// ***************************************************************************//
// Métodos para definição e acionamento dos menus e submenus                  //
// ***************************************************************************//
    private void definirMenuPrincipal() {
        modelMenuPrincipal = new DefaultListModel();
        listaMenuPrincipal.setModel(modelMenuPrincipal);
        modelMenuPrincipal.addElement("Supervisor");
        modelMenuPrincipal.addElement("Abrir Gaveta");
        modelMenuPrincipal.addElement("Saída Temporária");
    }

    private void definirMenuOperacoes() {
        modelMenuOperacoes = new DefaultListModel();
        listaMenuOperacoes.setModel(modelMenuOperacoes);
        modelMenuOperacoes.addElement("Carrega Pré-Venda");
    }

    private void definirMenuFiscal() {
        modelMenuFiscal = new DefaultListModel();
        listaMenuFiscal.setModel(modelMenuFiscal);
        modelMenuFiscal.addElement("LX - Leitura X");
        modelMenuFiscal.addElement("<html><center>LMFC - Leitura Memória <br>Fiscal Completa</center></html>");
        modelMenuFiscal.addElement("<html><center>LMFS - Leitura Memória <br>Fiscal Simplificada LMFS</center></html>");
        modelMenuFiscal.addElement("Espelho MFD");
        modelMenuFiscal.addElement("Arquivo MFD");
        modelMenuFiscal.addElement("Tabela de Produtos");
        modelMenuFiscal.addElement("Estoque");
        modelMenuFiscal.addElement("Movimento por ECF");
        modelMenuFiscal.addElement("Meios de Pagamento");
        modelMenuFiscal.addElement("DAV Emitidos");
        modelMenuFiscal.addElement("Identificação do PAF-ECF");
        modelMenuFiscal.addElement("Vendas do Período");
        modelMenuFiscal.addElement("<html><center>Tabela Índice Técnicos <br>de Produção</center></html>");
        modelMenuFiscal.addElement("Parâmetros de Configuração");
    }

    private void definirSubMenuGerente() {
        modelSubMenuGerente = new DefaultListModel();
        listaSubMenuGerente.setModel(modelSubMenuGerente);
        modelSubMenuGerente.addElement("Iniciar Movimento");
        modelSubMenuGerente.addElement("Encerrar Movimento");
        modelSubMenuGerente.addElement(" ");
        modelSubMenuGerente.addElement("Suprimento");
        modelSubMenuGerente.addElement("Sangria");
        modelSubMenuGerente.addElement(" ");
        modelSubMenuGerente.addElement(" ");
        modelSubMenuGerente.addElement("Redução Z");
        modelSubMenuGerente.addElement(" ");
        modelSubMenuGerente.addElement("Consultar Cliente");
        modelSubMenuGerente.addElement(" ");
        modelSubMenuGerente.addElement("Configurações Caixa");
        modelSubMenuGerente.addElement(" ");
        modelSubMenuGerente.addElement("Importar Tabelas com Dispositivo (pen-drive)");
        modelSubMenuGerente.addElement("Exportar Tabelas com Dispositivo (pen-drive)");
        modelSubMenuGerente.addElement(" ");
        modelSubMenuGerente.addElement("TEF - Módulo Administrativo");
    }

    private void definirSubMenuSupervisor() {
        modelSubMenuSupervisor = new DefaultListModel();
        listaSubMenuSupervisor.setModel(modelSubMenuSupervisor);
        modelSubMenuSupervisor.addElement("Iniciar Movimento");
        modelSubMenuSupervisor.addElement("Encerrar Movimento");
        modelSubMenuSupervisor.addElement("Posição de Caixa");
        modelSubMenuSupervisor.addElement(" ");
        modelSubMenuSupervisor.addElement("Suprimento");
        modelSubMenuSupervisor.addElement("Sangria");
        //modelSubMenuSupervisor.addElement("Recarga");        
        modelSubMenuSupervisor.addElement(" ");
        modelSubMenuSupervisor.addElement("Redução Z");
        modelSubMenuSupervisor.addElement(" ");
        modelSubMenuSupervisor.addElement("TEF - Módulo Administrativo");
    }

    private void acionaMenuPrincipal() {
        if (cupomAberto) {
            UTILBiblioteca.informarOperacaoNaoPermitida("Cupom Aberto.");
            return;
        }

        fecharMenusSuspenso();
        panelMenuPrincipalSuspenso.setVisible(true);
        listaMenuPrincipal.requestFocus();
        listaMenuPrincipal.setSelectedIndex(0);
    }

    private void acionaMenuOperacoes() {
        fecharMenusSuspenso();
        panelMenuOperacoes.setVisible(true);
        listaMenuOperacoes.requestFocus();
        listaMenuOperacoes.setSelectedIndex(0);
    }

    public void acionaMenuFiscal() {
        fecharMenusSuspenso();
        panelMenuFiscalSuspenso.setVisible(true);
        listaMenuFiscal.requestFocus();
        listaMenuFiscal.setSelectedIndex(0);
    }

    private void fecharMenusSuspenso() {
        panelMenuFiscalSuspenso.setVisible(false);
        panelMenuPrincipalSuspenso.setVisible(false);
        panelMenuOperacoes.setVisible(false);
        panelSubMenu.setVisible(false);
    }

    private BigDecimal totalGeral = BigDecimal.ZERO;
    private BigDecimal totalSubTotal = BigDecimal.ZERO;
    
    private void zerarCampos() {
        labelTotalGeral.setText("0,00");
        editSubTotal.setText("0,00");
        editTotalItem.setText("0,00");
        editUnitario.setText("0,00");
        lsItemVenda = null;
        lsItemVendaCancelados = null;
        beanCliente = null;
        beanVendedor = null;
        mpParametro.remove("BeanVenda");
        mpParametro.remove("BeanCliente");
        mpParametro.remove("BeanVendedor");
        modelBobina.clear();
        labelDescricaoProduto.setText("SIGEN ECF");
        setLabelMensagem("CAIXA ABERTO");
        cupomAberto = false;
        mpParametro.put("CupomAberto", cupomAberto);
        setLabelVendedor(null);
        totalGeral = BigDecimal.ZERO;
        totalSubTotal = BigDecimal.ZERO;
        totalDesconto = BigDecimal.ZERO;
    }

    private void acionaSubMenu() {
        if (!UTILBiblioteca.autenticarLoginGerente()) {
            return;
        }
        panelSubMenu.setVisible(true);
        ((CardLayout) panelCard.getLayout()).show(panelCard, "cardSupervisor");
        listaSubMenuSupervisor.requestFocus();
        listaSubMenuSupervisor.setSelectedIndex(0);
    }

    private void configurarKeyAction() {
        IdentClienteAction identClienteAction = new IdentClienteAction();
        panelIdentCliente.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, InputEvent.SHIFT_MASK), "identClienteAction");
        panelIdentCliente.getActionMap().put("identClienteAction", identClienteAction);

        MenuPrincipalAction menuPrincipalAction = new MenuPrincipalAction();
        panelMenuPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "menuPrincipalAction");
        panelMenuPrincipal.getActionMap().put("menuPrincipalAction", menuPrincipalAction);

        DescontoItemAction descontoItemAction = new DescontoItemAction();
        panelDescontoItem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "descontoItemAction");
        panelDescontoItem.getActionMap().put("descontoItemAction", descontoItemAction);

        MenuFiscalAction menuFiscalAction = new MenuFiscalAction();
        panelMenuFiscal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "menuFiscalAction");
        panelMenuFiscal.getActionMap().put("menuFiscalAction", menuFiscalAction);

        LocalizaProdutoAction localizaProdutoAction = new LocalizaProdutoAction();
        panelProduto.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "localizaProdutoAction");
        panelProduto.getActionMap().put("localizaProdutoAction", localizaProdutoAction);

        CancelaCupomAction cancelaCupomAction = new CancelaCupomAction();
        panelCancCupom.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "cancelaCupomAction");
        panelCancCupom.getActionMap().put("cancelaCupomAction", cancelaCupomAction);

        InformarVendedorAction informarVendedorAction = new InformarVendedorAction();
        panelInformaVendedor.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "informarVendedorAction");
        panelInformaVendedor.getActionMap().put("informarVendedorAction", informarVendedorAction);

        DevolucaoMercadoriaAction devolucaoMercadoriaAction = new DevolucaoMercadoriaAction();
        panelDevolucaoMercadoria.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "devolucaoMercadoriaAction");
        panelDevolucaoMercadoria.getActionMap().put("devolucaoMercadoriaAction", devolucaoMercadoriaAction);

        CarregarPreVendaAction carregarPreVendaAction = new CarregarPreVendaAction();
        panelCarregaPreVenda.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "f9Action");
        panelCarregaPreVenda.getActionMap().put("f9Action", carregarPreVendaAction);

        TotalizarVendaAction totalizarVendaAction = new TotalizarVendaAction();
        panelTotVenda.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "totalizarVendaAction");
        panelTotVenda.getActionMap().put("totalizarVendaAction", totalizarVendaAction);

        CancelaItemAction cancelaItemAction = new CancelaItemAction();
        panelCancItem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.SHIFT_MASK), "cancelaItemAction");
        panelCancItem.getActionMap().put("cancelaItemAction", cancelaItemAction);

        SairAplicacaoAction sairAction = new SairAplicacaoAction();
        panelSair.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "sairAction");
        panelSair.getActionMap().put("sairAction", sairAction);

        ESCAction escAction = new ESCAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAction");
        containerPrincipal.getActionMap().put("ESCAction", escAction);

        AbreGavetaAction abreGavetaAction = new AbreGavetaAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, InputEvent.SHIFT_MASK), "AbreGavetaAction");
        containerPrincipal.getActionMap().put("AbreGavetaAction", abreGavetaAction);


        EnterAction enterAction = new EnterAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "EnterAction");
        containerPrincipal.getActionMap().put("EnterAction", enterAction);

        SetaAcimaAction setaAcimaAction = new SetaAcimaAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "SetaAcimaAction");
        containerPrincipal.getActionMap().put("SetaAcimaAction", setaAcimaAction);

        SetaAbaixoAction setaAbaixoAction = new SetaAbaixoAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "SetaAbaixoAction");
        containerPrincipal.getActionMap().put("SetaAbaixoAction", setaAbaixoAction);
    }

    private void configurarMouseListener() {
        panelIdentCliente.addMouseListener(this);
        panelMenuPrincipal.addMouseListener(this);
        panelCarregaPreVenda.addMouseListener(this);
        panelMenuFiscal.addMouseListener(this);
        panelProduto.addMouseListener(this);
        panelDescontoItem.addMouseListener(this);
        panelInformaVendedor.addMouseListener(this);
        panelCancItem.addMouseListener(this);
        panelCancCupom.addMouseListener(this);
        panelTotVenda.addMouseListener(this);
        panelDevolucaoMercadoria.addMouseListener(this);
        panelSair.addMouseListener(this);
    }

    // ***************************************************************************//
    //                          Métodos de operações                              //
    // ***************************************************************************//
    private void identificarCliente(boolean flagDevolucao) {
        if (cupomAberto) {
            UTILBiblioteca.informarOperacaoNaoPermitida("Cupom Aberto.");
            return;
        }
        
        if(!validaCaixaAberto()){
            JOptionPane.showMessageDialog(this, "Caixa Fechado.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VIEWIdentificarCliente identificarCliente = new VIEWIdentificarCliente(null, true, flagDevolucao);
        identificarCliente.setVisible(true);
        if (!identificarCliente.cancelado) {
            beanCliente = identificarCliente.getCliente();
            mpParametro.put("BeanCliente", beanCliente);
        }
    }
    
    private boolean validaCaixaAberto(){
        return mpParametro.get("BeanMovimento") != null;
    }

    private void cancelarCupom() {
        if(!validaCaixaAberto()){
            JOptionPane.showMessageDialog(this, "Caixa Fechado.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!cupomAberto) {
            if (!cancelarUltimoCOO()) {
                JOptionPane.showMessageDialog(this, "Cupom Fiscal não pode ser cancelado", "Cancelar Cupom", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (recuperandoVenda || UTILBiblioteca.autenticarLoginGerente()) {
            /* Ações */
            Operacao cancelaVenda = OperacaoFactory.getInstance().criarOPCancelaVenda();
            mpParametro = cancelaVenda.executar(mpParametro);
            cupomAberto = false;
            mpParametro.put("CupomAberto", cupomAberto);
            setLabelMensagem("Cupom Fiscal Cancelado");
            zerarCampos();
        }
    }

    private boolean cancelarUltimoCOO() {
        String codMov = ((BeanMovimento) mpParametro.get("BeanMovimento")).getCodMov();
        BeanVenda ultimaVenda = new BeanVenda();
        ultimaVenda.setCodMov(codMov);
        String clausula = " ORDER BY CAST(COO AS INTEGER) DESC";
        ultimaVenda = DAOFacade.getUltimaVenda(ultimaVenda, clausula);

        IECFService eCFService = ECFServiceFactory.getInstance().criarECFService();

        boolean result = eCFService.getCOO().equals(ultimaVenda.getCoo());

        if (result) {
            mpParametro.put("BeanVenda", ultimaVenda);
        }

        return result;
    }

    private void efetuarDescontoItem() {
        if(!validaCaixaAberto()){
            JOptionPane.showMessageDialog(this, "Caixa Fechado.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (UTILBiblioteca.autenticarLoginGerente()) {
            Integer itemDesconto = Integer.parseInt(JOptionPane.showInputDialog(null, "Item", "Desconto Item", JOptionPane.QUESTION_MESSAGE));
            efetuarDesconto(itemDesconto);
        }
    }

    private void cancelarItemVenda() {
        if(!validaCaixaAberto()){
            JOptionPane.showMessageDialog(this, "Caixa Fechado.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }        
        if (UTILBiblioteca.autenticarLoginGerente()) {
            Integer itemCancelar = Integer.parseInt(JOptionPane.showInputDialog(null, "Cancelar item", "Item", JOptionPane.QUESTION_MESSAGE));
            cancelarItemBobina(itemCancelar);
        }
    }

    private void abrirAdministradorTef() {
        Operacao administradorTef = OperacaoFactory.getInstance().criarOPAdministradorTEF();
        administradorTef.executar(new HashMap());
    }

    private void iniciarMovimento() {
        VIEWLoginIniciarMovimento loginIniciarMovimento = new VIEWLoginIniciarMovimento(this, true, mpParametro);
        loginIniciarMovimento.setVisible(true);
        if (!loginIniciarMovimento.cancelado) {
            fecharMenusSuspenso();
            zerarCampos();
        }
    }

    private void pesquisarProduto() {
        VIEWPesquisaProduto pesquisaProduto = new VIEWPesquisaProduto(null, true);
        pesquisaProduto.setVisible(true);
        if (!pesquisaProduto.cancelado && validaCaixaAberto()) {
            BeanProduto beanProduto = pesquisaProduto.getProduto();
            String quantidade = pesquisaProduto.getQuantidade();
            /* Registrar na bobina, guardar em lista e executar insert */
            venderItemTela(beanProduto, quantidade);
            addProdutoLista(beanProduto, quantidade);

            /* OPVendeItem */
            Operacao vendeItem = OperacaoFactory.getInstance().criarOPVendaItem();
            mpParametro.put("BeanItemVenda", lsItemVenda.get(lsItemVenda.size() - 1));
            mpParametro = vendeItem.executar(mpParametro);
        }
    }

    private void addProdutoLista(BeanProduto produto, String quantidade) {
        /* Adicionar o produto vendido a lista de produtos da venda */
        if (lsItemVenda == null) {
            lsItemVenda = new ArrayList<BeanItemVenda>();
        }
        BeanItemVenda itemVenda = montarItemVenda(produto, quantidade);

        lsItemVenda.add(itemVenda);
        atualizaValoresTotais();
    }

    private void identificarVendedor() {
        if(!validaCaixaAberto()){
            JOptionPane.showMessageDialog(this, "Caixa Fechado.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        VIEWConsultarVendedor consultarVendedor = new VIEWConsultarVendedor(null, true);
        consultarVendedor.setVisible(true);
        if (!consultarVendedor.cancelado) {
            beanVendedor = consultarVendedor.getVendedor();
            mpParametro.put("BeanVendedor", beanVendedor);
            setLabelVendedor(beanVendedor);
        }
    }

    private void informarPedido() {
        if(!validaCaixaAberto()){
            JOptionPane.showMessageDialog(this, "Caixa Fechado.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cupomAberto) {
            UTILBiblioteca.informarOperacaoNaoPermitida("Cupom Aberto.");
            return;
        }

        VIEWInformarPedido informarPedido = new VIEWInformarPedido(null, true);
        informarPedido.setVisible(true);
    }

    private void totalizarVenda() {
        if(!validaCaixaAberto()){
            JOptionPane.showMessageDialog(this, "Caixa Fechado.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(totalGeral.compareTo(BigDecimal.ZERO) <= 0){
            JOptionPane.showMessageDialog(this, "Não existem valores à receber.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String valor = String.valueOf(labelTotalGeral.getText().replace("R$ ", "").replace(".", "").replace(",", "."));
        BigDecimal totalVenda = new BigDecimal(valor);
        String subTotal = String.valueOf(editSubTotal.getText().replace("R$ ", "").replace(".", "").replace(",", "."));
        BigDecimal valorCompra = new BigDecimal(subTotal);
        VIEWSelecionarCondicaoPagamento selecionarCondicaoPagamento = new VIEWSelecionarCondicaoPagamento(null, true, totalSubTotal, totalDesconto, totalGeral, mpParametro);

        selecionarCondicaoPagamento.setVisible(true);
        if (!selecionarCondicaoPagamento.cancelado) {
            zerarCampos();
        }
    }
    private boolean showCaixaFechadoMsg = true;
    private void sairAplicacao() {
        if (cupomAberto) {
            UTILBiblioteca.informarOperacaoNaoPermitida("Cupom Aberto.");
            return;
        }
        showCaixaFechadoMsg = false;
        if (UTILBiblioteca.autenticarLoginGerente()) {
            Operacao opSairAplicacao = OperacaoFactory.getInstance().criarOPSairAplicacao();
            mpParametro = opSairAplicacao.executar(mpParametro);
        }
        showCaixaFechadoMsg = true;
    }

    private void abrirGaveta() {
        Operacao abrirGaveta = OperacaoFactory.getInstance().criarOPAbrirGaveta();
        abrirGaveta.executar(new HashMap());
    }

    private void encerrarMovimento() {
        VIEWLoginEncerrarMovimento encerrarMovimento = new VIEWLoginEncerrarMovimento(null, true, mpParametro);
        encerrarMovimento.setVisible(true);
        if (!encerrarMovimento.cancelado) {
            fecharMenusSuspenso();
            zerarCampos();
            setLabelMensagem("CAIXA FECHADO");
        }
    }

    private void emitirPosicaoCaixa() {
        Operacao posicaoCaixa = OperacaoFactory.getInstance().criarOPRelatorioPosicaoCaixa();
        mpParametro = posicaoCaixa.executar(mpParametro);
    }

    private void devolucaoMercadoria() {
        if(!validaCaixaAberto()){
            JOptionPane.showMessageDialog(this, "Caixa Fechado.", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cupomAberto) {
            UTILBiblioteca.informarOperacaoNaoPermitida("Cupom Aberto.");
            return;
        }

        VIEWIdentificarClienteDevolucao identificarClienteDevolucao = new VIEWIdentificarClienteDevolucao(this, true);
        identificarClienteDevolucao.setVisible(true);
        if (!identificarClienteDevolucao.cancelado) {
            mpParametro.put("BeanDevolucao", identificarClienteDevolucao.getDados());
            VIEWInserirItemDevolucao inserirItemDevolucao = new VIEWInserirItemDevolucao(this, true, mpParametro);
            inserirItemDevolucao.setVisible(true);
            mpParametro.remove("BeanDevolucao");
        }
        zerarCampos();
    }

    private void efetuarSangria() {
        VIEWEfetuarSangria efetuarSangria = new VIEWEfetuarSangria(null, true, mpParametro);
        efetuarSangria.setVisible(true);
    }

    private void efetuarSuprimento() {
        VIEWInserirReal inserirReal = new VIEWInserirReal(null, true);
        inserirReal.setVisible(true);
        if (!inserirReal.cancelado && inserirReal.getValor().compareTo(BigDecimal.ZERO) > 0) {

            BeanSuprimento beanSuprimento = new BeanSuprimento();
            beanSuprimento.setValor(inserirReal.getValor());
            mpParametro.put("BeanSuprimento", beanSuprimento);

            /* Operacao de suprimento */
            Operacao suprimento = OperacaoFactory.getInstance().criarOPSuprimento();
            mpParametro = suprimento.executar(mpParametro);
        }
    }

    private void emitirLeituraX() {
        IECFService eCFService = ECFServiceFactory.getInstance().criarECFService();
        eCFService.emitirLeituraX();
    }

    private void emitirReducaoZ() {
        Operacao reducaoZ = OperacaoFactory.getInstance().criarOPReducaoZ();
        reducaoZ.executar(mpParametro);
    }

    private void emitirLeituraMFC() {
        VIEWLeituraMemoriaFiscalCompleta memoriaFiscalCompleta = new VIEWLeituraMemoriaFiscalCompleta(this, true);
        memoriaFiscalCompleta.setVisible(true);
    }

    private void emitirLeituraMFS() {
        VIEWLeituraMemoriaFiscalSimplificada memoriaFiscalSimplificada = new VIEWLeituraMemoriaFiscalSimplificada(this, true);
        memoriaFiscalSimplificada.setVisible(true);
    }

    private void gerarEspelhoMFD() {
        VIEWEspelhoMFD espelhoMFD = new VIEWEspelhoMFD(this, true);
        espelhoMFD.setVisible(true);
    }

    private void gerarArquivoMFD() {
        VIEWArquivoMFD arquivoMFD = new VIEWArquivoMFD(this, true);
        arquivoMFD.setVisible(true);
    }

    private void gerarDAVEmitidos() {
        VIEWDAVEmitidos emitidosDAV = new VIEWDAVEmitidos(this, true);
        emitidosDAV.setVisible(true);
    }

    private BeanItemVenda montarItemVenda(BeanProduto produto, String quantidade) {
        // Transformar produto em ItemVenda
        BeanItemVenda itemVendaProduto = new BeanItemVenda();
        itemVendaProduto.setCodProd(produto.getCodProd());
        itemVendaProduto.setDescricao(produto.getDescricao());
        itemVendaProduto.setValorUnitario(produto.getPrecoVenda());
        itemVendaProduto.setValorDesconto(BigDecimal.ZERO);
        itemVendaProduto.setValorAcrescimo(BigDecimal.ZERO);
        itemVendaProduto.setValorTotal(produto.getPrecoVenda().multiply(new BigDecimal(quantidade)));
        //itemVendaProduto.setSaldoEstoque(produto.getSaldoEstoque());
        itemVendaProduto.setIcmsSt(produto.getIcmsSt());
        itemVendaProduto.setIcmsRedBc(produto.getIcmsRedBc());
        itemVendaProduto.setIcmsAliq(produto.getIcmsAliq());
        itemVendaProduto.setIpiSt(produto.getIpiSt());
        itemVendaProduto.setIpiAliq(produto.getIpiAliq());
        itemVendaProduto.setPisSt(produto.getPisSt());
        itemVendaProduto.setPisAliq(produto.getPisAliq());
        itemVendaProduto.setCofinsSt(produto.getCofinsSt());
        itemVendaProduto.setCofinsAliq(produto.getCofinsAliq());
        itemVendaProduto.setCfop(produto.getCfop());
        itemVendaProduto.setQuantidadeVendida(new BigDecimal(quantidade));
        itemVendaProduto.setQuantidadeEmbalagem(produto.getQuantidadeEmbalagem());
        itemVendaProduto.setUndDescricao(produto.getUndDescricao());
        itemVendaProduto.setCodUnd(produto.getCodUnd());

        /* BC e  Valor */
        BigDecimal valorTotalItem = produto.getPrecoVenda().multiply(new BigDecimal(quantidade));
        BigDecimal icmsBc = valorTotalItem.multiply(new BigDecimal("100").subtract(produto.getIcmsRedBc())).divide(new BigDecimal("100"));

        if (produto.getIcmsSt().equals("60")) {
            icmsBc = BigDecimal.ZERO;
        }

        itemVendaProduto.setIcmsBc(icmsBc);
        itemVendaProduto.setIcmsValor(icmsBc.multiply(produto.getIcmsAliq()).divide(new BigDecimal("100")));
        itemVendaProduto.setIpiBc(valorTotalItem);
        itemVendaProduto.setIpiValor(valorTotalItem.multiply(produto.getIpiAliq()).divide(new BigDecimal("100")));
        itemVendaProduto.setPisBc(valorTotalItem);
        itemVendaProduto.setPisValor(valorTotalItem.multiply(produto.getPisAliq()).divide(new BigDecimal("100")));
        itemVendaProduto.setCofinsBc(valorTotalItem);
        itemVendaProduto.setCofinsValor(valorTotalItem.multiply(produto.getCofinsAliq()).divide(new BigDecimal("100")));
        /* ~~~~~~~~~~ || ~~~~~~~~*/

        int indiceUltimoItem = getNumeroUltimoItem();
        itemVendaProduto.setCodMov(((BeanMovimento) mpParametro.get("BeanMovimento")).getCodMov());
        itemVendaProduto.setItem(String.valueOf(indiceUltimoItem + 1));
        itemVendaProduto.setCodVendedor(mpParametro.get("BeanVendedor") != null ? ((BeanVendedor) mpParametro.get("BeanVendedor")).getCodVendedor() : null);
        itemVendaProduto.setLoja(((BeanMovimento) mpParametro.get("BeanMovimento")).getLoja());
        itemVendaProduto.setCodEcf(((BeanMovimento) mpParametro.get("BeanMovimento")).getCodEcf());
        itemVendaProduto.setCodOper(((BeanOperador) mpParametro.get("BeanOperador")).getCodOper());
        itemVendaProduto.setDecimaisQuantidade(new BigDecimal(UTILBiblioteca.DECIMAL_QUANTIDADE));
        itemVendaProduto.setDecimaisValor(new BigDecimal(UTILBiblioteca.DECIMAL_VALOR));
        itemVendaProduto.setIat("A");
        itemVendaProduto.setIndicadorCancelamento("N");

        return itemVendaProduto;
    }

    private int getNumeroUltimoItem() {
        /*String ultimoItem = "0";
        if (!lsItemVenda.isEmpty()) {
            ultimoItem = lsItemVenda.get(lsItemVenda.size() - 1).getItem();
        }
        return Integer.parseInt(ultimoItem);*/
        int ultimoItem = 0;
        if(lsItemVenda != null){
            ultimoItem = lsItemVenda.size();
        }
        if(lsItemVendaCancelados != null){
            ultimoItem += lsItemVendaCancelados.size();
        }
        return ultimoItem;
    }

    private void saidaTemporaria() {
        if (cupomAberto) {
            UTILBiblioteca.informarOperacaoNaoPermitida("Cupom Aberto");
            return;
        }
        fecharMenusSuspenso();
        VIEWLoginIniciarMovimentoAberto loginIniciarMovimentoAberto = new VIEWLoginIniciarMovimentoAberto(this, true, mpParametro, true);
        loginIniciarMovimentoAberto.setVisible(true);
        zerarCampos();


    }

    // ***************************************************************************//
// Actions vinculadas ao pressionamento de teclas                             //
// ***************************************************************************//
    private class IdentClienteAction extends AbstractAction {

        public IdentClienteAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            identificarCliente(false);
        }
    }

    private class CancelaCupomAction extends AbstractAction {

        public CancelaCupomAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cancelarCupom();
        }
    }

    private class CancelaItemAction extends AbstractAction {

        public CancelaItemAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cancelarItemVenda();
        }
    }

    private class DevolucaoMercadoriaAction extends AbstractAction {

        public DevolucaoMercadoriaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //abrirAdministradorTef();
            devolucaoMercadoria();
        }
    }

    private class MenuPrincipalAction extends AbstractAction {

        public MenuPrincipalAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            acionaMenuPrincipal();
        }
    }

    private class DescontoItemAction extends AbstractAction {

        public DescontoItemAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            efetuarDescontoItem();
        }
    }

    private class MenuFiscalAction extends AbstractAction {

        public MenuFiscalAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            acionaMenuFiscal();
        }
    }

    private class LocalizaProdutoAction extends AbstractAction {

        public LocalizaProdutoAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            showCaixaFechadoMsg = false;
            pesquisarProduto();
            showCaixaFechadoMsg = true;
        }
    }

    private class SuprimentoAction extends AbstractAction {

        public SuprimentoAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    private class InformarVendedorAction extends AbstractAction {

        public InformarVendedorAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            identificarVendedor();
        }
    }

    private class CarregarPreVendaAction extends AbstractAction {

        public CarregarPreVendaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            informarPedido();
        }
    }

    private class TotalizarVendaAction extends AbstractAction {

        public TotalizarVendaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            totalizarVenda();
        }
    }

    private class SairAplicacaoAction extends AbstractAction {

        public SairAplicacaoAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            sairAplicacao();
        }
    }

    private class ESCAction extends AbstractAction {

        public ESCAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            teclouESC();
        }
    }

    private class AbreGavetaAction extends AbstractAction {

        public AbreGavetaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            abrirGaveta();
        }
    }

    private class EnterAction extends AbstractAction {

        public EnterAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                teclouEnter();
            } catch (Exception ex) {
                Logger.getLogger(VIEWCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class SetaAcimaAction extends AbstractAction {

        public SetaAcimaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            teclouSetaAcimaAbaixo();
        }
    }

    private class SetaAbaixoAction extends AbstractAction {

        public SetaAbaixoAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            teclouSetaAcimaAbaixo();
        }
    }

    private void teclouEnter() throws Exception {
        //menu principal
        if (this.getFocusOwner() == listaMenuPrincipal) {
            if (listaMenuPrincipal.getSelectedIndex() == 0) {
                acionaSubMenu();
            }

            // Gaveta            
            if (listaMenuPrincipal.getSelectedIndex() == 1) {
                abrirGaveta();
            }

            // Saída temporaria
            if (listaMenuPrincipal.getSelectedIndex() == 2) {
                saidaTemporaria();
            }
        }

        //menu principal - submenu supervisor
        if (this.getFocusOwner() == listaSubMenuSupervisor) {

            // Iniciar movimento
            if (listaSubMenuSupervisor.getSelectedIndex() == 0) {
                iniciarMovimento();
            }

            // Encerra movimento
            if (listaSubMenuSupervisor.getSelectedIndex() == 1) {
                encerrarMovimento();
            }

            // Posicao de Caixa
            if (listaSubMenuSupervisor.getSelectedIndex() == 2) {
                emitirPosicaoCaixa();
            }

            // Suprimento
            if (listaSubMenuSupervisor.getSelectedIndex() == 4) {
                efetuarSuprimento();
            }

            // Sangria
            if (listaSubMenuSupervisor.getSelectedIndex() == 5) {
                efetuarSangria();
            }

            // Recarga
            if (listaSubMenuSupervisor.getSelectedIndex() == 6) {
                // Recarga ? 
            }

            // Redução Z
            if (listaSubMenuSupervisor.getSelectedIndex() == 7) {
                emitirReducaoZ();
            }

            // Administrador Tef
            if (listaSubMenuSupervisor.getSelectedIndex() == 9) {
                abrirAdministradorTef();
            }
        }

        // Menu Principal - Submenu gerente
        if (this.getFocusOwner() == listaSubMenuGerente) {

            // Iniciar movimento
            if (listaSubMenuGerente.getSelectedIndex() == 0) {
                iniciarMovimento();
            }

            // Encerrar movimento
            if (listaSubMenuGerente.getSelectedIndex() == 1) {
                encerrarMovimento();
            }

            // Suprimento
            if (listaSubMenuGerente.getSelectedIndex() == 3) {
                efetuarSuprimento();
            }

            // Sangria
            if (listaSubMenuGerente.getSelectedIndex() == 4) {
                efetuarSangria();
            }

            // Reducao Z
            if (listaSubMenuGerente.getSelectedIndex() == 6) {
                emitirReducaoZ();
            }

            // Consultar cliente
            if (listaSubMenuGerente.getSelectedIndex() == 8) {
                identificarCliente(false);
            }

            // Configurações
            if (listaSubMenuGerente.getSelectedIndex() == 10) {
                /* O que fazer ?*/
            }

            // Administração Tef
            if (listaSubMenuGerente.getSelectedIndex() == 15) {
                abrirAdministradorTef();
            }
        }

        // Menu operacoes
        if (this.getFocusOwner() == listaMenuOperacoes) {
        }

        // Menu fiscal
        if (this.getFocusOwner() == listaMenuFiscal) {

            //Leitura X
            if (listaMenuFiscal.getSelectedIndex() == 0) {
                emitirLeituraX();
            }

            // LMFC
            if (listaMenuFiscal.getSelectedIndex() == 1) {
                emitirLeituraMFC();
            }

            // LMFS
            if (listaMenuFiscal.getSelectedIndex() == 2) {
                emitirLeituraMFS();
            }

            // Espelho MFD
            if (listaMenuFiscal.getSelectedIndex() == 3) {
                gerarEspelhoMFD();
            }

            // Arquivo MFD
            if (listaMenuFiscal.getSelectedIndex() == 4) {
                gerarArquivoMFD();
            }

            // Tabela de Produtos
            if (listaMenuFiscal.getSelectedIndex() == 5) {
            }

            // Estoque
            if (listaMenuFiscal.getSelectedIndex() == 6) {
                /// iCaixa.gerarArquivoEstoque();
            }

            // Movimento ECF
            if (listaMenuFiscal.getSelectedIndex() == 7) {
                // iCaixa.gerarMovimentoECF();
            }

            // Meios de Pagamento
            if (listaMenuFiscal.getSelectedIndex() == 8) {
                //  iCaixa.gerarMeiosPagamento();
            }

            // DAV Emitidos
            if (listaMenuFiscal.getSelectedIndex() == 9) {
                gerarDAVEmitidos();
            }

            // Identificação PAF-ECF
            if (listaMenuFiscal.getSelectedIndex() == 10) {
                // iCaixa.gerarIdentificacaoPafECF();
            }

            // Vendas no período
            if (listaMenuFiscal.getSelectedIndex() == 11) {
                //  iCaixa.gerarVendasPeriodo();
            }

            //Tabela de indice tecnico de produção            
            if (listaMenuFiscal.getSelectedIndex() == 12) {
                // iCaixa.gerarIndiceTecnicoProducao();
            }

            // Parâmetros de configuração
            if (listaMenuFiscal.getSelectedIndex() == 13) {
                // iCaixa.gerarParametrosConfiguracao();
            }
        }
    }

    private void teclouESC() {
        if (this.getFocusOwner() == listaMenuPrincipal) {
            panelMenuPrincipalSuspenso.setVisible(false);
            panelSubMenu.setVisible(false);
        }
        if (this.getFocusOwner() == listaMenuOperacoes) {
            panelMenuOperacoes.setVisible(false);
        }
        if (this.getFocusOwner() == listaMenuFiscal) {
            panelMenuFiscalSuspenso.setVisible(false);
        }
        if (this.getFocusOwner() == listaSubMenuGerente
                || this.getFocusOwner() == listaSubMenuSupervisor) {
            listaMenuPrincipal.requestFocus();
            listaMenuPrincipal.setSelectedIndex(0);
            panelSubMenu.setVisible(false);
        }

    }

    private void teclouSetaAcimaAbaixo() {
        String selecionado = "";

        if (this.getFocusOwner() == listaMenuPrincipal) {
            selecionado = (String) modelMenuPrincipal.get(listaMenuPrincipal.getSelectedIndex());
        }

        if (this.getFocusOwner() == listaMenuOperacoes) {
            selecionado = (String) modelMenuOperacoes.get(listaMenuOperacoes.getSelectedIndex());
        }

        if (this.getFocusOwner() == listaMenuFiscal) {
            selecionado = (String) modelMenuFiscal.get(listaMenuFiscal.getSelectedIndex());
        }

        if (this.getFocusOwner() == listaSubMenuGerente) {
            selecionado = (String) modelSubMenuGerente.get(listaSubMenuGerente.getSelectedIndex());
        }

        if (this.getFocusOwner() == listaSubMenuSupervisor) {
            selecionado = (String) modelSubMenuSupervisor.get(listaSubMenuSupervisor.getSelectedIndex());
        }

        setLabelMensagem(selecionado);
        this.repaint();
    }

//****************************************************************************//
//                              VENDA                                        //
//****************************************************************************//
    private void verificaEditCodigo() throws HeadlessException {
        
        if(mpParametro.get("BeanMovimento") == null){
            if(showCaixaFechadoMsg){
                JOptionPane.showMessageDialog(this, "Caixa Fechado", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
            }
            return;
        }
        
        // Verifica se não está vazio e se contém apenas números
        if (!editCodigo.getText().trim().equals("")) {
            String[] a = {editCodigo.getText()};
            String codProd = a[0];
            String quantidade = "1";
            if (editCodigo.getText().contains("*")) {
                a = editCodigo.getText().replace("*", "X").split("X");
                quantidade = a[0];
                codProd = a[1];
            }
            if (UTILBiblioteca.regexInteger(a[0])) {
                if (a.length > 1) {
                    if (!UTILBiblioteca.regexInteger(a[1])) {
                        JOptionPane.showMessageDialog(this, "Número inválido", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                        editCodigo.requestFocus();
                    }
                }
                consultarItem(codProd, quantidade);
            } else {
                JOptionPane.showMessageDialog(this, "Número inválido", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                editCodigo.requestFocus();
            }
        }
    }

    public boolean bobinaVazia() {
        if (modelBobina.isEmpty()) {
            return true;
        }
        return false;
    }

    private void imprimirCabecalhoBobina() {
        for (String s : getCabecalhoBobina()) {
            modelBobina.addElement(s);
        }
    }

    private void consultarItem(String codProduto, String quantidade) {
        BeanProduto beanProduto = new DAOProduto().pesquisarProduto(codProduto);
        if (beanProduto == null) {
            beanProduto = new DAOProduto().pesquisarProdutoCodBarra(codProduto);
            if (beanProduto == null) {
                JOptionPane.showMessageDialog(this, "Produto não encontrado", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                limparCodigoProduto();
                //editCodigo.setText("");
                //editCodigo.requestFocus();
                return;
            }
        }

        /* Registrar na bobina, guardar em lista e executar insert */
        venderItemTela(beanProduto, quantidade);
        addProdutoLista(beanProduto, quantidade);

        /* OPVendeItem */
        Operacao vendeItem = OperacaoFactory.getInstance().criarOPVendaItem();
        mpParametro.put("BeanItemVenda", lsItemVenda.get(lsItemVenda.size() - 1));
        mpParametro = vendeItem.executar(mpParametro);

        editCodigo.requestFocus();
    }

    public void setMapParametros(Map mp) {
        this.mpParametro = mp;
        mpParametro.put("CupomAberto", cupomAberto);
    }

    private void setLabelVendedor(BeanVendedor beanVendedor) {
        labelVendedor.setText("");
        if (beanVendedor != null) {
            labelVendedor.setText(beanVendedor.toString());
        }
    }

    public void setLabelOperador(BeanOperador operador) {
        this.beanOperador = operador;
        labelOperador.setText(operador.toString());
    }

    public void setLabelMensagem(String mensagem) {
        labelMensagens.setText(mensagem.toUpperCase());
    }

    public void setLabelDescricaoProduto(String descricao) {
        labelDescricaoProduto.setText(descricao);
    }

    public void setLabelTotalGeral(String totalGeral) {
        labelTotalGeral.setText(totalGeral);
    }

    public void setLabelSubTotal(String subTotal) {
        editSubTotal.setText(subTotal);
    }

    public void setLabelTotalItem(String totalItem) {
        editTotalItem.setText(totalItem);
    }

    public void setLabelValorUnitario(String valorUnitario) {
        editUnitario.setText(valorUnitario);
    }

    public String getQuantidade() {
        String q = "1";
        if (editCodigo.getText().contains("*")) {
            String[] a = editCodigo.getText().replace("*", "X").split("X");
            if (a.length > 1) {
                q = a[0];
            }
        }
        return q;
    }

    private void addElementBobina(List<String> lsItemCupom) {
        for (String s : lsItemCupom) {
            modelBobina.addElement(s);
        }
        bobina.setSelectedIndex(modelBobina.getSize() - 1);
        bobina.ensureIndexIsVisible(modelBobina.getSize() - 1);
    }

    private void limparCodigoProduto() {
        editCodigo.setText("");
        editCodigo.requestFocus();
    }
//****************************************************************************//
//                              Métodos Bobina                                //
//****************************************************************************//

    private List<String> getCabecalhoBobina() {
        List<String> lsModelBobina = new ArrayList<String>();
        String cgcCpf = "CONSUMIDOR";
        if (beanCliente != null) {
            cgcCpf = beanCliente.getCpfCnpj();
        }

        lsModelBobina.add(" " + UTILBiblioteca.repete("-", 47));
        lsModelBobina.add("           ** CUPOM FISCAL **           ");

        if (cgcCpf != null && !cgcCpf.equals("")) {
            lsModelBobina.add(" " + ("CNPJ/CPF CONSUMIDOR: " + cgcCpf));
        }

        lsModelBobina.add(" " + UTILBiblioteca.repete("-", 47));
        lsModelBobina.add("ITEM CÓDIGO      DESCRIÇÃO                   ");
        lsModelBobina.add("QTD UN   VL.UNIT.(R$) ST     VL.ITEM(R$)");
        lsModelBobina.add(" " + UTILBiblioteca.repete("-", 47));

        return lsModelBobina;
    }

    private void venderItemTela(BeanProduto produto, String quantidade) {
        /* Vender Item na bobina */
        List<String> lsItemVendidoBobina = new ArrayList<String>();

        /* Inicializa lista de produtos */
        if (lsItemVenda == null) {
            lsItemVenda = new ArrayList<BeanItemVenda>();
        }

        /* Verifica se o cupom já foi aberto, caso não, abre cupom e registra início de venda */
        if (!cupomAberto) {
            imprimirCabecalhoBobina();
            /* OPVenda */
            if (!recuperandoVenda) {
                Operacao venda = OperacaoFactory.getInstance().criarOPVenda();
                mpParametro = venda.executar(mpParametro);
            }
            cupomAberto = true;
            mpParametro.put("CupomAberto", cupomAberto);
            setLabelMensagem("Venda em andamento...");
        }

        int item = getNumeroUltimoItem();
        lsItemVendidoBobina.add(getItemBobina(produto, String.valueOf(item + 1)));
        lsItemVendidoBobina.add(getItemValorBobina(produto, quantidade));

        setLabelDescricaoProduto(produto.getDescricao());
        addElementBobina(lsItemVendidoBobina);
        limparCodigoProduto();
    }

    private String getItemValorBobina(BeanProduto produto, String quantidade) {
        BigDecimal totalItem = produto.getPrecoVenda().multiply(produto.getQuantidadeEmbalagem()).multiply(new BigDecimal(quantidade));
        setLabelValorUnitario(AbstractView.nf.format(produto.getPrecoVenda()));
        setLabelTotalItem(AbstractView.nf.format(totalItem).toString());

        return getItemValorBobina(produto, quantidade, totalItem);
    }

    private void efetuarDesconto(Integer indexItemDesconto) {
        if (indexItemDesconto == null || indexItemDesconto == 0) {
            return;
        }

        BeanItemVenda itemVendaDesconto = procurarItemNaLista(indexItemDesconto);
        if (itemVendaDesconto == null) {
            JOptionPane.showMessageDialog(this, "O índice não corresponde a nenhum item do cupom", "Desconto Item", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VIEWInserirValorDesconto inserirValorDesconto = new VIEWInserirValorDesconto(this, true, itemVendaDesconto.getValorTotal().toPlainString().length());
        inserirValorDesconto.setVisible(true);
        if (!inserirValorDesconto.cancelado) {
            BigDecimal valorDesconto = inserirValorDesconto.getValorDesconto();
            String tipoDesconto = inserirValorDesconto.getTipoDesconto();

            BigDecimal valorEquivalente = valorDesconto;
            if (tipoDesconto.equalsIgnoreCase("P")) {
                valorEquivalente = (itemVendaDesconto.getValorTotal().multiply(valorDesconto).setScale(2, BigDecimal.ROUND_HALF_UP)).divide(new BigDecimal(100d)).setScale(2, BigDecimal.ROUND_HALF_UP);
            }

            if (valorEquivalente.compareTo(itemVendaDesconto.getValorTotal()) >= 0) {
                JOptionPane.showMessageDialog(this, "Desconto inválido", "Desconto Item", JOptionPane.WARNING_MESSAGE);
                efetuarDesconto(indexItemDesconto);
                return;
            }

            mpParametro.put("BeanItemDesconto", itemVendaDesconto);
            mpParametro.put("tipoDesconto", tipoDesconto);
            mpParametro.put("valorDesconto", valorEquivalente);
            mpParametro.put("valorDescontoPercOuReal", valorDesconto);

            /* Efetuar Operacao DescontoItem */
            Operacao efetuarDesconto = OperacaoFactory.getInstance().criarOPDescontoItem();
            mpParametro = efetuarDesconto.executar(mpParametro);

            efetuarDescontoBobina(itemVendaDesconto, tipoDesconto, valorEquivalente, valorDesconto);

            /* Atualizar Item da Lista 
            for (BeanItemVenda it : lsItemVenda) {
                if (Integer.valueOf(it.getItem()).equals(indexItemDesconto)) {
                    it.setValorDesconto(valorEquivalente);
                    it.setValorTotal(it.getValorTotal().subtract(valorEquivalente));
                    break;
                }
            }*/

            atualizaValoresTotais();
        }
    }

    private void efetuarDescontoBobina(BeanItemVenda itemDesconto, String tipoDesconto, BigDecimal valorReal, BigDecimal valorPerc) {

        List<String> lsDescontoItem = new ArrayList<String>();
        int contEspaco = 18;
        String l1 = "desconto item " + itemDesconto.getItem();
        if (tipoDesconto.equalsIgnoreCase("P")) {
            l1 = l1.concat(" " + valorPerc.toPlainString().replace(".", ",") + "%");
            contEspaco = 10;
        }

        l1 = l1.concat(UTILBiblioteca.repete(" ", contEspaco).concat("-" + AbstractView.nf.format(valorReal).replace("R$", "")));

        lsDescontoItem.add(l1);
        addElementBobina(lsDescontoItem);
    }

    private String getItemBobina(BeanProduto produto, String item) {
        String itemBobina =
                UTILBiblioteca.repete("0", 3 - String.valueOf(item).length()) + item
                + "  "
                + produto.getCodProd() + UTILBiblioteca.repete(" ", 8 - produto.getCodProd().length())
                + " "
                + produto.getDescricao();

        return itemBobina;
    }

    private BeanItemVenda procurarItemNaLista(Integer item) {
        BeanItemVenda itemVenda = null;
        int i = -1;
        for (BeanItemVenda it : lsItemVenda) {
            i++;
            boolean a = (item == Integer.parseInt(it.getItem()));
            if (a) {
                itemVenda = lsItemVenda.get(i);
                break;
            }
        }
        return itemVenda;
    }

    private void cancelarItemBobina(Integer indexItemCancelado) {
        if (indexItemCancelado == null || indexItemCancelado == 0) {
            return;
        }

        BeanItemVenda itemVenda = procurarItemNaLista(indexItemCancelado);
        if (itemVenda == null) {
            JOptionPane.showMessageDialog(this, "O indicie não corresponde a nenhum item do cupom", "Cancelar Item", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String icmsST = itemVenda.getIcmsSt().equals("60") ? "FF" : "I";

        List<String> lsItemCancelado = new ArrayList<String>();
        lsItemCancelado.add(UTILBiblioteca.repete("*", 48));
        lsItemCancelado.add("CANCELAMENTO ITEM: ");
        lsItemCancelado.add(UTILBiblioteca.repete("0", 3 - itemVenda.getItem().toString().length()) + itemVenda.getItem()
                + "  " + itemVenda.getCodProd() + UTILBiblioteca.repete(" ", 14 - itemVenda.getCodProd().length())
                + "  " + itemVenda.getDescricao());

        lsItemCancelado.add(UTILBiblioteca.repete(" ", 5 - itemVenda.getQuantidadeVendida().toString().length()) + itemVenda.getQuantidadeVendida()
                + " "
                + itemVenda.getUndDescricao()
                + " x "
                + UTILBiblioteca.repete(" ", 7 - itemVenda.getValorUnitario().toString().length()) + UTILBiblioteca.formatoDecimal("V", itemVenda.getValorUnitario())
                + "  "
                + UTILBiblioteca.repete(" ", 5 - icmsST.length()) + icmsST
                + UTILBiblioteca.repete(" ", 12 - itemVenda.getValorTotal().toString().length()) + "-" + UTILBiblioteca.formatoDecimal("V", itemVenda.getValorTotal()));

        lsItemCancelado.add(UTILBiblioteca.repete("*", 48));

        addElementBobina(lsItemCancelado);

        /* Adiciona item de cancelamento ao mapa de parametros */
        mpParametro.put("BeanItemCancelar", itemVenda);

        /* Operação de cancelamento de item */
        Operacao cancelaItemVenda = OperacaoFactory.getInstance().criarOPCancelaItemVenda();
        mpParametro = cancelaItemVenda.executar(mpParametro);

        /* Remover item da lista de venda */
        lsItemVenda.remove(itemVenda);
        if(lsItemVendaCancelados == null){
            lsItemVendaCancelados = new ArrayList<BeanItemVenda>();
        }
        lsItemVendaCancelados.add(itemVenda);

        /* Atualiza totais */
        atualizaValoresTotais();
    }

    private String getItemValorBobina(BeanProduto produto, String quantidade, BigDecimal totalItem) {
        String unidadeProduto = produto.getUndDescricao();
        BigDecimal precoUnitario = produto.getPrecoVenda().multiply(produto.getQuantidadeEmbalagem());

        if (unidadeProduto.length() >= 3) {
            unidadeProduto = unidadeProduto.substring(0, 3);
        } else {
            unidadeProduto += UTILBiblioteca.repete(" ", 3 - unidadeProduto.length());
        }

        String icmsST = produto.getIcmsSt().equals("60") ? "FF" : "I";

        String itemValorBobina =
                UTILBiblioteca.repete(" ", 5 - quantidade.length()) + quantidade
                + " "
                + unidadeProduto
                + " x "
                + UTILBiblioteca.repete(" ", 9 - precoUnitario.toString().length()) + UTILBiblioteca.formatoDecimal("V", precoUnitario)
                + "  "
                + UTILBiblioteca.repete(" ", 7 - icmsST.length()) + icmsST
                + UTILBiblioteca.repete(" ", 12 - totalItem.toString().length()) + UTILBiblioteca.formatoDecimal("V", totalItem);

        return itemValorBobina;
    }

    private BigDecimal totalDesconto = BigDecimal.ZERO;
    
    private void atualizaValoresTotais() {
        totalSubTotal = BigDecimal.ZERO;
        totalGeral = BigDecimal.ZERO;
        totalDesconto = BigDecimal.ZERO;
//        BigDecimal totalDesconto = BigDecimal.ZERO;
        for (BeanItemVenda itVenda : lsItemVenda) {
            totalGeral = totalGeral.add(itVenda.getValorTotal());
            totalDesconto = totalDesconto.add(itVenda.getValorDesconto());
        }
        totalSubTotal = totalGeral.add(totalDesconto);
        setLabelSubTotal(AbstractView.nf.format(totalSubTotal));
        setLabelTotalGeral("R$ " + AbstractView.df.format(totalGeral)); // - Desconto
    }

    /* RECUPERAR VENDA */
    private void recuperarVenda() {
        BeanVenda beanVendaRecuperar = (BeanVenda) mpParametro.get("BeanVendaRecuperar");
        if (beanVendaRecuperar != null) {
            recuperandoVenda = true;

            if (beanCliente == null) {
                beanCliente = new BeanCliente();
            }
            beanCliente.setCpfCnpj(beanVendaRecuperar.getCpfCnpjAdquirente());
            beanCliente.setNome(beanVendaRecuperar.getNomeAdquirente());

            boolean cupomRecuperarAberto = (Boolean) mpParametro.get("CupomRecuperarAberto");
            /* Caso Aberto, */
            if (cupomRecuperarAberto) {
                BeanItemVenda itDadosVenda = new BeanItemVenda();
                itDadosVenda.setCoo(beanVendaRecuperar.getCoo());
                itDadosVenda.setCodMov(beanVendaRecuperar.getCodMov());

                // Lista de Itens da Venda 
                List<BeanItemVenda> lsItemVendaRecuperada = DAOFacade.getLsItemVenda(itDadosVenda);
                for (BeanItemVenda it : lsItemVendaRecuperada) {
                    BeanProduto produtoTemp = new BeanProduto();
                    produtoTemp.setCodProd(it.getCodProd());
                    // Pesquisa Produto
                    produtoTemp = DAOFacade.getProduto(produtoTemp);

                    venderItemTela(produtoTemp, it.getQuantidadeVendida().toPlainString());
                    lsItemVenda.add(it);
                }
                mpParametro.put("BeanVenda", beanVendaRecuperar);
                atualizaValoresTotais();
            } else {
                /* Verificar se ultimo cupom pode ser cancelado e refazer a venda */
                cancelarCupom();
            }
        }
    }

//****************************************************************************//
// Aparência e controle dos painéis com as funções do programa - F1 a F12     //
//****************************************************************************//
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == panelIdentCliente) {
            identificarCliente(false);
        }
        if (e.getSource() == panelMenuPrincipal) {
            acionaMenuPrincipal();
        }
        if (e.getSource() == panelCarregaPreVenda) {
            acionaMenuOperacoes();
        }
        if (e.getSource() == panelMenuFiscal) {
            acionaMenuFiscal();
        }
        if (e.getSource() == panelProduto) {
            //TODO : Devemos fazer uma calculadora própria?
            if (listaMenuPrincipal.getSelectedIndex() == 1) {
//                NotaFiscal.main(new String[0]);
            }
        }
        if (e.getSource() == panelDescontoItem) {
            //localizaProduto();
        }
        if (e.getSource() == panelInformaVendedor) {
//                iniciaEncerramentoVenda();
        }
        if (e.getSource() == panelCancItem) {
            //          cancelaItem();
        }
        if (e.getSource() == panelCancCupom) {
            //        cancelaCupom();
        }
        if (e.getSource() == panelTotVenda) {
            //      descontoValor();
        }
        if (e.getSource() == panelDevolucaoMercadoria) {
            //identificaVendedor();
        }
        if (e.getSource() == panelSair) {
            //sair();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == panelIdentCliente) {
            panelIdentCliente.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelMenuPrincipal) {
            panelMenuPrincipal.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelCarregaPreVenda) {
            panelCarregaPreVenda.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelMenuFiscal) {
            panelMenuFiscal.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelProduto) {
            panelProduto.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelDescontoItem) {
            panelDescontoItem.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelInformaVendedor) {
            panelInformaVendedor.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelCancItem) {
            panelCancItem.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelCancCupom) {
            panelCancCupom.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelTotVenda) {
            panelTotVenda.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelDevolucaoMercadoria) {
            panelDevolucaoMercadoria.setBackground(Color.WHITE);
        }
        if (e.getSource() == panelSair) {
            panelSair.setBackground(Color.WHITE);
        }
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == panelIdentCliente) {
            panelIdentCliente.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelMenuPrincipal) {
            panelMenuPrincipal.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelCarregaPreVenda) {
            panelCarregaPreVenda.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelMenuFiscal) {
            panelMenuFiscal.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelProduto) {
            panelProduto.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelDescontoItem) {
            panelDescontoItem.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelInformaVendedor) {
            panelInformaVendedor.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelCancItem) {
            panelCancItem.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelCancCupom) {
            panelCancCupom.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelTotVenda) {
            panelTotVenda.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelDevolucaoMercadoria) {
            panelDevolucaoMercadoria.setBackground(new Color(255, 255, 255, 0));
        }
        if (e.getSource() == panelSair) {
            panelSair.setBackground(new Color(255, 255, 255, 0));
        }
        this.repaint();
    }
    // Variables declaration - do not modify                               
    private javax.swing.JList bobina;
    private javax.swing.JLayeredPane containerPrincipal;
    private javax.swing.JFormattedTextField editCodigo;
    private javax.swing.JFormattedTextField editQuantidade;
    private javax.swing.JFormattedTextField editSubTotal;
    private javax.swing.JFormattedTextField editTotalItem;
    private javax.swing.JFormattedTextField editUnitario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelVendedor;
    private javax.swing.JLabel labelDescricaoProduto;
    private javax.swing.JLabel labelIdentCliente;
    private javax.swing.JLabel labelTotVenda;
    private javax.swing.JLabel labelDevolucaoMercadoria;
    private javax.swing.JLabel labelSair;
    private javax.swing.JLabel labelMenuPrincipal;
    private javax.swing.JLabel labelCarregaPreVenda;
    private javax.swing.JLabel labelMenuFiscal;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelDescontoItem;
    private javax.swing.JLabel labelInformaVendedor;
    private javax.swing.JLabel labelCancItem;
    private javax.swing.JLabel labelCancCupom;
    private javax.swing.JLabel labelImagemProduto;
    private javax.swing.JLabel labelImagemTela;
    private static javax.swing.JLabel labelMensagens;
    private javax.swing.JLabel labelOperador;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTotalGeral;
    private javax.swing.JList listaMenuFiscal;
    private javax.swing.JList listaMenuOperacoes;
    private javax.swing.JList listaMenuPrincipal;
    private javax.swing.JList listaSubMenuGerente;
    private javax.swing.JList listaSubMenuSupervisor;
    private javax.swing.JScrollPane panelBobina;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelIdentCliente;
    private javax.swing.JPanel panelTotVenda;
    private javax.swing.JPanel panelDevolucaoMercadoria;
    private javax.swing.JPanel panelSair;
    private javax.swing.JPanel panelMenuPrincipal;
    private javax.swing.JPanel panelMenuPrincipalSuspenso;
    private javax.swing.JPanel panelCarregaPreVenda;
    private javax.swing.JPanel panelMenuFiscal;
    private javax.swing.JPanel panelMenuFiscalSuspenso;
    private javax.swing.JPanel panelProduto;
    private javax.swing.JPanel panelDescontoItem;
    private javax.swing.JPanel panelInformaVendedor;
    private javax.swing.JPanel panelCancItem;
    private javax.swing.JPanel panelCancCupom;
    private javax.swing.JPanel panelMenuOperacoes;
    private javax.swing.JPanel panelSubMenu;
    private javax.swing.JScrollPane panelSubMenuGerente;
    private javax.swing.JScrollPane panelSubMenuSupervisor;
    // End of variables declaration                                      

    //TODO : Existe algum problema na implementação dessa Thread - Banner?
    class Banner implements Runnable {

        @Override
        public void run() {

            Random aleatorio = new Random();
            int numero = 0;
            try {
                while (true) {
                    numero = aleatorio.nextInt(6);
                    //           labelImagemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource(configuracao.getCaminhoImagensMarketing() + numero + ".jpg")));
//                    Thread.sleep(5000);
                }
            } catch (Exception e) {
//                e.printStackTrace();
                // labelImagemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource(configuracao.getCaminhoImagensProdutos() + "padrao.png")));
            }
        }
    }
}
