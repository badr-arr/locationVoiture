/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestResa;

import NonAdmin.NonAdmin2;
import javaapplication2.applocation;
import javaapplication6.Client;
import javaapplication6.Creation;
import javaapplication6.Facture;
import javaapplication6.Reservation;
import javaapplication6.Voiture;
import javaapplication6.modification;
import static javaapplication6.trouver.*;


/**
 *
 * @author SAMSUNG
 * int IdR,numReserv;
    Date DateD,DateF;
    String Statut;
 */
public class AddResa extends javax.swing.JFrame {

    /**
     * Creates new form AddResa
     */
    String type="";
    int n;
    applocation a;
    NonAdmin2 ab;
    
    public AddResa() {
        initComponents();
    }
   
    public AddResa(applocation aThis) {
                initComponents();
                a=aThis; 
                type="creation";     
                Voiture v = trouverVoitureMarque("Renault");
                MatriculeField.setText(v.getMatricule());
                MarqueField.setSelectedItem(v.getMarque());
                TypeField.setText(v.getType());
                DispoField.setText(v.getDisponibilite());
                SiegeField.setSelectedItem(v.getSiegeBebe());           
                StatutField.setText("En attente");
                MontantField.setText(String.valueOf(v.getPrix()));
    }
    public AddResa(NonAdmin2 aThis) {
                initComponents();
                ab=aThis; 
                type="creation";     
    }
     public AddResa(applocation aThis ,Reservation r) {

                initComponents();
                type="modification";
                a=aThis;     
                Client c = trouverCinClient2(r.getCinClient() );
                Voiture v = trouverVoiture(r.getMatriculeVoiture()) ;
                Facture f = trouverFacture(r.getNumFacture()) ;
                
                //Client
                NomField.setText(c.getNom());
                PrenomField.setText(c.getPrenom());
                NationaliteField.setSelectedItem(c.getNationalite());
                CinField.setText(c.getCIN());
                AdresseField.setText(c.getAdresse());
                DateField.setDate(c.getDateNaissance());
                PhoneField.setText(c.getPhone());
                
                //Reservation                
                DateDField.setDate(r.getDateD());
                DateFField.setDate(r.getDateF());
                StatutField.setText(r.getStatut());
                n=r.getNumReserv();
                
                //Voiture
                MatriculeField.setText(v.getMatricule());
                MarqueField.setSelectedItem(v.getMarque());
                TypeField.setText(v.getType());
                DispoField.setText(v.getDisponibilite());
                SiegeField.setSelectedItem(v.getSiegeBebe());
                
                //Montant
                MontantField.setText(String.valueOf(f.getMontant()));
                
           }
           public AddResa(NonAdmin2 aThis ,Reservation r) {

                initComponents();
                type="modification";
                ab=aThis;     
                Client c = trouverCinClient2(r.getCinClient() );
                Voiture v = trouverVoiture(r.getMatriculeVoiture()) ;
                Facture f = trouverFacture(r.getNumFacture()) ;
                //Client
                NomField.setText(c.getNom());
                PrenomField.setText(c.getPrenom());
                NationaliteField.setSelectedItem(c.getNationalite());
                CinField.setText(c.getCIN());
                AdresseField.setText(c.getAdresse());
                DateField.setDate(c.getDateNaissance());
                PhoneField.setText(c.getPhone());
                
                //Reservation                
                DateDField.setDate(r.getDateD());
                DateFField.setDate(r.getDateF());
                StatutField.setText(r.getStatut());
                n=r.getNumReserv();
                
                //Voiture
                MatriculeField.setText(v.getMatricule());
                MarqueField.setSelectedItem(v.getMarque());
                TypeField.setText(v.getType());
                DispoField.setText(v.getDisponibilite());
                SiegeField.setSelectedItem(v.getSiegeBebe());
                
                //Montant
                MontantField.setText(String.valueOf(f.getMontant()));
                
           }
    
     
    
