package model;

import java.io.Serializable;

public class NewsBean implements Serializable {
    
    private int codicenews;
	private String autore;
	private String data;
	private String titolo;
    private String testo;
    
    public NewsBean() {
        autore="";
        data="";
        titolo="";
        testo="";
    }

    public int getCodiceNews() {
		return codicenews;
	}


	public void setCodiceNews(int codicenews) {
		this.codicenews = codicenews;
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
}
