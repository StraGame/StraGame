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
        <input type="password" name="oldpassword" placeholder="Vecchia password" pattern="([a-zA-Z0-9]{8,46})"
        				title="Il campo Vecchia password deve essere compreso fra 8 e 46 caratteri" placeholder="Password*" required/>
        <input type="password" name="newpassword" placeholder="Nuova password" pattern="([a-zA-Z0-9]{8,46})"
        				title="Il campo Nuova password deve essere compreso fra 8 e 46 caratteri" placeholder="Password*" required/>
        <input type="password" name="repeatpassword" placeholder="Ripetere password" pattern="([a-zA-Z0-9]{8,46})"
        				title="Il campo Ripetere password deve essere compreso fra 8 e 46 caratteri" placeholder="Password*" required/>
        <label id='labelSignUp' class='labelSignUp'> <%=label%></label>
        <div class="text-center">
        	<a href="index.jsp"><input class="button" value="Home" style="width:50px;"/></a>
        	<input class="button" type = "submit" value="Salva"/>
        </div>
        
      </form>
    </div>

 
  </div>
</div>
  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>

    

</body>
</html>
