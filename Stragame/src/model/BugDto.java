package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BugDto implements BugDao {
	
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


	@Override
	public void insertBug(BugBean b)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

		String insertSQL = "INSERT INTO " + "bug"
				+ " (autore,videogioco,data,titolo,testo,categoria) VALUES (?, ?, ?, ? , ? , ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, b.getAutore());
			preparedStatement.setString(2, b.getVideogioco());
			preparedStatement.setString(3, sdf.format(oggi));
			preparedStatement.setString(4, b.getTitolo());
			preparedStatement.setString(5, b.getTesto());
			preparedStatement.setString(6, b.getCategoria());

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

	@Override
	public void removeBug(int id)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		

		String deleteSQL = "DELETE FROM " + "bug" + " WHERE codicebug = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

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

	@Override
	public BugBean getBug(int id)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		BugBean bean = new BugBean();

		String selectSQL = "SELECT * FROM " + "bug" + " WHERE codicebug = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
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
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}
	
	public ArrayList<BugBean> getAllBug() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<BugBean> list= new ArrayList<BugBean>();
		
		String selectSQL = "SELECT * FROM " + "bug" + " ORDER BY" + " data DESC";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				BugBean bean=new BugBean();
				
				bean.setCodicebug(rs.getInt("codicebug"));
				bean.setAutore(rs.getString("autore"));
				bean.setVideogioco(rs.getString("videogioco"));
				bean.setData(rs.getString("data"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setTesto(rs.getString("testo"));
				bean.setCategoria(rs.getString("categoria"));
				
				list.add(bean);
				
			}
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
		return list;
	}
	
	public ArrayList<BugBean> getAllBugforVideoGame(String videogioco) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<BugBean> list= new ArrayList<BugBean>();
		
		String selectSQL = "SELECT * FROM " + "bug" + "where videogioco=?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, videogioco);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				BugBean bean=new BugBean();
				
				bean.setCodicebug(rs.getInt("codicebug"));
				bean.setAutore(rs.getString("autore"));
				bean.setVideogioco(rs.getString("videogioco"));
				bean.setData(rs.getString("data"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setTesto(rs.getString("testo"));
				bean.setCategoria(rs.getString("categoria"));
				
				list.add(bean);
				
			}
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
		return list;
	}
}
