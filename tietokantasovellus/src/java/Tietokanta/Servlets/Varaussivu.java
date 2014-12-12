package Tietokanta.Servlets;

import Tietokanta.Mallit.Kayttaja;
import Tietokanta.Mallit.Varaus;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class Varaussivu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
//        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("kirjautunut");
//        if (kirjautunut == null) {
//            response.sendRedirect("login");
//            return;
//        }
        
//        PrintWriter out = response.getWriter();
        
        Date pvm;
        DateFormat format = new SimpleDateFormat("yyyy-M-dd");

        List<Varaus> varaukset = new ArrayList<Varaus>();

        try {
            pvm = format.parse(request.getParameter("pvm"));
//            out.println("moikka moi");
//            out.println(pvm.getTime());
            varaukset = Varaus.getKaikkiVaraukset(new java.sql.Date(pvm.getTime()));

        } catch (Exception e) {
        }
        request.setAttribute("varaukset", varaukset);

//        out.println(varaukset.size());
        
//        List<Kayttaja> laakarit = Kayttaja.getLaakarit();
//        request.setAttribute("laakarit", laakarit);
        //List<Varaus> varaukset = Varaus.getLaakarinVaraukset(laakari);
        // request.setAttribute("varaukset", varaukset);
        
        response.setContentType("text/html;charset=UTF-8");
        naytaJSP("varaussivu.jsp", request, response);

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
