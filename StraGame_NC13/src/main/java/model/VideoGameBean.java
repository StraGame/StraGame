package model;

import java.io.Serializable;
import javax.servlet.http.Part;

public class VideoGameBean implements Serializable {
  
  private String nome;
  private String genere;
  private String descrizione;
  private Part photo;
  
  /**
   * This inizialize a new VideoGame with nome, genere and descrizione.
   */
  public VideoGameBean() {
    
    nome = "";
    genere = "";
    descrizione = "";
        
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getGenere() {
    return genere;
  }

  public void setGenere(String genere) {
    this.genere = genere;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  public Part getPhoto() {
    return photo;
  }

  public void setPhoto(Part photo) {
    this.photo = photo;
  }
  
}
