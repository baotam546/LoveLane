/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InterestInHobbyDAO;
import DAO.InterestInRelationshipDAO;
import DAO.LocationDAO;
import DAO.RelationDAO;
import DAO.SexOriented;
import DAO.SuggestDAO;
import DAO.photoDAO;
import DAO.userAccountDAO;
import DTO.userAccountDTO;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ACER
 */
@MultipartConfig
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
        final PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        userAccountDTO user = (userAccountDTO) session.getAttribute("usersession");
        String email = user.getEmail();
        writer.println(email);
        String password = user.getPassword();
        writer.println(password);
        String firstName = request.getParameter("firstName");
        writer.println(firstName);
        String lastName = request.getParameter("lastName");
        writer.println(lastName);
        String birthdayS = request.getParameter("Birthday");
        writer.println(birthdayS);
        String description = request.getParameter("description");
        writer.println(description);
        
        //get location by LoationID
        String location_raw = request.getParameter("location");
        int locationID = Integer.parseInt(location_raw);
        LocationDAO loDAO = new LocationDAO();
        String location = loDAO.getLocationByID(locationID);

        //get gender ID
        String sex = request.getParameter("Sex");
        writer.println(sex);
        
        int genderID = 0;
        if (sex.equals("male")) {
            genderID = 1002;
        } else if (sex.equals("female")) {
            genderID = 1003;
        } else {
            genderID = 1004;
        }
        
        //insert user account
        userAccountDAO UserDAO = new userAccountDAO();
        userAccountDTO userAccount = new userAccountDTO(firstName, lastName, email, password, description, genderID, birthdayS, location);
        UserDAO.insertUser(firstName, lastName, email, password, genderID, location, birthdayS, description);
        
        //get user id by email
        int user_id = UserDAO.getUserIDByEmail(email);
        
        //insert to interest in hobby
        String[] hobbyList = request.getParameterValues("hobby");
        InterestInHobbyDAO hobbyDAO = new InterestInHobbyDAO();
        hobbyDAO.insertHobby(hobbyList, user_id);
        
        //insert sex oriented
        String[] oriented_raw = request.getParameterValues("oriented");
        int[] oriented = new int[oriented_raw.length];
        for (int i = 0; i < oriented_raw.length; i++) {
            oriented[i] = Integer.parseInt(oriented_raw[i]);
        }
        SexOriented.insertSexOriendted(user_id, oriented);
        
        //insert to interest in relationship
        String[] interest_raw = request.getParameterValues("interest");
        int[] interest = new int[interest_raw.length];
        
        for (int i = 0; i < interest_raw.length; i++) {
            interest[i] = Integer.parseInt(interest_raw[i]);
        
        }
        RelationDAO relationDAO = new RelationDAO();
        String[] relation = relationDAO.getRelationListByIDs(interest);
        InterestInRelationshipDAO iiDAO = new InterestInRelationshipDAO();
        iiDAO.insertRelationship(user_id, relation);
       
        //insert image link to database
        String[] insertedPhotos = request.getParameterValues("photo");
        ArrayList<String> Photos = new ArrayList<>();
        for(String p : insertedPhotos){
            if(!p.equals("")) Photos.add(p);
        }
        photoDAO PhotoDAO = new photoDAO();
        for(String p : Photos){
            PhotoDAO.insertPhoto(user_id, user_id+"_"+p);
        }
        //run suggestion for user
        SuggestDAO suggest = new SuggestDAO();
        suggest.suggest();
        
        //Create new user session
        session = request.getSession(true);
        session.setAttribute("currentUserID", user_id);
        session.setAttribute("currentUser", userAccount);
        response.sendRedirect("HomePageController");
        
        //insert image to disk
        for (int i = 1; i <= 6; i++) {
            uploadPhoto(request, response, i, user_id);
        }

    }

    protected void uploadPhoto(HttpServletRequest request,
            HttpServletResponse response, int imageNum, int userID)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Create path components to save the file
        final String path = Query.Query.UPLOAD_FILE_PATH;
        final Part filePart = (Part) request.getPart("picture" + imageNum);

        final String fileName = userID + "_" + imageNum + ".png";

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                    new Object[]{fileName, path});
        } catch (FileNotFoundException fne) {

            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                    new Object[]{fne.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

    }

//    public void uploadImage(HttpServletRequest request, HttpServletResponse response, int imageNum, int user_id) 
//            throws ServletException, IOException {
//        Part photo = request.getPart("picture"+imageNum);
//        String fileName = user_id+"_"+imageNum+".png";
//        request.setAttribute("file", photo);
//        request.setAttribute("fileName", fileName);
//        RequestDispatcher rd = request.getRequestDispatcher("upload");
//        rd.include(request, response);
//    }
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
