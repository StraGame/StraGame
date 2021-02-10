package testControl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.ReportPubblicationServlet;
import model.ReportPubblicationDao;
import model.ReportPubblicationDto;
import model.UserDao;
import model.UserDto;

class TestReportPubblicationServlet {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private ReportPubblicationServlet servlet;
	private ReportPubblicationDao reportdto=new ReportPubblicationDto();
	private UserDao userdto= new UserDto();
	
	@BeforeEach
	void setUp() throws Exception {
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
		servlet=new ReportPubblicationServlet();
	}

	@Test
	void TC_4_4_1() {
		request.addParameter("action","insert");
		request.addParameter("id", "3240");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("testo", "");
		
		String oracle="Il testo non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_4_1_1() {
		request.addParameter("action","insert");
		request.addParameter("id", "3240");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("testo", "devo scrivere pi� di 300 caratteri, non so che scrivere quindi ricopio. devo scrivere pi� di 300 caratteri, non so che scrivere quindi ricopio. devo scrivere pi� di 300 caratteri, non so che scrivere quindi ricopio. devo scrivere pi� di 300 caratteri, non so che scrivere quindi ricopio. devo scrivere pi� di 300 caratteri, non so che scrivere quindi ricopio.");
		
		String oracle="Il testo non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_4_2() {
		request.addParameter("action","insert");
		request.addParameter("id", "3240");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("testo", "Testo della segnalazione");
		request.addParameter("categoria", "");
		
		String oracle="La categoria non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_4_2_1() {
		request.addParameter("action","insert");
		request.addParameter("id", "3240");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("testo", "Testo della segnalazione");
		request.addParameter("categoria", "as");
		
		String oracle="La categoria non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_4_2_2() {
		request.addParameter("action","insert");
		request.addParameter("id", "3240");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("testo", "Testo della segnalazione");
		request.addParameter("categoria", "Questa categoria deve essere lunga pi� di quarantacinque caratteri");
		
		String oracle="La categoria non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_4_3() {
		request.addParameter("action","insert");
		request.addParameter("id", "3240");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("testo", "Testo della segnalazione");
		request.addParameter("categoria", "categoria1");
		
		String oracle="La categoria non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	void TC_4_4_4() {
		request.addParameter("action","insert");
		request.addParameter("id", "3232");
		request.getSession().setAttribute("username","adm12345");
		request.addParameter("testo", "Testo della segnalazione");
		request.addParameter("categoria", "Spam");
		
		String oracle="";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
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
	    try {
			reportdto.removeReportPubblication(3240, "adm12345");
			userdto.setSegnalato("adm12345", false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
