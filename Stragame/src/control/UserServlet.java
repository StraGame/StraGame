package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserDao;
import model.UserDto;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userdto=new UserDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		String autore =(String) request.getSession().getAttribute("username");
		
		if(action==null) {
			try {
				UserBean bean= userdto.retrieveUser(autore);
				
				String nome=bean.getNome();
				String cognome=bean.getCognome();
				String email=bean.getEmail();
				String descrizione=bean.getDescrizione();
				
				request.setAttribute("nome", nome);
				request.setAttribute("cognome", cognome);
				request.setAttribute("email", email);
				request.setAttribute("descrizione", descrizione);
				
				
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			String newDescription= request.getParameter("chagedesciption");
			try {
				
				userdto.editDescription(newDescription, autore);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
				dispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

