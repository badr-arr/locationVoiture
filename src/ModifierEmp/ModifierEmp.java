/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModifierEmp;

import javaapplication2.applocation;
import javaapplication6.Employe;
import javaapplication6.modification;
import javax.swing.JOptionPane;
import Compte.Compte;
import static javaapplication6.trouver.trouverEmp;



/**
 *
 * @author SAMSUNG
 */
public class ModifierEmp extends javax.swing.JFrame {
    applocation a ;
    Compte ab ;
    String user;
    String mail;
    String pass;
    /**
     * Creates new form ModifEmp
     */
    public ModifierEmp(applocation aThis ,Compte abThis,String s){
        initComponents();
        Employe e = trouverEmp(s);
        this.a=aThis;
        this.ab=abThis;
        this.user=s;
        this.pass= e.getPassword();
        this.mail= e.getEmail();
    }
    public ModifierEmp() {
        initComponents();
    }
    
    public int Reponse(){
        if (this.pass.equals(AncienMpField.getText())){
            if (NouveauMpField.getText().equals(RetaperMpField.getText()))
                return 2;
            else 
                return 1;
        }
        else return 0;
    }
    
    public void Modifier() {
        Employe e = trouverEmp(this.user);
        e.setPassword(NouveauMpField.getText());
        modification c = new modification(e,this.user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NouveauMpField = new javax.swing.JPasswordField();
        AncienMpField = new javax.swing.JPasswordField();
        RetaperMpField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 576));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(NouveauMpField);
        NouveauMpField.setBounds(290, 300, 320, 30);
        getContentPane().add(AncienMpField);
        AncienMpField.setBounds(290, 220, 320, 30);
        getContentPane().add(RetaperMpField);
        RetaperMpField.setBounds(290, 380, 320, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ModifierEmp/reduire.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(840, -10, 34, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ModifierEmp/fermer.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(870, 0, 30, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ModifierEmp/barre.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ModifierEmp/submit-button.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(400, 450, 110, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ModifierEmp/ModifierEmp.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       this.dispose(); 
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(ModifierEmp.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if (Reponse() == 0 )
            JOptionPane.showMessageDialog(null,"Ancien mot de passe incorrect. Réessayer !");
        else if (Reponse() == 1)
            JOptionPane.showMessageDialog(null,"Les deux champs de mot de passe sont différents. Réessayer !");
        else {
            Modifier();
            this.dispose();
            a.Update_Table_Employe();
        }
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(ModifierEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField AncienMpField;
    private javax.swing.JPasswordField NouveauMpField;
    private javax.swing.JPasswordField RetaperMpField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}