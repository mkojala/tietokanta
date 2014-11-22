package Tietokanta;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Yhteys {

    public Yhteys() throws NamingException {

    }

    public static Connection getYhteys() throws NamingException, SQLException {
        InitialContext cxt = new InitialContext();
        DataSource yhteysVarasto = (DataSource) cxt.lookup("java:/comp/env/jdbc/mkojala");
//try { yhteys.close(); } catch (Exception e) { }
        Connection yhteys = yhteysVarasto.getConnection();
        return yhteys;
    }

    public Connection getConnection() throws NamingException, SQLException {
        return getYhteys();
    }
}
