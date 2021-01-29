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
 * Servlet implementation class TopicDetailsServlet
 */
@WebServlet("/TopicDetailsServlet")
public class TopicDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PubblicationDao pubblicationdto = new PubblicationDto();
	private NewsDao newsdto = new NewsDto();
	private CommentDao commentdto = new CommentDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println("stampo id da get Parameter: "+id);
		int codicepubblicazione = Integer.parseInt(id);
		ArrayList<NewsBean> newsList;
		ArrayList<CommentBean> comments;
		
		System.out.println("id arrivato nella servlet:"+ id);
		
		try {
			PubblicationBean bean =pubblicationdto.getPubblication(codicepubblicazione);
			request.setAttribute("pubblication",bean);
			
			newsList=newsdto.getAllNews();
			request.setAttribute("news", newsList);
			
			comments=commentdto.getCommentsbyPubblication(codicepubblicazione);
			request.setAttribute("comments",comments);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/topicDetails.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}