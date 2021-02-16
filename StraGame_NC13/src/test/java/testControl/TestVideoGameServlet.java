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
import org.springframework.mock.web.MockPart;
import control.VideoGameServlet;
import model.VideoGameDao;
import model.VideoGameDto;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestVideoGameServlet {

  private MockHttpServletRequest request;
  private VideoGameServlet servlet;
  private MockHttpServletResponse response;
  private VideoGameDao gamedto;
    
  @BeforeEach
    public void setUp() throws Exception {
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
    servlet = new VideoGameServlet();
    gamedto = new VideoGameDto();
  }

  @Test
    public void tc_3_2_1() {
    request.addParameter("titolo", "");
    request.addParameter("action", "insert");
    String oracle = "Il titolo non rispetta la lunghezza";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_1_1() {
    request.addParameter("titolo", "a");
    request.addParameter("action", "insert");
    String oracle = "Il titolo non rispetta la lunghezza";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_1_2() {
    request.addParameter("titolo", "Final Fantasy 7777777777777777777777777777777777");
    request.addParameter("action", "insert");
    String oracle = "Il titolo non rispetta la lunghezza";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_2() {
    request.addParameter("titolo", "*123&");
    request.addParameter("action", "insert");
    String oracle = "Il titolo non rispetta il formato";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_3() {
    request.addParameter("titolo", "Final Fantasy 7");
    request.addParameter("action", "insert");
    request.addParameter("genere", "");
    String oracle = "Il genere non rispetta la lunghezza";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_3_1() {
    request.addParameter("titolo", "Final Fantasy 7");
    request.addParameter("action", "insert");
    request.addParameter("genere", "pi");
    String oracle = "Il genere non rispetta la lunghezza";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_3_2() {
    request.addParameter("titolo", "Final Fantasy 7");
    request.addParameter("action", "insert");
    request.addParameter("genere", "picchiaduro sparattuto avventura arcade Battle Royale");
    String oracle = "Il genere non rispetta la lunghezza";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_4() {
    request.addParameter("titolo", "Final Fantasy 7");
    request.addParameter("action", "insert");
    request.addParameter("genere", "##genere*1");
    String oracle = "Il genere non rispetta il formato";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_5() {
    request.addParameter("titolo", "Final Fantasy 7");
    request.addParameter("action", "insert");
    request.addParameter("genere", "picchiaduro");
    request.addParameter("descrizione", "");
    String oracle = "La descrizione non rispetta la lunghezza";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_5_1() {
    request.addParameter("titolo", "Final Fantasy 7");
    request.addParameter("action", "insert");
    request.addParameter("genere", "picchiaduro");
    request.addParameter("descrizione", "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7"
        + " Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7"
        + " Final Fantasy 7Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7"
        + " Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7"
        + " Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7"
        + " Final Fantasy 7 Final Fantasy 7 Final Fantasy 7Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7"
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 Final Fantasy 7 "
        + "Final Fantasy 7");
    String oracle = "La descrizione non rispetta la lunghezza";
        
    IllegalArgumentException exception = 
        assertThrows(IllegalArgumentException.class, () -> {
          servlet.doPost(request, response);
        });
    assertEquals(oracle, exception.getMessage());
  }
    
  @Test
    public void tc_3_2_6() throws ServletException, IOException {
    request.addParameter("titolo", "Final Fantasy 7");
    request.addParameter("action", "insert");
    request.addParameter("genere", "picchiaduro");
    request.addParameter("descrizione", "Final Fantasy 7 è un gioco di simulazione.");
    byte[] b = new byte[20];
    MockPart part = new MockPart("foto", "", b);
    request.addPart(part);
    servlet.doPost(request, response);
        
  }
    
  @Test
    public void actionNull() throws ServletException, IOException {
    servlet.doPost(request, response);
  }
    
  @Test
    public void viewGame() throws ServletException, IOException {
    request.addParameter("action", "viewGame");
    request.addParameter("nome", "The Crew 2");
    servlet.doPost(request, response);
        
  }
        
  @AfterEach
    public void tearDown() {
    servlet = null;
    request = null;    
    response = null;
        
        
  }
    
  @AfterAll
    public void restore() {
    try {
      gamedto.removeVideoGame("Final Fantasy 7");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}