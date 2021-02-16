package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class PubblicationDto implements PubblicationDao {

  private static DataSource ds;

  @Override
  public void insertPubblication(PubblicationBean p) throws SQLException {
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
      
    LocalDateTime oggi = LocalDateTime.now();
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
    
    if (p.getTipo().equals("topic")) {
      
      String insertSql = "INSERT INTO pubblication(autore,titolo,descrizione,"
          + "videogioco,data,tipo,immagine) VALUES (?,?,?,?,?,?,?)";
      
      
      try {
        
        connection = DriverManagerConnectionPool.getConnection();
        
        preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, p.getAutore());
        preparedStatement.setString(2, p.getTitolo());
        preparedStatement.setString(3, p.getDescrizione());
        preparedStatement.setString(4, p.getVideogioco());
        preparedStatement.setString(5, oggi.format(sdf));
        preparedStatement.setString(6, p.getTipo());
        try {
          if (p.getPhoto() != null) {
            preparedStatement.setBinaryStream(7, p.getPhoto().getInputStream(),
                (int) p.getPhoto().getSize());
          } else {
            preparedStatement.setBinaryStream(7, null, 0);
          }
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
        preparedStatement.executeUpdate();

        //connection.commit();
      } finally {
        try {
          if (preparedStatement != null) {
            preparedStatement.close();
          }
        } finally {
          connection.close();
        }
      }
    } else {
      String insertSql = "INSERT INTO pubblication(autore,titolo,descrizione,"
          + "videogioco,data,tipo,immagine,trama,gameplay,grafica,votocomplessivo)"
          + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      
      
      try {
        
        connection = DriverManagerConnectionPool.getConnection();
        
        preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, p.getAutore());
        preparedStatement.setString(2, p.getTitolo());
        preparedStatement.setString(3, p.getDescrizione());
        
        preparedStatement.setString(4, p.getVideogioco());
        preparedStatement.setString(5, sdf.format(oggi));
        preparedStatement.setString(6, p.getTipo());
        try {
          if (p.getPhoto() != null) {
            preparedStatement.setBinaryStream(7, p.getPhoto().getInputStream(),
                (int) p.getPhoto().getSize());
          } else {
            preparedStatement.setBinaryStream(7, null, 0);
          }
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        preparedStatement.setInt(8, p.getTrama());
        preparedStatement.setInt(9, p.getGameplay());
        preparedStatement.setInt(10, p.getGrafica());
        preparedStatement.setInt(11, p.getVoto());
      
        preparedStatement.executeUpdate();

        //connection.commit();
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
  }
  
  @Override
  public ArrayList<PubblicationBean> getPubsByTipo(String tipo) throws SQLException {
    Connection conn = null;
    PreparedStatement statement = null;
      
    ArrayList<PubblicationBean> l = null;
      
    String selectSql = "SELECT * FROM " + "pubblication" + " WHERE tipo = ? ORDER BY data DESC";
      
    try {
      conn = DriverManagerConnectionPool.getConnection();
      statement = conn.prepareStatement(selectSql);
      statement.setString(1, tipo);
        
      ResultSet rs = statement.executeQuery();
        
      l = new ArrayList<PubblicationBean>();
        
      while (rs.next()) {
        PubblicationBean p = new PubblicationBean();
        p.setCodicePubblicazione(rs.getInt("codicepubblicazione"));
        p.setAutore(rs.getString("autore"));
        p.setTitolo(rs.getString("titolo"));
        p.setDescrizione(rs.getString("descrizione"));
        p.setVideogioco(rs.getString("videogioco"));
        p.setData(rs.getString("data"));
        p.setGameplay(rs.getInt("gameplay"));
        p.setTrama(rs.getInt("trama"));
        p.setGrafica(rs.getInt("grafica"));
        p.setVoto(rs.getInt("votocomplessivo"));

        l.add(p);
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
    
  @Override
  public void removePubblication(int id) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    

    String deleteSql = "DELETE FROM " + "pubblication" + " WHERE codicepubblicazione = ?";

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
  public PubblicationBean getPubblication(int id) throws SQLException {
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    PubblicationBean bean = new PubblicationBean();

    String selectSql = "SELECT * FROM " + "pubblication" + " WHERE codicepubblicazione = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);
      preparedStatement.setInt(1, id);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        
        bean.setCodicePubblicazione(rs.getInt("codicepubblicazione"));
        bean.setAutore(rs.getString("autore"));
        bean.setTitolo(rs.getString("titolo"));
        bean.setDescrizione(rs.getString("descrizione"));
        bean.setVideogioco(rs.getString("videogioco"));
        bean.setData(rs.getString("data"));
        bean.setGameplay(rs.getInt("gameplay"));
        bean.setTrama(rs.getInt("trama"));
        bean.setGrafica(rs.getInt("grafica"));
        bean.setVoto(rs.getInt("votocomplessivo"));
        bean.setTipo(rs.getString("Tipo"));
        
        
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
  public ArrayList<PubblicationBean> getPubsByVideogame(String videogame) throws SQLException {
    
    Connection conn = null;
    PreparedStatement statement = null;
    
    ArrayList<PubblicationBean> l = null;
    
    String selectSql = "SELECT * FROM " + "pubblication" 
        + " WHERE videogioco = ? ORDER BY data DESC";
    
    try {
      
      conn = DriverManagerConnectionPool.getConnection();
      
      statement = conn.prepareStatement(selectSql);
      statement.setString(1, videogame);
      
      ResultSet rs = statement.executeQuery();
      
      l = new ArrayList<PubblicationBean>();
      
      while (rs.next()) {
        
        PubblicationBean p = new PubblicationBean();
        p.setCodicePubblicazione(rs.getInt("codicepubblicazione"));
        p.setAutore(rs.getString("autore"));
        p.setTitolo(rs.getString("titolo"));
        p.setDescrizione(rs.getString("descrizione"));
        p.setVideogioco(rs.getString("videogioco"));
        p.setData(rs.getString("data"));
        p.setGameplay(rs.getInt("gameplay"));
        p.setTrama(rs.getInt("trama"));
        p.setGrafica(rs.getInt("grafica"));
        p.setVoto(rs.getInt("votocomplessivo"));
        p.setTipo(rs.getString("tipo"));
        
        l.add(p);
        
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
  
  @Override
  public ArrayList<PubblicationBean> getAllPubFilter(
      String videogioco, String tipo) throws SQLException {
    
    if (videogioco == null) {
      return this.getPubsByTipo(tipo);
    } else if (!"".equals(videogioco)) {
      Connection connection = null;
      PreparedStatement preparedStatement = null;
      
      ArrayList<PubblicationBean> l = new ArrayList<PubblicationBean>();
      
      String selectSql = "SELECT * FROM " + "pubblication" + " WHERE videogioco = ? "
          + "AND tipo=? ORDER BY data DESC";
      
      try {
        connection = DriverManagerConnectionPool.getConnection();
        preparedStatement = connection.prepareStatement(selectSql);
        preparedStatement.setString(1, videogioco);
        preparedStatement.setString(2, tipo);
        
        ResultSet rs = preparedStatement.executeQuery();
        
        while (rs.next()) {
          
          PubblicationBean p = new PubblicationBean();
          p.setCodicePubblicazione(rs.getInt("codicepubblicazione"));
          p.setAutore(rs.getString("autore"));
          p.setTitolo(rs.getString("titolo"));
          p.setDescrizione(rs.getString("descrizione"));
          p.setVideogioco(rs.getString("videogioco"));
          p.setData(rs.getString("data"));
          p.setGameplay(rs.getInt("gameplay"));
          p.setTrama(rs.getInt("trama"));
          p.setGrafica(rs.getInt("grafica"));
          p.setVoto(rs.getInt("votocomplessivo"));
          p.setTipo(rs.getString("tipo"));
          
          l.add(p);
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
      return l;
    } else {
      return this.getPubsByTipo(tipo);
    }
  }
  
  @Override
  public ArrayList<PubblicationBean> getAllPubblication() throws SQLException {
    Connection conn = null;
    PreparedStatement statement = null;
    
    ArrayList<PubblicationBean> l = null;
    
    String selectSql = "SELECT * FROM " + "pubblication" + " ORDER BY data DESC";
    
    try {
      conn = DriverManagerConnectionPool.getConnection();
      statement = conn.prepareStatement(selectSql);
      
      ResultSet rs = statement.executeQuery();
      
      l = new ArrayList<PubblicationBean>();
      
      while (rs.next()) {
        PubblicationBean p = new PubblicationBean();
        p.setCodicePubblicazione(rs.getInt("codicepubblicazione"));
        p.setAutore(rs.getString("autore"));
        p.setTitolo(rs.getString("titolo"));
        p.setDescrizione(rs.getString("descrizione"));
        p.setVideogioco(rs.getString("videogioco"));
        p.setData(rs.getString("data"));
        p.setGameplay(rs.getInt("gameplay"));
        p.setTrama(rs.getInt("trama"));
        p.setGrafica(rs.getInt("grafica"));
        p.setVoto(rs.getInt("votocomplessivo"));
        p.setTipo(rs.getString("tipo"));

        l.add(p);
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
  
  @Override
  public byte[] getPhoto(int codice) throws SQLException {
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
      
    byte [] bt = null;
    String imgSql = "SELECT immagine FROM pubblication" + " WHERE codicepubblicazione =  ?";
    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(imgSql);
      preparedStatement.setInt(1, codice);
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
