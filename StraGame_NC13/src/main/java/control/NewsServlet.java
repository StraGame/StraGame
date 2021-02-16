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

/**
 * Servlet implementation class newsServlet.
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private NewsDao newsdto = new NewsDto();
       
  
  public NewsServlet() {
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
        
    ArrayList<NewsBean> list = new ArrayList<NewsBean>();
        
    try {
               
      list = newsdto.getAllNews();
      request.setAttribute("news", list);
                
      RequestDispatcher dispatcher = 
          getServletContext().getRequestDispatcher("/news.jsp");
      dispatcher.forward(request, response);
            
            
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
