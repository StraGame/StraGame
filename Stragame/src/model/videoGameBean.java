package model;

import java.io.Serializable;

public class VideoGameBean implements Serializable {
    
    private String nome;
	private String genere;
    private String descrizione;
    
    public VideoGameBean() {
		
		nome="";
		genere="";
		descrizione="";
				
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
    
    
}
