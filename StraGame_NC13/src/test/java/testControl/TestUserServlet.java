package testControl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockPart;
import control.UserServlet;

class TestUserServlet {

  private UserServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
    public void setUp() throws Exception {
        
    servlet = new UserServlet();
    request = new MockHttpServletRequest();    
    response = new MockHttpServletResponse();
  }

  @Test
    public void testActionNull() throws ServletException, IOException {
    servlet.doPost(request, response);
    assertEquals("text/html", response.getContentType());
  }
    
  @Test
    public void testInsertDescription() throws ServletException, IOException {
    request.addParameter("action", "insertDescription");
    request.addParameter("changeDescription", "ciao sono la descrizione");
    request.getSession().setAttribute("username", "adm12345");
    servlet.doPost(request, response);
    assertEquals("text/html", response.getContentType());
  }
    
  @Test
    public void testUpdatePhoto() throws ServletException, IOException {
    request.addParameter("action", "uploadPhoto");
    request.getSession().setAttribute("username", "adm12345");
    request.addParameter("username", "vincenzoStrano");
    byte[] b = new byte[20];
    MockPart part = new MockPart("photo", "", b);
    request.addPart(part);
    servlet.doPost(request, response);
    assertEquals("text/html", response.getContentType());
  }
    
  @Test
    public void testGetPhoto() throws ServletException, IOException {
    request.addParameter("action", "getPhoto");
    request.addParameter("username", "vincenzoStrano");
    request.getSession().setAttribute("username", "vincenzoStrano");
    servlet.doPost(request, response);
    assertEquals("image/jpeg", response.getContentType());
  }
    
  @Test
    public void testGetPhotoNull() throws ServletException, IOException {
    request.addParameter("action", "getPhoto");
    request.addParameter("username", "adm12345");
    request.getSession().setAttribute("username", "adm12345");
    servlet.doPost(request, response);
    assertEquals(null, response.getContentType());
  }
    
  @AfterEach
    void tearDown() throws Exception {
    servlet = null;
    request = null;
    response = null;
  }
}
