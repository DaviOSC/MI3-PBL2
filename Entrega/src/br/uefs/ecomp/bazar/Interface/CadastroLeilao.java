package br.uefs.ecomp.bazar.Interface;

import br.uefs.ecomp.bazar.model.Produto;
import br.uefs.ecomp.bazar.model.exception.*;
import java.util.Date;
import java.util.Iterator;
import javax.swing.*;

public class CadastroLeilao extends JDialog {
    
    private MainJframe mainframe;
    
    public CadastroLeilao(MainJframe mainframe)
    {
        this.mainframe = mainframe;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLeilao = new javax.swing.ButtonGroup();
        jPanel = new javax.swing.JPanel();
        lblInicio = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lblProduto = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        lblIncremento = new javax.swing.JLabel();
        lblTermino = new javax.swing.JLabel();
        rbLeilaoManual = new javax.swing.JRadioButton();
        rbLeilaoAutomatico = new javax.swing.JRadioButton();
        rbLeilaoAutoFechado = new javax.swing.JRadioButton();
        cbProdutos = new javax.swing.JComboBox<>();
        inicioSpinner = new javax.swing.JSpinner();
        terminoSpinner = new javax.swing.JSpinner();
        precoSpinner = new javax.swing.JSpinner();
        incrementoSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setPreferredSize(new java.awt.Dimension(526, 504));
        setResizable(false);
        setSize(new java.awt.Dimension(526, 504));

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setPreferredSize(new java.awt.Dimension(597, 345));

        lblInicio.setText("Início:");
        lblInicio.setEnabled(false);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblProduto.setText("Produto:");

        lblPreco.setText("Preço minimo:");

        lblIncremento.setText("Incremento:");

        lblTermino.setText("Término");
        lblTermino.setEnabled(false);

        buttonGroupLeilao.add(rbLeilaoManual);
        rbLeilaoManual.setText("Leilão Manual");
        rbLeilaoManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLeilaoManualActionPerformed(evt);
            }
        });

        buttonGroupLeilao.add(rbLeilaoAutomatico);
        rbLeilaoAutomatico.setText("Leilão automático");
        rbLeilaoAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLeilaoAutomaticoActionPerformed(evt);
            }
        });

        buttonGroupLeilao.add(rbLeilaoAutoFechado);
        rbLeilaoAutoFechado.setText("Leilão Fechado");
        rbLeilaoAutoFechado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLeilaoAutoFechadoActionPerformed(evt);
            }
        });

        inicioSpinner.setModel(new javax.swing.SpinnerDateModel());
        inicioSpinner.setEnabled(false);

        terminoSpinner.setModel(new javax.swing.SpinnerDateModel());
        terminoSpinner.setEnabled(false);

        precoSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        precoSpinner.setInheritsPopupMenu(true);

        incrementoSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(rbLeilaoManual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbLeilaoAutomatico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbLeilaoAutoFechado))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inicioSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbProdutos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIncremento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPreco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTermino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(terminoSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(precoSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incrementoSpinner)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbLeilaoAutoFechado)
                    .addComponent(rbLeilaoAutomatico)
                    .addComponent(rbLeilaoManual))
                .addGap(18, 18, 18)
                .addComponent(lblProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPreco)
                .addGap(10, 10, 10)
                .addComponent(precoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIncremento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incrementoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inicioSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTermino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(terminoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastrar)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    @Override
    //metodo que é chamado quando o JDialog é carregado
    public void addNotify()
    {
        super.addNotify();
        setProdutos();
        rbLeilaoManual.setSelected(true);  
    }
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
       
       if(rbLeilaoManual.isSelected())
       {
          try
            {
                mainframe.getFacade().cadastrarLeilaoManual((Produto)cbProdutos.getSelectedItem(), (double)precoSpinner.getValue(), (double)incrementoSpinner.getValue());
                JOptionPane.showMessageDialog(null, "Leilão Manual Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            catch (LeilaoNaoCadastrouException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
       }
       else if(rbLeilaoAutomatico.isSelected())
       {
          try
            {
                mainframe.getFacade().cadastrarLeilaoAutomatico((Produto)cbProdutos.getSelectedItem(), (double)precoSpinner.getValue(), (double)incrementoSpinner.getValue(),(Date)inicioSpinner.getValue(),(Date)terminoSpinner.getValue());
                JOptionPane.showMessageDialog(null, "Leilão Auutomatico Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            catch (LeilaoNaoCadastrouException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
       }
       else if(rbLeilaoAutoFechado.isSelected())
       {
          try
            {
                mainframe.getFacade().cadastrarLeilaoAutomaticoFechado((Produto)cbProdutos.getSelectedItem(), (double)precoSpinner.getValue(), (double)incrementoSpinner.getValue(),(Date)inicioSpinner.getValue(),(Date)terminoSpinner.getValue());
                JOptionPane.showMessageDialog(null, "Leilão Automatico Fechado Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            catch (LeilaoNaoCadastrouException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
       }
       mainframe.listarLeiloes();
              
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void rbLeilaoManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLeilaoManualActionPerformed
        ativarInputs(false);
    }//GEN-LAST:event_rbLeilaoManualActionPerformed

    private void rbLeilaoAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLeilaoAutomaticoActionPerformed
        ativarInputs(true);
    }//GEN-LAST:event_rbLeilaoAutomaticoActionPerformed

    private void rbLeilaoAutoFechadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLeilaoAutoFechadoActionPerformed
        ativarInputs(true);
    }//GEN-LAST:event_rbLeilaoAutoFechadoActionPerformed
    
    //ativa ou desativa os campos referentes as entradas de data e hora de inicio e fim
    private void ativarInputs(boolean bool)
    {
        lblInicio.setEnabled(bool);
        lblTermino.setEnabled(bool);
        inicioSpinner.setEnabled(bool);
        terminoSpinner.setEnabled(bool);
        
    }
    
    //define os items da lista de produtos para serem selecionados para iniciar o leilão
    public void setProdutos()
    {
        DefaultComboBoxModel<Produto> modelProduto = new DefaultComboBoxModel<>();

        Iterator<Produto> produtosIterator = mainframe.getFacade().listarProdutosCadastrados();
        while (produtosIterator.hasNext()) {
            Produto produto = produtosIterator.next();
            if(!produto.isVendido())
                modelProduto.addElement(produto);
        }

        cbProdutos.setModel(modelProduto);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.ButtonGroup buttonGroupLeilao;
    private javax.swing.JComboBox<Produto> cbProdutos;
    private javax.swing.JSpinner incrementoSpinner;
    private javax.swing.JSpinner inicioSpinner;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblIncremento;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblTermino;
    private javax.swing.JSpinner precoSpinner;
    private javax.swing.JRadioButton rbLeilaoAutoFechado;
    private javax.swing.JRadioButton rbLeilaoAutomatico;
    private javax.swing.JRadioButton rbLeilaoManual;
    private javax.swing.JSpinner terminoSpinner;
    // End of variables declaration//GEN-END:variables
}
