package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import model.BugDto;
import model.CommentBean;
import model.CommentDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

 
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestCommentDto {

  private CommentDto commentdto;
  private String data;
    
  @BeforeAll
  public void setUp() {
    commentdto = new CommentDto();
    data = "";
  }
    
  @Test
  @Order(1)
  void testInsertCommentSuccess() {
    CommentBean bean = new CommentBean();
    bean.setAutore("adm12345");
    bean.setCodicePubblicazione(3231);
    bean.setTesto("Ciaoo sono qui nei commenti");
    
    try {
      LocalDateTime oggi = LocalDateTime.now();
      DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
      commentdto.insertComment(bean);
            
      String output = "";
      String oracle = "trovato";
            
      ArrayList<CommentBean> pippo = commentdto.getCommentsbyPubblication(bean.getCodicePubblicazione());
      for (CommentBean comment : pippo) {
        if (comment.getData().equals(oggi.format(sdf))) {
          data = comment.getData();
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
  void testInsertCommentFailure() {
    CommentBean bean = new CommentBean();
    bean.setAutore("c.lau");
    bean.setCodicePubblicazione(3231);
    
    try {
      commentdto.insertComment(bean);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
    
  @Test
  @AfterAll
  void testRemoveCommentSuccess() {
        
    try {
      commentdto.removeComment(3251, data, "adm12345");
            
      String output = "";
      String oracle = "non trovato";
            
      ArrayList<CommentBean> lista = commentdto.getCommentsbyPubblication(3251);
      for (CommentBean comment : lista) {
        if (comment.getData().equals(data) && comment.getAutore().equals("adm12345")) {
          output = "trovato";
        } else {
          output = "non trovato";
        }
      }
            
      assertEquals(oracle, output);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
    
  @Test
  @Order(3)
  void testRemoveCommentFailure() {
        
    try {
      commentdto.removeComment(3231, data, "");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  @Test
  @Order(4)
  void testGetCommentsbyPubblication() {
    try {
      ArrayList<CommentBean> bean = commentdto.getCommentsbyPubblication(3251);
      assertNotNull(bean);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(5)
  void testRemoveAllCommentByPub() {
    try {
      commentdto.removeAllCommentByPub(3232);
      int oracle = 0;
      ArrayList<CommentBean> lista = commentdto.getCommentsbyPubblication(3232);
            
      assertEquals(oracle, lista.size());
                
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
    

  @Test
  @Order(6)
  void testGetAllComments() {
    try {
      ArrayList<CommentBean> bean = commentdto.getAllComments();
      assertFalse(bean.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
