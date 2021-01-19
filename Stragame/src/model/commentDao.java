package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface commentDao {

    public void insertComment(commentBean c) throws SQLException;
	
	public void removeComment(int codiePubblicazione, String data, String autore)throws SQLException;
	
	public ArrayList<commentBean> getCommentsbyPubblication(int codicePubblicazione)throws SQLException;
}
