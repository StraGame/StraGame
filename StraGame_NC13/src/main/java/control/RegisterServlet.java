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
 * Servlet implementation class RegisterServlet.
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    
  private static final long serialVersionUID = 1L;
  private UserDao userdto = new UserDto();   
  /**
    * @see HttpServlet#HttpServlet()
  */
 
  public RegisterServlet() {
    super();
    //TODO Auto-generated constructor stub
  }

  /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    //TODO Auto-generated method stub
    doPost(request, response);
  }

  /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub

    String label;
    String nome;
    String cognome;
    String username;
    String password;
    String email;
    String verificaPassword;
        
    UserBean bean = new UserBean();
        
    nome = request.getParameter("nome");
    cognome = request.getParameter("cognome");
    username = request.getParameter("username");
    password = request.getParameter("password");
    verificaPassword = request.getParameter("confirmedPassword");
    email = request.getParameter("email");
        
    if (nome.length() == 0) {
      throw new IllegalArgumentException("Il nome non rispetta la lunghezza");
    } else if (nome.length() > 25) {
      throw new IllegalArgumentException("Il nome non rispetta la lunghezza");
    } else if (nome.length() < 2) {
      throw new IllegalArgumentException("Il nome non rispetta la lunghezza");
    } else if (!nome.matches("[A-Za-z \']+")) {
      throw new IllegalArgumentException("Il nome non rispetta il formato");
    } else {
      bean.setNome(nome);
    }
    
    if (cognome.length() == 0) {
      throw new IllegalArgumentException("Il cognome non rispetta la lunghezza");
    } else if (cognome.length() > 25) {
      throw new IllegalArgumentException("Il cognome non rispetta la lunghezza");
    } else if (cognome.length() < 2) {
      throw new IllegalArgumentException("Il cognome non rispetta la lunghezza");
    } else if (!cognome.matches("[A-Za-z \']+")) {
      throw new IllegalArgumentException("Il cognome non rispetta il formato");
    } else {
      bean.setCognome(cognome);
    }
    
    if (username.length() == 0) {
      throw new IllegalArgumentException("L'username non rispetta la lunghezza");
    } else if (username.length() > 25) {
      throw new IllegalArgumentException("L'username non rispetta la lunghezza");
    } else if (username.length() < 5) {
      throw new IllegalArgumentException("L'username non rispetta la lunghezza");
    } else if (!username.matches("[a-zA-Z0-9 \']+")) {
      throw new IllegalArgumentException("L'username non rispetta il formato");
    } else {
          bean.setNickname(username);
        }
       
    if (password.length() == 0) {
      throw new IllegalArgumentException("La password non rispetta la lunghezza");
    } else if (password.length() < 8) {
      throw new IllegalArgumentException("La password non rispetta la lunghezza");
    } else if (password.length() >= 46) {
      throw new IllegalArgumentException("La password non rispetta la lunghezza");
    } else if (!password.matches("[a-zA-Z0-9 \']+")) {
      throw new IllegalArgumentException("La password non rispetta il formato");
    } else if (!(verificaPassword.equals(password))) {
      throw new IllegalArgumentException("Le due password non corrispondono");
    } else {
      bean.setPassword(password);
    }
    
    if (email.length() == 0) {
      throw new IllegalArgumentException("L'email non rispetta la lunghezza");
    } else if (email.length() <= 11) {
      throw new IllegalArgumentException("L'email non rispetta la lunghezza");
    } else if (email.length() >= 46) {
      throw new IllegalArgumentException("L'email non rispetta la lunghezza");
    } else if (!email.matches("([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-]{2,})+.)+([a-zA-Z0-9]{2,})+$")) {
      throw new IllegalArgumentException("L'email non rispetta il formato");
    } else {
      bean.setEmail(email);
    }
        
    try {
      if(userdto.retrieveUser(username).getNickname()=="") {
        bean.setRuolo("user");
        bean.setSegnalato(false);
                
        userdto.insertUser(bean);
        label = "registrazione riuscita";
      } else {
        label="Username già presente";
      }
        request.setAttribute("label", label);
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(request, response);
            
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
        
  }

}