       public void modifierResa() 
       {           
                Reservation r=new Reservation();               
                java.util.Date utilDate = DateDField.getDate();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                r.setDateD(sqlDate);                 
                utilDate = DateFField.getDate();
                sqlDate = new java.sql.Date(utilDate.getTime());
                r.setDateF(sqlDate);
                Voiture v = trouverVoitureMarque(String.valueOf(MarqueField.getSelectedItem()));
                MatriculeField.setText(v.getMatricule());
                TypeField.setText(v.getType());
                DispoField.setText(v.getDisponibilite());
                StatutField.setText("En attente");
                if (v.getDisponibilite().equals("disponible"))
                    r.setStatut("en cours");
                SiegeField.setSelectedItem(v.getSiegeBebe());
                v.setSiegeBebe(String.valueOf(SiegeField.getSelectedItem()));
                modification c=new modification(r,this.n);
                modification voiture= new modification(v,v.getMatricule());
                
                Client client=new Client();		
		client.setNom(NomField.getText());
		client.setPrenom(PrenomField.getText());
		client.setCIN(CinField.getText());
		client.setNationalite((String) NationaliteField.getSelectedItem());
                client.setCIN(CinField.getText());
                client.setPhone(PhoneField.getText());                   
		client.setAdresse(AdresseField.getText());
                utilDate = DateField.getDate();
                sqlDate = new java.sql.Date(utilDate.getTime());
                client.setDateNaissance(sqlDate);               
                client.setPhone(PhoneField.getText());                
                modification a = new modification(client,client.getCIN());
                
                Facture f=new Facture();
		f.setMontant(Double.parseDouble(MontantField.getText()));
                modification f2=new modification(f,f.getNum());
           
                                         }
       
       //Si Client existe deja sur leur table
	public void inscrireResa() 
	{
                java.util.Date utilDate;
                java.sql.Date sqlDate;
                
                Client client= trouverCinClient2(CinField.getText());
                //*******CREATION CLIENT SI CLIENT NEXISTE PAS 
                
                if (client.getNom().equals(null)){
                    client.setCIN(CinField.getText());
                    client.setNom(NomField.getText());
                    client.setPrenom(PrenomField.getText());
                    client.setNationalite((String) NationaliteField.getSelectedItem());
                    client.setAdresse(AdresseField.getText());                
                    utilDate = DateField.getDate();
                    sqlDate = new java.sql.Date(utilDate.getTime());
                    client.setDateNaissance(sqlDate);               
                    client.setPhone(PhoneField.getText()); 
                    Creation cl = new Creation(client) ;
                }
                
                //VOITURE MODIFICATION 
                Voiture v = trouverVoitureMarque(String.valueOf(MarqueField.getSelectedItem()));
                MatriculeField.setText(v.getMatricule());
                TypeField.setText(v.getType());
                DispoField.setText(v.getDisponibilite());
                if (v.getDisponibilite().equals("disponible"))
                    v.setDisponibilite("indisponible");
                SiegeField.setSelectedItem(v.getSiegeBebe());
                v.setSiegeBebe(String.valueOf(SiegeField.getSelectedItem()));
                modification voi = new modification(v,v.getMatricule());
                
                
                Reservation r=new Reservation();               
                utilDate = DateDField.getDate();
                sqlDate = new java.sql.Date(utilDate.getTime());
                r.setDateD(sqlDate);                 
                utilDate = DateFField.getDate();
                sqlDate = new java.sql.Date(utilDate.getTime());
                r.setDateF(sqlDate);
                if (DispoField.getText().equals("disponible"))
                    r.setStatut("en cours");
                r.setCinClient(client.getCIN());
                r.setMatriculeVoiture(v.getMatricule());
                r.setIdEmp(3);
                Creation re = new Creation(r);
                
                Facture f=new Facture();
                MontantField.setText(String.valueOf(v.getPrix()));
                f.setNumr(r.getNumReserv());
		f.setMontant(v.getPrix());
                Creation fa = new Creation(f);
           
	}
        
