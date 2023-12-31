/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.userAccountDAO;
import DTO.userAccountDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class LoginController extends HttpServlet {

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
        /* TODO output your page here. You may use following sample code. */
        try {
            String action = request.getParameter("action");
            String user = request.getParameter("user");
            String password = request.getParameter("password");

//            RequestDispatcher rd1 = request.getRequestDispatcher("menu.html");
//            rd1.include(request, response);
            if (action != null && action.equals("logout")) {
                HttpSession session = request.getSession(false);

                if (session != null) {
                    session.invalidate();
                }

            } else {

                log("Debug user : " + user + " " + password);

                if (user == null && password == null) {

                    log("Debug user : Go to login " + user + " " + password);
                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                } else if (user != null && password != null) {

                    log("Debug user : Go to here " + user + " " + password);
                    userAccountDAO userDAO = new userAccountDAO();
                    userAccountDTO userDTO = userDAO.login(user, password);

                    if (userDTO != null) {
                        HttpSession session = request.getSession(true);
                        userDTO = userDAO.getUserByID(userDAO.getUserIDByEmail(user));
                        session.setAttribute("currentUserID", userDAO.getUserIDByEmail(user));
                        session.setAttribute("currentUser", userDTO);
                        response.sendRedirect("HomePageController");

                    } else if (userDTO == null) {
                        request.setAttribute("error", "Wrong username or password");
                        RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
