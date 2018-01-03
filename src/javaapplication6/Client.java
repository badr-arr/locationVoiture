/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication6;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Client {
    String Nom,Prenom,nationalite,adresse,CIN,phone;
    Date dateNaissance;

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

   public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateDenaissance) {
        this.dateNaissance = dateDenaissance;
    }
    public static Client mapClient( ResultSet resultSet ) throws SQLException {
        	Client client = new Client();
       
                client.setNom(resultSet.getString("Nom"));
                client.setPrenom(resultSet.getString("Prenom"));
                client.setNationalite(resultSet.getString("Nationalite"));
                client.setAdresse(resultSet.getString("Adresse"));
                client.setCIN(resultSet.getString("Cin"));
                client.setDateNaissance(resultSet.getDate("dateNaissance"));
                client.setPhone(resultSet.getString("NumTelephone"));
                            return client;
        
                                                                                }

    
}
