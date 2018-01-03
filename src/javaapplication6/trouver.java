/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap; 
import java.util.Map;
import static javaapplication6.Client.mapClient;
import static javaapplication6.DAOUtilitaire.initialisationRequetePreparee;
import static javaapplication6.DAOUtilitaire.fermeturesSilencieuses;
import static javaapplication6.Employe.mapEmp;
import static javaapplication6.Reservation.mapReservation;
import static javaapplication6.Voiture.mapVoiture;
import static javaapplication6.Facture.mapFacture;
/**
 *
 * @author choaib
 */
public class trouver {
    
  //1-methodes relatives au Employes
    public  static ResultSet afficherEmploye()  {
	
		Map<Integer,Employe> employes = new HashMap<Integer,Employe>();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Employe employe = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Employe";
		
		try{
                 connexion=daoFactory.getConnection();
                  preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true);
                  resultSet = preparedStatement.executeQuery();
			
			
			
		}catch(SQLException e){
							  
                }
		
		return resultSet;
    }									
  //2-methodes relatives au voitures
    public  static ResultSet affichervoiture()  {
		Map<Integer,Voiture> Voitures = new HashMap<Integer,Voiture>();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Voiture v = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from voiture";
		
		try{
                 connexion=daoFactory.getConnection();
                  preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true);
                  resultSet = preparedStatement.executeQuery();
                    }catch(SQLException e){
                                           }
                                return resultSet;
                                                    }
    public  static Voiture trouverVoiture(String m)  {
		
		Voiture voitures = new Voiture();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Voiture where matricule=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,m);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
                voitures = mapVoiture(resultSet);
								}
			
		}catch(SQLException e){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
	
		
		return voitures;
    }
    public  static Voiture trouverVoitureMarque(String m)  {
		
		Voiture voitures = new Voiture();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Voiture where marque=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,m);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
                voitures = mapVoiture(resultSet);
								}
			
		}catch(SQLException e){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
	
		
		return voitures;
    }
    
    
    
    public  static Map<String,Voiture> trouverMatriculeVoiture(String Matricule ) {
		
		Map<String,Voiture> voitures = new HashMap<String,Voiture>();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Voiture voiture = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Voiture where matricule=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,Matricule);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			
				voiture=mapVoiture(resultSet);
				voitures.put(voiture.getMatricule(),voiture);
									}
			
		}catch(SQLException e){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
	
		
		return voitures;
    }
  //3-methodes relatives au Factures:
    public  static ResultSet afficherfacture()  {
	
		Map<Integer,Facture> Factures = new HashMap<Integer,Facture>();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Facture f = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from tarif";
		
		try{
                 connexion=daoFactory.getConnection();
                  preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true);
                  resultSet = preparedStatement.executeQuery();
			
			
		}catch(SQLException e){
							  
		}
	
		
		return resultSet;
    }    
    public  static Facture trouverFacture(int n) {
		
		Facture f = new Facture();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Tarif where numFacture=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion,SQL_Request,true,n);
			resultSet = preparedStatement.executeQuery();			
			while (resultSet.next()) 
                            f = mapFacture(resultSet);
			
		}catch(SQLException e){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
	
		
		return f;
    }
    
    
    public  static ResultSet trouverFactureR(int n ) {
		
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Tarif where numFacture=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,false,n);
			resultSet = preparedStatement.executeQuery();
			
			
			
		}catch(SQLException e){
						  
		}
	
		
		return resultSet;
    }

    
    
  //4-methodes relatives au reservations:
    
                public  static ResultSet afficherReservation()  {
	
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Reservation r = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Reservation;";
		
		try{
                 connexion=daoFactory.getConnection();
                  preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true);
                  resultSet = preparedStatement.executeQuery();
			
			
			
		}catch(SQLException e){
							  
		}
	
		
		return resultSet;
    }
                public  static Reservation trouveNumResa(int n ) {
		
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Reservation r = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from  Reservation where numReserv=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,n);
			resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
			
				r=mapReservation(resultSet);
									}
			
									
		}catch(SQLException e){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
		return r;
         }		
                public  static ResultSet trouveNumResaR(int n ) {
		
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from  Reservation where numReserv=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,n);
			resultSet = preparedStatement.executeQuery();
                        
									
		}catch(SQLException e){
							  
		}
		return resultSet;
         }		

                
                
//5-methodes relatives au clients
        public  static ResultSet afficherclient() throws SQLException  {
	
		Map<Integer,Client> clients = new HashMap<Integer,Client>();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Client client = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from client";
		
		try{
                 connexion=daoFactory.getConnection();
                 preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true);
                 resultSet = preparedStatement.executeQuery();}
                catch(SQLException e){
                                     }
                
                   return resultSet;
                                                                         }		  
        public  static ResultSet trouverCinClient(String Cin ) {
		
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Client client = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Client where cin=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,Cin);
			resultSet = preparedStatement.executeQuery();
			
		
			
		}catch(SQLException e){
							  
		}
	
		
		return resultSet;
        }
	public  static Client trouverCinClient2(String Cin ) {
		
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Client client = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Client where cin=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,Cin);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			
				client=mapClient(resultSet);
									}
			
		}catch(SQLException e){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
	
		
		return client;
        }
        
        //*************************Trouver Client Boolean 
        public  static boolean ClientExist(String Cin ) {
		
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Client client = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Client where cin=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,Cin);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			
				client=mapClient(resultSet);
									}
			
		}catch(SQLException e){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
	
		
		if (client.getNom().equals(null))
                    return false;
                else 
                    return true;
        }
        
        
        //*************************Trouver employe
        	public  static Employe trouverEmp(String u) {
		
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		Employe e = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Employe where UserName=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,u);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			
				e=mapEmp(resultSet);
									}
			
		}catch(SQLException a){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
	
		
		return e;
                }
                
//****************************Trouver employe a partir d'username
                
public  static Employe trouverLogin(String m)  {
		
		Employe e = new Employe();
		Connection connexion = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		DaoFactory daoFactory=new DaoFactory();
		String SQL_Request="select * from Employe where UserName=?";
		
		try{
			connexion=daoFactory.getConnection();
			preparedStatement=initialisationRequetePreparee(connexion,SQL_Request,true,m);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
                                e = mapEmp(resultSet);
			}
			
		}catch(SQLException ex){
							  
		}finally {
			fermeturesSilencieuses(resultSet,preparedStatement,connexion );
			}
	
		
		return e;
    }
                    
    
}
    
    
    
    
   
                      								


