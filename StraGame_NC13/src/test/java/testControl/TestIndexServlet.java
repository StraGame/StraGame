package testControl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.IndexServlet;

class TestIndexServlet {
	
	private IndexServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@BeforeEach
	public void setUp() throws Exception {
		
		servlet = new IndexServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
	}
	@Test
	void test() throws ServletException, IOException {
		servlet.doPost(request,response);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		servlet=null;
		request=null;
		response=null;
	}

}
