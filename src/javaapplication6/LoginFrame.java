/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package javaapplication6;
import javaapplication2.*;
/**
 *
 * @author choaib
 */
import AppPackage.AnimationClass;
import MpOublie.MpOublie;
import NonAdmin.NonAdmin2;
import NouveauEmp.NouveauEmp;
import static javaapplication6.EmployeeAuthentification.verification;
import static javaapplication6.EmployeeAuthentification.verificationAdmin;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class LoginFrame extends javax.swing.JFrame {

   AnimationClass AC=new AnimationClass(); 
      public LoginFrame() {
        initComponents();
        SlideShow();
    }
    
    
     public final void SlideShow(){
         new Thread(){
             
             int compteur=0; 
             
           @Override
           public void run(){
               
               try{
                   
                   while(true){ //tant que lutilisateur n'a pas fermer la fenetre le slide ne sarrete pas
                       switch(compteur){
                           case 0:
                               ImageIcon image=new ImageIcon(getClass().getResource("./photo.png"));
                               Background1.setIcon(image);
                               
                               Thread.sleep(4000);
                                

                               AC.jLabelXLeft(0,-680,40,8,Background1); //(compteur,position a -width,7 pixel chaque 20ms);
                                Thread.sleep(1);

                               AC.jLabelXLeft(680,0,40,8,Background2); 
                                compteur=1;
                               break;
                               
                               case 1:
                               ImageIcon image1=new ImageIcon(getClass().getResource("./photo1.png"));
                               Background2.setIcon(image1);
                               Thread.sleep(4000);

                               AC.jLabelXRight(-680,0,40,8,Background1); //(compteur,position a -width,7 pixel chaque 20ms);
                               Thread.sleep(1);
                               AC.jLabelXRight(0,680,40,8,Background2); 
                               compteur=2;
                               break;
                             case 2:
                                    
                                 ImageIcon image2=new ImageIcon(getClass().getResource("./photo2.jpg"));
                                 Background1.setIcon(image2);
                                Thread.sleep(4000);
                                AC.jLabelXLeft(0,-680,40,8,Background1); //(compteur,position a -width,7 pixel chaque 20ms);
                               Thread.sleep(1);
                                AC.jLabelXLeft(680,0,40,8,Background2); 
                                compteur=3;
                               break;
                               case 3:
                               ImageIcon image3=new ImageIcon(getClass().getResource("./DSC06316.JPG"));
                                 Background2.setIcon(image3);
                                Thread.sleep(4000);
                                AC.jLabelXRight(-680,0,40,8,Background1); //(compteur,position a -width,7 pixel chaque 20ms);
                               Thread.sleep(1);
                                AC.jLabelXRight(0,680,40,8,Background2); 
                                compteur=0;
                               break;
                       }
                   }
                   
               }catch(Exception e){
                   
               }
                            }
         }.start();
        
    }
    
    
    int xmouse,ymouse;
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NouveauField = new javax.swing.JLabel();
        OublieField = new javax.swing.JLabel();
        deplace = new javax.swing.JLabel();
        LoginField = new javax.swing.JTextField();
        PassField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fermer = new javax.swing.JLabel();
        reduire = new javax.swing.JLabel();
        barre = new javax.swing.JLabel();
        Background1 = new javax.swing.JLabel();
        Background2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(680, 420));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        NouveauField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NouveauField.setForeground(new java.awt.Color(255, 255, 255));
        NouveauField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NouveauField.setText("Créer une nouvelle session");
        NouveauField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NouveauFieldMouseClicked(evt);
            }
        });
        getContentPane().add(NouveauField);
        NouveauField.setBounds(330, 380, 180, 30);

        OublieField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        OublieField.setForeground(new java.awt.Color(255, 255, 255));
        OublieField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OublieField.setText("Mot de passe oublié ?");
        OublieField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OublieFieldMouseClicked(evt);
            }
        });
        getContentPane().add(OublieField);
        OublieField.setBounds(510, 380, 160, 30);

        deplace.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        deplace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deplaceMousePressed(evt);
            }
        });
        deplace.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                deplaceMouseDragged(evt);
            }
        });
        getContentPane().add(deplace);
        deplace.setBounds(10, 0, 630, 12);

        LoginField.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        LoginField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LoginField.setBorder(null);
        LoginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginFieldActionPerformed(evt);
            }
        });
        getContentPane().add(LoginField);
        LoginField.setBounds(125, 94, 162, 22);

        PassField.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        PassField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PassField.setToolTipText("");
        PassField.setBorder(null);
        PassField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassFieldActionPerformed(evt);
            }
        });
        getContentPane().add(PassField);
        PassField.setBounds(123, 145, 167, 28);

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/Untitled-1.png"))); // NOI18N
        loginButton.setToolTipText("");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginButtonMousePressed(evt);
            }
        });
        loginButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                loginButtonMouseMoved(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(130, 190, 140, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/lpfield.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 20, 330, 240);

        fermer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/fermer.png"))); // NOI18N
        fermer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fermerMouseClicked(evt);
            }
        });
        getContentPane().add(fermer);
        fermer.setBounds(655, -2, 30, 30);

        reduire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/reduire.png"))); // NOI18N
        reduire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reduireMouseClicked(evt);
            }
        });
        getContentPane().add(reduire);
        reduire.setBounds(630, -5, 30, 30);

        barre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/barre.png"))); // NOI18N
        getContentPane().add(barre);
        barre.setBounds(-4, 0, 690, 27);

        Background1.setBackground(new java.awt.Color(0, 0, 0));
        Background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/photo.png"))); // NOI18N
        Background1.setOpaque(true);
        getContentPane().add(Background1);
        Background1.setBounds(0, 0, 680, 420);

        Background2.setBackground(new java.awt.Color(0, 0, 0));
        Background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication6/photo1.png"))); // NOI18N
        Background2.setToolTipText("");
        getContentPane().add(Background2);
        Background2.setBounds(680, 0, 680, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginFieldActionPerformed

    private void fermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fermerMouseClicked
           System.exit(0);                                                   
        // TODO add your handling code here:
    }//GEN-LAST:event_fermerMouseClicked

    private void reduireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reduireMouseClicked
                   this.setState(LoginFrame.ICONIFIED);// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_reduireMouseClicked

    private void deplaceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplaceMouseDragged
        
            int x=evt.getXOnScreen();
            int y=evt.getYOnScreen();
            this.setLocation(x-xmouse, y-ymouse);
    }//GEN-LAST:event_deplaceMouseDragged

    private void deplaceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deplaceMousePressed
        ymouse=evt.getY();
        xmouse=evt.getX();
    }//GEN-LAST:event_deplaceMousePressed

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        if(verificationAdmin(LoginField.getText(),PassField.getText())){
            new applocation(LoginField.getText(),PassField.getText()).setVisible(true);
            this.dispose();
        }
        else if (verification(LoginField.getText(),PassField.getText())){
            new NonAdmin2(LoginField.getText(),PassField.getText()).setVisible(true);
            this.dispose();
        }                                                              
        else                                                        
            JOptionPane.showMessageDialog(null,"erreur de connection ressayez!");
        



    }//GEN-LAST:event_loginButtonMouseClicked

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMousePressed
               

    }//GEN-LAST:event_loginButtonMousePressed

    private void loginButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseMoved
                ImageIcon deux=new ImageIcon(getClass().getResource("./button.png"));
                loginButton.setIcon(deux);      
    }//GEN-LAST:event_loginButtonMouseMoved

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        ImageIcon trois=new ImageIcon(getClass().getResource("./Untitled-1.png"));
        loginButton.setIcon(trois);     
                
                                    }//GEN-LAST:event_loginButtonMouseExited

    private void PassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassFieldActionPerformed

    private void NouveauFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NouveauFieldMouseClicked
                  new NouveauEmp(this).setVisible(true);  
    }//GEN-LAST:event_NouveauFieldMouseClicked

    private void OublieFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OublieFieldMouseClicked
        new MpOublie(this).setVisible(true);
    }//GEN-LAST:event_OublieFieldMouseClicked

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background1;
    private javax.swing.JLabel Background2;
    private javax.swing.JTextField LoginField;
    private javax.swing.JLabel NouveauField;
    private javax.swing.JLabel OublieField;
    private javax.swing.JPasswordField PassField;
    private javax.swing.JLabel barre;
    private javax.swing.JLabel deplace;
    private javax.swing.JLabel fermer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel reduire;
    // End of variables declaration//GEN-END:variables
}
