package testControl;



import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.GetPhoto;

class TestGetPhoto {

	private GetPhoto servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@BeforeEach
	public void setUp() throws Exception {
		
		servlet = new GetPhoto();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
	}

	@Test
	void testGetPhotoUser() throws ServletException, IOException {
		request.addParameter("action", "user");
		request.addParameter("username","a.adm");
		servlet.doPost(request,response);
		assertEquals("image/jpeg", response.getContentType());
	}
	
	@Test
	void testGetPhotoUserNull() throws ServletException, IOException {
		request.addParameter("action", "user");
		request.addParameter("username","adm12345");
		servlet.doPost(request,response);
		assertEquals(null, response.getContentType());
	}
	
	@Test
	void testGetPhotoPubblication() throws ServletException, IOException {
		request.addParameter("action", "pubblication");
		request.addParameter("id","3249");
		servlet.doPost(request,response);
		assertEquals("image/jpeg", response.getContentType());
	}
	
	@Test
	void testGetPhotoPubblicationNull() throws ServletException, IOException {
		request.addParameter("action", "pubblication");
		request.addParameter("id","3264");
		servlet.doPost(request,response);
		response.getContentType();
		assertEquals(null, response.getContentType());
	}
	
	@Test
	void testGetPhotoNews() throws ServletException, IOException {
		request.addParameter("action", "news");
		request.addParameter("id","6");
		servlet.doPost(request,response);
		assertEquals("image/jpeg", response.getContentType());
	}
	
	@Test
	void testGetPhotoNewsNull() throws ServletException, IOException {
		request.addParameter("action", "news");
		request.addParameter("id","1");
		servlet.doPost(request,response);
		response.getContentType();
		assertEquals(null, response.getContentType());
	}
	
	@Test
	void testGetPhotoVideoGame() throws ServletException, IOException {
		request.addParameter("action", "videogame");
		request.addParameter("nome","The Crew 2");
		servlet.doPost(request,response);
		assertEquals("image/jpeg", response.getContentType());
	}
	
	@AfterEach
	void tearDown() throws Exception {
		servlet=null;
		request=null;
		response=null;
	}

}
