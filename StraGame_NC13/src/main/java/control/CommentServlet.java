package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CommentBean;
import model.CommentDao;
import model.CommentDto;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;

/**
 * Servlet implementation class CommentServlet.
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private CommentDao commentdto = new CommentDto();
  private PubblicationDao pubblicationdto = new PubblicationDto();
       
 
  public CommentServlet() {
    super();
    // TODO Auto-generated constructor stub
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    //    TODO Auto-generated method stub
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
        
    String nickname = (String) request.getSession().getAttribute("username");
    System.out.println(nickname);
        
    int id = Integer.parseInt(request.getParameter("id"));
        
    CommentBean comment = new CommentBean();
    comment.setAutore(nickname);
    comment.setTesto(request.getParameter("commentText"));
    comment.setCodicePubblicazione(id);
        
    try {
      commentdto.insertComment(comment);
            
      PubblicationBean bean = pubblicationdto.getPubblication(id);
      System.out.println("codice nella servlet: " + bean.getCodicePubblicazione());
      System.out.println("tipo della pubblicazione: " + bean.getTipo()); 
            
      if (bean.getTipo().equals("recensione")) {
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/ReviewDetailsServlet?id=" + id);
        dispatcher.forward(request, response);
            
      } else {
                
        RequestDispatcher dispatcher = 
            getServletContext().getRequestDispatcher("/topicDetailsServlet?id=" + id);
        dispatcher.forward(request, response);
                
      }
            
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
        
        
        
  }

}
