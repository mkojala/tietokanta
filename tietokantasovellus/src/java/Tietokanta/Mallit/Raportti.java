
package Tietokanta.Mallit;

import Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Marianne
 */
public class Raportti {
    
   private int raportti_id;
//   private Varaus varaus;
//   private Kayttaja asiakas;
   private int varaus_id;
   private int asiakas_id;
   private String potilasraportti;
   private String hoito_ohjeet;

   public Raportti(){
       
   }
   public Raportti(String potilasraportti, String hoito_ohjeet){
       this.potilasraportti = potilasraportti;
       this.hoito_ohjeet = hoito_ohjeet;
   }
   public int getRapID(){
       return raportti_id;
   }
   public int getVarID(){
       return varaus_id;
   }
   public int getAsID(){
       return asiakas_id;
   }
   public String getRaportti(){
       return potilasraportti;
   }
   public String getOhjeet(){
       return hoito_ohjeet;
   }
   public void setRapID(int raportti_id){
       this.raportti_id = raportti_id;
   }
   public void setVarID(int varaus_id){
       this.varaus_id = varaus_id;
   }
   public void setAsID(int asiakas_id){
       this.asiakas_id=asiakas_id;
   }
   public void setRaportti(String potilasraportti){
       this.potilasraportti=potilasraportti;
   }
   public void setOhjeet(String hoito_ohjeet){
       this.hoito_ohjeet=hoito_ohjeet;
   }
    public static List<Raportti> getAsiakkaanRaportit(int asiakas_id) {
        ArrayList<Raportti> raportit = new ArrayList<Raportti>();
        try {
            String sql = "SELECT raportti_id, varaus_id, asiakas_id, potilasraportti, hoito_ohjeet from raportti where asiakas_id = ?";

            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, asiakas_id);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {
                
                Raportti raportti = new Raportti();
                raportti.setRapID(tulokset.getInt("raportti_id"));
                raportti.setVarID(tulokset.getInt("varaus_id"));
                raportti.setAsID(tulokset.getInt("asiakas_id"));
                raportti.setRaportti(tulokset.getString("potilasraportti"));
                raportti.setOhjeet(tulokset.getString("hoito_ohjeet")); 
                raportit.add(raportti);

            }
            try {
                tulokset.close();
            } catch (Exception e) {
            }
            try {   
                kysely.close();
            } catch (Exception e) {
            }
            try {
                yhteys.close();
            } catch (Exception e) {
            }
        } catch (NamingException ex) {
            Logger.getLogger(Raportti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Raportti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return raportit;

    }
   
   public static List<Raportti> getRaportit() {
        ArrayList<Raportti> raportit = new ArrayList<Raportti>();
        try {
            String sql = "SELECT raportti_id, varaus_id, asiakas_id, potilasraportti, hoito_ohjeet from raportti";

            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {
                
                Raportti raportti = new Raportti();
                raportti.setRapID(tulokset.getInt("raportti_id"));
                raportti.setVarID(tulokset.getInt("varaus_id"));
                raportti.setAsID(tulokset.getInt("asiakas_id"));
                raportti.setRaportti(tulokset.getString("potilasraportti"));
                raportti.setOhjeet(tulokset.getString("hoito_ohjeet")); 
                raportit.add(raportti);

            }
            try {
                tulokset.close();
            } catch (Exception e) {
            }
            try {   
                kysely.close();
            } catch (Exception e) {
            }
            try {
                yhteys.close();
            } catch (Exception e) {
            }
        } catch (NamingException ex) {
            Logger.getLogger(Raportti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Raportti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return raportit;

    }
}
