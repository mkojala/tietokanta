package Tietokanta.Mallit;

import Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.Date;
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
    private int asiakas_id;
    private int laakari_id;
    private String potilasraportti;
    private String hoito_ohjeet;

    public Raportti() {

    }

    public int getLaakari_id() {
        return laakari_id;
    }

    public void setLaakari_id(int laakari_id) {
        this.laakari_id = laakari_id;
    }

    public Raportti(String potilasraportti, String hoito_ohjeet) {
        this.potilasraportti = potilasraportti;
        this.hoito_ohjeet = hoito_ohjeet;
    }

    public int getRaportti_id() {
        return raportti_id;
    }

    public void setRaportti_id(int raportti_id) {
        this.raportti_id = raportti_id;
    }

    public int getAsiakas_id() {
        return asiakas_id;
    }

    public void setAsiakas_id(int asiakas_id) {
        this.asiakas_id = asiakas_id;
    }

    public String getPotilasraportti() {
        return potilasraportti;
    }

    public void setPotilasraportti(String potilasraportti) {
        this.potilasraportti = potilasraportti;
    }

    public String getHoito_ohjeet() {
        return hoito_ohjeet;
    }

    public void setHoito_ohjeet(String hoito_ohjeet) {
        this.hoito_ohjeet = hoito_ohjeet;
    }

    public static List<Raportti> getAsiakkaanRaportit(int asiakas_id) {
        ArrayList<Raportti> raportit = new ArrayList<Raportti>();
        try {
            String sql = "SELECT asiakas_id, raportti_id, potilasraportti, hoito_ohjeet from raportti where asiakas_id = ?";

            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, asiakas_id);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Raportti raportti = new Raportti();   
                raportti.setAsiakas_id(tulokset.getInt("asiakas_id"));
                raportti.setRaportti_id(tulokset.getInt("raportti_id"));
                raportti.setPotilasraportti(tulokset.getString("potilasraportti"));
                raportti.setHoito_ohjeet(tulokset.getString("hoito_ohjeet"));
                raportit.add(raportti);

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
        return raportit;

    }

    public static List<Raportti> getRaportit() {
        ArrayList<Raportti> raportit = new ArrayList<Raportti>();
        try {
            String sql = "SELECT raportti_id, asiakas_id, laakari_id, potilasraportti, hoito_ohjeet from raportti";

            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Raportti raportti = new Raportti();
                raportti.setAsiakas_id(tulokset.getInt("asiakas_id"));
                raportti.setLaakari_id(tulokset.getInt("laakari_id"));
                raportti.setPotilasraportti(tulokset.getString("potilasraportti"));
                raportti.setHoito_ohjeet(tulokset.getString("hoito_ohjeet"));
                raportit.add(raportti);

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
        return raportit;

    }

    public Raportti getTiettyRaportti(int raportti_id) throws SQLException, NamingException {
        String sql = "SELECT raportti_id, asiakas_id, laakari_id, potilasraportti, hoito_ohjeet from raportti where raportti_id= ?";

        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setInt(1, raportti_id);
        ResultSet tulokset = kysely.executeQuery();

        Raportti raportti = new Raportti();
        while (tulokset.next()) {
            raportti.setAsiakas_id(tulokset.getInt("asiakas_id"));
            raportti.setLaakari_id(tulokset.getInt("laakari_id"));
            raportti.setPotilasraportti(tulokset.getString("potilasraportti"));
            raportti.setHoito_ohjeet(tulokset.getString("hoito_ohjeet"));

            tulokset.close();

            kysely.close();

            yhteys.close();

        }
        return raportti;
    }

    public void poistaRaportti(int raportti_id) throws SQLException, NamingException {
        String sql = "DELETE FROM raportti WHERE raportti_id = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setInt(1, raportti_id);
        int tulokset = kysely.executeUpdate();
        kysely.close();      
        yhteys.close();
    }

    public void tallennaRaportti(int asiakas_id, int laakari_id, String potilasraportti, String hoito_ohjeet) throws SQLException, NamingException {
        String sql;
        sql = "INSERT INTO raportti (asiakas_id, laakari_id, potilasraportti, hoito_ohjeet) VALUES (?,?,?,?)";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);

        kysely.setInt(1, asiakas_id);
        kysely.setInt(2, laakari_id);
        kysely.setString(3, potilasraportti);
        kysely.setString(4, hoito_ohjeet);
        ResultSet tulokset = kysely.executeQuery();
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
    }
     public static void muokkaaRaporttia(int raportti_id) throws SQLException, NamingException {
        String sql = "UPDATE raportti SET potilasraportti = ?, hoito_ohjeet = ? WHERE raportti_id = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setInt(1, raportti_id);
        int tulos = kysely.executeUpdate();
        
        try {
            kysely.close();
        } catch (SQLException e) {
        }
        try {
            yhteys.close();
        } catch (SQLException e) {
        }
    }


}
