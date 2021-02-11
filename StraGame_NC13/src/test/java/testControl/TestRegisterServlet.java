package testControl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.RegisterServlet;
import model.UserBean;
import model.UserDao;
import model.UserDto;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestRegisterServlet {

	private MockHttpServletRequest request;
	private RegisterServlet servlet;
	private MockHttpServletResponse response;
	private UserDao userdto= new UserDto();
	
	/**
	 * Testing Registrazioni
	 * istanziamento
	 */
	@BeforeEach
	public void setUp() throws Exception {
		servlet=new RegisterServlet();
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
	}

	@Test
	public void TC_2_1_1() {
		request.addParameter("nome","");
		String oracle="Il nome non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_1_1() {
		request.addParameter("nome","q");
		String oracle="Il nome non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_1_2() {
		request.addParameter("nome","Marioooooooooooooooooooooooo");
		String oracle="Il nome non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_2() {
		request.addParameter("nome","Mario1");
		String oracle="Il nome non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_3() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","");
		String oracle="Il cognome non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_3_1() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","a");
		String oracle="Il cognome non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_3_2() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		String oracle="Il cognome non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_4() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi*2");
		String oracle="Il cognome non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_5() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "");
		String oracle="L'username non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_5_1() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "sd");
		String oracle="L'username non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_5_2() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "pippoooooooooooooooooooooooooooooooo");
		String oracle="L'username non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_6() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mario&");
		String oracle="L'username non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void duplicateUsername() throws ServletException, IOException {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "adm12345");
				
		String oracle="Username già presente";
		servlet.doPost(request, response);
		assertEquals(oracle,request.getAttribute("label"));
	}
	
	@Test
	public void TC_2_1_7() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "");
		
		String oracle="La password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_7_1() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "ciao");
		
		String oracle="La password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_7_2() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "ciaooooooooooooooooooooooooooooooooooooooooooo22");
		
		String oracle="La password non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_8() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "Ciao1234&");
		
		String oracle="La password non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_8_1() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "Ciao1234");
		request.addParameter("confirmedPassword", "Ciao12345");
		
		String oracle="Le due password non corrispondono";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_9() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "Ciao1234");
		request.addParameter("confirmedPassword", "Ciao1234");
		request.addParameter("email", "");
		
		String oracle="L'email non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_9_1() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "Ciao1234");
		request.addParameter("confirmedPassword", "Ciao1234");
		request.addParameter("email", "sd@yahoo");
		
		String oracle="L'email non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_9_2() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "Ciao1234");
		request.addParameter("confirmedPassword", "Ciao1234");
		request.addParameter("email", "sdsssssssssssssssssssssssssssssssssssss@yahoo.it");
		
		String oracle="L'email non rispetta la lunghezza";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_10() {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "Ciao1234");
		request.addParameter("confirmedPassword", "Ciao1234");
		request.addParameter("email", "mariorossiyahoo.it");
		
		String oracle="L'email non rispetta il formato";
		
		IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,() -> {
			servlet.doPost(request,response);
		});
		assertEquals(oracle,exception.getMessage());		
	}
	
	@Test
	public void TC_2_1_11() throws ServletException, IOException {
		request.addParameter("nome","Mario");
		request.addParameter("cognome","Rossi");
		request.addParameter("username", "Mariomaff");
		request.addParameter("password", "Ciao1234");
		request.addParameter("confirmedPassword", "Ciao1234");
		request.addParameter("email", "mariorossi@yahoo.it");
		servlet.doPost(request, response);
	}
	
	@AfterEach
	  public void tearDown() {
	    servlet = null;
	    request = null;    
	    response = null;
	 
	  }
	
	@AfterAll
	public void restoreData() {
		
	try {
		UserBean user = userdto.retrieveUser("Mariomaff");
		if(user.getNickname().equals("Mariomaff")) {
		  userdto.removeUser("MarioMaff");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
