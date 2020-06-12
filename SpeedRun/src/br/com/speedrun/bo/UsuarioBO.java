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

	public void getUsuarioDAO() {
		this.usuariosInDataBase = usuarioDAO.buscaUsuarios();
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}