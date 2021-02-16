package testControl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import control.ReviewDetailsServlet;

class TestReviewDetailsServlet {


  private MockHttpServletRequest request;
  private ReviewDetailsServlet servlet;
  private MockHttpServletResponse response;
    
  @BeforeEach
    public void setUp() throws Exception {
    servlet = new ReviewDetailsServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
    public void TestReviewDetails() throws ServletException, IOException {
        
    request.addParameter("id", "1");
    servlet.doPost(request, response);
    assertEquals("text/html", response.getContentType());
        
  }
    
  @AfterEach
    public void tearDown() {
    servlet = null;
    request = null;    
    response = null;
        
  }
}
