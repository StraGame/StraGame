package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PubblicationDao {
	
	public void insertPubblication (PubblicationBean p)throws SQLException;
	
	public void removePubblication (int id)throws SQLException;
	
	public PubblicationBean getPubblication (int id)throws SQLException;
	
	public ArrayList<PubblicationBean> getPubsByVideogame (String videogame)throws SQLException;
	
	

}
