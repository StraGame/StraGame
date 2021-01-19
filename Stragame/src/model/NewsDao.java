package model;

import java.sql.SQLException;

public interface NewsDao {
    
    public void insertNews(NewsBean n) throws SQLException;
	
	public void removeNews(int codiceNews)throws SQLException;
	
	public NewsBean getNews(int codiceNews)throws SQLException;
}
