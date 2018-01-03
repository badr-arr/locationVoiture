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
public class Facture {
      int num,numr;
      double montant ;

    public int getNumr() {
        return numr;
    }

    public void setNumr(int numr) {
        this.numr = numr;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double  getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    
   public static Facture  mapFacture(ResultSet resultSet) throws SQLException{
       Facture f = new Facture();
       f.setMontant(resultSet.getDouble("montant"));
       f.setNum(resultSet.getInt("numFacture"));
       f.setNumr(resultSet.getInt("NumR"));
        return f;
                                                                            }
    
}
