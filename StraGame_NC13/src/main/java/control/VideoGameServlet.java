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
import model.CommentBean;
import model.CommentDao;
import model.CommentDto;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.VideoGameBean;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class VideoGameServelet.
*/
@WebServlet("/VideoGameServlet")
@MultipartConfig
public class VideoGameServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private VideoGameDao videogamedto = new VideoGameDto();
  private NewsDao newsdto = new NewsDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private CommentDao commentdto = new CommentDto();
       
  
  public VideoGameServlet() {
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
    //TODO Auto-generated method stub
        
        
    String action = request.getParameter("action");
    ArrayList<NewsBean> newsList;
        
    System.out.println("Azione in VideoGameServlet:" + action);
        
    if (action == null) {
      try {
        newsList = newsdto.getAllNews();
        request.getSession().setAttribute("news", newsList);
        RequestDispatcher dispatcher = getServletContext()
            .getRequestDispatcher("/newGame.jsp");
        dispatcher.forward(request, response);
      } catch (SQLException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();
      }
            
    } else if (action.equals("insert")) {
      String label = "";
      String titolo = request.getParameter("titolo");
      String genere = request.getParameter("genere");
      String descrizione = request.getParameter("descrizione");
      Part photo = request.getPart("foto");
            
      VideoGameBean bean = new VideoGameBean();
            
      if (titolo.length() == 0) {
        throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
      } else if (titolo.length() > 45) {
        throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
      } else if (titolo.length() < 2) {
        throw new IllegalArgumentException("Il titolo non rispetta la lunghezza");
      } else if (!titolo.matches("[a-zA-Z0-9 ,:']+")) {
        throw new IllegalArgumentException("Il titolo non rispetta il formato");
      } else {
        bean.setNome(titolo);
      }

      if (genere.length() == 0) {
        throw new IllegalArgumentException("Il genere non rispetta la lunghezza");
      } else if (genere.length() < 3) {
        throw new IllegalArgumentException("Il genere non rispetta la lunghezza");
      } else if (genere.length() > 45) {
        throw new IllegalArgumentException("Il genere non rispetta la lunghezza");
      } else if (!genere.matches("[a-zA-Z0-9 \']+")) {
        throw new IllegalArgumentException("Il genere non rispetta il formato");
      } else {
        bean.setGenere(genere);
      }

      if (descrizione.length() == 0) {
        throw new IllegalArgumentException("La descrizione non rispetta la lunghezza");
      } else if (descrizione.length() > 1000) {
        throw new IllegalArgumentException("La descrizione non rispetta la lunghezza");
      } else {
        bean.setDescrizione(descrizione);
      }
            
      try {
      
        if (videogamedto.getVideoGame(titolo).getNome() == "") {

          bean.setPhoto(photo);
          videogamedto.insertVideoGame(bean);
          label = "Videogioco inserito con successo";
                            
        } else {
          label = "Videogioco già presente";
        }
        request.setAttribute("label", label);
        RequestDispatcher dispatcher = getServletContext()
            .getRequestDispatcher("/newGame.jsp");
        dispatcher.forward(request, response);
      } catch (SQLException e1) {
        //TODO Auto-generated catch block
        e1.printStackTrace();
      }
    } else {
      String nome = request.getParameter("nome");
      ArrayList<PubblicationBean> pubs;
      ArrayList<CommentBean> comments;
      try {
        newsList = newsdto.getAllNews();
        request.setAttribute("news", newsList);
                
        VideoGameBean game = new VideoGameBean();
                
        game = videogamedto.getVideoGame(nome);
        request.setAttribute("game", game);
                
        pubs = pubblicationdto.getPubsByVideogame(nome);
        request.setAttribute("pubs", pubs);
                
        comments = commentdto.getAllComments();
        request.setAttribute("comments", comments);
                
        RequestDispatcher dispatcher = getServletContext()
            .getRequestDispatcher("/videogamePubblication.jsp");
        dispatcher.forward(request, response);
                
      } catch (SQLException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
