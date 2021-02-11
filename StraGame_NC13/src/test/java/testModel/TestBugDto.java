package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import model.BugBean;
import model.BugDto;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestBugDto {

	private BugDto bugdto;
	private BugBean bean;
	
	@BeforeAll
	public void setUp() {
	bugdto=new BugDto();
	bean=new BugBean();
	}
	
	@Test
	@Order(1)
	void testInsertBugFailure() {
		
		bean.setAutore("c.laudato");
		bean.setCategoria("Bug Grafico");
		bean.setTesto("Ciao sono il bug di test");
		try {
			bugdto.insertBug(bean);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(2)
	void testInsertBugSuccess() {
		BugBean bean= new BugBean();
		bean.setAutore("c.lau");
		bean.setCategoria("Bug Grafico");
		bean.setTitolo("Bug di Test");
		bean.setTesto("Ciao sono il bug");
		bean.setVideogioco("Rainbow Six Siege");
		
		try {
			LocalDateTime oggi = LocalDateTime.now();
			DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
			bugdto.insertBug(bean);
			String output="";
			String oracle="trovato";
			
			ArrayList<BugBean> bugOutput= bugdto.getAllBug();
			for(BugBean bug: bugOutput) {
				if(bug.getAutore().equals(bean.getAutore()) && bug.getData().equals(oggi.format(sdf))) {
					output="trovato";
				}
			}
			assertEquals(oracle,output);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@AfterAll
	void testRemoveBugSuccess() {
		try {
			bugdto.removeBug(13);
			
			BugBean bug= bugdto.getBug(13);
			assertEquals(bug.getTitolo(),"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	@Test
	void testGetBugSuccess() {
		try {
			BugBean bug= bugdto.getBug(9);
			assertNotNull(bug);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetBugFailure() {
		try {
			BugBean bug= bugdto.getBug(3000);
			assertEquals(bug.getTitolo(),"");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllBug() {
		try {
			ArrayList<BugBean> bugs= bugdto.getAllBug();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllBugFilter() {
		try {
			ArrayList<BugBean> bugsByGame= bugdto.getAllBugFilter("Rainbow Six Siege", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<BugBean> bugsByGame= bugdto.getAllBugFilter(null, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<BugBean> bugsByCategory= bugdto.getAllBugFilter("", "Bug Audio");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ArrayList<BugBean> bugsByGameByCategory= bugdto.getAllBugFilter("Rainbow Six Siege", "Bug Grafico");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<BugBean> allbug= bugdto.getAllBugFilter("", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<BugBean> allbugs= bugdto.getAllBugFilter(null, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
