package testControl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import control.NewsServlet;

class TestNewsServlet {

  private MockHttpServletRequest request;
  private NewsServlet servlet;
  private MockHttpServletResponse response;
    
  @BeforeEach
    public void setUp() throws Exception {
    servlet = new NewsServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
    public void testNews() throws ServletException, IOException {
        
    servlet.doPost(request, response);
        
  }
    
  @AfterEach
    public void tearDown() {
    servlet = null;
    request = null;    
    response = null;
        
  }

}
