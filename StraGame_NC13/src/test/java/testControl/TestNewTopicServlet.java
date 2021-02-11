
package testControl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockPart;

import control.NewTopicServlet;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestNewTopicServlet {
	
	private NewTopicServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private PubblicationDao pubblicationdto = new PubblicationDto();

	@BeforeEach
	void setUp() throws Exception {
		
		servlet = new NewTopicServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
		
	}

	@Test
	 public void TC4_2_1() {
		
		request.addParameter("titolo", "");
		request.addParameter("action", "insert");
		request.getSession().setAttribute("username","vincenzoStrano");
		 String message = "Il titolo non rispetta la lunghezza";
		    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
		      servlet.doPost(request, response);
		    });
		    assertEquals(message, exception.getMessage());
		
	}
	@Test
	 public void TC4_2_1_1() {
			
			request.addParameter("titolo", "tit");
			request.addParameter("action", "insert");
			request.getSession().setAttribute("username","vincenzoStrano");
			 String message = "Il titolo non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	
	@Test
	 public void usernameNull() throws ServletException, IOException {
		request.addParameter("action", "insert");
		request.getSession().setAttribute("username",null);
	    servlet.doPost(request, response);
    }
	
	@Test
	 public void TC4_2_1_2() {
			
			request.addParameter("titolo", "titolo troppo lungo mi aspetto un'eccezione brutta");
			request.addParameter("action", "insert");
			request.getSession().setAttribute("username","vincenzoStrano");
			 String message = "Il titolo non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_2_2() {
			
			request.addParameter("titolo", "**123**");
			request.addParameter("action", "insert");
			request.getSession().setAttribute("username","vincenzoStrano");
			 String message = "Il titolo non rispetta il formato";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_2_3() {
			
			request.addParameter("titolo", "titolo topic");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","");
			request.getSession().setAttribute("username","vincenzoStrano");
			 String message = "Il videogioco non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 
	 @Test
	 public void TC4_2_3_1() {
			
			request.addParameter("titolo", "titolo topic");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","t");
			request.getSession().setAttribute("username","vincenzoStrano");
			 String message = "Il videogioco non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_2_3_2() {
			
			request.addParameter("titolo", "titolo topic");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","titolo videogioco troppo lungo, mi aspetto una brutta eccezione");
			request.getSession().setAttribute("username","vincenzoStrano");
			 String message = "Il videogioco non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_2_4() {
			
			request.addParameter("titolo", "titolo topic");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","&&nomegioco&&");
			request.getSession().setAttribute("username","vincenzoStrano");
			 String message = "Il videogioco non rispetta il formato";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 
	 @Test
	 public void videogiocoNonPresente() {
			
			request.addParameter("titolo", "titolo topic");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","minecraft");
			request.getSession().setAttribute("username","vincenzoStrano");
			 String message = "Il videogioco non esiste all'interno del db";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 
	 @Test
	 public void TC4_2_5() {
			
			request.addParameter("titolo", "titolo topic");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "");
			request.getSession().setAttribute("username","vincenzoStrano");
			String message = "La descrizione non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}

	 @Test
	 public void TC4_2_5_1() {
			
			request.addParameter("titolo", "titolo topic");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere.");
			request.getSession().setAttribute("username","vincenzoStrano");
			String message = "La descrizione non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_2_6() throws ServletException, IOException {
			
			request.addParameter("titolo", "titolo topic");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","Anno 1800");
			request.addParameter("descrizione", "descrizione topic");
			request.getSession().setAttribute("username","vincenzoStrano");
			byte[] b = new byte[20];
		    MockPart part = new MockPart("photo", "", b);
		    request.addPart(part);
		    servlet.doPost(request, response);
			
		}
	 
	 @Test
	  public void getNewsAndVideogames() throws ServletException, IOException {
		 
		 request.addParameter("username","username");
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
				ArrayList<PubblicationBean> list = pubblicationdto.getAllPubblication();
				for(PubblicationBean b : list ) {
					
					if(b.getTitolo().equals("titolo topic")){
						
						pubblicationdto.removePubblication(b.getCodicePubblicazione());
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
}
