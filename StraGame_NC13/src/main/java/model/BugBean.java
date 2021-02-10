package model;

import java.io.Serializable;

public class BugBean implements Serializable {
  
  private int codicebug;
  private String autore;
  private String videogioco;
  private String data;
  private String titolo;
  private String testo;
  private String categoria;
  
  
  public BugBean() { 
    
    autore = "";
    videogioco = "";
    data = "";
    titolo = "";
    testo = "";
    categoria = "";
    
  }
  
  
  public int getCodicebug() {
    return codicebug;
  }


  public void setCodicebug(int codicebug) {
    this.codicebug = codicebug;
  }


  public String getAutore() {
    return autore;
  }

  public void setAutore(String autore) {
    this.autore = autore;
  }

  public String getVideogioco() {
    return videogioco;
  }

  public void setVideogioco(String videogioco) {
    this.videogioco = videogioco;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getTitolo() {
    return titolo;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public String getTesto() {
    return testo;
  }

  public void setTesto(String testo) {
    this.testo = testo;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
  
  

}
