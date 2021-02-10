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
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.ReportPubblicationBean;
import model.ReportPubblicationDao;
import model.ReportPubblicationDto;
import model.UserBean;
import model.UserDao;
import model.UserDto;

/**
  * Servlet implementation class ReportPubblicationServlet.
  */
@WebServlet("/ReportPubblicationServlet")
public class ReportPubblicationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private ReportPubblicationDao reportdto = new ReportPubblicationDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private NewsDao newsdto = new NewsDto();
  private UserDao userdto = new UserDto();
       
  /**
  * @see HttpServlet#HttpServlet()
  */
  public ReportPubblicationServlet() {
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
    String id = request.getParameter("id");
    int codicepubblicazione = Integer.parseInt(id);
    System.out.println(codicepubblicazione);
        
    ArrayList<NewsBean> newsList;
    if (action == null) {
            
      PubblicationBean bean;
      try {
        bean = pubblicationdto.getPubblication(codicepubblicazione);
        request.setAttribute("bean", bean);
                
        newsList = newsdto.getAllNews();
        request.setAttribute("news", newsList);
                
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/reportPubblication.jsp");
        dispatcher.forward(request, response);
      } catch (SQLException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();
      }
            
    } else {
      PubblicationBean bean;
      String categoria = request.getParameter("categoria");
      String testo = request.getParameter("testo");
      String autore = (String) request.getSession().getAttribute("username");
      ReportPubblicationBean report = new ReportPubblicationBean();
            
      if (testo.length() == 0) {
        throw new IllegalArgumentException("Il testo non rispetta la lunghezza");
      } else if (testo.length() > 300) {
        throw new IllegalArgumentException("Il testo non rispetta la lunghezza");
      } else {
        report.setDescrizione(testo);
      }
      
      if (categoria.length() == 0) {
        throw new IllegalArgumentException("La categoria non rispetta la lunghezza");
      } else if (categoria.length() < 3) {
        throw new IllegalArgumentException("La categoria non rispetta la lunghezza");
      } else if (categoria.length() > 45) {
        throw new IllegalArgumentException("La categoria non rispetta la lunghezza");
      } else if (!categoria.matches("[a-zA-Z \']+")) {
        throw new IllegalArgumentException("La categoria non rispetta il formato");
      } else {
        report.setCategoria(categoria);
      }
            
      try {
                
                
                
        bean = pubblicationdto.getPubblication(codicepubblicazione);
                
        report.setAutore(autore);
        report.setCodicePubblicazione(codicepubblicazione);
                
        reportdto.insertReportPubblication(report);
                
        userdto.setSegnalato(bean.getAutore(), true);
     
        if (bean.getTipo().equals("recensione")) {
          RequestDispatcher dispatcher = getServletContext()
              .getRequestDispatcher("/ReviewDetailsServlet?id=" + codicepubblicazione);
          dispatcher.forward(request, response);
                    
        }  else {
                    
          RequestDispatcher dispatcher = getServletContext()
              .getRequestDispatcher("/TopicDetailsServlet?id=" + codicepubblicazione);
          dispatcher.forward(request, response);
                    
        }
      } catch (SQLException e) {
        //TODO Auto-generated catch block
        e.printStackTrace();
      }
    }        
  }
}

