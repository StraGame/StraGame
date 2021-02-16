package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ReportPubblicationDto implements ReportPubblicationDao {

  
  @Override
  public void insertReportPubblication(ReportPubblicationBean rp) throws SQLException {
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    LocalDateTime oggi = LocalDateTime.now();
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 

    String insertSql = "INSERT INTO " + "pubblicationreport"
        + " (autore,codicepubblicazione,data,categoria,descrizione) VALUES (?, ?, ?, ?, ?)";
    
    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSql);
      preparedStatement.setString(1, rp.getAutore());
      preparedStatement.setInt(2, rp.getCodicePubblicazione());
      preparedStatement.setString(3, oggi.format(sdf));
      preparedStatement.setString(4, rp.getCategoria());
      preparedStatement.setString(5, rp.getDescrizione());

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
  public void removeReportPubblication(int codicePubblicazione, String autore) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String deleteSql = "DELETE FROM " + "pubblicationreport" 
        + " WHERE codicepubblicazione = ? " + "AND" + " autore = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSql);
      preparedStatement.setInt(1, codicePubblicazione);
      preparedStatement.setString(2, autore);

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
  public ReportPubblicationBean getReportPubblication(
      int codicePubblicazione, String autore) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    ReportPubblicationBean bean = new ReportPubblicationBean();

    String selectSql = "SELECT * FROM " + "pubblicationreport" 
        + " WHERE codicepubblicazione = ?" + " AND " + "autore = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);
      preparedStatement.setInt(1, codicePubblicazione);
      preparedStatement.setString(2, autore);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        
        bean.setAutore(rs.getString("autore"));
        bean.setCodicePubblicazione(rs.getInt("codicepubblicazione"));
        bean.setData(rs.getString("data"));
        bean.setCategoria(rs.getString("categoria"));
        bean.setDescrizione(rs.getString("descrizione"));      
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
  public ArrayList<ReportPubblicationBean> getAllPubblicationReport() throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    String selectSql = "SELECT * FROM " + "pubblicationreport ORDER BY data DESC";
    
    ArrayList<ReportPubblicationBean> l = null;    
    
    try {
      
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);
      
      ResultSet rs = preparedStatement.executeQuery();
      
      l = new ArrayList<ReportPubblicationBean>();
      
      while (rs.next()) {
        ReportPubblicationBean report = new ReportPubblicationBean();
        
        report.setAutore(rs.getString(1));
        report.setCodicePubblicazione(rs.getInt(2));
        report.setData(rs.getString(3));
        report.setCategoria(rs.getString(4));
        report.setDescrizione(rs.getString(5));
        
        l.add(report);
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
  }
  
  @Override
  public void removeAllReportByPub(int codicePubblicazione) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String deleteSql = "DELETE FROM " + "pubblicationreport" + " WHERE codicepubblicazione = ? ";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSql);
      preparedStatement.setInt(1, codicePubblicazione);

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
    
}

