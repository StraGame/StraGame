package model;

import java.sql.SQLException;

public interface ReportPubblicationDao {

    public void insertReportPubblication (ReportPubblicationBean rp) throws SQLException;
	
	public void removeReportPubblication (int codicePubblicazione, String autore) throws SQLException;
	
    public ReportPubblicationBean getReportPubblication (int codicePubblicazione, String autore) throws SQLException;
    
}
