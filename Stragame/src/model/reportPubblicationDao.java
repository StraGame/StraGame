package model;

import java.sql.SQLException;

public interface reportPubblicationDao {

    public void insertReportPubblication (reportPubblicationBean rp) throws SQLException;
	
	public void removeReportPubblication (int codicePubblicazione, String autore) throws SQLException;
	
    public reportPubblicationBean getReportPubblication (int codicePubblicazione, String autore) throws SQLException;
    
}
