package testControl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import control.ReviewServlet;

class TestReviewServlet {
    
  private MockHttpServletRequest request;
  private ReviewServlet servlet;
  private MockHttpServletResponse response;
    
  @BeforeEach
    public void setUp() throws Exception {
    servlet = new ReviewServlet();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
    public void testReview() throws ServletException, IOException {
        
    request.setParameter("videogioco", "Anno 1800");
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
