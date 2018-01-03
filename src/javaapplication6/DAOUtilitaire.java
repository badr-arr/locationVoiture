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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DAOUtilitaire {

   
   

    public static void fermetureSilencieuse( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "echec de la fermeture du ResultSet : " + e.getMessage() );
            }
        }
    }

    public static void fermetureSilencieuse( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "echec de la fermeture du Statement : " + e.getMessage() );
            }
        }
    }

    public static void fermetureSilencieuse( Connection connexion ) {
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                System.out.println( "echec de la fermeture de la connexion : " + e.getMessage() );
            }
        }
    }

    public static void fermeturesSilencieuses( Statement statement, Connection connexion ) {
        fermetureSilencieuse( statement );
        fermetureSilencieuse( connexion );
    																						}

    public static void fermeturesSilencieuses( ResultSet resultSet, Statement statement, Connection connexion ) {
        fermetureSilencieuse( resultSet );
        fermetureSilencieuse( statement );
        fermetureSilencieuse( connexion );																		}

   
    public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql,boolean id,Object... objets) throws SQLException {
        PreparedStatement preparedStatement;

    	if(id==true){
       preparedStatement = connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS );}
    	else {
           preparedStatement = connexion.prepareStatement(sql,Statement.NO_GENERATED_KEYS );}

        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        											}
        return preparedStatement;
    }
}
