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




public class VideoGameDto implements VideoGameDao {
	
  

    @Override
	public void insertVideoGame(VideoGameBean vg)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + "videogioco"
                + " (nome,genere,descrizione,foto) VALUES (?, ?, ?, ?)";
                
        try {
        	connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            
            preparedStatement.setString(1, vg.getNome());
            preparedStatement.setString(2, vg.getGenere());
            preparedStatement.setString(3, vg.getDescrizione());
            
            try {
				preparedStatement.setBinaryStream(4, vg.getPhoto().getInputStream(),(int) vg.getPhoto().getSize());
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
	public void removeVideoGame(String nome)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM " + "videogioco" + " WHERE nome = ?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, nome);

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
	public VideoGameBean getVideoGame(String nome)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		VideoGameBean bean = new VideoGameBean();

		String selectSQL = "SELECT * FROM " + "videogioco" + " WHERE nome = ?";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setNome(rs.getString("nome"));
				bean.setGenere(rs.getString("genere"));
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
	public ArrayList<String> getVideoGameNames() throws SQLException {
		
		Connection conn=null;
		PreparedStatement statement=null;
		
		ArrayList<String> l=null;
		
		String selectSQL = "SELECT * FROM " + "videogioco" ;
		
		try {
			
			conn=DriverManagerConnectionPool.getConnection();
			
			statement=conn.prepareStatement(selectSQL);
			
			
			ResultSet rs=statement.executeQuery();
			
			l=new ArrayList<String>();
			
			while(rs.next()) {
				
				

				l.add(rs.getString("nome"));
				
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
	
	public byte[] getPhoto(String nome) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		byte bt[]=null;
		String imgSQL = "SELECT foto FROM videogioco"+ " WHERE nome =  ?";
			try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(imgSQL);
			preparedStatement.setString(1,nome);
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

	public ArrayList<VideoGameBean> getAllVideoGame()throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<VideoGameBean> array= new ArrayList<VideoGameBean>();

		String selectSQL = "SELECT * FROM " + "videogioco";

		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				VideoGameBean bean = new VideoGameBean();
				bean.setNome(rs.getString("nome"));
				bean.setGenere(rs.getString("genere"));
				bean.setDescrizione(rs.getString("descrizione"));
				
				array.add(bean);
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
		return array;
	}
		
}