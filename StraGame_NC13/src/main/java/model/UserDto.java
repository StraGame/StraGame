package model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import javax.sql.DataSource;


public class UserDto implements UserDao {

  @Override
  public ArrayList<UserBean> retrieveAll() throws SQLException {


    Connection connection = null;
    PreparedStatement preparedStatement = null;

    ArrayList<UserBean> users = new ArrayList<UserBean>();

    String selectSql = "SELECT * FROM " + "user";

  

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        UserBean user = new UserBean();
    
        user.setNome(rs.getString("nome"));
        user.setCognome(rs.getString("cognome"));
        user.setRuolo(rs.getString("ruolo"));
        user.setPassword(rs.getString("password"));
        user.setNickname(rs.getString("nickname"));
        user.setEmail(rs.getString("email"));
        user.setDescrizione(rs.getString("descrizione"));
        users.add(user);
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
    return users;
  }
  
  @Override
  public boolean editDescription(String description, String nickname)throws SQLException {
  
  
    Connection connection = null;
    PreparedStatement preparedDescriptionStatement = null;
  
  
  
    String descriprionSql = "UPDATE user SET descrizione =? where nickname =?";
  
  
    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedDescriptionStatement = connection.prepareStatement(descriprionSql);

      preparedDescriptionStatement.setString(1, description);
      preparedDescriptionStatement.setString(2, nickname);
      preparedDescriptionStatement.executeUpdate();
    
    } finally {
      try {
        if (preparedDescriptionStatement != null) {
          preparedDescriptionStatement.close();
          return true;
        }
    
      } finally {
        connection.close();
      }
    }
    return false;
  }
  
  @Override
  public void editPassword(String password, String nickname)throws SQLException {
  
  
    Connection connection = null;
    PreparedStatement preparedDescriptionStatement = null;
  
  
  
    String descriprionSql = "UPDATE user SET password =? where nickname =?";
  
  
    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedDescriptionStatement = connection.prepareStatement(descriprionSql);
    
      preparedDescriptionStatement.setString(1, password);
      preparedDescriptionStatement.setString(2, nickname);
      preparedDescriptionStatement.executeUpdate();
    
    } finally {
      try {
        if (preparedDescriptionStatement != null) {
          preparedDescriptionStatement.close();   
        }
    
      } finally {
        connection.close();
      }
    }
  }
  
  

  @Override
  public UserBean retrieveUser(String nickname) throws SQLException {
  
    Connection connection = null;
    PreparedStatement preparedStatement = null;
  
    UserBean bean = new UserBean();

    String selectSql = "SELECT * FROM " + "user" + " WHERE nickname = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);
      preparedStatement.setString(1, nickname);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
    
        bean.setNickname(rs.getString("nickname"));
        bean.setNome(rs.getString("nome"));
        bean.setCognome(rs.getString("cognome"));
        bean.setRuolo(rs.getString("ruolo"));
        bean.setEmail(rs.getString("email"));
        bean.setPassword(rs.getString("password"));
        bean.setDescrizione(rs.getString("descrizione"));
        bean.setSegnalato(rs.getBoolean("segnalato"));
    
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
  public synchronized byte[] getPhoto(String nickname) throws SQLException {
  
    Connection connection = null;
    PreparedStatement preparedStatement = null;
  
    byte [] bt = null;
    String imgSql = "SELECT foto FROM user" + " WHERE nickname =  ?";
    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(imgSql);
      preparedStatement.setString(1, nickname);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        bt = rs.getBytes("foto");
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

  @Override
  public void insertUser(UserBean user) throws SQLException {
  
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String insertSql = "INSERT INTO " + "user"
        + " (nickname,ruolo,email,nome,cognome,password,descrizione,segnalato) "
        + "VALUES (?, ?, ?, ?, ? , ? , ?,?)";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertSql);
      preparedStatement.setString(1, user.getNickname());
      preparedStatement.setString(2, user.getRuolo());
      preparedStatement.setString(3, user.getEmail());
      preparedStatement.setString(4, user.getNome());
      preparedStatement.setString(5, user.getCognome());
      preparedStatement.setString(6, user.getPassword());
      preparedStatement.setString(7, user.getDescrizione());
      preparedStatement.setBoolean(8, user.getSegnalato());
    
    

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

  @Override
  public void removeUser(String nickname) throws SQLException {
  
    Connection connection = null;
    PreparedStatement preparedStatement = null;

  
    String deleteSql = "DELETE FROM " + "user" + " WHERE nickname = ?";

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(deleteSql);
      preparedStatement.setString(1, nickname);

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
  public void setSegnalato(String nickname, boolean segnalato) throws SQLException {
  
    Connection connection = null;
    PreparedStatement preparedStatement = null;
  
    String updateSql = "UPDATE " + "user " + "SET segnalato=? WHERE nickname = ?";
  
    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(updateSql);
      preparedStatement.setBoolean(1, segnalato);
      preparedStatement.setString(2, nickname);

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
  public ArrayList<UserBean> retrieveAllReportUser()throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    ArrayList<UserBean> users = new ArrayList<UserBean>();

    String selectSql = "SELECT * FROM " + "user" + " WHERE segnalato=1";

  

    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(selectSql);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        UserBean user = new UserBean();
    
        user.setNome(rs.getString("nome"));
        user.setCognome(rs.getString("cognome"));
        user.setRuolo(rs.getString("ruolo"));
        user.setPassword(rs.getString("password"));
        user.setNickname(rs.getString("nickname"));
        user.setEmail(rs.getString("email"));
        user.setDescrizione(rs.getString("descrizione"));
        user.setSegnalato(rs.getBoolean("segnalato"));
        users.add(user);
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
    return users;
  }

  @Override
  public void updatePhoto(String username, Part photo)throws SQLException {
  
    Connection connection = null;
    PreparedStatement preparedStatement = null;
  
    String imgSql = "Update user set foto =? where nickname =?";
  
  
    try {
      connection = DriverManagerConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(imgSql);
      try {
        if (photo != null) {
          preparedStatement.setBinaryStream(1, photo.getInputStream(), (int) photo.getSize());
        } else {
          preparedStatement.setBinaryStream(1, null, 0);
        }
        preparedStatement.setString(2, username);
        preparedStatement.executeUpdate();
    
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
  
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
