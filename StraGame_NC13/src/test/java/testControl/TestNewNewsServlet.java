package testControl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockPart;

import control.NewNewsServlet;

class TestNewNewsServlet {

	private MockHttpServletRequest request;
	private NewNewsServlet servlet;
	private MockHttpServletResponse response;
	
	@BeforeEach
	public void setUp() throws Exception {
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
		servlet=new NewNewsServlet();
	}

	@Test
	public void TC_3_1_1() {
		request.addParameter("titolo", "");
		request.addParameter("action", "insert");
		request.getSession().setAttribute("username","adm12345");
		String oracle="Il titolo non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_3_1_1_1() {
		request.addParameter("titolo", "ciao");
		request.addParameter("action", "insert");
		request.getSession().setAttribute("username","adm12345");
		String oracle="Il titolo non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_3_1_1_2() {
		request.addParameter("titolo", "ciaociaociaociaociaociaociaociaociaociaociaociao");
		request.addParameter("action", "insert");
		request.getSession().setAttribute("username","adm12345");
		String oracle="Il titolo non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_3_1_2() {
		request.addParameter("titolo", "*123&Ciao");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("action", "insert");
		String oracle="Il titolo non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_3_1_3() {
		request.addParameter("action", "insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "Nuova news");
		request.addParameter("descrizione", "");
		String oracle="La descrizione non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_3_1_3_1() {
		request.addParameter("action", "insert");
		request.addParameter("titolo", "Nuova news");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("descrizione", "La descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezzaLa descrizione non rispetta la lunghezza");
		String oracle="La descrizione non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_3_1_4() throws ServletException, IOException {
		request.addParameter("action", "insert");
		request.addParameter("titolo", "Nuova news");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("descrizione", "Questa è la descrizione");
		byte[] b = new byte[20];
	    MockPart part = new MockPart("photo", "", b);
	    request.addPart(part);
		servlet.doPost(request,response);
		
	}
	
	@Test
	public void actionNull() throws ServletException, IOException {
		servlet.doPost(request,response);
	}
	
	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	}

}
