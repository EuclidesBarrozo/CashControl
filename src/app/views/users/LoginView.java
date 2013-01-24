/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.views.users;

import app.controllers.AppController;
import app.views.AppView;
import core.dataManipulation.LinkedArray;
import java.awt.Color;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 * 
 */
public class LoginView extends AppView {

    /** Creates new form LoginView */
    public LoginView() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        rememberPasswordLabel = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        entryButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autenticação de usuários");

        title.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        title.setText("Autenticação de usuários");

        message.setForeground(new java.awt.Color(0, 204, 0));
        message.setText("Seja bem-vindo!");

        loginLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        loginLabel.setText("Login:");

        passwordLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        passwordLabel.setText("Senha:");

        rememberPasswordLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        rememberPasswordLabel.setForeground(new java.awt.Color(51, 51, 255));
        rememberPasswordLabel.setText("Esqueci minha senha!");
        rememberPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rememberPasswordLabelMouseClicked(evt);
            }
        });

        entryButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        entryButton.setText("Entrar");
        entryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginLabel)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(message))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rememberPasswordLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(entryButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(7, 7, 7)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rememberPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(entryButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void entryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryButtonActionPerformed
		LinkedArray params = new LinkedArray();
		
		params.add("login", login.getText());
		params.add("password", password.getText());
		
		if (controller.components.use("Auth", "login", params) == Boolean.TRUE) {
			dispose();
			new AppController().callAction("main", params);
		}
		else {
			message.setText("Login falhou! Tente novamente.");
			message.setForeground(Color.red);
			login.setText("");
			password.setText("");
		}
	}//GEN-LAST:event_entryButtonActionPerformed

	private void rememberPasswordLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rememberPasswordLabelMouseClicked
		controller.display("rememberPassword");
	}//GEN-LAST:event_rememberPasswordLabelMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entryButton;
    private javax.swing.JTextField login;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel message;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel rememberPasswordLabel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
