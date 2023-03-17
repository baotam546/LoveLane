<%-- 
    Document   : SignUp
    Created on : Feb 25, 2023, 8:33:35 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/Account-SignUp.css">
        <title>LoveLane</title>
    </head>
    <body>
        <img src="./images/LovelaneLogo.png" alt="icon" class="brand-name">
        <hr>     
        <%! String err; %>
            <% err = (String) request.getAttribute("error");
            if (err != null) {
                out.println("<h2 style='color:red; text-align : center;'>"+err+"</h2>"); 
            }%>
            
        <div class="sign-up">
            <form action="./SignUpController" autocomplete="off" method="post" >
                <h2 id="title">Sign Up</h2>
                
                
                <input type="email" name="email" placeholder="Email" autocomplete="off"><br>
                <input type="password" name="password" placeholder="Password" autocomplete="off">
                <p>Already have an account please <a href="#">Login</a></p>
                <input type="submit" id="submit" value="Submit">
            </form>
            
        </div>
    </body>
</html>
