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

/**
  * Servlet implementation class ReportDetailsServlet.
 */
@WebServlet("/ReportDetailsServlet")
public class ReportDetailsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private ReportPubblicationDao reportdto = new ReportPubblicationDto();
  private NewsDao newsdto = new NewsDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
       

  public ReportDetailsServlet() {
    super();
    //TODO Auto-generated constructor stub
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    //TODO Auto-generated method stub
        
    int id = Integer.parseInt(request.getParameter("id"));
    String autore = request.getParameter("autore");
        
    ArrayList<NewsBean> newsList;
        
    try {
      ReportPubblicationBean report = reportdto.getReportPubblication(id, autore);
      request.setAttribute("report", report);
            
      newsList  = newsdto.getAllNews();
      request.setAttribute("news", newsList);
            
      ArrayList<PubblicationBean> pubblicazioni = pubblicationdto.getAllPubblication();
      request.setAttribute("pubblicazioni", pubblicazioni);
            
      RequestDispatcher dispatcher = 
          getServletContext().getRequestDispatcher("/reportDetails.jsp");
      dispatcher.forward(request, response);
    } catch (SQLException e) {
      //TODO Auto-generated catch block
      e.printStackTrace();
    }
        
  }

}
