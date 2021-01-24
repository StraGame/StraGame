package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {
	
	public ArrayList<UserBean> retrieveAll()throws SQLException;
	
	public boolean editDescription(String description, String nickname)throws SQLException;
	
	public UserBean retrieveUser(String nickname)throws SQLException;
	
	public void editPhoto(String nickname, String photo)throws SQLException;
	
	public byte[] getPhoto(String nickname) throws SQLException ;
	
	public void editPassword(String password, String nickname)throws SQLException;
	
	public void insertUser(UserBean user)throws SQLException;
	
	public void removeUser(String nickname)throws SQLException;
	
	
	
}
