package testControl;



import static org.junit.Assert.assertNull;

import control.LogoutServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class TestLogout {

  private MockHttpServletRequest request;
  private LogoutServlet servlet;
  private MockHttpServletResponse response;
  
  @BeforeEach
  public void setUp() throws Exception {
    servlet = new LogoutServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void logoutTest() throws ServletException, IOException {
    
    request.setAttribute("username", "user");
    request.setAttribute("adminRoles", true);
    servlet.doPost(request, response);
    assertNull(request.getSession().getAttribute("username"));
    
  }
  
  @AfterEach
  public void tearDown() {
    servlet = null;
    request = null;  
    response = null;
    
  }


}
