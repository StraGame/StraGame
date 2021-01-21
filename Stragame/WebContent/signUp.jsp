<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String label = (String) request.getAttribute("label"); %>
    
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Stragame</title>
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400" rel="stylesheet">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
   <link rel="stylesheet" href="css/loginstyle.css">

  
</head>

<body>
  
<div class="modal-wrap">

  <div class="modal-bodies">
    <div class="modal-body modal-body-step-1 is-showing">
      <div class="title">Registrazione</div>
      
      <form id = "form" action = "RegisterServlet" method = "post">
        <input id="nome" name="nome" type="text" placeholder="Nome*"/>
        <input id="cognome" name="cognome" type="text" placeholder="Cognome*"/>
        <input id="username" name="username" type="text" placeholder="Username*"/>
        <input id="email" name="email" type="email" placeholder="E-Mail*"/>
        <input id="password" name="password" type="password" placeholder="Password*"/>
        <input id="confirmedPassword" name="confirmedPassword" type="password" placeholder="Confirm Password*"/>
        
        <label id='labelSignUp' class='labelSignUp'> <%=label%></label>
        
        <div class="text-center">
        <input class="button" type = "submit" value="Registrati"/> 

        </div>
      </form>
    </div>

 
  </div>
</div>
  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>

    

</body>
</html>
    