/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.*;
import java.awt.Color;

/**
 *
 * @author RIDDHI HAKANI
 */



public class list extends javax.swing.JFrame  {

    /**
     * Creates new form list
     */
    
    public list() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
    }
    
    static current c1=new current();
    static tableData t1 =new tableData();
    void assign(details obj)
    {     
        jLabel14.setText(obj.name);
        jLabel15.setText(obj.age);
        jLabel17.setText(obj.shift);
        jLabel16.setText(obj.gender);
    }

    void check(String text) 
    {
        try
        {
        String url="jdbc:mysql://localhost:3306/test";
        String uname="root";
        String pass="raj81085";
        String query="select * from meds";
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,uname,pass);
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        //search s1=new search();
        
        search s2=new search();
        while(rs.next())
        {
            
            String medName=rs.getString("medicine");
            if(medName.equals(text))
            {
                
                
                
                t1.name=rs.getString(1);
                c1.name=rs.getString(1);
                t1.sell=rs.getInt(2);
                c1.sell=rs.getInt(2);
                t1.cost=rs.getInt(3);
                c1.cost=rs.getInt(3);
                t1.quantity=rs.getInt(4);
                c1.quantity=rs.getInt(4);
                t1.shelf=rs.getInt(5);
                c1.shelf=rs.getInt(5);
                
                s2.set(t1);
                
                
            }
            
        }
        st.close();
        con.close();
        s2.setVisible(true);
        
        
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
        
    }
  
    void db()
    {
        try
        {
            String url="jdbc:mysql://localhost:3306/test";
            String uname="root";
            String pass="raj81085";
            
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection co = DriverManager.getConnection(url,uname,pass);

            PreparedStatement s = co.prepareStatement("update meds set quantity=? where medicine=?");
            
            s.setInt(1,c1.quantity);
            s.setString(2,c1.name);
            int r = s.executeUpdate();    
            s.close();
            co.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    void update(int a)
    {
        
        c1.quantity=c1.quantity+a;
        
        db();
    }
    void sell(int a)
    {
        if(a>c1.quantity)
        {
            inSufficient i=new inSufficient();
            i.setVisible(true);
        }
        else
        {
            c1.quantity=c1.quantity-a;
            db();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        input = new javax.swing.JTextField();
        Signout = new javax.swing.JButton();
        newmed = new javax.swing.JButton();
        medicine = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 125));
        setMinimumSize(new java.awt.Dimension(1000, 640));
        setPreferredSize(new java.awt.Dimension(1000, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Heading", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HealthCare Medical Store");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, 50));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("WE CARE ABOUT YOU");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jPanel2.setBackground(new java.awt.Color(104, 203, 253, 50));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Name :");
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, 20));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Age :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gender :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Shift :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("jLabel14");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("jLabel15");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("jLabel16");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("jLabel17");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 670, 110));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DAY");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 60, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("+");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 30, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIGHT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 90, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/plus1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(104, 203, 253, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });
        jPanel1.add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 220, 40));

        Signout.setBackground(new java.awt.Color(255, 255, 255));
        Signout.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Signout.setForeground(new java.awt.Color(0, 204, 204));
        Signout.setText("SIGN OUT");
        Signout.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(0, 204, 204)));
        Signout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Signout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignoutMouseExited(evt);
            }
        });
        Signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignoutActionPerformed(evt);
            }
        });
        jPanel1.add(Signout, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 150, 40));

        newmed.setBackground(new java.awt.Color(255, 255, 255));
        newmed.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        newmed.setForeground(new java.awt.Color(0, 204, 204));
        newmed.setText("UPDATE MEDICINES");
        newmed.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(0, 204, 204)));
        newmed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newmed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newmedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newmedMouseExited(evt);
            }
        });
        newmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newmedActionPerformed(evt);
            }
        });
        jPanel1.add(newmed, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 160, 40));

        medicine.setBackground(new java.awt.Color(255, 255, 255));
        medicine.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        medicine.setForeground(new java.awt.Color(0, 204, 204));
        medicine.setText("Search");
        medicine.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(0, 204, 204)));
        medicine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        medicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                medicineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                medicineMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                medicineMouseReleased(evt);
            }
        });
        medicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineActionPerformed(evt);
            }
        });
        jPanel1.add(medicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 670, 260));

        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/sandi.jpg"))); // NOI18N
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void medicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineMouseClicked

    }//GEN-LAST:event_medicineMouseClicked

    private void medicineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineMouseEntered
        // TODO add your handling code here:
        medicine.setBackground(Color.BLACK);
    }//GEN-LAST:event_medicineMouseEntered

    private void medicineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineMouseExited
        // TODO add your handling code here:
        medicine.setBackground(Color.white);
    }//GEN-LAST:event_medicineMouseExited

    private void medicineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineMouseReleased

    }//GEN-LAST:event_medicineMouseReleased

    private void medicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineActionPerformed
        // TODO add your handling code here:
        
        String text=input.getText();
        
        check(text);
        
        
    }//GEN-LAST:event_medicineActionPerformed

    private void newmedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newmedMouseEntered
        // TODO add your handling code here:
        newmed.setBackground(Color.BLACK);
    }//GEN-LAST:event_newmedMouseEntered

    private void newmedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newmedMouseExited
        // TODO add your handling code here:
        newmed.setBackground(Color.white);
    }//GEN-LAST:event_newmedMouseExited

    private void newmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newmedActionPerformed
        // TODO add your handling code here:
       
        newMed n=new newMed();
        n.setVisible(true);
        
    }//GEN-LAST:event_newmedActionPerformed

    private void SignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignoutActionPerformed
        // TODO add your handling code here:
        dispose();
        new medicalstore().setVisible(true);
    }//GEN-LAST:event_SignoutActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    private void SignoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignoutMouseEntered
        // TODO add your handling code here:
        Signout.setBackground(Color.BLACK);
    }//GEN-LAST:event_SignoutMouseEntered

    private void SignoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignoutMouseExited
        // TODO add your handling code here:
        Signout.setBackground(Color.white);
    }//GEN-LAST:event_SignoutMouseExited

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
            java.util.logging.Logger.getLogger(list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
           
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new list().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Signout;
    private javax.swing.JTextField input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton medicine;
    private javax.swing.JLabel name;
    private javax.swing.JButton newmed;
    // End of variables declaration//GEN-END:variables
}
