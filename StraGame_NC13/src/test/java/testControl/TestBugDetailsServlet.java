package testControl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.BugDetailsServlet;
import model.BugBean;
import model.BugDao;
import model.BugDto;

class TestBugDetailsServlet {

	private BugDetailsServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private BugDao bugdto = new BugDto();

	@BeforeEach
	void setUp() throws Exception {
		
		servlet = new BugDetailsServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
		
	}
	
	@Test
	public void testBugDetails() throws ServletException, IOException {
		
		request.addParameter("id", "7");
		servlet.doPost(request,response);
		try {
			BugBean bean = bugdto.getBug(7);
			assertEquals(bean,request.getAttribute("bean"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testBugDetailsExc() throws ServletException, IOException {
		
		 assertThrows(NumberFormatException.class,() -> {
			servlet.doPost(request,response);
		});
		
		
		
	}
	
	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	}
}
