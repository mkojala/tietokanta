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
public class Laakari {
    private int laakari_id;
    String nimi;
    
    public Laakari(){
        
    }
    
    public Laakari(int id, String nimi){
        this.laakari_id = id;
        this.nimi = nimi;
    }

    public int getLaakari_id() {
        return laakari_id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setLaakari_id(int laakari_id) {
        this.laakari_id = laakari_id;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    
    
    
}
