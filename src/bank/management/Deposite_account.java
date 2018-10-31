
 
package bank.management;

/**
 *
 * @author Asus
 */
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Deposite_account extends javax.swing.JFrame {

    Connection myConn;
    PreparedStatement myStat;
    ResultSet res;
   
    public Deposite_account() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bDeposite = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        tf_acc_num = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tf_deposite = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bsubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("     Account  Transaction  Form");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        bDeposite.setText("Deposite");
        bDeposite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDepositeActionPerformed(evt);
            }
        });
        jPanel1.add(bDeposite);
        bDeposite.setBounds(270, 310, 75, 23);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account_number", "Account_Holder", "Ammount"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 553, 56);
        jPanel1.add(tf_acc_num);
        tf_acc_num.setBounds(280, 50, 117, 30);

        jLabel2.setText("Account Number");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(142, 60, 90, 14);

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(470, 310, 55, 23);

        jButton2.setText("Clear");
        jPanel1.add(jButton2);
        jButton2.setBounds(370, 310, 57, 23);
        jPanel1.add(tf_deposite);
        tf_deposite.setBounds(290, 220, 117, 30);

        jLabel3.setText("Deposite Amount");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(152, 230, 110, 14);

        bsubmit.setText("Submit");
        bsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsubmitActionPerformed(evt);
            }
        });
        jPanel1.add(bsubmit);
        bsubmit.setBounds(420, 50, 65, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Selection_item back=new Selection_item();
     this.setVisible(false);
     back.setVisible(true);       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsubmitActionPerformed
        DefaultTableModel model=(DefaultTableModel)tbl.getModel();
        try{
            myConn=connect.conn();
            String sql="select *from C_account where Acc_num=?";
            myStat=myConn.prepareStatement(sql);
            myStat.setString(1,tf_acc_num.getText());
            res=myStat.executeQuery();
            if(res.next())
            {
                String acc_num=res.getString("Acc_num");
                String name=res.getString("Name");
                Double tk=res.getDouble("Ammount");
                model.addRow(new Object[]{acc_num,name,tk});
            }
            else
            {
               JOptionPane.showMessageDialog(null,"Not Found"); 
            }
            
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
        


    }//GEN-LAST:event_bsubmitActionPerformed

    private void bDepositeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDepositeActionPerformed
       
        try{
            myConn=connect.conn();
            String sql="update C_account set Ammount=? where Acc_num='"+tf_acc_num.getText()+"'";
            myStat=myConn.prepareStatement(sql);
          
            double dep=Double.parseDouble(tf_deposite.getText());
            double after_dep=dep+res.getDouble("Ammount");
            
             myStat.setDouble(1,after_dep);
            // myStat.execute();
             myStat.execute();
        
             JOptionPane.showMessageDialog(null,"Successfully deposited");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"please enter the account number");
        }


    }//GEN-LAST:event_bDepositeActionPerformed

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
            java.util.logging.Logger.getLogger(Deposite_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposite_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposite_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposite_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposite_account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeposite;
    private javax.swing.JButton bsubmit;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField tf_acc_num;
    private javax.swing.JTextField tf_deposite;
    // End of variables declaration//GEN-END:variables
}
