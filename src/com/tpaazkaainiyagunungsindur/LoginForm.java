/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpaazkaainiyagunungsindur;

/**
 *
 * @author indrasudirman
 */
import java.sql.*;
import com.tpaazkaainiyagunungsindur.connection.ConnectionDataBaseMySQL;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class LoginForm extends javax.swing.JFrame {
    
    ConnectionDataBaseMySQL connectionDataBase;
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    private Border loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    private final String title = "<html><FONT COLOR=GREEN> Login </FONT></HTML>";

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        logInAs();
        connectionDataBase = new ConnectionDataBaseMySQL();
        connectionDataBase.connectionDataBase();
        this.setLocationRelativeTo(null);
        
        TitledBorder titleBorder = BorderFactory.createTitledBorder(loweredEtched, title, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
        jPanelLogin.setBorder(titleBorder);
        Color myColor = new Color(14, 94, 14);
        Border jLabelLogiAzkaAiniyaBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, myColor);
        jLabelLogiAzkaAiniya.setBorder(jLabelLogiAzkaAiniyaBorder); 
        
        
        
    }
    
    
    
    private void login() {
//        try {
//            String name = fUser.getText();  
//            String password = new String (fPassword.getPassword());
//            connectionDataBase.statement = connectionDataBase.connection.createStatement();
//            String sql = "SELECT * FROM users WHERE USERNAME = '"+name+"' AND PASSWORD ='"+password+"'";
//            connectionDataBase.resultSet = connectionDataBase.statement.executeQuery(sql);
//            
//            if(connectionDataBase.resultSet.next()) {
//                if(fPassword.getPassword().equals(connectionDataBase.resultSet.getString("PASSWORD"))) {
//                    new MainMenu().show();
//                    this.dispose();
//                
//                }
//                else {
//                    JOptionPane.showMessageDialog(fQuit, "Password Salah!!");
//                    fPassword.setText("");
//                    fPassword.requestFocus();
//                }
//                
//            }
//            else {
//                JOptionPane.showMessageDialog(null, "Login Gagal !!");
//            }
//            
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//            
//        }
        String a, b, c;
        a = fUser.getText();
        b = new String (fPassword.getPassword());
        c = String.valueOf(jComboBoxLoginLevel.getSelectedItem());
        
        
        
        try {
            
            connectionDataBase.statement = connectionDataBase.connection.createStatement();
            String sql = "SELECT * FROM users WHERE USERNAME = ? AND PASSWORD = ? AND LEVEL = ?";
//            connectionDataBase.resultSet = connectionDataBase.statement.executeQuery(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a);
            preparedStatement.setString(2, b);
            preparedStatement.setString(3, c);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                
                
                JLabel [] jLabelKonfirmasi = {new JLabel("Anda berhasil login sebagai"), new JLabel(resultSet.getString("LEVEL"))};
                Font fontBold = new Font ("Ubuntu", Font.BOLD,16);
                jLabelKonfirmasi[1].setFont(fontBold);
                
                JOptionPane.showMessageDialog(null, jLabelKonfirmasi);
                
                if (jComboBoxLoginLevel.getSelectedIndex() == 0) {
                    new MainMenu(a,c).setVisible(true);
                    this.dispose();
                
                }
            
            }
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Gagal login "+ e);
        
        }
    }
    
    public void logInAs() {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String databaseUrl = "jdbc:mysql://localhost:3306/TPAAzkaAiniya?zeroDateTimeBehavior=convertToNull";
            connection = DriverManager.getConnection (databaseUrl, "root", "");
            Statement stat = connection.createStatement();
            String selectQuery = "select * FROM users";
            ResultSet rs = stat.executeQuery(selectQuery);
            
            while (rs.next())
            {
                String levelLogin = rs.getString("LEVEL");
                jComboBoxLoginLevel.addItem(levelLogin);
            }
            
            
            
        
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        
        }
        
    }
    
//    private void welcome() {
//        
//        try {
//            
//            String sql = "select * from users";
//            pst = connection.prepareStatement(sql)
//        }
//        catch (Exception e) {
//            
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fUser = new javax.swing.JTextField();
        fPassword = new javax.swing.JPasswordField();
        fQuit = new javax.swing.JButton();
        fLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxLoginLevel = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelLogiAzkaAiniya = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TPA Azka Ainiya Login");
        setMinimumSize(new java.awt.Dimension(880, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Roboto Lt", 2, 14)); // NOI18N
        jLabel1.setText("Taman Pendidikan Al Quran (TPA) Azka Ainiya Perumahan Griya Indah Serpong Blok O 5 /14 Gunung Sindur");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        fPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fPasswordActionPerformed(evt);
            }
        });

        fQuit.setText("Quit");
        fQuit.setToolTipText("");
        fQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fQuitActionPerformed(evt);
            }
        });

        fLogin.setText("Login");
        fLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fLoginActionPerformed(evt);
            }
        });

        jLabel4.setText("Masuk sebagai");

        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Create New Account");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tpaazkaainiyagunungsindur/image/LogoTPAAzkaAiniya.png"))); // NOI18N

        jLabelLogiAzkaAiniya.setFont(new java.awt.Font("Ubuntu", 1, 19)); // NOI18N
        jLabelLogiAzkaAiniya.setForeground(new java.awt.Color(14, 94, 14));
        jLabelLogiAzkaAiniya.setText("<html><center>&nbsp; Login Menu TPA Azka Ainiya</center></html>");

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelLoginLayout.createSequentialGroup()
                            .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(50, 50, 50)
                            .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxLoginLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fUser, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(fQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogiAzkaAiniya, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addComponent(jLabelLogiAzkaAiniya, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxLoginLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fQuit)
                            .addComponent(fLogin)))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 750, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fLoginActionPerformed
        login();
    }//GEN-LAST:event_fLoginActionPerformed

    private void fPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fPasswordActionPerformed

    private void fQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fQuitActionPerformed
        dispose();
    }//GEN-LAST:event_fQuitActionPerformed

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        Border labelBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, blue);
        jLabel6.setBorder(labelBorder); 
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setBorder(null); 
    }//GEN-LAST:event_jLabel6MouseExited

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fLogin;
    private javax.swing.JPasswordField fPassword;
    private javax.swing.JButton fQuit;
    private javax.swing.JTextField fUser;
    private javax.swing.JComboBox jComboBoxLoginLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelLogiAzkaAiniya;
    private javax.swing.JPanel jPanelLogin;
    // End of variables declaration//GEN-END:variables

    
}
