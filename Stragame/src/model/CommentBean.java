package model;

import java.io.Serializable;

public class CommentBean implements Serializable{
    
    private int codicePubblicazione;
	private String autore;
	private String data;
	private String testo;
	

    public CommentBean() {
        codicePubblicazione=-1;
        autore="";
        data="";
        testo="";
        
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

}
