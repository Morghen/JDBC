/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import database.utilities;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rémy
 */
public class apps extends javax.swing.JFrame {

    /**
     * Creates new form apps
     */
    public utilities util;
    String[] logmdp;
    
    public apps() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            setVisible(false);
            loginForm loginF = new loginForm(this,true);
            loginF.setVisible(true);
            util = new utilities(utilities.SQL, "user", "toor");
            connectionState.setText("Connecté");
        } catch (Exception ex) {
            Logger.getLogger(apps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requeteLabel = new javax.swing.JLabel();
        requeteTextField = new javax.swing.JTextField();
        ScrollPanelTable = new javax.swing.JScrollPane();
        TableRequete = new javax.swing.JTable();
        BouttonDemarrer = new javax.swing.JButton();
        connectionState = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setPreferredSize(new java.awt.Dimension(900, 550));

        requeteLabel.setText("Requete :");

        TableRequete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        ScrollPanelTable.setViewportView(TableRequete);

        BouttonDemarrer.setText("Démarrer");
        BouttonDemarrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BouttonDemarrerMouseReleased(evt);
            }
        });

        connectionState.setText("Non connecter");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(requeteLabel)
                        .addGap(18, 18, 18)
                        .addComponent(requeteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addComponent(BouttonDemarrer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ScrollPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(connectionState))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(connectionState)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requeteLabel)
                    .addComponent(requeteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BouttonDemarrer)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(ScrollPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BouttonDemarrerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BouttonDemarrerMouseReleased
        try {
            // TODO add your handling code here:
            System.out.println("Requete = " + requeteTextField.getText());
            ResultSet rs;
            ResultSetMetaData rsmd;
            int rowCount,colCount, i;
            rs = util.query(requeteTextField.getText());
            DefaultTableModel dtm = new DefaultTableModel();
            
            rowCount = rs.getRow();
            rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();
            while(rs.next())
            {
                Object[]  rowData = new Object[colCount];
                for(i=0; i < colCount; i++)
                {
                    rowData[i] = rs.getObject(i+1);
                    jTextArea1.setText(jTextArea1.getText()+ "\t" + rs.getObject(i+1));
                }
                jTextArea1.setText(jTextArea1.getText()+ "\n");
                dtm.addRow(rowData);
            }
            TableRequete.setModel(dtm);
            //dtm.fireTableDataChanged();
            System.out.println("Fin requete = ");
        } catch (SQLException ex) {
            Logger.getLogger(apps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BouttonDemarrerMouseReleased

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
            java.util.logging.Logger.getLogger(apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(apps.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new apps().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BouttonDemarrer;
    private javax.swing.JScrollPane ScrollPanelTable;
    private javax.swing.JTable TableRequete;
    private javax.swing.JLabel connectionState;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel requeteLabel;
    private javax.swing.JTextField requeteTextField;
    // End of variables declaration//GEN-END:variables
}
