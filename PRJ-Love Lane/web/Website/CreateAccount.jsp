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
    <img src="images/LovelaneLogo.png" alt="icon" class="brand-name">
    <hr>
    <div class="create-account">
        <h2 id="page-name">Create Account</h2>
        <form action="./CreateAccount">
            <div class="left-input">
                <label for="Name">Name</label><br>
                <input type="text" name="Name"><br>
                <label for="Birthday">Birthday</label><br>
                <input type="date" name="Birthday"><br>
                <label for="Phone">Phone Number</label><br>
                <input type="text" name="Phone"><br>
                <label for="Sex">Sex</label><br>
                <input type="radio" name="Sex" value="male">Male
                <input type="radio" name="Sex" value="female">Female
                <input type="radio" name="Sex" value="Everyone">Everyone <br>
            </div>
            <div class="pictures">
                <p class="option-title">Profile Pictures</p>

                <span>
                    <img src="" alt="">
                    <button onclick="removeImage(this)" type="button">-</button>
                    <label class="custom-file-upload">
                        <input type="file" name="picture1" accept="image/*" onchange="previewImages()" />+
                    </label>

                </span>

                <span>
                    <img src="" alt="">
                    <button onclick="removeImage(this)" type="button">-</button>
                    <label class="custom-file-upload">

                        <input type="file" name="picture2" accept="image/*" onchange="previewImages()" /> +

                    </label></span>

                <span>
                    <img src="" alt="">
                    <button onclick="removeImage(this)" type="button">-</button>
                    <label class="custom-file-upload">
                        <input type="file" name="picture3" accept="image/*" onchange="previewImages()" />+
                    </label></span>

                <span>
                    <img src="" alt="">
                    <button onclick="removeImage(this)" type="button">-</button>
                    <label class="custom-file-upload">
                        <input type="file" name="picture4" accept="image/*" onchange="previewImages()" />+
                    </label></span>

                <span>
                    <img src="" alt="">
                    <button onclick="removeImage(this)" type="button">-</button>
                    <label class="custom-file-upload">
                        <input type="file" name="picture5" accept="image/*" onchange="previewImages()" />+
                    </label></span>

                <span>
                    <img src="" alt="">
                    <button onclick="removeImage(this)" type="button">-</button>
                    <label class="custom-file-upload">
                        <input type="file" name="picture6" accept="image/*" onchange="previewImages()" />+
                    </label>
                </span>

            </div>
            <h2 id="page-name">Option</h2>
            <div class="specification">
                <p class="option-title">Hobbies</p>
                <div class="hobby">
                    <input type="checkbox" id="music" name="hobby" value="music">
                    <label for="music"> Music </label><br>
                    <input type="checkbox" id="swimming" name="hobby" value="swimming">
                    <label for="swimming"> Swimming </label><br>
                    <input type="checkbox" id="fashion" name="hobby" value="fashion">
                    <label for="fashion"> Fashion </label><br>
                </div>
            </div>
            <div class="specification">
                <p class="option-title">Sex-Oriented</p>
                <input type="checkbox" id="male" name="oriented" value="male">
                <label for="male"> Male</label>
                <input type="checkbox" id="female" name="oriented" value="female">
                <label for="female"> Female</label>
                <input type="checkbox" id="everyone" name="oriented" value="everyone">
                <label for="everyone"> Everyone</label>
            </div>
            <div class="specification">
                <p class="option-title">Interest in relationship</p>
                <input type="checkbox" id="new-friend" name="interest" value="new-friend">
                <label for="new-friend"> New Friends</label><br>
                <input type="checkbox" id="short-term" name="interest" value="short-term">
                <label for="short-term"> Short-term Dating</label><br>
                <input type="checkbox" id="long-term" name="interest" value="long-term">
                <label for="long-term"> Long-term Dating</label><br>
                <input type="checkbox" id="hookups" name="interest" value="hookups">
                <label for="hookups"> Hookups</label><br>
            </div>
            <input type="submit" name="" id="submit">

        </form>

    </div>
    <script src="js/CreateAccount.js"></script>
</body>

</html>