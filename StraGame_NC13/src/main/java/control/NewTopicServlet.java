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
import model.PubblicationDao;
import model.PubblicationDto;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class NewTopicServlet.
*/
@WebServlet("/NewTopicServlet")
@MultipartConfig
public class NewTopicServlet extends HttpServlet {
    
  private static final long serialVersionUID = 1L;
    
  private VideoGameDao videogiocodto = new VideoGameDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private NewsDao newsdto = new NewsDto();
       
  
  public NewTopicServlet() {
    super();
    //TODO Auto-generated constructor stub
  }

  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
        
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
        
    String action = request.getParameter("action");
    String label = "";
    //request.getSession().removeAttribute("label");
        
    if (action == null) {
        
      try {
            
        ArrayList<String> list = videogiocodto.getVideoGameNames();
        request.getSession().setAttribute("videogiochi", list);
            
        ArrayList<NewsBean> newsList = newsdto.getAllNews();
        request.getSession().setAttribute("news", newsList);
            
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/newTopic.jsp");
        dispatcher.forward(request, response);
            
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
            
      if (request.getSession().getAttribute("username") == null) {
                
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newTopic.jsp");
        dispatcher.forward(request, response);
      }  else {
                
            
            
        Part photo = request.getPart("foto");
            
        String autore = (String) request.getSession().getAttribute("username");
        String titolo = request.getParameter("titolo");
        String descrizione = request.getParameter("descrizione");
        String videogioco = request.getParameter("videogioco");
        PubblicationBean bean = new PubblicationBean();

        if (titolo.length() == 0) {
          throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
        } else if (titolo.length() > 45) {
          throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
        } else if (titolo.length() < 5) {
          throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
        } else if (!titolo.matches("[A-Za-z0-9 \']+")) {
          throw new IllegalArgumentException("Il titolo non rispetta il formato");
        } else {
          bean.setTitolo(titolo);
        }
    
     
        if (videogioco.length() == 0) {
          throw new IllegalArgumentException("Il videogioco non rispetta la lunghezza");
        } else if (videogioco.length() < 2) {
          throw new IllegalArgumentException("Il videogioco non rispetta la lunghezza");
        } else if (videogioco.length() > 45) {
          throw new IllegalArgumentException("Il videogioco non rispetta la lunghezza");
        } else if (!videogioco.matches("[A-Za-z0-9 \']+")) {
          throw new IllegalArgumentException("Il videogioco non rispetta il formato");
        }  else {
          try {
            if (videogiocodto.getVideoGame(videogioco).getNome().equals("")) {
              throw new IllegalArgumentException("Il videogioco non esiste all'interno del db");
            } else {
              bean.setVideogioco(videogioco);
            }
          } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
     
          if (descrizione.length() == 0) {
            throw new IllegalArgumentException("La descrizione non rispetta la lunghezza");
          } else if (descrizione.length() > 2000) {
            throw new IllegalArgumentException("La descrizione non rispetta la lunghezza");
          } else {
            bean.setDescrizione(descrizione);
          }

          try {
            bean.setAutore(autore);
            bean.setTipo("topic");
            bean.setPhoto(photo);
                    
            pubblicationdto.insertPubblication(bean);
                    
            label = "Topic inserito correttamente";
            request.setAttribute("label", label);
            RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher("/newTopic.jsp");
            dispatcher.forward(request, response);
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }    
      }
    }
  }
} 
