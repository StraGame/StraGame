package testControl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import control.LoginServlet;

class TestLoginServlet {

	private LoginServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@BeforeEach
	public void setUp() throws Exception {
		
		servlet = new LoginServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
	}

	@Test
	void testLoginSuccess() throws ServletException, IOException {
		request.addParameter("username","adm12345");
		request.addParameter("password","ciao1234");
		servlet.doPost(request,response);
		response.getRedirectedUrl();
	}
	
	@Test
	void testLoginAdminSuccess() throws ServletException, IOException {
		request.addParameter("username","vincenzoStrano");
		request.addParameter("password","ciao1234");
		servlet.doPost(request,response);
		response.getRedirectedUrl();
	}
	
	@Test
	void testLoginFailure() throws ServletException, IOException {
		request.addParameter("username","vincenzoStrano");
		request.addParameter("password","ciao12345");
		servlet.doPost(request,response);
		response.getRedirectedUrl();
	}
	
	@Test
	void testLoginFailure1() throws ServletException, IOException {
		request.addParameter("username","vincenzoS");
		request.addParameter("password","ciao1234");
		servlet.doPost(request,response);
		response.getRedirectedUrl();
	}
	
	@Test
	void testLoginFailure2() throws ServletException, IOException {
		request.addParameter("username","vincenzoS");
		request.addParameter("password","ciao12345");
		servlet.doPost(request,response);
		response.getRedirectedUrl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
}
