package testControl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import control.LoginServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class TestLoginServlet {

  private LoginServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  public void setUp() throws Exception {
    
    servlet = new LoginServlet();
    request = new MockHttpServletRequest();  
    response = new MockHttpServletResponse();
  }

  @Test
  void testLoginSuccess() throws ServletException, IOException {
    request.addParameter("username", "adm12345");
    request.addParameter("password", "ciao1234");
    servlet.doPost(request, response);
    assertEquals("adm12345", request.getSession().getAttribute("username"));
  }
  
  @Test
  void testLoginAdminSuccess() throws ServletException, IOException {
    request.addParameter("username", "vincenzoStrano");
    request.addParameter("password", "ciao1234");
    servlet.doPost(request, response);
    assertEquals(true, request.getSession().getAttribute("adminRoles"));
  }
  
  @Test
  void testLoginFailure() throws ServletException, IOException {
    request.addParameter("username", "vincenzoStrano");
    request.addParameter("password", "ciao12345");
    servlet.doPost(request, response);
    assertNull(request.getSession().getAttribute("username"));
    
  }
  
  @Test
  void testLoginFailure1() throws ServletException, IOException {
    request.addParameter("username", "vincenzoS");
    request.addParameter("password", "ciao1234");
    assertNull(request.getSession().getAttribute("username"));
  }
  
  @Test
  void testLoginFailure2() throws ServletException, IOException {
    request.addParameter("username", "vincenzoS");
    request.addParameter("password", "ciao12345");
    assertNull(request.getSession().getAttribute("username"));
  }

  @AfterEach
  void tearDown() throws Exception {
  }
}
