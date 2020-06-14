package br.com.speedrun3.bo;

import br.com.speedrun2.beans.UsuarioBean;

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
