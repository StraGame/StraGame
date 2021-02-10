package testControl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.BugDetailsServlet;

class TestBugDetailsServlet {

	private BugDetailsServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@BeforeEach
	void setUp() throws Exception {
		
		servlet = new BugDetailsServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
		
	}
	
	@Test
	public void testBugDetails() throws ServletException, IOException {
		
		request.addParameter("id", "1");
		servlet.doPost(request,response);
	}
	@Test
	public void testBugDetailsExc() throws ServletException, IOException {
		
		servlet.doPost(request,response);
	}
	
	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	}
}
