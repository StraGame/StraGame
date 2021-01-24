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
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet("/TopicServlet")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoGameDao videogiocodto = new VideoGameDto();
	private PubblicationDao pubblicationdto = new PubblicationDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicServlet() {
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
		
		ArrayList<String> list;
		ArrayList<PubblicationBean> topicListV;
		
		try {
			list = videogiocodto.getVideoGameNames();
			request.setAttribute("videogiochi", list);
			
			String videogioco=request.getParameter("videogioco");
			String categoria=request.getParameter("categoria");
			
			topicListV=pubblicationdto.getAllPubFilter(videogioco,"topic");
			request.setAttribute("topicListV", topicListV);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/topic.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
