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
import java.sql.Date;

public class Reservation {
    int numReserv,idEmp,numFacture;
    Date DateD,DateF;
    String Statut,cinClient,matriculeVoiture;

    public String getCinClient() {
        return cinClient;
    }

    public void setCinClient(String cinClient) {
        this.cinClient = cinClient;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public int getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(int numFacture) {
        this.numFacture = numFacture;
    }

    public String getMatriculeVoiture() {
        return matriculeVoiture;
    }

    public void setMatriculeVoiture(String matriculeVoiture) {
        this.matriculeVoiture = matriculeVoiture;
    }
    
     public int getNumReserv() {
        return numReserv;
    }

    public void setNumReserv(int n) {
        this.numReserv=n;
    }

    public Date getDateD() {
        return DateD;
    }

    public void setDateD(Date DateD) {
        this.DateD = DateD;
    }

    public Date getDateF() {
        return DateF;
    }

    public void setDateF(Date DateF) {
        this.DateF = DateF;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }
    
    
   public static Reservation mapReservation(ResultSet resultSet) throws SQLException{
                    Reservation r=new Reservation();
                    r.setDateD(resultSet.getDate("DateD"));
                    r.setDateF(resultSet.getDate("DateF"));
                    r.setCinClient(resultSet.getString("CinClient"));
                    r.setIdEmp(resultSet.getInt("IdEmploye"));
                    r.setMatriculeVoiture(resultSet.getString("MatriculeVoiture"));
                    r.setNumReserv(resultSet.getInt("numReserv"));
                    r.setStatut(resultSet.getString("statut"));
                    return r;

                                                                                 }
    
}
