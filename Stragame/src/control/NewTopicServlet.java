package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class NewTopicServlet
 */
@WebServlet("/NewTopicServlet")
@MultipartConfig
public class NewTopicServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private VideoGameDao videogiocodto = new VideoGameDto();
	private PubblicationDao pubblicationdto = new PubblicationDto();
	private NewsDao newsdto=new NewsDto();
       
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
		
		String action = request.getParameter("action");
		String label="";
		//request.getSession().removeAttribute("label");
		
		if(action==null) {
		
		try {
			
			ArrayList<String> list = videogiocodto.getVideoGameNames();
			request.getSession().setAttribute("videogiochi", list);
			
			ArrayList<NewsBean> newsList=newsdto.getAllNews();
			request.getSession().setAttribute("news", newsList);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newTopic.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		else {
			
			if(request.getSession().getAttribute("username")==null) {
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newTopic.jsp");
				dispatcher.forward(request, response);
			}
			
			else {
			
			Part photo = request.getPart("foto");
			
			String autore =(String) request.getSession().getAttribute("username");
			String titolo= request.getParameter("titolo");
			String descrizione = request.getParameter("descrizione");
			String videogioco = request.getParameter("videogioco");

			try {
				if((!"".equals(titolo)) && (!"".equals(descrizione)) && (!"".equals(videogioco))) {
				
					PubblicationBean bean = new PubblicationBean();
					
					bean.setAutore(autore);
					bean.setTitolo(titolo);
					bean.setDescrizione(descrizione);
					bean.setVideogioco(videogioco);
					bean.setTipo("topic");
					bean.setPhoto(photo);
					
				
					
					pubblicationdto.insertPubblication(bean);
					
					label="Topic inserito correttamente";
					request.setAttribute("label",label);
				}
				
				
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newTopic.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
 }
}
