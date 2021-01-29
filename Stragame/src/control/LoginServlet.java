package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.UserBean;
import model.UserDao;
import model.UserDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userdto = new UserDto();
		
		String redirectedPage="";
		
			try {
				
				UserBean user = userdto.retrieveUser(username);
				
				if(user.getNickname().equals(username)&& user.getPassword().equals(password)) {
				if(user.getRuolo().equals("user")) {
				request.getSession().setAttribute("adminRoles", new Boolean(false));
				request.getSession().setAttribute("username",username);
				
				redirectedPage = "/index.jsp";//reindirizza a servlet productControlAdmin
				}
				else
				{
					request.getSession().setAttribute("adminRoles", new Boolean(true));
					request.getSession().setAttribute("username",username);
					redirectedPage="/index.jsp"; //reindirizza a servlet product control
				}
				
				}
				
				else {
					 
					request.getSession().setAttribute("adminRoles", new Boolean(false));
					redirectedPage = "/index.jsp";
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}
		
	
	

}
