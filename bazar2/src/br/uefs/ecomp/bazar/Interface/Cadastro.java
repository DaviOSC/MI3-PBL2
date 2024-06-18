package br.uefs.ecomp.bazar.Interface;
import br.uefs.ecomp.bazar.model.exception.UsuarioNaoCadastrouException;
import java.awt.Component;
import javax.swing.*;

public class Cadastro extends JDialog {
    
    private MainJframe mainframe;
    
    public Cadastro(MainJframe mainframe)
    {
        this.mainframe = mainframe;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        loginField = new javax.swing.JTextField();
        senhaField = new javax.swing.JPasswordField();
        lblLogn = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        enderecoField = new javax.swing.JTextField();
        telefoneField = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblLogn.setText("Login:");

        lblSenha.setText("Senha:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLogin.setText("Fazer Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblNome.setText("Nome:");

        lblCPF.setText("CPF:");

        lblEndereco.setText("Endereço:");

        lblTelefone.setText("Telefone:");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(senhaField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(nomeField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enderecoField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 221, Short.MAX_VALUE))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblLogn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLogin))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //metodo chamado ao pressionar o botão de cadastrar
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
       try
        {
            mainframe.getFacade().cadastrarUsuario(loginField.getText(), nomeField.getText(), senhaField.getText(), cpfField.getText(), enderecoField.getText(), telefoneField.getText()); 
            limparCampos();
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        }
        catch (UsuarioNaoCadastrouException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed
    //metodo chamado ao pressionar o botão de logar
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        dispose();    
        new Login(mainframe).setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed
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
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField cpfField;
    private javax.swing.JTextField enderecoField;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblLogn;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField loginField;
    private javax.swing.JTextField nomeField;
    private javax.swing.JPasswordField senhaField;
    private javax.swing.JTextField telefoneField;
    // End of variables declaration//GEN-END:variables
}
