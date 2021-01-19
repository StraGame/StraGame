package model;

import java.sql.SQLException;

public interface videoGameDao {
	
	public void insertVideoGame(videoGameBean vg) throws SQLException;
	
	public void removeVideoGame(string nome)throws SQLException;
	
	public BugBean getVideoGame(string nome)throws SQLException;

}
