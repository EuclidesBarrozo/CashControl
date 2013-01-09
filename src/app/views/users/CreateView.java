/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.views.users;

import app.controllers.EmailsController;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newEmailButton.setText("Adicionar E-mail");
        newEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEmailButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newEmailButton)
                .addContainerGap(242, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newEmailButton)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void newEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEmailButtonActionPerformed
		controller.callAction("newEmail");
		dispose();
	}//GEN-LAST:event_newEmailButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton newEmailButton;
    // End of variables declaration//GEN-END:variables

}
