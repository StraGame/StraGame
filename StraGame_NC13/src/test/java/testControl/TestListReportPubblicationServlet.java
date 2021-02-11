package testControl;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import control.ListReportPubblicationServlet;
import model.PubblicationBean;
import model.PubblicationDao;
import model.PubblicationDto;
import model.ReportPubblicationBean;
import model.ReportPubblicationDao;
import model.ReportPubblicationDto;
import model.UserDao;
import model.UserDto;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestListReportPubblicationServlet {

	private ListReportPubblicationServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private ReportPubblicationDao reportdto = new ReportPubblicationDto();
	private UserDao userdto = new UserDto();
	private PubblicationDao pubblicationdto = new PubblicationDto();

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
	void testDeleteReportCleanUser() throws ServletException, IOException {
		request.addParameter("action","DeleteReport");
		request.addParameter("id","3264");
		request.addParameter("autore","adm12345");
		servlet.doPost(request,response);
		try {
			assertEquals(false,userdto.retrieveUser("c.lau").getSegnalato());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeleteReportReportedUser() throws ServletException, IOException {
		request.addParameter("action","DeleteReport");
		request.addParameter("id","3332");
		request.addParameter("autore","c.lau");
		servlet.doPost(request,response);
		try {
			assertEquals(true,userdto.retrieveUser("giorgiogiorgio").getSegnalato());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeletePubblicationCleanUser() throws ServletException, IOException {
		request.addParameter("action","DeletePubblication");
		request.addParameter("id","3333");
		servlet.doPost(request,response);
		try {
			assertEquals(false,userdto.retrieveUser("MarioRox56").getSegnalato());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeletePubblicationReportedUser() throws ServletException, IOException {
		request.addParameter("action","DeletePubblication");
		request.addParameter("id","3332");
		servlet.doPost(request,response);
		try {
			assertEquals(false,userdto.retrieveUser("giorgiogiorgio").getSegnalato());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}



	@AfterEach
	void tearDown() throws Exception {
		servlet=null;
		request=null;
		response=null;
	}
	
	@AfterAll
	public void restoreData() {
	
		//Reinserisco la segnalazione, e segnalo di nuovo l'utente
	ReportPubblicationBean bean = new ReportPubblicationBean();
	bean.setAutore("adm12345");
	bean.setCategoria("Linguaggio inappropriato");
	bean.setCodicePubblicazione(3264);
	bean.setDescrizione("Brutte parole qui!");
	try {
		reportdto.insertReportPubblication(bean);
		String autorepub = "c.lau";
		userdto.setSegnalato("c.lau", true);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//reinserisco la segnalazione per deleteReportReportedUser
	bean.setAutore("c.lau");
	bean.setCategoria("Linguaggio inappropriato");
	bean.setCodicePubblicazione(3332);
	bean.setDescrizione("Brutte parole qui!");
	try {
		reportdto.insertReportPubblication(bean);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
    }
}