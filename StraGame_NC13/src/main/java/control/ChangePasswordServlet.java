package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserBean;
import model.UserDao;
import model.UserDto;

/**
 * Servlet implementation class ChangePassword.
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserDao userdto = new UserDto();
       
  /**
     * @see HttpServlet#HttpServlet()
  */
  public ChangePasswordServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doPost(request, response);
  }

  /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    // TODO Auto-generated method stub
    String label = "";
    String autore = (String) request.getSession().getAttribute("username");
    String oldpassword = (String) request.getParameter("oldpassword");
    String newpassword = (String) request.getParameter("newpassword");
    String repeatpassword = (String) request.getParameter("repeatpassword");
    
    System.out.println(oldpassword);
        
    if (oldpassword.length() == 0) {
      throw new IllegalArgumentException("La vecchia password non rispetta la lunghezza");
    } else if (oldpassword.length() < 8) {
      throw new IllegalArgumentException("La vecchia password non rispetta la lunghezza");
    } else if (oldpassword.length() >= 46) {
      throw new IllegalArgumentException("La vecchia password non rispetta la lunghezza");
    } else if (!oldpassword.matches("[a-zA-Z0-9 \']+")) {
      throw new IllegalArgumentException("La vecchia password non rispetta il formato");
    } 
  
   if (newpassword.length() == 0) {
      throw new IllegalArgumentException("La nuova password non rispetta la lunghezza");
    } else if (newpassword.length() < 8) {
      throw new IllegalArgumentException("La nuova password non rispetta la lunghezza");
    } else if (newpassword.length() >= 46) {
      throw new IllegalArgumentException("La nuova password non rispetta la lunghezza");
    } else if (!newpassword.matches("[a-zA-Z0-9 \']+")) {
      throw new IllegalArgumentException("La nuova password non rispetta il formato");
    }
  	
   
    if (!newpassword.equals(oldpassword)) {
      if(repeatpassword.equals(newpassword)) {
        try {
        	if(userdto.retrieveUser(autore).getPassword().equals(oldpassword)) {
    	  userdto.editPassword(newpassword, autore);
    	  label="Password cambiata con successo";
        	}
        	else {
        		label ="la vecchia password non è corretta";
        	}
    	} catch (SQLException e) {
    	  // TODO Auto-generated catch block
    	  e.printStackTrace();
    	  label="Password non è stata cambiata";
    				}
    			}
    			else {
    				label="Le due password non corrispondono";
    			}
    		}
    		else {
    			label="La nuova password deve essere diversa da quella vecchia";
    		}
    request.setAttribute("label", label);
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/changePassword.jsp");
    dispatcher.forward(request, response);
  }
}
