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

import control.NewBugServlet;

class TestNewBugServlet {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private NewBugServlet servlet;
	
	@BeforeEach
	void setUp() throws Exception {
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
		servlet=new NewBugServlet();
	}

	@Test
	void TC_4_1_1() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("autore","adm12345");
		request.addParameter("titolo", "");
		
		String oracle= "Il titolo non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_1_1() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("autore","adm12345");
		request.addParameter("titolo", "as");
		
		String oracle= "Il titolo non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_1_2() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("autore","adm12345");
		request.addParameter("titolo", "Questo titolo deve avere pi� di quarantacinque caratteri");
		
		String oracle= "Il titolo non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_2() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo&");
		
		String oracle= "Il titolo non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_3() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "");
		
		String oracle= "La categoria non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_3_1() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "a");
		
		String oracle= "La categoria non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_3_2() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Questa categoria deve avere pi� di quarantacinque caratteri");
		
		String oracle= "La categoria non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_4() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Bug Grafico&");
		
		String oracle= "La categoria non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}

	@Test
	void TC_4_1_5() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Bug Grafico");
		request.addParameter("videogioco", "");
		
		String oracle= "Il videogioco non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_5_1() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Bug Grafico");
		request.addParameter("videogioco", "a");
		
		String oracle= "Il videogioco non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_5_2() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Bug Grafico");
		request.addParameter("videogioco", "Questo videogioco deve avere pi� di quarantacinque caratteri");
		
		String oracle= "Il videogioco non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_6() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Bug Grafico");
		request.addParameter("videogioco", "The Crew 2&");
		
		String oracle= "Il videogioco non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_7() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Bug Grafico");
		request.addParameter("videogioco", "The Crew 2");
		request.addParameter("descrizione", "");
		
		String oracle= "La descrizione non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_7_1() {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Bug Grafico");
		request.addParameter("videogioco", "The Crew 2");
		request.addParameter("descrizione", "Questa descrizione dovrebbe avere trecentouno caratteri, ma sinceramente non so che scrivere quindi ricompio. Questa descrizione dovrebbe avere trecentouno caratteri, ma sinceramente non so che scrivere quindi ricompio. Questa descrizione dovrebbe avere trecentouno caratteri, ma sinceramente non so che scrivere quindi ricompio. ");
		
		String oracle= "La descrizione non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_1_8() throws ServletException, IOException {
		request.addParameter("action","insert");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("titolo", "titolo");
		request.addParameter("categoria", "Bug Grafico");
		request.addParameter("videogioco", "The Crew 2");
		request.addParameter("descrizione", "Descrizione del Bug grafico");

		servlet.doPost(request,response);
	}
	
	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	}
}
