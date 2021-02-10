package testControl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.TopicDetailsServlet;

class TestTopicDetails {

	private MockHttpServletRequest request;
	private TopicDetailsServlet servlet;
	private MockHttpServletResponse response;
	
	@BeforeEach
	public void setUp() throws Exception {
		servlet=new TopicDetailsServlet();
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
	}

	@Test
	public void testTopicDetails() throws ServletException, IOException {
		
		request.setParameter("id","1");
		servlet.doPost(request,response);
		assertEquals("text/html",response.getContentType());
	}
	
	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	    
	  }

}
