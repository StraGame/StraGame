<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Stragame</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/animate.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"> </head>

<body>
    <!--======== Navbar =======-->
    <div class="top-bar">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="navbar-menu-left-side239">
                        <ul>
                            <li><a href="logIn.html"><i class="fa fa-user" aria-hidden="true"></i>Login Area</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="navbar-serch-right-side">
                        <form class="navbar-form" role="search">
                            <div class="input-group add-on">
                                <input class="form-control form-control222" placeholder="Search" name="srch-term" id="srch-term" type="text">
                                <div class="input-group-btn">
                                    <button class="btn btn-default btn-default2913" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <!-- ==========header mega navbar=======-->
    <div class="top-menu-bottom932">
        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    <a class="navbar-brand" href="index.html"><img src="image/logo1.png" alt="Logo"  width="90" height="70"></a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav"> </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.html">Home</a></li>
                        <li class="dropdown"> <a href="user.html" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">Topic <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="topic.html" target="_self">Topic</a></li>
                                <li><a href="newTopic.html" target="_self">Inserisci nuovo topic</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Recensioni <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="review.html" target="_self">Recensioni</a></li>
                                <li><a href="newReview.html" target="_self">Inserisci nuova recensione</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bug <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="bug.html" target="_self">Bug</a></li>
                                <li><a href="newBug.html" target="_self">Segnala un bug</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"> <a href="user.html" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">News <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="news.html">News</a></li>
                                <li><a href="NewNews.html">Inserisci una News</a></li>
                            </ul>
                        </li>
                        <li><a href="user.html">Profile</a></li>
                        <li><a href="contact_us.html" target="_self">About Us</a></li>                        
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>
<section class="header-descriptin329">
                       <div class="container">
                       <h3>Inserisci nuova Recensione</h3>
                        <ol class="breadcrumb breadcrumb839">
  <li><a href="index.html">Home</a></li>
  <li class="active">Nuova recensione</li>
</ol>
    </div>
