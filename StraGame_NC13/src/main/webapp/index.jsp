<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%  String ut=(String) request.getSession().getAttribute("username");
   Boolean adm= (Boolean) session.getAttribute("adminRoles");
   %>
   
   <% ArrayList<PubblicationBean> recensioni = (ArrayList<PubblicationBean>) request.getAttribute("recensioni"); %>
   
   <% ArrayList<PubblicationBean> topic = (ArrayList<PubblicationBean>) request.getAttribute("topic"); %>
   
   <% ArrayList<NewsBean> news = (ArrayList<NewsBean>) request.getAttribute("news"); %>
   
   <% ArrayList<BugBean> bug = (ArrayList<BugBean>) request.getAttribute("bug"); %>
   
   <% ArrayList<VideoGameBean> game= (ArrayList<VideoGameBean>) request.getAttribute("game"); %>
   
   <%ArrayList<CommentBean> comments= (ArrayList<CommentBean>) request.getAttribute("comments"); %>
   
<!DOCTYPE html>
<html lang="it">

<% if(recensioni==null || topic==null || news==null ||bug==null ||game==null){
	
	response.sendRedirect("./IndexServlet");	
	return;
	
}	%>

<%@ page contentType="text/html; charset=ISO-8859-1" import="java.util.*, java.util.ArrayList, model.PubblicationBean,model.NewsBean, model.BugBean, model.VideoGameBean, model.CommentBean"%>

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
                        <ol class="breadcrumb breadcrumb839">
  <li><a href="index.jsp">Home</a></li>
</ol>
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
                        <%if(adm!=null && adm==true) { %>
                        <input id="tab4" type="radio" name="tabs">
                        <label for="tab4">Ultime segnalazioni</label>
                        <%} %>
                        
                        <section id="content1">
                               <!--Recent Question Content Section -->
                            <div class="question-typegame">
                                <ul id="griglia">
                                <%for(VideoGameBean g: game) {%>
                                    <li><a href="VideoGameServlet?action=viewGame&nome=<%=g.getNome()%>"><img src="GetPhoto?action=videogame&nome=<%=g.getNome() %>" width="100" height="160"><p class="testogiochi"><%=g.getNome() %></p></a></li>
                                <%} %>
                                </ul>
                            </div>
                        </section>
                        <!--  End of content-1------>
                        
                        <section id="content2">
	                        <%int numT=0; %>
	                        <%if(topic.size()>=5)
	                        	numT=5;
	                        else
	                        	numT=topic.size();%>
                           <%for(int i=0; i<numT; i++){%>
                            <%PubblicationBean b= topic.get(i); %>
                            <div class="question-type2033">
                                <div class="row">
                                    <div class="col-md-1">
                                    <div class="left-user12923 left-user12923-repeat">
                                        <img src="GetPhoto?username=<%=b.getAutore()%>&action=user" alt="image" onerror="this.src='image/images.png'">
                                    </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="right-description893">
                                            <div id="que-hedder2983">
                                                <span class="label utente">&#128100 <%=b.getAutore()%></span>
                                                <span class="label videogioco">&#127918 <%=b.getVideogioco() %></span>
                                                <h3><a href="TopicDetailsServlet?id=<%=b.getCodicePubblicazione() %>" target="_self"><%=b.getTitolo()%></a></h3> </div>
                                            <div class="ques-details10018">
                                                <p><%=b.getDescrizione()%></p>
                                            </div>
                                            <hr>
                                            <div class="clockcomment"> &#128336 Data inserimento: <%=b.getData() %></div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="ques-type302">
                                                <br>
                                                <br>
                                                <%int cont=0; %>
                                                <%for(CommentBean c: comments){ %>
                                                <%if(c.getCodicePubblicazione()==b.getCodicePubblicazione()){%>
                                                <%cont=cont+1; %>
                                                <%} %>
                                                <%} %>
                                                <span class="label comment">&#128172 <%=cont %></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%} %>                       
                        </section>
                        
                        <!----end of content-2----->
                        
                        <section id="content3">
                        <%int numR=0; %>
                        <%if(recensioni.size()>=5)
                        	numR=5;
                        else
                        	numR=recensioni.size();%>
                            <%for(int i=0; i<numR; i++){%>
                            <%PubblicationBean b= recensioni.get(i); %>
                            <div class="question-type2033">
                                <div class="row">
                                    <div class="col-md-1">
                                    <div class="left-user12923 left-user12923-repeat">
                                        <img src="GetPhoto?username=<%=b.getAutore()%>&action=user" alt="image" onerror="this.src='image/images.png'">
                                    </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="right-description893">
                                            <div id="que-hedder2983">
                                                <span class="label utente">&#128100 <%=b.getAutore()%></span>
                                                <span class="label videogioco">&#127918 <%=b.getVideogioco() %></span>
                                                <h3><a href="ReviewDetailsServlet?id=<%=b.getCodicePubblicazione() %>" target="_self"><%=b.getTitolo()%></a></h3> </div>
                                            <div class="ques-details10018">
                                                <p><%=b.getDescrizione()%></p>
                                            </div>
                                            <hr>
                                            <div class="clockcomment"> &#128336 Data inserimento: <%=b.getData() %></div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="ques-type302">
                                                <br>
                                                <br>
                                                <%int cont=0; %>
                                                <%for(CommentBean c: comments){ %>
                                                <%if(c.getCodicePubblicazione()==b.getCodicePubblicazione()){%>
                                                <%cont=cont+1; %>
                                                <%} %>
                                                <%} %>
                                                <span class="label comment">&#128172 <%=cont %></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%} %>
                        </section>
                        <!--End content-3 -->
                        
                        
                        <%if(adm!=null && adm==true) { %>
                        <section id="content4">
                        <%int numB=0; %>
                        <%if(bug.size()>=5)
                        	numB=5;
                        else
                        	numB=bug.size();%>
                        <%for(int i=0; i<numB; i++){%>
                            <%BugBean st= bug.get(i); %>
                            <div class="question-type2033">
                                <div class="row">
                                    <div class="col-md-1">
                                    <div class="left-user12923 left-user12923-repeat">
                                        <img src="GetPhoto?username=<%=st.getAutore()%>&action=user" alt="image" onerror="this.src='image/images.png'">
                                    </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="right-description893">
                                            <div id="que-hedder2983">
                                                <span class="label utente">&#128100 <%=st.getAutore() %></span>
                                                <span class="label videogioco">&#127918 <%=st.getVideogioco() %></span>
                                                <span class="label categoria">Categoria <%=st.getCategoria() %></span>
                                                <h3><a href="BugDetailsServlet?id=<%=st.getCodicebug() %>" target="_self"><%=st.getTitolo() %></a></h3> </div>
                                            <div class="ques-details10018">
                                                <p><%=st.getTesto() %></p>
                                            </div>
                                            <hr>
                                            <div class="clockcomment"> &#128336 Inserito il: <%=st.getData() %></div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="ques-type302">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%} %>
                        </section>
                        <%} %>
               
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