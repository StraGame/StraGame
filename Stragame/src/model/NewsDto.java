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
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NewsDto implements NewsDao{

      
    @Override
	public void insertNews(NewsBean n)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

		String insertSQL = "INSERT INTO " + "news"
				+ " (autore,data,titolo,testo,immagine) VALUES (? , ? , ? , ? , ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, n.getAutore());
			preparedStatement.setString(2, sdf.format(oggi));
			preparedStatement.setString(3, n.getTitolo());
			preparedStatement.setString(4, n.getTesto());
			try {
				preparedStatement.setBinaryStream(5, n.getPhoto().getInputStream(),(int) n.getPhoto().getSize());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
	public void removeNews(int id)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		

		String deleteSQL = "DELETE FROM " + "news" + " WHERE codicenews = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
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
	public NewsBean getNews(int codiceNews)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		NewsBean bean = new NewsBean();

		String selectSQL = "SELECT * FROM " + "news" + " WHERE codicenews = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, codiceNews);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				
				bean.setAutore(rs.getString("autore"));
				bean.setData(rs.getString("data"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setTesto(rs.getString("testo"));
		
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
	public ArrayList<NewsBean> getAllNews() throws SQLException {
		
		Connection conn=null;
		PreparedStatement statement=null;
		
		ArrayList<NewsBean> l=null;
		
		String selectSQL = "SELECT * FROM " + "news ORDER BY data DESC";
		
		try {
			
			conn=DriverManagerConnectionPool.getConnection();
			
			statement=conn.prepareStatement(selectSQL);
			
			
			ResultSet rs=statement.executeQuery();
			
			l=new ArrayList<NewsBean>();
			
			while(rs.next()) {
				
				NewsBean b = new NewsBean();

				b.setCodiceNews(rs.getInt("codicenews"));
                b.setAutore(rs.getString("autore"));
                b.setData(rs.getString("data"));
                b.setTitolo(rs.getString("titolo"));
                b.setTesto(rs.getString("testo"));

				l.add(b);
				
			}
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } finally {
                if (conn != null)
                    conn.close();
            }
        }
    return l;
    }
	
	public void updatePhoto(int id, String photo)throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String imgSQL = "Update news set immagine =? where codicenews =?";
		
		File file = new File(photo);
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(imgSQL) ;
			try {		
			FileInputStream fis = new FileInputStream(file);
			preparedStatement.setBinaryStream(1, fis, fis.available());
			preparedStatement.setInt(2,id);
			preparedStatement.executeUpdate();
			} 
			
			catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		} catch (IOException e) {

			e.printStackTrace();
		
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
	
	public byte[] getPhoto(int id) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		byte bt[]=null;
		String imgSQL = "SELECT immagine FROM news"+ " WHERE codicenews =  ?";
			try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(imgSQL);
			preparedStatement.setInt(1,id);
			ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					bt=rs.getBytes("immagine");
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

}
