package control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.UserBean;
import model.UserDao;
import model.UserDto;

/**
 * Servlet implementation class UserServlet.
*/
@MultipartConfig 
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserDao userdto = new UserDto();
  private NewsDao newsdto = new NewsDto();
  static String SAVE_DIR = "/uploadTemp";
       
  /**
    * @see HttpServlet#HttpServlet()
  */
  public UserServlet() {
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
    //TODO Auto-generated method stub
    String action = request.getParameter("action");
    System.out.println(action);
    String autore = (String) request.getSession().getAttribute("username");
    ArrayList<NewsBean> newsList;
        
        
    if (action == null) {
      try {
        UserBean bean = userdto.retrieveUser(autore);
                
        String nome = bean.getNome();
        String cognome = bean.getCognome();
        String email = bean.getEmail();
        String descrizione = bean.getDescrizione();
                
        request.setAttribute("nome", nome);
        request.setAttribute("cognome", cognome);
        request.setAttribute("email", email);
        request.setAttribute("descrizione", descrizione);
                
        newsList = newsdto.getAllNews();
        request.setAttribute("news", newsList);
                
        RequestDispatcher dispatcher = getServletContext()
            .getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
      } catch (SQLException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else if (action.equals("insertDescription")) {
      String newDescription = request.getParameter("changeDescription");
      try {
                
        userdto.editDescription(newDescription, autore);
                
        RequestDispatcher dispatcher = getServletContext()
            .getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
                
      } catch (SQLException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else if (action.equals("uploadPhoto")) {
            
      System.out.println("sto in uploadphoto");
            
      String username = request.getParameter("username");
            
      Part photo = request.getPart("foto");
      try {
        userdto.updatePhoto(username, photo);
      } catch (SQLException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();
      }
            
      RequestDispatcher dispatcher = getServletContext()
           .getRequestDispatcher("/profile.jsp");
      dispatcher.forward(request, response);
    } else {
            
      System.out.println("sono in getPhoto");
      byte[] bt = null;
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
      out.close();
            
    }
  } 
}

