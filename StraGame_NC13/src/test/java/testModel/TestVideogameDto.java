package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.Part;
import model.VideoGameBean;
import model.VideoGameDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.mock.web.MockPart;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestVideogameDto {

  private VideoGameDto gamedto;
  
  @BeforeAll
  public void setUp() {
    gamedto = new VideoGameDto();
  }
  
  @Test
  @Order(1)
  void testInsertVideoGameSuccess() {
    VideoGameBean game = new VideoGameBean();
    game.setNome("Final Fantasy 7");
    game.setDescrizione("Gioco molto bello pieno di personaggi fantasy");
    game.setGenere("Simulazione");
    byte[] b = new byte[20];
    MockPart part = new MockPart("photo", "", b);
    game.setPhoto(part);
    
    try {
      gamedto.insertVideoGame(game);
      
      VideoGameBean output = gamedto.getVideoGame(game.getNome());
      
      assertTrue(game.getNome().equals(output.getNome()));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(2)
  void testInsertVideoGameFailure() {
    VideoGameBean game = new VideoGameBean();
    game.setNome("Final Fantasy 7");
    game.setDescrizione("Gioco molto bello pieno di personaggi fantasy");
    game.setGenere("Simulazione");
    
    try {
      gamedto.insertVideoGame(game);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testRemoveVideoGameSuccess() {
    try {
      String name = "Final Fantasy 7";
      gamedto.removeVideoGame(name);
      
      VideoGameBean output = gamedto.getVideoGame(name);
      
      assertFalse(output.getNome().equals(name));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  void testRemoveVideoGameFailure() {
    try {
      gamedto.removeVideoGame("Pluto e topolino");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testGetVideoGame() {
    try {
      VideoGameBean pippo = gamedto.getVideoGame("The Crew 2");
      
      assertFalse(pippo.getNome().equals(""));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testGetVideoGameNames() {
    try {
      ArrayList<String> nomigiochi = gamedto.getVideoGameNames();
      
      assertFalse(nomigiochi.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testGetPhoto() {
    try {
      byte[] photo = gamedto.getPhoto("The Crew 2");
      assertNotNull(photo);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testGetAllVideoGame() {
    try {
      ArrayList<VideoGameBean> giochi = gamedto.getAllVideoGame();
      
      assertFalse(giochi.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
