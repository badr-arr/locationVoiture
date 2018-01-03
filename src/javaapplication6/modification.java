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
public class modification {
    
   public  modification(){
        
    }
    public modification(Client client,String cin){
			  
			   
				Connection connexion = null; 
				PreparedStatement preparedStatement = null; 
				DaoFactory daoFactory=new DaoFactory();
				String SQL_Request="update Client set Nom=?,Prenom=?,Nationalite=?,Adresse=?,Cin=?,dateNaissance =? where  Cin=?";
				try{  

					connexion=daoFactory.getConnection();
					preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,client.getNom(),client.getPrenom(),client.getNationalite(),client.getAdresse(),client.getCIN(),client.getDateNaissance(),cin);
					int statut = preparedStatement.executeUpdate();
					
					
					
				}catch(SQLIntegrityConstraintViolationException e){
                                         JOptionPane.showMessageDialog(null,"Attention ce num de reservation existe deja  dans votre base!","num de reservation duplication",JOptionPane.ERROR_MESSAGE);
                                                                                       }catch(SQLException e){
									  
				}finally {
					fermeturesSilencieuses(preparedStatement,connexion );
					}
			}
   
    //*********************************Modification Voiture
    
    public modification(Voiture v,String n){
			  
			   
				Connection connexion = null; 
				PreparedStatement preparedStatement = null; 
				DaoFactory daoFactory=new DaoFactory();
				String SQL_Request="update Voiture set matricule=?,marque=?,type=?,disponibilite=?,SiegeBebe=?,Prix=? where  matricule=?";
				try{  

					connexion=daoFactory.getConnection();
					preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,v.getMatricule(),v.getMarque(),v.getType(),v.getDisponibilite(),v.getSiegeBebe(),v.getPrix(),n);
					int statut = preparedStatement.executeUpdate();
					
					
					
				}catch(SQLIntegrityConstraintViolationException e){
                                         JOptionPane.showMessageDialog(null,"Attention ce num de matricule existe deja  dans votre base!","num de matricule duplication",JOptionPane.ERROR_MESSAGE);
                                                                                       }catch(SQLException e){
									  
				}finally {
					fermeturesSilencieuses(preparedStatement,connexion );
					}
			}
   
    
    
    //**************MODIFIER EMPLOYE
    public modification(Employe e,String u){
			  
			   
				Connection connexion = null; 
				PreparedStatement preparedStatement = null; 
				DaoFactory daoFactory=new DaoFactory();
                                    String SQL_Request="update Employe set Nom=?,Prenom=?,NumTelephone=?,UserName=?,Email=?,Password=?,compte=? where UserName=?";
				try{  

					connexion=daoFactory.getConnection();
					preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,e.getNom(),e.getPrenom(),e.getPhone(),e.getUserName(),e.getEmail(),e.getPassword(),e.getCompte(),u);
					int statut = preparedStatement.executeUpdate();
					
					
					
				}catch(SQLIntegrityConstraintViolationException a){
                                         JOptionPane.showMessageDialog(null,"Nombre de caractère dépassé!","Employe duplication",JOptionPane.ERROR_MESSAGE);
                                                                                       }catch(SQLException a){
									  
				}finally {
					fermeturesSilencieuses(preparedStatement,connexion );
					}
			}
   
    
    //*****************************MODIFICATION EMPLOYE 2 
    
    
    
    
    
    public modification(Reservation resa,int n){
			  
			   
				Connection connexion = null; 
				PreparedStatement preparedStatement = null; 
				DaoFactory daoFactory=new DaoFactory();
				String SQL_Request="update Reservation set numReserv=?,DateD=?,DateF=?,Statut=? where  numReserv=?";
				try{  
					connexion=daoFactory.getConnection();
					preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,resa.getNumReserv(),resa.getDateD(),resa.getDateF(),resa.getStatut(),n);
					int statut = preparedStatement.executeUpdate();
                                    }catch(SQLIntegrityConstraintViolationException e){
                                         JOptionPane.showMessageDialog(null,"Attention ce num de reservation existe deja  dans votre base!","num de reservation duplication",JOptionPane.ERROR_MESSAGE);
                                                                                       }
                                catch(SQLException e){
									  
				}finally {
					fermeturesSilencieuses(preparedStatement,connexion );
					}
			}
    
    public modification(Facture facture ,int n){
			  
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="update Tarif set numFacture=?,montant=?,NumR=? where  numFacture=?";
				try{  

                                        connexion=daoFactory.getConnection();
					preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,facture.getNum(),facture.getMontant(),facture.getNumr(),n);
					int statut = preparedStatement.executeUpdate();					
                                    }catch(SQLIntegrityConstraintViolationException e){
                                         JOptionPane.showMessageDialog(null,"Attention ce num de facture existe deja  dans votre base!","num de facture duplication",JOptionPane.ERROR_MESSAGE);
                                                                                       }catch(SQLException e){
									  
				}finally {
					fermeturesSilencieuses(preparedStatement,connexion );
					}
			}
   



    
}
