<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%  String ut=(String) request.getSession().getAttribute("username");
   Boolean adm= (Boolean) session.getAttribute("adminRoles");
   %>
   
   
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
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://emoji-css.afeld.me/emoji.css" rel="stylesheet"> </head>

<body>
    <!--======== Navbar =======-->
    <div class="top-bar">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="navbar-menu-left-side239">
                        <ul>
                            <li><a href="logIn.jsp"><i class="fa fa-user" aria-hidden="true"></i>Login Area</a></li>
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
                    <a class="navbar-brand" href="index.jsp"><img src="image/logo1.png" alt="Logo"  width="90" height="70"></a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav"> </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.jsp">Home</a></li>
                        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">Topic <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="topic.jsp" target="_self">Topic</a></li>
                                <li><a href="newTopic.jsp" target="_self">Inserisci nuovo topic</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Recensioni <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="review.jsp" target="_self">Recensioni</a></li>
                                <li><a href="newReview.jsp" target="_self">Inserisci nuova recensione</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bug <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="bug.jsp" target="_self">Bug</a></li>
                                <li><a href="newBug.jsp" target="_self">Segnala un bug</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"> <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">News <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="news.jsp">News</a></li>
                                <li><a href="newNews.jsp">Inserisci una News</a></li>
                            </ul>
                        </li>
                        <li><a href="profile.jsp">Profile</a></li>
                        <li><a href="contactUs.jsp" target="_self">About Us</a></li>                        
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>
    
    
    <!--======= welcome section on top background=====-->
    <section class="welcome-part-one">
        <div class="container">
                <div class="form-style8292">
                <div class="input-group"> <span class="input-group-addon"><i class="fa fa-pencil-square" aria-hidden="true"></i></span>
                    <input type="text" class="form-control form-control8392" placeholder="Ask any question and you be sure find your answer ?"> <span class="input-group-addon"><a href="#">Ask Now</a></span> </div>
            </div>
        </div>
    </section>
    
    
    <!-- ======content section/body=====-->
    <section class="main-content920">
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <div id="main">
                        <input id="tab1" type="radio" name="tabs" checked>
                        <label for="tab1">Videogame</label>
                        <input id="tab2" type="radio" name="tabs">
                        <label for="tab2">Ultimi Topic</label>
                        <input id="tab3" type="radio" name="tabs">
                        <label for="tab3">Ultime recensioni</label>
                        <input id="tab4" type="radio" name="tabs">
                        <label for="tab4">Ultime segnalazioni</label>
                        
                        <section id="content1">
                               <!--Recent Question Content Section -->
                            <div class="question-typegame">
                                <ul id="griglia">
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/division2.jpg" width="100" height="160"><p class="testogiochi">Tom Clancy's The Division 2</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/farcry5.jpg" width="100" height="160"><p class="testogiochi">Far Cry 5</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/immortals.jpg" width="100" height="160"><p class="testogiochi">Immortals Fenyx Rising</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/legion.jpg" width="100" height="160"><p class="testogiochi">Watch Dogs: Legion</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/odyssey.jpg" width="100" height="160"><p class="testogiochi">Assassin's Creed Odissey</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/rainbow.jpg" width="100" height="160"><p class="testogiochi">Tom Clancy's Rainbow Six Siege</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/valhalla.jpg" width="100" height="160"><p class="testogiochi">Assassin's Creed Valhalla</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/crew2.jpg" width="100" height="160"><p class="testogiochi">The Crew 2</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/mario.jpg" width="100" height="160"><p class="testogiochi">Mario + Rabbids Kingdom Battle</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/scontridiretti.jpg" width="100" height="160"><p class="testogiochi"> Park Scontri Di Retti</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/starlink.jpg" width="100" height="160"><p class="testogiochi">Starlink Battle for Atlas</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/farcry4.jpg" width="100" height="160"><p class="testogiochi">Far Cry 4</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/hyperscape.jpg" width="100" height="160"><p class="testogiochi">Hyper Scape</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/rabbidscoding.jpg" width="100" height="160"><p class="testogiochi">Rabbids Coding</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/anno1800.jpg" width="100" height="160"><p class="testogiochi">Anno 1800</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/startreckbridgecrew.jpg" width="100" height="160"><p class="testogiochi">Star Trek: Bridge Crew</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/assassincreedrogue.jpg" width="100" height="160"><p class="testogiochi">Assassin's Creed Rogue</p></a></li>
                                    <li><a href="videogamePubblication.jsp"><img src="image/Giochi/farcryprimal.jpg" width="100" height="160"><p class="testogiochi">Far Cry Primal</p></a></li>
                                    </ul>
                            </div>
                        </section>
                        <!--  End of content-1------>
                        
                        <section id="content2">
                           <!--Most Response Content Section -->
                            <div class="question-type2033">
                                <div class="row">
                                    <div class="col-md-1">
                                    <div class="left-user12923 left-user12923-repeat">
                                        <a href="#"><img src="image/images.png" alt="image"> </a>
                                    </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="right-description893">
                                            <div id="que-hedder2983">
                                                <span class="label utente">&#128100 NomeUtente</span>
                                                <span class="label videogioco">&#127918 TitoloVideogioco</span>
                                                <h3><a href="topicDetails.jsp" target="_self">Titolo Primo Topic</a></h3> </div>
                                            <div class="ques-details10018">
                                                <p>Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.</p>
                                            </div>
                                            <hr>
                                           <div class="clockcomment"> &#128336 Ultimo commento: 15/01/2021 10:58</div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="ques-type302">
                                                <br>
                                                <br>
                                                <span class="label like">&#128172 333</span>
                                                <hr>
                                                <span class="label comment">&#128077 333</span>
                                        </div>
                                    </div>
                                </div>
                            </div>                         
                        </section>
                        
                        <!----end of content-2----->
                        
                        <section id="content3">
                              <!--Recently answered Content Section -->
                            <div class="question-type2033">
                                <div class="row">
                                    <div class="col-md-1">
                                    <div class="left-user12923 left-user12923-repeat">
                                        <a href="#"><img src="image/images.png" alt="image"> </a>
                                    </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="right-description893">
                                            <div id="que-hedder2983">
                                                <span class="label utente">&#128100 NomeUtente</span>
                                                <span class="label videogioco">&#127918 TitoloVideogioco</span>
                                                <h3><a href="reviewDetails.jsp" target="_self">Titolo Prima Recensione</a></h3> </div>
                                            <div class="ques-details10018">
                                                <p>Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.</p>
                                            </div>
                                            <hr>
                                            <div class="clockcomment"> &#128336 Ultimo commento: 15/01/2021 10:58</div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="ques-type302">
                                                <br>
                                                <br>
                                                <span class="label like">&#128172 333</span>
                                                <hr>
                                                <span class="label comment">&#128077 333</span>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                              
                            <div class="question-type2033">
                                <div class="row">
                                    <div class="col-md-1">
                                    <div class="left-user12923 left-user12923-repeat">
                                        <a href="#"><img src="image/images.png" alt="image"> </a>
                                    </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="right-description893">
                                            <div id="que-hedder2983">
                                                <span class="label utente">&#128100 NomeUtente</span>
                                                <span class="label videogioco">&#127918 TitoloVideogioco</span>
                                                <h3><a href="reviewDetails.jsp" target="_self">Titolo seconda Recensione</a></h3> </div>
                                            <div class="ques-details10018">
                                                <p>Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.</p>
                                            </div>
                                            <hr>
                                            <div class="clockcomment"> &#128336 Ultimo commento: 15/01/2021 10:58</div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="ques-type302">
                                                <br>
                                                <br>
                                                <span class="label like">&#128172 333</span>
                                                <hr>
                                                <span class="label comment">&#128077 333</span>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                        </section>
                        <!--End content-3 -->
                        
                        
                        
                        <section id="content4">
                        <!--No answered Content Section -->
                            <div class="question-type2033">
                                <div class="row">
                                    <div class="col-md-1">
                                    <div class="left-user12923 left-user12923-repeat">
                                        <a href="#"><img src="image/images.png" alt="image"> </a>
                                    </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="right-description893">
                                            <div id="que-hedder2983">
                                                <span class="label utente">&#128100 NomeUtente</span>
                                                <span class="label videogioco">&#127918 TitoloVideogioco</span>
                                                <span class="label categoria">Categoria</span>
                                                <h3><a href="bugDetails.jsp" target="_self">Titolo Segnalazione Bug</a></h3> </div>
                                            <div class="ques-details10018">
                                                <p>Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.</p>
                                            </div>
                                            <hr>
                                            <div class="clockcomment"> &#128336 Inserito il: 15/01/2021 10:58</div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="ques-type302">
                                        </div>
                                    </div>
                                </div>
                            </div>

                              <!--Recent Question Content Section -->
                            <div class="question-type2033">
                                <div class="row">
                                    <div class="col-md-1">
                                    <div class="left-user12923 left-user12923-repeat">
                                        <a href="#"><img src="image/images.png" alt="image"> </a>
                                    </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="right-description893">
                                            <div id="que-hedder2983">
                                                <span class="label utente">&#128100 NomeUtente</span>
                                                <span class="label videogioco">&#127918 TitoloVideogioco</span>
                                                <span class="label categoria">Categoria</span>
                                                <h3><a href="bugDetails.jsp" target="_self">Titolo Segnalazione Bug</a></h3> </div>
                                            <div class="ques-details10018">
                                                <p>Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis.</p>
                                            </div>
                                            <hr>
                                            <div class="clockcomment"> &#128336 Inserito il: 15/01/2021 10:58</div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="ques-type302">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--End of content-5-->
                        </section>
               
                    </div>
                </div>
                <!--end of col-md-9 -->
                <!--strart col-md-3 (side bar)-->
                <aside class="col-md-3 sidebar97239">
                    <!--              login part-->
                    <% if (ut==null){ %>
                    <div class="login-part2389">
                        <h4>Login</h4>
                        <form action = "LoginServlet" method = "POST">
                        <div class="input-group300"> <span><i class="fa fa-user" aria-hidden="true"></i></span>
                            <input type="text" id="username" name="username" class="namein309" placeholder="username"> </div>
                        <div class="input-group300"> <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                            <input type="password" id="password" name="password" class="passin309" placeholder="password"> </div>
                        <a href="#">
                            <button type="Submit" class="userlogin320">Log In</button>
                        </a>
                        
                        </form>
                        <div class="rememberme">
                            <label>
                                <input type="checkbox" checked="checked"> Remember Me</label> <a href="signUp.jsp" class="resbutton3892">Register</a> </div>
                    </div>
                    
                    	<%} else  { %>
	
	<td id="spaziologout"></td>
	<td>
	<form action="LogoutServlet" method="POST" >
	<button type="Submit" class="btn btn-dark" > Logout</button>
	</form>
	</td>
	
	<%} %>
                    
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
                        <a href="index.jsp">
                            <p>-Home</p>
                        </a>
                        <a href="topic.jsp">
                            <p>-Topic</p>
                        </a>
                        <a href="review.jsp">
                            <p>-Recensioni</p>
                        </a>
                        <a href="bug.jsp">
                            <p>-Bug</p>
                        </a>
                        <a href="news.jsp">
                            <p>-News</p>
                        </a>
                        <a href="profile.jsp">
                            <p>-Profie</p>
                        </a>
                        <a href="contactUs.jsp">
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