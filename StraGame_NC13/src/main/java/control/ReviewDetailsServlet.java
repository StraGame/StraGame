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
import model.CommentBean;
import model.CommentDao;
import model.CommentDto;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;

/**
 * Servlet implementation class ReviewDetailsServlet.
 */
@WebServlet("/ReviewDetailsServlet")
public class ReviewDetailsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private NewsDao newsdto = new NewsDto();
  private CommentDao commentdto = new CommentDto();
       
  /**
     * @see HttpServlet#HttpServlet()
     */
  public ReviewDetailsServlet() {
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
        
    int codicepubblicazione = Integer.parseInt(request.getParameter("id"));
    ArrayList<NewsBean> newsList;
    ArrayList<CommentBean> comments;
        
    try {
      PubblicationBean bean = pubblicationdto.getPubblication(codicepubblicazione);
            
      request.setAttribute("bean", bean);
            
      newsList = newsdto.getAllNews();
      request.setAttribute("news", newsList);
            
      comments = commentdto.getCommentsbyPubblication(codicepubblicazione);
      request.setAttribute("comments", comments);
            
      RequestDispatcher dispatcher = getServletContext()
          .getRequestDispatcher("/reviewDetails.jsp");
      dispatcher.forward(request, response);
            
            
    } catch (SQLException e) {
      //TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
