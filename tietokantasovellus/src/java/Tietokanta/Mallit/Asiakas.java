/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author mkojala
 */
public class Asiakas {
    
    private int asiakas_id;

    
    public Asiakas(){
    }
    
    public Asiakas(int id){
        this.asiakas_id =id;
    }

    public void setAsiakas_id(int asiakas_id) {
        this.asiakas_id = asiakas_id;
    }

    public int getAsiakas_id() {
        return asiakas_id;
    }
    
    
    public static List<Asiakas> getAsiakkaat(int asiakas_id) {
        ArrayList<Asiakas> asiakkaat = new ArrayList<Asiakas>();
        try {
            String sql = "SELECT asiakas_id FROM asiakkaat WHERE asiakas_id = ?";
            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, asiakas_id);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {
                
                Asiakas asiakas = new Asiakas();
                asiakas.setAsiakas_id(tulokset.getInt("asiakas_id"));
                asiakkaat.add(asiakas);
            }
            try {
                tulokset.close();
            } catch (SQLException e) {
            }
            try {
                kysely.close();
            } catch (SQLException e) {
            }
            try {
                yhteys.close();
            } catch (SQLException e) {
            }
        } catch (NamingException ex) {
            Logger.getLogger(Raportti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Raportti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asiakkaat;

    }
    
}
