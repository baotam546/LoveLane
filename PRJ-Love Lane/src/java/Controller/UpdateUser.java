package Controller;

import DAO.InterestInHobbyDAO;
import DAO.InterestInRelationshipDAO;
import DAO.LocationDAO;
import DAO.RelationDAO;
import DAO.SexOriented;
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
 * Servlet implementation class UpdateUser
 */
@MultipartConfig
public class UpdateUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        userAccountDTO user = (userAccountDTO) session.getAttribute("usersession");
        int userID = user.getUserID();
        String email = user.getEmail();
        writer.println(email);
        String password = user.getPassword();
        writer.println(password);
        
        // Retrieve fields that were modified by the user
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthdayS = request.getParameter("Birthday");
        String description = request.getParameter("description");
        String location_raw = request.getParameter("location");
        int locationID = Integer.parseInt(location_raw);
        String sex = request.getParameter("Sex");
        String[] hobbyList = request.getParameterValues("hobby");
        String[] oriented_raw = request.getParameterValues("oriented");
        String[] interest_raw = request.getParameterValues("interest");
        String[] insertedPhotos = request.getParameterValues("photo");

        // Get existing user account data
        userAccountDAO UserDAO = new userAccountDAO();
        userAccountDTO userAccount = UserDAO.getUserByID(userID);
  
        // Update fields in user account DTO and database
        if (!firstName.equals("")) {
            userAccount.setFirstName(firstName);
            UserDAO.updateUser(userID, "first_name", firstName);
        }
        if (!lastName.equals("")) {
            userAccount.setLastName(lastName);
            UserDAO.updateUser(userID, "last_name", lastName);
        }
        if (!birthdayS.equals("")) {
            userAccount.setBirthday(birthdayS);
            UserDAO.updateUser(userID, "birthday", birthdayS);
        }
        if (!description.equals("")) {
            userAccount.setDescription(description);
            UserDAO.updateUser(userID, "description", description);
        }
        if (locationID != 0) {
            LocationDAO loDAO = new LocationDAO();
            String location = loDAO.getLocationByID(locationID);
            userAccount.setLocation(location);
            UserDAO.updateUser(userID, "location", location);
        }
        if (!sex.equals("")) {
            int genderID = 0;
            if (sex.equals("male")) {
                genderID = 1002;
            } else if (sex.equals("female")) {
                genderID = 1003;
            } else {
                genderID = 1004;
            }
            userAccount.setGender(genderID);
            UserDAO.updateUser(userID, "gender_id", String.valueOf(genderID));
        }
        
        // Update interests
        if (hobbyList != null) {
            InterestInHobbyDAO hobbyDAO = new InterestInHobbyDAO();
            hobbyDAO.updateHobby(hobbyList, userID);
        }
        if (oriented_raw != null) {
            int[] oriented = new int[oriented_raw.length];
            for (int i = 0; i < oriented_raw.length; i++) {
                oriented[i] = Integer.parseInt(oriented_raw[i]);
            }
            SexOriented.insertSexOriendted(userID, oriented);
        }
        if (interest_raw != null) {
            int[] interest = new int[interest_raw.length];

            for (int i = 0; i < interest_raw.length; i++) {  interest[i] = Integer.parseInt(interest_raw[i]);
        }

        InterestInRelationshipDAO interestDAO = new InterestInRelationshipDAO();
        interestDAO.updateInterest(interest, userID);
    }
    
    // Delete existing photos
    if (insertedPhotos != null) {
        photoDAO photoDAO = new photoDAO();
        for (String photoName : insertedPhotos) {
            int photoID = photoDAO.getPhotoIDByName(photoName, userID);
            if (photoID != 0) {
                String photoPath = getServletContext().getRealPath("/") + "images/" + photoName;
                File file = new File(photoPath);
                if (file.exists()) {
                    file.delete();
                }
                photoDAO.deletePhoto(photoID);
            }
        }
    }
    
    // Update existing photos or upload new ones
    ArrayList<String> photoNames = new ArrayList<>();
    for (Part part : request.getParts()) {
        String fileName = getFileName(part);
        if (!fileName.equals("")) {
            InputStream inputStream = part.getInputStream();
            OutputStream outputStream = new FileOutputStream(getServletContext().getRealPath("/") + "images/" + fileName);

            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            photoNames.add(fileName);
        }
    }

    if (!photoNames.isEmpty()) {
        photoDAO photoDAO = new photoDAO();
        for (String photoName : photoNames) {
            int photoID = photoDAO.getPhotoIDByName(photoName, userID);
            if (photoID == 0) {
                photoDAO.insertPhoto(photoName, userID);
            } else {
                photoDAO.updatePhoto(photoID, photoName);
            }
        }
    }
    
    response.sendRedirect("userProfile.jsp");
}

private String getFileName(Part part) {
    String contentDispositionHeader = part.getHeader("content-disposition");
    String[] elements = contentDispositionHeader.split(";");
    for (String element : elements) {
        if (element.trim().startsWith("filename")) {
            return element.substring(element.indexOf("=") + 1).trim().replace("\"", "");
        }
    }
    return "";
}
}