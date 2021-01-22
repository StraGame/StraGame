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

import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class NewTopicServlet
 */
@WebServlet("/NewTopicServlet")
public class NewTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		VideoGameDao videogiocodto = new VideoGameDto();
		PubblicationDao pubblicationdto = new PubblicationDto();
		
		
		String action = request.getParameter("action");
		String label="";
		
		if(action==null) {
		
		try {
			
			ArrayList<String> list = videogiocodto.getVideoGameNames();
			request.setAttribute("videogiochi", list);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newTopic.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		}
		
		else {
			
			String autore =(String) request.getSession().getAttribute("username");
			String titolo= request.getParameter("titolo");
			String descrizione = request.getParameter("descrizione");
			String videogioco = request.getParameter("videogioco");
			
			PubblicationBean bean = new PubblicationBean();
			
			bean.setAutore(autore);
			bean.setTitolo(titolo);
			bean.setDescrizione(descrizione);
			bean.setVideogioco(videogioco);
			
			try {
				pubblicationdto.insertPubblication(bean);
				label="topic inserito correttamente";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				label="topic non inserito";
			}
			
			request.setAttribute("label",label);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newTopic.jsp");
			dispatcher.forward(request, response);
			
			
			
		}
		
		
		
		
	}

}
