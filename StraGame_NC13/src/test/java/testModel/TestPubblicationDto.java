package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.PubblicationBean;
import model.PubblicationDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.mock.web.MockPart;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestPubblicationDto {

  private PubblicationDto pubblicationdto;
  
  @BeforeAll
  public void setUp() {
    pubblicationdto = new PubblicationDto();
  }
  
  @Test
  @Order(1)
  void testInsertTopicSuccess() {
    PubblicationBean bean = new PubblicationBean();
    
    bean.setAutore("c.laudato");
    bean.setDescrizione("Ciao sono il topic di prova");
    bean.setVideogioco("Rainbow Six Siege");
    bean.setTitolo("Topic Test");
    bean.setTipo("topic");
    byte[] b = new byte[20];
    MockPart part = new MockPart("photo", "", b);
    bean.setPhoto(part);
    
    try {
      LocalDateTime oggi = LocalDateTime.now();
      DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
      pubblicationdto.insertPubblication(bean);
      
      String output = "";
      String oracle = "trovato";
      
      ArrayList<PubblicationBean> prova = pubblicationdto.getPubsByTipo("topic");
      for (PubblicationBean topics : prova) {
        if (topics.getData().equals(oggi.format(sdf)) 
            && topics.getAutore().equals(bean.getAutore())) {
          output = "trovato";
        }
      }
      
      assertEquals(oracle, output);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(2)
  void testInsertReviewSuccess() {
    PubblicationBean review = new PubblicationBean();
    
    review.setAutore("c.laudato");
    review.setDescrizione("Ciao sono la recensione di prova");
    review.setVideogioco("Rainbow Six Siege");
    review.setTitolo("Review Test");
    review.setTipo("recensione");
    review.setGameplay(5);
    review.setTrama(5);
    review.setVoto(10);
    review.setGrafica(10);
    byte[] b = new byte[20];
    MockPart part = new MockPart("photo", "", b);
    review.setPhoto(part);
    
    try {
      LocalDateTime oggi = LocalDateTime.now();
      DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
      
      pubblicationdto.insertPubblication(review);
      
      String output = "";
      String oracle = "trovato";
      
      ArrayList<PubblicationBean> prova = pubblicationdto.getPubsByTipo("recensione");
      for (PubblicationBean topics : prova) {
        if (topics.getData().equals(oggi.format(sdf)) 
            && topics.getAutore().equals(review.getAutore())) {
          output = "trovato";
        }
      }
      
      assertEquals(oracle, output);
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }
  
  @Test
  @Order(1)
  void testInsertTopicSuccess1() {
    PubblicationBean bean = new PubblicationBean();
    
    bean.setAutore("c.laudato");
    bean.setDescrizione("Ciao sono il topic di prova");
    bean.setVideogioco("Rainbow Six Siege");
    bean.setTitolo("Topic Test");
    bean.setTipo("topic");
    MockPart part = new MockPart("photo", null, null);
    bean.setPhoto(part);
    
    try {
      LocalDateTime oggi = LocalDateTime.now();
      DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
      pubblicationdto.insertPubblication(bean);
      
      String output = "";
      String oracle = "trovato";
      
      ArrayList<PubblicationBean> prova = pubblicationdto.getPubsByTipo("topic");
      for (PubblicationBean topics : prova) {
        if (topics.getData().equals(oggi.format(sdf)) 
            && topics.getAutore().equals(bean.getAutore())) {
          output = "trovato";
        }
      }
      
      assertEquals(oracle, output);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(2)
  void testInsertReviewSuccess1() {
    PubblicationBean review = new PubblicationBean();
    
    review.setAutore("c.laudato");
    review.setDescrizione("Ciao sono la recensione di prova");
    review.setVideogioco("Rainbow Six Siege");
    review.setTitolo("Review Test");
    review.setTipo("recensione");
    review.setGameplay(5);
    review.setTrama(5);
    review.setVoto(10);
    review.setGrafica(10);
    MockPart part = new MockPart("photo", null, null);
    review.setPhoto(part);
    
    try {
      LocalDateTime oggi = LocalDateTime.now();
      DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
      
      pubblicationdto.insertPubblication(review);
      
      String output = "";
      String oracle = "trovato";
      
      ArrayList<PubblicationBean> prova = pubblicationdto.getPubsByTipo("recensione");
      for (PubblicationBean topics : prova) {
        if (topics.getData().equals(oggi.format(sdf)) 
            && topics.getAutore().equals(review.getAutore())) {
          output = "trovato";
        }
      }
      
      assertEquals(oracle, output);
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }
  
  @Test
  void testGetPubsByTipoReviewSuccess() {
    try {
      ArrayList<PubblicationBean> reviews = pubblicationdto.getPubsByTipo("recensione");
      
      assertFalse(reviews.isEmpty());
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
  }
  
  @Test
  void testGetPubsByTipoTopicSuccess() {
    try {
      ArrayList<PubblicationBean> topics = pubblicationdto.getPubsByTipo("topic");
            
      assertFalse(topics.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testRemovePubblicationSuccess() {
    try {
      pubblicationdto.removePubblication(3250);
      
      PubblicationBean prova = pubblicationdto.getPubblication(3250);
      assertTrue(prova.getAutore().equals(""));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  void testGetPubblication() {
    try {
      PubblicationBean pub = pubblicationdto.getPubblication(3249);
      assertFalse(pub.getAutore().equals(""));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testGetPubsByVideogame() {
    try {
      ArrayList<PubblicationBean> pubs = pubblicationdto.getPubsByVideogame("Rainbow Six Siege");
      assertNotNull(pubs.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testGetAllPubFilter() {
    try {
      ArrayList<PubblicationBean> topic = pubblicationdto.getAllPubFilter(null, "topic");
      assertNotNull(topic.isEmpty());
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    try {
      ArrayList<PubblicationBean> topicbygame = pubblicationdto.getAllPubFilter("Rainbow Six Siege", "topic");
      assertNotNull(topicbygame.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      ArrayList<PubblicationBean> reviewbygame = pubblicationdto.getAllPubFilter("Rainbow Six Siege", "review");
      assertNotNull(reviewbygame);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    try {
      ArrayList<PubblicationBean> review = pubblicationdto.getAllPubFilter("", "review");
      assertNotNull(review.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Test
  void testGetAllPubblication() {
    try {
      ArrayList<PubblicationBean> lista = pubblicationdto.getAllPubblication();
      assertFalse(lista.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testGetPhoto() {
    try {
      byte[] photo = pubblicationdto.getPhoto(3259);
      assertNotNull(photo);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
