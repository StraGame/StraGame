package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.mock.web.MockPart;
import org.junit.jupiter.api.Order;

import model.NewsBean;
import model.NewsDto;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestNewsDto {

	private NewsDto newsdto;
	@BeforeAll
	void setUp() {
		newsdto = new NewsDto();
	}
	
	@Test
	@Order(1)
	void testInsertNewsSuccess() {
		NewsBean news= new NewsBean();
		news.setAutore("a.adm");
		news.setTitolo("News Test");
		news.setTesto("Ciao sono la news di test");
		byte[] b = new byte[20];
	    MockPart part = new MockPart("photo", "", b);
	    news.setPhoto(part);
		
		try {
			LocalDateTime oggi = LocalDateTime.now();
			DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			newsdto.insertNews(news);
			String output="", oracle="trovato";
			ArrayList<NewsBean> lista =newsdto.getAllNews();
			for(NewsBean notizia: lista) {
				if(notizia.getAutore().equals(news.getAutore())&& notizia.getData().equals(oggi.format(sdf))) {
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
	void testInsertNewsFailure() {
		NewsBean news= new NewsBean();
		news.setAutore("a.adm");
		news.setTitolo("News Test");
		news.setTesto("Ciao sono la news di test");
	    MockPart part = new MockPart("photo", null, null);
	    news.setPhoto(part);
		
		try {
			LocalDateTime oggi = LocalDateTime.now();
			DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			newsdto.insertNews(news);
			String output="", oracle="trovato";
			ArrayList<NewsBean> lista =newsdto.getAllNews();
			for(NewsBean notizia: lista) {
				if(notizia.getAutore().equals(news.getAutore())&& notizia.getData().equals(oggi.format(sdf))) {
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
	void testRemoveNewsSuccess() {
		try {
			newsdto.removeNews(18);
			NewsBean news= newsdto.getNews(18);
			
			assertEquals(news.getAutore(),"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(5)
	void testRemoveNewsFailure() {
		try {
			newsdto.removeNews(120);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testGetNews() {
		try {
			NewsBean news= newsdto.getNews(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Order(3)
	void testGetAllNews() {
		try {
			ArrayList<NewsBean> news= newsdto.getAllNews();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Order(4)
	void testGetPhoto() {
		try {
			byte[] photo=newsdto.getPhoto(6);
			assertNotNull(photo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(4)
	void testGetPhotoNull() {
		try {
			byte[] photo=newsdto.getPhoto(5);
			assertNotNull(photo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
