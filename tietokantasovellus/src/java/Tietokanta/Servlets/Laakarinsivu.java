package Tietokanta.Servlets;

import Tietokanta.Mallit.Kayttaja;
import Tietokanta.Mallit.Raportti;
import Tietokanta.Mallit.Varaus;
import Tietokanta.Mallit.Varaustiedot;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marianne
 */
public class Laakarinsivu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws javax.naming.NamingException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("kirjautunut");
        if (kirjautunut == null) {
            response.sendRedirect("login");
            return;
        }
        request.setAttribute("kayttaja", kirjautunut.getNimi());
        int laakari_id = kirjautunut.getKayttaja_id();
        String potilasraportti = request.getParameter("raportti");
        String hoito_ohje = request.getParameter("hoito_ohje");

        List<Varaustiedot> varaukset = Varaustiedot.getVaraustiedot(kirjautunut.getKayttaja_id());
        request.setAttribute("varaukset", varaukset);
        List<Kayttaja> asiakkaat = Kayttaja.getAsiakkaat();
        request.setAttribute("asiakkaat", asiakkaat);
        int asiakas_id = 0;

        if (request.getParameter("asiakas") != null) {
            asiakas_id = Integer.parseInt(request.getParameter("asiakas"));

            String button = request.getParameter("button");

       // int raportti_id;
            if (button.equals("Hae")) {
                List<Raportti> raportit = Raportti.getAsiakkaanRaportit(asiakas_id);
                request.setAttribute("raportit", raportit);

            } else if (button.equals("Tallenna") && request.getParameter("asiakas") != null) {
                Raportti rap = new Raportti();
                try {
                    rap.tallennaRaportti(asiakas_id, laakari_id, potilasraportti, hoito_ohje);
                    response.sendRedirect("laakarinsivu");
                } catch (SQLException ex) {
                    Logger.getLogger(Laakarinsivu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NamingException ex) {
                    Logger.getLogger(Laakarinsivu.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (button.equals("Muokkaa") && request.getParameter("asiakas") != null && request.getParameter("checkbox") != null) {
               int checkbox = Integer.parseInt(request.getParameter("checkbox"));  
                asiakas_id = Integer.parseInt(request.getParameter("asiakas"));
                try {
                    Raportti r = new Raportti(); 
                    r.setRaportti_id(checkbox);
                    r.setAsiakas_id(asiakas_id);
                    r.setLaakari_id(kirjautunut.getKayttaja_id());
                    r.setPotilasraportti(request.getParameter("raportti"));
                    r.setHoito_ohjeet(request.getParameter("hoito_ohje"));
                    Raportti.muokkaaRaporttia(r);
                } catch (SQLException ex) {
                    Logger.getLogger(Laakarinsivu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NamingException ex) {
                    Logger.getLogger(Laakarinsivu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (button.equals("Poista") && request.getParameter("asiakas") != null && request.getParameter("checkbox") != null) {
                int checkbox = Integer.parseInt(request.getParameter("checkbox"));
                //  raportti_id = Integer.parseInt(request.getParameter("raportti"));
                try {
                    Raportti r = new Raportti();
                    r.poistaRaportti(checkbox);
                } catch (SQLException ex) {
                    Logger.getLogger(Laakarinsivu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NamingException ex) {
                    Logger.getLogger(Laakarinsivu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        naytaJSP("laakarinsivu.jsp", request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws javax.naming.NamingException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
}
