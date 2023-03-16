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
            <form action="./CreateAccount" method="post">
                <div class="left-input">
                    <label for="Name">First Name</label><br>
                    <input type="text" name="firstName"><br>
                    <label for="Name">Last Name</label><br>
                    <input type="text" name="lastName"><br>
                    <label for="Birthday">Birthday</label><br>
                    <input type="date" name="Birthday"><br>
                    <label for="Phone">Phone Number</label><br>
                    <input type="text" name="Phone"><br>
                    <label for="Sex">Sex</label><br>
                    <input type="radio" name="Sex" value="male">Male
                    <input type="radio" name="Sex" value="female">Female
                    <input type="radio" name="Sex" value="others">Others<br>
                </div>
                <div class="pictures">
                    <p class="option-title">Profile Pictures</p>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture" accept="image/png, image/gif, image/jpeg" onchange="previewImages()" />+
                        </label>

                    </span>
                    
                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this)" type="button">x</button>
                        <label class="custom-file-upload">

                            <input type="file" name="picture" accept="image/png, image/gif, image/jpeg" onchange="previewImages()" /> +

                        </label></span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture" accept="image/png, image/gif, image/jpeg" onchange="previewImages()" />+
                        </label></span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture" accept="image/png, image/gif, image/jpeg" onchange="previewImages()" />+
                        </label></span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture" accept="image/png, image/gif, image/jpeg" onchange="previewImages()" />+
                        </label></span>

                    <span>
                        <img src="" alt="">
                        <button onclick="removeImage(this)" type="button">x</button>
                        <label class="custom-file-upload">
                            <input type="file" name="picture" accept="image/png, image/gif, image/jpeg" onchange="previewImages()" />+
                        </label>
                    </span>
                    <input type="hidden" value="" name="image">
                    <input type="hidden" value="" name="image">
                    <input type="hidden" value="" name="image">
                    <input type="hidden" value="" name="image">
                    <input type="hidden" value="" name="image">
                    <input type="hidden" value="" name="image">
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
                    <input type="checkbox" id="male" name="oriented" value="male">
                    <label for="male"> Male</label>
                    <input type="checkbox" id="female" name="oriented" value="female">
                    <label for="female"> Female</label>
                    <input type="checkbox" id="others" name="oriented" value="others">
                    <label for="everyone"> Others</label>
                </div>
                <div class="specification">
                    <p class="option-title">Interest in relationship</p>
                    <div class="hobby">
                        <input type="checkbox" id="new-friend" name="interest" value="new-friend">
                        <label for="new-friend"> New Friends</label><br>
                        <input type="checkbox" id="short-term" name="interest" value="short-term">
                        <label for="short-term"> Short-term Dating</label><br>
                        <input type="checkbox" id="long-term" name="interest" value="long-term">
                        <label for="long-term"> Long-term Dating</label><br>
                        <input type="checkbox" id="hookups" name="interest" value="hookups">
                        <label for="hookups"> Hookups</label><br>
                    </div>
                </div>
                <input type="submit" name="" id="submit">

            </form>

        </div>
        <script src="js/CreateAccount.js"></script>
    </body>

</html>