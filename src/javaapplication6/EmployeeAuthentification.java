/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


 import java.sql.SQLException;
import static javaapplication6.trouver.afficherEmploye;

/**
 *
 * @author choaib
 */
public class EmployeeAuthentification {
    
      public static boolean  verification(String UserName,String MotDepasse) {
          Map<Integer,Employe> employes = new HashMap<Integer,Employe>();
          ResultSet resultSet=afficherEmploye();
         try {  
             while (resultSet.next()) {
                        if( resultSet.getString("UserName").equals(UserName))
                            if ( resultSet.getString("Password").equals(MotDepasse) )
                                { if  (resultSet.getString("compte").equals("active") )
                                    return true;
                                else return false;}
            
              
              }  } catch (SQLException ex) {
									}
          
             
                                                        
                                
          return false;
                                   
                                             }
      
      public static boolean  verificationAdmin(String UserName,String MotDepasse){
        Map<Integer,Employe> employes = new HashMap<Integer,Employe>();
        ResultSet resultSet=afficherEmploye();
        try{  
            while (resultSet.next()) {
                if( resultSet.getString("UserName").equals(UserName))
                    if ( resultSet.getString("Password").equals(MotDepasse) ){ 
                        if  ((resultSet.getString("compte").equals("active")) && (resultSet.getString("UserName").equals("admin")) )
                            return true;
                        else 
                            return false;
                    }
            } 
        } catch (SQLException ex) {}
          return false ;					
      }
      
}
      
     
