package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BugDao;
import model.BugDto;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.BugBean;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class NewBugServlet.
 */
@WebServlet("/NewBugServlet")
public class NewBugServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private VideoGameDao videogiocodto = new VideoGameDto();
  private BugDao bugdto = new BugDto();
  private NewsDao newsdto = new NewsDto();
  /**
     * @throws ServletException 
 * @see HttpServlet#HttpServlet()
     */
  
  public NewBugServlet() throws ServletException {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
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
    String action = request.getParameter("action");

    if (action == null) {
            
      try {
                
        ArrayList<String> list = videogiocodto.getVideoGameNames();
        request.getSession().setAttribute("videogiochi", list);
                
        ArrayList<NewsBean> newsList = newsdto.getAllNews();
        request.getSession().setAttribute("news", newsList);

        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/newBug.jsp");
        dispatcher.forward(request, response);
                
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      String label = "";
      String autore = (String) request.getSession().getAttribute("username");
      String titolo = request.getParameter("titolo");
      String descrizione = request.getParameter("descrizione");
      String videogioco = request.getParameter("videogioco");
      String categoria = request.getParameter("categoria");
      BugBean bean = new BugBean();
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

      if (categoria.length() == 0) {
        throw new IllegalArgumentException("La categoria non rispetta la lunghezza");
      } else if (categoria.length() < 2) {
        throw new IllegalArgumentException("La categoria non rispetta la lunghezza");
      } else if (categoria.length() > 45) {
        throw new IllegalArgumentException("La categoria non rispetta la lunghezza");
      } else if (!categoria.matches("[a-zA-Z \']+")) {
        throw new IllegalArgumentException("La categoria non rispetta il formato");
      } else {
        bean.setCategoria(categoria);
      }
    
      if (videogioco.length() == 0) {
        throw new IllegalArgumentException("Il videogioco non rispetta la lunghezza");
      } else if (videogioco.length() < 2) {
        throw new IllegalArgumentException("Il videogioco non rispetta la lunghezza");
      } else if (videogioco.length() > 45) {
        throw new IllegalArgumentException("Il videogioco non rispetta la lunghezza");
      } else if (!videogioco.matches("[a-zA-Z0-9 \']+")) {
        throw new IllegalArgumentException("Il videogioco non rispetta il formato");
      } else {
        bean.setVideogioco(videogioco);
      }
     
      if (descrizione.length() == 0) {
        throw new IllegalArgumentException("La descrizione non rispetta la lunghezza");
      } else if (descrizione.length() > 300) {
        throw new IllegalArgumentException("La descrizione non rispetta la lunghezza");
      } else {
        bean.setTesto(descrizione);
      } 
      
      try {
                
        bean.setAutore(autore);
                
        bugdto.insertBug(bean);
        label = "Segnalazione Bug inserita con successo";
                            
        request.setAttribute("label", label);
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/newBug.jsp");
        dispatcher.forward(request, response);
                
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
  }
}
