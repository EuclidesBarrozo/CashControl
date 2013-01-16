/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.views.users;

import app.views.AppView;

/**
 *
 * @author Macário Martins <macariomartinsjunior@gmail.com>
 * 
 */
public class CreateView extends AppView {

    /** Creates new form CreateView */
    public CreateView() {
        initComponents();
    }
	
	private String upperInitials(String str) {
		String[]tmp;
		
		while (str.contains("  "))
			str = str.replace("  ", " ");
		
		tmp = str.split(" ");
		str = "";
		
		for (int i = 0; i < tmp.length; i++)
			str += tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1) + " ";
		
		return str;
	}
	
	private String normalize(String str) {
		str = str.replace("á", "a");	str = str.replace("Á", "A");
		str = str.replace("â", "a");	str = str.replace("Â", "A");
		str = str.replace("ã", "a");	str = str.replace("Ã", "A");
		str = str.replace("à", "a");	str = str.replace("À", "A");
		str = str.replace("ä", "a");	str = str.replace("Ä", "A");
		
		str = str.replace("é", "e");	str = str.replace("É", "E");
		str = str.replace("ê", "e");	str = str.replace("Ê", "E");
		str = str.replace("ẽ", "e");	str = str.replace("Ẽ", "E");
		str = str.replace("è", "e");	str = str.replace("È", "E");
		str = str.replace("ë", "e");	str = str.replace("Ë", "E");

		str = str.replace("í", "i");	str = str.replace("Í", "I");
		str = str.replace("î", "i");	str = str.replace("Î", "I");
		str = str.replace("ĩ", "i");	str = str.replace("Ĩ", "I");
		str = str.replace("ì", "i");	str = str.replace("Ì", "I");
		str = str.replace("ï", "i");	str = str.replace("Ï", "I");

		str = str.replace("ó", "o");	str = str.replace("Ó", "O");
		str = str.replace("ô", "o");	str = str.replace("Ô", "O");
		str = str.replace("õ", "o");	str = str.replace("Õ", "O");
		str = str.replace("ò", "o");	str = str.replace("Ò", "O");
		str = str.replace("ö", "o");	str = str.replace("Ö", "O");
		
		str = str.replace("ú", "u");	str = str.replace("Ú", "U");
		str = str.replace("û", "u");	str = str.replace("Û", "U");
		str = str.replace("ũ", "u");	str = str.replace("Ũ", "U");
		str = str.replace("ù", "u");	str = str.replace("Ù", "U");
		str = str.replace("ü", "u");	str = str.replace("Ü", "U");

		return str;
	}
	
	private boolean nameIsValid(String name) {
		return normalize(name).matches("[a-zA-Z][a-zA-Z ]*");
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        login = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        addEmailButton = new javax.swing.JButton();
        addPhoneButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        passwordConfirmationLabel = new javax.swing.JLabel();
        passwordConfirmation = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        setResizable(false);

        title.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        title.setText("Cadastro de Usuários");

        nameLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nameLabel.setText("Nome");

        loginLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        loginLabel.setText("Login");

        passwordLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        passwordLabel.setText("Senha");

        addEmailButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        addEmailButton.setText("Adicionar E-mail");
        addEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmailButtonActionPerformed(evt);
            }
        });

        addPhoneButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        addPhoneButton.setText("Adicionar Telefone");
        addPhoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhoneButtonActionPerformed(evt);
            }
        });

        okButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        passwordConfirmationLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        passwordConfirmationLabel.setText("Confirm. senha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(addPhoneButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addEmailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(242, 242, 242)
                                        .addComponent(cancelButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(okButton))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(passwordConfirmationLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(passwordConfirmation))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(passwordLabel)
                                                .addComponent(loginLabel)
                                                .addComponent(nameLabel))
                                            .addGap(4, 4, 4)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(title)
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nameLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordConfirmationLabel)
                    .addComponent(passwordConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmailButton)
                    .addComponent(addPhoneButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		dispose();
	}//GEN-LAST:event_cancelButtonActionPerformed

	private void addEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmailButtonActionPerformed
		controller.callAction("newEmail");
	}//GEN-LAST:event_addEmailButtonActionPerformed

	private void addPhoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhoneButtonActionPerformed
		message("Muito bem, Eduardo!\nAqui você coloca a action que vai levar o usuário\n a adicionar um telefone, seja fixo ou celular. ;)");
	}//GEN-LAST:event_addPhoneButtonActionPerformed

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
		boolean condition1 = ! name.getText().equals("") && nameIsValid(name.getText());
		boolean condition2 = ! login.getText().equals("");
		boolean condition3 = ( ! password.getText().equals("")) && password.getText().equals(passwordConfirmation.getText());
		
		if (controller.getData().containsKey("Emails"))
			data.add("Emails", controller.getData().get("Emails"));
		
		if (condition1 && condition2 && condition3) {
			data.add("name", name.getText());
			data.add("login", login.getText());
			data.add("password", password.getText());
			
			updateController();
			dispose();
		}
		else {
			name.setText("");
			login.setText("");
			password.setText("");
			passwordConfirmation.setText("");
			message("Preencha todos os campos corretamente e certifique-se que a senha e a confirmação são idênticas!");
		}
	}//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmailButton;
    private javax.swing.JButton addPhoneButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField login;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField passwordConfirmation;
    private javax.swing.JLabel passwordConfirmationLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
