package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationBean;

/**
 * Servlet implementation class NewNewsServlet.
 */
@MultipartConfig
@WebServlet("/NewNewsServlet")
public class NewNewsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private NewsDao newsdto = new NewsDto();
       
 
  public NewNewsServlet() {
    super();
    //TODO Auto-generated constructor stub
  }

  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    //TODO Auto-generated method stub
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
        
    ArrayList<NewsBean> list = new ArrayList<NewsBean>();    
    String label = "";
    String titolo = request.getParameter("titolo");
    String descrizione = request.getParameter("descrizione");
    String autore = (String) request.getSession().getAttribute("username");
    String action = request.getParameter("action");
        
        
    if (action == null) {
      try {
        list = newsdto.getAllNews();
        request.getSession().setAttribute("news", list);
                
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/newNews.jsp");
        dispatcher.forward(request, response);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
            
    } else {
      NewsBean bean = new NewsBean();
      if (titolo.length() == 0) {
        throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
      } else if (titolo.length() > 45) {
        throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
      } else if (titolo.length() < 5) {
        throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
      } else if (!titolo.matches("[a-zA-Z0-9 \']+")) {
        throw new IllegalArgumentException("Il titolo non rispetta il formato");
      } else {
        bean.setTitolo(titolo);
      }

      if (descrizione.length() == 0) {
        throw new IllegalArgumentException("La descrizione non rispetta la lunghezza");
      } else if (descrizione.length() > 750) {
        throw new IllegalArgumentException("La descrizione non rispetta la lunghezza");
      } else {
        bean.setTesto(descrizione);
      }
           
      try {
                
        Part photo = request.getPart("foto");
        bean.setAutore(autore);
        bean.setPhoto(photo);
        
        newsdto.insertNews(bean);
        label = "News inserita con successo";
                
        request.setAttribute("label", label);
        response.setContentType("la creazione della news è andata a buon fine");
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/newNews.jsp");
        dispatcher.forward(request, response);

      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
  }
}
