package model;

import java.sql.SQLException;

public interface NewsDao {
    
    public void insertNews(NewsBean n) throws SQLException;
	
	public void removeNews(int id)throws SQLException;
	
	public BugBean getNews(int id)throws SQLException;
}
