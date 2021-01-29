<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<% String label = (String) request.getAttribute("label");
		if(label==null)
			label="";
	%>
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
      <div class="title">Cambia Password</div>
      <form action="ChangePasswordServlet" method="post">
        <input type="password" name="oldpassword" placeholder="Vecchia password"/>
        <input type="password" name="newpassword" placeholder="Nuova password"/>
        <input type="password" name="repeatpassword" placeholder="Ripetere password"/>
        <label id='labelSignUp' class='labelSignUp'> <%=label%></label>
        <div class="text-center">
        	<input class="button" type = "submit" value="Salva"/>
        </div>
      </form>
    </div>

 
  </div>
</div>
  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>

    

</body>
</html>
