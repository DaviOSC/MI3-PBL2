package br.uefs.ecomp.bazar.Interface;

import br.uefs.ecomp.bazar.facade.BazarFacade;
import br.uefs.ecomp.bazar.model.*;
import br.uefs.ecomp.bazar.model.exception.*;

import java.awt.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainJframe extends javax.swing.JFrame {
    
    private BazarFacade facade;
    
    public MainJframe()
    {
        this.facade = new BazarFacade();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        midPanel = new javax.swing.JPanel();
        listPanel = new javax.swing.JPanel();
        panelList1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        produtosList = new javax.swing.JList<>();
        subPanelList = new javax.swing.JPanel();
        panelList2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        participantesList = new javax.swing.JList<>();
        panelList3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        leiloesList = new javax.swing.JList<>();
        panelList4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lancesList = new javax.swing.JList<>();
        midBtnPanel = new javax.swing.JPanel();
        btnParticiparLeilao = new javax.swing.JButton();
        btnIniciarLeilao = new javax.swing.JButton();
        btnEncerrarLeilao = new javax.swing.JButton();
        btnLanceMinimo = new javax.swing.JButton();
        btnDarLance = new javax.swing.JButton();
        lanceSpinner = new javax.swing.JSpinner();
        btnAbrirEnvelopesLeilao = new javax.swing.JButton();
        infPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        infoSubPanel1 = new javax.swing.JPanel();
        info1Plbl1 = new javax.swing.JLabel();
        info2Plbl1 = new javax.swing.JLabel();
        info3Plbl1 = new javax.swing.JLabel();
        info4Plbl1 = new javax.swing.JLabel();
        infoSubPanel2 = new javax.swing.JPanel();
        info1Llbl1 = new javax.swing.JLabel();
        info2Llbl1 = new javax.swing.JLabel();
        info3Llbl1 = new javax.swing.JLabel();
        info7Llbl1 = new javax.swing.JLabel();
        info4Llbl1 = new javax.swing.JLabel();
        info5Llbl1 = new javax.swing.JLabel();
        info6Llbl1 = new javax.swing.JLabel();
        info8Llbl1 = new javax.swing.JLabel();
        dateTimePanel = new javax.swing.JPanel();
        nullLabel1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        nullLabel2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        loadMenuItem = new javax.swing.JMenuItem();
        cadastroMenuItem = new javax.swing.JMenuItem();
        loginMenuItem = new javax.swing.JMenuItem();
        userMenu = new javax.swing.JMenu();
        timeMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cadastrarLeilaoMenuItem = new javax.swing.JMenuItem();
        cadastrarProdutoMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        listarProdutosMenuItem = new javax.swing.JMenuItem();
        listarLeiloesMenuItem = new javax.swing.JMenuItem();
        listarLeiloesIniciadosMenuItem = new javax.swing.JMenuItem();
        buscarLeiloesMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Bazar");
        setMinimumSize(new java.awt.Dimension(830, 414));
        setSize(new java.awt.Dimension(830, 414));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setEnabled(false);
        mainPanel.setLayout(new java.awt.BorderLayout(1, 1));

        midPanel.setLayout(new javax.swing.BoxLayout(midPanel, javax.swing.BoxLayout.Y_AXIS));

        listPanel.setLayout(new javax.swing.OverlayLayout(listPanel));

        panelList1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelList1.setLayout(new java.awt.BorderLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Lista de Produtos");
        panelList1.add(jLabel5, java.awt.BorderLayout.NORTH);

        produtosList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        produtosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        produtosList.setName("ListaProdutos"); // NOI18N
        produtosList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                produtosListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(produtosList);

        panelList1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        listPanel.add(panelList1);

        subPanelList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        subPanelList.setLayout(new java.awt.GridLayout(1, 0));

        panelList2.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Lista de  Participantes");
        panelList2.add(jLabel6, java.awt.BorderLayout.NORTH);

        participantesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(participantesList);

        panelList2.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        subPanelList.add(panelList2);

        panelList3.setLayout(new java.awt.BorderLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista de Leilões");
        panelList3.add(jLabel7, java.awt.BorderLayout.NORTH);

        leiloesList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        leiloesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        leiloesList.setName("ListaLeilões"); // NOI18N
        leiloesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                leiloesListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(leiloesList);

        panelList3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        subPanelList.add(panelList3);

        panelList4.setLayout(new java.awt.BorderLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Lista de Lances");
        panelList4.add(jLabel8, java.awt.BorderLayout.NORTH);

        lancesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lancesList);

        panelList4.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        subPanelList.add(panelList4);

        listPanel.add(subPanelList);

        midPanel.add(listPanel);

        btnParticiparLeilao.setText("Participar de um leilão");
        btnParticiparLeilao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticiparLeilaoActionPerformed(evt);
            }
        });
        midBtnPanel.add(btnParticiparLeilao);

        btnIniciarLeilao.setText("Iniciar Leilão");
        btnIniciarLeilao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarLeilaoActionPerformed(evt);
            }
        });
        midBtnPanel.add(btnIniciarLeilao);

        btnEncerrarLeilao.setText("Encerrar Leilão");
        btnEncerrarLeilao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarLeilaoActionPerformed(evt);
            }
        });
        midBtnPanel.add(btnEncerrarLeilao);

        btnLanceMinimo.setText("Dar Lance Minimo");
        btnLanceMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanceMinimoActionPerformed(evt);
            }
        });
        midBtnPanel.add(btnLanceMinimo);

        btnDarLance.setText("Dar Lance ");
        btnDarLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarLanceActionPerformed(evt);
            }
        });
        midBtnPanel.add(btnDarLance);

        lanceSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        lanceSpinner.setEnabled(false);
        lanceSpinner.setPreferredSize(new java.awt.Dimension(80, 25));
        midBtnPanel.add(lanceSpinner);

        btnAbrirEnvelopesLeilao.setText("Abrir Envelopes");
        btnAbrirEnvelopesLeilao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirEnvelopesLeilaoActionPerformed(evt);
            }
        });
        midBtnPanel.add(btnAbrirEnvelopesLeilao);

        midPanel.add(midBtnPanel);

        mainPanel.add(midPanel, java.awt.BorderLayout.CENTER);

        infPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        infPanel.setLayout(new java.awt.BorderLayout());

        infoPanel.setLayout(new javax.swing.OverlayLayout(infoPanel));

        infoSubPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        infoSubPanel1.setPreferredSize(new java.awt.Dimension(100, 100));
        infoSubPanel1.setLayout(new java.awt.GridLayout(2, 0));

        info1Plbl1.setText("Tipo:");
        info1Plbl1.setVerifyInputWhenFocusTarget(false);
        infoSubPanel1.add(info1Plbl1);

        info2Plbl1.setText("Resumo:");
        infoSubPanel1.add(info2Plbl1);

        info3Plbl1.setText("Detalhes:");
        infoSubPanel1.add(info3Plbl1);

        info4Plbl1.setText("Status:");
        infoSubPanel1.add(info4Plbl1);

        infoPanel.add(infoSubPanel1);

        infoSubPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        infoSubPanel2.setPreferredSize(new java.awt.Dimension(100, 100));
        infoSubPanel2.setLayout(new java.awt.GridLayout(2, 0));

        info1Llbl1.setText("Produto:");
        infoSubPanel2.add(info1Llbl1);

        info2Llbl1.setText("Preço:");
        infoSubPanel2.add(info2Llbl1);

        info3Llbl1.setText("Início:");
        infoSubPanel2.add(info3Llbl1);

        info7Llbl1.setText("Venda:");
        infoSubPanel2.add(info7Llbl1);

        info4Llbl1.setText("Vendedor:");
        infoSubPanel2.add(info4Llbl1);

        info5Llbl1.setText("Incremento:");
        infoSubPanel2.add(info5Llbl1);

        info6Llbl1.setText("Término:");
        infoSubPanel2.add(info6Llbl1);

        info8Llbl1.setText("Vencedor:");
        infoSubPanel2.add(info8Llbl1);

        infoPanel.add(infoSubPanel2);

        infPanel.add(infoPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(infPanel, java.awt.BorderLayout.PAGE_END);

        dateTimePanel.setLayout(new java.awt.GridLayout(2, 0));
        dateTimePanel.add(nullLabel1);

        lblTime.setText("Hora:");
        dateTimePanel.add(lblTime);
        dateTimePanel.add(nullLabel2);

        lblDate.setText("Data:");
        dateTimePanel.add(lblDate);

        mainPanel.add(dateTimePanel, java.awt.BorderLayout.NORTH);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        saveMenuItem.setText("Salvar");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        loadMenuItem.setText("Carregar");
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadMenuItem);

        cadastroMenuItem.setText("Cadastrar");
        cadastroMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(cadastroMenuItem);

        loginMenuItem.setText("Logar");
        loginMenuItem.setToolTipText("");
        loginMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loginMenuItem);

        jMenuBar1.add(fileMenu);

        userMenu.setText("User");

        timeMenuItem.setText("Listar momento atual");
        timeMenuItem.setEnabled(false);
        timeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(timeMenuItem);
        userMenu.add(jSeparator1);

        cadastrarLeilaoMenuItem.setText("Cadastrar Leilão");
        cadastrarLeilaoMenuItem.setEnabled(false);
        cadastrarLeilaoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarLeilaoMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(cadastrarLeilaoMenuItem);

        cadastrarProdutoMenuItem.setText("Cadastrar Produto");
        cadastrarProdutoMenuItem.setEnabled(false);
        cadastrarProdutoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProdutoMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(cadastrarProdutoMenuItem);
        userMenu.add(jSeparator2);

        listarProdutosMenuItem.setText("Listar Produtos");
        listarProdutosMenuItem.setEnabled(false);
        listarProdutosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarProdutosMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(listarProdutosMenuItem);

        listarLeiloesMenuItem.setText("Listar Leilões");
        listarLeiloesMenuItem.setEnabled(false);
        listarLeiloesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarLeiloesMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(listarLeiloesMenuItem);

        listarLeiloesIniciadosMenuItem.setText("Listar Leilões Iniciados");
        listarLeiloesIniciadosMenuItem.setEnabled(false);
        listarLeiloesIniciadosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarLeiloesIniciadosMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(listarLeiloesIniciadosMenuItem);

        buscarLeiloesMenuItem.setText("Buscar Leilões");
        buscarLeiloesMenuItem.setEnabled(false);
        buscarLeiloesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLeiloesMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(buscarLeiloesMenuItem);

        jMenuBar1.add(userMenu);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    @Override
    //desativa parte da interface ao iniciar
    public void addNotify()
    {
        super.addNotify();
        enableUserUI(false);
        produtosList.setVisible(false);
        leiloesList.setVisible(false);
        midBtnPanel.setVisible(false);
    }
    
    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        try
        {
            //opção para selecionar o arquivo para salvar
            JFileChooser chooser = new JFileChooser();
            //filtro para escolher apenas o tipo de arquivo especifico
            FileNameExtensionFilter filter = new FileNameExtensionFilter("binFiles", "bin");
            chooser.setFileFilter(filter);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
            {
                facade.salvarDados(chooser.getSelectedFile().getName());
                JOptionPane.showMessageDialog(null, "Informações salvas.", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        try 
        {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("binFiles", "bin");
            chooser.setFileFilter(filter);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                facade.carregarDados(chooser.getSelectedFile().getName());
                System.out.print(chooser.getSelectedFile().getName());
                JOptionPane.showMessageDialog(null, "Informações carredadas.", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(IOException | ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        enableUserUI(false);                                                   
        panelList1.setVisible(true);
        infoSubPanel1.setVisible(true);
        infoSubPanel2.setVisible(false);
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void cadastroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroMenuItemActionPerformed
        //criação do JDialog de cadastro
        new Cadastro(this).setVisible(true);
    }//GEN-LAST:event_cadastroMenuItemActionPerformed

    private void loginMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuItemActionPerformed
        //criação do JDialog de logn
        new Login(this).setVisible(true);
    }//GEN-LAST:event_loginMenuItemActionPerformed
    //atualiza lista de produtos mostrados na interface
    public void listarProdutos()
    {
        listarProdutosMenuItemActionPerformed(null);
    }
    private void timeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeMenuItemActionPerformed
        Date dataHoraAtual = facade.listarMomentoAtual();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataHoraAtual);

        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1; 
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);
        lblDate.setText("Data:"+ dia+"/"+mes+"/"+ano);
        lblTime.setText("Hora:"+ hora +":"+minuto+":"+segundo);
    }//GEN-LAST:event_timeMenuItemActionPerformed

    private void cadastrarProdutoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarProdutoMenuItemActionPerformed
        new CadastroProduto(this).setVisible(true);
    }//GEN-LAST:event_cadastrarProdutoMenuItemActionPerformed

    private void cadastrarLeilaoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarLeilaoMenuItemActionPerformed
        new CadastroLeilao(this).setVisible(true);
        listarLeiloes();
    }//GEN-LAST:event_cadastrarLeilaoMenuItemActionPerformed
    private void setLeiloesList(JList list)
    {
        //define a cor dos leilões baseado no estado deles
        list.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
                {
                    //pega o componnte da Jlist
                    Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    Leilao leilao = (Leilao) value;

                    if(leilao.getStatus() == Leilao.CADASTRADO)                    
                        component.setForeground(Color.BLUE);                   
                    else if(leilao.getStatus() == Leilao.INICIADO)
                        component.setForeground(Color.GREEN);
                    else
                        component.setForeground(Color.RED);
                    
                    return component;
                }
            });
    }
            //atualiza a lista de produtos e as labels referentes as informações ao selecionar/mudar a opção selecionada na lista de produtos
    private void produtosListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_produtosListValueChanged
        Produto produto = produtosList.getSelectedValue();
        if(produto != null)
        {
            info1Plbl1.setText("Tipo: " + produto.getTipo());
            info1Plbl1.setToolTipText(info1Plbl1.getText());
            info2Plbl1.setText("Resumo: " + produto.getDescricaoResumida());
            info2Plbl1.setToolTipText(info2Plbl1.getText());
            info3Plbl1.setText("Detalhes: " + produto.getDescricaoDetalhada());
            info3Plbl1.setToolTipText(info3Plbl1.getText());

            if(produto.isVendido())
            {
                info4Plbl1.setText("Status: Vendido");  
            }
            else
            {
                info4Plbl1.setText("Status: Não vendido"); 
            }
            info4Plbl1.setToolTipText(info4Plbl1.getText());
        }
    }//GEN-LAST:event_produtosListValueChanged
        //atualiza a lista de leiloes e as labels referentes as informações ao selecionar/mudar a opção selecionada na lista de leiloes
    private void leiloesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_leiloesListValueChanged
        Leilao leilao = leiloesList.getSelectedValue();
        if(leilao != null)
        {
            info1Llbl1.setText("Produto: " + leilao.getProduto().getTipo());
            info1Llbl1.setToolTipText(info1Llbl1.getText());
            info2Llbl1.setText("Preço: " + leilao.getPrecoMinimo());
            info2Llbl1.setToolTipText(info2Llbl1.getText());
            info3Llbl1.setText("Incremento: " + leilao.getIncrementoMinimo());
            info3Llbl1.setToolTipText(info3Llbl1.getText());
            info4Llbl1.setText("Vendedor: " + leilao.getVendedor().getNome());
            info4Llbl1.setToolTipText(info4Llbl1.getText());

            if(leilao instanceof LeilaoManual)
            {
               btnIniciarLeilao.setEnabled(true);
               btnEncerrarLeilao.setEnabled(true);
               if(leilao.getStatus() == Leilao.CADASTRADO)
               {
                    info5Llbl1.setVisible(false);
                    info6Llbl1.setVisible(false);
                    info7Llbl1.setVisible(false);
                    info8Llbl1.setVisible(false);
               }
               else if(leilao.getStatus() == Leilao.INICIADO)
               {
                    info7Llbl1.setVisible(false);
                    info8Llbl1.setVisible(false);
                    info5Llbl1.setVisible(true);
                    info5Llbl1.setText("Inicio: " + leilao.getInicio());
                    info6Llbl1.setVisible(false); 
               }
               else if(leilao.getStatus() == Leilao.ENCERRADO)
               {
                    info5Llbl1.setVisible(true);
                    info6Llbl1.setVisible(true);
                    info5Llbl1.setText("Inicio: " + leilao.getInicio()); 
                    info6Llbl1.setText("Término:" + leilao.getTermino());
                    info7Llbl1.setVisible(true);
                    info8Llbl1.setVisible(true);
                    if(leilao.getVenda() == null)
                    {
                        info7Llbl1.setText("Venda: Não gerada."); 
                        info8Llbl1.setText("Vencedor: Não existe.");
                    }
                    else
                    {
                        info7Llbl1.setText("Venda: Gerada"); 
                        info8Llbl1.setText("Vencedor:" + leilao.getVenda().getComprador().getNome());
                    }
               }
            }
            else
            {
               btnIniciarLeilao.setEnabled(false);
               btnEncerrarLeilao.setEnabled(false);
               info5Llbl1.setVisible(true);
               info6Llbl1.setVisible(true);
               info5Llbl1.setText("Inicio: " + leilao.getInicio()); 
               info6Llbl1.setText("Término:" + leilao.getTermino());
               if(leilao.getStatus() == Leilao.ENCERRADO)
               {
                info7Llbl1.setVisible(true);
                info8Llbl1.setVisible(true);
                if(leilao.getVenda() == null)
                {
                    info7Llbl1.setText("Venda: Não gerada."); 
                    info8Llbl1.setText("Vencedor: Não existe.");
                }
                else
                {
                    info7Llbl1.setText("Venda: Gerada"); 
                    info8Llbl1.setText("Vencedor:" + leilao.getVenda().getComprador().getNome());
                }
               }
            }
            info5Llbl1.setToolTipText(info5Llbl1.getText());
            info6Llbl1.setToolTipText(info6Llbl1.getText());
            info7Llbl1.setToolTipText(info7Llbl1.getText());
            info8Llbl1.setToolTipText(info8Llbl1.getText());
            //atualiza lista de lances e lista de participantes da interface do leilão selecionado
            listarLances();
            listarParticipantes();            
        }
    }//GEN-LAST:event_leiloesListValueChanged

    private void btnIniciarLeilaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarLeilaoActionPerformed
       Leilao leilao = leiloesList.getSelectedValue();
       if(leilao != null)
       {
            if(leilao instanceof LeilaoManual)
            {                   
                if(leilao.getStatus() == Leilao.INICIADO)
                {
                    JOptionPane.showMessageDialog(null, "Leilão já está iniciado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else if(leilao.getStatus() == Leilao.ENCERRADO)
                {
                    JOptionPane.showMessageDialog(null, "Leilão está encerrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    try
                    {
                        facade.iniciarLeilao(leilao);
                        JOptionPane.showMessageDialog(null, "Leilão iniciado.", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(UsuarioDiferenteVendedorException e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Leilão não é Manual", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Leilão não selecionado", "Erro", JOptionPane.ERROR_MESSAGE);  
        }
       //atualiza a lista de leilões 
       listarLeiloes();
    }//GEN-LAST:event_btnIniciarLeilaoActionPerformed

    private void btnParticiparLeilaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticiparLeilaoActionPerformed
        Leilao leilao = leiloesList.getSelectedValue();
        if(leilao != null)
        {   
            try
            {
                facade.participarLeilao(leilao);
                JOptionPane.showMessageDialog(null, "Participando do leilao de " + leilao.getProduto() , "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (UsuarioJaParticipaException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Leilão não selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        listarParticipantes();
        listarLeiloes();
    }//GEN-LAST:event_btnParticiparLeilaoActionPerformed
    public void listarParticipantes()
    {
        Leilao leilao = leiloesList.getSelectedValue();
        if(leilao != null)
        {   
            //modelo de lista, adicionando os elementos a partir do iterator 
            DefaultListModel modelParticioantes = new DefaultListModel<>();
            Iterator<Usuario> participantesIterator =  facade.listarParticipantesLeilao(leilao);

            while(participantesIterator.hasNext())
            {
                modelParticioantes.addElement(participantesIterator.next());
            }

            participantesList.setModel(modelParticioantes); 
        }
    }
    
    public void listarLances()
    {
        Leilao leilao = leiloesList.getSelectedValue();
        if(leilao != null)
        {   
            DefaultListModel modelLance = new DefaultListModel<>();
            if(leilao instanceof LeilaoAutomaticoFechado)
            {
                modelLance.clear();  
            }
            else
            {
              Iterator<Lance> lancesIterator =  facade.listarLances(leilao);
                while(lancesIterator.hasNext())
                {
                    modelLance.addElement(lancesIterator.next());
                }  
            }     
            lancesList.setModel(modelLance);
        }
    }
    
    private void btnLanceMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanceMinimoActionPerformed
        Leilao leilao = leiloesList.getSelectedValue();
        //define leilão selecionado como ativo na facade/controller
        facade.selecionarLeilao(leilao);
        try
        {
            facade.darLanceMinimo();
            JOptionPane.showMessageDialog(null, "Lance registrado." , "Sistema", JOptionPane.INFORMATION_MESSAGE);

        }
        catch(LanceInvalidoException | LeilaoNaoParticipaException | LanceLeilaoFechadoException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        listarLances();
    }//GEN-LAST:event_btnLanceMinimoActionPerformed

    private void btnDarLanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarLanceActionPerformed
        Leilao leilao = leiloesList.getSelectedValue();
        facade.selecionarLeilao(leilao);
        try 
        {
            if(facade.darLance((double)lanceSpinner.getValue()))
                JOptionPane.showMessageDialog(null, "Lance registrado." , "Sistema", JOptionPane.INFORMATION_MESSAGE);
            else
            {
                JOptionPane.showMessageDialog(null, "Lance não pode ser dado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(LanceInvalidoException | LeilaoNaoParticipaException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
       listarLances();
    }//GEN-LAST:event_btnDarLanceActionPerformed

    private void btnAbrirEnvelopesLeilaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirEnvelopesLeilaoActionPerformed
        try
        {
          Leilao leilao = leiloesList.getSelectedValue();
          facade.selecionarLeilao(leilao);
            if(leilao != null)
            {   
                DefaultListModel modelLance = new DefaultListModel<>();
                Iterator<Lance> lancesIterator =  facade.abrirEnvelopesLeilaoAutomaticoFechado();

                if (lancesIterator != null)
                {
                    while (lancesIterator.hasNext())
                    {
                        modelLance.addElement(lancesIterator.next());
                    }
                }

                lancesList.setModel(modelLance);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Leilão não selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
            }  
        }
        catch(LeilaoNaoEncerradoException e)
        {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_btnAbrirEnvelopesLeilaoActionPerformed

    private void buscarLeiloesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLeiloesMenuItemActionPerformed
        new BuscarLeilao(this).setVisible(true);
    }//GEN-LAST:event_buscarLeiloesMenuItemActionPerformed

    private void btnEncerrarLeilaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarLeilaoActionPerformed
        Leilao leilao = leiloesList.getSelectedValue();
        facade.selecionarLeilao(leilao);
        if(leilao != null)
        {   
            if(leilao instanceof LeilaoManual)
            {   
                if(leilao.getStatus() == Leilao.CADASTRADO)
                {
                    JOptionPane.showMessageDialog(null, "Leilão não iniciado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else if(leilao.getStatus() == Leilao.ENCERRADO)
                {
                    JOptionPane.showMessageDialog(null, "Leilão já encerrado" , "Sistema", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Venda venda = facade.encerrarLeilao(); 
                    if(venda != null)
                        JOptionPane.showMessageDialog(null, "Leilão encerrado." , "Sistema", JOptionPane.INFORMATION_MESSAGE);
                    else if(venda == null)
                    {
                        JOptionPane.showMessageDialog(null, "Leilão encerrado, venda não gerada.", "Erro", JOptionPane.ERROR_MESSAGE);                    
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Leilão não é Manual", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Leilão não selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);    
        }
        listarLeiloes();
    }//GEN-LAST:event_btnEncerrarLeilaoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int resposta = JOptionPane.showConfirmDialog(this,"Deseja salvar as informações do programa?","Encerrar",JOptionPane.YES_NO_CANCEL_OPTION);

        if (resposta == JOptionPane.YES_OPTION)
        {
            saveMenuItemActionPerformed(null);
            System.exit(0);
        }
        else if(resposta == JOptionPane.NO_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void listarLeiloesIniciadosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarLeiloesIniciadosMenuItemActionPerformed
        //troca da tela de Produtos para a tela de leilões, listando os iniciados
        panelList1.setVisible(false);
        subPanelList.setVisible(true);
        infoSubPanel2.setVisible(true);
        infoSubPanel1.setVisible(false);
        
        DefaultListModel modelLeiloes = new DefaultListModel<>();
        Iterator<Leilao> leiloesIterator = facade.listarLeiloesIniciados();

        while(leiloesIterator.hasNext())
        {
            modelLeiloes.addElement(leiloesIterator.next());
        }

        leiloesList.setModel(modelLeiloes);
        setLeiloesList(leiloesList);
    }//GEN-LAST:event_listarLeiloesIniciadosMenuItemActionPerformed
    public void listarLeiloes()
    {
        listarLeiloesMenuItemActionPerformed(null);
    }

    private void listarLeiloesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarLeiloesMenuItemActionPerformed
        //troca da tela de Produtos para a tela de leilões
        panelList1.setVisible(false);
        subPanelList.setVisible(true);
        infoSubPanel2.setVisible(true);
        infoSubPanel1.setVisible(false);
        midBtnPanel.setVisible(true);
        
        DefaultListModel modelLeiloes = new DefaultListModel<>();
        Iterator<Leilao> leiloesIterator = facade.listarLeiloes();

        while(leiloesIterator.hasNext())
        {
            modelLeiloes.addElement(leiloesIterator.next());
        }

        leiloesList.setModel(modelLeiloes);
        setLeiloesList(leiloesList);
        
    }//GEN-LAST:event_listarLeiloesMenuItemActionPerformed

    private void listarProdutosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarProdutosMenuItemActionPerformed
        //troca da tela de leiloes para a tela de Produtos
        panelList1.setVisible(true);
        infoSubPanel1.setVisible(true);
        infoSubPanel2.setVisible(false);
        subPanelList.setVisible(false);
        midBtnPanel.setVisible(false);

        DefaultListModel modelProduto = new DefaultListModel<>();
        Iterator<Produto> produtosIterator = facade.listarProdutosCadastrados();
        
        while(produtosIterator.hasNext())
        {
            modelProduto.addElement(produtosIterator.next());
        }

        produtosList.setModel(modelProduto);
        
        //muda a cor dos produtos de acordo com o estado deles
        produtosList.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
                {
                    Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    Produto produto = (Produto) value;

                    if (produto.isVendido())
                    {
                        component.setForeground(Color.green);
                    }
                    else
                    {
                        component.setForeground(Color.RED);
                    }

                    return component;
                }
            });
    }//GEN-LAST:event_listarProdutosMenuItemActionPerformed
    
    public void buscarLeiloes(Date momentoA, Date momentoB)
    {
        DefaultListModel modelLeiloes = new DefaultListModel<>();
        
        Iterator<Leilao> leiloesIterator = facade.buscarLeiloesTempo(momentoA, momentoB);

        while(leiloesIterator.hasNext())
        {
            modelLeiloes.addElement(leiloesIterator.next());
        }

        leiloesList.setModel(modelLeiloes);
        setLeiloesList(leiloesList);
    }
    public void logarUsuario(Usuario usuario)
    {
        userMenu.setText(usuario.getLogin());
        for (Component item : userMenu.getMenuComponents())
        {
            if (item instanceof JMenuItem)
            {
                ((JMenuItem)item).setEnabled(true);
            }
        }

        enableUserUI(true);
    }
    public BazarFacade getFacade()
    {
        return facade;
    }
    
    public void enableUserUI(boolean enable)
    {
        listarLeiloesMenuItem.setEnabled(enable);
        listarProdutosMenuItem.setEnabled(enable);
        listarLeiloesIniciadosMenuItem.setEnabled(enable);
        cadastrarLeilaoMenuItem.setEnabled(enable);
        cadastrarProdutoMenuItem.setEnabled(enable);
        buscarLeiloesMenuItem.setEnabled(enable);
        btnIniciarLeilao.setEnabled(enable);
        btnParticiparLeilao.setEnabled(enable);
        btnLanceMinimo.setEnabled(enable);
        btnDarLance.setEnabled(enable);
        btnAbrirEnvelopesLeilao.setEnabled(enable);
        btnEncerrarLeilao.setEnabled(enable);
        lanceSpinner.setEnabled(enable);
        produtosList.setVisible(enable);
        leiloesList.setVisible(enable);
        participantesList.setVisible(enable);
        lancesList.setVisible(enable);
    }

    public static void main(String args[])
    {
        //Códigos gerado automaticamente pela IDE ApacheNetBeans, 
        //testei usando apenas "new MainJframe().setVisible(true);" no codigo da main e funcionou tudo normal apanentemente, apenas alguns JDialogs
        // ficaram com a formatação errada, por isso prefiri manter o código da IDE mesmo
         
        /* 
         * Bloco de configuração do Look and Feel para "Nimbus"
         * 
         * Este bloco de código tenta configurar a interface gráfica da aplicação 
         * para utilizar o Look and Feel "Nimbus", que oferece uma aparência mais moderna 
         * e esteticamente agradável. Ele percorre todos os Look and Feels instalados no sistema 
         * e verifica se algum deles tem o nome "Nimbus". Se encontrado, define "Nimbus" 
         * como o Look and Feel da aplicação. Caso ocorram exceções durante este processo, 
         * elas são capturadas e registradas usando o logger.
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                new MainJframe().setVisible(true);
                
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirEnvelopesLeilao;
    private javax.swing.JButton btnDarLance;
    private javax.swing.JButton btnEncerrarLeilao;
    private javax.swing.JButton btnIniciarLeilao;
    private javax.swing.JButton btnLanceMinimo;
    private javax.swing.JButton btnParticiparLeilao;
    private javax.swing.JMenuItem buscarLeiloesMenuItem;
    private javax.swing.JMenuItem cadastrarLeilaoMenuItem;
    private javax.swing.JMenuItem cadastrarProdutoMenuItem;
    private javax.swing.JMenuItem cadastroMenuItem;
    private javax.swing.JPanel dateTimePanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel infPanel;
    private javax.swing.JLabel info1Llbl1;
    private javax.swing.JLabel info1Plbl1;
    private javax.swing.JLabel info2Llbl1;
    private javax.swing.JLabel info2Plbl1;
    private javax.swing.JLabel info3Llbl1;
    private javax.swing.JLabel info3Plbl1;
    private javax.swing.JLabel info4Llbl1;
    private javax.swing.JLabel info4Plbl1;
    private javax.swing.JLabel info5Llbl1;
    private javax.swing.JLabel info6Llbl1;
    private javax.swing.JLabel info7Llbl1;
    private javax.swing.JLabel info8Llbl1;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel infoSubPanel1;
    private javax.swing.JPanel infoSubPanel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSpinner lanceSpinner;
    private javax.swing.JList<String> lancesList;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    private javax.swing.JList<Leilao> leiloesList;
    private javax.swing.JPanel listPanel;
    private javax.swing.JMenuItem listarLeiloesIniciadosMenuItem;
    private javax.swing.JMenuItem listarLeiloesMenuItem;
    private javax.swing.JMenuItem listarProdutosMenuItem;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem loginMenuItem;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel midBtnPanel;
    private javax.swing.JPanel midPanel;
    private javax.swing.JLabel nullLabel1;
    private javax.swing.JLabel nullLabel2;
    private javax.swing.JPanel panelList1;
    private javax.swing.JPanel panelList2;
    private javax.swing.JPanel panelList3;
    private javax.swing.JPanel panelList4;
    private javax.swing.JList<String> participantesList;
    private javax.swing.JList<Produto> produtosList;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JPanel subPanelList;
    private javax.swing.JMenuItem timeMenuItem;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables
}
