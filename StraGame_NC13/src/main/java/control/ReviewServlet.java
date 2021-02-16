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
import model.VideoGameDao;
import model.VideoGameDto;

/**
  * Servlet implementation class NewReviewServlet.
*/
@WebServlet("/ReviewServlet")

public class ReviewServlet extends HttpServlet {
    
  private static final long serialVersionUID = 1L;
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private VideoGameDao videogiocodto = new VideoGameDto();
  private NewsDao newsdto = new NewsDto();
  private CommentDao commentdto = new CommentDto();
       

  public ReviewServlet() {
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
        
    ArrayList<String> list;
    ArrayList<PubblicationBean> reviewList;
    ArrayList<NewsBean> newsList;
    ArrayList<CommentBean> comments;
        
    try {
      list = videogiocodto.getVideoGameNames();
      request.setAttribute("videogiochi", list);
            
      String videogioco = request.getParameter("videogioco");
            
      reviewList = pubblicationdto.getAllPubFilter(videogioco, "recensione");
      request.setAttribute("recensioni", reviewList);
            
      newsList = newsdto.getAllNews();
      request.setAttribute("news", newsList);
            
      comments = commentdto.getAllComments();
      request.setAttribute("comments", comments);
            
      RequestDispatcher dispatcher = getServletContext()
          .getRequestDispatcher("/review.jsp");
      dispatcher.forward(request, response);
            
    } catch (SQLException e) {
      //TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}


