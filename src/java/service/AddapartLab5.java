/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Autopart;

/**
 *
 * @author Lenovo
 */
public class AddapartLab5 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            Autopart autopart = (Autopart) session.getAttribute("Autopart");

            if (autopart == null) {
                String name = request.getParameter("name");
                String pid = request.getParameter("pid");
                String type = request.getParameter("type");
                int price = Integer.parseInt(request.getParameter("price"));
                autopart = new Autopart(pid,name,type,price);

                
                session.setAttribute("Autopart", autopart);
                out.println("<html><body>");
                out.println("<form action='AddapartLab5'>");
                out.println("Id: <input type='text' name='pid' value=" + autopart.getPid()+ ">");
                out.println("Name: <input type='text' name='name' value=" + autopart.getName() + ">");
                out.println("Type: <input type='text' name='type' value=" + autopart.getType() + ">");
                out.println("Price: <input type='text' name='price' value=" + autopart.getPrice() + ">");
                out.println("<input type='submit' value='แก้ไข'>");
                out.println("</form></body></html>");
            } 
            
            else {
                out.println("<form action='AddapartLab5'>");
                out.println("Id: <input type='text' name='pid' value=" + autopart.getPid()+ "><br/>");
                out.println("name:<input type='text' name='name' value=" + autopart.getName() + "><br/>");
                out.println("type:<input type='type' name='type' value=" + autopart.getType() + "><br/>");
                out.println("Price:<input type='text' name='price' value=" + autopart.getPrice() + "><br/>");
                out.println("<input type='submit' value='แก้ไข'>");
                out.println("</form></body></html>");

                session.removeAttribute("Autopart");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("error.html");
            {
            }
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

}
