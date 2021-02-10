package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BugDao {
 
  public void insertBug(BugBean b) throws SQLException;
 
  public void removeBug(int id)throws SQLException;
 
  public BugBean getBug(int id)throws SQLException;
 
  public ArrayList<BugBean> getAllBug() throws SQLException;
 
  public ArrayList<BugBean> getAllBugFilter(String videogioco, String categoria) 
      throws SQLException;
 
}
