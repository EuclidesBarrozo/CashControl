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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newEmailButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newEmailButton.setText("Adicionar E-mail");
        newEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEmailButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newEmailButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(okButton)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newEmailButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void newEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEmailButtonActionPerformed
		controller.callAction("newEmail");
	}//GEN-LAST:event_newEmailButtonActionPerformed

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
		System.out.println("Processamento encerrado!");
		data = controller.getData();
		if (data.containsKey("Emails")) {
			System.out.println("Dados chegaram ao fim do processamento! Exibindo dados...");
			data.dump();
			updateController();
			dispose();
		}
		else
			System.out.println("Os dados não chegaram ao fim do processamento!");
	}//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton newEmailButton;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

}
