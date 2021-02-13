package testModel;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.ReportPubblicationBean;
import model.ReportPubblicationDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestReportPubblicationDto {

  private ReportPubblicationDto reportdto;
  
  @BeforeAll
  void setUp() {
    reportdto = new ReportPubblicationDto();
  }
  
  @Test
  @Order(1)
  void testInsertReportPubblicationSuccess() {
    ReportPubblicationBean bean = new ReportPubblicationBean();
    bean.setAutore("c.lau");
    bean.setCategoria("Linguaggio inappropriato");
    bean.setCodicePubblicazione(3240);
    bean.setDescrizione("Scrive solo parolacce");

    try {
      LocalDateTime oggi = LocalDateTime.now();
      DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
      reportdto.insertReportPubblication(bean);
      ReportPubblicationBean reportOutput;
      reportOutput = reportdto.getReportPubblication(bean.getCodicePubblicazione(), bean.getAutore());
      assertEquals(oggi.format(sdf), reportOutput.getData());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(2)
  void testInsertReportPubblicationFailure() {
    ReportPubblicationBean bean = new ReportPubblicationBean();
    bean.setAutore("c.lau");
    bean.setCategoria("Linguaggio inappropriato");
    bean.setCodicePubblicazione(3240);
    bean.setDescrizione("Scrive solo parolacce");

    try {
      reportdto.insertReportPubblication(bean);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @AfterAll
  void testRemoveReportPubblicationSuccess() {
    try {
      reportdto.removeReportPubblication(3240, "c.lau");
      assertNotNull(reportdto.getReportPubblication(3240, "c.lau"));
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(8)
  void testRemoveReportPubblicationFailure() {
    try {
      reportdto.removeReportPubblication(3240, "c.laudato");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(3)
  void testGetReportPubblicationSuccess() {
    try {
      ReportPubblicationBean bean = reportdto.getReportPubblication(3259, "a.adm");
      assertNotNull(bean);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(4)
  void testGetReportPubblicationFailure() {
    try {
      reportdto.getReportPubblication(1, "c.laudato");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(5)
  void testGetAllPubblicationReport() {
    try {
      ArrayList<ReportPubblicationBean> lista = reportdto.getAllPubblicationReport();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  @Order(6)
  void testRemoveAllReportByPubSuccess() {
    try {
      reportdto.removeAllReportByPub(3241);
      int oracle = 0;
      ArrayList<ReportPubblicationBean> lista = reportdto.getAllPubblicationReport();
      int cont = 0;
      for (ReportPubblicationBean report : lista) {
        if (report.getCodicePubblicazione() == 3241) {
          cont++;
        }
      }
      
      assertEquals(oracle, cont);
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test
  @Order(7)
  void testRemoveAllReportByPubFailure() {
    try {
      reportdto.removeAllReportByPub(1);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
