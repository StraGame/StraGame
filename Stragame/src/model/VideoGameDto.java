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

public class VideoGameDto implements VideoGameDao {
	
    private static DataSource ds;
    
    static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/stragame");
			System.out.println(ds.toString());

            } 
        catch (NamingException e) {
		    System.out.println("Error:" + e.getMessage());
        }
    }

    @Override
	public void insertVideoGame(VideoGameBean vg)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + "videogame"
                + " (nome,genere,descrizione) VALUES (?, ?, ?)";
                
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            
            preparedStatement.setString(1, vg.getNome());
            preparedStatement.setString(2, vg.getGenere());
            preparedStatement.setString(3, vg.getDescrizione());

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
	public void removeVideoGame(String nome)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM " + "videogame" + " WHERE nome = ?";

		try {
			connection = ds.getConnection();
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

		String selectSQL = "SELECT * FROM " + "videogame" + " WHERE nome = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setNome(rs.getString("nome"));
				bean.setGenere(rs.getString("genere"));
				bean.setDescrizione(rs.getString("descizione"));
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
			
			conn=ds.getConnection();
			
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
		
}