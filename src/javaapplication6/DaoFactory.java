/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author choaib
 */
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DaoFactory 
{       private String url;
	private String username;
	private String password;
        public DaoFactory() { 
		this.url = "jdbc:mysql://localhost:3306/projet";
		this.username ="root";
		this.password ="ensa";			
		String Driver="com.mysql.jdbc.Driver";
            try {
            Class.forName(Driver);
		}catch ( ClassNotFoundException e ) {
                      System.out.println("driver introuvable");
                                                    }
                            }
	
		public Connection getConnection() throws SQLException { 
			return DriverManager.getConnection(url,username,password);
														}
	

}