package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VideoGameDao {
	
	public void insertVideoGame(VideoGameBean vg) throws SQLException;
	
	public void removeVideoGame(String nome)throws SQLException;
	
	public VideoGameBean getVideoGame(String nome)throws SQLException;
	
	public ArrayList<String> getVideoGameNames()throws SQLException;

}
