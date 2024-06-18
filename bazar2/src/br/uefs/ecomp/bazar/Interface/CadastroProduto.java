package br.uefs.ecomp.bazar.Interface;

import br.uefs.ecomp.bazar.model.exception.*;
import java.awt.Component;
import javax.swing.*;

public class CadastroProduto extends JDialog {
    
    private MainJframe mainframe;
    
    public CadastroProduto(MainJframe mainframe)
    {
        this.mainframe = mainframe;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        tipoField = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lblDescResum = new javax.swing.JLabel();
        descResumField = new javax.swing.JTextField();
        lblDescDetalhada = new javax.swing.JLabel();
        descDetalField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblTipo.setText("Tipo:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblDescResum.setText("Descrição resumida:");

        lblDescDetalhada.setText("Descrição detalhada:");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(tipoField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescResum, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDescDetalhada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(descDetalField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(lblTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(descResumField, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 193, Short.MAX_VALUE))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescResum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descResumField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescDetalhada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descDetalField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
       try
        {
            mainframe.getFacade().cadastrarProduto(tipoField.getText(),descResumField.getText(), descDetalField.getText());
            limparCampos();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            
        }
        catch (ProdutoNaoCadastrouException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_btnCadastrarActionPerformed
    //limpa os campos de entrada 
    private void limparCampos()
    {
        Component[] components = jPanel.getComponents();
        for (Component component : components)
        {
            if (component instanceof JTextField)
            {
                ((JTextField) component).setText(null);
            }
            if (component instanceof JPasswordField)
            {
                ((JPasswordField) component).setText(null);
            }
        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JTextField descDetalField;
    private javax.swing.JTextField descResumField;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblDescDetalhada;
    private javax.swing.JLabel lblDescResum;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField tipoField;
    // End of variables declaration//GEN-END:variables
}
