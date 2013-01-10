/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.views.users;

import app.views.AppView;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 * 
 */
public class RememberPasswordView extends AppView {

    /** Creates new form RememberPasswordView */
    public RememberPasswordView() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recuperação de senha");

        title.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        title.setText("Recuperação de senha");

        messageLabel.setText("Informe seus dados corretamente!");

        loginLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        loginLabel.setText("Login");

        nameLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nameLabel.setText("Nome");

        okButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(okButton)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loginLabel)
                                    .addComponent(nameLabel))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(messageLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(login)
                                    .addComponent(name))))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(title)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(messageLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
		data.add("login", login.getText());
		data.add("name", name.getText());
		
		String password = (String) model.callMethod("rememberPassword", data);
		
		if (password == null) {
			messageLabel.setText("Falha! Tente novamente.");
			messageLabel.setForeground(Color.red);
		}
		
		else {
			messageLabel.setText("Senha recuperada!");
			messageLabel.setForeground(new Color(0, 204, 0));
			JOptionPane.showMessageDialog(null, "Sua senha é: " + password);
			dispose();
		}
	}//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField login;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