        //***************SI Client n'existe pas
        public void inscrireResa2() 
	{
                //Inscrire Client 
                Client client=new Client();		
		client.setNom(NomField.getText());
		client.setPrenom(PrenomField.getText());
		client.setCIN(CinField.getText());
		client.setNationalite((String) NationaliteField.getSelectedItem());
                client.setCIN(CinField.getText());
                client.setPhone(PhoneField.getText());                   
		client.setAdresse(AdresseField.getText());
                java.util.Date utilDate = DateField.getDate();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                client.setDateNaissance(sqlDate);               
                client.setPhone(PhoneField.getText());                
                Creation a = new Creation(client);
                
                //Inscrire Reservation
                Reservation r=new Reservation();
		utilDate =DateDField.getDate();
                sqlDate = new java.sql.Date(utilDate.getTime());
                r.setDateD(sqlDate);                 
                utilDate = DateFField.getDate();
                sqlDate = new java.sql.Date(utilDate.getTime());
                r.setDateF(sqlDate);
		r.setStatut((String) StatutField.getText());
                Creation c=new Creation(r);
                
                Facture f=new Facture();
		f.setMontant(Double.parseDouble(MontantField.getText()));
                Creation f2=new Creation(f);
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MontantField = new javaapplication2.Customjtextfield();
        SiegeField = new javax.swing.JComboBox();
        MarqueField = new javax.swing.JComboBox();
        TypeField = new javaapplication2.Customjtextfield();
        DispoField = new javaapplication2.Customjtextfield();
        MatriculeField = new javaapplication2.Customjtextfield();
        StatutField = new javaapplication2.Customjtextfield();
        PhoneField = new javaapplication2.Customjtextfield();
        AdresseField = new javaapplication2.Customjtextfield();
        CinField = new javaapplication2.Customjtextfield();
        PrenomField = new javaapplication2.Customjtextfield();
        NomField = new javaapplication2.Customjtextfield();
        NationaliteField = new javax.swing.JComboBox();
        DateFField = new com.toedter.calendar.JDateChooser();
        DateDField = new com.toedter.calendar.JDateChooser();
        DateField = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 22, 900, 555));
        setMinimumSize(new java.awt.Dimension(900, 555));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MontantField.setForeground(new java.awt.Color(204, 204, 204));
        MontantField.setEnabled(false);
        MontantField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(MontantField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 485, 230, -1));

        SiegeField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        SiegeField.setMaximumRowCount(2);
        SiegeField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sans", "Avec" }));
        getContentPane().add(SiegeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 230, -1));

        MarqueField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        MarqueField.setMaximumRowCount(10);
        MarqueField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Renault", "Dacia", "Peugeot", "Citroen", "Fiat", "Ford", "Hyundai", "Kia", "Suzuki" }));
        MarqueField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MarqueFieldItemStateChanged(evt);
            }
        });
        MarqueField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarqueFieldActionPerformed(evt);
            }
        });
        getContentPane().add(MarqueField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 230, -1));

        TypeField.setForeground(new java.awt.Color(204, 204, 204));
        TypeField.setEnabled(false);
        TypeField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(TypeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 230, -1));

        DispoField.setForeground(new java.awt.Color(204, 204, 204));
        DispoField.setEnabled(false);
        DispoField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(DispoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 230, -1));

        MatriculeField.setForeground(new java.awt.Color(204, 204, 204));
        MatriculeField.setEnabled(false);
        MatriculeField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(MatriculeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 230, -1));

        StatutField.setForeground(new java.awt.Color(204, 204, 204));
        StatutField.setEnabled(false);
        StatutField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(StatutField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 230, -1));

        PhoneField.setForeground(new java.awt.Color(204, 204, 204));
        PhoneField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(PhoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 230, -1));

        AdresseField.setForeground(new java.awt.Color(204, 204, 204));
        AdresseField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(AdresseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 230, -1));

        CinField.setForeground(new java.awt.Color(204, 204, 204));
        CinField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        CinField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CinFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CinFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CinFieldKeyTyped(evt);
            }
        });
        getContentPane().add(CinField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 230, -1));

        PrenomField.setForeground(new java.awt.Color(204, 204, 204));
        PrenomField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(PrenomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 230, -1));

        NomField.setForeground(new java.awt.Color(204, 204, 204));
        NomField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(NomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 230, -1));

        NationaliteField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        NationaliteField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marocain", "Etranger" }));
        NationaliteField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NationaliteFieldActionPerformed(evt);
            }
        });
        getContentPane().add(NationaliteField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 230, -1));

        DateFField.setDateFormatString("dd-MM-yyyy");
        DateFField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(DateFField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 230, 30));

        DateDField.setDateFormatString("dd-MM-yyyy");
        DateDField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(DateDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 230, 30));

        DateField.setDateFormatString("dd-MM-yyyy");
        DateField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(DateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 230, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TestResa/submit-button.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, -1, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TestResa/fermer.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, -1, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TestResa/reduire.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, -10, -1, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TestResa/barre.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-330, 0, 1330, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TestResa/Copie de fondo-gris.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.setState(AddResa.ICONIFIED);        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
              if(type.equals("creation")){
                  String cin = CinField.getText();
                  if (!ClientExist(cin))
                       inscrireResa2();    
                  else
                      inscrireResa();
              }
         else{
            modifierResa();
                       }
   a.Update_Table_Reservation();    

     this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void NationaliteFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NationaliteFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NationaliteFieldActionPerformed

    private void MarqueFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarqueFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarqueFieldActionPerformed

    private void CinFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CinFieldKeyPressed
        
    }//GEN-LAST:event_CinFieldKeyPressed

    private void MarqueFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MarqueFieldItemStateChanged
        Voiture v = trouverVoitureMarque(String.valueOf(MarqueField.getSelectedItem()));        
        MatriculeField.setText(v.getMatricule());
        TypeField.setText(v.getType());
        DispoField.setText(v.getDisponibilite());
        SiegeField.setSelectedItem(v.getSiegeBebe());
        MontantField.setText(String.valueOf(v.getPrix()));
    }//GEN-LAST:event_MarqueFieldItemStateChanged

    private void CinFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CinFieldKeyReleased
        Client client= trouverCinClient2(CinField.getText());
        NomField.setText(client.getNom());
        PrenomField.setText(client.getPrenom());
        NationaliteField.setSelectedItem(client.getNationalite());
        AdresseField.setText(client.getAdresse());
        DateField.setDate(client.getDateNaissance());
        PhoneField.setText(client.getPhone());
    }//GEN-LAST:event_CinFieldKeyReleased

    private void CinFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CinFieldKeyTyped

    }//GEN-LAST:event_CinFieldKeyTyped

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
            java.util.logging.Logger.getLogger(AddResa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddResa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddResa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddResa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddResa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaapplication2.Customjtextfield AdresseField;
    private javaapplication2.Customjtextfield CinField;
    private com.toedter.calendar.JDateChooser DateDField;
    private com.toedter.calendar.JDateChooser DateFField;
    private com.toedter.calendar.JDateChooser DateField;
    private javaapplication2.Customjtextfield DispoField;
    private javax.swing.JComboBox MarqueField;
    private javaapplication2.Customjtextfield MatriculeField;
    private javaapplication2.Customjtextfield MontantField;
    private javax.swing.JComboBox NationaliteField;
    private javaapplication2.Customjtextfield NomField;
    private javaapplication2.Customjtextfield PhoneField;
    private javaapplication2.Customjtextfield PrenomField;
    private javax.swing.JComboBox SiegeField;
    private javaapplication2.Customjtextfield StatutField;
    private javaapplication2.Customjtextfield TypeField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
