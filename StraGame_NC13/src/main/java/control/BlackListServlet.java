package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BugBean;
import model.BugDao;
import model.BugDto;
import model.CommentDao;
import model.CommentDto;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.ReportPubblicationDao;
import model.ReportPubblicationDto;
import model.UserBean;
import model.UserDao;
import model.UserDto;

/**
 * Servlet implementation class BlackListServlet.
 */
@WebServlet("/BlackListServlet")
public class BlackListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserDao userdto = new UserDto();
  private NewsDao newsdto = new NewsDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
  private CommentDao commentdto = new CommentDto();
  private ReportPubblicationDao reportdto = new ReportPubblicationDto();
  private BugDao bugdto = new BugDto();
       
  /**
     * @see HttpServlet#HttpServlet()
     */
  public BlackListServlet() {
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
    	System.out.println();
    	System.out.println();
      try {
        ArrayList<UserBean> users = userdto.retrieveAllReportUser();
        request.setAttribute("users", users);
      
        ArrayList<NewsBean> newsList = newsdto.getAllNews();
        request.setAttribute("news", newsList);
      
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/blackList.jsp");
        dispatcher.forward(request, response);
      
      
      } catch (SQLException e) {
      
        e.printStackTrace(); // TODO Auto-generated catch block
      }
    
    } else {
      String nickname = request.getParameter("nickname");
      
      try {
        ArrayList<PubblicationBean> pubblicazioni = pubblicationdto.getAllPubblication();
        for (PubblicationBean p : pubblicazioni) {
          if (p.getAutore().equals(nickname)) {
            reportdto.removeAllReportByPub(p.getCodicePubblicazione());
            commentdto.removeAllCommentByPub(p.getCodicePubblicazione());
            pubblicationdto.removePubblication(p.getCodicePubblicazione());
            
          }
        }
        ArrayList<BugBean> bugs = bugdto.getAllBug();

        for (BugBean b : bugs) {
          if (b.getAutore().equals(nickname)) {
            bugdto.removeBug(b.getCodicebug());
          }
        }

        userdto.removeUser(nickname);
        
        ServletContext ctx = this.getServletContext();
        
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/blackList.jsp");
        dispatcher.forward(request, response);
        
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}
