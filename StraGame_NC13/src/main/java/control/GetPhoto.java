package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationDao;
import model.PubblicationDto;
import model.UserDao;
import model.UserDto;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class GetPhoto.
 */
@WebServlet("/GetPhoto")
public class GetPhoto extends HttpServlet {
    
  private static final long serialVersionUID = 1L;
  private UserDao userdto = new UserDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private NewsDao newsdto = new NewsDto();
  private VideoGameDao videogamedto = new VideoGameDto();
       
  /**
     * @see HttpServlet#HttpServlet()
     */
  public GetPhoto() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

    doPost(request, response);
    
  }

  /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
    System.out.println("sono in getPhoto");
        
    byte[] bt = null;
    String action = request.getParameter("action");
        
    if (action.equals("user")) {
      try {
        String username = request.getParameter("username");
        System.out.println("stampo username in getphoto:" + username);
        bt = userdto.getPhoto(username);    
        
      } catch (SQLException e) {
        e.printStackTrace();
      }
        
      ServletOutputStream out = response.getOutputStream();
      if (bt != null) {
        out.write(bt);
        response.setContentType("image/jpeg");    
            
      }
      System.out.println(response.getContentType());
      out.close();
    } else if (action.equals("pubblication")) {

      try {
        String codice = request.getParameter("id");
        int id = Integer.parseInt(codice);
                
        bt = pubblicationdto.getPhoto(id);
            
      } catch (SQLException e) {
        e.printStackTrace();
      }
            
      ServletOutputStream out = response.getOutputStream();
      if (bt != null) {
        out.write(bt);
        response.setContentType("image/jpeg");    
                
      }
      out.close();
    } else if (action.equals("news")) {
            
      try {
        String codice = request.getParameter("id");
        int id = Integer.parseInt(codice);
                
        bt = newsdto.getPhoto(id);
            
      } catch (SQLException e) {
        e.printStackTrace();
      }
            
      ServletOutputStream out = response.getOutputStream();
      if (bt != null) {
        out.write(bt);
        response.setContentType("image/jpeg");    
                
      }
      out.close();
            
    } else {
            
      try {
        String nome = request.getParameter("nome");
                
        bt = videogamedto.getPhoto(nome);
            
      } catch (SQLException e) {
        e.printStackTrace();
      }
            
      ServletOutputStream out = response.getOutputStream();
      out.write(bt);
      response.setContentType("image/jpeg");    
      out.close();
            
    }
            
  }
}


