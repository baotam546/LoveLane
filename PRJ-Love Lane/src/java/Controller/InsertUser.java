/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SexOriented;
import DAO.userAccountDAO;
import DTO.userAccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class InsertUser extends HttpServlet {

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
         String email =(String) request.getAttribute("user");
            String password =(String) request.getAttribute("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String birthdayS =request.getParameter("Birthday");
            String description = request.getParameter("description");
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(birthdayS);
        } catch (ParseException ex) {
            Logger.getLogger(InsertUser.class.getName()).log(Level.SEVERE, null, ex);
        }
            String phone = request.getParameter("Phone");
            String sex = request.getParameter("Sex");
            int genderID = 0;
            if(sex == "male"){
                genderID = 1;
            }else if(sex == "female"){
                genderID = 2;
            }else
                genderID =3;
            
            String[] hobbyList =request.getParameterValues("hobby");
            String SexOriented = request.getParameter("oriented");
            String [] photo = request.getParameterValues("picture");
            String [] interest = request.getParameterValues("interest");
            userAccountDAO UserDAO = new userAccountDAO();
            UserDAO.insertUser(firstName, lastName, email, password, genderID, description, birthdayS, phone);
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
