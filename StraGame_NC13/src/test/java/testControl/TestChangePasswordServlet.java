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

import control.ChangePasswordServlet;
import model.UserDao;
import model.UserDto;

class TestChangePasswordServlet {

	private MockHttpServletRequest request;
	private ChangePasswordServlet servlet;
	private MockHttpServletResponse response;
	private UserDao userdto= new UserDto();
	
	@BeforeEach
	public void setUp() throws Exception {
		servlet=new ChangePasswordServlet();
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
	}

	@Test
	public void TC_2_2_1() {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "");
		
		String oracle="La vecchia password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_2_2_1_1() {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "qwe");
		
		String oracle="La vecchia password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_2_2_1_2() {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		
		String oracle="La vecchia password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_2_2_2() {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "Ciao12£*.");
		
		String oracle="La vecchia password non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void oldPasswordError() throws ServletException, IOException {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "ciao1235");
		request.addParameter("newpassword", "ciao1235");
		request.addParameter("repeatpassword", "ciao1235");
		
		String oracle="La vecchia password non è corretta";
		servlet.doPost(request, response);
		assertEquals(oracle,request.getAttribute("label"));
	}
	
	@Test
	public void TC_2_2_3() {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "ciao1234");
		request.addParameter("newpassword", "");
		
		String oracle="La nuova password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_2_2_3_1() {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "ciao1234");
		request.addParameter("newpassword", "ciao");
		
		String oracle="La nuova password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_2_2_3_2() {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "ciao1234");
		request.addParameter("newpassword", "ciaoooooooooooooooooooooooooooooooooooooooooooo");
		
		String oracle="La nuova password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void TC_2_2_4() {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "ciao1234");
		request.addParameter("newpassword", "ciao123&.!");
		
		String oracle="La nuova password non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());
	}
	
	@Test
	public void passwordMatchError() throws ServletException, IOException {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "ciao1234");
		request.addParameter("newpassword", "ciao1234");
		String oracle="La nuova e la vecchia password coincidono";
	    servlet.doPost(request,response);
		assertEquals(oracle,request.getAttribute("label"));
	}
	
	@Test
	public void passwordMismatch() throws ServletException, IOException {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "ciao1234");
		request.addParameter("newpassword", "ciao1235");
		request.addParameter("repeatpassword", "ciao1236");
		String oracle="La password ripetuta non coincide con la nuova password";
		servlet.doPost(request,response);
		assertEquals(oracle,request.getAttribute("label"));
	}
	
	@Test
	public void TC_2_2_5() throws ServletException, IOException {
		request.getSession().setAttribute("username", "adm12345");
		request.addParameter("oldpassword", "ciao1234");
		request.addParameter("newpassword", "ciao1235");
		request.addParameter("repeatpassword", "ciao1235");
		servlet.doPost(request, response);
	}

	@AfterEach
	public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	    try {
			userdto.editPassword("ciao1234", "adm12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
