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


public class ReportPubblicationDto implements ReportPubblicationDao {

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
	public void insertReportPubblication(ReportPubblicationBean rp) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		

		String insertSQL = "INSERT INTO " + "reportpubblication"
                + " (autore,codicepubblicazione,data,categoria,descrizione) VALUES (?, ?, ?, ?, ?)";
        
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, rp.getAutore());
            preparedStatement.setInt(2, rp.getCodicePubblicazione());
            preparedStatement.setString(3, sdf.format(oggi));
            preparedStatement.setString(4, rp.getCategoria());
            preparedStatement.setString(5, rp.getDescrizione());

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
    public void removeReportPubblication(int codicePubblicazione, String autore) throws SQLException{

        Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM " + "reportpubblication" + " WHERE codicepubblicazione = ?" + "AND" + "autore = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, codicePubblicazione);
            preparedStatement.setString(2, autore);

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
    public ReportPubblicationBean getReportPubblication(int codicePubblicazione, String autore) throws SQLException{

        Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ReportPubblicationBean bean = new ReportPubblicationBean();

		String selectSQL = "SELECT * FROM " + "reportpubblication" + " WHERE codicepubblicazione = ?"+ "AND" + "autore = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, codicePubblicazione);
            preparedStatement.setString(2, autore);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
                bean.setAutore(rs.getString("autore"));
                bean.setCodicePubblicazione(rs.getInt("codicepubblication"));
                bean.setData(rs.getString("data"));
                bean.setCategoria(rs.getString("categoria"));
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
}
