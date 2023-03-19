/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SuggestDAO;
import DAO.photoDAO;
import DAO.userAccountDAO;
import DTO.userAccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
public class HomePageController extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        int id = (Integer) session.getAttribute("currentUserID");
        userAccountDTO currentUser = (userAccountDTO) session.getAttribute("currentUser");
        if (id == 0 || currentUser == null) {
            response.sendRedirect("HomePage.jsp");
        } else {
            int viewNumber = 0;
            String action = request.getParameter("action");
            if (session.getAttribute("viewNumber") == null) {
                session.setAttribute("viewNumber", viewNumber);
            }
            if (session.getAttribute("viewNumber") != null && action != null) {
                viewNumber = (int) session.getAttribute("viewNumber");
                viewNumber++;
            }
            //get users id of suggestion
            SuggestDAO suggestDAO = new SuggestDAO();
            List<Integer> userIDList = suggestDAO.getSuggestionList(id);
            //get users list by their id
            List<userAccountDTO> userList = new ArrayList<>();
            for (int i : userIDList) {
                userAccountDAO userDAO = new userAccountDAO();
                userAccountDTO user = userDAO.getUserByID(i);
                userList.add(user);
            }
            if (viewNumber >= userIDList.size()) {
                request.setAttribute("error", "You reached the end :((");
                request.getRequestDispatcher("theEnd.jsp").forward(request, response);
            }
            //get photos based on view number
            photoDAO photoDAO = new photoDAO();
            
            List<String> photoLinks = photoDAO.getUserPhotoLinkByID(userIDList.get(viewNumber));
            //get the user infomation
            userAccountDTO user = userList.get(viewNumber);
            //Update view number
            session.setAttribute("viewNumber", viewNumber);
            
            
            session.setAttribute("userInfo", user);
            session.setAttribute("links", photoLinks);

            PrintWriter p = response.getWriter();
            p.println(viewNumber);
            p.println(user);
            p.println(photoLinks);
            RequestDispatcher rd = request.getRequestDispatcher("UserPage.jsp");
            rd.forward(request, response);

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
