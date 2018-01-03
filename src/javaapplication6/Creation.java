/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


import static javaapplication6.DAOUtilitaire.fermeturesSilencieuses;
import static javaapplication6.DAOUtilitaire.initialisationRequetePreparee;
import javax.swing.JOptionPane;

/**
 *
 * @author choaib
 */
public class Creation {
    
    
      
    private static final String SQL_INSERT_Client = "INSERT INTO Client(Nom,Prenom,Nationalite,Cin,Adresse,DateNaissance,NumTelephone) VALUES(?,?,?,?,?,?,?);";
    private static final String SQL_INSERT_Reservation = "INSERT INTO Reservation(numReserv,DateD,DateF,Statut,CinClient,MatriculeVoiture,IdEmp) VALUES(?,?,?,?,?,?,?);";
    private static final String SQL_INSERT_Facture = "INSERT INTO Tarif(numFacture,montant,NumR) VALUES(?,?,?);";
    private static final String SQL_INSERT_Employe = "INSERT INTO Employe(Nom,Prenom,NumTelephone,UserName,Email,Password,compte) VALUES(?,?,?,?,?,?,?);";
    private static final String SQL_INSERT_Voiture = "INSERT INTO Voiture(matricule,marque,type,disponibilite,SiegeBebe,Prix) VALUES(?,?,?,?,?,?);";
    
    public Creation( Reservation r ) throws IllegalArgumentException {
	DaoFactory daoFactory=new DaoFactory();

	Connection connexion = null; 
	PreparedStatement preparedStatement = null;
	
	try {
		/* Récupération d'une connexion depuis la Factory */ 
		connexion = daoFactory.getConnection();
		preparedStatement = initialisationRequetePreparee(connexion,SQL_INSERT_Reservation,true,r.getNumReserv(),r.getDateD(),r.getDateF(),r.getStatut(),r.getStatut(),r.getCinClient(),r.getMatriculeVoiture(),r.getIdEmp());
                int statut = preparedStatement.executeUpdate();
		/* Analyse du statut retourné par la requête d'insertion */ 
		if ( statut == 0 ) {
                    System.out.println("erreur!");
		//throw new DAOException( "Échec de la création du client,aucune ligne n'est ajoutée dans la table." );
		}
		
		}catch(SQLIntegrityConstraintViolationException e){
                                         JOptionPane.showMessageDialog(null,"Attention ce num de reservation existe deja  dans votre base!","num de reservation duplication",JOptionPane.ERROR_MESSAGE);
                                                                                       } catch ( SQLException e ) {
		} finally {
			fermeturesSilencieuses(preparedStatement,connexion);
				  } 
		}

    
    //*****************************Creation Voiture*****************************
    
    public Creation(Voiture r) throws IllegalArgumentException {
	DaoFactory daoFactory=new DaoFactory();

	Connection connexion = null; 
	PreparedStatement preparedStatement = null;
	
	try {
		/* Récupération d'une connexion depuis la Factory */ 
		connexion = daoFactory.getConnection();
		preparedStatement = initialisationRequetePreparee(connexion,SQL_INSERT_Voiture,true,r.getMatricule(),r.getMarque(),r.getType(),r.getDisponibilite(),r.getSiegeBebe(),r.getPrix());
                int statut = preparedStatement.executeUpdate();
		/* Analyse du statut retourné par la requête d'insertion */ 
		if ( statut == 0 ) {
                    System.out.println("erreur!");
		//throw new DAOException( "Échec de la création du client,aucune ligne n'est ajoutée dans la table." );
		}
		
		}catch(SQLIntegrityConstraintViolationException e){
                                         JOptionPane.showMessageDialog(null,"Attention ce num de matricule existe deja  dans votre base!","num de matricule duplication",JOptionPane.ERROR_MESSAGE);
                                                                                       } catch ( SQLException e ) {
		} finally {
			fermeturesSilencieuses(preparedStatement,connexion);
				  } 
		}

//*********************************Creation Employe****************************
        public Creation(Employe e) throws IllegalArgumentException {
	DaoFactory daoFactory=new DaoFactory();

	Connection connexion = null; 
	PreparedStatement preparedStatement = null;
	
	try {
		/* Récupération d'une connexion depuis la Factory */ 
		connexion = daoFactory.getConnection();
		preparedStatement = initialisationRequetePreparee(connexion,SQL_INSERT_Employe,true,e.getNom(),e.getPrenom(),e.getPhone(),e.getUserName(),e.getEmail(),e.getPassword(),e.getCompte());
                int statut = preparedStatement.executeUpdate();
		/* Analyse du statut retourné par la requête d'insertion */ 
		if ( statut == 0 ) {
                    System.out.println("erreur!");
		//throw new DAOException( "Échec de la création du client,aucune ligne n'est ajoutée dans la table." );
		}
		
		}catch(SQLIntegrityConstraintViolationException a){
                                         JOptionPane.showMessageDialog(null,"Attention ce login existe deja  dans votre base!","login duplication",JOptionPane.ERROR_MESSAGE);
                                                                                       } catch ( SQLException a ) {
		} finally {
			fermeturesSilencieuses(preparedStatement,connexion);
				  } 
		 }

        
        
        public Creation( Client client ) throws IllegalArgumentException {
	DaoFactory daoFactory=new DaoFactory();

	Connection connexion = null; 
	PreparedStatement preparedStatement = null;
	
	try {
		/* Récupération d'une connexion depuis la Factory */ 
		connexion = daoFactory.getConnection();
		preparedStatement = initialisationRequetePreparee(connexion,SQL_INSERT_Client,true,client.getNom(),client.getPrenom(),client.getNationalite(),client.getCIN(),client.getAdresse(),client.getDateNaissance(),client.getPhone());
                int statut = preparedStatement.executeUpdate();
		/* Analyse du statut retourné par la requête d'insertion */ 
		if ( statut == 0 ) {
                    System.out.println("erreur!");
		//throw new DAOException( "Échec de la création du client,aucune ligne n'est ajoutée dans la table." );
		}
		
		} catch ( SQLIntegrityConstraintViolationException e ) {
                    JOptionPane.showMessageDialog(null,"Attention ce cin existe deja  dans votre base!","cin duplication",JOptionPane.ERROR_MESSAGE);
		} 
                 catch ( SQLException e ) {
                    
		}finally {
			fermeturesSilencieuses(preparedStatement,connexion);
				  } 
		}
        
        
        public Creation( Facture f ) throws IllegalArgumentException {
	DaoFactory daoFactory=new DaoFactory();

	Connection connexion = null; 
	PreparedStatement preparedStatement = null;
	
	try {
		/* Récupération d'une connexion depuis la Factory */ 
		connexion = daoFactory.getConnection();
		preparedStatement = initialisationRequetePreparee(connexion,SQL_INSERT_Facture,true,f.getNum(),f.getMontant(),f.getNumr());
                int statut = preparedStatement.executeUpdate();
		/* Analyse du statut retourné par la requête d'insertion */ 
		if ( statut == 0 ) {
                    System.out.println("erreur!");
		//throw new DAOException( "Échec de la création du client,aucune ligne n'est ajoutée dans la table." );
		}
		
		} catch ( SQLException e ) {
		} finally {
			fermeturesSilencieuses(preparedStatement,connexion);
				  } 
		}



    
}
