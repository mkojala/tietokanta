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

public class Kayttaja {

    private int kayttaja_id;
    private String kayttajatunnus;
    private String nimi;
    private String osoite;
    private String salasana;
    private int oikeustaso;

    public Kayttaja() {
        
    }

    public Kayttaja(int kayttaja_id, String kayttajatunnus, String nimi, String osoite, String salasana, int oikeustaso) {
        this.kayttaja_id = kayttaja_id;
        this.kayttajatunnus = kayttajatunnus;
        this.nimi = nimi;
        this.osoite = osoite;
        this.salasana = salasana;
        this.oikeustaso = oikeustaso;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getOsoite() {
        return osoite;
    }

    public int getKayttaja_id() {
        return kayttaja_id;
    }

    public void setKayttaja_id(int kayttaja_id) {
        this.kayttaja_id = kayttaja_id;
    }

    public void setKayttajatunnus(String kayttajatunnus){
        this.kayttajatunnus=kayttajatunnus;
    }
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public void setOikeustaso(int oikeustaso) {
        this.oikeustaso = oikeustaso;
    }

    public String getKayttajatunnus(){
        return this.kayttajatunnus;
    }
    public String getNimi() {
        return this.nimi;
    }

    public String getSalasana() {
        return this.salasana;
    }

    public int getOikeustaso() {
        return this.oikeustaso;
    }

    public static List<Kayttaja> getKayttajat() {
        ArrayList<Kayttaja> kayttajat = new ArrayList<Kayttaja>();
        try {
            String sql = "SELECT kayttaja_id, kayttajatunnus, nimi, osoite, salasana, oikeustaso from kayttaja";

            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Kayttaja kayttaja = new Kayttaja();

                kayttaja.setKayttaja_id(tulokset.getInt("kayttaja_id"));
                
                kayttaja.setKayttajatunnus(tulokset.getString("kayttajatunnus"));

                kayttaja.setNimi(tulokset.getString("nimi"));
                
                kayttaja.setOsoite(tulokset.getString("osoite"));

                kayttaja.setSalasana(tulokset.getString("salasana"));
                
                kayttaja.setOikeustaso(tulokset.getInt("oikeustaso"));

                kayttajat.add(kayttaja);
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
            Logger.getLogger(Kayttaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kayttaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kayttajat;

    }
        
    public void tallenna(String kayttajatunnus, String nimi, String osoite, String salasana, int oikeustaso) throws SQLException, NamingException{
        String sql = "INSERT INTO kayttaja (kayttajatunnus, nimi, osoite, salasana, oikeustaso) VALUES(?, ?, ?, ?, ?)";
        Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
             kysely.setString(1, kayttajatunnus);
             kysely.setString(2, nimi);
             kysely.setString(3, osoite);
             kysely.setString(4, salasana);
             kysely.setInt(5, oikeustaso);
            ResultSet tulokset = kysely.executeQuery();
            
            
     
                kysely.close();
      
                tulokset.close();
          
                yhteys.close();
            
    }

    public static Kayttaja etsiKayttajaTunnuksilla(String kayttaja, String salasana) throws NamingException, SQLException {
        String sql = "SELECT kayttaja_id, nimi, kayttajatunnus, salasana, oikeustaso FROM kayttaja where kayttajatunnus = ? AND salasana = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, kayttaja);
        kysely.setString(2, salasana);
        ResultSet rs = kysely.executeQuery();

        //Alustetaan muuttuja, joka sisältää löydetyn käyttäjän
        Kayttaja kirjautunut = null;

  //next-metodia on kutsuttava aina, kun käsitellään 
        //vasta kannasta saatuja ResultSet-olioita.
        //ResultSet on oletuksena ensimmäistä edeltävällä -1:llä rivillä.
        //Kun sitä kutsuu ensimmäisen kerran siirtyy se ensimmäiselle riville 0.
        //Samalla metodi myös palauttaa tiedon siitä onko seuraavaa riviä olemassa.
        if (rs.next()) {
    //Kutsutaan sopivat tiedot vastaanottavaa konstruktoria 
            //ja asetetaan palautettava olio:
            kirjautunut = new Kayttaja();
            kirjautunut.setKayttaja_id(rs.getInt("kayttaja_id"));
            kirjautunut.setNimi(rs.getString("nimi")); 
            kirjautunut.setKayttajatunnus(rs.getString("kayttajatunnus"));
            kirjautunut.setSalasana(rs.getString("salasana"));
            kirjautunut.setOikeustaso(rs.getInt("oikeustaso"));
        }
        

  //Jos kysely ei tuottanut tuloksia käyttäjä on nyt vielä null.
        //Suljetaan kaikki resurssit:
        try {
            rs.close();
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

        //Käyttäjä palautetaan vasta täällä, kun resurssit on suljettu onnistuneesti.
        return kirjautunut;
    }
    public static List<Kayttaja> getLaakarit() {
        ArrayList<Kayttaja> kayttajat = new ArrayList<Kayttaja>();
        try {
            String sql = "SELECT kayttaja_id, kayttajatunnus, nimi, salasana, oikeustaso from kayttaja where oikeustaso = 1";

            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Kayttaja kayttaja = new Kayttaja();

                kayttaja.setKayttaja_id(tulokset.getInt("kayttaja_id"));
                
                kayttaja.setKayttajatunnus(tulokset.getString("kayttajatunnus"));

                kayttaja.setNimi(tulokset.getString("nimi"));

                kayttaja.setSalasana(tulokset.getString("salasana"));
                
                kayttaja.setOikeustaso(tulokset.getInt("oikeustaso"));

                kayttajat.add(kayttaja);
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
            Logger.getLogger(Kayttaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kayttaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kayttajat;

    }
    public static Kayttaja etsiLaakarinkayttajat() throws NamingException, SQLException {
        String sql = "SELECT nimi, osoite FROM kayttaja";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();

        //Alustetaan muuttuja, joka sisältää löydetyn käyttäjän
        Kayttaja asiakas = null;

        if (rs.next()) {
    //Kutsutaan sopivat tiedot vastaanottavaa konstruktoria 
            //ja asetetaan palautettava olio:
            asiakas = new Kayttaja();
            asiakas.setNimi(rs.getString("nimi")); 
            asiakas.setKayttajatunnus(rs.getString("osoite"));
        }
        

  //Jos kysely ei tuottanut tuloksia käyttäjä on nyt vielä null.
        //Suljetaan kaikki resurssit:
        try {
            rs.close();
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

        //Käyttäjä palautetaan vasta täällä, kun resurssit on suljettu onnistuneesti.
        return asiakas;
}
}
