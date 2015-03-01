/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietokanta.Mallit;

import Tietokanta.Yhteys;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author mkojala
 */
public class Varaus {

    private int varaus_id;
    private int asiakas_id;
    private int laakari_id;
    private String paiva;
    private Time aika;
    private String osoite;
    private String oireet;

    public Varaus() {

    }

    public Varaus(int varaus_id, int asiakas_id, int laakari_id, String paiva, String osoite, String oireet) {
        this.varaus_id = varaus_id;
        this.asiakas_id = asiakas_id;
        this.laakari_id = laakari_id;
        this.paiva = paiva;
        this.oireet = oireet;
    }

    public Time getAika() {
        return aika;
    }

    public void setAika(Time aika) {
        this.aika = aika;
    }

    public int getVaraus_id() {
        return varaus_id;
    }

    public void setVaraus_id(int varaus_id) {
        this.varaus_id = varaus_id;
    }

    public  int getAsiakas_id() {
        return asiakas_id;
    }

    public void setAsiakas_id(int asiakas_id) {
        this.asiakas_id = asiakas_id;
    }

    public int getLaakari_id() {
        return laakari_id;
    }

    public void setLaakari_id(int laakari_id) {
        this.laakari_id = laakari_id;
    }

    public String getPaiva() {
        return paiva;
    }

    public void setPaiva(String paiva) {
        this.paiva = paiva;
    }

    public String getOireet() {
        return oireet;
    }

    public void setOireet(String oireet) {
        this.oireet = oireet;
    }
    
    public static List<Varaus> getAsiakkaanVaraukset(int asiakas_id) {
        ArrayList<Varaus> varaukset = new ArrayList<Varaus>();
        try {
            String sql = "SELECT varaus_id, asiakas_id, laakari_id, paiva, oireet FROM varaus WHERE asiakas_id = ?";
            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, asiakas_id);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Varaus varaus = new Varaus();
                varaus.setVaraus_id(tulokset.getInt("varaus_id"));
                varaus.setAsiakas_id(tulokset.getInt("asiakas_id"));
                varaus.setLaakari_id(tulokset.getInt("laakari_id"));
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

    public static List<Varaus> getKaikkiVaraukset(Date pvm) {
        ArrayList<Varaus> varaukset = new ArrayList<Varaus>();
        try {
            String sql = "SELECT varaus_id, asiakas_id, laakari_id, paiva, oireet FROM varaus WHERE cast(paiva as date)=cast(? as date);";
            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setDate(1, (java.sql.Date) pvm);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Varaus varaus = new Varaus();
                varaus.setVaraus_id(tulokset.getInt("varaus_id"));
                varaus.setAsiakas_id(tulokset.getInt("asiakas_id"));
                varaus.setLaakari_id(tulokset.getInt("laakari_id"));
                varaus.setPaiva(tulokset.getString("paiva"));
                varaus.setAika(tulokset.getTime("paiva"));
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

    public static List<Varaus> getLaakarinVaraukset(int laakari_id) {
        ArrayList<Varaus> varaukset = new ArrayList<Varaus>();
        try {
            String sql = "SELECT laakari_id, varaus_id, asiakas_id, paiva, oireet FROM varaus WHERE laakari_id = ?";
            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, laakari_id);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {
                Varaus varaus = new Varaus();
                varaus.setLaakari_id(tulokset.getInt("laakari_id"));
                varaus.setVaraus_id(tulokset.getInt("varaus_id"));
                varaus.setAsiakas_id(tulokset.getInt("asiakas_id"));
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

    public static List<Varaus> getTiettyVaraus(int varaus_id) {
        ArrayList<Varaus> varaukset = new ArrayList<Varaus>();
        try {
            String sql = "SELECT varaus_id, asiakas_id, laakari_id, paiva,  oireet FROM varaus WHERE asiakas_id = ?";
            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, varaus_id);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Varaus varaus = new Varaus();
                varaus.setVaraus_id(tulokset.getInt("varaus_id"));
                varaus.setAsiakas_id(tulokset.getInt("asiakas_id"));
                varaus.setLaakari_id(tulokset.getInt("laakari_id"));
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

    public void varaa(int asiakas_id, int laakari_id, String paiva, String oireet) throws SQLException, NamingException {
        String sql;
        sql = "INSERT INTO varaus (asiakas_id, laakari_id, paiva, oireet) VALUES (?,?,?,?)";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        Date paivamaara = Date.valueOf(paiva);
        kysely.setInt(1, asiakas_id);
        kysely.setInt(2, laakari_id);
        kysely.setDate(3, paivamaara);
        kysely.setString(4,oireet);
        ResultSet tulokset = kysely.executeQuery();
        
        Varaus varaus = null;
        
        if(tulokset.next()){
                varaus = new Varaus();
                varaus.setAsiakas_id(tulokset.getInt("asiakas_id"));
                varaus.setLaakari_id(tulokset.getInt("laakari_id"));
                varaus.setPaiva(tulokset.getString("paiva"));
                varaus.setOireet(tulokset.getString("oireet"));
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
    }

    public static List<Varaus> getVaraukset() {
        ArrayList<Varaus> varaukset = new ArrayList<Varaus>();
        try {
            String sql = "SELECT asiakas_id, laakari_id, paiva, oireet FROM varaus";
            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Varaus varaus = new Varaus();
                varaus.setAsiakas_id(tulokset.getInt("asiakas_id"));
                varaus.setLaakari_id(tulokset.getInt("laakari_id"));
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
