package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VideoGameBean;
import model.VideoGameDao;
import model.VideoGameDto;

/**
 * Servlet implementation class VideoGameServelet
 */
@WebServlet("/VideoGameServlet")
public class VideoGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoGameDao videogamedto=new VideoGameDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoGameServlet() {
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
		
		String label="";
		String titolo= request.getParameter("titolo");
		String genere= request.getParameter("genere");
		String descrizione=request.getParameter("descrizione");
		
		try {
			if((!"".equals(titolo)) &&(!"".equals(descrizione))) {
					if(videogamedto.getVideoGame(titolo).getNome()=="") {
						
						VideoGameBean bean= new VideoGameBean();
						
						bean.setDescrizione(descrizione);
						bean.setNome(titolo);
						bean.setGenere(genere);
						
						videogamedto.insertVideoGame(bean);
						label="Videogioco inserito con successo";
						
					} 
					else {
						label="Videogioco già presente";
					}
			} 
			else {
				label="Inserisci tutti i campi";
			}
			request.setAttribute("label", label);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newGame.jsp");
			dispatcher.forward(request, response);
			} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
