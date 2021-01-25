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

import model.BugDao;
import model.BugDto;
import model.NewsBean;
import model.NewsDao;
import model.NewsDto;
import model.BugBean;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class NewBugServlet
 */
@WebServlet("/NewBugServlet")
public class NewBugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoGameDao videogiocodto = new VideoGameDto();
    private BugDao bugdto= new BugDto();
    private NewsDao newsdto=new NewsDto();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBugServlet() {
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
		String action = request.getParameter("action");

		if(action==null) {
			
			try {
				
				ArrayList<String> list = videogiocodto.getVideoGameNames();
				request.setAttribute("videogiochi", list);
				
				ArrayList<NewsBean> newsList=newsdto.getAllNews();
				request.setAttribute("news", newsList);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newBug.jsp");
				dispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String label="";
			String autore =(String) request.getSession().getAttribute("username");
			String titolo= request.getParameter("titolo");
			String descrizione = request.getParameter("descrizione");
			String videogioco = request.getParameter("videogioco");
			String categoria = request.getParameter("categoria");
			
			try {
				if(!"".equals(titolo)) {
					
					if(!"".equals(descrizione)) {
						
						if(!"".equals(categoria)) {
							
							if(!"".equals(videogioco)) {
								
								BugBean bean= new BugBean();
								
								bean.setAutore(autore);
								bean.setCategoria(categoria);
								bean.setVideogioco(videogioco);
								bean.setTitolo(titolo);
								bean.setTesto(descrizione);
								
								bugdto.insertBug(bean);
								label="Segnalazione Bug inserita con successo";
							}
							else {
								label="Ricorda: devi selezionare un videogioco";
							}
						}
						else {
							label="Ricorda: devi selezionare una categoria";
						}
					}
					else {
						label="Ricorda: devi inserire una descrizione";
					}
				}
				else {
					label="Ricorda: devi inserire un titolo";
				}
				request.setAttribute("label", label);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newBug.jsp");
				dispatcher.forward(request, response);
				
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
