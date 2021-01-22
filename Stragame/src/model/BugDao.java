package model;

import java.sql.SQLException;

public interface BugDao {
	
	public void insertBug(BugBean b) throws SQLException;
	
	public void removeBug(int id)throws SQLException;
	
	public BugBean getBug(int id)throws SQLException;
	
	
	

}
