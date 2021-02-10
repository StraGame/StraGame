<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% String label = (String) request.getAttribute("label");%>
	<%if(label==null){
		label="";}%>

	
	<% String ut=(String) request.getSession().getAttribute("username");
	Boolean adm= (Boolean) session.getAttribute("adminRoles"); 
	if((adm==null||(!adm.booleanValue()))){
	   response.sendRedirect("./index.jsp");
	   return;
   }%>

<% ArrayList<NewsBean> news = (ArrayList<NewsBean>) request.getSession().getAttribute("news"); %>
        
<!DOCTYPE html>
<html lang="it">

<%@ page contentType="text/html; charset=ISO-8859-1" import="java.util.*, java.util.ArrayList, model.PubblicationBean , model.NewsBean"%>

<%if(news==null){
	response.sendRedirect("./VideoGameServlet");
	return;
} %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Stragame</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/animate.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"> 
        
    </head>

<body>
<div class="top-bar">
        <div class="container">
            <div class="row">
                <div class="col-md-6" style="height:25px">
                    <div class="navbar-menu-left-side239">
                        
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
                            	<%if(adm!=null && adm==true) { %>
                                	<li><a href="bug.jsp" target="_self">Bug</a></li>
                                <%} %>
                                <li><a href="newBug.jsp" target="_self">Segnala un bug</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"> <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">News <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn">
                                <li><a href="news.jsp">News</a></li>
                                <%if(adm!=null && adm==true) { %>
                                <li><a href="newNews.jsp">Inserisci una News</a></li>
                                <%} %>
                            </ul>
                        </li>
                        
                        <%if(adm!=null && adm==true) { %>
                        <li><a href="newGame.jsp">Nuovo Gioco</a></li>
                        
                        
                        <li class="dropdown"> <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">Segnalazioni <span class="caret"></span></a>
                            <ul class="dropdown-menu animated zoomIn"> 
	                            <li><a href="listReportPubblication.jsp">Pubblicazioni segnalate</a>
	                            <li><a href="blackList.jsp">BlackList</a>
                           </ul>
                        </li>
                        <%} %>
                        <%if(ut!=null){ %>
                        <li><a href="profile.jsp">Profile</a></li>
                        <%} %>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>
    
<section class="header-descriptin329">
                       <div class="container">
                       <h3>Inserisci un nuovo videogame</h3>
                        <ol class="breadcrumb breadcrumb839">
  <li><a href="index.jsp">Home</a></li>
  <li class="active">Nuovo Videogame</li>
</ol>
    </div>
</section>
    <section class="main-content920">
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                <div class="ask-question-input-part032">
                    <h4>Nuovo Videogame</h4>
                    <hr>
                    <script type="text/javascript">
                    function validate(username){
                    	
                    	if(username==null){
                    		alert("Effettuare il login");
                    		return false;
                    	}
                    }              
					</script>
                    
                    <form id='form' action="VideoGameServlet?action=insert" enctype="multipart/form-data" method="POST" name="newGameForm" onsubmit="return validate(<%=(String) request.getSession().getAttribute("username")%>)">
                        <div class="button-group-addfile3237">
                            <span class="form-description23999">Foto*</span><input type="file" name="foto" class="question-ttile3226" accept="image/*" required>
                        </div>
                        <div class="username-part940">
                            <span class="form-description43">Titolo* </span><input type="text" name="titolo" class="username029" placeholder="Inserisci il titolo" pattern="([a-zA-Z0-9 ,:']{2,45})" title="La lunghezza deve essere compresa fra 2 e 45" required>  
                        </div>
                        <div class="categori49">
                            <span class="form-description43308">Genere* </span>
                            
                            <select id="genere" name="genere" class="list-category53" style="width:200px;" required>
                                <option value="Azione">Azione</option>
                                <option value="Arcade">Arcade</option>
                                <option value="Avventura">Avventura</option>
                                <option value="Battle Royale">Battle Royale</option>
                                <option value="Free-to-play">Free-to-play</option>
                                <option value="MMORPG">MMORPG</option>
                                <option value="MOBA">MOBA</option>
                                <option value="Picchiaduro">Picchiaduro</option>
                                <option value="Simulazione">Simulazione</option>
                                <option value="Sparatutto">Sparatutto</option>
                            </select>
                        </div>
                        
                        <div class="question-title39">
                            <span class="form-description43313">Descrizione* </span><textarea class="question-details3144" placeholder="Inserisci la descrizione" id="descrizione" name="descrizione" maxlength="1000" required ></textarea>
                        
                        </div>
                        
                        <%if(label.equals("Videogioco già presente")){ %>
                        <label id='labelSignUp' style="font-size:17px;margin-top:30px;margin-left:300px; border-color:#FF0000; text-align:center; color:#00ff00"> <%=label%></label>        
                        <%}else{ %>
                        <label id='labelSignUp' style="font-size:17px;margin-top:30px;margin-left:300px; border-color:#00ff00; text-align:center; color:#00ff00"> <%=label%></label>
                        <%} %>
                          <div class="publish-button2389">
                    <input class="publis1291" type = "submit" value="Pubblica"/> 
                        <!--  <button type="submit" class="publis1291">Pubblica</button> -->
                    </div>
                    
                               
                    </form>
                  
                </div>
            </div>
            <!--end of col-md-9 -->
           
            <!--strart col-md-3 (side bar)-->
            <aside class="col-md-3 sidebar97239">
                <!--              login part-->
                <div class="login-part2389">
                  <% if (ut==null){ %>
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
                            <input type="checkbox" checked="checked">Ricordami</label> <a href="signUp.jsp" class="resbutton3892">Registrati</a> </div>
                </div>
                     <%} else  { %>
	
							
							
							<form action="LogoutServlet" method="POST" >
							<button type="Submit" class="btn btn-dark" > Logout</button>
							</form>
							
							
							<%} %>
                
                <!--        start recent post  -->
                <div class="recent-post3290">
                        <h4>Ultime news</h4>
                        <%int numN=0; %>
                        <%if(news.size()>=5)
                        	numN=5;
                        else
                        	numN=news.size();%>
                            <%for(int i=0; i<numN; i++){%>
                            <% NewsBean n= news.get(i);%>
                        <div class="post-details021"> <a href="news.jsp"><h5><%=n.getTitolo() %></h5></a>
                        <%if(n.getTesto().length()>20){ %>
                            <p><%=n.getTesto().substring(0, 20)+"..."%></p> <small style="color: #848991"><%=n.getData() %></small>
                         <%} else{ %>
                         	<p><%=n.getTesto()%></p> <small style="color: #848991"><%=n.getData() %></small> 
                         	<%} %>
                         	<%} %>
                         </div>
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
            
        </div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/npm.js"></script>
</body>

</html>