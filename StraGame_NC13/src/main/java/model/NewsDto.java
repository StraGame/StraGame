package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NewsDto implements NewsDao {

      
  @Override
    public void insertNews(NewsBean n)throws SQLException {
        
    Connection connection = null;
    PreparedStatement preparedStatement = null;
        
    LocalDateTime oggi = LocalDateTime.now();
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
    //System.out.println(oggi.format(sdf));
    String insertSql = "INSERT INTO " + "news"
            + " (autore,data,titolo,testo,immagine) VALUES (? , ? , ? , ? , ?)";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSql);
            
      preparedStatement.setString(1, n.getAutore());
      preparedStatement.setString(2, oggi.format(sdf));
      preparedStatement.setString(3, n.getTitolo());
      preparedStatement.setString(4, n.getTesto());
      try {
        if (n.getPhoto() != null) {
          preparedStatement.setBinaryStream(5, n.getPhoto().getInputStream(), 
              (int) n.getPhoto().getSize());
        } else {
          preparedStatement.setBinaryStream(5, null, 0);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      preparedStatement.executeUpdate();

    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
          connection.close();
      }
    }    
  }

  @Override
    public void removeNews(int id)throws SQLException {
        
    Connection connection = null;
    PreparedStatement preparedStatement = null;

        

    String deleteSql = "DELETE FROM " + "news" + " WHERE codicenews = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSql);
      preparedStatement.setInt(1, id);

      preparedStatement.executeUpdate();

    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
          connection.close();
      }
    }  
  }
    
  @Override
    public NewsBean getNews(int codiceNews)throws SQLException {
        
    Connection connection = null;
    PreparedStatement preparedStatement = null;
        
    NewsBean bean = new NewsBean();

    String selectSql = "SELECT * FROM " + "news" + " WHERE codicenews = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);
      preparedStatement.setInt(1, codiceNews);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
                
                
        bean.setAutore(rs.getString("autore"));
        bean.setData(rs.getString("data"));
        bean.setTitolo(rs.getString("titolo"));
        bean.setTesto(rs.getString("testo"));
        
      }

    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
          connection.close();
      }
    }
    return bean;
  }

  @Override
    public ArrayList<NewsBean> getAllNews() throws SQLException {
        
    Connection conn = null;
    PreparedStatement statement = null;
        
    ArrayList<NewsBean> l = null;
        
    String selectSql = "SELECT * FROM " + "news ORDER BY data DESC";
        
    try {
            
      conn = DriverManagerConnectionPool.getConnection();
            
      statement = conn.prepareStatement(selectSql);
            
            
      ResultSet rs = statement.executeQuery();
            
      l = new ArrayList<NewsBean>();
            
      while (rs.next()) {
                
        NewsBean b = new NewsBean();

        b.setCodiceNews(rs.getInt("codicenews"));
        b.setAutore(rs.getString("autore"));
        b.setData(rs.getString("data"));
        b.setTitolo(rs.getString("titolo"));
        b.setTesto(rs.getString("testo"));

        l.add(b);
                
      }
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }
      } finally {
          conn.close();
      }
    }
    return l;
  }
    
  public byte[] getPhoto(int id) throws SQLException {
        
    Connection connection = null;
    PreparedStatement preparedStatement = null;
        
    byte bt [] = null;
    String imgSql = "SELECT immagine FROM news" + " WHERE codicenews =  ?";
    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(imgSql);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        bt = rs.getBytes("immagine");
      }    
    } catch (SQLException sqlException) {
      System.out.println(sqlException);
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
          connection.close();
      }
    }
            
    return bt;
  }
}
