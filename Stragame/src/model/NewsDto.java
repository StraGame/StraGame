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

public class NewsDto implements NewsDao{

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
	public void insertNews(NewsBean n)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

		String insertSQL = "INSERT INTO " + "news"
				+ " (autore,data,titolo,testo) VALUES (? , ? , ? , ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, n.getAutore());
			preparedStatement.setString(2, sdf.format(oggi));
			preparedStatement.setString(3, n.getTitolo());
			preparedStatement.setString(4, n.getTesto());

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
	public NewsBean getNews(int codiceNews)throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		NewsBean bean = new NewsBean();

		String selectSQL = "SELECT * FROM " + "news" + " WHERE codicenews = ?";

		try {
			connection = ds.getConnection();
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
		
		String selectSQL = "SELECT * FROM " + "news";
		
		try {
			
			conn=ds.getConnection();
			
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

}
