package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserBean;
import model.UserDao;
import model.UserDto;

/**
 * Servlet implementation class UserCheckServlet.
*/
@WebServlet("/UtenteDuplicatoControllo")
public class UserCheckServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  /**
   * Servlet verifica esistenza utente già registrato.
   */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    //TODO Auto-generated method stub
    doPost(request, response);
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();
    String nickname = request.getParameter("username");
    UserDao userdto = new UserDto();
    UserBean utente = null;
    try {
      utente = userdto.retrieveUser(nickname);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (utente != null) {
      out.print("false");
    } else {
      out.print("true");
    }
  }
}