package testControl;



import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.BlackListServlet;
import model.UserBean;
import model.UserDao;
import model.UserDto;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestBlackListServlet {

	private BlackListServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private UserDao userdto = new UserDto();

	@BeforeEach
	void setUp() throws Exception {
		
		servlet = new BlackListServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
		
	}


	@Test
	public void retrieveUtentiSegnalati() throws ServletException, IOException {
		
		request.getSession().setAttribute("adminRoles", true);
		servlet.doPost(request,response);
		try {
			ArrayList<UserBean> list = userdto.retrieveAllReportUser();
			assertEquals(list,request.getAttribute("users"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deleteUser() throws ServletException, IOException {
		
		request.addParameter("action", "deleteUser");
		request.addParameter("nickname", "giorgiogiorgio");
		servlet.doPost(request,response);
	}

	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	}
	
	@AfterAll
	public void restoreData() {
		UserBean user = new UserBean();
		user.setNickname("giorgiogiorgio");
		user.setCognome("Giorgio");
		user.setNome("Giorgio");
		user.setRuolo("user");
		user.setEmail("giorgio.gio@yahoo.it");
		user.setPassword("ciao1234");
		user.setDescrizione("loll");
		user.setSegnalato(false);
		try {
			userdto.insertUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
