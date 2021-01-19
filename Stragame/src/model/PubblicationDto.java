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


public class PubblicationDto implements PubblicationDao {

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
	public void insertPubblication(PubblicationBean p) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Date oggi = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		

		String insertSQL = "INSERT INTO " + "pubblication"
				+ " (codicepubblicazione,autore,titolo,descrizione,#mipiace,videogioco,data,gameplay,trama,grafica,voto) VALUES (?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? )";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, p.getCodicePubblicazione());
			preparedStatement.setString(2, p.getAutore());
			preparedStatement.setString(3, p.getTitolo());
			preparedStatement.setString(4, p.getDescrizione());
			preparedStatement.setInt(5, p.getNumMiPiace());
			preparedStatement.setString(6, p.getVideogioco());
			preparedStatement.setString(7, sdf.format(oggi));
			preparedStatement.setInt(8, p.getGameplay());
			preparedStatement.setInt(9, p.getTrama());
			preparedStatement.setInt(10, p.getGrafica());
			preparedStatement.setInt(11,p.getVoto());
			
			

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
	public void removePubblication(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		

		String deleteSQL = "DELETE FROM " + "pubblication" + " WHERE codicepubblicazione = ?";

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
	public PubblicationBean getPubblication(int id) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		PubblicationBean bean = new PubblicationBean();

		String selectSQL = "SELECT * FROM " + "pubblication" + " WHERE codicepubblicazione = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setCodicePubblicazione(rs.getInt("codicepubblicazione"));
				bean.setAutore(rs.getString("autore"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setNumMiPiace(rs.getInt("#mipiace"));
				bean.setVideogioco(rs.getString("videogioco"));
				bean.setData(rs.getString("data"));
				bean.setGameplay(rs.getInt("gameplay"));
				bean.setTrama(rs.getInt("trama"));
				bean.setGrafica(rs.getInt("grafica"));
				bean.setVoto(rs.getInt("voto"));
				
				
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
	public ArrayList<PubblicationBean> getPubsByVideogame(String videogame) throws SQLException {
		
		Connection conn=null;
		PreparedStatement statement=null;
		
		ArrayList<PubblicationBean> l=null;
		
		String selectSQL = "SELECT * FROM " + "pubblication" + " WHERE videogioco = ?";
		
		try {
			
			conn=ds.getConnection();
			
			statement=conn.prepareStatement(selectSQL);
			statement.setString(1, videogame);
			
			ResultSet rs=statement.executeQuery();
			
			 l=new ArrayList<PubblicationBean>();
			
			while(rs.next()) {
				
				PubblicationBean p=new PubblicationBean();
				p.setCodicePubblicazione(rs.getInt(1));
				p.setAutore(rs.getString(2));
				p.setTitolo(rs.getString(3));
				p.setDescrizione(rs.getString(4));
				p.setNumMiPiace(rs.getInt(5));
				p.setVideogioco(rs.getString(6));
				p.setData(rs.getString(7));
				p.setGameplay(rs.getInt(9));
				p.setTrama(rs.getInt(10));
				p.setGrafica(rs.getInt(11));
				p.setVoto(rs.getInt(12));
				
				l.add(p);
				
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
