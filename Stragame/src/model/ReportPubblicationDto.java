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

    
    @Override
	public void insertReportPubblication(ReportPubblicationBean rp) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		

		String insertSQL = "INSERT INTO " + "pubblicationreport"
                + " (autore,codicepubblicazione,data,categoria,descrizione) VALUES (?, ?, ?, ?, ?)";
        
        try {
            connection = DriverManagerConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, rp.getAutore());
            preparedStatement.setInt(2, rp.getCodicePubblicazione());
            preparedStatement.setString(3, sdf.format(oggi));
            preparedStatement.setString(4, rp.getCategoria());
            preparedStatement.setString(5, rp.getDescrizione());

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
    public void removeReportPubblication(int codicePubblicazione, String autore) throws SQLException{

        Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM " + "pubblicationreport" + " WHERE codicepubblicazione = ? " + "AND" + " autore = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
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

		String selectSQL = "SELECT * FROM " + "pubblicationreport" + " WHERE codicepubblicazione = ?"+ " AND " + "autore = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, codicePubblicazione);
            preparedStatement.setString(2, autore);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
                bean.setAutore(rs.getString("autore"));
                bean.setCodicePubblicazione(rs.getInt("codicepubblicazione"));
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
    
    public ArrayList<ReportPubblicationBean> getAllPubblicationReport() throws SQLException{
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL = "SELECT * FROM " + "pubblicationreport ORDER BY data DESC";
		
		ArrayList<ReportPubblicationBean> l=null;		
		
		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			l=new ArrayList<ReportPubblicationBean>();
			
			while(rs.next()) {
				ReportPubblicationBean report = new ReportPubblicationBean();
				
				report.setAutore(rs.getString(1));
				report.setCodicePubblicazione(rs.getInt(2));
				report.setData(rs.getString(3));
				report.setCategoria(rs.getString(4));
				report.setDescrizione(rs.getString(5));
				
				l.add(report);
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
			return l;
	}
    
    @Override
    public void removeAllReportByPub(int codicePubblicazione) throws SQLException{

        Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM " + "pubblicationreport" + " WHERE codicepubblicazione = ? ";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, codicePubblicazione);

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

