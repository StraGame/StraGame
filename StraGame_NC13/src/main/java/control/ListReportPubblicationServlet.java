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
import model.CommentDao;
import model.CommentDto;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.ReportPubblicationBean;
import model.ReportPubblicationDao;
import model.ReportPubblicationDto;
import model.UserDao;
import model.UserDto;

/**
 * Servlet implementation class ListReportPubblication.
 */
@WebServlet("/ListReportPubblicationServlet")
public class ListReportPubblicationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private ReportPubblicationDao reportdto = new ReportPubblicationDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private NewsDao newsdto = new NewsDto();
  private CommentDao commentdto = new CommentDto();
  private UserDao userdto = new UserDto();
    
       
 
  public ListReportPubblicationServlet() {
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
        
    String action = request.getParameter("action");
        
    if (action == null) {
      try {
        ArrayList<ReportPubblicationBean> lista = reportdto.getAllPubblicationReport();
        request.setAttribute("lista", lista);
                
        ArrayList<NewsBean> newsList = newsdto.getAllNews();
        request.setAttribute("news", newsList);
                
        ArrayList<PubblicationBean> pubblicazioni = pubblicationdto.getAllPubblication();
        request.setAttribute("pubblicazioni", pubblicazioni);
                
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/listReportPubblication.jsp");
        dispatcher.forward(request, response);
                
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else if (action.equals("DeleteReport")) {
      int id = Integer.parseInt(request.getParameter("id"));
      String autore = request.getParameter("autore");
            
      try {
        reportdto.removeReportPubblication(id, autore);
        int cont = 0;
        ArrayList<ReportPubblicationBean> lista = reportdto.getAllPubblicationReport();
        ArrayList<PubblicationBean> pubblicazioni = pubblicationdto.getAllPubblication();
        PubblicationBean sample = pubblicationdto.getPubblication(id);
                
        for (ReportPubblicationBean rp : lista) {
                    
          for (PubblicationBean p : pubblicazioni) {
                        
            if (rp.getCodicePubblicazione() == p.getCodicePubblicazione()) {
                            
              if (p.getAutore().equals(sample.getAutore())) {
                cont = 1;
              }
            }
          }
        }
                
        if (cont > 0) {
          userdto.setSegnalato(sample.getAutore(), true);
        } else {
          userdto.setSegnalato(sample.getAutore(), false);
        }
                
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/listReportPubblication.jsp");
        dispatcher.forward(request, response);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      int id = Integer.parseInt(request.getParameter("id"));
      
      int c = 0;
      try {
        reportdto.removeAllReportByPub(id);
        commentdto.removeAllCommentByPub(id);

        ArrayList<ReportPubblicationBean> lista = reportdto.getAllPubblicationReport();
        ArrayList<PubblicationBean> pubblicazioni = pubblicationdto.getAllPubblication();
        PubblicationBean sample = pubblicationdto.getPubblication(id);
                
        for (ReportPubblicationBean rp : lista) {
                    
          for (PubblicationBean p : pubblicazioni) {
                        
            if (rp.getCodicePubblicazione() == p.getCodicePubblicazione()) {
                            
              if (p.getAutore().equals(sample.getAutore())) {
                c = 1;
              }
            }
          }
        }
                
        if (c > 0) {
          userdto.setSegnalato(sample.getAutore(), true);
        } else {
          userdto.setSegnalato(sample.getAutore(), false);
        }
                
        pubblicationdto.removePubblication(id);
                
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/listReportPubblication.jsp");
        dispatcher.forward(request, response);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
