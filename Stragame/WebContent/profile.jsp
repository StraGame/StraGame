<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%  String ut=(String) request.getSession().getAttribute("username");
   Boolean adm= (Boolean) session.getAttribute("adminRoles");
   %>
   
   <% String nome = (String) request.getAttribute("nome"); %>
   <% String cognome = (String) request.getAttribute("cognome"); %>
   <% String email = (String) request.getAttribute("email"); %>
   <% String descrizione = (String) request.getAttribute("descrizione"); %>
   
<!DOCTYPE html>
<html lang="it">

<% if(nome==null){
	response.sendRedirect("./UserServlet");
	return;
}  %>

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
                        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">News <span class="caret"></span></a>
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

    <!-- ======breadcrumb ======-->
    <section class="header-descriptin329">
        <div class="container">
            <h3>User Deatils</h3>
            <ol class="breadcrumb breadcrumb839">
                <li><a href="index.html">Home</a></li>
                <li class="active">User Details</li>
            </ol>
        </div>
    </section>
    <section class="main-content920">
        <div class="container">
            <div class="row">
                <!--    body content-->
                <div class="col-md-9">
                    <div class="about-user2039">
                        <div class="user-title3930">
                            <h3>About <a href="#"><%=ut%></a>
                     
                        </h3>
                            <hr> </div>
                        <div class="user-image293"> <img src="image/images.png" alt="Image"> </div>
                        <span class="change-image"><a href="#">Cambia immagine</a><input type="file" /></span>
                        <div class="user-list10039">
                            <div class="ul-list-user-left">
                                <ul>
                                    <li><p name="nome">&#9757 <strong>Nome:</strong> <%=nome %></p></li>
                                    <li><p name="cognome">&#9996 <strong>Cognome:</strong> <%=cognome %></p></li>
                                    <li><p name="username" >&#9997 <strong>Nickname:</strong> <%=ut %></p></li>
                                    <li><p name="email">&#128231 <strong>E-mail:</strong> <%=email %></p></li>
                                    <li>&#128271 <strong>Password:</strong><a href="changePassword.jsp" class="change-password">cambia password</a></li>
                                </ul>
                            </div>
                        </div>
                        <form id="form" action="UserServlet?action=insertDescription" method="post">
	                        <div class="user-description303">
	                            <textarea class="description" name="chagedesciption"><%=descrizione.toString()%></textarea> 
	                            <input class="change-description" type = "submit" value="Modifica descrizione"/>
							</div>
                        </form>
                    </div>
                    
                    
                </div>
                <!--                end of col-md-9 -->
                <!--           strart col-md-3 (side bar)-->
                <aside class="col-md-3 sidebar97239">
                    
                    
                    <!--              login part-->
                    <div class="login-part2389">
                        <h4>Login</h4>
                        <div class="input-group300"> <span><i class="fa fa-user" aria-hidden="true"></i></span>
                            <input type="text" class="namein309" placeholder="email"> </div>
                        <div class="input-group300"> <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                            <input type="password" class="passin309" placeholder="password"> </div>
                        <a href="#">
                            <button type="button" class="userlogin320">Log In</button>
                        </a>
                        <div class="rememberme">
                            <label>
                                <input type="checkbox" checked="checked"> Ricordami</label> <a href="signUp.jsp" class="resbutton3892">Registrati</a> </div>
                    </div>
                    <!--              highest part-->
                    
                    
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
                        <p>-Profile</p>
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


    