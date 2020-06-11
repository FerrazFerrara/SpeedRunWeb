package br.com.speedrun.beans;

import br.com.speedrun.dao.SpeedRunDAO;

public class SpeedRunBean {
	// ============================== ATRIBUTOS ==============================
	private int idSR = 0;
	private int idUser;
	private String tempo; 
	private String modoJogo; 
	private String plataforma; 
	private String dia;
	
	// ============================== CONSTRUTORES ==============================
	public SpeedRunBean(int idUser, String tempo, String modoJogo, String plataforma, String dia) {
		this.setIdSR(0);
		this.setIdUser(idUser);
		this.setTempo(tempo);
		this.setModoJogo(modoJogo);
		this.setPlataforma(plataforma);
		this.setDia(dia);
	}
	
	public SpeedRunBean(int idSR, int idUser, String tempo, String modoJogo, String plataforma, String dia) {
		this.setIdSR(idSR);
		this.setIdUser(idUser);
		this.setTempo(tempo);
		this.setModoJogo(modoJogo);
		this.setPlataforma(plataforma);
		this.setDia(dia);
	}

	// ============================== GETTERS AND SETTERS ==============================
	public int getIdSR() {
		return idSR;
	}

	public void setIdSR(int idSR) {
		if (idSR == 0) {
			int id = new SpeedRunDAO().buscaSpeedruns().size() + 1;
			this.idSR = id;
		} else {
			this.idSR = idSR;
		}
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getModoJogo() {
		return modoJogo;
	}

	public void setModoJogo(String modoJogo) {
		this.modoJogo = modoJogo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
}
