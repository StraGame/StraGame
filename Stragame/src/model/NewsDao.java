package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NewsDao {
    
    public void insertNews(NewsBean n) throws SQLException;
	
	public void removeNews(int codiceNews)throws SQLException;
	
	public NewsBean getNews(int codiceNews)throws SQLException;
	
	public ArrayList<NewsBean> getAllNews()throws SQLException;
}
