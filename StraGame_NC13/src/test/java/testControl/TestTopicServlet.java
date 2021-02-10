package testControl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.TopicServlet;

class TestTopicServlet {

	private MockHttpServletRequest request;
	private TopicServlet servlet;
	private MockHttpServletResponse response;
	
	@BeforeEach
	public void setUp() throws Exception {
		servlet=new TopicServlet();
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
	}

	@Test
	void topicTest() throws ServletException, IOException {
		
		servlet.doPost(request,response);
		assertEquals("text/html",response.getContentType());
	}

	@AfterEach
	void tearDown() throws Exception {
		
		servlet = null;
	    request = null;    
	    response = null;
	    
	}

}
