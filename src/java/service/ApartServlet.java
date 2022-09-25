/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Autopart;
import org.json.JSONObject;

/**
 *
 * @author Lenovo
 */
public class ApartServlet extends HttpServlet { // Lab 8

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
        String requestUrl = request.getRequestURI();
        String name = requestUrl.substring("/Autopart/ApartServlet/".length());

        Autopart autopart = ApartData.getInstance().getAutopart(name);

        if (autopart != null) {
            String json = "{\n";
            json += "\"id\": " + JSONObject.quote(autopart.getPid()) + ",\n";
            json += "\"name\": " + JSONObject.quote(autopart.getName()) + ",\n";
            json += "\"type\": " + JSONObject.quote(autopart.getType()) + ",\n";
            json += "\"price\": " + autopart.getPrice() + "\n";
            json += "}";
            response.getOutputStream().println(json);
        } else {
            //That person wasn't found, so return an empty JSON object. We could also return an error.
            response.getOutputStream().println("{}");
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pid = request.getParameter("pid");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));

        ApartData.getInstance().putAutopart(new Autopart(pid, name, type, price ));
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

}
