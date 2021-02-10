<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String label = (String) request.getAttribute("label"); 
    if(label==null){
	   label="";
    }%>
    
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
      
      <form id = "form" action = "RegisterServlet" method = "post" >
        <input id="nome" name="nome" type="text" pattern="([A-Za-z]{2,25})" 
						title="Non usare numeri.La lunghezza deve essere compresa fra 2 e 25" placeholder="Nome*" required/>
       <input type="text" name="cognome"pattern="([A-Za-z]{2,25})" 
						title="Non usare numeri. La lunghezza deve essere compresa fra 2 e 25" required placeholder="cognome">
        <input id="username" name="username" type="text" pattern="([a-zA-Z0-9]{5,25})" title="Il campo username deve essere compreso fra 5 e 25 caratteri" placeholder="Username*" required />
        
        <script type="text/javascript">
        
        var username = document.getElementById("username");
        function checkUsername(){
    		
    		var xhttp = new XMLHttpRequest();
            xhttp.open("GET","UserCheckServlet="+username,true);
             
            xhttp.setRequestHeader("connection","close");
            
            xhttp.onreadystatechange = function() {
           	   	 if(xhttp.responseText === "false"){
           	   		 username.setCustomValidity("Username già presente");
           	   	}
           	   	 else{
           	   		username.setCustomValidity("");
           	   		 }
            }
            	
            xhttp.send();
    		
    	}
        
        username.onchange=checkUsername;
        username.onkeyup=checkUsername;
        
        </script>
        
        <input id="email" name="email" type="email" placeholder="E-Mail*" pattern="([a-zA-Z0-9_.-@]{12,45})" 
								title="Il campo email non rispetta il formato o la lunghezza" required/>
        <input id="password" name="password" type="password" pattern="([a-zA-Z0-9]{8,45})"
        				title="Il campo password deve essere compreso fra 8 e 45 caratteri" placeholder="Password*"required/>
        <input id="confirm_password" name="confirmedPassword" type="password"   placeholder="Confirm Password*" required/>
        
        <script type="text/javascript">
        var password = document.getElementById("password");
        var confirm_password = document.getElementById("confirm_password");

	      function validatePassword(){
	        	if(password.value != confirm_password.value) {
	          		confirm_password.setCustomValidity("Le password non coincidono");
	        	} else {
	          		confirm_password.setCustomValidity('');
	        	}
	      	}
	
	      password.onchange = validatePassword;
	      confirm_password.onkeyup = validatePassword;
        </script>
        
        <script>
        
        function validate() {
    		
    		var email = document.getElementById('email').value;
    		
    		if (email.length < 12 || email.length > 45) {
    			document.getElementById('labelSignUp').innerHTML='Lunghezza email non valida';
    			return false;
    		}
    		
    		var stringa1 = document.getElementById('password').value;
    		var stringa2 = document.getElementById('confirmedPassword').value;
    		
    		if(stringa1 != stringa2) {
    			document.getElementById('labelSignUp').innerHTML='Le due password non corrispondono';
    			return false;
    		}
    		document.getElementById('labelSignUp').innerHTML='';
    		
    		return true;
    		
    	}
        
        </script>
        
        <script>
        
        
        </script>
        
        
        <label id='labelSignUp' class='labelSignUp'> <%=label%></label>
        
        <div class="text-center">
	        <a href="index.jsp"><input class="button" value="Home" style="width:50px;"/></a>
	        <input class="button" type = "submit" value="Registrati" onclick="checkUsername()"/> 
        </div>
      </form>
    </div>

 
  </div>
</div>
  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>

    

</body>
</html>
    