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
 * @author choaib
 */
public class Employe {
    private Integer  Id;
    private String UserName,email,password,nom,prenom,phone,compte;
    
    public String getEmail(){
        return email;
    }   
    
    public String getUserName(){
        return UserName;        }
    
    public String getPassword(){
        return password;        }
    
    public  Integer getId(){
        return Id;
    }
    
    public  void setId(Integer Id){
        this.Id=Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }
    
    public void setPassword(String password){
        this.password=password;             }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public void setUserName(String UserName){
        this.UserName=UserName;             }
    
    public static Employe mapEmp( ResultSet resultSet ) throws SQLException {
        	Employe e = new Employe();
                e.setId(resultSet.getInt("id"));
                e.setUserName(resultSet.getString("UserName"));
                e.setEmail(resultSet.getString("Email"));
                e.setPassword(resultSet.getString("Password"));
                e.setCompte(resultSet.getString("compte"));
                e.setNom(resultSet.getString("Nom"));
                e.setPhone(resultSet.getString("NumTelephone"));
                e.setPrenom(resultSet.getString("Prenom"));
             
                            return e;
        
    }

    
}    
                         
  	


