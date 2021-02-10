package testControl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.BugServlet;

class TestBugServlet {

	private BugServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@BeforeEach
	public void setUp() throws Exception {
		
		servlet = new BugServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
		
	}

	@Test
	public void testBug() throws ServletException, IOException {
		
		servlet.doPost(request,response);
	}

	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	}
}
