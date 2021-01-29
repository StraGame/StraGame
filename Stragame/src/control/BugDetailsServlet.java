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

/**
 * Servlet implementation class BugDetailsServlet
 */
@WebServlet("/BugDetailsServlet")
public class BugDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BugDao bugdto= new BugDto();
	private NewsDao newsdto=new NewsDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BugDetailsServlet() {
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
		int codice= Integer.parseInt(request.getParameter("id"));
		ArrayList<NewsBean> newsList;
		
		try {
			BugBean bean= bugdto.getBug(codice);
			
			request.setAttribute("bean", bean);
			
			newsList=newsdto.getAllNews();
			request.setAttribute("news", newsList);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bugDetails.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}