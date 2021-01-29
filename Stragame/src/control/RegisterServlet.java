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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private UserDao userdto = new UserDto();   
    /**
     * @see HttpServlet#HttpServlet()
     */
 
    public RegisterServlet() {
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
		
		
		String label;
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		String email=request.getParameter("email");
		
		
		try {
			if(userdto.retrieveUser(username).getNickname()=="") {
				
				UserBean bean = new UserBean();
				
				bean.setNome(nome);
				bean.setCognome(cognome);
				bean.setNickname(username);
				bean.setPassword(password);
				bean.setEmail(email);
				bean.setRuolo("user");
				bean.setSegnalato(false);
				
				userdto.insertUser(bean);
				label="registrazione riuscita";
					
				}
				
				else { 
					
					label="nickname già scelto, provare con un altro nickname.";
				}
				
			request.setAttribute("label", label);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signUp.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		
	}

}
