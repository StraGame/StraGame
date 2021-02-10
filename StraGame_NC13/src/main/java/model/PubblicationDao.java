package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PubblicationDao {
  
  public void insertPubblication(PubblicationBean p)throws SQLException;
  
  public void removePubblication(int id)throws SQLException;
  
  public PubblicationBean getPubblication(int id)throws SQLException;
  
  public ArrayList<PubblicationBean> getPubsByVideogame(String videogame)throws SQLException;
  
  public ArrayList<PubblicationBean> getAllPubFilter(String videogioco, String tipo) throws SQLException;

  public ArrayList<PubblicationBean> getPubsByTipo(String tipo) throws SQLException;
  
  public ArrayList<PubblicationBean> getAllPubblication() throws SQLException;
  
  public  byte[] getPhoto(int codice) throws SQLException;
  

}
