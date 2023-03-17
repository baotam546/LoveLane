<%@page import="DTO.RelationDTO"%>
<%@page import="DTO.InterestInRelationshipDTO"%>
<%@page import="DTO.LocationDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="DTO.HobbyDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>LoveLane</title>
        <link rel="stylesheet" href="css/Account-SignUp.css">
    </head>

    <body>
        <c:if test="${sessionScope.usersession == null}">
            <% response.sendRedirect("SignUp.jsp");%>
        </c:if>
        <img src="images/LovelaneLogo.png" alt="icon" class="brand-name">
        <hr>
        <div class="create-account">
            <h2 id="page-name">Create Account</h2>
            <form action="InsertUser" method="post" enctype='multipart/form-data'>
                <div class="left-input">
                    <label for="Name">First Name</label><br>
                    <input type="text" name="firstName" required><br>
                    <label for="Name">Last Name</label><br>
                    <input type="text" name="lastName" required><br>
                    <label for="Birthday">Birthday</label><br>
                    <input type="date" name="Birthday" required><br>
                    <label for="Sex">Sex</label><br>
                    <input type="radio" id="genderMale" name="Sex" value="male">
                    <label for="genderMale">Male</label>
                    <input type="radio" id="genderFemale" name="Sex" value="female">
                    <label for="genderFemale">Female</label>
                    <input type="radio" id="genderOthers" name="Sex" value="others">
                    <label for="genderOthers">Others</label><br>
                    <label for="description">Description</label><br>
                    <input type="text" class="description" name="description" required><br>
                </div>
                <div class="pictures">
                    <p class="option-title">Profile Pictures</p>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this,1)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture1" accept="image/*" onchange="previewImages()"/>+
                        </label>

                    </span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this,2)" type="button">x</button>
                        <label class="custom-file-upload">

                            <input type="file" name="picture2" accept="image/*" onchange="previewImages()" /> +

                        </label></span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this,3)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture3" accept="image/*" onchange="previewImages()" />+
                        </label></span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this,4)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture4" accept="image/*" onchange="previewImages()" />+
                        </label></span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this,5)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture5" accept="image/*" onchange="previewImages()" />+
                        </label></span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this,6)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture6" accept="image/*" onchange="previewImages()" />+
                        </label>
                    </span>

                    <input type="hidden" name="photo" value="">
                    <input type="hidden" name="photo" value="">
                    <input type="hidden" name="photo" value="">
                    <input type="hidden" name="photo" value="">
                    <input type="hidden" name="photo" value="">
                    <input type="hidden" name="photo" value="">
                </div>

                <h2 id="page-name">Option</h2>
                <%! ArrayList<HobbyDTO> list;%>
                <%list = (ArrayList<HobbyDTO>) request.getAttribute("hobbyList");%>

                <div class="specification">
                    <p class="option-title">Hobbies</p>
                    <div class="hobby">
                        <%
                            for (HobbyDTO hobby : list) {
                                out.print("<input type='checkbox' name='hobby' id= '" + hobby.getName() + "' value='" + hobby.getName() + "'>");
                                out.print("<label for='" + hobby.getName() + "'>" + hobby.getName() + "</label><br>");

                            }
                        %>



                    </div>
                </div>
                <div class="specification">
                    <p class="option-title">Sex-Oriented</p>
                    <input type="checkbox" id="male" name="oriented" value="1002">
                    <label for="male"> Male</label>
                    <input type="checkbox" id="female" name="oriented" value="1003">
                    <label for="female"> Female</label>
                    <input type="checkbox" id="others" name="oriented" value="1004">
                    <label for="others"> Others</label>
                </div>
                <div class="specification">
                    <p class="option-title">Interest in relationship</p>
                    <div class="hobby">
                        <%! ArrayList<RelationDTO> RelationList;%>
                        <% RelationList = (ArrayList<RelationDTO>) request.getAttribute("relationList");%>

                        <%
                            for (RelationDTO relation : RelationList) {
                                out.print("<input type='checkbox' name='interest' id= '" + relation.getName() + "' value='" + relation.getId() + "'>");
                                out.print("<label for='" + relation.getName() + "'>" + relation.getName() + "</label><br>");

                            }
                        %>
                    </div>
                </div>
                <div class="specification">
                    <p class="option-title">Location</p>
                    <div class="location">
                        <%! ArrayList<LocationDTO> locationList;%>
                        <% locationList = (ArrayList<LocationDTO>) request.getAttribute("locationList");%>

                        <%
                            for (LocationDTO location : locationList) {
                                out.print("<input type='radio' name='location' id= '" + location.getName() + "' value='" + location.getId() + "'>");
                                out.print("<label for='" + location.getName() + "'>" + location.getName() + "</label><br>");

                            }
                        %>
                    </div>
                </div>
                <input type="submit" name="" id="submit">

            </form>

        </div>
        <script src="js/CreateAccount.js"></script>
    </body>

</html>