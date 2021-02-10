package model;

import java.util.Date;

public class ReportPubblicationBean {
  
  private int codicePubblicazione;
  private String autore;
  private String categoria;
  private String descrizione;
  private String data;

  public ReportPubblicationBean() {
    codicePubblicazione = -1;
    autore = "";
    categoria = "";
    descrizione = "";
    data = "";
  }

  public int getCodicePubblicazione() {
    return codicePubblicazione;
  }

  public void setCodicePubblicazione(int codicePubblicazione) {
    this.codicePubblicazione = codicePubblicazione;
  }

  public String getAutore() {
    return autore;
  }

  public void setAutore(String autore) {
    this.autore = autore;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  
  
  
}