</section>
    <section class="main-content920">
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                <div class="ask-question-input-part032">
                    <h4>Nuova recensione</h4>
                    <hr>
                    <form>
                        <div class="username-part940">
                            <span class="form-description43">Titolo* </span><input type="text" name="fname" class="username029" placeholder="Scegli il titolo">  
                        </div>
                        <div class="categori49">
                            <span class="form-description43305">Videogioco* </span>
                            <label>
                                <input list="browsers" name="myBrowser" class="list-category53" placeholder="Scegli..."/>
                            </label>
                            <datalist id="browsers">
                                <option value="Front_End Web Developer">
                                <option value="Back-End develoer">
                                <option value="Andriod Developer">
                                <option value="Web Application">
                                <option value="System Analyst">
                                <option value="Security">
                            </datalist>
                        </div>
                        <div class="categori499">
                            <span class="form-description43355">Gameplay* </span>
                                <span class="star-ratingGP">
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="1"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="2"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="3"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="4"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="5"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="6"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="7"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="8"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="9"><i></i>
                                    <input type="radio" onclick="returnRatingGP()" name="ratingGP" value="10"><i></i>
                                </span>
                        </div>
                        <div class="categori499">
                            <span class="form-description43356">Trama* </span>
                                <span class="star-ratingT">
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="1"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="2"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="3"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="4"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="5"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="6"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="7"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="8"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="9"><i></i>
                                    <input type="radio" onclick="returnRatingT()" name="ratingT" value="10"><i></i>
                                </span>
                        </div>
                        <div class="categori499">
                            <span class="form-description43357">Grafica* </span>
                                <span class="star-ratingG">
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="1"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="2"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="3"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="4"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="5"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="6"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="7"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="8"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="9"><i></i>
                                    <input type="radio" onclick="returnRatingG()" name="ratingG" value="10"><i></i>
                                </span>
                        </div>
                        <div class="categori499">
                            <span class="form-description43358">Voto Complessivo* </span>
                                <span class="star-ratingVC">
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="1"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="2"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="3"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="4"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="5"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="6"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="7"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="8"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="9"><i></i>
                                    <input type="radio" onclick="returnRatingVC()" name="ratingVC" value="10"><i></i>
                                </span>
                        </div>
                        <div class="question-title39">
                            <span class="form-description43313">Descrizione* </span><textarea class="question-details3133" placeholder=""></textarea>
                        </div>
                        <div class="button-group-addfile3239">
                            <span class="form-description23993">Allegati</span><input type="file" name="ffile" class="question-ttile3226">
                        </div>
                        <script src="js/script.js"></script>
                    </form>
                    <div class="publish-button2389">
                        <button type="button" class="publis1291">Pubblica</button>
                    </div>
                </div>
            </div>
            <!--end of col-md-9 -->
           
            <!--strart col-md-3 (side bar)-->
            <aside class="col-md-3 sidebar97239">
                <!--              login part-->
                <div class="login-part2389">
                    <h4>Login</h4>
                    <div class="input-group300"> <span><i class="fa fa-user" aria-hidden="true"></i></span>
                        <input type="text" class="namein309" placeholder="e-mail"> </div>
                    <div class="input-group300"> <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                        <input type="password" class="passin309" placeholder="password"> </div>
                    <a href="#">
                        <button type="button" class="userlogin320">Log In</button>
                    </a>
                    <div class="rememberme">
                        <label>
                            <input type="checkbox" checked="checked"> Remember Me</label> <a href="signup.html" class="resbutton3892">Register</a> </div>
                </div>
                
                <!--        start recent post  -->
                <div class="recent-post3290">
                    <h4>Ultime news</h4>
                    <div class="post-details021"> <a href="#"><h5>How much do web developers</h5></a>
                        <p>I am thinking of pursuing web developing as a career & was ...</p> <small style="color: #848991">July 16, 2017</small> </div>
                    <hr>
                    <div class="post-details021"> <a href="#"><h5>How much do web developers</h5></a>
                        <p>I am thinking of pursuing web developing as a career & was ...</p> <small style="color: #848991">July 16, 2017</small> </div>
                    <hr>
                    <div class="post-details021"> <a href="#"><h5>How much do web developers</h5></a>
                        <p>I am thinking of pursuing web developing as a career & was ...</p> <small style="color: #848991">July 16, 2017</small> </div>
                </div>
                <!--       end recent post    -->
            </aside>
            </div>
        </div>
    </section>
    
<!--    footer -->
<div class="footer-search">
    <div class="container">
        
    </div>
</div>
<section class="footer-part">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="info-part-one320">
                    <h4>Chi siamo</h4>
                    <p>Siamo un gruppo di programmatori, e stiamo creando questo forum</p>
                    <h4>Team</h4>
                    <p>Mario Maffettone
                        <br> Carmine Laudato
                        <br> Vincenzo Iovino
                        <br> Umberto Mauro</p>
                    <h4>Supporto :</h4>
                    <p>Supporto Email:
                    <br>stragame@live.com</p>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="info-part-three320">
                </div>
            </div>
            <div class="col-md-3">
                <div class="info-part-three320">
                </div>
            </div>
            <div class="col-md-3">
                <div class="info-part-two320">
                    <h4>Quick Links</h4>
                    <a href="index.html">
                        <p>-Home</p>
                    </a>
                    <a href="topic.html">
                        <p>-Topic</p>
                    </a>
                    <a href="review.html">
                        <p>-Recensioni</p>
                    </a>
                    <a href="bug.html">
                        <p>-Bug</p>
                    </a>
                    <a href="#">
                        <p>-News</p>
                    </a>
                    <a href="user.html">
                        <p>-Profie</p>
                    </a>
                    <a href="contact_us.html">
                        <p>-About Us</p>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="footer-social">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <p>Copyright 2021 | <b><strong>Stragame</strong></b></p>
            </div>
            <div class="col-md-6">
                <div class="social-right2389"> <a href="#"><i class="fa fa-twitter-square" aria-hidden="true"></i></a> <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a> <a href="#"><i class="fa fa-youtube" aria-hidden="true"></i></a> <a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a> <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a> <a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a> </div>
            </div>
        </div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/npm.js"></script>
</body>

</html>