package br.com.speedrun.bo;

import br.com.speedrun.beans.UsuarioBean;

public class ActualUserBO {
	private static UsuarioBean shared;
	
	private ActualUserBO() {
	}
	
	public static UsuarioBean getActualUser() {
		return shared;
	}
	
	public static void realizarLogin(UsuarioBean user) {
		shared = user;
	}
	
	public static void sairConta() {
		shared = null;
	}
}
