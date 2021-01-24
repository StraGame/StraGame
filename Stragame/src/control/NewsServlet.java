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
 * Servlet implementation class newsServlet
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NewsDao newsdto= new NewsDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
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
		System.out.println(action);
		
		if(action==null) {
			
			ArrayList<NewsBean> list = new ArrayList<NewsBean>();
			
		   try {
			   
			list = newsdto.getAllNews();
			request.setAttribute("news", list);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/news.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
		}
		
		else {
		String label="";
		String titolo=request.getParameter("titolo");
		String descrizione=request.getParameter("descrizione");
		String autore =(String) request.getSession().getAttribute("username");
		
		
		
		try {
			if(!"".equals(titolo)) {
				
				if(!"".equals(descrizione)) {
					NewsBean bean = new NewsBean();
					
					bean.setAutore(autore);
					bean.setTesto(descrizione);
					bean.setTitolo(titolo);
					
					newsdto.insertNews(bean);
					label="News inserita con successo";
				}
				
				else {
					label="Ricorda: devi inserire una descrizione";
				}
			}
			else {
				label="Ricorda: devi inserire un titolo";
			}
			
			request.setAttribute("label", label);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newNews.jsp");
			dispatcher.forward(request, response);
			
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		
		
	}

}
