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
import javax.sql.DataSource;







public class UserDto implements UserDao {

	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/stragame");
			System.out.println(ds.toString());

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	public ArrayList<UserBean> retrieveAll() throws SQLException {


		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<UserBean> users = new ArrayList<UserBean>();

		String selectSQL = "SELECT * FROM " + "user";

		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

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
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return users;
		
	}
	
	public boolean editDescription(String description, String nickname)throws SQLException {
		
		
		Connection connection = null;
		PreparedStatement preparedDescriptionStatement = null;
		
		
		
		String descriptionSQL = "Update user set descrizione =? where nickname =?";
		
		
		try {
			connection = ds.getConnection();
			preparedDescriptionStatement = connection.prepareStatement(descriptionSQL);
			
				
		
			preparedDescriptionStatement.setString(1, description);
			preparedDescriptionStatement.setString(2, nickname);
			preparedDescriptionStatement.executeUpdate();
			connection.commit();
			
		}
			
			
	
			
		 finally {
			try {
				if (preparedDescriptionStatement != null) {
					preparedDescriptionStatement.close();
					return true;
				}
				
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return false;
		
	}
	
	public void editPassword(String password, String nickname)throws SQLException {
		
		
		Connection connection = null;
		PreparedStatement preparedDescriptionStatement = null;
		
		
		
		String descriptionSQL = "Update user set password =? where nickname =?";
		
		
		try {
			connection = ds.getConnection();
			preparedDescriptionStatement = connection.prepareStatement(descriptionSQL);
			
				
		
			preparedDescriptionStatement.setString(1, password);
			preparedDescriptionStatement.setString(2, nickname);
			preparedDescriptionStatement.executeUpdate();
			connection.commit();
			
		}
			
			
	
			
		 finally {
			try {
				if (preparedDescriptionStatement != null) {
					preparedDescriptionStatement.close();
					
				}
				
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
		
	}
	
	

	@Override
	public UserBean retrieveUser(String nickname) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		UserBean bean = new UserBean();

		String selectSQL = "SELECT * FROM " + "user" + " WHERE nickname = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
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
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}

	@Override
	public void editPhoto(String nickname, String photo) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String imgSQL = "Update user set foto =? where nickname =?";
		
		File file = new File(photo);
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(imgSQL) ;
			try {		
			FileInputStream fis = new FileInputStream(file);
			preparedStatement.setBinaryStream(1, fis, fis.available());
			preparedStatement.setString(2, nickname);
			preparedStatement.executeUpdate();
			connection.commit();
			
			} 
			
			catch (FileNotFoundException e) {
			System.out.println(e);
			}
		} catch (IOException e) {
		System.out.println(e);
		
	} 
			
		 finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	
	public synchronized byte[] getPhoto(String nickname) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		byte bt[]=null;
		String imgSQL = "SELECT foto FROM user"+ " WHERE nickname =  ?";
			try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(imgSQL);
			preparedStatement.setString(1,nickname);
			ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					bt=rs.getBytes("foto");
				}	
			} 
			catch (SQLException sqlException) {
				System.out.println(sqlException);
			} 
			
			finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}
			
			return bt;
		}

	@Override
	public void insertUser(UserBean user) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + "user"
				+ " (nickname,ruolo,email,nome,cognome,password,descrizione) VALUES (?, ?, ?, ?, ? , ? , ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getNickname());
			preparedStatement.setString(2, user.getRuolo());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getNome());
			preparedStatement.setString(5, user.getCognome());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getDescrizione());
			
			

			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
	}

	@Override
	public void removeUser(String nickname) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		String deleteSQL = "DELETE FROM " + "user" + " WHERE nickname = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, nickname);

		 preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
	}
	
	


}
