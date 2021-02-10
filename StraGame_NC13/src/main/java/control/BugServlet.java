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
import model.BugDao;
import model.BugDto;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class BugServlet.
 */
@WebServlet("/BugServlet")
public class BugServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private VideoGameDao videogiocodto = new VideoGameDto();
  private BugDao bugdto = new BugDto();
  private NewsDao newsdto = new NewsDto();
       
  /**
     * @see HttpServlet#HttpServlet()
  */
  public BugServlet() {
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

    ArrayList<String> list;
    ArrayList<BugBean> bugListV;
    ArrayList<NewsBean> newsList;
            
    try {
      list = videogiocodto.getVideoGameNames();
      request.setAttribute("videogiochi", list);
                
      String videogioco = request.getParameter("videogioco");
      String categoria = request.getParameter("categoria");
                
      bugListV = bugdto.getAllBugFilter(videogioco, categoria);
      request.setAttribute("bugListV", bugListV);
                
      newsList = newsdto.getAllNews();
      request.setAttribute("news", newsList);
                
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bug.jsp");
      dispatcher.forward(request, response);
                
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
