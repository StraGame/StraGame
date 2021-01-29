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
import model.CommentBean;
import model.CommentDao;
import model.CommentDto;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.VideoGameBean;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PubblicationDao pubblicationdto= new PubblicationDto();
	private NewsDao newsdto=new NewsDto();
	private BugDao bugdto = new BugDto();
	private VideoGameDao gamedto= new VideoGameDto();
	private CommentDao commentdto= new CommentDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		// TODO Auto-generated method stub
		ArrayList<PubblicationBean> reviewList;
		ArrayList<PubblicationBean> topicList;
		ArrayList<NewsBean> newsList;
		ArrayList<BugBean> bugList;
		ArrayList<VideoGameBean> game;
		ArrayList<CommentBean> comments;
		
		try {
			reviewList=pubblicationdto.getPubsByTipo("recensione");
			request.setAttribute("recensioni", reviewList);
			
			topicList=pubblicationdto.getPubsByTipo("topic");
			request.setAttribute("topic", topicList);
			
			newsList=newsdto.getAllNews();
			request.setAttribute("news", newsList);
			
			bugList=bugdto.getAllBug();
			request.setAttribute("bug", bugList);
			
			game=gamedto.getAllVideoGame();
			request.setAttribute("game", game);
			
			comments=commentdto.getAllComments();
			request.setAttribute("comments",comments);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
