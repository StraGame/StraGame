package testControl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.ReportDetailsServlet;

class TestReportDetails {
	
	private MockHttpServletRequest request;
	private ReportDetailsServlet servlet;
	private MockHttpServletResponse response;
	
	@BeforeEach
	public void setUp() throws Exception {
		servlet=new ReportDetailsServlet();
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
	}

	@Test
	void testDetails() throws ServletException, IOException {
		
		request.addParameter("id", "1");
		request.addParameter("autore", "c.lau");
		servlet.doPost(request,response);
		
		
	}
	
	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	    
	  }

}
