/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SAMSUNG
 */
public class Voiture {
    double prix ;
    String matricule,marque,type,disponibilite,SiegeBebe;

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double p) {
        this.prix = p;
    }

    public String getSiegeBebe() {
        return SiegeBebe;
    }

    public void setSiegeBebe(String SiegeBebe) {
        this.SiegeBebe = SiegeBebe;
    }

    
    
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }
    
   public static Voiture mapVoiture(ResultSet resultSet) throws SQLException{
       Voiture v = new Voiture();
       v.setMarque(resultSet.getString("marque"));
       v.setMatricule(resultSet.getString("matricule"));
       v.setType(resultSet.getString("type"));
       v.setDisponibilite(resultSet.getString("disponibilite"));
       v.setSiegeBebe(resultSet.getString("SiegeBebe"));
       v.setPrix(resultSet.getDouble("Prix"));
       return v;
       
   }
    
    
}
