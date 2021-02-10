package testControl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.UserCheckServlet;

class TestUserCheckServlet {

	private MockHttpServletRequest request;
	private UserCheckServlet servlet;
	private MockHttpServletResponse response;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		servlet=new UserCheckServlet();
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
	}

	@Test
	void testUserCheck() throws ServletException, IOException {
		
		request.addParameter("username", "adm12345");
		servlet.doPost(request, response);
		assertEquals("text/html",response.getContentType());
	}
	
	@Test
	void testUserCheckNull() throws ServletException, IOException {
		
		servlet.doPost(request, response);
		assertEquals("text/html",response.getContentType());
	}
	
	@AfterEach
	void tearDown() throws Exception {
		
		servlet = null;
	    request = null;    
	    response = null;
	    
	}

}
