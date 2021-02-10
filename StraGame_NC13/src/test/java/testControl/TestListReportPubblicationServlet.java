package testControl;
import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import control.ListReportPubblicationServlet;

class TestListReportPubblicationServlet {

	private ListReportPubblicationServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@BeforeEach
	public void setUp() throws Exception {
		servlet = new ListReportPubblicationServlet();
		request = new MockHttpServletRequest();    
		response = new MockHttpServletResponse();
	}


	@Test
	void testActionNull() throws ServletException, IOException {
		servlet.doPost(request,response);
	}
	
	@Test
	void testDeleteReport() throws ServletException, IOException {
		request.addParameter("action","DeleteReport");
		request.addParameter("id","3264");
		request.addParameter("autore","adm12345");
		servlet.doPost(request,response);
	}
	
	@Test
	void testDeleteReportExc() throws ServletException, IOException {
		request.addParameter("action","DeleteReport");
		request.addParameter("id","3259");
		request.addParameter("autore","adm12345");
		servlet.doPost(request,response);
	}
	
	@Test
	void testDeletePubblication() throws ServletException, IOException {
		request.addParameter("action","DeletePubblication");
		request.addParameter("id","3232");
		servlet.doPost(request,response);
	}
	
	@Test
	@AfterEach
	void testDeletePubblicationExc() throws ServletException, IOException {
		request.addParameter("action","DeletePubblication");
		request.addParameter("id","3282");
		servlet.doPost(request,response);
	}



	@AfterEach
	void tearDown() throws Exception {
		servlet=null;
		request=null;
		response=null;
	}

}
