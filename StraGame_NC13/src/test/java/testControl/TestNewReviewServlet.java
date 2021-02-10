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

import control.NewReviewServlet;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestNewReviewServlet {
	
	private NewReviewServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private PubblicationDao pubblicationdto = new PubblicationDto();

	@BeforeEach
	void setUp() throws Exception {
		
		servlet = new NewReviewServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
		
	}

	@Test
	 public void TC4_3_1() {
		
		request.addParameter("titolo", "");
		request.addParameter("action", "insert");
		request.addParameter("ratingGP","-1");
		request.addParameter("ratingT","-1");
		request.addParameter("ratingG","-1");
		request.addParameter("ratingVC","-1");
		request.getSession().setAttribute("username","user");
		 String message = "Il titolo non rispetta la lunghezza";
		    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
		      servlet.doPost(request, response);
		    });
		    assertEquals(message, exception.getMessage());
		
	}
	@Test
	 public void TC4_3_1_1() {
			
			request.addParameter("titolo", "tit");
			request.addParameter("action", "insert");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			 String message = "Il titolo non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	
	@Test
	 public void TC4_3_1_2() {
			
			request.addParameter("titolo", "titolo troppo lungo mi aspetto un'eccezione brutta");
			request.addParameter("action", "insert");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			 String message = "Il titolo non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_2() {
			
			request.addParameter("titolo", "**123**");
			request.addParameter("action", "insert");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			 String message = "Il titolo non rispetta il formato";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_3() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			 String message = "Il videogioco non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 
	 @Test
	 public void TC4_3_3_1() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","t");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			 String message = "Il videogioco non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_3_2() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","titolo videogioco troppo lungo, mi aspetto una brutta eccezione");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			 String message = "Il videogioco non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_4() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","&&nomegioco&&");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			 String message = "Il videogioco non rispetta il formato";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 
	 @Test
	 public void videogiocoNonPresente() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","minecraft");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			 String message = "Il videogioco non esiste all'interno del db";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_5() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "La descrizione non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 
	 @Test
	 public void TC4_3_5_1() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere. Questa descrizione deve avere 2000 caratteri, ma non so che scrivere.");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "La descrizione non rispetta la lunghezza";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_6() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","-1");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "Il gameplay � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_6_1() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","0");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "Il gameplay � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_6_2() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","11");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "Il gameplay � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_7() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","-1");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "La grafica � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_7_1() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","0");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "La grafica � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 
	 @Test
	 public void TC4_3_7_2() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","11");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "La grafica � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_8() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","-1");
			request.addParameter("ratingG","10");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "La trama � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_8_1() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","0");
			request.addParameter("ratingG","10");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "La trama � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_8_2() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","11");
			request.addParameter("ratingG","10");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "La trama � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_9() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","10");
			request.addParameter("ratingG","10");
			request.addParameter("ratingVC","-1");
			request.getSession().setAttribute("username","user");
			String message = "Il voto complessivo � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_9_1() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","10");
			request.addParameter("ratingG","10");
			request.addParameter("ratingVC","0");
			request.getSession().setAttribute("username","user");
			String message = "Il voto complessivo � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 @Test
	 public void TC4_3_9_2() {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","10");
			request.addParameter("ratingG","10");
			request.addParameter("ratingVC","11");
			request.getSession().setAttribute("username","user");
			String message = "Il voto complessivo � minore di 1 o maggiore di 10";
			    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {      
			      servlet.doPost(request, response);
			    });
			    assertEquals(message, exception.getMessage());
			
		}
	 
	 @Test
	 public void TC4_3_10() throws ServletException, IOException {
			
			request.addParameter("titolo", "titolo recensione");
			request.addParameter("action", "insert");
			request.addParameter("videogioco","The Crew 2");
			request.addParameter("descrizione", "descrizione recensione");
			request.addParameter("ratingGP","10");
			request.addParameter("ratingT","10");
			request.addParameter("ratingG","10");
			request.addParameter("ratingVC","10");
			byte[] b = new byte[20];
		    MockPart part = new MockPart("photo", "", b);
		    request.addPart(part);
			request.getSession().setAttribute("username","c.lau");
			servlet.doPost(request, response);
			
		}
	 
	 @Test
	  public void getNewsAndVideogames() throws ServletException, IOException {
		 
		 servlet.doPost(request, response);
		 assertEquals("text/html;charset=UTF-8", response.getContentType());
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
					
					if(b.getTitolo().equals("titolo recensione")){
						
						pubblicationdto.removePubblication(b.getCodicePubblicazione());
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
}
