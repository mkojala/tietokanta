package Tietokanta.Mallit;

import Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class Kayttaja {

    private int id;
    private String nimi;
    private String salasana;

    public Kayttaja() {

    }

    public Kayttaja(int id, String nimi, String salasana) {
        this.id = id;
        this.nimi = nimi;
        this.salasana = salasana;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public int getId() {
        return this.id;
    }

    public String getNimi() {
        return this.nimi;
    }

    public String getSalasana() {
        return this.salasana;
    }

    public static List<Kayttaja> getKayttajat() throws NamingException, SQLException {
        String sql = "SELECT asiakas_id, nimi, salasana from asiakas";

        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet tulokset = kysely.executeQuery();

        ArrayList<Kayttaja> kayttajat = new ArrayList<Kayttaja>();
        while (tulokset.next()) {

            Kayttaja kayttaja = new Kayttaja();

            kayttaja.setId(tulokset.getInt("asiakas_id"));

            kayttaja.setNimi(tulokset.getString("nimi"));

            kayttaja.setSalasana(tulokset.getString("salasana"));

            kayttajat.add(kayttaja);
        }
        kayttajat.add(new Kayttaja(111, "Anssi Assi", "salasana"));
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
        return kayttajat;
    }
}
