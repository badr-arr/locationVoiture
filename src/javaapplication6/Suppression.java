/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javaapplication6.DAOUtilitaire.fermeturesSilencieuses;
import static javaapplication6.DAOUtilitaire.initialisationRequetePreparee;

/**
 *
 * @author choaib
 */
public class Suppression {
    
    public static void  SupprimerClient(String cin)
    {
    		Connection connexion = null; 
    		PreparedStatement preparedStatement = null; 

    		DaoFactory daoFactory=new DaoFactory();
    		String SQL_Request="delete from Client where cin=?";
    	
    		try{
    			connexion=daoFactory.getConnection();
    			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,cin);
    			int statut = preparedStatement.executeUpdate();
    			}catch(SQLException e){
    			}finally {
    				fermeturesSilencieuses(preparedStatement,connexion );
    					}

    }
//************************************Supprimer Voiture
    
    public static void  SupprimerVoiture(String n)
    {
    		Connection connexion = null; 
    		PreparedStatement preparedStatement = null; 

    		DaoFactory daoFactory=new DaoFactory();
    		String SQL_Request="delete from Voiture where matricule=?";
    	
    		try{
    			connexion=daoFactory.getConnection();
    			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,n);
    			int statut = preparedStatement.executeUpdate();
    			}catch(SQLException e){
    			}finally {
    				fermeturesSilencieuses(preparedStatement,connexion );
    					}

    }

    
    
    public static void  SupprimerResa(int n)
    {
    		Connection connexion = null; 
    		PreparedStatement preparedStatement = null; 

    		DaoFactory daoFactory=new DaoFactory();
    		String SQL_Request="delete from Reservation where numReserv=?";
    	
    		try{
    			connexion=daoFactory.getConnection();
    			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,n);
    			int statut = preparedStatement.executeUpdate();
    			}catch(SQLException e){
    			}finally {
    				fermeturesSilencieuses(preparedStatement,connexion );
    					}

    }
    
       public static void  SupprimerFacture(int n)
    {
    		Connection connexion = null; 
    		PreparedStatement preparedStatement = null; 

    		DaoFactory daoFactory=new DaoFactory();
    		String SQL_Request="delete from Tarif where numFacture=?";
    	
    		try{
    			connexion=daoFactory.getConnection();
    			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,n);
    			int statut = preparedStatement.executeUpdate();
    			}catch(SQLException e){
    			}finally {
    				fermeturesSilencieuses(preparedStatement,connexion );
    					}

    }

    
    
}
