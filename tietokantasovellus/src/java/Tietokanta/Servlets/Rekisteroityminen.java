/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietokanta.Servlets;


import Tietokanta.Mallit.Kayttaja;
import static Tietokanta.Mallit.Kayttaja.etsiKayttajaTunnuksilla;
import Tietokanta.Yhteys;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

/**
 *
 * @author mkojala
 */
public class Rekisteroityminen extends HttpServlet {
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws javax.naming.NamingException
     */
         protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {     
        String salasana = request.getParameter("salasana");
        String nimi = request.getParameter("nimi");
        String kayttajatunnus = request.getParameter("ktunnus");
        String osoite = request.getParameter("osoite");  
         
         Kayttaja kayttaja = new Kayttaja();              
         kayttaja.tallenna(kayttajatunnus, nimi, salasana, osoite, 2);
        
       
            response.sendRedirect("login");
 
             
           
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
             } catch (SQLException ex) {
                 Logger.getLogger(Rekisteroityminen.class.getName()).log(Level.SEVERE, null, ex);
             } catch (NamingException ex) {
                 Logger.getLogger(Rekisteroityminen.class.getName()).log(Level.SEVERE, null, ex);
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
             } catch (SQLException ex) {
                 Logger.getLogger(Rekisteroityminen.class.getName()).log(Level.SEVERE, null, ex);
             } catch (NamingException ex) {
                 Logger.getLogger(Rekisteroityminen.class.getName()).log(Level.SEVERE, null, ex);
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
public void asetaVirhe(String viesti, HttpServletRequest request) {
        request.setAttribute("viesti", viesti);
    }

}
