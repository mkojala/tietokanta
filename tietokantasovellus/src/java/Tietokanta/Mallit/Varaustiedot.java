/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietokanta.Mallit;

import Tietokanta.Yhteys;
import java.io.PrintWriter;
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
public class Varaustiedot {
    String nimi;
    String osoite;
    String paiva;
    String oireet;

    
    public Varaustiedot(){
        
    }
    public String getNimi() {
        return nimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public String getPaiva() {
        return paiva;
    }

    public String getOireet() {
        return oireet;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public void setPaiva(String paiva) {
        this.paiva = paiva;
    }

    public void setOireet(String oireet) {
        this.oireet = oireet;
    }
    public static List<Varaustiedot>getVaraustiedot(int laakari_id){
        
        ArrayList<Varaustiedot> varaukset = new ArrayList<Varaustiedot>();
        try {
            String sql = "SELECT laakari_id, asiakas_id, paiva, oireet, nimi, osoite FROM varaus, kayttaja WHERE kayttaja_id = asiakas_id AND laakari_id= ?";
            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, laakari_id);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Varaustiedot varaus = new Varaustiedot();
                varaus.setNimi(tulokset.getString("nimi"));
                varaus.setOsoite(tulokset.getString("osoite"));
                varaus.setPaiva(tulokset.getString("paiva"));
                varaus.setOireet(tulokset.getString("oireet"));
                varaukset.add(varaus);

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
        return varaukset;

        
    }
}
