package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReportPubblicationDao {

  public void insertReportPubblication(ReportPubblicationBean rp) throws SQLException;
  
  public void removeReportPubblication(int codicePubblicazione, String autore) throws SQLException;
  
  public ReportPubblicationBean getReportPubblication(
      int codicePubblicazione, String autore) throws SQLException;

  public ArrayList<ReportPubblicationBean> getAllPubblicationReport() throws SQLException;
  
  public void removeAllReportByPub(int codicePubblicazione) throws SQLException;
  
}
