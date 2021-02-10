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
   * Servlet implementation class NewReviewServlet.
  */
@WebServlet("/NewReviewServlet")
@MultipartConfig
public class NewReviewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private VideoGameDao videogiocodto = new VideoGameDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private NewsDao newsdto = new NewsDto();
       
  /**
     * @see HttpServlet#HttpServlet()
     */
  public NewReviewServlet() {
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
            getServletContext().getRequestDispatcher("/newReview.jsp");
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
      int gameplay = Integer.parseInt(request.getParameter("ratingGP"));
      int trama = Integer.parseInt(request.getParameter("ratingT"));
      int grafica = Integer.parseInt(request.getParameter("ratingG"));
      int votocomplessivo = Integer.parseInt(request.getParameter("ratingVC"));
      Part photo = request.getPart("foto");
            
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
      } else
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

      if (gameplay == 0) {
        throw new IllegalArgumentException("Il gameplay è minore di 1 o maggiore di 10");
      } else if (gameplay < 0) {
        throw new IllegalArgumentException("Il gameplay è minore di 1 o maggiore di 10");
      } else if (gameplay > 10) {
        throw new IllegalArgumentException("Il gameplay è minore di 1 o maggiore di 10");
      } else {
        bean.setGameplay(gameplay);
      }
   
      if (grafica == 0) {
        throw new IllegalArgumentException("La grafica è minore di 1 o maggiore di 10");
      } else if (grafica < 0) {
        throw new IllegalArgumentException("La grafica è minore di 1 o maggiore di 10");
      } else if (grafica > 10) {
        throw new IllegalArgumentException("La grafica è minore di 1 o maggiore di 10");
      } else {
        bean.setGrafica(grafica);
      }
   
      if (trama == 0) {
        throw new IllegalArgumentException("La trama è minore di 1 o maggiore di 10");
      } else if (trama < 0) {
        throw new IllegalArgumentException("La trama è minore di 1 o maggiore di 10");
      } else if (trama > 10) {
        throw new IllegalArgumentException("La trama è minore di 1 o maggiore di 10");
      } else {
        bean.setTrama(trama);
      }
   
      if (votocomplessivo == 0) {
        throw new IllegalArgumentException("Il voto complessivo è minore di 1 o maggiore di 10");
      } else if (votocomplessivo < 0) {
        throw new IllegalArgumentException("Il voto complessivo è minore di 1 o maggiore di 10");
      } else if (votocomplessivo > 10) {
        throw new IllegalArgumentException("Il voto complessivo è minore di 1 o maggiore di 10");
      } else {
        bean.setVoto(votocomplessivo);
      }
                  
      try {

        bean.setAutore(autore);
        bean.setTipo("recensione");
        bean.setPhoto(photo);
                    
        pubblicationdto.insertPubblication(bean);
        label = "Recensione inserita con successo";
                    
        request.setAttribute("label", label);
                
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/newReview.jsp");
        dispatcher.forward(request, response);
                
      } catch (SQLException e) {
        label = "Recensione non inserita correttamente";
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
