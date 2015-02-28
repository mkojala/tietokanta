package Tietokanta.Servlets;

import Tietokanta.Mallit.Kayttaja;
import static Tietokanta.Mallit.Kayttaja.etsiKayttajaTunnuksilla;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Kirjautuminen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NamingException, SQLException {
        String salasana = request.getParameter("password");
        String kayttaja = request.getParameter("username");
   
        HttpSession session = request.getSession();
       // Kayttaja kirjautuja = new Kayttaja();
     //   kirjautuja.setKayttajatunnus(kayttaja);
      //  kirjautuja.setSalasana(salasana);
        // kirjautuja = Kayttaja.etsiKayttajaTunnuksilla(kayttaja, salasana);

        /* Tarkistetaan onko parametrina saatu oikeat tunnukset */
        /* Jos kummatkin parametrit ovat null, käyttäjä ei ole edes yrittänyt vielä kirjautua.
         * Näytetään pelkkä lomake */
        if (kayttaja == null || salasana == null) {
            naytaJSP("login.jsp", request, response);
            return;
        }
//Tarkistetaan että vaaditut kentät on täytetty:
        if (kayttaja.equals("")) {
            asetaVirhe("Kirjautuminen epäonnistui! Et antanut käyttäjätunnusta.", request);
            naytaJSP("login.jsp", request, response);
            return;
        }
        /* Välitetään näkymille tieto siitä, mikä tunnus yritti kirjautumista */
        request.setAttribute("kayttaja", kayttaja);
        if (salasana.equals("")) {
            asetaVirhe("Kirjautuminen epäonnistui! Et antanut salasanaa.", request);
            naytaJSP("login.jsp", request, response);
            return;
        }
        Kayttaja k = Kayttaja.etsiKayttajaTunnuksilla(kayttaja, salasana);

        if (k != null) {
            session.setAttribute("kirjautunut", k);
            if (k.getOikeustaso() == 2) {
                response.sendRedirect("omasivu");
            } else {
                response.sendRedirect("laakarinsivu");
            }
            
            
        } else {
            response.setContentType("text/html;charset=UTF-8");
            /* Väärän tunnuksen syöttänyt saa eteensä kirjautumislomakkeen.
             * Tässä käytetään omassa kirjastotiedostossa määriteltyä näkymännäyttöfunktioita */
            request.setAttribute("viesti", "Väärä käyttäjätunnus tai salasana");
            request.setAttribute("kayttaja", kayttaja);
            naytaJSP("login.jsp", request, response);

            //  RequestDispatcher dispatcher =request.getRequestDispatcher("login.jsp");
            //dispatcher.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void naytaJSP(String loginjsp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        RequestDispatcher dispatcher = request.getRequestDispatcher(loginjsp);

        dispatcher.forward(request, response);
    }

    //metodi jolla asetetaan virheviestin sisältö
    public void asetaVirhe(String viesti, HttpServletRequest request) {
        request.setAttribute("viesti", viesti);
    }

}
