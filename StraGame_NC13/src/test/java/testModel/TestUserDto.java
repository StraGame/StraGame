package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import model.UserBean;
import model.UserDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.mock.web.MockPart;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestUserDto {

  private UserDto usr;
  
  @BeforeAll
  public void setUp() {
    usr = new UserDto();
  }
  
  @Test
  @Order(1)
  void testInsertUserSuccess() {
    UserBean bean = new UserBean();
    bean.setNome("carmine");
    bean.setCognome("laudato");
    bean.setNickname("c.laudato");
    bean.setEmail("pippo@poppi.it");
    bean.setPassword("ciao");
    bean.setRuolo("user");
    
    try {
      usr.insertUser(bean);
      
      UserBean output = usr.retrieveUser("c.laudato");
      
      assertEquals(bean.getNickname(), output.getNickname());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(2)
  void testInsertUserFailure() {
    UserBean bean = new UserBean();
    bean.setNome("carmine");
    bean.setCognome("laudato");
    bean.setNickname("c.laudato");
    bean.setEmail("pippo@poppi.it");
    bean.setRuolo("user");
    
    try {
      usr.insertUser(bean);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  
  @Test
  @Order(3)
  void testRetrieveAll() {
    try {
      ArrayList<UserBean> users = usr.retrieveAll();
      assertFalse(users.isEmpty());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(4)
  void testEditDescriptionSuccess() {
    try {
      String descrizione = "Ciao a tutti sono carmine e sto effettuando la classe di test";
      usr.editDescription(descrizione, "c.laudato");
      
      UserBean output = usr.retrieveUser("c.laudato");
      
      assertEquals(descrizione, output.getDescrizione());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(5)
  void testEditDescriptionFailure() {
    try {
      usr.editDescription("Ciao a tutti sono carmine e sto effettuando la classe di test e sto"
          + " inserendo una descrizione lunghissimaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
          + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
          + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "c.laudato");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(6)
  void testEditPassword() {
    try {
      String password = "ciaociao";
      usr.editPassword(password, "c.laudato");
      
      UserBean output = usr.retrieveUser("c.laudato");
      
      assertEquals(password, output.getPassword());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(7)
  void testRetrieveUserSuccess() {
    try {
      UserBean user = usr.retrieveUser("c.laudato");
      
      assertFalse(user.getNickname().equals(""));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(8)
  void testRetrieveUserFailure() {
    try {
      usr.retrieveUser("pippo");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(9)
  void testGetPhoto() {
    try {
      byte[] photo = usr.getPhoto("c.lau");
      assertNotNull(photo);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(9)
  void testGetPhotoNull() {
    try {
      byte[] photo = usr.getPhoto("vincenzoStrano");
      assertNull(photo);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  
  @Test
  @AfterAll
  void testRemoveUserSuccess() {
    try {
      usr.removeUser("c.laudato");
      
      UserBean user = usr.retrieveUser("c.laudato");
      
      assertTrue(user.getNickname().equals(""));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  void testRemoveUserFailure() {
    
    try {
      usr.removeUser("c.l");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(10)
  void testSetSegnalato() {
    try {
      usr.setSegnalato("c.laudato", true);
      
      UserBean user = usr.retrieveUser("c.laudato");
      
      assertTrue(user.getSegnalato());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(11)
  void testRetrieveAllReportUser() {
    try {
      ArrayList<UserBean> usersReport = usr.retrieveAllReportUser();
      
      assertNotNull(usersReport);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(12)
  void testUpdatePhoto() {
    try {
      byte[] b = new byte[20];
      MockPart part = new MockPart("photo", "", b);
      
      usr.updatePhoto("vincenzoStrano", part);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
