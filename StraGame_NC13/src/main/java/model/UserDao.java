package model;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.Part;

public interface UserDao {
  
  public ArrayList<UserBean> retrieveAll()throws SQLException;
  
  public boolean editDescription(String description, String nickname)throws SQLException;
  
  public UserBean retrieveUser(String nickname)throws SQLException;
  
  public byte[] getPhoto(String nickname) throws SQLException;
  
  public void editPassword(String password, String nickname)throws SQLException;
  
  public void insertUser(UserBean user)throws SQLException;
  
  public void removeUser(String nickname)throws SQLException;
  
  public void setSegnalato(String nickname, boolean segnalato) throws SQLException;
  
  public ArrayList<UserBean> retrieveAllReportUser()throws SQLException;

  public void updatePhoto(String username, Part photo) throws SQLException;
  
}
