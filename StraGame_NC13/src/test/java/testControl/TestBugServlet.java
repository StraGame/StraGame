package testControl;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.BugServlet;
import model.BugBean;
import model.BugDao;
import model.BugDto;

class TestBugServlet {

	private BugServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private BugDao bugdto = new BugDto();

	@BeforeEach
	public void setUp() throws Exception {
		
		servlet = new BugServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
		
	}

	@Test
	public void testBug() throws ServletException, IOException {
		
		servlet.doPost(request,response);
		try {
			ArrayList<BugBean> list = bugdto.getAllBugFilter("","");
			assertEquals(list,request.getAttribute("bugs"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void testBugFilter() throws ServletException, IOException {
		
    	request.addParameter("videogioco", "The Crew 2");
    	request.addParameter("categoria", "Bug Grafico");
		servlet.doPost(request,response);
		try {
			ArrayList<BugBean> list = bugdto.getAllBugFilter("The Crew 2","Bug Grafico");
			assertEquals(list,request.getAttribute("bugs"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
     public void testBugFilter1() throws ServletException, IOException {
		
    	request.addParameter("categoria", "Bug Grafico");
		servlet.doPost(request,response);
		try {
			ArrayList<BugBean> list = bugdto.getAllBugFilter("","Bug Grafico");
			assertEquals(list,request.getAttribute("bugs"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
     public void testBugFilter2() throws ServletException, IOException {
 		
    	request.addParameter("videogioco", "The Crew 2");
 		servlet.doPost(request,response);
 		try {
 			ArrayList<BugBean> list = bugdto.getAllBugFilter("The Crew 2","");
 			assertEquals(list,request.getAttribute("bugs"));
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
	
	

	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	}
}
