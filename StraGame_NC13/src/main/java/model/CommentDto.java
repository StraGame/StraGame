package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CommentDto implements CommentDao {
    

    
  @Override
    public void insertComment(CommentBean c) throws SQLException {
        
    Connection connection = null;
    PreparedStatement preparedStatement = null;
        
    LocalDateTime oggi = LocalDateTime.now();
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 

    String insertSql = "INSERT INTO " + "comment"
                + " (codicepubblicazione,autore,data,testo) VALUES (?, ?, ?, ?)";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSql);
      preparedStatement.setInt(1, c.getCodicePubblicazione());
      preparedStatement.setString(2, c.getAutore());
      preparedStatement.setString(3, oggi.format(sdf));
      preparedStatement.setString(4, c.getTesto());
                        

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
    public void removeComment(int codiePubblicazione, String data, String autore) 
            throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

        

    String deleteSql = "DELETE FROM " + "comment" 
        + " WHERE codicepubblicazione = ? "
        + "AND" + " data = ? " + "AND" + " autore = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSql);
      preparedStatement.setInt(1, codiePubblicazione);
      preparedStatement.setString(2, data);
      preparedStatement.setString(3, autore);

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
    public ArrayList<CommentBean> getCommentsbyPubblication(int codicePubblicazione) 
            throws SQLException {
        
    Connection conn = null;
    PreparedStatement statement = null;
        
    ArrayList<CommentBean> l = null;
        
    String selectSql = "SELECT * FROM " + "comment" 
        + " WHERE codicePubblicazione = ? ORDER BY data DESC";
        
    try {
            
      conn = DriverManagerConnectionPool.getConnection();
            
      statement = conn.prepareStatement(selectSql);
      statement.setInt(1, codicePubblicazione);
            
      ResultSet rs = statement.executeQuery();
            
      l = new ArrayList<CommentBean>();
            
      while (rs.next()) {
                
        CommentBean c = new CommentBean();
        c.setCodicePubblicazione(rs.getInt(1));
        c.setAutore(rs.getString(2));
        c.setData(rs.getString(3));
        c.setTesto(rs.getString(4));

        l.add(c);
                
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
    
  public void removeAllCommentByPub(int codicePubblicazione) throws SQLException {
    Connection conn = null;
    PreparedStatement statement = null;
        
    String selectSql = "DELETE FROM comment WHERE codicepubblicazione=?";
        
    try {
            
      conn = DriverManagerConnectionPool.getConnection();
            
      statement = conn.prepareStatement(selectSql);
      statement.setInt(1, codicePubblicazione);
            
      statement.executeUpdate();
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }
      } finally {
          conn.close();
      }
    }
  }
    
  public ArrayList<CommentBean> getAllComments()throws SQLException {
    Connection conn = null;
    PreparedStatement statement = null;
        
    ArrayList<CommentBean> l = null;
        
    String selectSql = "SELECT * FROM " + "comment";
        
    try {
            
      conn = DriverManagerConnectionPool.getConnection();
            
      statement = conn.prepareStatement(selectSql);
            
            
      ResultSet rs = statement.executeQuery();
            
      l = new ArrayList<CommentBean>();
            
      while (rs.next()) {
                
        CommentBean c = new CommentBean();
        c.setCodicePubblicazione(rs.getInt(1));
        c.setAutore(rs.getString(2));
        c.setData(rs.getString(3));
        c.setTesto(rs.getString(4));

        l.add(c);
                
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
    
}
