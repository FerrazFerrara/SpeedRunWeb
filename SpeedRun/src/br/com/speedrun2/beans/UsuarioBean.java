package br.com.speedrun2.beans;

import br.com.speedrun.dao.UsuarioDAO;

public class UsuarioBean {
	// ============================== ATRIBUTOS ==============================
	private int idUser = 0;
	private String login;
	private String senha;
	private String pais;
	private String twitter;
	private String youtube;
	private String instagram;
	
	// ============================== CONSTRUTORES ==============================
	public UsuarioBean(String login, String senha, String pais, String twitter, String youtube, String instagram) {
		this.setIdUser(0);
		this.setLogin(login);
		this.setSenha(senha);
		this.setPais(pais);
		this.setTwitter(twitter);
		this.setYoutube(youtube);
		this.setInstagram(instagram);
	}
	
	public UsuarioBean(int idUser, String login, String senha, String pais, String twitter, String youtube, String instagram) {
		this.setIdUser(idUser);
		this.setLogin(login);
		this.setSenha(senha);
		this.setPais(pais);
		this.setTwitter(twitter);
		this.setYoutube(youtube);
		this.setInstagram(instagram);
	}
	
	public UsuarioBean(String login, String senha) {		
		this.setLogin(login);
		this.setSenha(senha);		
	}
	
	public UsuarioBean() {
		
	}

	// ============================== GETTERS AND SETTERS ==============================
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		if(idUser == 0) {
			int id = new UsuarioDAO().buscaUsuarios().size() + 1;
			this.idUser = id;
		} else {
			this.idUser = idUser;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
}
