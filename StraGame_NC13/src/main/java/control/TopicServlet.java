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
import model.BugBean;
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
 * Servlet implementation class TopicServlet.
*/
@WebServlet("/TopicServlet")
public class TopicServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private VideoGameDao videogiocodto = new VideoGameDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private NewsDao newsdto = new NewsDto();
  private CommentDao commentdto = new CommentDto();
       
 

  public TopicServlet() {
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
    ArrayList<PubblicationBean> topicListV;
    ArrayList<NewsBean> newsList;
    ArrayList<CommentBean> comments;
        
    try {
      list = videogiocodto.getVideoGameNames();
      request.setAttribute("videogiochi", list);
            
      newsList = newsdto.getAllNews();
      request.setAttribute("news", newsList);
            
      String videogioco = request.getParameter("videogioco");
            
      topicListV = pubblicationdto.getAllPubFilter(videogioco, "topic");
      request.setAttribute("topicListV", topicListV);
            
      comments = commentdto.getAllComments();
      request.setAttribute("comments", comments);
            
      RequestDispatcher dispatcher = getServletContext()
          .getRequestDispatcher("/topic.jsp");
      dispatcher.forward(request, response);
            
    } catch (SQLException e) {
      //TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
