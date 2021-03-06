package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class BugDto implements BugDao {



  @Override
public void insertBug(BugBean b)throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    LocalDateTime oggi = LocalDateTime.now();
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 

    String insertSql = "INSERT INTO " + "bug"
        + " (autore,videogioco,data,titolo,testo,categoria) VALUES (?, ?, ?, ? , ? , ?)";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSql);

      preparedStatement.setString(1, b.getAutore());
      preparedStatement.setString(2, b.getVideogioco());
      preparedStatement.setString(3, oggi.format(sdf));
      preparedStatement.setString(4, b.getTitolo());
      preparedStatement.setString(5, b.getTesto());
      preparedStatement.setString(6, b.getCategoria());

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
public void removeBug(int id)throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;



    String deleteSql = "DELETE FROM " + "bug" + " WHERE codicebug = ?";

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
public BugBean getBug(int id)throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    BugBean bean = new BugBean();

    String selectSql = "SELECT * FROM " + "bug" + " WHERE codicebug = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);
      preparedStatement.setInt(1, id);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {

        bean.setCodicebug(rs.getInt("codicebug"));
        bean.setAutore(rs.getString("autore"));
        bean.setVideogioco(rs.getString("videogioco"));
        bean.setData(rs.getString("data"));
        bean.setTitolo(rs.getString("titolo"));
        bean.setTesto(rs.getString("testo"));
        bean.setCategoria(rs.getString("categoria"));



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
  public ArrayList<BugBean> getAllBug() throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    ArrayList<BugBean> list = new ArrayList<BugBean>();

    String selectSql = "SELECT * FROM " + "bug" + " ORDER BY" + " data DESC";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {

        BugBean bean = new BugBean();

        bean.setCodicebug(rs.getInt("codicebug"));
        bean.setAutore(rs.getString("autore"));
        bean.setVideogioco(rs.getString("videogioco"));
        bean.setData(rs.getString("data"));
        bean.setTitolo(rs.getString("titolo"));
        bean.setTesto(rs.getString("testo"));
        bean.setCategoria(rs.getString("categoria"));

        list.add(bean);

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
    return list;
  }

  @Override
public ArrayList<BugBean> getAllBugFilter(String videogioco, String categoria) throws SQLException {

    if (videogioco == null && categoria == null) {
      return this.getAllBug();
    } else           if (!"".equals(videogioco) && categoria.equals("")) {
      Connection connection = null;
      PreparedStatement preparedStatement = null;

      ArrayList<BugBean> list = new ArrayList<BugBean>();

      String selectSql = "SELECT * FROM " + "bug" + " WHERE videogioco=?" + " ORDER BY data DESC";

      try {
        connection = DriverManagerConnectionPool.getConnection();
        preparedStatement = connection.prepareStatement(selectSql);
        preparedStatement.setString(1, videogioco);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

          BugBean bean = new BugBean();

          bean.setCodicebug(rs.getInt("codicebug"));
          bean.setAutore(rs.getString("autore"));
          bean.setVideogioco(rs.getString("videogioco"));
          bean.setData(rs.getString("data"));
          bean.setTitolo(rs.getString("titolo"));
          bean.setTesto(rs.getString("testo"));
          bean.setCategoria(rs.getString("categoria"));

          list.add(bean);

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
      return list;
    } else if (videogioco.equals("") && !"".equals(categoria)) {
      Connection connection = null;
      PreparedStatement preparedStatement = null;

      ArrayList<BugBean> list = new ArrayList<BugBean>();

      String selectSql = "SELECT * FROM " + "bug" + " where categoria=? ORDER BY data DESC";

      try {
        connection = DriverManagerConnectionPool.getConnection();
        preparedStatement = connection.prepareStatement(selectSql);
        preparedStatement.setString(1, categoria);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

          BugBean bean = new BugBean();

          bean.setCodicebug(rs.getInt("codicebug"));
          bean.setAutore(rs.getString("autore"));
          bean.setVideogioco(rs.getString("videogioco"));
          bean.setData(rs.getString("data"));
          bean.setTitolo(rs.getString("titolo"));
          bean.setTesto(rs.getString("testo"));
          bean.setCategoria(rs.getString("categoria"));

          list.add(bean);

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
      return list;
    } else if (videogioco.equals("") && categoria.equals("")) {
      return this.getAllBug();
    } else {
      Connection connection = null;
      PreparedStatement preparedStatement = null;

      ArrayList<BugBean> list = new ArrayList<BugBean>();

      String selectSql = "SELECT * FROM " + "bug" 
          + " where categoria=? and videogioco=? ORDER BY data DESC";

      try {
        connection = DriverManagerConnectionPool.getConnection();
        preparedStatement = connection.prepareStatement(selectSql);
        preparedStatement.setString(1, categoria);
        preparedStatement.setString(2, videogioco);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

          BugBean bean = new BugBean();

          bean.setCodicebug(rs.getInt("codicebug"));
          bean.setAutore(rs.getString("autore"));
          bean.setVideogioco(rs.getString("videogioco"));
          bean.setData(rs.getString("data"));
          bean.setTitolo(rs.getString("titolo"));
          bean.setTesto(rs.getString("testo"));
          bean.setCategoria(rs.getString("categoria"));

          list.add(bean);

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
      return list;
    }
  }


}
