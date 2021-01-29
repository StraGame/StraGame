package model;
import java.io.Serializable;

import javax.servlet.http.Part;

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private String nome;
	private String cognome;
	private String ruolo;
	private String password;
	private String email;
	private String descrizione;
	private Boolean segnalato;
	private Part photo;
	
	public UserBean(String nickname, String nome, String cognome, String ruolo, String password, String email, String descrizione, Boolean segnalato) {
		
		this.nickname = nickname;
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.password = password;
		this.email=email;
		this.descrizione=descrizione;
		this.segnalato= segnalato;
	}
	
	public UserBean() {
		
		this.nickname="";
		this.cognome="";
		this.nome="";
		this.ruolo="";
		this.password="";
		this.email="";
		this.descrizione="";
		this.segnalato=false;
		
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getSegnalato() {
		return segnalato;
	}

	public void setSegnalato(Boolean segnalato) {
		this.segnalato = segnalato;
	}

	public Part getPhoto() {
		return photo;
	}

	public void setPhoto(Part photo) {
		this.photo = photo;
	}

	
	
	
	
	

	
}
