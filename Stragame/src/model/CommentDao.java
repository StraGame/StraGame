package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CommentDao {

    public void insertComment(CommentBean c) throws SQLException;
	
	public void removeComment(int codiePubblicazione, String data, String autore)throws SQLException;
	
	public ArrayList<CommentBean> getCommentsbyPubblication(int codicePubblicazione)throws SQLException;
}
