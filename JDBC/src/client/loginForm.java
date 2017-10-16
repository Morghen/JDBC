/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Map;
import java.util.TreeMap;
import javafx.scene.input.KeyCode;
import javax.swing.JOptionPane;

/**
 *
 * @author Rémy
 */
public class loginForm extends javax.swing.JDialog {

    public Map<String,String> tableLogin = new TreeMap();
    public String log, mdp, ip, port, nomBase;
    
    public loginForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tableLogin.put("user","toor");
        tableLogin.put("cb","oracle");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dbButtonGroup = new javax.swing.ButtonGroup();
        BouttonOK = new javax.swing.JButton();
        BouttonCancel = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        loginLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        bdAirportRadioB = new javax.swing.JRadioButton();
        oracleDBRadioB = new javax.swing.JRadioButton();

        setTitle("Login");

        BouttonOK.setText("OK");
        BouttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BouttonOKActionPerformed(evt);
            }
        });

        BouttonCancel.setText("Annuler");
        BouttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BouttonCancelActionPerformed(evt);
            }
        });

        loginLabel.setText("Login :");

        passwordLabel.setText("Mot de passe :");

        dbButtonGroup.add(bdAirportRadioB);
        bdAirportRadioB.setSelected(true);
        bdAirportRadioB.setText("BD_AIRPORT");

        dbButtonGroup.add(oracleDBRadioB);
        oracleDBRadioB.setText("BD_ORACLE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(BouttonOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BouttonCancel)
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel)
                            .addComponent(loginLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginField)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(bdAirportRadioB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(oracleDBRadioB)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bdAirportRadioB)
                    .addComponent(oracleDBRadioB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BouttonCancel)
                    .addComponent(BouttonOK))
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BouttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BouttonOKActionPerformed
        // Si login + mdp correct alors connect sinon message
        if(tableLogin.containsKey(loginField.getText()))
        {
            if(tableLogin.get(loginField.getText()).equals(passwordField.getText()))
            {
                System.out.println("Login correct, connexion");
                JOptionPane.showMessageDialog(null,"Login correct","Information",JOptionPane.INFORMATION_MESSAGE);
                if(bdAirportRadioB.isSelected())
                    setValues(loginField.getText(),passwordField.getText(),"127.0.0.1", "5500", "bd_airport");
                if(oracleDBRadioB.isSelected())
                    setValues(loginField.getText(),passwordField.getText(),"localhost", "1521", "cb");
                setVisible(false);
            }
            else
            {
                System.out.println("Mauvais mot de passe");
                JOptionPane.showMessageDialog(null,"Mot de passe incorrect","Erreur",JOptionPane.ERROR_MESSAGE);
                passwordField.setText("");
            }
        }
        else
        {
            System.out.println("Login incorrect");
            JOptionPane.showMessageDialog(null,"Login incorrect","Erreur",JOptionPane.ERROR_MESSAGE);
            loginField.setText("");
            passwordField.setText("");
        }
    }//GEN-LAST:event_BouttonOKActionPerformed

    private void BouttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BouttonCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BouttonCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loginForm dialog = new loginForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void setValues(String login,String passw, String pip, String pport, String pnomBase) {
        log = login;
        mdp = passw;
        ip = pip;
        port = pport;
        nomBase = pnomBase;
    }
    
    public String[] getValues() {
        String[] values = new String[5];
        values[0] = log;
        values[1] = mdp;
        values[2] = ip;
        values[3] = port;
        values[4] = nomBase;
        return values;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BouttonCancel;
    private javax.swing.JButton BouttonOK;
    private javax.swing.JRadioButton bdAirportRadioB;
    private javax.swing.ButtonGroup dbButtonGroup;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JRadioButton oracleDBRadioB;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    // End of variables declaration//GEN-END:variables
}
