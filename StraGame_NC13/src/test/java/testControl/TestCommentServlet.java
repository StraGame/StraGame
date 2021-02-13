package testControl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import control.CommentServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


class TestCommentServlet {

  private CommentServlet servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  public void setUp() throws Exception {
    
    servlet = new CommentServlet();
    request = new MockHttpServletRequest();  
    response = new MockHttpServletResponse();
  }

  @Test
  void testCommentReview() throws ServletException, IOException {
    request.getSession().setAttribute("username", "adm12345");
    request.addParameter("id", "3251");
    request.addParameter("commentText", "Ciao sono nei commenti");
    servlet.doPost(request, response);
    assertEquals("text/html", response.getContentType());
  }
  
  @Test
  void testCommentTopic() throws ServletException, IOException {
    request.getSession().setAttribute("username", "adm12345");
    request.addParameter("id", "3252");
    request.addParameter("commentText", "Ciao sono nei commenti");
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
