<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LoveLane</title>
    <link rel="stylesheet" href="./css/Account-SignUp.css">
</head>

<body>
    <img src="../Your First Project/icon.png" alt="icon" class="brand-name">
    <hr>
    <div class="create-account">
        <h2 id="page-name">Create Account</h2>
        <form action="">
            <div class="left-input">
                <label for="Name">Name</label><br>
                <input type="text" name="Name"><br>
                <label for="Birthday">Birthday</label><br>
                <input type="date" name="Birthday"><br>
                <label for="Sex">Sex</label><br>
                <input type="radio" name="Sex" value="male">Male
                <input type="radio" name="Sex" value="female">Female
                <input type="radio" name="Sex" value="Everyone">Everyone <br>
                <input type="checkbox" name="sexProfile" value="true">Display sex in profile
            </div>
            <div class="pictures">
                <p class="option-title">Profile Pictures</p>
                <span><label class="custom-file-upload">
                        <input type="file" />+
                    </label></span>
                <span><label class="custom-file-upload">
                        <input type="file" />+
                    </label></span>
                <span><label class="custom-file-upload">
                        <input type="file" />+
                    </label></span>
                <span><label class="custom-file-upload">
                        <input type="file" />+
                    </label></span>
                <span><label class="custom-file-upload">
                        <input type="file" />+
                    </label></span>
                <span><label class="custom-file-upload">
                        <input type="file" />+
                    </label></span>
            </div>
            <h2 id="page-name">Option</h2>
            <div class="specification">
                <p class="option-title">Interests</p>
                <input type="checkbox" id="music" name="interests" value="music">
                <label for="music"> Music</label><br>
                <input type="checkbox" id="swimming" name="interests" value="swimming">
                <label for="swimming"> Swimming</label><br>
                <input type="checkbox" id="fashion" name="interests" value="fashion">
                <label for="fashion"> Fashion</label><br>
            </div>
            <div class="specification">
                <p class="option-title">My Ideal Person</p>
                <input type="checkbox" id="male" name="ideal" value="male">
                <label for="male"> Male</label>
                <input type="checkbox" id="female" name="ideal" value="female">
                <label for="female"> Female</label>
                <input type="checkbox" id="everyone" name="ideal" value="everyone">
                <label for="everyone"> Everyone</label>
            </div>
            <div class="specification">
                <p class="option-title">Purpose</p>
                <input type="checkbox" id="new-friend" name="purpose" value="new-friend">
                <label for="new-friend"> New Friends</label><br>
                <input type="checkbox" id="short-term" name="purpose" value="short-term">
                <label for="short-term"> Short-term Dating</label><br>
                <input type="checkbox" id="long-term" name="purpose" value="long-term">
                <label for="long-term"> Long-term Dating</label><br>
                <input type="checkbox" id="hookups" name="purpose" value="hookups">
                <label for="hookups"> Hookups</label><br>
            </div>
            <input type="submit" name="" id="submit">

        </form>

    </div>

</body>

</html>