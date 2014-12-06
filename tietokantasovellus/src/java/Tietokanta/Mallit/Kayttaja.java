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
    private String nimi;
    private String salasana;
    private int oikeustaso;

    public Kayttaja() {

    }

    public Kayttaja(int kayttaja_id, String nimi, String salasana, int oikeustaso) {
        this.kayttaja_id = kayttaja_id;
        this.nimi = nimi;
        this.salasana = salasana;
        this.oikeustaso = oikeustaso;
    }

    public void setId(int kayttaja_id) {
        this.kayttaja_id = kayttaja_id;
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

    public int getId() {
        return this.kayttaja_id;
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
            String sql = "SELECT kayttaja_id, nimi, salasana, oikeustaso from kayttaja";

            Connection yhteys = Yhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Kayttaja kayttaja = new Kayttaja();

                kayttaja.setId(tulokset.getInt("kayttaja_id"));

                kayttaja.setNimi(tulokset.getString("nimi"));

                kayttaja.setSalasana(tulokset.getString("salasana"));

                kayttajat.add(kayttaja);
            }
            kayttajat.add(new Kayttaja(111, "Anssi Assi", "salasana", 1));
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
            Logger.getLogger(Kayttaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kayttaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kayttajat;

    }
    public static Kayttaja etsiKayttajaTunnuksilla(String kayttaja, String salasana){
        
    }
}
