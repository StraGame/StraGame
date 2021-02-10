package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VideoGameDao {
  
  public void insertVideoGame(VideoGameBean vg) throws SQLException;
  
  public void removeVideoGame(String nome)throws SQLException;
  
  public VideoGameBean getVideoGame(String nome)throws SQLException;
  
  public ArrayList<String> getVideoGameNames()throws SQLException;
  
  public  byte[] getPhoto(String nome) throws SQLException;
  
  public ArrayList<VideoGameBean> getAllVideoGame()throws SQLException;

}
