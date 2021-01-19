package model;

import java.util.Date;

public class PubblicationBean {

	private int codicePubblicazione;
	private String autore;
	private String titolo;
	private String descrizione;
	private int numMiPiace;
	private String videogioco;
	private String data;
	private int gameplay;
	private int trama;
	private int grafica;
	private int voto;
	
	public PubblicationBean() {
		
		codicePubblicazione=1;
		autore="";
		titolo="";
		descrizione="";
		numMiPiace=0;
		videogioco="";
		data= "";
		gameplay=0;
		trama=0;
		grafica=0;
		voto=0;
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

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getNumMiPiace() {
		return numMiPiace;
	}

	public void setNumMiPiace(int numMiPiace) {
		this.numMiPiace = numMiPiace;
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

	public int getGameplay() {
		return gameplay;
	}

	public void setGameplay(int gameplay) {
		this.gameplay = gameplay;
	}

	public int getTrama() {
		return trama;
	}

	public void setTrama(int trama) {
		this.trama = trama;
	}

	public int getGrafica() {
		return grafica;
	}

	public void setGrafica(int grafica) {
		this.grafica = grafica;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	
}
