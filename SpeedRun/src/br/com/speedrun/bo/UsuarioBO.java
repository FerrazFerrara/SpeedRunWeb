package br.com.speedrun.bo;

import java.util.ArrayList;

import br.com.speedrun.beans.UsuarioBean;
import br.com.speedrun.dao.UsuarioDAO;


public class UsuarioBO {
	public ArrayList<UsuarioBean> usuariosInDataBase = new ArrayList<UsuarioBean>();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public UsuarioBO(){
		this.getUsuarioDAO();
	}

	public void addUsuario(UsuarioBean Usuario) {
		this.usuarioDAO.inserirUsuario(Usuario);
	}

	public ArrayList<UsuarioBean> getUsuarioDAO() {
		this.usuariosInDataBase = usuarioDAO.buscaUsuarios();
		return this.usuariosInDataBase;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public void attProfile(String about, String username, String twitter, String facebook, String instagram) {
		UsuarioBean usuario = ActualUserBO.getActualUser();
		usuario.setTwitter(twitter);
		usuario.setInstagram(instagram);
		usuario.setYoutube(facebook);
		usuario.setPais(about);
		usuario.setLogin(username);
		usuarioDAO.updateUsuario(usuario, usuario.getIdUser());
	}
}
