package br.com.speedrun3.bo;

import java.util.ArrayList;

import br.com.speedrun.dao.UsuarioDAO;
import br.com.speedrun2.beans.UsuarioBean;


public class UsuarioBO {
	/// arraylist de usuarios no banco
	public ArrayList<UsuarioBean> usuariosInDataBase = new ArrayList<UsuarioBean>();
	/// referencia ao banco
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public UsuarioBO(){
		this.getUsuarioDAO();
	}

	/**
	 * inseri um novo usuario ao banco
	 * @param Usuario: usuario a ser inserido
	 */
	public void addUsuario(UsuarioBean Usuario) {
		this.usuarioDAO.inserirUsuario(Usuario);
	}

	/**
	 * buscar todos os usuarios do banco
	 * @return arraylist de todos usuarios no banco
	 */
	public ArrayList<UsuarioBean> getUsuarioDAO() {
		this.usuariosInDataBase = usuarioDAO.buscaUsuarios();
		return this.usuariosInDataBase;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	/**
	 * atualizada os dados do usuario logado atualmente
	 * @param about: sobre o usuario
	 * @param username: o username do usuario
	 * @param twitter: link do twitter
	 * @param facebook: link do facebook
	 * @param instagram: link do instagram
	 */
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
