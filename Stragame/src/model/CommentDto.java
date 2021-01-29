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

public class CommentDto implements CommentDao{
    

    
    @Override
	public void insertComment(CommentBean c) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		

		String insertSQL = "INSERT INTO " + "comment"
				+ " (codicepubblicazione,autore,data,testo) VALUES (?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, c.getCodicePubblicazione());
            preparedStatement.setString(2, c.getAutore());
            preparedStatement.setString(3, sdf.format(oggi));
			preparedStatement.setString(4, c.getTesto());
						

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
	public void removeComment(int codiePubblicazione, String data, String autore) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		

		String deleteSQL = "DELETE FROM " + "comment" + " WHERE codicepubblicazione = ?" + "AND" + "data = ?" + "AND" + "autore = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, codiePubblicazione);
            preparedStatement.setString(2, data);
            preparedStatement.setString(3, autore);

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
	public ArrayList<CommentBean> getCommentsbyPubblication(int codicePubblicazione) throws SQLException {
		
		Connection conn=null;
		PreparedStatement statement=null;
		
		ArrayList<CommentBean> l=null;
		
		String selectSQL = "SELECT * FROM " + "comment" + " WHERE codicePubblicazione = ? ORDER BY data DESC";
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			statement=conn.prepareStatement(selectSQL);
			statement.setInt(1, codicePubblicazione);
			
			ResultSet rs=statement.executeQuery();
			
			l=new ArrayList<CommentBean>();
			
			while(rs.next()) {
				
				CommentBean c= new CommentBean();
				c.setCodicePubblicazione(rs.getInt(1));
                c.setAutore(rs.getString(2));
                c.setData(rs.getString(3));
                c.setTesto(rs.getString(4));

				l.add(c);
				
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
    
	public void removeAllCommentByPub(int codicePubblicazione)throws SQLException{
		Connection conn=null;
		PreparedStatement statement=null;
		
		String selectSQL = "DELETE FROM comment WHERE codicepubblicazione=?";
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			statement=conn.prepareStatement(selectSQL);
			statement.setInt(1, codicePubblicazione);
			
			statement.executeUpdate();
		}finally {
			try {
				if (statement != null)
					statement.close();
			} finally {
				if (conn != null)
					conn.close();
			}
		}
	}
	
	public ArrayList<CommentBean> getAllComments()throws SQLException{
		Connection conn=null;
		PreparedStatement statement=null;
		
		ArrayList<CommentBean> l=null;
		
		String selectSQL = "SELECT * FROM " + "comment";
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			statement=conn.prepareStatement(selectSQL);
			
			
			ResultSet rs=statement.executeQuery();
			
			l=new ArrayList<CommentBean>();
			
			while(rs.next()) {
				
				CommentBean c= new CommentBean();
				c.setCodicePubblicazione(rs.getInt(1));
                c.setAutore(rs.getString(2));
                c.setData(rs.getString(3));
                c.setTesto(rs.getString(4));

				l.add(c);
				
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
