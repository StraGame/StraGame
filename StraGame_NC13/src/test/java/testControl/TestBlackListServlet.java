package testControl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.BlackListServlet;

class TestBlackListServlet {

	private BlackListServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

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
	}
	
	@Test
	public void deleteUser() throws ServletException, IOException {
		
		request.addParameter("action", "deleteUser");
		request.addParameter("nickname", "giogiogiorgio");
		servlet.doPost(request,response);
	}

	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	}
}
